(defproject site "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "BSD 2 Clause"
            :url "http://opensource.org/licenses/BSD-2-Clause"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [stasis "2.3.0"]
                 [optimus "0.20.1"]
                 [ring "1.6.3"]
                 [hiccup "1.0.5"]
                 [enlive "1.1.6"]
                 ;; [org.clojure/test.check "0.9.0"]
                 [me.raynes/cegdown "0.1.1"]
                 ]
  :ring {:handler site.server/app}
  :aliases {"build" ["run" "-m" "site.export/export"]} 
  :profiles {:dev {:plugins [[lein-ring "0.12.1"]]}})
