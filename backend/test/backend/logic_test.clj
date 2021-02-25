(ns backend.core-test
  (:require [clojure.test :refer :all]
            [backend.logic :as logic]))

(def edges-mock
  [[8 7]
   [7 3]
   [2 1]
   [3 7]
   [4 8]])

(deftest edge-to-map-test
  (testing "Checking if edge-to-map really returns a map"
    (is (= (logic/edge-to-map (first edges-mock)) {8 #{7} 7 #{8}))))