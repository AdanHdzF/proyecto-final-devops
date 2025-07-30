pipeline {
	agent any

	environment {
		PATH = "${env.PATH}:/usr/local/bin"
		IMAGE_NAME = 'proyectofinal'
		IMAGE_NAME_TEST = 'proyectofinaltesting'
		DOCKER_USERNAME = 'adanhf'
		DOCKER_CREDENTIALS = 'docker-hub-credentials'
		DOCKER_IMAGE = "${DOCKER_USERNAME}/${IMAGE_NAME}"
	}

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
					docker.build(IMAGE_NAME_TEST, '-f=Dockerfile.test .')
				}
			}
		}

		stage('Deploy') {
			steps {
				script {
					docker.build(DOCKER_IMAGE, '.')
				}
			}
		}
	}	
}