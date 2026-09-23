def call() {

    timeout(time: 10, unit: 'MINUTES') {

        def qualityGate = waitForQualityGate()

        if (qualityGate.status != 'OK') {
            error "SonarQube Quality Gate failed: ${qualityGate.status}"
        }

        echo "SonarQube Quality Gate passed: ${qualityGate.status}"
    }
}
