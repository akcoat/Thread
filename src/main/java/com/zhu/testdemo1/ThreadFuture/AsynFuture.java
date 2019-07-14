package com.zhu.testdemo1.ThreadFuture;

/**
 * 　　* @description: ${name}
 * 　　* @param ${tags}
 * 　　* @return ${return_type}
 * 　　* @throws
 * 　　* @author 83915
 * 　　* @date $date$ $time$
 *
 */
public class AsynFuture<T>  implements future<T> {

    private volatile boolean done =false;

    private T result ;


    public void done(T result){
        synchronized (this){
            this.result=result;
            this.done=true;
            this.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        //  若任务没完成  释放锁资源 让线程进入 blocked状态
        synchronized (this){
            while(!done){
                this.wait();
            }
        }
        return result;

    }
}
