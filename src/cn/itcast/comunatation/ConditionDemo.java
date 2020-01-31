package cn.itcast.comunatation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
	
	private int i = 1;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	/*
	 * 基数打印方法，由基数线程调用
	 */
	public void odd() {
		while(i<=10) {
			lock.lock();
			try {
				if(i%2 == 1) {
					System.out.println("奇数："+i);
					i++;
					condition.signal();
				}else {
					try {
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
				}
			}finally {
				lock.unlock();
			}
		}	
	}
	
	/*
	 * 偶数打印方法，由偶数线程调用
	 */
	public void even() {
		while(i<=10) {
			lock.lock();
			try {
				if(i%2 == 0) {
					System.out.println("偶数："+i);
					i++;
					condition.signal();
				}else {
					try {
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
				}
			}finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		final ConditionDemo conditionDemo = new ConditionDemo();
		//开启基数线程打印
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				conditionDemo.odd();
			}
		});
		//开启偶数线程打印
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				conditionDemo.even();
			}
		});
		
		thread1.start();
		thread2.start();
	}
	
	

}
