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
	bEngines	- new original engines for biggy, including BDIO, Oracle, Abacus
	framework	- biggy framework including
					- inception: compiler-like Inception, job-schedule-like Dispatcher 
					- datamodel: data model BigData based on proactor with Action and Transform
					- pipeline: dataflow among engines
					- confchain: - cores of engine-wrapper-related classes with the chain 
					- scripts: scripts to run runtime engine after pipeline
					- utils: deployment settings EngineConfig, context information manager BusKeeper, self-driving intelligent JetBrain, NettyNet
	engines		- runtime Input/Storage/Computation/Control/Output execution engines, e.g., Spark, HBase
	pipelines	- customized pipes, jobs and utils
	SDKs		- SDKs for developer users, e.g., Python
	examples	- examples for using biggy, WordCount, Sort, KMeans, PageRank

# References

[#100DaysOfCode](http://100daysofcode.com/)

[UserGuide](https://github.com/Ideamaxwu/biggy/blob/master/gamma_src/UseGuide.md) for biggy