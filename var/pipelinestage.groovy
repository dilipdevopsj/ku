def call() {
    git branch: 'dev',
        credentialsId: '047e0051-21a4-419a-8217-f8c646580ad9',
        url: 'https://github.com/dilipdevopsj/we.git'
}
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
        --upload-file target/maven-web-application.war \
        "http://13.235.243.213:8080/manager/text/deploy?path=/maven-web-application&update=true"
    """
}
