(ns numeralium-romani.core-spec
  (:require [speclj.core :refer :all]
            [numeralium-romani.core :refer :all]))

(describe "convert roman to arabic numerals"
  (it "parses < 3 as tallies"
    (should= 1 (as-arabic "I"))
    (should= 2 (as-arabic "II"))
    (should= 3 (as-arabic "III")))

  (it "parses subtraction-based numerals"
    (should= 4 (as-arabic "IV"))
    (should= 9 (as-arabic "IX")))

  (it "parses single char numerals"
    (should= 5 (as-arabic "V"))
    (should= 10 (as-arabic "X"))
    (should= 50 (as-arabic "L"))
    (should= 100 (as-arabic "C")))

  (it "parses addition-based numerals"
    (should= 6 (as-arabic "VI"))
    (should= 11 (as-arabic "XI")))

  (it "parses combined addition- and subtraction- based numerals"
    (should= 14 (as-arabic "XIV"))
    (should= 24 (as-arabic "XXIV"))
    (should= 1900 (as-arabic "MCM"))))
