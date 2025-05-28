import java.util.*;
public class minElementWithSpace {
    class Pair< k, v>{
        public k key;
        public v value;
        public Pair(k key, v value){
            this.key = key;
            this.value = value ;
        }
    }
    Stack<Integer> s = new Stack<>();
    Stack<Integer> ss = new Stack<>();
    Stack<Pair<Integer,Integer>> sss = new Stack<>();
    void push(int data){
        if(s.isEmpty()){
            return ;
        }
        s.push(data);
        if(ss.isEmpty() || data <= ss.peek()){
            ss.push(data);
        }
        
        
        return ;
    }
    int pop(){
        if(s.isEmpty()){
            return - 1;
        } 
        int ans = s.peek();
        s.pop();
        if(ss.peek() == ans){
            ss.pop();
        }
        return ans ;
    }
    int getMin(){
        if(ss.isEmpty()){
            return - 1;
        }
        return ss.peek();
    }
    public static void main(String[] args) {
        
    }
    
}
