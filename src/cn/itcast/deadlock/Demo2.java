package cn.itcast.deadlock;

public class Demo2 {
	public static void main(String[] args) {
		//创建两个实例，flag=1和flag=2
		DeadLock deadLock1 = new DeadLock(1);
		DeadLock deadLock2 = new DeadLock(2);
		//创建两个线程执行实例
		Thread thread1 = new Thread(deadLock1);
		Thread thread2 = new Thread(deadLock2);
		thread1.start();
		thread2.start();
	}
}
