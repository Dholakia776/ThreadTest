package cn.itcast.lockTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLTest {
	
	private Map<String,String> map = new HashMap<String,String>();
	private ReentrantReadWriteLock rLock = new ReentrantReadWriteLock();
	private ReentrantReadWriteLock.ReadLock readLock = rLock.readLock();		//读操作锁
	private ReentrantReadWriteLock.WriteLock writeLock = rLock.writeLock();		//写操作锁
	
	public String get(String key) {
		readLock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"--读操作已加锁，开始读操作。。。");
			Thread.sleep(3000);
			return map.get(key);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			readLock.unlock();
			System.out.println(Thread.currentThread().getName()+"--读操作已解锁，读操作结束");
		}
	}
	
	public void put(String key, String value) {
		writeLock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"++写操作已加锁，开始写操作。。。");
			Thread.sleep(3000);
			map.put(key,value);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			writeLock.unlock();
			System.out.println(Thread.currentThread().getName()+"--写操作已解锁，写操作结束");
		}
	}
	
	public static void main(String[] args) {
		final ReadWriteLTest readWriteLTest = new ReadWriteLTest();
		readWriteLTest.put("公孙离", "19");
		new Thread("读线程1") {
			public void run() {
				readWriteLTest.get("公孙离");
			}
		}.start();
		new Thread("读线程2") {
			public void run() {
				readWriteLTest.get("公孙离");
			}
		}.start();
		new Thread("读线程3") {
			public void run() {
				readWriteLTest.get("公孙离");
			}
		}.start();
	}
	
}
