package bdp;

import java.util.ArrayList;
import java.util.List;

interface Subject {
	public void attach(Observer O);
	public void detach(Observer O);
	public void notifyUpdate(Message M);
}

interface Observer {
	public void update(Message m);
}

class Message {
	String messagecontent;
	
	public Message(String messagecontent) {
		this.messagecontent=messagecontent;
	}
	
	public String getMessagecontent() {
		return messagecontent;
	}
}

class MessagePublisher implements Subject {
	private List<Observer> l1=new ArrayList<>();
	public void attach(Observer o) {
		l1.add(o);
	}
	
	public void detach(Observer o) {
		l1.remove(o);
	}
	
	public void notifyUpdate(Message m) {
		for(Observer ob:l1) {
			ob.update(m);
		}
	}
}

class MessageSubscriber1 implements Observer {
	public void update(Message o) {
		System.out.println("Message Subscriber 1 :"+o.getMessagecontent());
	}
}

class MessageSubscriber2 implements Observer {
	public void update(Message o) {
		System.out.println("Message Subscriber 2 :"+o.getMessagecontent());
	}
}

class MessageSubscriber3 implements Observer {
	public void update(Message o) {
		System.out.println("Message Subscriber 3 :"+o.getMessagecontent());
	}
}

public class ObserverEx {
	public static void main(String[] args) {
		MessageSubscriber1 s1=new MessageSubscriber1();
		MessageSubscriber2 s2=new MessageSubscriber2();
		MessageSubscriber3 s3=new MessageSubscriber3();
		MessagePublisher p=new MessagePublisher();
		p.attach(s1);
		p.attach(s2);
		p.notifyUpdate(new Message("This is First Message")); //s1 and s2 receives the update
		p.attach(s3);
		p.detach(s1); // s1 removed
		p.notifyUpdate(new Message("This is Second Message")); // s2 and s3 receives the update
	}
}
