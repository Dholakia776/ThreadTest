package cn.itcast.comunatation;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	
	static class Work implements Runnable{
		private int workNum;	//工人工号
		private Semaphore semaphore;	//机器数
		
		public Work(int workNum, Semaphore semaphore) {
			super();
			this.workNum = workNum;
			this.semaphore = semaphore;
		}
		
		public void run() {
			//工人获取机器
			try {
				semaphore.acquire();
				//打印
				String name = Thread.currentThread().getName();
				System.out.println(name+"获取到机器，开始工作。。");
				//线程休眠5秒
				Thread.sleep(5000);
				//使用完毕
				semaphore.release();
				System.out.println(name+"使用完毕，释放机器！！！");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	public static void main(String[] args) {
		int workers = 8;
		Semaphore semaphore = new Semaphore(3);
		
		for(int i=0;i<workers;i++) {
			new Thread(new Work(i, semaphore)).start();
		}
		
		
		
		
		
		
	}
}
