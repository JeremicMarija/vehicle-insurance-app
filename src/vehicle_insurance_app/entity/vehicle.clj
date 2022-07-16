(ns vehicle-insurance-app.entity.vehicle
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/vehicle-insurance"
               :user "root"
               :password ""
               :zeroDateTimeBehavior "convertToNull"})

(defn allVehicles[]
  (jdbc/query mysql-db
              ;["SELECT * FROM vehicles v"]
              ["SELECT insureds.name, insureds.surname, vehicles.brand, vehicles.id, vehicles.model, vehicles.registration_number, vehicles.insured_id 
                FROM vehicles
                LEFT JOIN insureds ON vehicles.insured_id = insureds.id"]
              ))

(defn get [id]
  (first(jdbc/query mysql-db
                    ["SELECT * FROM vehicles WHERE id = ?" id])))

(defn insertVehicle [params]
  (jdbc/insert! mysql-db :vehicles params))

(defn updateVehicle [id params]
  (jdbc/update! mysql-db :vehicles params (sql/where {:id id})))