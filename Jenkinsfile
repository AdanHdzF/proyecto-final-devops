pipeline {
	agent any

	triggers {
		githubPush()
	}

	stages {
		stage('Checkout') {
			steps {
				git branch: 'main', url: 'https://github.com/AdanHdzF/proyecto-final-devops.git'
			}
		}

		stage('Test') {
			steps {
				script {
					docker.build('proyectofinal:test', '--f Dockerfile.test .')
				}
			}
		}

		stage('Deploy') {
			steps {
				script {
					sh 'docker run -d --name proyectofinal_container proyectofinal:latest'
				}
			}
		}
	}	
}