;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
(defproject io.czlab/jasal "2.2.0"

  :license {:url "https://www.apache.org/licenses/LICENSE-2.0.txt"
            :name "Apache License"}

  :description "General helper java classes + interfaces."
  :url "https://github.com/llnek/jasal"

  :dependencies [[org.apache.logging.log4j/log4j-slf4j2-impl "2.24.1"]
                 [org.apache.logging.log4j/log4j-core "2.24.1"]
                 ;[javax.activation/activation "1.1.1"]
                 [jakarta.activation/jakarta.activation-api "2.1.3"]
                 [org.slf4j/slf4j-api "2.0.16"]]

  :plugins [[lein-junit "1.1.9"]
            [lein-javadoc "0.3.0"]
            [lein-cprint "1.2.0"]]

  :profiles {:provided {:dependencies
                        [[org.clojure/clojure "1.12.0"]
                         [net.mikera/cljunit "0.7.0" :scope "test"]
                         [org.junit.jupiter/junit-jupiter-api "5.11.3" :scope "test"]]}
             :uberjar {:aot :all}}

  :global-vars {*warn-on-reflection* true}
  :target-path "out/%s"
  :aot :all

  :coordinate! "czlab"
  :omit-source true

  :java-source-paths ["src/main/java" "src/test/java"]
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :resource-paths ["src/main/resources"]

  :javadoc-opts {:package-names ["czlab.jasal"]
                 :output-dir "docs"}

  ;;lein junit
  :junit-test-file-pattern #".*JUnit*.java"
  :junit-results-dir "test-reports"
  :junit-formatter "xml"
  :junit ["src/test/java"]

  :jvm-opts ["-Dlog4j.configurationFile=file:attic/log4j2.xml"
             "-Dczlabloggerflag=true"]
  :javac-options ["-source" "16"
                  "-target" "22"
                  "-Xlint:unchecked" "-Xlint:-options" "-Xlint:deprecation"])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;EOF

