(ns vehicle-insurance-app.handler
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [vehicle-insurance-app.controller.controller :as controller]
            [vehicle-insurance-app.entity.insured :as insured]
            [vehicle-insurance-app.entity.vehicle :as vehicle]
            [vehicle-insurance-app.entity.materialdamage :as materialdamage]
            [ring.util.response :as resp]))

(defroutes public-routes
  (GET "/" [] (controller/home))

  (GET "/insureds" [] (controller/insureds-page))

  (GET "/add-insured" [] (controller/add-inusred-page))

  (POST "/add-insured/insertInsured" [& params]
    (do (insured/insertInsured params)
        (resp/redirect "/insureds")))

  (GET "/updateInsured/:id/updateInsured" [id]
    (controller/update-insured-page id))
  (POST "/updateInsured/:id/updateInsured" [& params]
    (do (insured/updateInsured (:id params) params)
        (resp/redirect "/insureds")))

  (GET "/vehicles" [] (controller/vehicles-page))
  (GET "/add-vehicle" [] (controller/add-vehicle-page))
  (POST "/add-vehicle/insertVehicle" [& params]
    (do (vehicle/insertVehicle params)
        (resp/redirect "/vehicles")))

  (GET "/updateVehicle/:id/updateVehicle" [id]
    (controller/update-vehicle-page id))
  (POST "/updateVehicle/:id/updateVehicle" [& params]
    (do (vehicle/updateVehicle (:id params) params)
        (resp/redirect "/vehicles")))
  
  (GET "/materialDamages" [] (controller/material-damages-page))
  (GET "/add-material-damage" [] (controller/add-material-damage-page))
  (POST "/add-material-damage/insertMaterialDamage" [& params]
    (do (materialdamage/insertMaterialDamage params)
        (resp/redirect "/materialDamages")))
  
  (GET "/updateMaterialDamage/:id/updateMaterialDamage" [id]
    (controller/update-material-damage-page id))
  (POST "/updateMaterialDamage/:id/updateMaterialDamage" [& params]
    (do (materialdamage/updateMaterialDamage (:id params) params)
        (resp/redirect "/materialDamages"))))

(defroutes protected-routes)

(defroutes app-routes
  public-routes
  protected-routes
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
