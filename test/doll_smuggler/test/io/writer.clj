(ns doll-smuggler.test.io.writer
  (:use [doll-smuggler.core])
  (:use [doll-smuggler.io.writer])
  (:use [clojure.test]))

(testing "formats doll row"
  (deftest should-format-doll-row
    (is (= "anthony     13     35" (format-doll-row (struct doll "anthony" 13 35))))))

'(testing "prints dolls"
  (deftest should-print-dolls
    (write-dolls [(struct doll "luke" 9 150) (struct doll "anthony" 13 35) (struct doll "candice"   153   200)])))