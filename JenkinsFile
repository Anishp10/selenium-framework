pipeline {
  agent {
    docker { image 'maven:3.8.8-openjdk-11' args '--network=host' }
  }

  environment {
    // keeps local maven repo inside workspace to speed up builds
    MAVEN_OPTS = "-Dmaven.repo.local=.m2"
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build & Test') {
      steps {
        // run tests; pass headless property - your DriverFactory should read it via System.getProperty("headless")
        sh 'mvn -B clean test -Dheadless=true'
      }
    }

    stage('Publish Results') {
      steps {
        junit 'target/surefire-reports/*.xml'            // reads surefire XMLs
        archiveArtifacts artifacts: 'target/surefire-reports/**', fingerprint: true
      }
    }
  }

  post {
    always {
      cleanWs()
    }
    failure {
      echo "Build failed — check console output and junit report"
    }
  }
}
