projects = ["realworld-spring-boot-native", "MASTG-Hacking-Playground", "flask-realworld-example-app"]
owner = "MetaCringer"

pipelineJob("jobs/${project}") {
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