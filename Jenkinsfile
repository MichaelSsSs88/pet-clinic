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
            stage('Deploy on staging area') {
                  steps{
                        build job: 'PipeLine Test Environment'
                  }

                        }
            /*stage('Deploy') {
                  steps {
                        echo "Deploying in Staging Area"
                  }
            }
            stage('Deploy Production') {
                  steps {
                        echo "Deploying in Production Area"
                  }
            }*/
      }
}