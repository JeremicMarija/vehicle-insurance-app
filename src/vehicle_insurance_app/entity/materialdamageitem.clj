(ns vehicle-insurance-app.entity.materialdamageitem
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/vehicle-insurance"
               :user "root"
               :password ""
               :zeroDateTimeBehavior "convertToNull"})

(defn allMaterialDamageItems[id]
  (jdbc/query mysql-db
              ["SELECT material_damage_items.id, material_damage_items.description, material_damage_items.estimated_price, material_damage_items.damagetype_id, material_damage_items.materialdamage_id,
                material_damages.entry_date, material_damages.type_of_damage, damage_types.name
                FROM material_damage_items 
                LEFT JOIN material_damages ON material_damage_items.materialdamage_id = material_damages.id
                LEFT JOIN damage_types ON material_damage_items.damagetype_id = damage_types.id
                WHERE materialdamage_id = ?" id]))