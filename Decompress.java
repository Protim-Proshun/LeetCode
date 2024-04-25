public class Decompress {

    class DecompressNode {
        int data;
        DecompressNode next;

        public DecompressNode() {
            data = 0;
            next = null;
        }

        public DecompressNode(int data, DecompressNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public DecompressNode head;
    int listCount = 0;

    public void addToEnd(int data) {
        DecompressNode newNode = new DecompressNode(data, null);
        if(head == null) {
            head = newNode;
        }
        else {
            DecompressNode temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        listCount++;
    }

    public int[] decompressRLElist(int[] nums) {
        int arrayLength = nums.length;
        Decompress list1 = new Decompress();
        Decompress list2 = new Decompress();
        for(int i = 0; i < arrayLength; i++) {
            list1.addToEnd(nums[i]);
        }
        //list1.showList();
        DecompressNode temp = list1.head;
        for(int i = 0 ;; i++) {
            if(i % 2 == 0) {
                int freq = temp.data;
                temp = temp.next;
                if(temp == null) {
                    break;
                }
                int val = temp.data;
                for(int j = 0; j < freq; j++) {
                    list2.addToEnd(val);
                }
                temp = temp.next;
                if(temp == null) {
                    break;
                }
                //System.out.println(i);
            }
        }
        //list2.showList();

        temp = list2.head;
        int[] newArray = new int[list2.listCount];
        for(int i = 0; i < newArray.length; i++) {
            newArray[i] = temp.data;
            temp = temp.next;
            if(temp == null) {
                break;
            }
        }
        return newArray;
    }

    public void showList() {
        if(head == null) {
            System.out.println("The list is empty");
        }
        else {
            DecompressNode temp = head;
            while(temp.next != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print(temp.data + "\n");
        }
    }

}
