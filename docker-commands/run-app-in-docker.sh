docker stop roma-app
docker rm roma-app
docker rmi roma-image
docker build -t roma-image .
# -d image name
#docker run --name roma-app -p 8082:8080 -d roma-image
docker run --name roma-app -p 8082:8080 -v myvol:/data -d roma-image
docker exec -t -i roma-app ls
docker exec -t -i roma-app ./mvnv --version
docker logs roma-app
# -t container name
docker exec -t -i roma-app /bin/sh

# docker.io - public registry name
#docker tag roma-image:latest docker.io/epamromakotov/app:v1
#docker tag k8s-training-user-service:latest epamromakotov/k8s-user-service:v1
#docker push epamromakotov/k8s-user-service:v1

#docker tag k8s-training-post-service:latest epamromakotov/k8s-post-service:v1
#docker push epamromakotov/k8s-post-service:v1

#docker push docker.io/epamromakotov/app:v1
#docker pull docker.io/epamromakotov/app:v1

#git remote add gitlab git@git.epam.com:Roman_Kotov/k8s-training.git
#git push -u gitlab main
