package com.zhu.testdemo1.Threadlocal;

/**
 * 　　* @description: ${name}
 * 　　* @param ${tags}
 * 　　* @return ${return_type}
 * 　　* @throws
 * 　　* @author 83915
 * 　　* @date $date$ $time$
 *
 */
public class ThreadLocalSimulatorTest
{

    private final static ThreadLocalSimulator<String> threadLocal = new ThreadLocalSimulator<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            threadLocal.set("alxe");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---"+threadLocal.get());
        });
        Thread t2 = new Thread(()->{
            threadLocal.set("yytu");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---"+threadLocal.get());
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(Thread.currentThread().getName()+"---"+threadLocal.get());


    }
}
