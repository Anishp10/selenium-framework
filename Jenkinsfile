pipeline {
    agent {
        docker {
            image 'maven:3.8.8-openjdk-11'
            args '--network=host'
        }
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn -B clean test -Dheadless=true'
            }
        }

        stage('Publish Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
                archiveArtifacts artifacts: 'target/surefire-reports/**', fingerprint: true
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
