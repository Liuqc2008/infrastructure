package infrastructure.thread;

import infrastructure.thread.ThreadPoolProxy;

public class ThreadPoolProxyFactory {
    public static ThreadPoolProxy mThreadPoolProxy;
 
    public static ThreadPoolProxy getThreadPoolProxy(){
        if(mThreadPoolProxy == null){
        	
            synchronized (ThreadPoolProxyFactory.class){
                if(mThreadPoolProxy == null){
                    mThreadPoolProxy = new ThreadPoolProxy(3,3);
                }
            }
        }
        
        return mThreadPoolProxy;
    }
}