package bishizhenti;

public class MyLinkedQueue<T> {


    public Node<T> front = null;
    public Node<T> rear = null;
    private Integer count = 0;
    public Integer getCount() {
        return count;
    }
    public MyLinkedQueue(){
        initQueue();
    }

    /**
     * 初始化队列
     */
    private void initQueue(){
        front = new Node<T>();
        rear = front;
    }

    /**
     * 销毁队列
     */
    public void destroyQueue(){
        front = null;
        rear = null;
    }

    /**
     * 入队
     * @param data
     * @return
     */
    public boolean enQueue(T data){
        try {
            Node<T> node = new Node<T>(data);
            node.pre = rear;
            rear.next = node;
            rear = rear.next;
            count++;
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 出队
     * @return
     */
    public T deQueue(){
        try {
            if(front == rear) {
                System.out.println("没有元素了，不能出队了");
                return null;
            }
            front = front.next;
            count--;
            return front.data;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 返回队头元素
     * @return
     */
    public T getQueue(){
        try {
            if(front == rear) {
                System.out.println("没有元素了，不能找到队头元素了");
                return null;
            }
            return front.next.data;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static class Node<T>{
        public Node<T> pre = null;
        public Node<T> next = null;
        public T data = null;
        public Node(){}
        public Node(T d){
            data = d;
        }
    }



}