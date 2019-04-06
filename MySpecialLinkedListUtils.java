package second;


public class MySpecialLinkedListUtils {
	
	
	public static double [] summary(LinkedListNode head) {
		double arr[] =new double [5];
		LinkedListNode temp = head;
		double a[] =new double [1];
		a[0]=0;
		double i=0;
		
		double count = 0; 
        while (temp != null) 
        { 
            count++; 
            temp = temp.next; 
        }
        
        temp = head;
		double sum=0;
		while (temp!=null) {
			sum=sum+temp.value;
			temp=temp.next;
		}
		arr[0]=sum;
		
		temp = head; 
		double avg=(double)arr[0]/(double)count;
		arr[1]=avg;
		        
		 temp = head;
		 if (count%2==0) {
			 while (i <= count/2) 
		        { 
				 if (i==(count/2)-1)
				 {
					 arr[2]=((double)temp.value+(double)temp.next.value)/2;
					 break;
				 }
		            temp = temp.next;
		            i++;
		        }
		 }else {
			 while (i <=count/2) 
		        { 
				 if (i==((int)count/2))
				 {
					 arr[2]=(double)temp.value;
					 break;
				 }
		            temp = temp.next;
		            i++;
		        }
		 }
		 
		 i=0;
		 temp =head;
		 double max=-1000000000;
		 double min=1000000000;
		 
		 while (i<count) {
			 if (temp.value>max) {
				 max=temp.value;
			 }
			temp=temp.next;
			i++;
		 }
		 arr[3]= max;
		 
		i=0;
		temp =head;
		 while (i<count) {
			 if (temp.value<min) {
				 min=temp.value;
			 }
			temp=temp.next;
			i++;
		 }
		 arr[4]= min;
		 
		return arr ;
}
	
	public static LinkedListNode reverse (LinkedListNode head) {
		LinkedListNode next, temp = head;
		LinkedListNode prev=null;
        while (temp != null) 
        { 
        	next=temp.next;
            temp.next=prev; 
            prev=temp;
            temp=next;
        }
        head= prev;
		return head;
	}
	
	public static LinkedListNode evenIndexedElements (LinkedListNode head) {
		LinkedListNode temp=head;
		
			  while(temp!=null)
			  {
			    if((temp.next!=null)&&(temp.next.next!=null))
			    {
			     temp.next=temp.next.next;
			    }
			    temp=temp.next;
			  }	
		  return head;
	}
	
	
	public static LinkedListNode insertionSort(LinkedListNode head) {
		LinkedListNode first=head;
		LinkedListNode second=head.next;
		
		while(second!=null){
			first=head;
		while(second!=first) {
		if (second.getValue() < first.getValue()){
		int temp =second.value;
		second.value=first.value;
		first.value=temp;
		}
		else {
			first=first.next;
		}
		}
		second=second.next;
	}
		return head;
	}	
	
	public static LinkedListNode merge(LinkedListNode head,LinkedListNode head2) {
		LinkedListNode node=new LinkedListNode ();
		LinkedListNode temp=null;
		
		if (head==null) {
			return head2;
		}if (head2==null) {
			return head;
		}
		
			if (head.value<=head2.value) {
				
				node=head;
				node.next=merge(head.next,head2);
			}else {
				node=head2;
				node.next=merge(head,head2.next);
			}
		
		return node;
	}
	 
	
	
	public static LinkedListNode mergeSort(LinkedListNode head) {
		LinkedListNode list=head;
		LinkedListNode point=list.next;
		LinkedListNode NewList=new LinkedListNode ();
		
		while(point!=null) {
			point=point.next;
			if (point==null) {break;}
			point=point.next;
			list=list.next;
		}
		NewList=list.next;
		list.next=null;
		
		
       if (head==null||head.next==null) {
    	   return head;
       }
        mergeSort(head);
		mergeSort(NewList);
		head=merge(head,NewList);
		
		for(int i=0;i<6;i++) {
			System.out.println(head.value);
			head=head.next;
		}
		return head;
	}

	public static LinkedListNode removeCentralNode(LinkedListNode head) {
		LinkedListNode temp=head;
		int find=0;
		int count = 0; 
        while (temp != null) 
        { 
            count++; 
            temp = temp.next; 
        }
        temp=head;
        while (temp!=null)
        {
        	for (int i=0;i<count;i++) {
        		
        	if (count%2!=0) {
        		if (i==(count/2)-1) {
        			temp.next=temp.next.next;
        			find=1;
        			break;
        			
        		}
        	}else {
        		if (i==(count/2)-2) {
        			temp.next=temp.next.next;
        			find=1;
        			break;
        	}}
        		temp=temp.next;
        		
        	}
        	if (find==1) {
        		break;
        	}
        }
		return head;
	}
	
	public static boolean palindrome(LinkedListNode head) {
		boolean palin=false;
		LinkedListNode head2=new LinkedListNode();
		LinkedListNode temp=head;
		int i=0, count = 0; 
        while (temp != null) 
        { 
            count++; 
            temp = temp.next; 
        }
        temp=head;
		while(i<count) {
			temp = temp.next;
			if (count%2!=0) {
			if (i==(count/2)-2)
			{
				head2=temp.next.next;
				temp.next=null;

				break;
			}}else {
				if (i==(count/2)-2)
				{
					head2=temp.next;
					temp.next=null;

					break;
				}
			}
			i++;
			}
		
		LinkedListNode next, curr = head2;
		LinkedListNode prev=null;
        while (curr != null) 
        { 
        	next=curr.next;
            curr.next=prev; 
            prev=curr;
            curr=next;
        }
        head2= prev;
        
        i=0;
        int is=0;
        while(i<=count/2) {
		if (head.value==head2.value) {
			is=1;
		}else {
			break;
		}
		head=head.next;
		head2=head2.next;
		if (is==1&&i==(count/2)-1) {
			palin=true;
			break;
		}
		i++;	
		}
		return palin;
	}
	
}
	
	