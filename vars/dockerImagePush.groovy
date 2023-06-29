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

import java.text.SimpleDateFormat
import java.util.Date

def call (String aws_account_id, String region, String ecr_repoName)

{
   def timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
   def version = "build-${timestamp}"

    sh """

    aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
    docker tag ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${version}
    docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${version}

    """
}