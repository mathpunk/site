(ns site.export-test
  (:require  [site.export :refer :all]
             [clojure.java.io :as io]
             [clojure.test :refer [deftest testing is]]))

(defn exported? [path]
  (.exists (io/as-file (str export-dir "/" path))))

(deftest export-dir-exists
  (is (.exists (io/as-file "dist"))))

(deftest clean-empties-export-directory
  (do (clean)
      (is (= (count (file-seq (io/as-file "dist"))) 1))))

(deftest pages-get-exported
  (do
    (clean)
    (export)
    (is (exported? "index.html"))
    (is (exported? "about/index.html"))
    (is (exported? "resume/index.html"))
    (is (exported? "code/index.html"))
    (is (exported? "research/index.html"))
    (is (exported? "speaking/index.html"))
    (is (exported? "contact/index.html"))
    )
  )
