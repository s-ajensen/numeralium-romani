(ns numeralium-romani.core
  (:require [clojure.string :as string]))

(defn as-arabic [n]
  (let [digits {\I 1 \V 5 \X 10}]
    (->> (vec n)
      (map #(digits %))
      (#(loop [digits %
               total  0]
          (if (empty? digits)
            total
            (recur
              (next digits)
              (* (if (> (nth digits 1 0) (first digits)) -1 1) (+ total (first digits))))))))))