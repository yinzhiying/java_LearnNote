package hehe.haha.nihao;

public class QueueArray {
	private String[] queueElem;
	private int front; // 队首
	private int rear; // 队尾

	public QueueArray() {
		queueElem = new String[100];
		front = 0;
		rear = -1;
	}

	public void inQueue(String s) throws Exception {
		if (99 == rear) {
			throw new Exception("队列已满");
		}
		queueElem[++rear] = s;
	}

	public String outQueue() throws Exception {
		if (-1 == rear) {
			throw new Exception("队列为空");
		}
		String s = queueElem[front];
		for (int i = 0; i < 99; i++) {
			queueElem[i] = queueElem[i + 1];
			rear--;
		}
		return s;
	}
}