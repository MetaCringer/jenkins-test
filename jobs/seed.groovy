def projects = ["realworld-spring-boot-native", "MASTG-Hacking-Playground", "flask-realworld-example-app"]
def owner = "MetaCringer"
def image_tag = "localhost:5000/java-app"
folder('jobs') {
    displayName('jobs')
}
for (def project in projects){
    
    
    pipelineJob("jobs/${project}") {
        parameters {
            string name: 'REPO', defaultValue: "https://github.com/${owner}/${project}"
            if (project == "realworld-spring-boot-native"){
                string name: 'IMAGE_TAG', defaultValue: "${image_tag}"
            }
            
            string name: 'ARTIFACTORY_URL', defaultValue: "http://artifactory:8081"
            string name: 'SNYK_TOKEN_ID', defaultValue: "snyk"
            string name: 'ARTIFACTORY_TOKEN_ID', defaultValue: "artifactory"
            string name: 'JDK_TOOL', defaultValue: "jdk17"
            string name: 'DOCKER_TOOL', defaultValue: "main"
            string name: 'SNYK_TOOL', defaultValue: "main"
        }
        definition {
            cpsScm {
                scm {
                    git("https://github.com/${owner}/${project}.git", "master")
                }
                scriptPath("Jenkinsfile")
                lightweight(true)
            }
        }
    }
}