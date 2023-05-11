pipeline {
    agent any

    // tools {
        // Install the Maven version configured as "M3" and add it to the path.
        // maven "M3"
    // }

    stages {
        stage('Initialize') {
            steps {
                // echo 'Initialize pipeline'
                // Get code from GitHub repository with given credentials
                checkout scmGit(branches: [[name: '*/main']], extensions: [], gitTool: 'jgit', userRemoteConfigs: [[credentialsId: 'a39c0acd-46bf-4298-ad5a-f17e4f86f198', url: 'git@github.com:alivetest/java-maven-helloworld.git/']])
            }
        }
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                // git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                
                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"
                sh "mvn -B -DskipTets clean package"

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
                // failed, record the test results and archive the jar file.
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}
