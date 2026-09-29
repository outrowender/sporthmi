/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor;

import de.audi.atip.hmi.model.texteditor.LinkedList;
import de.audi.atip.hmi.model.texteditor.ListNode;
import de.audi.atip.hmi.modelaccess.ICopyTo;
import de.audi.atip.log.LogChannel;

public class CursoredLinkedList
implements ICopyTo {
    private static LogChannel lc;
    public static final int INS_LIST_CURSOR_ENUM_FIRST;
    public static final int INS_LIST_CURSOR_STAYS;
    public static final int INS_LIST_CURSOR_FIRST_NEW;
    public static final int INS_LIST_CURSOR_LAST_NEW;
    public static final int INS_LIST_CURSOR_ENUM_LAST;
    public LinkedList list;
    public ListNode current;
    public ListNode head;
    public ListNode tail;

    public CursoredLinkedList(LogChannel logChannel) {
        lc = logChannel;
        this.list = new LinkedList();
        this.current = this.head = this.list.getHead();
        this.tail = this.list.getTail();
    }

    public void clear() {
        this.list.clear();
        this.current = this.list.getHead();
    }

    public ListNode getCNode() {
        return this.current;
    }

    public ICopyTo[] getCData() {
        return this.current != null ? this.current.data : null;
    }

    public boolean insertMoveCLeft(ICopyTo[] iCopyToArray) {
        if (iCopyToArray == null) {
            return false;
        }
        ListNode listNode = new ListNode(iCopyToArray);
        this.list.insertLeft(this.current, listNode);
        this.current = listNode;
        return true;
    }

    public boolean insertMoveCRight(ICopyTo[] iCopyToArray) {
        if (iCopyToArray == null) {
            return false;
        }
        ListNode listNode = new ListNode(iCopyToArray);
        this.list.insertRight(this.current, listNode);
        this.current = listNode;
        return true;
    }

    private ListNode getNewCurrent(ListNode listNode, ListNode listNode2, int n) {
        boolean bl;
        ListNode listNode3 = null;
        boolean bl2 = bl = listNode != null && listNode2 != null && n >= 0 && n <= 2;
        if (bl) {
            listNode3 = n == 2 ? listNode2 : (n == 0 ? this.current : listNode);
        }
        return listNode3;
    }

    public boolean insertSectionLeft(int n, ListNode listNode, ListNode listNode2, int n2) {
        boolean bl;
        ListNode listNode3 = this.getNewCurrent(listNode, listNode2, n2);
        boolean bl2 = bl = listNode3 != null;
        if (bl) {
            this.list.insertLeft(this.current, listNode, listNode2, n);
            this.current = listNode3;
        }
        return bl;
    }

    public boolean insertSectionLeft(ListNode listNode, ListNode listNode2, int n) {
        boolean bl;
        ListNode listNode3 = this.getNewCurrent(listNode, listNode2, n);
        boolean bl2 = bl = listNode3 != null;
        if (bl) {
            this.list.insertLeft(this.current, listNode, listNode2);
            this.current = listNode3;
        }
        return bl;
    }

    public boolean insertSectionRight(int n, ListNode listNode, ListNode listNode2, int n2) {
        boolean bl;
        ListNode listNode3 = this.getNewCurrent(listNode, listNode2, n2);
        boolean bl2 = bl = listNode3 != null;
        if (bl) {
            this.list.insertRight(this.current, listNode, listNode2, n);
            this.current = listNode3;
        }
        return bl;
    }

    public boolean insertSectionRight(ListNode listNode, ListNode listNode2, int n) {
        boolean bl;
        ListNode listNode3 = this.getNewCurrent(listNode, listNode2, n);
        boolean bl2 = bl = listNode3 != null;
        if (bl) {
            this.list.insertRight(this.current, listNode, listNode2);
            this.current = listNode3;
        }
        return bl;
    }

    public boolean moveLeft() {
        boolean bl;
        boolean bl2 = bl = this.current != null && this.current.left != null && this.current != this.list.getHead();
        if (bl) {
            this.current = this.current.left;
        }
        return bl;
    }

    public boolean moveRight() {
        boolean bl;
        boolean bl2 = bl = this.current != null && this.current.right != null && this.current != this.list.getTail();
        if (bl) {
            this.current = this.current.right;
        }
        return bl;
    }

    public boolean move(int n) {
        int n2 = this.list.getSize();
        ListNode listNode = this.list.getHead();
        ListNode listNode2 = this.list.getTail();
        if (n >= n2) {
            this.current = listNode2;
            return false;
        }
        if (n < 0) {
            this.current = listNode;
            return false;
        }
        if (n < n2 / 2) {
            this.current = listNode.right;
            while (n > 0) {
                if (this.current.right != null) {
                    this.current = this.current.right;
                    --n;
                    continue;
                }
                return false;
            }
        } else {
            this.current = listNode2.left;
            for (int i2 = n2 - n - 1; i2 > 0; --i2) {
                if (this.current.left != null) {
                    this.current = this.current.left;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public ICopyTo[] removeCurrLeft() {
        ICopyTo[] iCopyToArray = null;
        if (this.getSize() > 0) {
            ListNode listNode = this.current = this.current == this.list.tail ? this.current.left : this.current;
            if (this.current != null && this.current != this.list.getHead()) {
                ListNode listNode2 = this.current;
                this.current = this.current.left;
                iCopyToArray = this.list.remove(listNode2);
            }
        }
        return iCopyToArray;
    }

    public ICopyTo[] removeLeft(ListNode listNode) {
        ICopyTo[] iCopyToArray = null;
        if (this.getSize() > 0) {
            if (this.current.equals(listNode)) {
                ListNode listNode2 = this.current = this.current == this.list.tail ? this.current.left : this.current;
                if (this.current != null && this.current != this.list.getHead()) {
                    ListNode listNode3 = this.current;
                    this.current = this.current.left;
                    iCopyToArray = this.list.remove(listNode3);
                }
            } else {
                iCopyToArray = this.list.remove(listNode);
            }
        }
        return iCopyToArray;
    }

    public ICopyTo[] removeCurrRight() {
        ICopyTo[] iCopyToArray = null;
        if (this.getSize() > 0) {
            ListNode listNode = this.current = this.current == this.list.head ? this.current.right : this.current;
            if (this.current != null && this.current != this.list.tail) {
                ListNode listNode2 = this.current;
                this.current = this.current.right;
                iCopyToArray = this.list.remove(listNode2);
            }
        }
        return iCopyToArray;
    }

    public ICopyTo[] removeRight(ListNode listNode) {
        ICopyTo[] iCopyToArray = null;
        if (this.getSize() > 0) {
            if (this.current.equals(listNode)) {
                ListNode listNode2 = this.current = this.current == this.list.head ? this.current.right : this.current;
                if (this.current != null && this.current != this.list.tail) {
                    ListNode listNode3 = this.current;
                    this.current = this.current.right;
                    iCopyToArray = this.list.remove(listNode3);
                }
            } else {
                iCopyToArray = this.list.remove(listNode);
            }
        }
        return iCopyToArray;
    }

    public void printList() {
        ListNode listNode = this.head;
        while (listNode != null) {
            String string;
            String string2 = listNode.data != null && listNode.data.length > 0 ? listNode.data[0].toString() : (string = listNode.equals(this.head) || listNode.equals(this.tail) ? " #" : " <null>");
            if (listNode.equals(this.current)) {
                System.out.print(new StringBuffer().append(" [").append(string).append("]").toString());
            } else {
                System.out.print(new StringBuffer().append(" ").append(string).toString());
            }
            listNode = listNode.right;
        }
        System.out.println(new StringBuffer().append(" <").append(this.getSize()).append(">").toString());
    }

    public int getSize() {
        return this.list.getSize();
    }

    @Override
    public boolean copyTo(ICopyTo iCopyTo) {
        if (!(iCopyTo instanceof CursoredLinkedList)) {
            return false;
        }
        CursoredLinkedList cursoredLinkedList = (CursoredLinkedList)iCopyTo;
        if (cursoredLinkedList.head == null && cursoredLinkedList.tail == null && cursoredLinkedList.list == null) {
            return false;
        }
        if (!this.list.copyTo(cursoredLinkedList.list)) {
            return false;
        }
        ListNode listNode = this.head;
        ListNode listNode2 = cursoredLinkedList.head;
        boolean bl = false;
        for (int i2 = 0; i2 < this.list.size; ++i2) {
            if (listNode.equals(this.current)) {
                cursoredLinkedList.current = listNode2;
                bl = true;
                continue;
            }
            listNode = listNode.right;
            listNode2 = listNode2.right;
        }
        return bl;
    }
}

