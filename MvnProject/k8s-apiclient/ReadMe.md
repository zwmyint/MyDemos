#Tips


```
echo $KUBECONFIG
```

##How to package
```
mvn clean compile assembly:single
```

##How to execute?

```
java -jar k8s-api-1.0.jar
```

## How to build docker image

```
cp $(echo $KUBECONFIG) .
docker build -t waitplay/apiclient .
docker run --name apiclient waitplay/apiclient
```
 

