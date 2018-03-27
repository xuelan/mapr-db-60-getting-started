#!/bin/bash

# Needs mapr user with the same uid gid
sudo dscl . -create /Users/mapr
sudo dscl . -create /Users/mapr UserShell /bin/bash
sudo dscl . -create /Users/mapr RealName "mapr"
sudo dscl . -create /Users/mapr UniqueID "5000"
sudo dscl . -create /Users/mapr PrimaryGroupID 5000
sudo dscl . -create /Users/mapr NFSHomeDirectory /Users/mapr
sudo dscl . -passwd /Users/mapr password


# Needs the ticket locally
ssh root@psnode147 'cat /tmp/maprticket_5000' > /tmp/maprticket_5000

# Needs the conf files locally
mkdir /tmp/conf
ssh root@psnode147 'cat /opt/mapr/conf/cldb.conf' > /tmp/conf/cldb.conf
ssh root@psnode147 'cat /opt/mapr/conf/gateway.conf' > /tmp/conf/gateway.conf
ssh root@psnode147 'cat /opt/mapr/conf/mapr-clusters.conf' > /tmp/conf/mapr-clusters.conf
ssh root@psnode147 'cat /opt/mapr/conf/mapr.login.conf' > /tmp/conf/mapr.login.conf
ssh root@psnode147 'cat /opt/mapr/conf/mfs.conf' > /tmp/conf/mfs.conf
ssh root@psnode147 'cat /opt/mapr/conf/nfsserver.conf' > /tmp/conf/nfsserver.conf

