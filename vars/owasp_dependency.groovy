def call() {

    sh 'mkdir -p dependency-check-report'

    dependencyCheck(
        odcInstallation: 'OWASP',
        nvdCredentialsId: 'nvd-api-key',
        additionalArguments: '''
            --scan .
            --format XML
            --format HTML
            --out dependency-check-report
            --disableVersionCheck
        '''
    )

    dependencyCheckPublisher(
        pattern: 'dependency-check-report/dependency-check-report.xml',
        skipNoReportFiles: false
    )
}
