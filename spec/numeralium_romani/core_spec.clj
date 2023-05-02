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
    (should= 4 (as-arabic "IV"))
    (should= 9 (as-arabic "IX"))))
