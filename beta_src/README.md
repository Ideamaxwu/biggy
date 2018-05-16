# Abstract

NO clues how to architect the project :(

downside-up seems working great :) update on 2018/05/08

# Keep in Mind

Q: how to build a software/system from scratch?

A: make it work then make it perfect. aka, practice makes perfect.

# Goals in BETA version

* seperate modules & add necessary modules

* glue together first

* from standalone to cluster

* abstraction and reconstraction in the loop

# Code Structures
	bigo		- biggy instance
	clients		- interactive Web/Desktop clients
	engines		- runtime Input/Storage/Computation/Control/Output execution engines, e.g., Spark, HBase
	bEngines	- new original engines for biggy
	framework	- biggy framework including
					- cores: engine-wrapper-related classes 
					- datamodel: data model based on proactor
					- inception: compiler-like Inception, job-schedule-like Dispatcher 
					- pipeline: dataflow among engines
					- scripts: scripts to run runtime engine after pipeline
					- utils: deployment settings Configuration, context information manager BusKeeper
	SDKs		- SDKs for developer users, e.g., Python
	examples	- examples for using biggy

# Ways to get there

## Clean Code (notes of the name-same book)

* Bad Code: the only valid measurement of code quality: WTFs/minute

* I can teach you the physics of riding a bicycle, prove to you that bicycle riding is practical, and you'd still fall down the first time you cliembed on that bike. Coding is no different.

* LeBalanc's law: Later equals never.

* Meaningful Names: elapsedTimeInDays; IShapeFactory; class names should have noun (Account) not verb (Processor); methods names should have verb phrases (deletePage).

* Functions: first rule of functions is small; do one thing well and only; too many arguments should be wrapped into class.

* Comments: don't comment bad code, rewrite it; warning of consequences; TODO; Mandated/Journal Comments; don't use a comment when you can use a function or a viariable; commented-out code is odious.

* Formatting: .

* Objects and Data Structures: data abstraction; Law of Demeter.

* Error Handling: try-catch-finnaly.

* Boundries: .

* Unit Tests: three laws of TDD.

* Classes: .

* Systems: .

* Emergency: .

* Concurrency: objects are abstractions of processing, and threads are abstractions of schedule.

* Successive Refinement: never let the rot get started.

* JUnit Internals: .

* Refactoring SerialDate: .

* Smells and Heuristics: .

## [A Build System for Complex Projects](http://www.drdobbs.com/tools/a-build-system-for-complex-projects-part/218400678)
seems no help :)

## UML
Unified Modeling Language for Class/Objects/Component/Deployment/UserCase/Interaction/StateChart/Activity Diagram

## Cluster Scheduling
[blog1](https://zhuanlan.zhihu.com/p/34492335), [blog1 in  English](http://www.firmament.io/blog/scheduler-architectures.html),  [blog2](https://zhuanlan.zhihu.com/p/33823266)

* Resources Manager - YARN

* Job Scheduler - Mesos

* States Monitor - Kubernetes, Omega

* Centralized, Distributed, Two-tier, Hybrid

## Related Work

* Operating System Support for Warehouse-scale Computing, Malte Schwarzkopf

* The Datacenter Needs an Operating System, Matei Zaharia
