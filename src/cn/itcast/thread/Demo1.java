package cn.itcast.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {
	public static void main(String[] args) {
		
		/*
		 * 方式一：继承Thread类
		//创建自定义线程类实例
		MyThread myThread = new MyThread();
		//启动线程
		myThread.start();
		*/
		//在main主线程打印信息
		/*
		for(int i=0;i<10;i++) {
			System.err.println("main主线程执行："+new Date().getTime());
		}
		*/
		
		//方式二：实现Runnable接口
		//实现Runable接口
		//在main主线程打印信息
		//通过Thread类执行
		/*
		Thread thread = new Thread(new MyRunnable());
		thread.start();
		*/
		
		//方式二：实现Callable接口
		//实现callable接口
		//创建Futuretask实例，创建MyCallable实例
		/*
		FutureTask<String> futureTask = new FutureTask<String>(new Mycallable());
		//创建Thread实例，执行Futuretask
		Thread thread = new Thread(futureTask);
		thread.start();
		//在主线程打印信息
		try {
			String result = futureTask.get();
			System.out.println("执行结果："+result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//1.使用Executors创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //2.通过线程池执行线程
        executorService.execute(new MyRunnable());
        //3.主线程循环打印
        for (int i=0; i<10; i++){
            System.err.println("main主线程正在执行："+new Date().getTime());
        }
		
		
	}

}
