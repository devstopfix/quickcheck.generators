(ns quickcheck.generators.auth
  (:require [clojure.test.check.generators :as gen]
            [dict.words :as words]))

(def dictionary-password
  (gen/fmap (partial clojure.string/join "-")
    (gen/let [n (gen/elements [2 3 4])]
             (gen/vector (gen/elements words/short-ascii-words) n))))

(def char-base64
  (-> "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
      (seq)
      (gen/elements)))

(def bearer-token "e.g. YYhJLopHg5e6GUT5aH2VddwCNaUvAdSK"
  (gen/fmap clojure.string/join (gen/vector char-base64 32)))
