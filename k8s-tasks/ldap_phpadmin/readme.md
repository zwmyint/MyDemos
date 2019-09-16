# This is a phpldapadmin demo project.

## Images

- osixia/openldap:1.2.5
- osixia/phpldapadmin:0.8.0

## Tips

1. If you donot want to expose a service, you should donot spec the targetPort.
2. Copy slapd.d to host volume before start the ldap pod.
3. Do not forget spec the env named PHPLDAPADMIN_LDAP_HOSTS and it value should be openldap, it should be the service name.


## Useful Commands

```
//Deploy app
kubectl apply -k .
//Undeploy app
kubectl delete -k .

kubectl get pod
kubectl get svc
kubectl get pv

kuectl logs <pod id>



//copy files from container to host

docker cp 7f658c572dd9:/etc/ldap/slapd.d /mnt/data/slapd/config
```
