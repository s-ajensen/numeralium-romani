(ns numeralium-romani.core
  (:require [clojure.string :as string]))

(defn subtotal-coefficient [first second]
  (if (> second first) -1 1))

(defn as-arabic [n]
  (let [digits {\I 1 \V 5 \X 10}]
    (->> (vec n)
      (map #(digits %))
      (reduce #(+ (* (subtotal-coefficient %1 %2) %1) %2)))))