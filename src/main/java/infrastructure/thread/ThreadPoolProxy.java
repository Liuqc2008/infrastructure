package infrastructure.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * des       线程池代理类，替线程池做一些操作，即可以暴露一些线程池本有的方法，
 *            也可以写一些对线程池的拓展方法。
 */
public class ThreadPoolProxy {
 
    ThreadPoolExecutor mThreadPoolExecutor;
    private int mCorePoolSize =20;
    private int mMaximumPoolSize =100;
 
    public ThreadPoolProxy(int corePoolSize,int maximumPoolSize){
        mCorePoolSize = corePoolSize;
        mMaximumPoolSize = maximumPoolSize;
    }
/**
 * @des 初始化线程池
 */
    private void initThreadPoolExecutor(){
 
        if(mThreadPoolExecutor==null||mThreadPoolExecutor.isShutdown()||mThreadPoolExecutor.isTerminated()){
            synchronized (ThreadPoolProxy.class){
                if(mThreadPoolExecutor==null||mThreadPoolExecutor.isShutdown()||mThreadPoolExecutor.isTerminated()){
 
                    long keepAliveTime = 0;//这里不保持时间
                    TimeUnit unit = TimeUnit.MILLISECONDS;//毫秒
                    BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();//无限队列
                    ThreadFactory threadFactory = Executors.defaultThreadFactory();//默认线程工厂
 
                    RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();//这里不对异常进行处理
                    mThreadPoolExecutor = new ThreadPoolExecutor(
                            mCorePoolSize,//线程池核心数
                            mMaximumPoolSize,//最大线程数
                            keepAliveTime,//保持时间
                            unit,//时间单位
                            workQueue,//任务队列
                            threadFactory,//线程工厂
                            handler//异常捕获器
                            );
                }
            }
        }
    }
 
    /**
     * @des 提交任务
     * @param task
     * @return 得到异步执行完成之后的结果
     */
    public Future<?> submit(Runnable task){
        initThreadPoolExecutor();
        return mThreadPoolExecutor.submit(task);
 
    }
    /**
     * @des 执行任务
     * @param task
     */
    public void execute(Runnable task){
        initThreadPoolExecutor();
        mThreadPoolExecutor.execute(task);
    }
 
    /**
     * @des 移除任务
     * @param task
     */
    public void remove(Runnable task){
        initThreadPoolExecutor();
        mThreadPoolExecutor.remove(task);
    }
}
