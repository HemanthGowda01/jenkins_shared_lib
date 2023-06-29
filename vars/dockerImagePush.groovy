// def call (String project, String ImageTag, String hubUser){
//     withCredentials([usernamePassword(
//         credentialsId: "docker", 
//         passwordVariable: "PASS", 
//         usernameVariable: "USER" )])
//         {
//             sh "docker login -u '$USER' -p '$PASS'"
//         }
//         sh "docker image push ${hubUser}/${project}:${ImageTag}"
//         sh "docker image push ${hubUser}/${project}:latest"
// }

// above is the code for docker hub related

import java.util.Random

def call (String aws_account_id, String region, String ecr_repoName)

{
    def random = new Random()
    def randomTag = "Build${random.nextInt(1000)}"

    sh """

    aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
    docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${randomTag}

    """
}