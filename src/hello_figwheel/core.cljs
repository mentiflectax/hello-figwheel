(ns hello-figwheel.core
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]

   ))

(enable-console-print!)

(println "This text is printed from src/hello-figwheel/core.cljs. Go ahead and edit it and see reloading in action.")

(println "And now?")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(defn get-app-element []
  (gdom/getElement "app"))

(defn hello-world []
  [:div
   [:h1 (:text @app-state)]
   [:h3 "Edit this text bla-bla-bla"]
   ])


(defn mount [el]
  (rdom/render [hello-world] el))

(mount-app-element)

(defn ^:after-load on-js-reload []
  (mount-app-element)
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)


