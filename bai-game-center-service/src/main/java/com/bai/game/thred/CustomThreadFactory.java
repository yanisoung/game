package com.bai.game.thred;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Bai
 * @date 2021/8/15 20:45
 */
public class CustomThreadFactory implements ThreadFactory {

	private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
	private static final AtomicInteger THREAD_NUMBER = new AtomicInteger(1);
	private final ThreadGroup threadGroup;
	private final String namePrefix;

	public CustomThreadFactory (String name) {
		SecurityManager s = System.getSecurityManager();
		threadGroup = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
		namePrefix = name + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
	}

	@Override
	public Thread newThread (Runnable r) {
		Thread t = new Thread(threadGroup, r, namePrefix + THREAD_NUMBER.getAndIncrement(), 0);
		if (t.isDaemon()) {
			t.setDaemon(false);
		}
		if (t.getPriority() != Thread.NORM_PRIORITY) {
			t.setPriority(Thread.NORM_PRIORITY);
		}
		return t;
	}
}
