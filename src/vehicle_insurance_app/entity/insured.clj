(ns vehicle-insurance-app.entity.insured
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/vehicle-insurance"
               :user "root"
               :password ""
               :zeroDateTimeBehavior "convertToNull"})

(defn allInsureds[]
  (jdbc/query mysql-db
              ["SELECT * FROM insureds i"]))

(defn get [id]
  (first(jdbc/query mysql-db
                    ["SELECT * FROM insureds WHERE id = ?" id])))

(defn updateInsured [id params]
  (jdbc/update! mysql-db :insureds params (sql/where {:id id})))

(defn insertInsured [params]
  (jdbc/insert! mysql-db :insureds params))