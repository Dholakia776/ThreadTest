package cn.itcast.deadlock;

public class DeadLock implements Runnable {

	private int flag;	//决定线程走向的标记
	private static Object obj1 = new Object();	//锁对象1
	private static Object obj2 = new Object();	//锁对象2
	
	public DeadLock(int flag) {
		this.flag = flag;
	}
	@Override
	public void run() {
		if(flag == 1) {
			//线程1执行的代码：用于一个资源请求另一个资源
			synchronized (obj1) {
				System.out.println(Thread.currentThread().getName()+"已获取obj1，正在请求obj2");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (obj2) {
					System.err.println(Thread.currentThread().getName()+"已获取obj1和obj2");
				}
			}
		}else {
			//线程2执行的代码
			synchronized (obj2) {
				System.out.println(Thread.currentThread().getName()+"已获取obj2，正在请求obj1");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (obj1) {
					System.err.println(Thread.currentThread().getName()+"已获取obj1和obj2");
				}
			}
		}

	}

}
