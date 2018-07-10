*In theory, there is no difference between theory and practice; in practice, there is. — Chuck Reid*

# Goals in R version

* clean code - abstraction and reconstruction

* standalone to cluster

* self-driving system management

* existing engines support and multi-OS support

* Optimizaition of BigData, NettyNet, JetBrain, Clients, etc.

* Ready to rELEASE

# Code Structures
	bigo		- biggy instance, assembling BusKeeper, JetBrain, Server
	clients		- interactive Web/Desktop clients
	engines		- runtime Input/Storage/Computation/Control/Output execution engines, e.g., Spark, HBase
	bEngines	- new original engines for biggy, including BDIO, Oracle, Abacus
	framework	- biggy framework including
					- cores: engine-wrapper-related classes 
					- datamodel: data model BigData based on proactor with Action and Transform
					- inception: compiler-like Inception, job-schedule-like Dispatcher 
					- pipeline: dataflow among engines
					- scripts: scripts to run runtime engine after pipeline
					- utils: deployment settings EngineConfig, context information manager BusKeeper, self-driving intelligent JetBrain, NettyNet
	pipelines	- customized pipes, jobs and utils
	SDKs		- SDKs for developer users, e.g., Python
	examples	- examples for using biggy, WordCount, Sort, KMeans, PageRank
	
# changes

* //put BusKeeper, JetBrain into InstanceBDMS
* put addEngine into ConfChain
* concrete HeartBeat
* concrete NettyNet
* //delete or reconstruct Inception package, or move it into CliClient
* abstract Pipeline
* //remove Example Experiment code
* concrete Scheduler
* //edit jobs comments
* //abstract pipes and jobs
* //delete WordCount example
* //add Control module into framework instance
* //update EngineFactory to switch case default
* update Actor and Tranform operators to invoking
* make sense of StateMachine
* implement clients
* //update comments in Examples
* //fix bugs in Examples

# References

[#100DaysOfCode](http://100daysofcode.com/)