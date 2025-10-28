def call() {
    stage('Build') {
        echo "Building WAR using Maven..."
        sh 'mvn clean package'
        stash includes: 'target/*.war', name: 'app-war'

        script {
            timeout(time: 10, unit: 'MINUTES') {
                input(id: 'DeployApprove', message: 'Continue to deploy?')
            }
        }
    }
}
