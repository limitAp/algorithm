package leetcode.editor.cn.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class FooBar {

    private int n;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private Condition condition2 = lock.newCondition();

    private boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if (!flag) {
                condition.await();
            }
            printFoo.run();
            flag = false;
            condition2.signal();
            lock.unlock();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if (flag) {
                condition2.await();
            }
            printBar.run();
            flag = true;
            condition.signal();
            lock.unlock();
        }
    }

}
