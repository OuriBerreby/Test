# QuickPushDataStructure
This is an implementation of the QuickPushDataStructure which provide a sorted-like doubly linked list that can perform a quick push operation. 
It is a thread safe class that can perform in multi-threading environment using semaphore and mutex.
The push() method adds elements to the data structure . The pop() method removes and returns the element with the max value. The peek() method returns the element at the top of the list without removing it.

## Usage
To initialize the QuickPopDataStructure, you need to provide a Comparator<T> object to the constructor. This comparator will be used to sort the elements in the data structure.
  
  `QuickPushDataStructure<Integer> dataStructure = new QuickPushDataStructure<>(Comparator.naturalOrder());`

## Push Method

  The push() method time complexity is 0(1) 
  `quickPushDataStructure.push()`
  
  
## Pop Method
  The pop() method time complexity is 0(n) 
  `quickPushDataStructure.pop()`

## Implementation Details
  This implementation uses a binary semaphore to signal when the data structure is not empty, and a mutex lock to ensure thread safety when accessing the data structure.
  
## Thread Safety
  This implementation is thread-safe and can be used safely in multi-threaded environments.

# QuickPopDataStructure
This is an implementation of the QuickPopDataStructure which provide a sorted-like doubly linked list that can perform a quick pop operation. 
It is a thread safe class that can perform in multi-threading environment using semaphore and mutex.
The push() method find the right position of the element to add and insert it to the data structure. The pop() method removes and returns the head of the datas structure. The peek() method returns the element at the top of the list without removing it.

## Usage
To initialize the QuickPopDataStructure, you need to provide a Comparator<T> object to the constructor. This comparator will be used to sort the elements in the data structure.
  
  `QuickPopDataStructure<Integer> dataStructure = new QuickPopDataStructure<>(Comparator.naturalOrder());`

## Push Method

  The push() method time complexity is 0(1) 
  `quickPopDataStructure.push()`
  
  
## Pop Method
  The pop() method time complexity is 0(n) 
  `quickPopDataStructure.pop()`

## Implementation Details
  This implementation uses a binary semaphore to signal when the data structure is not empty, and a mutex lock to ensure thread safety when accessing the data structure.
  
## Thread Safety
  This implementation is thread-safe and can be used safely in multi-threaded environments.
