#!/bin/bash

# Useful links :
# https://community.mapr.com/thread/22280-maprdb-jsoncan-an-application-connect-without-mapr-client
# https://community.mapr.com/docs/DOC-1420

export MAPR_TICKETFILE_LOCATION=/tmp/maprticket_5000

java -Dhadoop.login=mapr -Dhadoop.login=hybrid -Dzookeeper.saslprovider=com.mapr.security.maprsasl.MaprSaslProvider -Dmapr.home.dir=/tmp/ -Djava.security.auth.login.config=/tmp/conf/mapr.login.conf -cp "/Users/xuelansun/Git/mapr-db-60-getting-started/ojai-examples/target/*"  com.mapr.db.examples.OJAI_001_YelpSimpleQuery