package cn.itcast.lockTest;

import java.util.concurrent.locks.ReentrantLock;

public class ReenLock {
	public static void main(String[] args) {
		
		ReentrantLock reenLock = new ReentrantLock();
		for(int i=0;i<10;i++) {
			reenLock.lock();
			System.out.println("第"+(i+1)+"次 加锁");
		}
		
		for(int i=0;i<10;i++) {
			try {
				System.out.println("第"+(i+1)+"次 解锁");
			}finally {
				reenLock.unlock();
			}
		}
	}
	

}
