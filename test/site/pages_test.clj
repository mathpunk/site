(ns site.pages-test
  (:require  [site.pages :refer [featured-links]]
             [site.build :refer [get-pages get-raw-pages]]
             [clojure.test :refer [deftest testing is]]))

(deftest featured-pages-are-assigned-links
  (is (= "/about" (get featured-links "about")))
  (is (= "/resume" (get featured-links "resume")))
  (is (= "/code" (get featured-links "code")))
  (is (= "/research" (get featured-links "research")))
  (is (= "/speaking" (get featured-links "speaking")))
  (is (= "http://blog.chiral.computer" (get featured-links "blog")))
  (is (= "/contact" (get featured-links "contact")))
  )
