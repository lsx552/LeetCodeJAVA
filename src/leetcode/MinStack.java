package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private List<Integer> data;
    private List<Integer> mins;
    public MinStack() {
        data = new ArrayList<Integer>();
        mins = new ArrayList<Integer>();
    }

    public void push(int x) throws Exception{
        data.add(x);
        if(mins.size() == 0) {
            // 初始化mins
            mins.add(0);
        } else {
            // 辅助栈mins push最小值的索引
            int min = getMin();
            if (x < min) {
                mins.add(data.size() - 1);
            }
        }
    }

    public int pop()throws Exception {
        // 栈空，抛出异常
        if(data.size() == 0) {
            throw new Exception("栈为空");
        }
        // pop时先获取索引
        int popIndex = data.size() - 1;
        // 获取mins栈顶元素，它是最小值索引
        int minIndex = mins.get(mins.size() - 1);
        // 如果pop出去的索引就是最小值索引，mins才出栈
        if(popIndex == minIndex) {
            mins.remove(mins.size() - 1);
        }
        return data.remove(data.size() - 1);
    }

    public int top() throws Exception {
        // 栈空，抛出异常
        if(data.size() == 0) {
            throw new Exception("栈为空");
        }
        return data.get(data.size()-1);
    }
    public int getMin() throws Exception {
        // 栈空，抛出异常
        if(data.size() == 0) {
            throw new Exception("栈为空");
        }
        // 获取mins栈顶元素，它是最小值索引
        int minIndex = mins.get(mins.size() - 1);
        return data.get(minIndex);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        try {
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            System.out.println(minStack.getMin());
            System.out.println(minStack.pop());
            System.out.println(minStack.top());
            System.out.println(minStack.getMin());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
