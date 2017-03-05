(ns quickcheck.generators.mac
  (:require [clojure.test.check.generators :as gen]))

(def hex-digit (gen/elements [\0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \a \b \c \d \e \f]))

(def hex-pair (gen/fmap clojure.string/join (gen/tuple hex-digit hex-digit)))

(def mac-address
  (->> 
    (gen/vector hex-pair 6)
    (gen/fmap (partial clojure.string/join "-"))))
