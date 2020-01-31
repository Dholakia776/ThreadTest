package cn.itcast.ThreadDemo1;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	static AtomicInteger n;
	public static void main(String[] args) throws InterruptedException {
		int j = 0;
		while(j < 100) {
			n = new AtomicInteger(0);
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					n.getAndIncrement();
				}		
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					n.getAndIncrement();
				}		
			}
		});
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(n);
		j++;
	}
	}
}
