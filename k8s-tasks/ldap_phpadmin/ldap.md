docker volume create ldap-vol

docker volume inspect ldap-vol


docker rm $(docker stop $(docker ps -a | grep ldap))


docker run -p 8389:389 -p 6636:636 --name ldap-service --hostname ldap-service --detach osixia/openldap:1.2.5

docker exec ldap-service ldapsearch -x -H ldap://localhost -b dc=example,dc=org -D "cn=admin,dc=example,dc=org" -w admin

docker run -p 8636:443 --name phpldapadmin-service --hostname phpldapadmin-service --link ldap-service:ldap-host --env PHPLDAPADMIN_LDAP_HOSTS=ldap-host --detach osixia/phpldapadmin:0.8.0

https://9.30.246.163:8636
dn: cn=admin,dc=example,dc=org /admin



uid=ben,ou=people,dc=example,dc=org


# Entry 1: uid=bob,ou=people,dc=example,dc=org
dn: uid=bob,ou=people,dc=example,dc=org
cn: Ben Alex
objectclass: inetOrgPerson
objectclass: organizationalPerson
objectclass: person
objectclass: top
sn: Alex
uid: bob
userpassword: {SHA}W6ph5Mm5Pz8GgiULbPgzG37mj9g=