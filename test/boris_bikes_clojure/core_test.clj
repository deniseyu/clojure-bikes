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

(deftest docking-bikes
  (testing "Bike can be docked"
    (let [bike {:status :working} station []]
      (is (= (dock bike station) [bike]))))
  (testing "Dock contains one bike after docking"
    (let [bike {:status :working} station []]
      (is (= (count (dock bike station)) 1)))))

(deftest undocking-bikes
  (testing "Bike can be undocked"
    (let [bike {:status :working} station [bike]]
      (is (= (undock station) []))))
  (testing "Dock contains no bikes after undocking"
    (let [bike {:status :working} station [bike]]
      (is (= (bike-count (undock station)) 0)))))
