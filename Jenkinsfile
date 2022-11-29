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
        sh 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=pdrodavi_smartentry-springboot'
      }
    }

  }
  environment {
    SONAR_TOKEN = '32fc6c2f9fa88f384a575154811149f088838948'
  }
}