(ns site.components
  (:require [site.style :refer [pilcrow]]))

(defn navigation [link-map]
  (let [links (for [[anchor target] link-map]
                [:a {:href target} anchor])
        elements (drop-last (interleave links (repeat pilcrow)))]
    (into [] (concat [:nav] elements))))

#_(def logo [:svg {:src "images/chiral.computer.svg"}])
