job('First-Maven-Project-Via-DSL') {
    description("First Maven job generated by the DSL on ${new Date()}, the project is a small maven hosted on github")
    scm {
        git('https://github.com/MichaelSsSs88/pet-clinic.git', 'master')
    }
    triggers {
        scm('* * * * *')
    }
    steps {
            maven {
                goals('clean')
                goals('verify')
                goals('package')
                mavenOpts('-Xms256m')
                mavenOpts('-Xmx512m')
                localRepository(LocalRepositoryLocation.LOCAL_TO_WORKSPACE)
                mavenInstallation('Maven 3.9.3')
                providedSettings('central-mirror')
            }
            maven('verify')
            maven('clean package', 'First-Maven-Project-Via-DSL/pom.xml')
            maven('clean package', 'First-Maven-Project-Via-DSL/pet-clinic-data/pom.xml')
            maven('clean package', 'First-Maven-Project-Via-DSL/pet-clinic-web/pom.xml' )
        }
        publishers {
            archiveArtifacts '**/*.war,**/*.jar'
        }
}
