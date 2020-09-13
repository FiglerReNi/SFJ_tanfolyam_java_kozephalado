package queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueApplication {

	public static void main(String[] args) {
		Queue<String> qu = new PriorityQueue<>();
		//hoozáadás a queue-hoz offer vagy add
		qu.offer("elsõ");
		qu.offer("második");;
		qu.offer("harmadik");
		qu.offer("4");
		qu.offer("3");
		//a qu.peek megadja a sorban következõ elemet,
		//a qu berendezi magának az elemeket, alapból abc sorrendben elõl számok aztán betûk szerint
		System.out.println(qu.peek());
		//a soron következõ elemet törli és ki is tudjuk íratni az értékét
		System.out.println(qu.poll());
		System.out.println(qu.poll());
		//ha közben adunk hozzá, berendezi a sorba
		qu.offer("kettõ");
		System.out.println(qu.poll());
		System.out.println(qu.poll());
		System.out.println(qu.poll());
		System.out.println(qu.poll());

		//ha meg akarjuk õrizni a beviteli sorrendet (FIFO amit elõször beviszünk az jön ki elõször egy poll-al)
		Queue<String> qu1 = new LinkedList<>();
		qu1.add("elsõ");
		qu1.add("második");;
		qu1.add("harmadik");
		qu1.add("4");
		qu1.add("3");
		System.out.println(qu1.poll());
		System.out.println(qu1.poll());
		qu1.add("kettõ");
		System.out.println(qu1.poll());
		System.out.println(qu1.poll());
		System.out.println(qu1.poll());
		System.out.println(qu1.poll());
		
		//szó hosszúság szerint sorbarendezve
		Queue<String> qu2 = new PriorityQueue<>((a, b) -> a.length()-b.length());
		qu2.offer("elsõ");
		qu2.offer("második");;
		qu2.offer("harmadik");
		qu2.offer("4");
		qu2.offer("3");
		System.out.println(qu2.poll());
		System.out.println(qu2.poll());
		qu2.offer("kettõ");
		System.out.println(qu2.poll());
		System.out.println(qu2.poll());
		System.out.println(qu2.poll());
		System.out.println(qu2.poll());
		
		
		//STACK a legutolsót veszi ki legelõször (LIFO)
		Stack<String> st = new Stack<>();
		//elem hozzáadása add vagy push
		st.push("legalja");
		st.push("közepe");
		st.push("kút");
		//kiveszi a legutoljára betett elemet
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		
		//Túl poll megakadályozása
		Stack<String> st1 = new Stack<>();
		st1.push("legalja");
		st1.push("közepe");
		st1.push("kút");
		printStack(st1);
		st1.pop();
		printStack(st1);
		st1.pop();
		printStack(st1);
		st1.pop();
		printStack(st1);
		}
	
	public static void printStack(Stack<String> st) {
		System.out.println(st.isEmpty() ? "A verem üres" : st.toString()); 
	}
}
