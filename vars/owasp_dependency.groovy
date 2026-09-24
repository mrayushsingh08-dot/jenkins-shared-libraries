def call() {

    sh '''
        mkdir -p dependency-check-report

        dependency-check.sh \
          --scan . \
          --format XML \
          --format HTML \
          --out dependency-check-report \
          --disableVersionCheck \
          --project "Wanderlust"

    '''

    dependencyCheckPublisher(
        pattern: 'dependency-check-report/dependency-check-report.xml'
    )
}
