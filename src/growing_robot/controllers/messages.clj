(ns growing-robot.controller.messages
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [growing-robot.views.messages :as view]
            [growing-robot.models.message :as model]))
 
(defn index []
  (view/index (model/all)))
 
(defn create [params]
  (let [message (:message params)]
    (when-not (str/blank? message)
      (model/create message)))
  (ring/redirect "/"))
 
(defroutes routes
  (GET "/" [] (index))
  (POST "/" {params :params} (create params)))

