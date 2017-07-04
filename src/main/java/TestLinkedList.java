import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinkedList {

	@Test
	public void returnNothingWhenTheListIsEmpty() {
		TList<Integer> iList = new TLinkedList<Integer>();
		TNode<Integer> cursor = iList.getFirst();
		assertNull("Should be null since the list is just initilized",cursor);
	}
	
	@Test
	public void returnFirstElementWhenThereIsOne() {
		Integer expected = 3;
		TList<Integer> iList = new TLinkedList<Integer>();
		iList.push(expected);
		TNode<Integer> cursor = iList.getFirst();
		assertNull("Next items should be null",cursor.getNext());
		assertNotNull("Should not be null since one item is pushed in the list",cursor);
		assertSame("The first value should be the same as item pushed in the list", expected, cursor.get());
	}
	
	@Test
	public void returnAllElementsPushed() {
		TList<Integer> iList = new TLinkedList<Integer>();
		iList.push(3);
		iList.push(2);
		iList.push(4);
		
		TNode<Integer> cursor = iList.getFirst();
		assertSame("The first value should be the same as the first item pushed in the list", 3, cursor.get());
		
		cursor = cursor.getNext();
		assertSame("The second value should be the same as the second item pushed in the list", 2, cursor.get());
		
		cursor = cursor.getNext();
		assertSame("The last value should be the same as the last item pushed in the list", 4, cursor.get());
		
		assertNull("No more than 3 items contained in the list",cursor.getNext());		
	}

	@Test
	public void returnFalseWhenNoItemInTheListAfterPop(){
		TList<Integer> iList = new TLinkedList<Integer>();
		assertFalse("Should return false when poping an empty list",iList.pop());
	}
	
	@Test
	public void returnTruePopingTheOneItemList(){
		TList<Integer> iList = new TLinkedList<Integer>();
		iList.push(1);
		assertTrue("Should return true when poping an one-item-list",iList.pop());
	}
	
	@Test
	public void shouldReturnOneItemListAfterPopingThe2itemsList(){
		TList<Integer> iList = new TLinkedList<Integer>();
		iList.push(1);
		iList.push(2);
		assertTrue("Should return true when poping",iList.pop());
		TNode<Integer> cursor = iList.getFirst();
		assertSame("The first item should be 1",1,cursor.get());
		assertNull("Next item should be null",cursor.getNext());
		iList.push(3);
		cursor = cursor.getNext();
		assertSame("The next item should be 3",3,cursor.get());
		assertNull("Next item should be null",cursor.getNext());
	}

	@Test
	public void shouldRemoveItemHigherThanValue(){
		Integer filterValue = 3;
		
		TList<Integer> iList = new TLinkedList<Integer>();
		iList.push(3);
		iList.push(4);
		iList.push(1);
		iList.push(2);
		iList.push(6);
		iList.push(5);
		
		iList.takeOut(i->i>filterValue);
		
		TNode<Integer> cursor = iList.getFirst();
		while(cursor!=null){
			if(cursor.get()>filterValue){
				System.out.println("value:" + cursor.get());
				fail("There is still one item which is higher than "+filterValue);
			}
			cursor = cursor.getNext();
		}
		
		iList.push(5);
		cursor = iList.getFirst();
		assertSame("should be 3",3,cursor.get());
		cursor = cursor.getNext();
		assertSame("should be 1",1,cursor.get());
		cursor = cursor.getNext();
		assertSame("should be 2",2,cursor.get());
		cursor = cursor.getNext();
		assertSame("should be 5",5,cursor.get());
		
	}

	@Test
	public void shouldReturnEmptyListAfterFilter(){
		Integer filterValue = 5;
		
		TList<Integer> iList = new TLinkedList<Integer>();
		iList.push(7);
		
		iList.takeOut(i->i>filterValue);
		
		TNode<Integer> cursor = iList.getFirst();
		
		assertNull("Should be empty after filter",cursor);
		iList.push(3);
		iList.takeOut(i->i>filterValue);
		cursor = iList.getFirst();
		assertSame("Should be 3", 3, cursor.get());
		cursor = cursor.getNext();
		assertNull("Should be null", cursor);
		iList.push(2);
		iList.push(1);
		iList.takeOut(i->i<=filterValue);
		cursor = iList.getFirst();
		assertNull("Should be empty after filter",cursor);
	}

}
