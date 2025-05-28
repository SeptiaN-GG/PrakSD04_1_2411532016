package Pekan6;

public class HapusDLL {
    // fungsi menghapus node awal
    public static NodeDLL delHead(NodeDLL head) {
        if (head == null) {
            return null;
        }
        NodeDLL temp = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        return head;
    }

    // fungsi menghapus di akhir
    public static NodeDLL delLast(NodeDLL head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        NodeDLL curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        // update pointer previous node
        if (curr.prev != null) {
            curr.prev.next = null;
		}
        return head;
	}
    //fungsi menghapus node posii tertentu
    public static NodeDLL delPos(NodeDLL head, int pos) {
    	//jika dll kosong
    	if (head == null) {
    		return head;
    	}
    	NodeDLL curr = head;
    	//telusuri sampai ke node yang akan dihapus
    	for (int i=1; curr != null && 1<pos;++i) {
    		curr = curr.next;
    	}
    	//jika posisi tidak ditemukan
    	if(curr == null) {
    		return head;
    	}
    	//update pointer
    	if(curr.prev!= null) {
    		curr.prev.next = curr.next;
    	}
    	if(curr.next != null) {
    		curr.next.prev = curr.prev;
    	}
    	//jika yang dihapus head
    	if(head == curr) {
    		head = curr.next;
    	}
    	return head;
    }
    public static void printList(NodeDLL head) {
    	NodeDLL curr = head;
    	while(curr != null) {
    		System.out.println(curr.data+" ");
    		curr = curr.next;
    	}
    	System.out.println();
    }
    public static void main(String[] args) {
    	//buat sebuah dll
    	NodeDLL head = new NodeDLL(1);
    	head.next = new NodeDLL(2);
    	head.next.prev = head;
    	head.next.next = new NodeDLL(3);
    	head.next.next.prev = head.next;
    	head.next.next.next = new NodeDLL(4);
    	head.next.next.next.prev = head.next.next;
    	head.next.next.next.next = new NodeDLL(5);
    	head.next.next.next.next.next = head.next.next.next;
    	
    	System.out.println("DLL Awal: ");
    	printList(head);
    	
    	System.out.println("Setelah head dihapus: ");
    	head = delHead(head);
    	printList(head);
    	
    	System.out.println("Setelah node terakhir dihapus: ");
    	head = delLast(head);
    	printList(head);
    	
    	System.out.println("Menghapus node ke 2: ");
    	head = delPos(head, 2);
    	
    	printList(head);
    	System.out.println("~Septian");
    	System.out.println("2411532016");
    	
    			
    }
}
