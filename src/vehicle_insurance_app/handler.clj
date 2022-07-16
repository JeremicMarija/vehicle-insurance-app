(ns vehicle-insurance-app.handler
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [vehicle-insurance-app.controller.controller :as controller]
            [vehicle-insurance-app.entity.insured :as insured]
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
        (resp/redirect "/insureds"))))

(defroutes protected-routes)

(defroutes app-routes
  public-routes
  protected-routes
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
