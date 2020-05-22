node {
   stage('SCM Checkout') {
      git 'https://github.com/olyasss/hotel'
   }
   stage('Cpmpile-Package') {
      sh 'mvn clean install'
   }
   script {
            def gitCommand = 'cp $WORKSPACE/target/*.war /opt/mvnplugintest/'
            runCommand(gitCommand)
    }
}
