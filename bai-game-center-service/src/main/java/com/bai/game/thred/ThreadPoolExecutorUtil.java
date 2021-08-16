package com.bai.game.thred;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 *
 * @author Bai
 * @date 2021/8/15 20:43
 */
public class ThreadPoolExecutorUtil {

	public static ThreadPoolExecutor getPool (String name) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(15, 50, 60, TimeUnit.MINUTES,
			new LinkedBlockingQueue<>(10000), new CustomThreadFactory(name));
		return threadPoolExecutor;
	}
}
