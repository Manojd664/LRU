package classes;

public class QueueNode {

	private int rollNo;
	public QueueNode next,prev;
	
	public QueueNode(int rollNo)
	{
		this.rollNo=rollNo;
		next=null;
		prev=null;
	}

	public int getRollNo() {
		return rollNo;
	}
}
