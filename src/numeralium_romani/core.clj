(ns numeralium-romani.core
  (:require [clojure.set :as set]
            [clojure.string :as string]))

(def arabic-to-roman {1 "I" 4 "IV" 5 "V" 9 "IX" 10 "X" 50 "L" 90 "XC" 100 "C" 400 "CD" 500 "D" 900 "CM" 1000 "M"})
(def roman-to-arabic (sort #(compare (count %1) (count %2)) (set/map-invert arabic-to-roman)))

(defn as-roman [n]
  (loop [n n roman ""]
    (if (zero? n)
      roman
      (let [max-digit (last (sort (filter #(>= n (key %)) arabic-to-roman)))]
        (recur (- n (key max-digit)) (str roman (val max-digit)))))))

(defn as-arabic [n]
  (loop [n (string/split n #"") arabic 0]
    (if (empty? n)
      arabic
      (recur (drop 1 n) (+ arabic (roman-to-arabic (first n)))))))


(defn as-arabic [n]
  (let []))