def call(String nodeLabel, String tomcatUrl) {
    stage("Deploy to ${nodeLabel}") {
        agent { label nodeLabel }

        steps {
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
}
