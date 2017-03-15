# Documentation of biggy

# How to use?

### input [datasource, datadestination]

### store [datastorename]
* store -store [datastorename]
* store -index [data indextype]

### compute [data operation]
* compute -query [data operation]
* compute -analysis [data operation]

### control [configuration]

### output [data operation]
* output -visualize [data operation]
* output -share [data operation]

# Example
* install biggy project

	```./bigo.sh install biggy```
* manage [create, start, use, stop, delete, describe] biggy instance named bigo
      
      ```./bigo.sh [new, start, use, stop, delete, info] biggy bigo```
* input [feed, file] path_from path_to

      ```
      *TBD module*
      ./bigo.sh use biggy bigo
      using biggy bigo
      biggy>>> input [-feed, -file] data/source.xls data/destination.table
      input...
      *some excuting info here*
      inputed.
	  biggy>>> quit
      use biggy bigo end.
      ```
* store [create, delete] datastore

      ```
      ./bigo.sh use biggy bigo
      using biggy bigo
      biggy>>> store [-new, -delete] bigdb
      store...
      *some excuting info here*
      stored.
	  biggy>>> quit
      use biggy bigo end.
      ```
* compute [query, analysis] code_query

      ```
      ./bigo.sh use biggy bigo
      using biggy bigo
      biggy>>> compute [-query, -analysis] use dataverse bigdb; for $ds in dataset Metadata.Dataset return $ds
      compute...
      *some excuting info here*
      computed.
	  biggy>>> quit
      use biggy bigo end.
      ```
* control

      ```
      *BUILDIN module*
      ./bigo.sh use biggy bigo
      using biggy bigo
      biggy>>> control
      control...
      Built-in Module. NO Configuration!
      controlled.
	  biggy>>> quit
      use biggy bigo end.
      ```
* output [visual, share] path_data

      ```
      ./bigo.sh use biggy bigo
      using biggy bigo
      biggy>>> output -visual
      output...
      *some excuting info here*
      outputed.
	  biggy>>> quit
      use biggy bigo end.
      ```
      
# Five Parts

## INPUT
Data INPUT is to have continous data arrive into biggy from external sources and incrementally populate a persisted dataset and associated indexes.

### Data Feed
A simple way of having data being put into a biggy on a continuous basis is to have a single program fetch data from an external data source, parse the data, and then invoke an insert statement per record or batch of records.

## STORAGE
Data STORAGE is to store the data on physical storage devices.

### Data Storage
Data storage refers to the storage and management of large-scale datasets while achieving reliability and availability of data accessing.

### Data Index
Data index is an effective method to reduce the expense of disk reading and writing, and improve insertion, deletion, modification, and query speeds, while has the additional cost for storing index files which should be maintained dynamically when data is updated.

## COMPUTATION
Data COMPUTATION is to explore valuable information from persisted data by shallow query, data mining and deep learning.

### Data Query
Data query is the basic manupilations in biggy, such as sort, project, join in traditional databases. 

### Data Analysis
Data analysis can be from simple statistic to deep data mining technology.

## CONTROL
Data CONTROL is to make all the data management conducted without conflicts, faults and failures.

### Data Transaction
According to CAP theorem, it is not feasile for BDMS to fullfil ACID ( Atomic Consistent Isolation Durable) from traditional DB. However, BASE (Basic Availability Soft-state Eventual consistency) is an alternative.

### Data Recovery
Data recovery provides a robust and rapid recovery process when unexpectance happens.

## OUTPUT
Data OUTPUT provides a way to show the results.

### Data Visualization
Visualization helps us take deep look into the big data, which provides us a interactive and graphic way to embrase the inside of big data.

### Data Sharing
Data sharing helps to share the data easily.
