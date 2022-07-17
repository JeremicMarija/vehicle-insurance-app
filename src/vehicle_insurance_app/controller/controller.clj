(ns vehicle-insurance-app.controller.controller
  (:require [clostache.parser :as clostache]
            [vehicle-insurance-app.entity.insured :as insured-entity]
            [vehicle-insurance-app.entity.vehicle :as vehicle-entity]
            [vehicle-insurance-app.entity.materialdamage :as material-damages-entity]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
          (str "pages/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn home []
  (render-template "homepage" {}))

;Insured start
(defn insureds-page []
  (render-template "insureds-page" {:insureds (insured-entity/allInsureds)}))

(defn add-inusred-page []
  (render-template "add-insured" {}))

(defn update-insured-page [id]
  (render-template "update-insured" {:insureds (insured-entity/get id)}))

;Vehicle start
(defn vehicles-page []
  (render-template "vehicles-page" {:vehicles (vehicle-entity/allVehicles)
                                    :insureds (insured-entity/allInsureds)}))

(defn add-vehicle-page [] 
  (render-template "add-vehicle" {:insureds (insured-entity/allInsureds)}))

(defn update-vehicle-page [id] 
  (render-template "update-vehicle" {:vehicles (vehicle-entity/get id)
                                     :insureds (insured-entity/allInsureds)}))

;Material Damage start
(defn material-damages-page []
  (render-template "material-damages-page" {:material-damages (material-damages-entity/allMaterialDamages)
                                            :vehicles (vehicle-entity/allVehicles)}))

(defn add-material-damage-page []
 (render-template "add-material-damage" {:vehicles (vehicle-entity/allVehicles)}))

(defn update-material-damage-page [id]
  (render-template "update-material-damage" {:material-damages (material-damages-entity/get id)
                                             :vehicles (vehicle-entity/allVehicles)}))