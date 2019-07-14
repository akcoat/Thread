package com.zhu.testdemo1.Controller;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class TestThread {

    // 请求总数
    public static  int clientTotal =5000;
    // 同时并发执行的线程总数
    public static int ThreadTotal=50;

    public static int count;

    public static void  add(){
        count++;
    }

    public static void main(String[] args){
        ExecutorService executorService =
                Executors.newCachedThreadPool();
        final Semaphore semaphore =new Semaphore(ThreadTotal);
        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("error:{}",e.getMessage());
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
            executorService.shutdown();
            log.info("count:{}",count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
