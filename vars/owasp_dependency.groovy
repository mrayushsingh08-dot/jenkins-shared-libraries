def call() {

    try {

        echo "Starting OWASP Dependency-Check..."

        dependencyCheck(
            odcInstallation: 'OWASP',
            additionalArguments: '--scan ./ --format XML --out ./dependency-check-report --noupdate'
        )

        dependencyCheckPublisher(
            pattern: '**/dependency-check-report.xml',
            failedTotalCritical: 999999,
            failedTotalHigh: 999999,
            failedTotalMedium: 999999,
            failedTotalLow: 999999
        )

        echo "OWASP Dependency-Check completed."

    } catch (Exception e) {

        echo "WARNING: OWASP Dependency-Check failed."
        echo "Reason: ${e.message}"
        echo "Continuing pipeline..."

    }
}
