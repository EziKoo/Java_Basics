package com.chy.synchronized_;

public class ReleaseLock {
    public static void main(String[] args) {
        /*
        释放锁：
        1、当前线程的同步方法、同步代码块执行结束
        2、当前线程的同步方法、同步代码块中遇到break,return;
        3、当前线程的同步方法、同步代码块出现了未处理的Error或Exception，导致异常结束
        4、当前线程的同步方法、同步代码执行了线程对象的wait()方法，当前线程暂停，并释放锁
         */

        /*
        不释放锁
        1、线程执行同步代码块或同步方法时，程序调用Thread.sleep()、Thread.yield()方法暂停当前线程的执行、不会释放锁
        2、线程执行同步代码块时，其他线程调用了该线程的suspend()方法将该线程挂起，该线程不会释放锁。
        提示：
           应尽量避免使用：suspend()和resume()来控制线程，方法不再推荐使用
         */
    }
}
