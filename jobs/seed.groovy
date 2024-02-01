def projects = ["realworld-spring-boot-native", "MASTG-Hacking-Playground", "flask-realworld-example-app"]
def owner = "MetaCringer"
def image_tag = "localhost:5000/java-app"
folder('jobs') {
    displayName('jobs')
}
for (def project in projects){
    
    
    pipelineJob("jobs/${project}") {
        parameters {
            stringParam('REPO', "https://github.com/${owner}/${project}", "")
            if (project == "realworld-spring-boot-native"){
                stringParam('IMAGE_TAG', "${image_tag}", "")
            }
            stringParam('ARTIFACTORY_URL', "http://artifactory:8081", "")
            stringParam('SNYK_TOKEN_ID', "snyk", "")
            stringParam('ARTIFACTORY_TOKEN_ID', "artifactory", "")
            if(project == "MASTG-Hacking-Playground"){
                stringParam('MOBSF_TOKEN_ID', "mobsf", "")
            }
            stringParam('JDK_TOOL', "jdk17", "")
            stringParam('DOCKER_TOOL', "main", "")
            stringParam('SNYK_TOOL', "main", "")
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