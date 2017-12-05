(ns site.export
  (:require [stasis.core :as stasis]
            [site.build :as build]
            [optimus.optimizations :as optimizations]
            [optimus.export :refer [save-assets]]
            [optimus.strategies :refer [serve-live-assets]]))

(def export-dir "dist")

(defn clean []
  (stasis/empty-directory! export-dir))

(defn export []
  (let [assets (optimizations/all (build/get-assets) {})]
    (clean)
    (save-assets assets export-dir)
    (stasis/export-pages (build/get-pages) export-dir {:optimus-assets assets})))
