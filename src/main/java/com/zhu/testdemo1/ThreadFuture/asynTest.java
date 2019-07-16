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
public class asynTest
{

    public static void main(String[] args) throws InterruptedException {

        FutureService futureService = new FutureService();

        future<String> submit = futureService.submit(() -> {
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "finished";
        },(t)->{
           System.out.println(t);
        });
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------");
      //  System.out.println(submit.get());

    }

}
