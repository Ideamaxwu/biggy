# These are some examples using biggy to build your own BDMS.

## Guide for Framework Writers
how to contribute to the biggy framework?

biggy Framework includes important implementation for datar architecture,  `core` for engine-wrapper-related classes, `inception` for compiler-like component, `utils` for utilities used for framework. Framework Writers can pull request for better coding or minor structural modifications BUT NO major changes to break the design of the five datar functionalities.

## Guide for Engine Writers
how to add a runtime engine?

biggy framework provide *pluggability* for Engine Writers to add your favorite runtime engine. In `biggy.engines.*****` (e.g., `biggy.engines.computation`), implement `*****Engine*****` (e.g., `ComputationEngineSpark`) extends from `*****Wrapper` (e.g., `ComputationWrapper`). Then create class `*****Engine` (e.g., `SparkEngine`) to implement your favorite runtime engine. Job execution can work by `*****Job` (e.g., `SparkClusterJob`). Engine Writers don't need to worry the underneath in biggy framework and focus on how to add your engine.

## Guide for SDKs Writers
how to inject a programming language?

biggy support several popular languages, e.g., Java, Python. We encourage SDKs Writers to inject your familar language for the community of the same.

## Guide for End Users
how to use your built BDMS?

We provide an interactive interface for End Users to configurate, deploy, build and use your own BDMS. Also, command line interface is supported.

### Standalone HelloWorld

### Cluster WordCount