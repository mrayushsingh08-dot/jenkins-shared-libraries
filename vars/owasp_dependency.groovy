def call() {
    catchError(buildResult: 'SUCCESS', stageResult: 'UNSTABLE') {
        dependencyCheck(
            odcInstallation: 'OWASP',
            additionalArguments: '--scan ./ --noupdate'
        )

        dependencyCheckPublisher(
            pattern: '**/dependency-check-report.xml'
        )
    }
}
