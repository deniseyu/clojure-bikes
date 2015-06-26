(ns boris-bikes-clojure.core)

(defn working?
  [bike]
  (= (:status bike) :working))

(defn break!
  [bike]
  (assoc bike :status :broken))

(defn repair!
  [bike]
  (assoc bike :status :working))
