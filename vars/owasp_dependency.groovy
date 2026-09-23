def call() {
    withCredentials([
        string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')
    ]) {
        // catchError build status ko success/unstable rakhta hai taaki next stages block na hon
        catchError(buildResult: 'SUCCESS', stageResult: 'UNSTABLE') {
            dependencyCheck(
                odcInstallation: 'OWASP',
                additionalArguments: "--scan ./ --nvdApiKey ${NVD_API_KEY} --noupdate"
            )

            dependencyCheckPublisher(
                pattern: '**/dependency-check-report.xml'
            )
        }
    }
}
