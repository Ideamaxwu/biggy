# biggy 
<p align="left">
  <img src="https://github.com/Ideamaxwu/biggy/blob/master/bigo.png" alt="bigo"/>
</p>
biggy - implementation of datar - universal architecture of data management

## What is datar?
keywords: *1 envisioned architecure; 3 features; 5 core functionalities*

From decades of practices and theories in the field of database management, we never stop liberating us from tedious and complicated management of (big) data. We envision a universal architecture of (big) data management, **datar**, to make one more step. The idea essentially comes from computer. *A datar is a set of coherent softewares/systems that can manage (big) data pluggablly, automatically and intelligently with specific functionalities, where specific functionalities refer to input, storage, compute, control and output of the (big) data.* 

<p align="center">
  <img src="https://github.com/Ideamaxwu/biggy/blob/master/computer.jpg" alt="computer architecture"/>
  <img src="https://github.com/Ideamaxwu/biggy/blob/master/datar.png" alt="datar architecture"/>
</p>

## What is biggy?
keywords: *implementation of datar*

To put the envisioned datar into practice, we implement it as **biggy**. biggy is based on AsterixDB with several other systems to fulfill the functions of input, storage, compute, control and output.

* input - data ETL&feed

* storage - data storage&index

* compute - data query&analysis&deep learning

* control - data transaction&recovery&scheduling

* output - data visualization&sharing

## How to make it work?
Currently, we plan to implement biggy based on [AsterixDB](https://github.com/apache/asterixdb), [BAD](https://github.com/apache/asterixdb-bad), [Spark-MLlib](https://github.com/apache/spark) and [d3](https://github.com/d3/d3). AsterixDB is the core component for data storage and control, BAD for data input, Spark-MLlib for data computation and d3 for data output. We make it more pluggable and automatical rather than just gluing them together. Further work of supporting most popular systems (e.g., TensorFlow) as plugins needs done with fullfilment of intelligency.

## References
* [Apache Maven](https://maven.apache.org/): A software project management and comprehension tool, and [source code](https://github.com/apache/maven). Ideas about auto project management.

* [Apache Beam](https://beam.apache.org/): An advanced unified programming model, and [source code](https://github.com/apache/beam). Ideas about End Users, SDK Writers and Runner Writers.

* [PingCAP](https://www.pingcap.com/index.html): Opensource NewSQL, and [source code](https://github.com/pingcap). Ideas about storage and computation seperation.

* [Apache Zeppelin](https://zeppelin.apache.org/), and [source code](https://github.com/apache/zeppelin). Ideas about interpreters.
