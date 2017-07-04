import java.util.function.Predicate;

interface TList<T> {
	public TNode<T> getFirst();
	public boolean push(T item);
	public boolean pop();
	public void takeOut(Predicate<T> predicate);  
}
