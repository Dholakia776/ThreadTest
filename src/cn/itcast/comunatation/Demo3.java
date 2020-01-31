package cn.itcast.comunatation;

public class Demo3 {
	
	private int i = 1;
	private Object obj = new Object();
	/*
	 * 基数打印方法，由基数线程调用
	 */
	public void odd() {
		while(i<=10) {
			synchronized (obj) {
				if(i%2 == 1) {
					System.out.println("奇数："+i);
					i++;
					obj.notify();
				}else {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
			
	}
	
	/*
	 * 偶数打印方法，由偶数线程调用
	 */
	public void even() {
		while(i<=10) {
			synchronized (obj) {
				if(i%2 == 0) {
					System.out.println("偶数："+i);
					i++;
					obj.notify();
				}else {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		final Demo3 demo3 = new Demo3();
		//开启基数线程打印
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				demo3.odd();
			}
		});
		//开启偶数线程打印
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				demo3.even();
			}
		});
		
		thread1.start();
		thread2.start();
	}
	
}
