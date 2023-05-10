(ns numeralium-romani.core
  (:require [clojure.string :as str]))

(def digits { "I" 1 "V" 5 "X" 10 "L" 50 "C" 100 "M" 1000 })

(defn subtotal-coefficient [first second]
  (if (< second first) -1 1))

(defn as-arabic [n]
  (->> (str/split n #"")
    (reverse)
    (map #(digits %))
    (partition-by identity)
    (map #(reduce + %))
    (reduce #(+ (* (subtotal-coefficient %1 %2) %2) %1))))
