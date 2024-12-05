pipeline {
    agent any
    tools {
        maven 'Maven 3.9.9'  // Use the name configured in Global Tool Configuration
    }

    stages {
        stage('Initialize') {
            steps {
                // Get code from GitHub repository with given credentials
                git url: 'https://github.com/akhila6522/java-maven-helloworld.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"
                sh "mvn clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            post {
                success {
                    // On success builds the package jar file will archive
                    archiveArtifacts 'target/first-maven*.jar'
                }
            }
        }
        stage('Test') {
            steps {
                // Run Maven's tests 
                sh 'mvn test'
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results.
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}
