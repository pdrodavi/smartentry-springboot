pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git(url: 'https://github.com/pdrodavi/smartentry-springboot.git', changelog: true, branch: 'pipeblue')
      }
    }

    stage('Scanner') {
      agent any
      steps {
        withSonarQubeEnv(envOnly: true, installationName: 'SONAR_SCANNER')
      }
    }

  }
  environment {
    SONAR_TOKEN = '32fc6c2f9fa88f384a575154811149f088838948'
  }
}