def call() {

    withCredentials([
        string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')
    ]) {

        dependencyCheck(
            odcInstallation: 'OWASP',
            additionalArguments: "--scan ./ --nvdApiKey ${NVD_API_KEY}"
        )

        dependencyCheckPublisher(
            pattern: '**/dependency-check-report.xml'
        )
    }
}
