(ns doll-smuggler.test.io.reader
  (:use [doll-smuggler.io.reader])
  (:use [doll-smuggler.core])
  (:use [clojure.test]))

(testing "reads a file"
  (deftest should-parse-many-dolls-a-dummy-file
    (is (= ["foo" "bar" "baz"] (read-data-file "test/resources/data/dummy.txt")))))

(testing "parses data"
  (deftest should-parse-data
    (is (= { :max-weight 400 } (parse-data ["max weight: 400"] )))))

(testing "parses max-weight from data"  
  (deftest should-parse-max-weight
    (is (= 400 (parse-max-weight ["max weight: 400"])))))

(testing "parses doll from string"
  (deftest should-parse-doll
    (is (= (struct doll "luke" 9 150) (parse-doll "luke        9   150")))))

(testing "parses dolls from data"
  (deftest should-handle-no-dolls
    (is (= 0 (count (parse-dolls [])))))

  (deftest should-parse-one-doll
    (def dolls (parse-dolls ["" "" "" "" "" "luke        9   150"]))
    (is (= [(struct doll "luke" 9 150)] dolls))
    (is (= 1 (count dolls)))
    ))

  (deftest should-parse-many-dolls
    (def dolls (parse-dolls ["" "" "" "" "" "luke        9   150" "anthony    13    35"]))
    (is (= [(struct doll "luke" 9 150) (struct doll "anthony" 13 35)] dolls))
    (is (= [(struct doll "luke" 9 150) (struct doll "anthony" 13 35)] dolls)))
