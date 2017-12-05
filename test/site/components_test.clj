(ns site.components-test
  (:require [site.components :refer :all]
            [site.pages :refer [featured-links]]
            [site.style :refer [pilcrow]]
            [clojure.string :as string]
            [clojure.test :refer [deftest testing is]]
            [clojure.java.io :as io]))

(def nav (navigation featured-links))

(def elements (rest nav))

(defn link? [element]
  (= :a (first element)))

(defn anchor-is? [anchor element]
  (= anchor (nth element 2)))

(defn target-is? [target element]
  (= target (:href (second element))))

(deftest navigation-bar-form
  (is (= (first nav) :nav))
  (is (every? link? (take-nth 2 elements)))
  (is (every? #(= pilcrow %) (take-nth 2 (rest elements)))))

(deftest navigation-bar-content
  (let [links (take-nth 2 elements)]
    (for [feature ["about" "resume" "code" "research" "speaking" "blog" "contact"]]
      (is (some #(anchor-is? feature %) links)))
    (for [feature-link ["/about" "/resume" "/code" "/research" "/speaking"
                        "http://blog.chiral.computer" "/contact"]]
      (is (some #(target-is? feature-link %) links)))))

#_(deftest logo-form
    (is (= :svg (first logo))))

#_(deftest logo-content
    (let [image (io/as-file (io/resource "public/images/chiral.computer.svg"))]
      (is (.exists image))
      (is (= "images/chiral.computer.svg" (:src (second logo))))))
