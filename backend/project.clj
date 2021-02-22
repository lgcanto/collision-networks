(defproject backend "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.2"]
                 ;; Compojure - A basic routing library
                 [compojure "1.6.2"]
                 ;; Our Http library for client/server
                 [http-kit "2.5.1"]
                 ;; Ring defaults - for query params etc
                 [ring/ring-defaults "0.3.2"]
                 ;; Clojure data.JSON library
                 [org.clojure/data.json "1.0.0"]
                 ;; Static code analysis
                 [clj-kondo "RELEASE"]]
  :main ^:skip-aot backend.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}}
  ;; Static code analysis
  :plugins [[jonase/eastwood "0.3.13"]
            [lein-kibit "0.1.8"]
            ;; Detection of outdated dependencies/plugins
            [lein-ancient "0.6.15"]
            ;; Test coverage reports
            [lein-cloverage "1.2.2"]
            ;; Detection of vulnerable dependencies
            [lein-nvd "1.4.0"]])
