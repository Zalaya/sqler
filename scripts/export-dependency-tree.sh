#! /bin/bash

mvn -f ../backend dependency:tree > ../information/dependency-tree.txt
