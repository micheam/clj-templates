(ns {{namespace}} .web.core
    (:require [ring.adapter.jetty :as s]
              [ring.middleware.json :refer [wrap-json-response wrap-json-params]]
              [ring.middleware.keyword-params :refer [wrap-keyword-params]]
              [ring.middleware.params :refer [wrap-params]]
              [clojure.tools.logging :as log]
              [{{namespace}} .web.route :refer [{{name}} -routes]]))

(defonce server (atom nil))

(def app
  (-> {{name}} -routes
      wrap-keyword-params
      wrap-json-params
      wrap-json-response
      wrap-params))

(defn start []
  (when-not @server
    (let [port (if-let [p (System/getenv "PORT")]
                 (Integer/parseInt p)
                 8080)]
      (reset! server (s/run-jetty #'app {:port port :join? false}))
      (log/infof "server started on port %d" port))))

(defn stop []
  (when @server
    (.stop @server)
    (reset! server nil)))

(defn restart []
  (when @server
    (stop)
    (start)))
