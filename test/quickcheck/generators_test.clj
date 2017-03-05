(ns quickcheck.generators-test
  (:require [quickcheck.generators.email :as email]
            [quickcheck.generators.auth :as auth]
            [clojure.test :refer :all]
            [clojure.test.check.clojure-test :refer (defspec)]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]))

(defspec dino-email-addresses
         (prop/for-all [e email/email]
                       (is (.contains e "@"))
                       (is (.contains e "aurus"))))

(defspec passwords
         (prop/for-all (pwd auth/dictionary-password)
                       (is (string? pwd))))
