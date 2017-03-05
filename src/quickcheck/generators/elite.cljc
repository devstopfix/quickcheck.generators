(ns quickcheck.generators.elite
  (:require [clojure.test.check.generators :as gen]))

; Elite planet name letter pairs (http://www.iancgbell.clara.net/elite/text/index.htm)
(def pair (gen/elements [[     ] [\L \E] [\X \E] [\G \E] [\Z \A] [\C \E] [\B \I] [\S \O]
                         [\U \S] [\E \S] [\A \R] [\M \A] [\I \N] [\D \I] [\R \E] [\A   ]
                         [\E \R] [\A \T] [\E \N] [\B \E] [\R \A] [\L \A] [\V \E] [\T \I]
                         [\E \D] [\O \R] [\Q \U] [\A \N] [\T \E] [\I \S] [\R \I] [\O \N]]))

; Generator of Elite-like planet names. Uses a similar algorithm but replaces the use
; of a seeded series of numbers with test.check generators.
(def planet
  (->> (gen/vector pair 3 4)
       (gen/fmap flatten)
       (gen/fmap clojure.string/join)
       (gen/such-that not-empty)))
