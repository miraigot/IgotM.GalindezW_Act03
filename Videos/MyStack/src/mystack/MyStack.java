/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mystack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class MyStack {
Thread thread;
Pusher push;
Popper pop;
List<Integer> stack;
int top;

public MyStack(int intSize){

            thread = new Thread();
            stack = new ArrayList<Integer>(intSize);

}
    public static void main(String[] args) {

            MyStack s = new MyStack(20);
            List<Thread> threads = new ArrayList<Thread>();

            for(int i =0; i<=10; i++){
                Runnable push = new Pusher(i, s);
                Thread worker = new Thread(push);

                worker.setName(String.valueOf(i));
                worker.start();
                threads.add(worker);
            }
             for(int i =s.top; i>=0; i--){
                Runnable pop = new Popper(i, s);
                Thread worker = new Thread(pop);
                worker.setName(String.valueOf(i));
                worker.start();
                threads.add(worker);
             }
    }
    public int getTop(){
        return top;
    }

    public synchronized void pop(){
        if(stack.isEmpty()!=true)
            stack.remove(top--);
    }
    
    public synchronized void push(int num){
        if(top<stack.size())
            stack.add(num);
            top ++;

    }

}
