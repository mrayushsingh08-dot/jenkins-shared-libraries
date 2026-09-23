def call() {
    withSonarQubeEnv('sonarqube') {
        sh 'mvn clean verify sonar:sonar'
    }
}
