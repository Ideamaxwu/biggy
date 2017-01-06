# biggy
biggy - implementation of datar - universal architecture of data management

## What is datar?
keywords: *1 envisioned architecure; 3 features; 5 core functionalities*

From decades of practices and theories in the field of database management, we never stop liberating us from tedious and complicated management of (big) data. We envision a universal architecture of (big) data management, **datar**, to make one more step. The idea essentially comes from computer. *A datar is a set of coherent softewares/systems that can manage (big) data pluggablly, automatically and intelligently with specific functionalities, where specific functionalities refer to input, storage, compute, control and output of the (big) data.* 

<p align="center">
  <img src="https://github.com/Ideamaxwu/biggy/blob/master/computer.jpg" alt="computer architecture"/>
  <img src="https://github.com/Ideamaxwu/biggy/blob/master/datar.jpg" alt="datar architecture"/>
</p>

## What is biggy?
keywords: *implementation of datar*

To put the envisioned datar into practice, we implement it as **biggy**. biggy is based on AsterixDB with several other systems to fulfill the functions of input, storage, compute, control and output.

* input - data ETL&feed

* storage - data storage&index

* compute - data query&analysis

* control - data transaction&recovery

* output - data visualization&sharing

