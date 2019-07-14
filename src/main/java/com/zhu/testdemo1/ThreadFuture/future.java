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
public interface future<T> {

    T get() throws InterruptedException;


 }
