(ns quickcheck.generators.email
  (:require [clojure.test.check.generators :as gen]
            [dict.words :as words]))

(def tld "Top-Level Domains"
  (gen/elements [".com" ".edu" ".gov" ".mil" ".net" ".org"]))

(defn- make-email [xs]
  (->> (interleave xs ["." "@" "" ""])
       (apply str)
       (clojure.string/lower-case)))

(def email "Generator of email addresses in form adj.dino@kingdom.tld"
  (gen/fmap make-email
            (gen/tuple
              (gen/elements words/adjectives)
              (gen/elements words/dinosaurs)
              (gen/elements words/domains)
              tld)))
