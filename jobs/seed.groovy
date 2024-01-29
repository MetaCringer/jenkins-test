projects = ["realworld-spring-boot-native", "MASTG-Hacking-Playground", "flask-realworld-example-app"]
owner = "MetaCringer"
folder("jobs")
project=projects[0]
pipelineJob("jobs/${project}") {
    // parameters {
    // }
    definition {
        cpsScm {
            
            scm {
                git("https://github.com/${owner}/${project}.git")
            }
            scriptPath("Jenkinsfile")
            lightweight(true)
        }
    }
}