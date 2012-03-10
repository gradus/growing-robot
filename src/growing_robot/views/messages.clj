(ns growing-robot.views.messages
  (:use [hiccup.core :only [html h]]
        [hiccup.page-helpers :only [doctype]]
        [hiccup.form-helpers :only [form-to label text-area submit-button]])
  (:require [growing-robot.views.layout :as layout]))
 
(defn message-form []
  [:div {:id "message-form" }
   (form-to [:post "/"]
            (label "message" "What do you want to message?")
            [:br]
            (text-area "message")
            [:br]
            (submit-button "message!"))])
 
(defn display-messages [messages]
   [:div {:id "messages"}
    [:ul
     (map
      (fn [message] [:li (:data (:doc message))])
      (:rows messages))]])
 
(defn index [messages]
  (layout/common "Growing Robot"
                 (message-form)
                 [:br]
                 (display-messages messages)))

