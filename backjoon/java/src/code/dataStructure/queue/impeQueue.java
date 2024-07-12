package code.dataStructure.queue;

public class impeQueue {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyLinkListQue<>();
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Enqueue(4);
        while (!queue.IsEmpty()){
            System.out.println(queue.Dequeue());
        }
    }
    interface MyQueue<T>{
        void Enqueue(T data);
        T Dequeue();
        boolean IsEmpty();
        boolean IsFull();
        void print();
        int size();
    }

    static class Node<T> {
        private Node<T> front;
        private Node<T> rear;
        private final T data;
        public Node(T data){
            this.front = null;
            this.rear = null;
            this.data = data;
        }
        public Node(Node<T> node,T data){
            this.front = node;
            this.rear = null;
            this.data = data;
        }

        public void setRear(Node<T> nodes) {
            this.rear = nodes;
        }
        public Node<T> getRear(){
            this.front = null;
            return this.rear;
        }
        //메모리 명시적 헤제
        public void clear(){
            this.rear = null;
            this.front = null;
        }
    }

    static class MyLinkListQue<T> implements MyQueue<T>{

        private Node<T> node;
        private int count;
        private Node<T> rearNode;
        public MyLinkListQue(){
            this.count = 0;
            this.node=null;
        }

        @Override
        public void Enqueue(T data) {
            if (IsEmpty()){
                this.node = new Node<>(data);
                this.rearNode = this.node;
            }else{
                Node<T> newNode= new Node<>(rearNode,data);
                this.rearNode.setRear(newNode);
                this.rearNode = newNode;
            }
            count++;


        }

        @Override
        public T Dequeue() {
            Node<T> returnNode = this.node;
            this.node = returnNode.getRear();
            count--;
            returnNode.clear();
            return returnNode.data;
        }

        @Override
        public boolean IsEmpty() {
            return node == null;

        }

        @Override
        public boolean IsFull() {
            return true;
        }

        @Override
        public void print() {

        }

        @Override
        public int size() {
            return count;
        }
    }


}
