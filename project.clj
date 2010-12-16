(defproject aleph "0.1.3-SNAPSHOT"
  :description "an asynchronous web server"
  :repositories {"jboss" "http://repository.jboss.org/nexus/content/groups/public/"}
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}
  :dependencies [[org.clojure/clojure "1.2.0"] 
                 [org.jboss.netty/netty "3.2.2.Final"]
                 [clj-http "0.1.0-SNAPSHOT"]
                 [lamina "0.3.1-SNAPSHOT"]
                 [potemkin "0.1.0"]
                 ;;https://gist.github.com/656227
                 ;;original thread http://groups.google.com/group/aleph-lib/browse_thread/thread/4b1cf00b4b3e42de?hl=en_US
                 ;;compojure.core, aleph.core, aleph.http, hiccup.core, hiccup.page-helpers
                 [compojure "0.5.2"]
                 [hiccup "0.3.0"]
                 [ring/ring-core "0.3.0"]
                 [ring/ring-devel "0.3.0"]
                 [ring/ring-httpcore-adapter "0.2.5"]
                 [ring/ring-jetty-adapter "0.2.5"]
                 ;[webmine "0.1.1-SNAPSHOT"]
                 [jline "0.9.94"]
                 ;important: no need to specify clojars.org when in the root like this;;
                 ;see e.g. https://github.com/rosado/aleph.experiments/blob/master/project.clj

                 ;below is as per: https://github.com/swannodette/enlive-tutorial/blob/master/project.clj
                 [enlive "1.0.0-SNAPSHOT"]
                 [net.cgrand/moustache "1.0.0-SNAPSHOT"];probably don't need this yet

		 
		 ])
