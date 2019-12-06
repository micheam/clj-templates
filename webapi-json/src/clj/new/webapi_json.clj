(ns clj.new.webapi-json
  (:require [clj.new.templates :refer [renderer project-name name-to-path ->files
                                       multi-segment sanitize-ns]]))

(def render (renderer "webapi-json"))

(defn webapi-json
  "Generate a skelton project of Compojure based rest application."
  [name]
  (let [main-ns (multi-segment (sanitize-ns name))
        data {:name (project-name name)
              :namespace main-ns
              :nested-dirs (name-to-path main-ns)}]
    (println "Generating fresh 'clj new' webapi-json project.")
    (->files data
             ["deps.edn" (render "deps.edn" data)]
             ["src/{{nested-dirs}}/web/core.clj" (render "web/core.clj" data)]
             ["src/{{nested-dirs}}/web/handler.clj" (render "web/handler.clj" data)]
             ["src/{{nested-dirs}}/web/route.clj" (render "web/route.clj" data)]
             ["src/{{nested-dirs}}.clj" (render "core.clj" data)]
             ["resources/logback.xml" (render "resources/logback.xml" data)])))
