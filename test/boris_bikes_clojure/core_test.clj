(ns boris-bikes-clojure.core-test
  (:require [clojure.test :refer :all]
            [boris-bikes-clojure.core :refer :all]))

(deftest bike-status 
  (testing "Bike is working"
    (let [bike {:status :working}]
      (is (= (working? bike) true))))
  (testing "Broken bike is not working"
    (let [broken-bike {:status :broken}]
      (is (= (working? broken-bike) false))))) 

(deftest bike-breaking
  (testing "Bike can break"
    (let [bike {:status :working}]
      (is (= (working? (break! bike)) false))))
  (testing "Bike can be fixed"
    (let [broken-bike {:status :broken}]
      (is (= (working? (repair! broken-bike)) true)))))
