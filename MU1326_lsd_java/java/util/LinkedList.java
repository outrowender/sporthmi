/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList
extends AbstractSequentialList
implements List,
Cloneable,
Serializable {
    private static final long serialVersionUID = 876323262645176354L;
    transient int size = 0;
    transient Link voidLink;

    public LinkedList() {
        this.voidLink.previous = this.voidLink = new Link(null, null, null);
        this.voidLink.next = this.voidLink;
    }

    public LinkedList(Collection collection) {
        this();
        this.addAll(collection);
    }

    public void add(int n, Object object) {
        if (n >= 0 && n <= this.size) {
            Link link;
            int n2;
            Link link2 = this.voidLink;
            if (n < this.size / 2) {
                n2 = 0;
                while (n2 <= n) {
                    link2 = link2.next;
                    ++n2;
                }
            } else {
                n2 = this.size;
                while (n2 > n) {
                    link2 = link2.previous;
                    --n2;
                }
            }
            Link link3 = link2.previous;
            link3.next = link = new Link(object, link3, link2);
            link2.previous = link;
            ++this.size;
            ++this.modCount;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean add(Object object) {
        Link link;
        Link link2 = this.voidLink.previous;
        this.voidLink.previous = link = new Link(object, link2, this.voidLink);
        link2.next = link;
        ++this.size;
        ++this.modCount;
        return true;
    }

    public boolean addAll(int n, Collection collection) {
        int n2 = collection.size();
        if (n2 == 0) {
            return false;
        }
        if (n >= 0 && n <= this.size) {
            int n3;
            Link link = this.voidLink;
            if (n < this.size / 2) {
                n3 = 0;
                while (n3 < n) {
                    link = link.next;
                    ++n3;
                }
            } else {
                n3 = this.size;
                while (n3 >= n) {
                    link = link.previous;
                    --n3;
                }
            }
            Link link2 = link.next;
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                Link link3;
                link.next = link3 = new Link(iterator.next(), link, null);
                link = link3;
            }
            link.next = link2;
            link2.previous = link;
            this.size += n2;
            ++this.modCount;
            return true;
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean addAll(Collection collection) {
        int n = collection.size();
        if (n == 0) {
            return false;
        }
        Link link = this.voidLink.previous;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Link link2;
            link.next = link2 = new Link(iterator.next(), link, null);
            link = link2;
        }
        link.next = this.voidLink;
        this.voidLink.previous = link;
        this.size += n;
        ++this.modCount;
        return true;
    }

    public void addFirst(Object object) {
        Link link;
        Link link2 = this.voidLink.next;
        this.voidLink.next = link = new Link(object, this.voidLink, link2);
        link2.previous = link;
        ++this.size;
        ++this.modCount;
    }

    public void addLast(Object object) {
        Link link;
        Link link2 = this.voidLink.previous;
        this.voidLink.previous = link = new Link(object, link2, this.voidLink);
        link2.next = link;
        ++this.size;
        ++this.modCount;
    }

    public void clear() {
        if (this.size > 0) {
            this.size = 0;
            this.voidLink.next = this.voidLink;
            this.voidLink.previous = this.voidLink;
            ++this.modCount;
        }
    }

    public Object clone() {
        return new LinkedList(this);
    }

    /*
     * Unable to fully structure code
     */
    public boolean contains(Object var1_1) {
        block4: {
            var2_2 = this.voidLink.next;
            if (var1_1 == null) ** GOTO lbl12
            while (var2_2 != this.voidLink) {
                if (var1_1.equals(var2_2.data)) {
                    return true;
                }
                var2_2 = var2_2.next;
            }
            break block4;
lbl-1000:
            // 1 sources

            {
                if (var2_2.data == null) {
                    return true;
                }
                var2_2 = var2_2.next;
lbl12:
                // 2 sources

                ** while (var2_2 != this.voidLink)
            }
        }
        return false;
    }

    public Object get(int n) {
        if (n >= 0 && n < this.size) {
            Link link = this.voidLink;
            if (n < this.size / 2) {
                int n2 = 0;
                while (n2 <= n) {
                    link = link.next;
                    ++n2;
                }
            } else {
                int n3 = this.size;
                while (n3 > n) {
                    link = link.previous;
                    --n3;
                }
            }
            return link.data;
        }
        throw new IndexOutOfBoundsException();
    }

    public Object getFirst() {
        Link link = this.voidLink.next;
        if (link != this.voidLink) {
            return link.data;
        }
        throw new NoSuchElementException();
    }

    public Object getLast() {
        Link link = this.voidLink.previous;
        if (link != this.voidLink) {
            return link.data;
        }
        throw new NoSuchElementException();
    }

    /*
     * Unable to fully structure code
     */
    public int indexOf(Object var1_1) {
        block4: {
            var2_2 = 0;
            var3_3 = this.voidLink.next;
            if (var1_1 == null) ** GOTO lbl15
            while (var3_3 != this.voidLink) {
                if (var1_1.equals(var3_3.data)) {
                    return var2_2;
                }
                var3_3 = var3_3.next;
                ++var2_2;
            }
            break block4;
lbl-1000:
            // 1 sources

            {
                if (var3_3.data == null) {
                    return var2_2;
                }
                var3_3 = var3_3.next;
                ++var2_2;
lbl15:
                // 2 sources

                ** while (var3_3 != this.voidLink)
            }
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     */
    public int lastIndexOf(Object var1_1) {
        block4: {
            var2_2 = this.size;
            var3_3 = this.voidLink.previous;
            if (var1_1 == null) ** GOTO lbl15
            while (var3_3 != this.voidLink) {
                --var2_2;
                if (var1_1.equals(var3_3.data)) {
                    return var2_2;
                }
                var3_3 = var3_3.previous;
            }
            break block4;
lbl-1000:
            // 1 sources

            {
                --var2_2;
                if (var3_3.data == null) {
                    return var2_2;
                }
                var3_3 = var3_3.previous;
lbl15:
                // 2 sources

                ** while (var3_3 != this.voidLink)
            }
        }
        return -1;
    }

    public ListIterator listIterator(int n) {
        return new LinkIterator(this, n);
    }

    public Object remove(int n) {
        if (n >= 0 && n < this.size) {
            Link link;
            int n2;
            Link link2 = this.voidLink;
            if (n < this.size / 2) {
                n2 = 0;
                while (n2 <= n) {
                    link2 = link2.next;
                    ++n2;
                }
            } else {
                n2 = this.size;
                while (n2 > n) {
                    link2 = link2.previous;
                    --n2;
                }
            }
            Link link3 = link2.previous;
            link3.next = link = link2.next;
            link.previous = link3;
            --this.size;
            ++this.modCount;
            return link2.data;
        }
        throw new IndexOutOfBoundsException();
    }

    /*
     * Unable to fully structure code
     */
    public boolean remove(Object var1_1) {
        block3: {
            var2_2 = this.voidLink.next;
            if (var1_1 == null) ** GOTO lbl8
            while (var2_2 != this.voidLink && !var1_1.equals(var2_2.data)) {
                var2_2 = var2_2.next;
            }
            break block3;
lbl-1000:
            // 1 sources

            {
                var2_2 = var2_2.next;
lbl8:
                // 2 sources

                ** while (var2_2 != this.voidLink && var2_2.data != null)
            }
        }
        if (var2_2 == this.voidLink) {
            return false;
        }
        var3_3 = var2_2.next;
        var4_4 = var2_2.previous;
        var4_4.next = var3_3;
        var3_3.previous = var4_4;
        --this.size;
        ++this.modCount;
        return true;
    }

    public Object removeFirst() {
        Link link = this.voidLink.next;
        if (link != this.voidLink) {
            Link link2;
            this.voidLink.next = link2 = link.next;
            link2.previous = this.voidLink;
            --this.size;
            ++this.modCount;
            return link.data;
        }
        throw new NoSuchElementException();
    }

    public Object removeLast() {
        Link link = this.voidLink.previous;
        if (link != this.voidLink) {
            Link link2;
            this.voidLink.previous = link2 = link.previous;
            link2.next = this.voidLink;
            --this.size;
            ++this.modCount;
            return link.data;
        }
        throw new NoSuchElementException();
    }

    public Object set(int n, Object object) {
        if (n >= 0 && n < this.size) {
            int n2;
            Link link = this.voidLink;
            if (n < this.size / 2) {
                n2 = 0;
                while (n2 <= n) {
                    link = link.next;
                    ++n2;
                }
            } else {
                n2 = this.size;
                while (n2 > n) {
                    link = link.previous;
                    --n2;
                }
            }
            Object object2 = link.data;
            link.data = object;
            return object2;
        }
        throw new IndexOutOfBoundsException();
    }

    public int size() {
        return this.size;
    }

    public Object[] toArray() {
        int n = 0;
        Object[] objectArray = new Object[this.size];
        Link link = this.voidLink.next;
        while (link != this.voidLink) {
            objectArray[n++] = link.data;
            link = link.next;
        }
        return objectArray;
    }

    public Object[] toArray(Object[] objectArray) {
        int n = 0;
        if (this.size > objectArray.length) {
            objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), this.size);
        }
        Link link = this.voidLink.next;
        while (link != this.voidLink) {
            objectArray[n++] = link.data;
            link = link.next;
        }
        if (n < objectArray.length) {
            objectArray[n] = null;
        }
        return objectArray;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            objectOutputStream.writeObject(iterator.next());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.size = objectInputStream.readInt();
        Link link = this.voidLink = new Link(null, null, null);
        int n = this.size;
        while (--n >= 0) {
            Link link2;
            link.next = link2 = new Link(objectInputStream.readObject(), link, null);
            link = link2;
        }
        link.next = this.voidLink;
        this.voidLink.previous = link;
    }

    private static final class Link {
        Object data;
        Link previous;
        Link next;

        Link(Object object, Link link, Link link2) {
            this.data = object;
            this.previous = link;
            this.next = link2;
        }
    }

    private static final class LinkIterator
    implements ListIterator {
        int pos;
        int expectedModCount;
        final LinkedList list;
        Link link;
        Link lastLink;

        LinkIterator(LinkedList linkedList, int n) {
            this.list = linkedList;
            this.expectedModCount = this.list.modCount;
            if (n >= 0 && n <= this.list.size) {
                this.link = this.list.voidLink;
                if (n < this.list.size / 2) {
                    this.pos = -1;
                    while (this.pos + 1 < n) {
                        this.link = this.link.next;
                        ++this.pos;
                    }
                } else {
                    this.pos = this.list.size;
                    while (this.pos >= n) {
                        this.link = this.link.previous;
                        --this.pos;
                    }
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public void add(Object object) {
            if (this.expectedModCount == this.list.modCount) {
                Link link;
                Link link2 = this.link.next;
                this.link.next = link = new Link(object, this.link, link2);
                link2.previous = link;
                this.link = link;
                this.lastLink = null;
                ++this.pos;
                ++this.expectedModCount;
                ++this.list.size;
                ++this.list.modCount;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            return this.link.next != this.list.voidLink;
        }

        public boolean hasPrevious() {
            return this.link != this.list.voidLink;
        }

        public Object next() {
            if (this.expectedModCount == this.list.modCount) {
                Link link = this.link.next;
                if (link != this.list.voidLink) {
                    this.lastLink = this.link = link;
                    ++this.pos;
                    return this.link.data;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        public int nextIndex() {
            return this.pos + 1;
        }

        public Object previous() {
            if (this.expectedModCount == this.list.modCount) {
                if (this.link != this.list.voidLink) {
                    this.lastLink = this.link;
                    this.link = this.link.previous;
                    --this.pos;
                    return this.lastLink.data;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        public int previousIndex() {
            return this.pos;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public void remove() {
            Link link;
            if (this.expectedModCount != this.list.modCount) throw new ConcurrentModificationException();
            if (this.lastLink == null) throw new IllegalStateException();
            Link link2 = this.lastLink.next;
            link2.previous = link = this.lastLink.previous;
            link.next = link2;
            if (this.lastLink == this.link) {
                --this.pos;
            }
            this.link = link;
            this.lastLink = null;
            ++this.expectedModCount;
            --this.list.size;
            ++this.list.modCount;
        }

        public void set(Object object) {
            if (this.expectedModCount == this.list.modCount) {
                if (this.lastLink == null) {
                    throw new IllegalStateException();
                }
            } else {
                throw new ConcurrentModificationException();
            }
            this.lastLink.data = object;
        }
    }
}

