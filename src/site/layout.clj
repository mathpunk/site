(ns site.layout
  (:require [site.style :refer [pilcrow]]
            [site.pages :refer [featured-links]]
            [site.components :refer :all]
            [optimus.link :as link] 
            [hiccup.page :refer [html5]]))

(defn layout-page [request html-partial]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    [:title "chiral.computer"]
    [:link {:rel "stylesheet" :href (link/file-path request "/css/tufte.css")}]
    ]
   [:body
    (navigation featured-links)
    [:div.body html-partial]]))
