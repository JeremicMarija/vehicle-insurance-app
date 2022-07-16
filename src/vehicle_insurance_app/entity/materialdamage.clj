(ns vehicle-insurance-app.entity.materialdamage
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/vehicle-insurance"
               :user "root"
               :password ""
               :zeroDateTimeBehavior "convertToNull"})

(defn allMaterialDamages[]
  (jdbc/query mysql-db
              ["SELECT material_damages.id, material_damages.entry_date, material_damages.type_of_damage, material_damages.vehicle_id, vehicles.registration_number
                FROM material_damages
                LEFT JOIN vehicles ON material_damages.vehicle_id = vehicles.id"]))

(defn get [id]
  (first(jdbc/query mysql-db
                    ["SELECT * FROM material_damages WHERE id = ?" id])))

(defn insertMaterialDamage [params]
  (jdbc/insert! mysql-db :material_damages params))