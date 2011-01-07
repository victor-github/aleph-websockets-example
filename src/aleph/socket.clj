
(ns wl.core
  (:use compojure.core, aleph.http, aleph.http.core, hiccup.core, hiccup.page-helpers, lamina.core)
  (:require [compojure.route :as route])
  (:gen-class)

  (:require [compojure.route :as route])
  (:use [clojure.java.io :only (file)])

  (:require [net.cgrand.enlive-html :as html])

)

(def *base-url* (atom ""));will be defined later, based on what we GET

(defn fetch-url [url]
    (html/html-resource (java.net.URL. url)))

(defn render [t] (apply str t))

(def broadcast-channel (channel))

(defn websocket-activity [ch handshake]
  (receive ch
   (fn [name]
     (doseq [i (range 100)]   
      (. Thread (sleep 1000))
      (let [comment-thread    (html/select (fetch-url @*base-url*) [:table (html/has [:td.doubledash])])
            ;if you were to retrieve the whole form in the page: (html/select (fetch-url @*base-url*) [:form])
            what-to-enqueue (render (html/emit* comment-thread))
            ]
      (enqueue ch what-to-enqueue)
        )  ))) )

(defn layout [& content]
  (html5 [:head [:title "new page"] (include-js "js/jquery-1.4.3.min.js")]
	 [:body content]))

(defroutes my-app

  ;NB: this doesn't affect the routes below, just the ones in the html files
  (route/files "/"
   {:root "full-path-to-project/aleph-websockets-ring-example/public"}
  (route/not-found
    (file "full-path-to-project/aleph-websockets-ring-example/public/404.html")))

  (GET "/:thread_id" {params :params} 
       (do
         (swap! *base-url* (fn[_] (str "http://boards.url.org/b/res/" (params "thread_id")))) 
         (spit "public/test_url" @*base-url*)
         (layout (slurp "public/ws.html")) ) )  
  (GET "/socket/get" [] (wrap-aleph-handler websocket-activity))
  (route/not-found (layout [:p "file not found."])))


(defn main []
  (start-http-server (wrap-ring-handler my-app) {:port 8080 :websocket true})
  (println "server started"))

;;start execution in main[]
(main)
