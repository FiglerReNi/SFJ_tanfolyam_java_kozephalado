package queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueApplication {

	public static void main(String[] args) {
		Queue<String> qu = new PriorityQueue<>();
		//hooz�ad�s a queue-hoz offer vagy add
		qu.offer("els�");
		qu.offer("m�sodik");;
		qu.offer("harmadik");
		qu.offer("4");
		qu.offer("3");
		//a qu.peek megadja a sorban k�vetkez� elemet,
		//a qu berendezi mag�nak az elemeket, alapb�l abc sorrendben el�l sz�mok azt�n bet�k szerint
		System.out.println(qu.peek());
		//a soron k�vetkez� elemet t�rli �s ki is tudjuk �ratni az �rt�k�t
		System.out.println(qu.poll());
		System.out.println(qu.poll());
		//ha k�zben adunk hozz�, berendezi a sorba
		qu.offer("kett�");
		System.out.println(qu.poll());
		System.out.println(qu.poll());
		System.out.println(qu.poll());
		System.out.println(qu.poll());

		//ha meg akarjuk �rizni a beviteli sorrendet (FIFO amit el�sz�r bevisz�nk az j�n ki el�sz�r egy poll-al)
		Queue<String> qu1 = new LinkedList<>();
		qu1.add("els�");
		qu1.add("m�sodik");;
		qu1.add("harmadik");
		qu1.add("4");
		qu1.add("3");
		System.out.println(qu1.poll());
		System.out.println(qu1.poll());
		qu1.add("kett�");
		System.out.println(qu1.poll());
		System.out.println(qu1.poll());
		System.out.println(qu1.poll());
		System.out.println(qu1.poll());
		
		//sz� hossz�s�g szerint sorbarendezve
		Queue<String> qu2 = new PriorityQueue<>((a, b) -> a.length()-b.length());
		qu2.offer("els�");
		qu2.offer("m�sodik");;
		qu2.offer("harmadik");
		qu2.offer("4");
		qu2.offer("3");
		System.out.println(qu2.poll());
		System.out.println(qu2.poll());
		qu2.offer("kett�");
		System.out.println(qu2.poll());
		System.out.println(qu2.poll());
		System.out.println(qu2.poll());
		System.out.println(qu2.poll());
		
		
		//STACK a legutols�t veszi ki legel�sz�r (LIFO)
		Stack<String> st = new Stack<>();
		//elem hozz�ad�sa add vagy push
		st.push("legalja");
		st.push("k�zepe");
		st.push("k�t");
		//kiveszi a legutolj�ra betett elemet
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		
		//T�l poll megakad�lyoz�sa
		Stack<String> st1 = new Stack<>();
		st1.push("legalja");
		st1.push("k�zepe");
		st1.push("k�t");
		printStack(st1);
		st1.pop();
		printStack(st1);
		st1.pop();
		printStack(st1);
		st1.pop();
		printStack(st1);
		}
	
	public static void printStack(Stack<String> st) {
		System.out.println(st.isEmpty() ? "A verem �res" : st.toString()); 
	}
}
