(ns doll-smuggler.core
  (:use [doll-smuggler.doll])
  (:use [doll-smuggler.io.reader])
  (:use [doll-smuggler.io.writer])
  )

(defn -main
  [& args]
  (println (parse-data (read-data-file "test/resources/data/example_data.txt")))
  )
