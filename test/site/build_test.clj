(ns site.build-test
  (:require [site.build :refer :all]
            [site.pages :refer [featured-links]]
            [clojure.test :refer [deftest testing is]]))

;; Bug I don't follow, hence tests
(defn mock-response [pages uri]
  ((get pages uri) {}))

(deftest markdown-pages-callable
  (let [empty-pages (pages-from-markdown [])]
    (is (= clojure.lang.PersistentArrayMap (type empty-pages)))
    (is (empty? empty-pages))))

(deftest prepared-pages-callable
  (let [empty-pages (prepare-pages [])]
    (is (= clojure.lang.PersistentArrayMap (type empty-pages)))
    (is (empty? empty-pages))))

(deftest featured-pages-have-content
  (let [pages (get-raw-pages)]
    (for [anchor (keys featured-links)]
      (let [content (mock-response pages (str "/" anchor "/"))]
        (is (not (or (nil? content) (empty? content))))))))
