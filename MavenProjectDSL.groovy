job('First-Maven-Project-Via-DSL'){
    description("First Maven job generated by the DSL on ${new Date()}, the project is a small maven hosted on github")
    scm{
        git("git@github.com:MichaelSsSs88/pet-clinic.git", master)
    }
    triggers{
        scm('* * * * *')
    }
    steps{
        maven('clean package', 'pom.xml')
    }
    publishers{
        archiveArtifacts '**/*.war',
        archiveArtifacts '**/*.jar'
    }
}