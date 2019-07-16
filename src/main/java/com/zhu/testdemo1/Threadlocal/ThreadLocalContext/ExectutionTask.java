package com.zhu.testdemo1.Threadlocal.ThreadLocalContext;

/**
 * 　　* @description: ${name}
 * 　　* @param ${tags}
 * 　　* @return ${return_type}
 * 　　* @throws
 * 　　* @author 83915
 * 　　* @date $date$ $time$
 *
 */
public class ExectutionTask implements Runnable
{

    private queryFromDBAction queryFromDBAction = new queryFromDBAction();

    private  HttpAction httpAction = new HttpAction();
    @Override
    public void run() {

    }
}
