def call() {
    sh 'mvn clean package'
}
def call() {
    sh 'mvn sonar:sonar'
}

def call() {
    sh 'mvn deploy'
}
def call() {
         sh """
             curl -u sai:dd \
              --upload-file /var/lib/jenkins/workspace/WQ/target/maven-web-application.war \
              "http://13.235.243.213:8080/manager/text/deploy?path=/maven-web-application&update=true"
              """
        }
