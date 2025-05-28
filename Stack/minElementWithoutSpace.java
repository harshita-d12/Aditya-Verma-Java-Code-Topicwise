import java.util.*;

public class minElementWithoutSpace {
    int min = 0;
    Stack<Integer> s = new Stack<>();
    int getMin(){
        if(s.isEmpty()){
            return - 1;
        }
        return min;
    }

    void push(int data){
        if (s.isEmpty()) {
            s.push(data);
            min = data ;
        }else{
            if(data >= min){
                s.push(data);
            }else if(data < min){
                s.push(2*data - min);
                min = data;
            }
        }
    }

    void pop(){
        if(s.isEmpty()){
            return ;
        }else{
            if(s.peek() >= min){
                s.pop();
            }else if(s.peek() < min){
                min = 2 * min - s.peek();
                s.pop();
            }
        }
    }

    int peek(){
        if(s.isEmpty()){
            return - 1;
        }else{
            if(s.peek() >= min){
                return s.peek();
            }else if(s.peek() < min){
                return min;
            }
        }
        return - 1;
    }
    public static void main(String[] args) {
        minElementWithoutSpace s = new minElementWithoutSpace();
        s.push(5);
        s.push(7);
        s.push(3);
        s.pop();
        s.push(4);
        System.out.println(s.getMin());


        while(!s.s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        
    }
}
