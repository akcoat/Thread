package com.zhu.testdemo1.ThreadFuture;

import com.zhu.testdemo1.ThreadFuture.AsynFuture;
import com.zhu.testdemo1.ThreadFuture.FutureTask;
import com.zhu.testdemo1.ThreadFuture.future;

import java.util.function.Consumer;

/**
 * 　　* @description: ${name}
 * 　　* @param ${tags}
 * 　　* @return ${return_type}
 * 　　* @throws
 * 　　* @author 83915
 * 　　* @date $date$ $time$
 *
 */

//  将future这个票据与任务结合在一起，降低耦合性
public class FutureService
{

    public <T> future<T> submit(final FutureTask<T> task){
        AsynFuture<T> asynFuture  = new AsynFuture<>();
        new Thread(){
            @Override
            public void run() {
               T t =  task.call();
                asynFuture.done(t);
            }
        }.start();
        return asynFuture;
    }


    public <T> future<T> submit(final FutureTask<T> task, Consumer<T> consumer){
        AsynFuture<T> asynFuture  = new AsynFuture<>();
        new Thread(){
            @Override
            public void run() {
                T t =  task.call();
                asynFuture.done(t);
                // 在这个任务 结束的时候会回调 consumer的方法  实现回调函数的效果
                consumer.accept(t);
            }
        }.start();
        return asynFuture;
    }
}
