# ⚡️ JVM Optimizer

Optimize JVM for web service using machine learning.

## Target JVM Parameters

### Heap Size

The range of heap size is 2GB ~ 4GB. Interval is 200MB.

- `-Xms<heap size>[unit]`: minimal heap size
- `-Xmx<heap size>[unit]`: maximal heap size

### Metaspace Size

The range of metaspace size is 128MB ~ 512MB. Interval is 64MB.

- `-XX:MaxMetaspaceSize=<metaspace size>[unit]`: maximal metaspace size

### New Generation Size

The range of young generation size is 0.125 * heap_size ~ 0.375 * heap_size.
Interval is 0.025%.

- `-XX:NewSize=<young size>[unit]`: minimal new generation size
- `-XX:MaxNewSize=<young size>[unit]`: maximal new generation size

## Context Parameters

### Container Resource Restriction

Same as JVM heap size. (2GB ~ 4GB)

### Database Connections

From 5 to 20

### Processor Performance

### Network Round-Trip Time

## Target Performance

Target performance is measured by p95, p99 value.

## Time

there's 9000 different type of predefined parameters. If each case take 5
minutes, 9000 * 5 / 24 / 60 = 31.25 day is needed.

### Default settings

These are important garbage collector, heap size, and runtime compiler default selections: 

- Garbage-First (G1) Collector
- The maximum number of GC threads is limited by heap size and available CPU resources 
- Initial heap size of 1/64 of physical memory 
- Maximum heap size of 1/4 of physical memory 
- Tiered compiler, using both C1 and C2

## Behavior-Based Tuning
The Java HotSpot VM garbage collectors can be configured to preferentially meet one of two goals: maximum pause-time and application throughput. If the preferred goal is met, the collectors will try to maximize the other. Naturally, these goals can't always be met: Applications require a minimum heap to hold at least all of the live data, and other configuration might preclude reaching some or all of the desired goals.

### Maximum Pause-Time Goal
The pause time is the duration during which the garbage collector stops the application and recovers space that's no longer in use. The intent of the maximum pause-time goal is to limit the longest of these pauses.

An average time for pauses and a variance on that average is maintained by the garbage collector. The average is taken from the start of the execution, but it's weighted so that more recent pauses count more heavily. If the average plus the variance of the pause-time is greater than the maximum pause-time goal, then the garbage collector considers that the goal isn't being met.

The maximum pause-time goal is specified with the command-line option -XX:MaxGCPauseMillis=<nnn>. This is interpreted as a hint to the garbage collector that a pause-time of <nnn> milliseconds or fewer is desired. The garbage collector adjusts the Java heap size and other parameters related to garbage collection in an attempt to keep garbage collection pauses shorter than <nnn> milliseconds. The default for the maximum pause-time goal varies by collector. These adjustments may cause garbage collection to occur more frequently, reducing the overall throughput of the application. In some cases, though, the desired pause-time goal can't be met.

### Throughput Goal
The throughput goal is measured in terms of the time spent collecting garbage, and the time spent outside of garbage collection is the application time.

The goal is specified by the command-line option -XX:GCTimeRatio=nnn. The ratio of garbage collection time to application time is 1/ (1+nnn). For example, -XX:GCTimeRatio=19 sets a goal of 1/20th or 5% of the total time for garbage collection.

The time spent in garbage collection is the total time for all garbage collection induced pauses. If the throughput goal isn't being met, then one possible action for the garbage collector is to increase the size of the heap so that the time spent in the application between collection pauses can be longer.

### Footprint
If the throughput and maximum pause-time goals have been met, then the garbage collector reduces the size of the heap until one of the goals (invariably the throughput goal) can't be met. The minimum and maximum heap sizes that the garbage collector can use can be set using -Xms=<nnn> and -Xmx=<mmm> for minimum and maximum heap size respectively.

### Default Option Values for Heap Size
By default, the virtual machine grows or shrinks the heap at each collection to try to keep the proportion of free space to live objects at each collection within a specific range.

This target range is set as a percentage by the options -XX:MinHeapFreeRatio=<minimum> and -XX:MaxHeapFreeRatio=<maximum>, and the total size is bounded below by –Xms<min> and above by –Xmx<max>.

With these options, if the percent of free space in a generation falls below 40%, then the generation expands to maintain 40% free space, up to the maximum allowed size of the generation. Similarly, if the free space exceeds 70%, then the generation contracts so that only 70% of the space is free, subject to the minimum size of the generation.

- `-Xms`: 125m (1/4 of max heap size growing to 1/1, step 1/4) -> 4
- `-Xmx`: 800m (600m ~ 2g, step 200m) -> 7
- `-XX:MinHeapFreeRatio`: 40 (30 ~ 50, step 10) -> 3
- `-XX:MaxHeapFreeRatio`: 70 (60 ~ 80, step 10) -> 3
- `-XX:NewRatio`: 2 (2 ~ 4, step 1) -> 3
- `-XX:SurvivorRatio`: 8 (7 ~ 9, step 1) -> 3
- request speed: 1 ~ 3 -> 3

4 * 7 * 3 * 3 * 3 * 3 * 3 = 6,804

## Result Note

Collected data shows that all parameters has linear relation with performance.
But one wiered thing is that performance declines as heap size grow. It is
opposite of my expectation. One interasting notice is that the ratio between min
and max heap size determines the decline ratio of graph, which makes graph as I
expected when min and max heap size ratio is 1 to 4. It seems like as max heap
size is bigger than min heap size, the graph changes as heap size grows,
performance got better. I don't know why.

I think the problem is that sticking min and max size of the heap makes JVM
harder to mainpulate the ratio of gc generations.

## Insufficient points

1. Dataset is too small
