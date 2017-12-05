(ns site.build
  (:require [stasis.core :as stasis]
            [optimus.assets :as assets]
            [site.layout :refer [layout-page]]
            [me.raynes.cegdown :as md]
            [clojure.string :as str]))

(defn get-assets []
  (assets/load-assets "public" [#".*"]))

#_(defn pages-from-html-partials [sources]
    (zipmap (keys sources)
            (map #(fn [req] (layout-page req %)) (vals sources))))

(defn pages-from-markdown [sources]
  (zipmap (map #(str/replace % #"\.md$" "/") (keys sources))
          (map #(fn [req] (layout-page req (md/to-html %))) (vals sources))))

(defn pages-from-markdown-with-landing [sources]
  (let [pages (pages-from-markdown sources)
        landing (get pages "/about/")]
    (assoc pages "/" landing)))

(defn prepare-page [page req]
  "Every page goes through this function --- some are strings, some are functions."
  (-> (if (string? page) page (page req))
      identity)) ;; would be, highlight-code-blocks e.g.

(defn prepare-pages [pages]
  (zipmap (keys pages)
          (map #(partial prepare-page %) (vals pages))))

(defn get-raw-pages []
  (stasis/merge-page-sources
   {:public (stasis/slurp-directory "resources/public" #".*\.(html|css|js)")
    #_:partials #_(pages-from-html-partials (stasis/slurp-directory "resources/partials" #".*\.html$"))
    :markdown (pages-from-markdown-with-landing (stasis/slurp-directory "resources/md" #"\.md$"))}))

(defn get-pages []
  (prepare-pages (get-raw-pages)))
