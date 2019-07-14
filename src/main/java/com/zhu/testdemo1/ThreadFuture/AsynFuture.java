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
        //  若任务没完成  让线程阻塞
        synchronized (this){
            while(!done){
                this.wait();
            }
        }
        return result;

    }
}
