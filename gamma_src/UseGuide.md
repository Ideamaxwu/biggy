## How to make it run buglessly?

The basic workflow of biggy is 1) read engine configuration setups; 2) start utils include: BusKeeper, JetBrain; 3) start biggy instance; 4) add five modules; 5) show current engines info; 6)start Inception to dispatch; 7) run pipeJobs on your built BDMS; 8) close ALL. The above steps fall into three jumps: Setup as Configuration, Build your own BDMS, Run your pipeJobs.

* Java Execution Environment: JavaSE-1.8(jre1.8.0_111)

* Default config resources in resources/config/engine.conf