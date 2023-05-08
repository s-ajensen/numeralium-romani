(ns numeralium-romani.core-spec
  (:require [speclj.core :refer :all]
            [numeralium-romani.core :refer :all]))

(describe "Converts Arabic to Roman numerals"
  (it "parses numbers < 3 as tally marks"
    (should= "I" (as-roman 1))
    (should= "II" (as-roman 2))
    (should= "III" (as-roman 3)))

  (it "parses subtraction-based numerals"
    (should= "IV" (as-roman 4))
    (should= "IX" (as-roman 9))
    (should= "XL" (as-roman 40))
    (should= "XC" (as-roman 90))
    (should= "CD" (as-roman 400))
    (should= "CM" (as-roman 900)))

  (it "parses individual numerals"
    (should= "V" (as-roman 5))
    (should= "X" (as-roman 10))
    (should= "L" (as-roman 50))
    (should= "C" (as-roman 100))
    (should= "D" (as-roman 500))
    (should= "M" (as-roman 1000)))

  (it "parses addition-based numerals"
    (should= "VI" (as-roman 6))
    (should= "XII" (as-roman 12))
    (should= "CLV" (as-roman 155))
    (should= "MD" (as-roman 1500)))

  (it "parses combined subtraction- and addition-based numerals"
    (should= "MCM" (as-roman 1900))
    (should= "XIV" (as-roman 14))
    (should= "MLXVI" (as-roman 1066))
    (should= "MMMCMXCIX" (as-roman 3999))))

(describe "Converts Roman to Arabic numerals"
  (it "parses I as 1"
    (should= 1 (as-arabic "I")))

  (it "parses consecutive I's"
    (should= 2 (as-arabic "II"))
    (should= 3 (as-arabic "III")))

  (it "parses consecutive, repeating numerals"
    (should= 20 (as-arabic "XX"))
    (should= 30 (as-arabic "XXX"))
    (should= 200 (as-arabic "CC"))
    (should= 3000 (as-arabic "MMM")))

  (it "parses subtraction-based numerals"
    (should= 4 (as-arabic "IV"))
    (should= 9 (as-arabic "IX"))
    (should= 40 (as-arabic "XL"))
    (should= 90 (as-arabic "XC"))
    (should= 400 (as-arabic "CD"))
    (should= 900 (as-arabic "CM")))

  (it "parses addition-based numerals"
    (should= 6 (as-arabic "VI"))
    (should= 12 (as-arabic "XII"))
    (should= 1300 (as-arabic "MCCC"))
    (should= 1333 (as-arabic "MCCCXXXIII")))

  (it "parses combined subtraction- and addition-based numerals"
    (should= 24 (as-arabic "XXIV"))
    (should= 1900 (as-arabic "MCM"))
    (should= 14 (as-arabic "XIV"))
    (should= 1066 (as-arabic "MLXVI"))
    (should= 3999 (as-arabic "MMMCMXCIX"))))