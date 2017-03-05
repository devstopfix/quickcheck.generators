(ns quickcheck.generators.auth
  (:require [clojure.test.check.generators :as gen]
            [dict.words :as words]))

(def dictionary-password
  (gen/fmap (partial clojure.string/join "-")
    (gen/let [n (gen/elements [2 3 4])]
             (gen/vector (gen/elements words/short-ascii-words) n))))
