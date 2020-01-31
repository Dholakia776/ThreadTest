package cn.itcast.comunatation;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	
	private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
	
	public void startThread() {
		//打印线程准备启动
		String name = Thread.currentThread().getName();
		System.out.println(name+"正在准备。。。");
		//调用await()等待所有线程全部准备完成
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//打印线程启动完毕信息
		System.out.println(name+"已经启动完毕："+new Date().getTime());
	}
	
	public static void main(String[] args) {
		CyclicBarrierDemo barrierDemo = new CyclicBarrierDemo();
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				barrierDemo.startThread();
			}
		},"运动员1");
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				barrierDemo.startThread();
			}
		},"运动员2");
		Thread thread3 = new Thread(new Runnable() {
			public void run() {
				barrierDemo.startThread();
			}
		},"运动员3");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
}
