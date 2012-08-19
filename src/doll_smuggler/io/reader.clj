(ns doll-smuggler.io.reader
  (:use [doll-smuggler.doll])
  (:require clojure.string))

(defn read-data-file
  [filename]
  (clojure.string/split-lines (slurp filename)))

(defn parse-max-weight
  [data]
  (def pattern (re-pattern #"^max weight:\s*(\d+)"))
  (read-string (get (re-matches pattern (first data)) 1)))

(defn parse-doll
  [s]
  (def values (clojure.string/split s #"\s+"))
  (struct doll (nth values 0) (read-string (nth values 1)) (read-string (nth values 2))))

(defn parse-dolls
  [data]
  (map parse-doll (drop 5 data))
  )

(defn parse-data
  [data]
  { :max-weight (parse-max-weight data)
    :dolls      (parse-dolls data) } )



