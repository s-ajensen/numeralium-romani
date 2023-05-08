(ns numeralium-romani.core
  (:require [clojure.string :as string]))

(def digits {"I" 1 "IV" 4 "V" 5 "IX" 9 "X" 10 "XL" 40 "L" 50
             "XC" 90 "C" 100 "CD" 400 "D" 500 "CM" 900 "M" 1000})

(defn digits-less-than [n]
  (->> digits
    (filter #(>= n (val %)))
    (sort #(compare (val %1) (val %2)))))

(defn as-roman [n]
  (loop [n n romans ""]
    (if (zero? n)
      romans
      (let [num-pair (last (digits-less-than n))]
        (recur (- n (val num-pair)) (str romans (key num-pair)))))))

(defn subtotal-coefficient [first second]
  (if (< second first) -1 1))

(defn as-arabic [n]
  (->> (string/split n #"")
    (reverse)
    (map #(digits %))
    (partition-by identity)
    (map #(reduce + %))
    (reduce #(+ (* (subtotal-coefficient %1 %2) %2) %1))))