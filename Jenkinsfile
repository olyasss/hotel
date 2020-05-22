node {
   stage('SCM Checkout') {
      git 'https://github.com/olyasss/hotel'
   }
   stage('Cpmpile-Package') {
      sh 'mvn clean install'
      sh "cp $WORKSPACE/target/*.war /opt/mvnplugintest/"
   }
}
