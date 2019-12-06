(ns {{namespace}}.web.route
  (:require
   [compojure.core :refer :all]
   [compojure.route :refer :all]
   [{{namespace}}.web.handler :as handler]))

(defroutes {{name}}-routes
  (GET "/" _ handler/hello)
  (not-found {}))
