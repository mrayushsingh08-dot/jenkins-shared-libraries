def call() {
    dependencyCheck(
        additionalArguments: '--scan ./'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
