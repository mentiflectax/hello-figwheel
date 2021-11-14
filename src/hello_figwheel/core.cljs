(ns hello-figwheel.core
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [sablono.core :as sab :include-macros true]

   ))

(enable-console-print!)

(println "This text is printed from src/hello-figwheel/core.cljs. Go ahead and edit it and see reloading in action.")

(println "And now?")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))




(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)


(defn template []
  [:div
   [:h1 "Counter: "]]
)

(defn render [comp]
  (.renderComponent js/React
                    (sab/html comp) 
                    (.getElementById js/document "main-area")))

(render template)
