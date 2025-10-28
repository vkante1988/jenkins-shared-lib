// vars/deployToNode.groovy
def call(String tomcatUrl) {
    echo "Deploying WAR to Tomcat: ${tomcatUrl}"

    deploy adapters: [tomcat9(
        credentialsId: 'tomcat-credentials',
        path: '',
        url: "http://${tomcatUrl}/"
    )],
    contextPath: null,
    war: 'target/*.war'

    echo "✅ Deployment to ${tomcatUrl} completed."
}
