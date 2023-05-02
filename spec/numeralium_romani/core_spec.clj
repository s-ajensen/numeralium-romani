(ns numeralium-romani.core-spec
  (:require [speclj.core :refer :all]
            [numeralium-romani.core :refer :all]))

(describe "converts roman to arabic numerals"
  (it "parses i as 1"
    (should= 1 (as-arabic "I")))

  (it "parses consecutive i characters"
    (should= 2 (as-arabic "II"))
    (should= 3 (as-arabic "III")))

  (it "parses iv as 4"
    (should= 4 (as-arabic "IV")))

  (it "parses leading modifiers as 'less than'"
    (should= 9 (as-arabic "IX"))
    (should= 90 (as-arabic "XC"))
    (should= 900 (as-arabic "CM")))

  (it "parses vi as 6"
    (should= 6 (as-arabic "VI")))

  (it "parses trailing modifiers as 'greater than'"
    (should= 7 (as-arabic "VII"))
    (should= 8 (as-arabic "VIII"))
    (should= 120 (as-arabic "CXX"))
    (should= 60 (as-arabic "LX")))

  (it "parses numerals with combined leading and trailing modifiers"
    (should= 1900 (as-arabic "MCM"))
    (should= 2421 (as-arabic "MMCDXXI"))
    (should= 1009 (as-arabic "MIX"))
    (should= 3999 (as-arabic "MMMCMXCIX"))))
