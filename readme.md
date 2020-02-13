# Blocking Queue Implementation in Java

A blocking queue is defined as a queue which blocks the caller of the enqueue method if there's no more capacity to add the new item being enqueued. 
Similarly, the queue blocks the dequeue caller if there are no items in the queue. 
Also, the queue notifies a blocked enqueuing thread when space becomes available and a blocked dequeuing thread when an item becomes available in the queue. 

This source code is from [Java Multithreading for Senior Engineering Interviews](https://www.educative.io/courses/java-multithreading-for-senior-engineering-interviews) course on [Educative](https://www.educative.io).