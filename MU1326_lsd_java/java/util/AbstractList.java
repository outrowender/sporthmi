/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public abstract class AbstractList
extends AbstractCollection
implements List {
    protected transient int modCount = 0;

    protected AbstractList() {
    }

    public void add(int n, Object object) {
        throw new UnsupportedOperationException();
    }

    public boolean add(Object object) {
        this.add(this.size(), object);
        return true;
    }

    public boolean addAll(int n, Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(n++, iterator.next());
        }
        return !collection.isEmpty();
    }

    public void clear() {
        this.removeRange(0, this.size());
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof List) {
            List list = (List)object;
            if (list.size() != this.size()) {
                return false;
            }
            Iterator iterator = this.iterator();
            Iterator iterator2 = list.iterator();
            while (iterator.hasNext()) {
                Object object2 = iterator.next();
                Object object3 = iterator2.next();
                if (!(object2 == null ? object3 != null : !object2.equals(object3))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public abstract Object get(int var1);

    public int hashCode() {
        int n = 1;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            n = 31 * n + (object == null ? 0 : object.hashCode());
        }
        return n;
    }

    /*
     * Unable to fully structure code
     */
    public int indexOf(Object var1_1) {
        block2: {
            var2_2 = this.listIterator();
            if (var1_1 == null) ** GOTO lbl9
            while (var2_2.hasNext()) {
                if (!var1_1.equals(var2_2.next())) continue;
                return var2_2.previousIndex();
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                if (var2_2.next() != null) continue;
                return var2_2.previousIndex();
lbl9:
                // 2 sources

                ** while (var2_2.hasNext())
            }
        }
        return -1;
    }

    public Iterator iterator() {
        return new SimpleListIterator();
    }

    /*
     * Unable to fully structure code
     */
    public int lastIndexOf(Object var1_1) {
        block2: {
            var2_2 = this.listIterator(this.size());
            if (var1_1 == null) ** GOTO lbl9
            while (var2_2.hasPrevious()) {
                if (!var1_1.equals(var2_2.previous())) continue;
                return var2_2.nextIndex();
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                if (var2_2.previous() != null) continue;
                return var2_2.nextIndex();
lbl9:
                // 2 sources

                ** while (var2_2.hasPrevious())
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        return this.listIterator(0);
    }

    public ListIterator listIterator(int n) {
        return new FullListIterator(n);
    }

    public Object remove(int n) {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int n, int n2) {
        ListIterator listIterator = this.listIterator(n);
        int n3 = n;
        while (n3 < n2) {
            listIterator.next();
            listIterator.remove();
            ++n3;
        }
    }

    public Object set(int n, Object object) {
        throw new UnsupportedOperationException();
    }

    public List subList(int n, int n2) {
        if (n >= 0 && n2 <= this.size()) {
            if (n <= n2) {
                if (this instanceof RandomAccess) {
                    return new SubAbstractListRandomAccess(this, n, n2);
                }
                return new SubAbstractList(this, n, n2);
            }
            throw new IllegalArgumentException();
        }
        throw new IndexOutOfBoundsException();
    }

    private static class SubAbstractList
    extends AbstractList {
        private final AbstractList fullList;
        private int offset;
        private int size;

        SubAbstractList(AbstractList abstractList, int n, int n2) {
            this.fullList = abstractList;
            this.modCount = this.fullList.modCount;
            this.offset = n;
            this.size = n2 - n;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public void add(int n, Object object) {
            if (this.modCount != this.fullList.modCount) throw new ConcurrentModificationException();
            if (n < 0 || n > this.size) throw new IndexOutOfBoundsException();
            this.fullList.add(n + this.offset, object);
            ++this.size;
            this.modCount = this.fullList.modCount;
        }

        public boolean addAll(int n, Collection collection) {
            if (this.modCount == this.fullList.modCount) {
                if (n >= 0 && n <= this.size) {
                    boolean bl = this.fullList.addAll(n + this.offset, collection);
                    if (bl) {
                        this.size += collection.size();
                        this.modCount = this.fullList.modCount;
                    }
                    return bl;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

        public boolean addAll(Collection collection) {
            if (this.modCount == this.fullList.modCount) {
                boolean bl = this.fullList.addAll(this.size, collection);
                if (bl) {
                    this.size += collection.size();
                    this.modCount = this.fullList.modCount;
                }
                return bl;
            }
            throw new ConcurrentModificationException();
        }

        public Object get(int n) {
            if (this.modCount == this.fullList.modCount) {
                if (n >= 0 && n <= this.size) {
                    return this.fullList.get(n + this.offset);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

        public Iterator iterator() {
            return this.listIterator(0);
        }

        public ListIterator listIterator(int n) {
            if (this.modCount == this.fullList.modCount) {
                if (n >= 0 && n <= this.size) {
                    return new SubAbstractListIterator(this.fullList.listIterator(n + this.offset), this, this.offset, this.size);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

        public Object remove(int n) {
            if (this.modCount == this.fullList.modCount) {
                if (n >= 0 && n <= this.size) {
                    Object object = this.fullList.remove(n + this.offset);
                    --this.size;
                    this.modCount = this.fullList.modCount;
                    return object;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

        protected void removeRange(int n, int n2) {
            if (n != n2) {
                if (this.modCount == this.fullList.modCount) {
                    this.fullList.removeRange(n + this.offset, n2 + this.offset);
                    this.size -= n2 - n;
                    this.modCount = this.fullList.modCount;
                } else {
                    throw new ConcurrentModificationException();
                }
            }
        }

        public Object set(int n, Object object) {
            if (this.modCount == this.fullList.modCount) {
                if (n >= 0 && n <= this.size) {
                    return this.fullList.set(n + this.offset, object);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

        public int size() {
            return this.size;
        }

        void sizeChanged(boolean bl) {
            this.size = bl ? ++this.size : --this.size;
            this.modCount = this.fullList.modCount;
        }

        private static final class SubAbstractListIterator
        implements ListIterator {
            private final SubAbstractList subList;
            private final ListIterator iterator;
            private int start;
            private int end;

            SubAbstractListIterator(ListIterator listIterator, SubAbstractList subAbstractList, int n, int n2) {
                this.iterator = listIterator;
                this.subList = subAbstractList;
                this.start = n;
                this.end = this.start + n2;
            }

            public void add(Object object) {
                this.iterator.add(object);
                this.subList.sizeChanged(true);
                ++this.end;
            }

            public boolean hasNext() {
                return this.iterator.nextIndex() < this.end;
            }

            public boolean hasPrevious() {
                return this.iterator.previousIndex() >= this.start;
            }

            public Object next() {
                if (this.iterator.nextIndex() < this.end) {
                    return this.iterator.next();
                }
                throw new NoSuchElementException();
            }

            public int nextIndex() {
                return this.iterator.nextIndex() - this.start;
            }

            public Object previous() {
                if (this.iterator.previousIndex() >= this.start) {
                    return this.iterator.previous();
                }
                throw new NoSuchElementException();
            }

            public int previousIndex() {
                int n = this.iterator.previousIndex();
                if (n >= this.start) {
                    return n - this.start;
                }
                return -1;
            }

            public void remove() {
                this.iterator.remove();
                this.subList.sizeChanged(false);
                --this.end;
            }

            public void set(Object object) {
                this.iterator.set(object);
            }
        }
    }

    private final class FullListIterator
    extends SimpleListIterator
    implements ListIterator {
        FullListIterator(int n) {
            if (n < 0 || n > AbstractList.this.size()) {
                throw new IndexOutOfBoundsException();
            }
            this.pos = n - 1;
        }

        public void add(Object object) {
            if (this.expectedModCount == AbstractList.this.modCount) {
                try {
                    AbstractList.this.add(this.pos + 1, object);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    throw new NoSuchElementException();
                }
                ++this.pos;
                this.lastPosition = -1;
                if (AbstractList.this.modCount != this.expectedModCount) {
                    ++this.expectedModCount;
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasPrevious() {
            return this.pos >= 0;
        }

        public int nextIndex() {
            return this.pos + 1;
        }

        public Object previous() {
            if (this.expectedModCount == AbstractList.this.modCount) {
                try {
                    Object object = AbstractList.this.get(this.pos);
                    this.lastPosition = this.pos--;
                    return object;
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    throw new NoSuchElementException();
                }
            }
            throw new ConcurrentModificationException();
        }

        public int previousIndex() {
            return this.pos;
        }

        public void set(Object object) {
            if (this.expectedModCount == AbstractList.this.modCount) {
                try {
                    AbstractList.this.set(this.lastPosition, object);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    throw new IllegalStateException();
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }

    private class SimpleListIterator
    implements Iterator {
        int pos = -1;
        int expectedModCount;
        int lastPosition = -1;

        SimpleListIterator() {
            this.expectedModCount = AbstractList.this.modCount;
        }

        public boolean hasNext() {
            return this.pos + 1 < AbstractList.this.size();
        }

        public Object next() {
            if (this.expectedModCount == AbstractList.this.modCount) {
                try {
                    Object object = AbstractList.this.get(this.pos + 1);
                    this.lastPosition = ++this.pos;
                    return object;
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    throw new NoSuchElementException();
                }
            }
            throw new ConcurrentModificationException();
        }

        public void remove() {
            if (this.expectedModCount == AbstractList.this.modCount) {
                try {
                    AbstractList.this.remove(this.lastPosition);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    throw new IllegalStateException();
                }
                if (AbstractList.this.modCount != this.expectedModCount) {
                    ++this.expectedModCount;
                }
                if (this.pos == this.lastPosition) {
                    --this.pos;
                }
            } else {
                throw new ConcurrentModificationException();
            }
            this.lastPosition = -1;
        }
    }

    private static final class SubAbstractListRandomAccess
    extends SubAbstractList
    implements RandomAccess {
        SubAbstractListRandomAccess(AbstractList abstractList, int n, int n2) {
            super(abstractList, n, n2);
        }
    }
}

