pipeline {
    agent any

    stages {
        stage('Initialize') {
            steps {
                // Get code from GitHub repository with given credentials
                checkout scmGit(branches: [[name: '*/main']], extensions: [], gitTool: 'jgit', userRemoteConfigs: [[credentialsId: 'a39c0acd-46bf-4298-ad5a-f17e4f86f198', url: 'git@github.com:alivetest/java-maven-helloworld.git/']])
            }
        }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"
                sh "mvn -B -DskipTest clean package"

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
