package cn.itcast.comunatation;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	
	private CountDownLatch countDownLatch = new CountDownLatch(3);
	
	//运动员方法：由运动员线程调用
	public void racer() {
		//获取运动员名称
		String name = Thread.currentThread().getName();
		System.out.println(name+"正在准备。。。");
		//线程睡眠5秒
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//运动员准备完毕
		System.out.println(name+"准备完毕！");
		//计数-1
		countDownLatch.countDown();
	}
	
	//教练方法：由教练线程调用
	public void coach() {
		//获取教练名称
		String name = Thread.currentThread().getName();
		//教练等待索引运动员准备完毕
		System.out.println(name+"正在等待运动员准备。。。");
		//调用await()等待其它线程执行完毕
		try {
			countDownLatch.await();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//所有运动员就绪，开始训练
		System.out.println("所有运动员准备就绪，"+name+"开始训练");
	}
	
	
	public static void main(String[] args) {
		//创建CountDownLatchDemo实例
		final CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
		//创建三个线程对象调用racer()
		Thread thread1 = new Thread(new Runnable() {	
			public void run() {
				countDownLatchDemo.racer();
			}
		},"运动员1");
		Thread thread2 = new Thread(new Runnable() {	
			public void run() {
				countDownLatchDemo.racer();
			}
		},"运动员2");
		Thread thread3 = new Thread(new Runnable() {	
			public void run() {
				countDownLatchDemo.racer();
			}
		},"运动员3");
		
		//创建一个线程对象调用coach()
		Thread thread4 = new Thread(new Runnable() {	
			public void run() {
				countDownLatchDemo.coach();
			}
		},"教练");
		
		thread4.start();
		thread1.start();
		thread2.start();
		thread3.start();
		
		
	}
}
