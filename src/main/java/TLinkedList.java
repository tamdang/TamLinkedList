import java.util.function.Predicate;

class TLinkedList<T> implements TList<T>{

	private TNode<T> firstNode = null;
	private TNode<T> lastNode = null;
	private TNode<T> cursor = null;
	
	TLinkedList(){
		this.firstNode = null;
		this.lastNode = null;
		this.cursor = null;
	}
	
	@Override
	public TNode<T> getFirst(){
		this.cursor = this.firstNode;
		return this.cursor;
	}
	
	@Override
	public boolean push(T item) {
		if(firstNode == null){
			lastNode = firstNode = new TNode<T>(item);
		}
		else{
			TNode<T> newNode = new TNode<T>(item);
			lastNode.setNext(newNode);
			lastNode = newNode;
		}
		return true;
	}

	@Override
	public boolean pop() {
		if(lastNode==null){
			return false;
		}
		else if(firstNode == lastNode){
			firstNode = lastNode = null;
		}
		else{
			TNode<T> cursor = firstNode;
			while(cursor!=null){
				if(cursor.getNext() == lastNode){
					cursor.setNext(null);
					lastNode = cursor;
					break;
				}
				else{
					cursor = cursor.getNext();
				}
			}
		}
		return true;
	}

	@Override
	public void takeOut(Predicate<T> predicate) {
		TNode<T> cursor = firstNode; 
		TNode<T> prvNode = null;
		while(cursor!=null){
			if(predicate.test(cursor.get())){
				if(cursor==firstNode){
					firstNode = cursor.getNext();
					if(cursor==lastNode){
						lastNode = null;
					}
				}
				else{
					if(lastNode==cursor){
						if(prvNode!=null){
							prvNode.setNext(null);	
						}
						lastNode = prvNode;
					}
					else{
						if(prvNode!=null){
							prvNode.setNext(cursor.getNext());	
						}
					}
				}
			}
			else{
				prvNode = cursor;
			}
			cursor = cursor.getNext();	
		}
	}

}