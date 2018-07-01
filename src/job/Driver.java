package job;

import java.util.Scanner;

import lru.LRUCache;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("LRU in running.....\n");
		System.out.println("Please enter the cache size: ");
		int cacheSize=scan.nextInt();
		
		LRUCache lruCache=new LRUCache(cacheSize, scan);
		
		lruCache.startLRUCache();

	}

}
