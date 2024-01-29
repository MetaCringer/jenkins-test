def projects = ["realworld-spring-boot-native", "MASTG-Hacking-Playground", "flask-realworld-example-app"]
def owner = "MetaCringer"
folder("jobs")
def project=projects[0]
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