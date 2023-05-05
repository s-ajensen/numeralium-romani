(ns numeralium-romani.core-spec
  (:require [speclj.core :refer :all]
            [numeralium-romani.core :refer :all]))

(describe "converts arabic to roman numerals"
  (it "parses single character numbers up to 1,000"
    (should= "I" (as-roman 1))
    (should= "V" (as-roman 5))
    (should= "X" (as-roman 10))
    (should= "L" (as-roman 50))
    (should= "C" (as-roman 100))
    (should= "M" (as-roman 1000)))

  (it "parses subtraction-based numerals up to 900"
    (should= "IV" (as-roman 4))
    (should= "IX" (as-roman 9))
    (should= "CD" (as-roman 400))
    (should= "XC" (as-roman 90))
    (should= "CD" (as-roman 400))
    (should= "CM" (as-roman 900)))

  (it "parses identical, repeating digits"
    (should= "II" (as-roman 2))
    (should= "III" (as-roman 3))
    (should= "XX" (as-roman 20))
    (should= "CCC" (as-roman 300)))

  (it "parses mixed repeating and subtraction-based numerals"
    (should= "XXIX" (as-roman 29))
    (should= "XIV" (as-roman 14))
    (should= "CXCIX" (as-roman 199)))

  (it "parses addition-based numerals up to 999"
    (should= "VI" (as-roman 6))
    (should= "LX" (as-roman 60))
    (should= "DC" (as-roman 600))
    (should= "CMXCIX" (as-roman 999)))

  (it "parses mixed repeating and addition-based numerals"
    (should= "LXXX" (as-roman 80))
    (should= "DCC" (as-roman 700)))

  (it "parses mixed addition- and subtraction-based numerals"
    (should= "MCM" (as-roman 1900))
    (should= "MIX" (as-roman 1009))
    (should= "MLXVI" (as-roman 1066))
    (should= "MMMCMXCIX" (as-roman 3999))))

(describe "converts roman to arabic numerals"
  (it "parses single character numerals"
    (should= 1 (as-arabic "I"))
    (should= 5 (as-arabic "V"))
    (should= 1000 (as-arabic "M")))

  (it "parses subtraction-based numerals"
    (should= 4 (as-arabic "IV"))
    (should= 90 (as-arabic "XC"))
    (should= 900 (as-arabic "CM")))

  (it "parses repeated single character numerals"
    (should= 3 (as-arabic "III"))))