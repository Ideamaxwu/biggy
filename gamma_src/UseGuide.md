## How to make it run buglessly?

The basic workflow of biggy is 1) read engine configuration setups; 2) start utils include: BusKeeper, JetBrain; 3) start biggy instance; 4) add five modules; 5) show current engines info; 6)start Inception to dispatch; 7) run pipeJobs on your built BDMS with BigData dataflow; 8) close ALL. The above steps fall into three jumps: Setup as Configuration, Build your own BDMS, Run your pipeJobs on BigDataFlow.

* Java Execution Environment: JavaSE-1.8(jre1.8.0_111)

* Default config resources in resources/config/engine.conf

* cross origin problem can be sovled by --allow-file-access-from-files

* Maven pom spark-core version should compact with spark-mllib version, others same

* download, intall MongoDB and start service: C:\mongodb\bin\mongod --dbpath c:\data\db

* setup HADOOP_HOME by System Environmrnt Variables or by code

* solve cannot read lifecycle mapping problem by editing pom.xml

* explictly set maven compiler as 1.8 version in pom.xml if default is 1.5 without change

* DO NOT run two examples at once, because the MongoDBDriver close connection each time
