package com.single;

/**
 * ThreadLocal线程单例
 */
public class ThreadLocalInstance {
    private static final ThreadLocal<ThreadLocalInstance> thread
            = new ThreadLocal<ThreadLocalInstance>(){
        @Override
        protected ThreadLocalInstance initialValue() {
            return new ThreadLocalInstance();
        }
    };

    private ThreadLocalInstance(){

    }

    public static ThreadLocalInstance getInstance(){
        return thread.get();
    }
}
