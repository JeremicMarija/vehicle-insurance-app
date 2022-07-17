(ns vehicle-insurance-app.entity.damagetype
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/vehicle-insurance"
               :user "root"
               :password ""
               :zeroDateTimeBehavior "convertToNull"})

(defn allDamageTypes[]
  (jdbc/query mysql-db
              ["SELECT * FROM damage_types dt"]))