(ns numeralium-romani.core
  (:require [clojure.string :as string])
  (:require [clojure.set :as set]))

(def digits {\I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000})

(defn subtotal-coefficient [first second]
  (if (>= second first) 1 -1))

(defn as-arabic [n]
  (->> (reverse (vec (string/upper-case n)))
    (map #(digits %))
    (partition-by identity)
    (map #(reduce + %))
    (reduce #(+ (* (subtotal-coefficient %1 %2) %2) %1))))

(defn as-roman [n]
  (loop [n n roman ""]
    (if (> 1 n)
      roman
      (let [f (last (filter (fn [[key val]] (zero? (mod n val))) digits))]
        (recur (- n (val f)) (str roman (key f)))))))