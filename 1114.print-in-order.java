/*
 * @lc app=leetcode id=1114 lang=java
 *
 * [1114] Print in Order
 */

// @lc code=start
class Foo {

    public Foo() {
        
    }
    int count = 0;

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized(this) {
            this.count++;
            printFirst.run();
            notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized(this) {
            while (this.count < 1) {
                wait();
            }
            this.count++;
            printSecond.run();
            notifyAll();
        }  
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized(this) {
            while (this.count < 2) {
                wait();
            }
            printThird.run();
            notifyAll();
        }
    }
}
// @lc code=end

