(ns doll-smuggler.core
  (:use [doll-smuggler.doll])
  (:use [doll-smuggler.io.reader])
  (:use [doll-smuggler.io.writer])
  (:use [clojure.string :only [join]]))

(def ^:dynamic items [])

; Adapted from: http://rosettacode.org/wiki/Knapsack_problem/0-1#Clojure
(declare mm)
 
(defn m [idx w]
  (cond
    (< idx 0) [0 []]
    (= w 0) [0 []]
    :else
    (let [{wi :weight vi :value} (get items idx)]
      (if (> wi w)
        (mm (dec idx) w)
        (let [[vn sn :as no]  (mm (dec idx) w)
              [vy sy :as yes] (mm (dec idx) (- w wi))]
          (if (> (+ vy vi) vn)
            [(+ vy vi) (conj sy idx)]
            no))))))
 
(def mm (memoize m))

(defn -main
  [& args]
  (def data (parse-data (read-data-file "test/resources/data/example_data.txt")))
  (def dolls (vec (get data :dolls)))
  (def max-weight (get data :max-weight))

  (def ^:dynamic items dolls)


  (let [[value indexes] (m  (-> dolls count dec) max-weight)
        names (map (comp :name dolls) indexes)]
    (println "items to pack:" (join ", " names))
    (println "total value:" value)
    (println "total weight:" (reduce + (map (comp :weight dolls) indexes)))

    (println(zipmap indexes dolls))
    '(println (nth dolls (first indexes)))

    (println indexes)
    (println names)
    (println value)

    (write-dolls dolls)

    )
  )
