def call(String gitUrl) {
    stage('Checkout') {
        echo "Checking out code from ${gitUrl}"
        git branch: 'main', url: gitUrl
    }
}
