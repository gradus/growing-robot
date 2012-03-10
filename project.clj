(defproject growing-robot "0.0.1"
  :description "Chat App with CouchDB"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [com.ashafa/clutch "0.2.4"]
                 [ring/ring-jetty-adapter "0.3.10"]
                 [compojure "0.6.4"]
                 [hiccup "0.3.6"]]
  :uberjar-name "gatekeeper_output_monitor.jar"
  :main growing-robot.core)
