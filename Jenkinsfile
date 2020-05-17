pipeline {
  agent {
    dockerfile {
      filename 'Dockerfile'
    }

  }
  stages {
    stage('maven-build') {
      steps {
        echo 'test pipeline'
      }
    }

    stage('docker-build') {
      steps {
        sh 'mvn clean install'
      }
    }

  }
}