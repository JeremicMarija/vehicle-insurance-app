(ns vehicle-insurance-app.controller.controller
  (:require [clostache.parser :as clostache]
            [vehicle-insurance-app.entity.insured :as insured-entity]))

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