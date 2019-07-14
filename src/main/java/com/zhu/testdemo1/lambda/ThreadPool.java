package com.zhu.testdemo1.lambda;

/**
 * 　　* @description: ${name}
 * 　　* @param ${tags}
 * 　　* @return ${return_type}
 * 　　* @throws
 * 　　* @author 83915
 * 　　* @date $date$ $time$
 *
 */
//线程池

import java.util.LinkedList;

/**
 * 任务队列
 * 拒绝策略（抛出异常，直接丢弃，阻塞，临时队列）
 * 初始化值 init
 * active
 * max
 */
public class ThreadPool {

    private  int size;

    private final static int DEFAULT_SIZE= 10;

    private final static LinkedList<Runnable> task_queue=new LinkedList<>();

    public ThreadPool(){
        this(DEFAULT_SIZE);
    }
    public ThreadPool(int size){
        this.size=size;
       // init();
    }


    private enum TaskState{
        FREE,RUNNING,BLOCKED,DEAD
    }

    private static class WorkerTask extends Thread{

        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group,String name){
            super(group,name);
        }

        public TaskState getTaskState(){
            return this.taskState;
        }

        public void run(){
            while (this.taskState!=TaskState.DEAD){

            }
        }

        public void close(){
            this.taskState=TaskState.DEAD;
        }

    }





}
