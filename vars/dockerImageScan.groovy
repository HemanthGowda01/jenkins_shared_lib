// def call (String project, String ImageTag, String hubUser)
// {
//     sh """
//     trivy image ${hubUser}/${project}:latest > imagescanResult.txt
//     cat imagescanResult.txt
//     """
// }


def call (String aws_account_id, String region, String ecr_repoName)
{
    sh """

    
     trivy image  ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest > devDozeeBuild3.16.0result.txt
     cat devDozeeBuild3.16.0result.txt

    """
}