def projects = ["realworld-spring-boot-native", "MASTG-Hacking-Playground", "flask-realworld-example-app"]
def owner = "MetaCringer"
def image_tag = "localhost:5000/java-app"
def jdk_tool = "jdk17"
folder('jobs') {
    displayName('jobs')
}
for (def project in projects){
    if(project == "MASTG-Hacking-Playground"){
        jdk_tool = "jdk8"
    }
    
    pipelineJob("jobs/${project}") {
        parameters {
            stringParam('REPO', "https://github.com/${owner}/${project}", "")
            if (project == "realworld-spring-boot-native"){
                stringParam('IMAGE_TAG', "${image_tag}", "")
            }
            if(project == "MASTG-Hacking-Playground"){
                stringParam('MOBSF_TOKEN_ID', "mobsf", "")
                stringParam('MOBSF_URL', "http://mobsf:8000", "")
            }
            if(project != "flask-realworld-example-app"){
                stringParam('JDK_TOOL', "${jdk_tool}", "")
            }
            stringParam('DOCKER_TOOL', "main", "")
            stringParam('ARTIFACTORY_URL', "http://artifactory:8081", "")
            stringParam('SNYK_TOKEN_ID', "snyk", "")
            stringParam('ARTIFACTORY_TOKEN_ID', "artifactory", "")
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