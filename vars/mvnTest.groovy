def call(){
    
    sh 'mvn clean install -U'
    sh 'mvn test'


}