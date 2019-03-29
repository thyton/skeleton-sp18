package synthesizer;
public interface BoundedQueue<T> {
    int capacity(); // return size
    int fillCount(); //return number of items currently in the buffer
    void enqueue(T x); // add item x to the end
    T dequeue(); // delete and return item from the `front
    T peek(); // return (but do not delete) item from the front
    default boolean isEmpty() {  // is the buffer empty
        return fillCount() == 0;
    }
    default boolean isFull() { // is the buffer full
        return fillCount() == capacity();
    }
}