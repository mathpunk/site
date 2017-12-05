(ns site.server
  (:require [stasis.core :as stasis]
            [site.build :as build]
            [optimus.prime :as optimus]
            [optimus.strategies :refer [serve-live-assets]]
            [optimus.optimizations :as optimizations]
            [site.build :as build]))

(def app
  (optimus/wrap
   (stasis/serve-pages build/get-pages)
   build/get-assets
   optimizations/all
   serve-live-assets))
