projects = ["realworld-spring-boot-native", "MASTG-Hacking-Playground", "flask-realworld-example-app"]
owner = "MetaCringer"

pipelineJob("realworld-spring-boot-native") {
    // parameters {
    // }
    definition {
        cpsScm {
            
            scm {
                git("https://github.com/MetaCringer/realworld-spring-boot-native.git")
            }
            scriptPath("Jenkinsfile")
            lightweight(true)
        }
    }
}