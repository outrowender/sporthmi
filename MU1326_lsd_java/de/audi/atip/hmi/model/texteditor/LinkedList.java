/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor;

import de.audi.atip.hmi.model.texteditor.ListNode;
import de.audi.atip.hmi.modelaccess.ICopyTo;

public class LinkedList
implements ICopyTo {
    public static final int UNKNOWN_SIZE;
    public static final boolean DEBUG;
    public ListNode head = new ListNode();
    public ListNode tail;
    public int size = 0;

    public LinkedList() {
        this.head.right = this.tail = new ListNode(this.head, null, null);
    }

    public ListNode getHead() {
        return this.head;
    }

    public ListNode getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }

    public void insertLeft(ListNode listNode, ListNode listNode2) {
        ListNode listNode3 = listNode = listNode == null ? this.tail : listNode;
        if (listNode.equals(this.head)) {
            this.insertRight(listNode, listNode2);
        } else {
            ListNode listNode4 = listNode.left;
            listNode.left = listNode2;
            listNode2.right = listNode;
            listNode2.left = listNode4;
            listNode4.right = listNode2;
            ++this.size;
        }
    }

    public int countListSectionWithValid(ListNode listNode, ListNode listNode2) {
        boolean bl;
        int n = 1;
        boolean bl2 = bl = listNode != null && listNode2 != null;
        if (bl) {
            ListNode listNode3 = listNode;
            while (!listNode3.equals(listNode2)) {
                if (listNode3 != null && listNode3.right != null && listNode3.right.left == listNode3) {
                    ++n;
                    listNode3 = listNode3.right;
                    continue;
                }
                bl = false;
                break;
            }
        }
        return bl ? n : -1;
    }

    private int countListSectionNOValid(ListNode listNode, ListNode listNode2) {
        int n = 1;
        ListNode listNode3 = listNode;
        while (!listNode3.equals(listNode2)) {
            ++n;
            listNode3 = listNode3.right;
        }
        return n;
    }

    public int countListSection(ListNode listNode, ListNode listNode2) {
        return this.countListSectionNOValid(listNode, listNode2);
    }

    public void insertLeft(ListNode listNode, ListNode listNode2, ListNode listNode3, int n) {
        int n2;
        int n3 = n2 = n < 1 ? this.countListSection(listNode2, listNode3) : n;
        if (n2 > 0) {
            ListNode listNode4 = listNode = listNode == null ? this.tail : listNode;
            if (listNode.equals(this.head)) {
                this.insertRight(listNode, listNode2, listNode3, n2);
            } else {
                listNode2.left = listNode.left;
                listNode3.right = listNode;
                listNode.left.right = listNode2;
                listNode.left = listNode3;
                this.size += n2;
            }
        }
    }

    public void insertLeft(ListNode listNode, ListNode listNode2, ListNode listNode3) {
        this.insertLeft(listNode, listNode2, listNode3, -1);
    }

    public void appendTail(ListNode listNode) {
        this.insertLeft(this.tail, listNode);
    }

    public void appendTail(ICopyTo[] iCopyToArray) {
        this.insertLeft(this.tail, new ListNode(iCopyToArray));
    }

    public void insertRight(ListNode listNode, ListNode listNode2, ListNode listNode3, int n) {
        int n2;
        int n3 = n2 = n < 1 ? this.countListSection(listNode2, listNode3) : n;
        if (n2 > 0) {
            ListNode listNode4 = listNode = listNode == null ? this.head : listNode;
            if (listNode.equals(this.tail)) {
                this.insertLeft(listNode, listNode2, listNode3, n2);
            } else {
                listNode2.left = listNode;
                listNode3.right = listNode.right;
                listNode.right.left = listNode3;
                listNode.right = listNode2;
                this.size += n2;
            }
        }
    }

    public void insertRight(ListNode listNode, ListNode listNode2, ListNode listNode3) {
        this.insertRight(listNode, listNode2, listNode3, -1);
    }

    public void insertRight(ListNode listNode, ListNode listNode2) {
        ListNode listNode3 = listNode = listNode == null ? this.head : listNode;
        if (listNode.equals(this.tail)) {
            this.insertLeft(listNode, listNode2);
        } else {
            ListNode listNode4 = listNode.right;
            listNode.right = listNode2;
            listNode2.left = listNode;
            listNode2.right = listNode4;
            listNode4.left = listNode2;
            ++this.size;
        }
    }

    public void appendHead(ListNode listNode) {
        this.insertRight(this.head, listNode);
    }

    public void appendHead(ICopyTo[] iCopyToArray) {
        this.appendHead(new ListNode(iCopyToArray));
    }

    public ICopyTo[] remove(ListNode listNode) {
        if (this.size == 0 || listNode == null) {
            return null;
        }
        if (listNode.equals(this.head)) {
            listNode = listNode.right;
        }
        if (listNode.equals(this.tail)) {
            listNode = listNode.left;
        }
        --this.size;
        listNode.left.right = listNode.right;
        listNode.right.left = listNode.left;
        listNode.left = null;
        listNode.right = null;
        return listNode.data;
    }

    public void clear() {
        if (this.tail.left != null) {
            this.tail.left.right = null;
        }
        this.tail.left = this.head;
        if (this.head.right != null) {
            this.head.right.left = null;
        }
        this.head.right = this.tail;
        this.size = 0;
    }

    public ICopyTo[][] getData() {
        ICopyTo[][] iCopyToArray;
        Object object = iCopyToArray = this.size > 0 ? new ICopyTo[this.size][] : (ICopyTo[][])null;
        if (iCopyToArray != null) {
            ListNode listNode = this.head;
            for (int i2 = 0; i2 < this.size; ++i2) {
                listNode = listNode.right;
                iCopyToArray[i2] = listNode.data;
            }
        }
        return iCopyToArray;
    }

    @Override
    public boolean copyTo(ICopyTo iCopyTo) {
        if (!(iCopyTo instanceof LinkedList)) {
            return false;
        }
        LinkedList linkedList = (LinkedList)iCopyTo;
        if (this.size == 0) {
            linkedList.clear();
            return true;
        }
        ListNode listNode = this.head;
        ListNode listNode2 = linkedList.head;
        while (listNode.right != this.tail) {
            listNode = listNode.right;
            ListNode listNode3 = listNode2 = listNode2 == linkedList.tail ? listNode2 : listNode2.right;
            if (listNode2 == linkedList.tail) {
                linkedList.appendTail((ICopyTo[])null);
                listNode.copyTo(listNode2.left);
                continue;
            }
            listNode.copyTo(listNode2);
        }
        if (listNode2.right != linkedList.tail || listNode2 != linkedList.tail) {
            if (listNode2.right != null && listNode2.right.left != null) {
                listNode2.right.left = null;
            }
            listNode2.right = linkedList.tail;
            linkedList.tail.left.right = null;
            linkedList.tail.left = listNode2;
        }
        linkedList.size = this.size;
        return true;
    }

    public static void main(String[] stringArray) {
        int n = 5;
        String[][] stringArrayArray = new String[5][];
        for (int i2 = 0; i2 < n; ++i2) {
            stringArrayArray[i2] = new String[]{Integer.toString(i2), Integer.toString(i2 + 1), Integer.toString(i2 + 2)};
        }
        System.out.println("App head");
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < n; ++i3) {
        }
        ICopyTo[][] iCopyToArray = linkedList.getData();
        System.out.println(iCopyToArray);
        System.out.println("App tail");
        LinkedList linkedList2 = new LinkedList();
        for (int i4 = 0; i4 < n; ++i4) {
        }
        ICopyTo[][] iCopyToArray2 = linkedList2.getData();
        System.out.println(iCopyToArray2);
        System.out.println("remove from head");
        ICopyTo[] iCopyToArray3 = null;
        while ((iCopyToArray3 = linkedList.remove(linkedList.head)) != null || linkedList.size != 0) {
        }
        System.out.println("remove from tail");
        iCopyToArray3 = null;
        while ((iCopyToArray3 = linkedList2.remove(linkedList2.tail)) != null || linkedList2.size != 0) {
        }
    }
}

