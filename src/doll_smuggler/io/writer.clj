(ns doll-smuggler.io.writer
  (:use [doll-smuggler.doll])
  (:require clojure.string))

(defn write-title
  []
  (println "packed dolls:\n"))

(defn write-headers
  []
  (println "name    weight  value"))

(defn format-doll-row
  [doll]
  (format "%-8s %5s %6s" (get doll :name) (get doll :weight) (get doll :value)))

(defn write-doll
  [doll]
  (println (format-doll-row doll)))

(defn write-dolls
  [dolls]
  (write-title)
  (write-headers)
  (dorun (map write-doll dolls)))
