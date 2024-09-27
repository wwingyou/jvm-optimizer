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
