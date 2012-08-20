(ns doll-smuggler.core
  (:use [doll-smuggler.doll])
  (:use [doll-smuggler.io.reader])
  (:use [doll-smuggler.io.writer]))

(def ^:dynamic items [])

; Adapted from: http://rosettacode.org/wiki/Knapsack_problem/0-1#Clojure
(declare mm)
 
(defn m [idx max-weight]
  (cond
    (< idx 0) [0 []]
    (= max-weight 0) [0 []]
    :else
    (let [{doll-weight :weight doll-value :value} (get items idx)]
      (if (> doll-weight max-weight)
        (mm (dec idx) max-weight)
        (let [[vn sn :as no]  (mm (dec idx) max-weight)
              [vy sy :as yes] (mm (dec idx) (- max-weight doll-weight))]
          (if (> (+ vy doll-value) vn)
            [(+ vy doll-value) (conj sy idx)]
            no))))))
 
(def mm (memoize m))

(defn total-weight
  [dolls indexes]
  (reduce + (map (comp :weight dolls) indexes)))

(defn -main
  [& args]
  (if (= (count args) 0)
      ((println "Usage: lein run <path to data file>")
       (System/exit 0)))

  (def filename (first args))
  (def data (parse-data (read-data-file filename)))
  (def max-weight (get data :max-weight))
  (def dolls (vec (get data :dolls)))
  (def ^:dynamic items dolls)

  (let [[value indexes] (m  (-> dolls count dec) max-weight)
        names (map (comp :name dolls) indexes)]
    (println "total value:" value)
    (println "total weight:" (total-weight dolls indexes))

    (write-dolls dolls indexes)))
