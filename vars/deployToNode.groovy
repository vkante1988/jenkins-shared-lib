// vars/deployToNode.groovy
def call(String nodeLabel, String tomcatUrl) {
    stage("Deploy to ${nodeLabel}") {
        echo "Starting deployment on ${nodeLabel} (Tomcat: ${tomcatUrl})"

        node(nodeLabel) {
            unstash 'app-war'

            try {
                deploy adapters: [tomcat9(
                    credentialsId: 'tomcat-credentials',
                    path: '',
                    url: "http://${tomcatUrl}/"
                )],
                contextPath: null,
                war: 'target/*.war'

                echo "✅ Successfully deployed to ${nodeLabel} (${tomcatUrl})"
            } catch (err) {
                echo "❌ Deployment failed on ${nodeLabel} (${tomcatUrl})"
                error "Deployment to ${nodeLabel} failed: ${err}"
            }
        }
    }
}
