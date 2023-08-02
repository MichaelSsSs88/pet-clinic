pipeline {
      agent any
      stages {
            stage('Build Application') {
                  steps {
                        sh 'mvn clean package'
                        //echo 'Building Sample Maven Project'
                  }
                  post {
                      success{
                           echo "Now archiving the artifacts..."
                           archiveArtifacts artifacts: '**/*.war,**/*.jar'
                      }
                  }
            }
            stage('Create tomcat docker image') {
                              steps{
                                    sh "sudo docker build . -t tomcatwebapp:${env.BUILD_ID}"
                              }

                                    }
//             stage('Deploy on staging area') {
//                   steps{
//                         build job: 'PipeLine Test Environment'
//                   }
//
//                         }
//             stage('Deploy on prod area') {
//                               steps{
//
//                                     timeout(time:5, unit:'DAYS'){
//                                         input message: 'Approve PRODUCTION Deployment?'
//                                     }
//                                     build job: 'Pipeline Deployment Environment'
//                               }
//
//                                     }

      }
}