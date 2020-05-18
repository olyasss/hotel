node {
   stage('SCM Checkout') {
      git 'https://github.com/olyasss/hotel'
   }
   stage('Cpmpile-Package') {
      sh 'mvn clean install'
   }
   stage('Post Steps') {
      sh 'cp /var/lib/jenkins/workspace/pipeFirst/target/*.jar /opt/hotel'
   }
}
