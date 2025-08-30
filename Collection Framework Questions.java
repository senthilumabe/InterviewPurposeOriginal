1.How HashMap works internally?
=============================

=> In Java, a HashMap stores key–value pairs internally using an array of buckets. 
=> When we put an entry, it first calls the key’s hashCode() to compute a hash value, which is then mapped to an index in the bucket array. 
=> If the bucket is empty, the entry is stored directly. If there is already an entry, a collision occurs, and then the map checks keys using equals(). 
=> If the key already exists, the value is updated; otherwise, the new entry is added to the same bucket, forming a linked list. 
=> Since Java 8, if too many collisions happen in a bucket (more than 8 entries), the list is converted into a balanced Red-Black Tree for faster lookups. On retrieval, the same process happens: hashCode() finds the bucket, and then equals() checks for the exact key. 
=> HashMap automatically resizes (doubles its capacity) when the number of entries crosses the load factor threshold (default 0.75) to maintain performance. 
=> In terms of complexity, operations are O(1) on average, but can degrade to O(log n) if a tree is used or O(n) in the worst case of excessive collisions.

##########################################################################################################################
2.Collection Frameworks explain
================================
=> Collection framework implements various interfaces, Collection interface and Map interface (java.util.Map) are the mainly used interfaces of Java Collection Framework. 
List of interfaces of Collection Framework is given below:

1. Collection interface:
-------------------------
=> This is the collection hierarchy's base interface. 
=> Its elements are a collection of items that it represents. 
=> Duplicate elements may be found in collections, and elemental orders may change. 
=> Commonly used classes like ArrayList, LinkedList, and HashSet are examples of implementations of this interface.
Syntax:
---------
public interface Collection<E>extends Iterable  
Where <E> represents that this interface is of Generic type

2. List interface:
-------------------
=> The list extends the Collection interface and represents an ordered collection of elements. 
=> It allows duplicate elements and provides methods to access elements by their index. 
=> Implementations of the List interface include ArrayList, LinkedList, and Vector.
Syntax:
-------
public interface List<E> extends Collection<E> 
 
3. Set interface:
-----------------
=> A collection that is incapable of having duplicate elements is represented by a set, which expands on the Collection interface. 
=> It does not ensure the components' order; instead, it simulates the abstraction of a mathematical set. 
=> HashSet, TreeSet, and LinkedHashSet implement the Set interface.
Syntax:
-------
public interface Set<E> extends Collection<E> 
 
4. Queue interface:
--------------------
=> A queue is a collection intended to keep things before they are processed, and it extends the Collection interface. 
=> Its elements are arranged in FIFO (First-In-First-Out) order. The Queue interface is implemented by LinkedList, PriorityQueue, and ArrayDeque.
Syntax:
-------
public interface Queue<E> extends Collection<E>
  
5. Deque Interface
-------------------
=> Deque stands for "Double Ended Queue" and extends the Queue interface. 
=> It represents a linear collection that supports element insertion and removal at both ends. 
=> Deques can function as standard queues (FIFO) as well as stacks (LIFO). 
=> Implementations of the Deque interface include LinkedList and ArrayDeque.
Syntax:
-------
public interface Dequeue<E> extends Queue<E>  

5. Map interface:
-----------------
=> The Map interface does not extend the Collection interface, in contrast to other collection interfaces. 
=> It shows a mapping of keys to values in which a single value is connected to each key. 
=> HashMap, TreeMap, and LinkedHashMap are examples of map implementations. 
=> Furthermore, a map that retains its keys in ascending order is provided by the SortedMap interface, which extends Map.
Syntax
------
public interface Map<K, V> {}  

##########################################################################################################################
3. Explain HashMap vs LinkedHashMap vs TreeMap and also explain concurrentHashMap
===============================================
🔹 HashMap
-----------
=> A HashMap is an implementation of the Map interface that Stores key–value pairs using hashing and does not guarantee any order of keys.
=> It allows one null key and multiple null values, and provides O(1) average time complexity for insertion and lookup.
=> Uses hashing (hashCode() + equals()).

Use when: You only care about fast lookups and don’t need ordering.
---------

🔹 LinkedHashMap
-----------------
=> A LinkedHashMap is a subclass of HashMap that maintains a doubly-linked list of entries which preserves the insertion order of keys, or access order if configured, making iteration predictable.
=> It also allows one null key and multiple null values, but has slightly more overhead than HashMap
=> Preserves insertion order (or access order if configured with accessOrder=true).
=> Slightly slower than HashMap due to the overhead of maintaining order.
Use when: You need predictable iteration order (e.g., caching).
---------

🔹 TreeMap
===========
=> It maintains elements in ascending order	
=> It implements using a tree structure
=> It can be sorted by key only.
=> It cannot have a null key but can have multiple null values.
=> It uses a red-black tree for storage and retrieval.
Use when: You need sorted keys or ordered operations.
---------
concurrentHashMap
==================
=> A ConcurrentHashMap is a thread-safe variant of HashMap that implements the ConcurrentMap interface.

=> It is designed for concurrent access without needing external synchronization.

=> Does not allow null keys and does not allow null values (to avoid ambiguity in multi-threaded access).

=> Iterators of ConcurrentHashMap are fail-safe, so they do not throw exceptions even if the map is modified during iteration (but changes may or may not be reflected immediately).

=> Internally, Java 7 used segment-level locking (dividing map into segments), while Java 8 improved it with a bucket-level (fine-grained) locking + CAS operations for better concurrency.

=> Provides O(1) average performance with safe concurrent modifications.

=> Best suited for multi-threaded environments where thread safety and high performance are required.
##########################################################################################################################
4.HashSet vs LinkedHashSet vs TreeSet
======================================
HashSet:
========
=> A HashSet is a collection that stores only unique values and implements the Set interface.

=> It maintains no specific order of elements.

=> It cannot contain duplicate elements and allows at most one null value.

=> Iteration in a HashSet is straightforward since it directly stores values.

=> Internally, it is implemented using a hash table.

=> It provides O(1) average time performance for add, remove, and lookup operations.

LinkedHashSet:
==============
=> A LinkedHashSet is a subclass of HashSet that also stores only unique values and implements the Set interface.

=> It maintains elements in the insertion order using a doubly-linked list.

=> It cannot contain duplicate elements and allows at most one null value.

=> Iteration in a LinkedHashSet is predictable because it follows insertion order.

I=> nternally, it is implemented using a hash table with a linked list running through it.

=> It provides O(1) average time performance, with a slight overhead compared to HashSet due to maintaining order.

TreeSet:
=========

=> A TreeSet is a collection that stores only unique values and implements the NavigableSet interface.

=> It maintains elements in sorted (ascending) order by default, or based on a custom comparator.

=> It cannot contain duplicate elements and does not allow null values (throws NullPointerException).

=> Iteration in a TreeSet is predictable because it always follows the sorted order of elements.

=> Internally, it is implemented using a Red-Black Tree (self-balancing binary search tree).

=> It provides O(log n) time complexity for add, remove, and lookup operations.

#########################################################################################################################
5. What is fail-fast and fail-safe iterator
============================================
Fail-Fast Iterators:
=====================

=> Fail-fast iterators operate directly on the collection.

=> If the collection is structurally modified (add/remove element) after the iterator is created, they throw a ConcurrentModificationException.

=> They do not make a copy of the collection, so they are not thread-safe.

Example collections: ArrayList, HashMap, HashSet, LinkedList.
--------------------
=> Fail-fast behavior is implemented using a modCount check inside the iterator.

=> Performance is faster, but not safe for concurrent modifications.

Fail-Safe Iterators:
======================
=> Fail-safe iterators operate on a copy of the collection (usually a clone).

=> If the collection is structurally modified while iterating, they do not throw exceptions since iteration happens over the copy.

=> They are thread-safe but changes made during iteration are not reflected in the iterator.

Example collections: ConcurrentHashMap, CopyOnWriteArrayList.
-------------------
=> Implemented using techniques like copy-on-write or snapshot iteration.

=> Performance is slower compared to fail-fast, due to extra memory usage for copies.

#########################################################################################################################
6.Explain ArrayList and CopyOnWriteArrayList
=============================================
=> ArrayList uses a dynamic array. which means its resizable array. it is the implementation of List.
=> It is not thread-safe, so concurrent modifications from multiple threads can cause ConcurrentModificationException.

Iterators of ArrayList are fail-fast, meaning they throw exceptions if the list is structurally modified while iterating.

Allows null values and duplicates.

Provides O(1) average performance for random access (get/set) and O(n) for add/remove (due to shifting elements).

Internally, it uses a dynamic array that grows automatically when capacity is exceeded.

Best suited for single-threaded applications where fast random access is required.

CopyOnWriteArrayList:
=====================

=> A CopyOnWriteArrayList is a thread-safe variant of ArrayList that implements the List interface.

=> It is safe for concurrent modifications because every write operation (add/remove/set) creates a new copy of the underlying array.

=> Iterators of CopyOnWriteArrayList are fail-safe, meaning they do not throw exceptions if the list is modified during iteration, but changes are not reflected in the iterator.

=> Allows null values and duplicates, like ArrayList.

=> Provides O(1) for random access, but write operations (add/remove) are more expensive due to array copying.

=> Internally, it uses the copy-on-write technique, which trades memory and write performance for safe concurrent reads.

=> Best suited for multi-threaded applications where reads are frequent and writes are infrequent (e.g., caching, observer lists).

##########################################################################################################################
7.PriorityQueue — internal working
==================================
=> A PriorityQueue in Java is a special type of queue where elements are ordered by priority rather than insertion order. 

=> Internally, it is implemented using a binary heap stored in an array. 

=> By default, it’s a min-heap, so the smallest element is always at the head, though we can provide a custom comparator for different ordering. 

=> When we insert an element, it’s first added at the end of the array and then adjusted upwards using heapify-up to maintain the heap property. 

=> When we remove an element, the root is removed, the last element is placed at the root, and then heapify-down is applied. 

=> Insert and remove operations take O(log n), while peek takes O(1). 

=> This makes PriorityQueue very efficient for scenarios like scheduling, shortest path algorithms, or whenever we need quick access to the highest-priority element.”
##########################################################################################################################
8. Comparable vs Comparator
============================
Comparable:

=> Comparable is an interface in java.lang
=> Defines the natural ordering of objects
=> Contains method compareTo(Object o)
=> Sorting logic is inside the class itself
=> Supports only one sorting sequence
=> Requires the class to implement Comparable
=> Example: Collections.sort(list) uses compareTo()

Comparator:

=> Comparator is an interface in java.util
=> Defines custom or external ordering of objects
=> Contains method compare(Object o1, Object o2)
=> Sorting logic is outside the class
=> Supports multiple sorting sequences
=> Does not modify the original class
=> Example: Collections.sort(list, comparator) uses compare()
##########################################################################################################################
9.Difference between Collections.synchronizedList and Concurrent collections
=============================================================================
Collections.synchronizedList:
==============================

=> Achieves thread safety by synchronizing every method call
=> Ensures only one thread can access the list at a time
=> Uses coarse-grained locking → performance is slower under high concurrency

Concurrent Collections:
=========================
=> Specifically designed for multi-threading
=> Use fine-grained locking or copy-on-write techniques
=> Allow better scalability under concurrent access
=> Provide fail-safe iterators (no ConcurrentModificationException)
=> Deliver higher performance in multi-threaded environments
##########################################################################################################################
10.Immutable collections — ways to create
==========================================
Immutable Collections:
=======================
=> An immutable collection is a collection whose contents cannot be modified after creation.
=> No elements can be added, removed, or updated once created.
=> Provides thread-safety by design since data cannot change.
=> Helps in creating defensive copies and avoiding accidental modifications.
Ways to Create Immutable Collections:
--------------------------------------

1. Using Collections.unmodifiableXXX()
=======================================
=> Wraps a mutable collection to make it unmodifiable
=> Example:
List<String> list = new ArrayList<>();
list.add("A"); list.add("B");
List<String> immutableList = Collections.unmodifiableList(list);

=> But if the original list is modified, the immutable view also reflects changes.

2. Using List.of(), Set.of(), Map.of() (Java 9+)
================================================
=> Creates truly immutable collections directly
=> Example:
List<String> list = List.of("A", "B", "C");

=> No modification allowed, and they don’t reflect changes in any other collection.

3. Using Collections.singletonXXX()
======================================
=> Creates an immutable collection with only one element
=> Example:

List<String> single = Collections.singletonList("A");

4. Using Stream Collectors (Java 10+)
======================================
=> Use Collectors.toUnmodifiableList() / toUnmodifiableSet() / toUnmodifiableMap()
=> Example:

List<String> list = Stream.of("A", "B")
        .collect(Collectors.toUnmodifiableList());
#########################################################################################################################
11.Iterator and ListIterator
=============================
Iterator:
==========
=> Present in all collection classes (List, Set, Map’s keySet/values).
=> Provides unidirectional traversal → moves only forward.
=> Methods: hasNext(), next(), remove().
=> Cannot traverse backward.
=> Cannot modify elements directly (only remove).
=> Applicable to all collections.
                  => Example:

               Iterator<String> it = list.iterator();
              while(it.hasNext()) {
                  System.out.println(it.next());
                                  }

ListIterator:
==============

=> Specific to List implementations only (ArrayList, LinkedList, Vector).
=> Provides bidirectional traversal → can move forward and backward.
=> Methods: hasNext(), next(), hasPrevious(), previous(), add(), set(), remove().
=> Can modify elements (add, update, remove) during iteration.
=> More powerful but slightly heavier than Iterator.
		=> Example:

		ListIterator<String> it = list.listIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
#########################################################################################################################
12.What is the hashCode-equals contract? Why is it important?
==============================================================
hashCode–equals Contract:
=========================
=> If two objects are equal according to equals(), then they must have the same hashCode().
=> If two objects have the same hashCode(), they may or may not be equal (collisions possible).
=> If equals() is overridden, you must also override hashCode() to maintain the contract.

Why is it Important?
====================
=> Collections like HashMap, HashSet, LinkedHashMap rely on hashCode() to decide the bucket in which an object is stored.
=> After locating the bucket, they use equals() to check if two objects are actually the same.
=> Breaking the contract can lead to:

Duplicate objects in a HashSet (violating uniqueness).

Missing keys/values in a HashMap even if they exist.

Inconsistent behavior in hashing-based collections.

#########################################################################################################################
13.If you override equals () but do not override hashCode(), what could go wrong when storing objects in a HashMap?
===================================================================================================================
If you override equals() but not hashCode():
=============================================-
=> Two objects may be equal according to equals() but produce different hash codes (default hashCode() from Object).
=> When such objects are stored in a HashMap (or HashSet):

-> They will go into different buckets due to different hash codes.
-> This breaks the hashCode–equals contract.
=> As a result:
================

=> A HashMap may fail to find a key even if it is logically equal.

=> A HashSet may store duplicates, because it relies on hashCode first, then equals.

=> Lookups, updates, and removals become unreliable and inconsistent.

#########################################################################################################################
14.What happens if a hash function always returns the same value? how will it store values?
=> If a hash function always returns the same value, all keys end up in one bucket. 
=> The HashMap still works by using equals to differentiate keys, but performance degrades from O(1) to O(n) or O(log n), making the hash function useless.”

#########################################################################################################################
15.f a poorly designed hash function causes all elements to collide in a HashMap, what would be the performance impact?
========================================================================================================================
Performance Impact of Poorly Designed Hash Function (all collisions):

=> If all elements collide into the same bucket, HashMap loses its O(1) average performance.
=> Instead of distributing keys across buckets, it puts them into one bucket.
=> Then, lookup (get()), insert (put()), and delete (remove()) must scan through that bucket.

JDK 7 and earlier: bucket is a linked list → operations degrade to O(n) in worst case.

JDK 8 and later: if bucket size exceeds a threshold (default 8 elements), it gets treeified (red-black tree) → operations improve to O(log n) but still worse than O(1).

=> So, HashMap still functions correctly, but with significant performance loss under heavy collisions.

#########################################################################################################################
16.If you need to remove elements while iterating over a collection, which type of iterator would you choose and why?
======================================================================================================================
Removing elements while iterating over a collection:
======================================================

=> If we need to remove elements during iteration, we should use the Iterator (or ListIterator for lists) instead of a for-each loop.
=> The Iterator interface provides the remove() method, which safely removes the current element from the underlying collection.
=> This avoids ConcurrentModificationException, which occurs if you try to remove elements directly from the collection while iterating.
=> For lists, ListIterator is even more powerful:

It supports both remove() and add() operations.

It allows bidirectional traversal (previous() as well as next()).

#########################################################################################################################
17.If you need to implement a queue that frequently adds and removes elements from both ends, which list would be a better choice and why?
=============================
=> If we need a queue that frequently adds and removes elements from both ends, the better choice is LinkedList (or more modern, ArrayDeque).
=> LinkedList implements the Deque interface, allowing efficient insertion and deletion from both head and tail in O(1) time.
=> In contrast, ArrayList is not efficient for such operations:

Adding/removing at the end is O(1), but

Adding/removing at the beginning or middle requires shifting elements → O(n).
=> ArrayDeque is even more efficient than LinkedList in practice, since it avoids node object overhead and works on a resizable array with circular indexing.
#########################################################################################################################
18.Hashtable explain:
========================
Hashtable in Java

=> Hashtable is a legacy class (introduced in JDK 1.0) that implements the Map interface and stores elements in key–value pairs.
=> It does not allow null key or null values (unlike HashMap which allows one null key and multiple null values).
=> It is synchronized, meaning all methods are thread-safe → but this synchronization makes it slower compared to modern alternatives like HashMap or ConcurrentHashMap.
=> Internally, it uses a hash table (array of buckets + linked list/tree in JDK 8+) for storage and retrieval.
=> Performance is O(1) on average for put() and get(), but can degrade with collisions.
=> Iterators are fail-fast, meaning they throw ConcurrentModificationException if the table is modified while iterating.
=> It is considered legacy and rarely used in modern applications — usually replaced by HashMap (for single-threaded) or ConcurrentHashMap (for multi-threaded) scenarios.
#########################################################################################################################
19.What are the differences between Collection and Collections?
=================================================================
Collection vs Collections
Collection (Interface)

=> Collection is a root interface in the Java Collections Framework (java.util package).
=> It represents a group of objects (elements).
=> Extended by interfaces like List, Set, Queue.
=> Provides basic methods like add(), remove(), size(), iterator().
=> Example: List<String> list = new ArrayList<>(); → list is a Collection.

Collections (Class)

=> Collections is a utility class (final, in java.util package).
=> Provides static helper methods to work with collections.
=> Common methods:

Collections.sort(list) → to sort a list.

Collections.reverse(list) → to reverse.

Collections.unmodifiableList(list) → to make immutable.

Collections.synchronizedList(list) → to make thread-safe.
=> Cannot be instantiated because it only has static methods.
#########################################################################################################################
20.what is BlockingDeque?
==========================
BlockingQueue

=> BlockingQueue is an interface in java.util.concurrent used in multi-threaded environments.
=> It represents a thread-safe queue that supports blocking operations for adding and removing elements.
=> If the queue is full, a thread trying to put() will wait until space is available.
=> If the queue is empty, a thread trying to take() will wait until an element becomes available.
=> Common implementations: ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, DelayQueue.
=> Widely used in Producer-Consumer problems.
#########################################################################################################################
21.What does the hashCode() method?
===================================
hashCode() Method in Java

=> hashCode() is a method defined in the Object class that returns an int value representing the hash code of an object.
=> A hash code is a numerical value used by hash-based collections (like HashMap, HashSet, Hashtable) to determine the bucket location where the object should be stored.
=> The contract between equals() and hashCode() is:

If two objects are equal (via equals()), they must have the same hash code.

If two objects have the same hash code, they may or may not be equal (collisions possible).
=> The default implementation of hashCode() in Object class typically uses the object’s memory address, but classes usually override it to ensure proper hashing based on fields.
=> A good hashCode implementation reduces collisions and improves performance of hash-based collections.
#########################################################################################################################
22.Why we override equals() method?
===================================
=> The equals() method is defined in the Object class, and by default it checks for reference equality (whether two references point to the same object in memory).
=> In real-world scenarios, we often need to compare objects by their content (data/fields), not by their memory location.
=> For example: Two Employee objects with the same id and name should be considered equal, even if they are stored at different memory addresses.
=> That’s why we override equals() to provide our own logic for comparing objects meaningfully.
=> It is especially important in collections like HashSet, HashMap, or ArrayList.contains() which use equals() to check for duplicate elements or keys.
#########################################################################################################################
23.How to synchronize List, Set, and Map elements?
===================================================
=> Java provides Collections.synchronizedXXX() utility methods to make collections thread-safe by wrapping them with synchronized versions.
Synchronize a List:
---------------------
List<String> list = Collections.synchronizedList(new ArrayList<>());

Synchronize a Set:
---------------------
Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

Synchronize a Map:
---------------------
Map<String, String> map = Collections.synchronizedMap(new HashMap<>());

=> These synchronized collections allow only one thread to access the collection at a time by locking.
=> But the iterators returned by these synchronized collections are fail-fast, so to iterate safely, you should manually synchronize during iteration:

#########################################################################################################################
24.What are the advantages of the generic collection?
=>The main advantage of generic collections is type safety, no need for casting, compile-time error detection, and cleaner, reusable code.”
#########################################################################################################################
25.What is hash-collision in Hashtable and how it is handled in Java?
=====================================================================
=> A hash collision occurs when two different keys produce the same hash code and end up mapped to the same bucket in a hash-based data structure (like Hashtable, HashMap).

=> Since multiple keys can map to the same bucket, Java needs a strategy to handle collisions.

=> In Hashtable (and HashMap before Java 8):

Collisions are handled using a Linked List inside each bucket.

If two keys have the same hash code, their entries are stored in the same bucket as a chain.

During lookup, Java traverses the linked list and uses equals() to find the correct key-value pair.

=> Since Java 8 (for HashMap, not Hashtable):

If too many collisions happen in a single bucket (linked list length > 8), the linked list is converted into a balanced Red-Black Tree.

This improves worst-case lookup performance from O(n) to O(log n).

Note: Hashtable is older and does not use tree structure—it still uses only chaining with linked lists.
#########################################################################################################################
26.What is the Dictionary class?
================================
=> Dictionary is an abstract class that represented key-value pairs before Map was introduced. It’s now legacy and replaced by Map interface in modern Java.”
#########################################################################################################################
27.What is the default size of load factor in hashing based collection?
========================================================================
=> The default size of load factor is 0.75. The default capacity is computed as initial capacity * load factor. For example, 16 * 0.75 = 12. So, 12 is the default capacity of Map.
#########################################################################################################################
28.What are the differences between the length of an Array and the size of an ArrayList?
======================================================================================
=> The length of an array can be obtained using the property of length whereas ArrayList does not support length property, but we can use size() method to get the number of objects in the list.

Finding the length of the array
--------------------------------
Int [] array = new int[4];  
System.out.println("The size of the array is " + array.length);  
Finding the size of the ArrayList
---------------------------------
ArrayList<String> list=new ArrayList<String>();    
list.add("ankit");    
list.add("nippun");  
System.out.println(list.size());  
#########################################################################################################################
29.How to convert ArrayList to Array and Array to ArrayList?
=================================================================
=> We can convert an Array to ArrayList by using the asList() method of Arrays class. 
=> asList() method is the static method of Arrays class and accepts the List object. 
Consider the following syntax:
------------------------------
Arrays.asList(item)  

=> We can convert an ArrayList to Array using toArray() method of the ArrayList class. 
Consider the following syntax to convert the ArrayList to the List object.
-------------------------------------------------------------------------
List_object.toArray(new String[List_object.size()])  
#########################################################################################################################
30.How to make Java ArrayList Read-Only?
=========================================
=> We can obtain a Java ArrayList that is Read-only by calling the Collections.unmodifiableCollection() method. 
=> When we define an ArrayList as Read-only, we cannot modify the collection through the add(), remove(), or set() methods.
#########################################################################################################################
31.How to remove duplicates from ArrayList?
=============================================
There are two ways to remove duplicates from the ArrayList.
-----------------------------------------------------------
Using HashSet: 
--------------
=> By using HashSet we can remove the duplicate element from the ArrayList, but it will not then preserve the insertion order.
Using LinkedHashSet: 
---------------------
=> We can also maintain the insertion order by using LinkedHashSet instead of HashSet.
The Process to remove duplicate elements from ArrayList using the LinkedHashSet:
---------------------------------------------------------------------------------
Copy all the elements of ArrayList to LinkedHashSet.
Empty the ArrayList using clear() method, which will remove all the elements from the list.
Now copy all the elements of LinkedHashset to ArrayList.

Note:
=======
=> We can remove duplicates by converting ArrayList into a Set. If we want to maintain insertion order, use LinkedHashSet or Streams with distinct() in Java 8+.”
#########################################################################################################################
32.How to reverse an ArrayList?
===============================
=> The simplest way is Collections.reverse(list), which reverses an ArrayList in place. 
=> Alternatively, we can use manual swapping or Java 8 Streams for a reversed copy.”

#########################################################################################################################
33.How to sort ArrayList in descending order?
===================================================
=> We can sort an ArrayList in descending order using Collections.sort(list, Collections.reverseOrder()), or with Java 8+, use list.sort(Comparator.reverseOrder()) or Streams with sorted().”

#########################################################################################################################
34.How to synchronize ArrayList?
================================
=> We can synchronize an ArrayList using Collections.synchronizedList(), or better use CopyOnWriteArrayList from java.util.concurrent for high concurrency and fail-safe iteration.”

#########################################################################################################################
35. When to use ArrayList and LinkedList?
==========================================
=> Use ArrayList when you need fast random access and fewer modifications, and use LinkedList when insertions/deletions are frequent, especially in the middle or both ends.”

#########################################################################################################################
36.HashSet internalworks?
===========================
HashSet Internal Working

A HashSet is internally backed by a HashMap.

When you add an element, it is stored as a key in the HashMap with a constant dummy value.

Uniqueness of elements is ensured using hashCode() (for bucket location) and equals() (for duplicate check).

HashSet allows only one null value.

Provides O(1) average time complexity for add, remove, and lookup.

In case of many collisions, performance may degrade to O(n)

#########################################################################################################################
37.What is the difference between an Iterator and an Enumeration?
=====================================================================
A major difference between iterator and enumeration is that iterators have a remove() method while enumerations do not. Thus, using Iterator we can manipulate objects by adding and removing them from collections. Since enumeration can only traverse objects and fetch them, it behaves like a read-only interface.

#########################################################################################################################
38.What is the Best Practices for Java Collections Framework
=============================================================
=> Programs should be written as interfaces, not implementations, so the implementation can be changed easily.

=> Always use Generics to ensure type safety and avoid ClassCastException.

=> Choose the appropriate collection type based on the requirement:

Array → when size is fixed.

ArrayList → when dynamic resizing is needed.

LinkedHashMap → when iteration order matters.

Set → when duplicates must be avoided.

=> Use immutable classes as keys in Map to avoid issues with hashCode() and equals().

=> For readability, use isEmpty() instead of checking size() == 0.

=> Use Collections utility methods (unmodifiableXXX, synchronizedXXX, emptyXXX) instead of writing custom implementations.

#########################################################################################################################
39.Difference between ArrayList and Vector?
=============================================
Vector
======
=> Vector is synchronized (thread-safe).

=> It is a legacy class (introduced in JDK 1.0).

=> It doubles its size (100% growth) when capacity is exceeded.

=> Slower in performance due to synchronization overhead.

=> Provides a fail-safe iterator (doesn’t throw ConcurrentModificationException).

=> Mostly used in legacy or concurrent environments, but replaced by modern concurrent collections.
ArrayList:
===========
=> ArrayList is not synchronized (not thread-safe).

=> It is not a legacy class (introduced in JDK 1.2 with Collections Framework).

=> Increases its size by 50% when capacity is exceeded.

=> Faster performance as there’s no synchronization overhead.

=> Provides a fail-fast iterator (throws ConcurrentModificationException if modified during iteration).

=> Preferred in non-concurrent environments for better performance.

#########################################################################################################################
40.What is IdentityHashMap?
============================
=> IdentityHashMap is like a HashMap but compares keys using == instead of equals().
=> Useful in scenarios like object reference comparison, object graph processing, or serialization frameworks where identity comparison is required.

#########################################################################################################################
41.What will happen if you use HashMap in a multithreaded Java application?
============================================================================
=> HashMap is not synchronized, so it is not thread-safe.

=> If multiple threads access and modify it concurrently, it may lead to data inconsistency.

=> During resize (rehashing), multiple threads can cause a race condition, leading to infinite loops or lost updates.

=> In such cases, we should prefer ConcurrentHashMap."

#########################################################################################################################
42.what is WeakHashMap?
=======================
=> WeakHashMap is a special Map implementation where keys are weakly referenced, meaning if a key is no longer used elsewhere, its entry can be garbage collected automatically. It’s mostly used for caching and memory-sensitive applications.

#########################################################################################################################
43.UnsupportedOperationException?
==================================
=> UnsupportedOperationException is an unchecked exception thrown when we try to perform an operation that a collection does not support, such as modifying an immutable or fixed-size collection."

#########################################################################################################################
44.What is the diamond operator in Java?
========================================
Diamond Operator (<>) in Java

=> Introduced in Java 7 to simplify generic instance creation.

=> Allows the compiler to infer the generic type from the variable declaration, so you don’t need to repeat it.

=> Reduces code verbosity and improves readability.

=> Commonly used with collections like ArrayList, HashMap, etc.

#########################################################################################################################
Java Collections – Scenario based Questions and Answers
=======================================================

=> Q1: How do you remove duplicates from a list while preserving order?

A: Use LinkedHashSet or Streams distinct() → Preserves insertion order and ensures uniqueness.

#########################################################################################################################
=> Q2: Which collection is best for fast lookup by key, like employee ID?
===========================================================================
A: HashMap → Provides O(1) average time for get/put operations.

#########################################################################################################################
=> Q3: How to handle a highly concurrent map where multiple threads read/write?
====================================================
A: Use ConcurrentHashMap → Thread-safe without locking the entire map.

#########################################################################################################################
=> Q4: Which collection should you use for a FIFO queue?
====================================================
A: LinkedList or ArrayDeque → O(1) insertion/removal at ends.

#########################################################################################################################
=> Q5: How to implement a stack for undo operations?
====================================================
A: Stack or ArrayDeque → Supports LIFO efficiently.

#########################################################################################################################
=> Q6: Which collection automatically sorts unique elements?
====================================================
A: TreeSet → Maintains ascending order and uniqueness.

#########################################################################################################################
=> Q7: How to maintain insertion order in a Map?
====================================================
A: LinkedHashMap → Iteration order equals insertion order.

#########################################################################################################################
=> Q8: Which list is better for frequent random access?
====================================================
A: ArrayList → O(1) access by index and dynamically resizable.

#########################################################################################################################
=> Q9: How to safely iterate a collection in multi-threaded environment?
=======================================================================
A: Use CopyOnWriteArrayList, ConcurrentHashMap, or Collections.synchronizedXXX() → Prevents ConcurrentModificationException.

#########################################################################################################################
=> Q10: How to implement a memory-sensitive cache where keys should be garbage collected if unreferenced?
========================================================================================================
A: Use WeakHashMap → Entries removed automatically by GC.

#########################################################################################################################
=> Q11: How do you synchronize a List for multiple threads?
====================================================
A:
Option 1: Collections.synchronizedList(new ArrayList<>()) → Entire list locked.
Option 2: CopyOnWriteArrayList → Fine-grained locking, supports fail-safe iteration.

#########################################################################################################################
=> Q12: How to reverse an ArrayList?
====================================================
A: Collections.reverse(list) or Streams + sorted(Comparator.reverseOrder()).

#########################################################################################################################
=> Q13: How to sort an ArrayList in descending order?
====================================================
A: Collections.sort(list, Collections.reverseOrder()) or list.sort(Comparator.reverseOrder()).

#########################################################################################################################
=> Q14: How to ensure type safety in collections?
====================================================
A: Use Generics (e.g., List<String> list = new ArrayList<>()).

#########################################################################################################################
=> Q15: Which map compares keys using reference equality instead of equals()?
============================================================================
A: IdentityHashMap → Keys compared using ==.

#########################################################################################################################
=> Q16: When should you use ArrayList vs LinkedList?
====================================================
A: ArrayList → Fast random access (O(1)), read-heavy.
LinkedList → Fast insert/delete in middle or ends, modification-heavy.

#########################################################################################################################
=> Q17: What is the difference between ArrayList and Vector?
====================================================
A: ArrayList → Not synchronized, faster.
Vector → Synchronized, legacy, slower.

#########################################################################################################################
=> Q18: Which Set maintains insertion order?
====================================================
A: LinkedHashSet → Preserves insertion order.

#########################################################################################################################
=> Q19: Which Set automatically sorts elements?
====================================================
A: TreeSet → Sorted ascending, no duplicates.

#########################################################################################################################
=> Q20: How does HashSet ensure uniqueness?
====================================================
A: Backed by HashMap; uses hashCode() + equals() to check duplicates.

#########################################################################################################################
=> Q21: When to use TreeSet over HashSet?
====================================================
A: When you need a sorted collection; HashSet does not maintain order.

#########################################################################################################################
=> Q22: How does PriorityQueue work internally?
====================================================
A: Backed by a binary heap → Maintains natural order or custom Comparator.

#########################################################################################################################
=> Q23: Can PriorityQueue store null elements?
====================================================
A: No → Throws NullPointerException.

#########################################################################################################################
=> Q24: How to implement a thread-safe queue for multiple producers and consumers?
====================================================
A: Use BlockingQueue like ArrayBlockingQueue or LinkedBlockingQueue.

#########################################################################################################################
=> Q25: What is CopyOnWriteArrayList and when to use it?
====================================================
A: Thread-safe list → Creates new copy on write, ideal for read-heavy, low-write scenarios.

#########################################################################################################################
=> Q26: Difference between Collections.synchronizedList and concurrent collections?
====================================================
A: Synchronized → Locks entire collection; one thread at a time.
Concurrent → Fine-grained locking or copy-on-write, higher concurrency, fail-safe iterators.

#########################################################################################################################
=> Q27: What happens if HashMap keys don’t override hashCode() and equals() properly?
====================================================
A: Lookup and uniqueness may fail → May store duplicate keys or fail to find entries.

#########################################################################################################################
=> Q28: How does HashMap handle resizing?
====================================================
A: When elements exceed load factor (default 0.75), capacity doubles and entries are rehashed.

#########################################################################################################################
=> Q29: How to handle hash collisions in HashMap?
====================================================
A: Chaining using linked list or red-black tree (Java 8+) in the same bucket.

#########################################################################################################################
=> Q30: Can HashMap have null keys and values?
====================================================
A: Yes → One null key allowed, multiple null values allowed.

#########################################################################################################################
=> Q31: Can ConcurrentHashMap have null keys or values?
====================================================
A: No → Neither null keys nor null values allowed.

#########################################################################################################################
=> Q32: When to use LinkedHashMap over HashMap?
====================================================
A: When insertion order or access order iteration is required (e.g., LRU cache).

#########################################################################################################################
=> Q33: When to use TreeMap over HashMap?
====================================================
A: When sorted order by keys is required.

#########################################################################################################################
=> Q34: Difference between fail-fast and fail-safe iterators?
====================================================
A: Fail-fast → Throws ConcurrentModificationException.
Fail-safe → Operates on clone/copy; allows concurrent modifications.

#########################################################################################################################
=> Q35: Which iterator allows safe removal during iteration?
====================================================
A: Iterator.remove() → Supported safely.

#########################################################################################################################
=> Q36: How to implement LRU cache using Java Collections?
====================================================
A: Use LinkedHashMap with accessOrder=true and override removeEldestEntry().

#########################################################################################################################
=> Q37: How to create immutable collections?
====================================================
A: Collections.unmodifiableList/Set/Map() or Java 9+ List.of(), Set.of(), Map.of().

#########################################################################################################################
=> Q38: When to use Comparable vs Comparator?
====================================================
A: Comparable → Natural ordering inside class.
Comparator → Custom ordering externally.

#########################################################################################################################
=> Q39: How to safely iterate a ConcurrentHashMap?
====================================================
A: Use keySet(), entrySet(), values() iterator → Fail-safe.

#########################################################################################################################
=> Q40: Which Set is suitable for maintaining insertion order with uniqueness?
========================================================================================================
A: LinkedHashSet.

#########################################################################################################################
=> Q41: Which Set is suitable for fast insertion and lookup without caring about order?
========================================================================================================
A: HashSet.

#########################################################################################################################
=> Q42: Which Set is suitable for sorted, unique, and frequent searches?
====================================================
A: TreeSet.

########################################################################################################################
=> Q43: How to convert a List to Set to remove duplicates?
====================================================
A: Set<Type> set = new HashSet<>(list);

########################################################################################################################
=> Q44: How do enums work with collections?
====================================================
A: EnumMap → Keys; EnumSet → Specialized, high-performance Set for enums.

########################################################################################################################
=> Q45: What are some common concurrency pitfalls with collections?
====================================================
A: Using HashMap/ArrayList directly in multi-threaded env → data inconsistency; iterating without fail-safe iterator → ConcurrentModificationException.

########################################################################################################################
=> Q46: How to implement stack behavior with thread safety?
====================================================
A: Use ConcurrentLinkedDeque or Collections.synchronizedList(new LinkedList<>()).

########################################################################################################################
=> Q47: What happens when two keys have the same hashCode() in HashMap?
====================================================
A: Hash collision → Stored in same bucket using linked list/tree; equals() checks uniqueness.

########################################################################################################################
=> Q48: How to sort a collection using custom order?
====================================================
A: Implement Comparator → Pass to Collections.sort(list, comparator) or TreeSet.

########################################################################################################################
=> Q49: What is WeakHashMap and when to use it?
====================================================
A: Keys are weakly referenced → GC removes entries automatically; useful for caching.

########################################################################################################################
=> Q50: What is IdentityHashMap and when to use it?
====================================================

A: Keys compared using reference equality (==); useful for object identity comparisons.

########################################################################################################################