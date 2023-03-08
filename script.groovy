def buildJar() {
    echo "Building jar file..."
    sh 'mvn package'
}

def pushImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'PASS', usernameVariable: 'USER'  )])
        sh 'docker build -t aborzymdocker/demo-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push aborzymdocker/demo-app:jma-2.0'
}

def deployApp(){
    echo 'deploying the application'
}

return this