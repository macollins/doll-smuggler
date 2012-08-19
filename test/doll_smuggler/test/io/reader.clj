(ns doll-smuggler.test.io.reader
  (:use [doll-smuggler.core])
  (:use [doll-smuggler.doll])
  (:use [doll-smuggler.io.reader])
  (:use [clojure.test]))

(def luke    (struct doll "luke" 9 150))
(def anthony (struct doll "anthony" 13 35))

(testing "reads a file"
  (deftest should-parse-many-dolls-a-dummy-file
    (is (= ["foo" "bar" "baz"] (read-data-file "test/resources/data/dummy.txt")))))

(testing "parses data"
  (deftest should-parse-data
    (is (= { :max-weight 400
             :dolls [luke] } (parse-data ["max weight: 400" "" "" "" "" "luke        9   150"] )))))

(testing "parses max-weight from data"  
  (deftest should-parse-max-weight
    (is (= 400 (parse-max-weight ["max weight: 400"])))))

(testing "parses doll from string"
  (deftest should-parse-doll
    (is (= luke (parse-doll "luke        9   150")))))

(testing "parses dolls from data"
  (deftest should-handle-no-dolls
    (is (= 0 (count (parse-dolls [])))))

  (deftest should-parse-one-doll
    (def dolls (parse-dolls ["" "" "" "" "" "luke        9   150"]))
    (is (= [luke]))
    (is (= 1 (count dolls)))
    ))

  (deftest should-parse-many-dolls
    (def dolls (parse-dolls ["" "" "" "" "" "luke        9   150" "anthony    13    35"]))
    (is (= [luke anthony] dolls))
    (is (= [luke anthony] dolls)))
