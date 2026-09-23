def call(String sonarServer, String projectKey, String projectName) {
    withSonarQubeEnv("${sonarServer}") {
        def scannerHome = tool 'sonar'
        sh """
            ${scannerHome}/bin/sonar-scanner \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.projectName=${projectName} \
                -Dsonar.sources=.
        """
    }
}
