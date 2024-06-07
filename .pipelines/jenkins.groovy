pipeline {
    agent {
        node {
            label 'docker-agent-java17'
        }
    }
    stages {
        stage('Build') {
            steps {
                echo "Building.."
                sh '''
                mvn clean install -Dmaven.test.skip=true 
                '''
            }
        }
        stage('Test') {
            steps {
                echo "Testing.."
                sh '''
                mvn test
                '''
            }
        }
        stage('Deliver') {
            steps {
                echo 'Deliver....'
                sh '''
                echo "doing delivery stuff.."
                '''
            }
        }
    }
}