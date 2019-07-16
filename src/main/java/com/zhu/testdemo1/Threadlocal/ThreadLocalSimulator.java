package com.zhu.testdemo1.Threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * 　　* @description: ${name}
 * 　　* @param ${tags}
 * 　　* @return ${return_type}
 * 　　* @throws
 * 　　* @author 83915
 * 　　* @date $date$ $time$
 *
 */
public class ThreadLocalSimulator<T> {

    private final Map<Thread,T> map = new HashMap<>();


    final T get(){
        synchronized (this){
            Thread thread = Thread.currentThread();
            T t =map.get(thread);
            if(t==null){
                return initValue();
            }
            return  t;
        }

    }


    final void set(T t){
        synchronized (this){
            Thread thread = Thread.currentThread();
            map.put(thread,t);
        }
    }

    public T initValue(){

        return null;
    }

}
