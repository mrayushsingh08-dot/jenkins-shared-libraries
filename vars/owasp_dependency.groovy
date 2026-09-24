def call() {

    dependencyCheck(
        odcInstallation: 'OWASP',
        additionalArguments: '''
            --scan .
            --format XML
            --format HTML
            --out dependency-check-report
            --disableOssIndex
        '''
    )

    dependencyCheckPublisher(
        pattern: 'dependency-check-report/dependency-check-report.xml'
    )
}
