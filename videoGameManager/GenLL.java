//Daniel Chavez
public class GenLL <T> {

	public class ListNode{
		T data; 
		ListNode link;
		
		public ListNode(T data, ListNode link) 
		{
			this.data = data;
			this.link = link;
		}
	}
		private ListNode head;
		private ListNode current;
		private ListNode previous;
		private int size;
		
		//public constructor that sets everything to null (empty list)
		public GenLL()
		{
			head = current = previous = null;
			this.size = 0;
		}
	
		public void add(T aData) 
		{
			ListNode newNode = new ListNode(aData, null); //new videoGame node created
			if(head == null) { //if empty list
				head = current = newNode; //make first listNode (newNode)
				this.size = 1;
				return;
			}
			ListNode temp = head;
			while(temp.link != null) {
				temp = temp.link;
			}
			temp.link = newNode;
			this.size++;
		}
		
		public void print(){
			ListNode temp = head;
			while(temp != null) {
				System.out.println(temp.data);
				temp = temp.link;
			}
		}
		
		public void addAfterCurrent(T aData) {
			if(current == null) {
				return;
			}
			/*newNode created with videoGame data, whose link is pointing 
			to where the current.link is pointing*/
			ListNode newNode = new ListNode(aData, current.link);
			/*newNode will be in front of current so current.link has to point to
			  new node; */
			current.link = newNode;
			this.size++;
		}
		
		public T getCurrent() {
			if(current == null) { //signifies that list is empty 
				return null; 
			}
			return current.data; //returns data at current listNode
		}
		
		//changes the data at current listNode
		public void setCurrent(T aData) {
			if(aData == null || current == null) {
				return;
			}
			current.data = aData; //currents data gets replaced with user Input 
		}
		
		//moves current to next link
		public void gotoNext() {
			if(current == null) { //signifies list doesnt exist 
				return;
			}
			previous = current; //previous has to be behind current
			current = current.link;//current will point to next listNode
		}
		
		//current will point to head starting at the beginning of the list
		public void reset() {
			current = head; //points current to head
			previous = null; //if current is at head previous cannot exist
		}
		
		public boolean hasMore() { //shows if list has more values
			return current != null;
		}
	
		public void removeCurrent() {
			if(current == head) {
				head = head.link;
				current = head;
			}
			else
			{
				previous.link = current.link;
				current = current.link;
			}
			if(this.size > 0) {
				size--;
			}	
		}
		
		public int getSize() {
			return this.size;
		}
		
		public T getAt(int index) {
			if(index < 0 || index >= size) {
				return null;
			}
			ListNode temp = head;
			for(int i = 0; i <index; i++) {
				temp = temp.link;
		 	}
			return temp.data;
		}
		
		public void setAt(int index, T aData) {
			if(index < 0 || index >= size ||aData == null) {
				return;
			}
			ListNode temp = head;
			for(int i = 0; i < index; i++) {
				temp = temp.link;
			}
			temp.data = aData;
		}
				
		public void remove() {
			head = null;
		}
}