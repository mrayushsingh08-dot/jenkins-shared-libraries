def call() {

timeout(time: 10, unit: 'MINUTES') {

    try {
        def qualityGate = waitForQualityGate(abortPipeline: false)

        if (qualityGate.status != 'OK') {
            unstable "SonarQube Quality Gate: ${qualityGate.status}"
            echo "SonarQube Quality Gate did not pass, but pipeline will continue."
        } else {
            echo "SonarQube Quality Gate passed: ${qualityGate.status}"
        }

    } catch (Exception e) {
        echo "SonarQube Quality Gate check failed: ${e.message}"
        echo "Continuing pipeline..."
    }
}


}
