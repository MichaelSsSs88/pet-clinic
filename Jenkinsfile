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
                                    sh "docker rm -f tomcatwebapp"
                                    sh "docker rmi -f tomcatwebapp"
                                    sh "docker build . -t tomcatwebapp"
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


      //       post{
      //             success{
      //                         echo "Post step: Running docker file"
      //                         sh "docker run -d -p 8090:8080 tomcatwebapp:${env.BUILD_ID}"
      //             }
      //
      //       }
}