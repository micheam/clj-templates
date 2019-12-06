(ns {{namespace}}.web.handler
  (:require
   [clojure.tools.logging :as log]
   [ring.util.http-response :as resp]))

(defn hello [{params :params}]
  (log/debug ::hello params)
  (let [name (get params :name "World")] 
    (resp/ok (str "Hello, " name))))
