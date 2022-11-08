pipeline {
    agent any
    tools {
        maven 'M2_HOME'
        jdk 'JAVA_HOME'
    }
    environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.1.153:8081/repository/LocalNexusRepo1/"
        NEXUS_REPOSITORY = "LocalNexusRepo1"
        NEXUS_CREDENTIAL_ID = "NEXUS_CRED"
        registry = "yahiahj/jenkins-spring"
        registryCredential = 'dockerhub_id'
        dockerImage = ''
    }
    stages {
        stage('Git Pulling'){
            steps{
                 echo 'Pulling...';
                 git branch: 'Yahia' ,
                 url : 'https://github.com/khalillan/Devops.git'
                 
             }
         }
         stage('Cleaning..') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Compiling..') {
            steps {
                sh 'mvn compile'
            }
        }
        stage("build & SonarQube analysis") {
            steps {
                withSonarQubeEnv('Jenkins') {
                 sh 'mvn clean package sonar:sonar'
              }
            }
          }
        stage('build artifact'){
              steps{
                  sh 'mvn package'
              }
          }
        stage('deploy jar to nexus'){
              steps{
                  script{
                      
                      pom = readMavenPom file: "pom.xml";
                      filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                      echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                      artifactPath = filesByGlob[0].path;
                      artifactExists = fileExists artifactPath;
                      if(artifactExists) {
                          echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                          nexusArtifactUploader(
                              nexusVersion:NEXUS_VERSION,
                              protocol: NEXUS_PROTOCOL,
                              nexusUrl: NEXUS_URL,
                              groupId: pom.groupId,
                              version: pom.version,
                              repository: NEXUS_REPOSITORY,
                              credentialsId: NEXUS_CREDENTIAL_ID,
                              artifacts: [
                                  [artifactId: pom.artifactId,
                                  classifier: '',
                                  file: artifactPath,
                                  type: pom.packaging],
                                  [artifactId: pom.artifactId,
                                  classifier: '',
                                  file: "pom.xml",
                                  type: "pom"]
                              ]
                            );
                        } else {
                           error "*** File: ${artifactPath}, could not be found";
                        }
                    }
                }
            } 
        stage('Build Image'){
            steps{
                script{
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }

        }
        
        
    }      
          
    
}
