(use 'ring.adapter.jetty)
(use 'aleph.socket)

(let [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
    (run-jetty #'aleph.socket/myapp {:port port}))
