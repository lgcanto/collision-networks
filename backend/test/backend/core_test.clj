(ns backend.core-test
  (:require [clojure.test :refer :all]
            [backend.core :refer :all]))

(deftest a-test
  (testing "test-function must return 4"
    (is (= (test-function) 4))))
