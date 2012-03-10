(ns growing-robot.core
  (:use [compojure.core :only (defroutes)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as ring]
            [growing-robot.controllers.messages]
            [growing-robot.views.layout :as layout]))
 
;;; Define the routes
(defroutes routes
  growing-robot.controller.messages/routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four)))
 
;;; the main application
(def application (handler/site routes))
 
;;; start to start the jetty server on port
(defn start [port]
  (ring/run-jetty (var application) {:port (or port 8080) :join? false}))
 
;;; main
(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (start port)))

