/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // merging one by one
        //k lists
        // N total nodes 
        // tc O(N*K)
        //sc O(1)
        if(lists.length==0)return null;
        ListNode merged = lists[0];
        for(int i=1;i<lists.length;i++){
            merged = merge(merged , lists[i]);
        }
        return merged;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(l1!=null && l2!=null){
        if(l1.val <= l2.val){
            temp.next = l1;
            l1 = l1.next;
        }
        else{
            temp.next = l2;
            l2= l2.next;
        }
        temp = temp.next;
        }
        if(l1 != null)
        temp.next = l1;
        if(l2 != null)
        temp.next = l2;
        return dummy.next;
    }
}




//         // sorting NlongN
//         ArrayList<Integer> arr = new ArrayList<>();
//         for(ListNode head : lists){
//             while(head!=null){
//                 arr.add(head.val);
//                 head = head.next;
//             }
//         }
//         Collections.sort(arr);
//         ListNode dummy = new ListNode(-1);
//         ListNode temp = dummy;
//         for(int i : arr){
//             temp.next=new ListNode(i);
//             temp= temp.next;
//         }
        
//         return dummy.next;
        
//     }
// }