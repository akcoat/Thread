package com.zhu.testdemo1.ThreadFuture;

import com.zhu.testdemo1.ThreadFuture.AsynFuture;
import com.zhu.testdemo1.ThreadFuture.FutureTask;
import com.zhu.testdemo1.ThreadFuture.future;

/**
 * 　　* @description: ${name}
 * 　　* @param ${tags}
 * 　　* @return ${return_type}
 * 　　* @throws
 * 　　* @author 83915
 * 　　* @date $date$ $time$
 *
 */
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

}
