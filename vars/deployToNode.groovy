// vars/deployToNode.groovy
def call(String nodeLabel, String tomcatUrl) {
    node(nodeLabel) {
        unstash 'app-war'
        deploy adapters: [tomcat9(
            credentialsId: 'tomcat-credentials',
            path: '',
            url: "http://${tomcatUrl}/"
        )],
        contextPath: null,
        war: 'target/*.war'
    }
}
