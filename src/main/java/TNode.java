
public class TNode<T> {
	private T item;
	private TNode<T> nextNode;
	
	TNode(T item){
		this.item = item;
		this.nextNode = null;
	}
	
	public T get(){
		return item;
	}
	
	public TNode<T> getNext(){
		return nextNode;
	}
	
	public void setNext(TNode<T> nextNode){
		this.nextNode = nextNode;
	}
}