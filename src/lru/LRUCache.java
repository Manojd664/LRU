package lru;

import java.util.*;
import java.io.*;

import classes.*;

public class LRUCache {
	private int countCacheSize;
	private int cacheSize;
	public Scanner scan;
	private Map<Integer, Student> studentMap;
	private QueueNode head, tail;

	public LRUCache(int cacheSize, Scanner scan) {
		countCacheSize = 0;
		this.cacheSize = cacheSize;
		this.scan = scan;
		studentMap = new HashMap<>();
		head = null;
		tail = null;
	}

	//method to ask user for choice and calls corresponding method
	public void startLRUCache() {
		while (true) {
			System.out.println("Please choose an option:\n1.Continueue \n2.Exit:\n");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the roll no: ");
				int rollNo = scan.nextInt();
				if (alreadyInCache(rollNo)) {
					if (countCacheSize != 1)
						alterNodes(rollNo);
					displayDetails(rollNo);
					displayQueue();
				} else {
					addNewStudent(rollNo);
					displayDetails(rollNo);
					displayQueue();
				}
				break;

			case 2:
				System.exit(1);
			default:
				System.out.println("Wrong choice");
			}
		}
	}

	//Checks if current rollNo already in hash or not
	public boolean alreadyInCache(int rollNo) {
		if (studentMap.containsKey(rollNo))
			return true;
		else
			return false;
	}

	//Displays the details of Currently altered node
	public void displayDetails(int rollNo) {
		System.out.println("Details of currently addded/altered student in Cache: ");
		Student student = studentMap.get(rollNo);
		System.out.println("Name: "+student.getName());
		System.out.println("DOB: "+student.getDateOfBirth());
		System.out.println("Address: "+student.getAddress());
	}

	//Displays the current queue/cache
	public void displayQueue() {
		System.out.println("Current Cache: ");
		QueueNode prt = head;
		while (prt != null) {
			System.out.print(prt.getRollNo() + ", ");
			prt = prt.next;
		}
		System.out.println();
	}

	//Creates a new instance of Student and call removeNode and addNode methods
	public void addNewStudent(int rollNo) {
		System.out.println("Enter Name: ");
		String name = scan.next();
		System.out.println("Enter Date Of Birth: ");
		String dob = scan.next();
		System.out.println("Enter Address: ");
		String address = scan.next();
		Student newStudent = new Student(rollNo, name, address, dob);
		if (countCacheSize == cacheSize) {
			removeNode();
			studentMap.put(rollNo, newStudent);
			addNode(rollNo);
		} else {
			countCacheSize++;
			studentMap.put(rollNo, newStudent);
			addNode(rollNo);
		}

	}

	//Moves current referred node to the front of Queue
	public void alterNodes(int rollNo) {
		if (tail.getRollNo() == rollNo) {
			// Deleting tail
			QueueNode temp = tail.prev.next;
			tail = tail.prev;
			tail.next = null;
			// adding at front
			temp.prev = null;
			temp.next = head;
			head.prev = temp;
			head = temp;
		} else if (head.getRollNo() != rollNo) // altering node is not head
		{
			QueueNode ptr = head;
			while (ptr.next != null) {
				if (ptr.next.getRollNo() == rollNo)
					break;
				ptr = ptr.next;
			}
			QueueNode temp = ptr.next;
			ptr.next = ptr.next.next;
			ptr.next.prev = ptr;
			// adding at front
			temp.prev = null;
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
	}

	//Adds a new node at front of Queue
	public void addNode(int rollNo) {
		// adding first node to the linked list
		QueueNode node = new QueueNode(rollNo);
		if (tail == null || head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
	}

	/*Removes the last node of the Queue*/
	public void removeNode() {
		if (tail != null) {
			tail = tail.prev;
			tail.next = null;
		}
	}
}
