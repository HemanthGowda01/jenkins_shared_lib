def call (String project, String ImageTag, String hubUser)
{
    sh """
    trivy image ${hubUser}/${project}:latest > imagescanResult.txt
    cat imagescanResult.txt
    """
}