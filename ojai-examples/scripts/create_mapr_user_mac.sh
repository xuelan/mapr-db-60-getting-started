#!/bin/bash

sudo dscl . -create /Users/mapr
sudo dscl . -create /Users/mapr UserShell /bin/bash
sudo dscl . -create /Users/mapr RealName "mapr"
sudo dscl . -create /Users/mapr UniqueID "5000"
sudo dscl . -create /Users/mapr PrimaryGroupID 5000
sudo dscl . -create /Users/mapr NFSHomeDirectory /Users/mapr
sudo dscl . -passwd /Users/mapr password