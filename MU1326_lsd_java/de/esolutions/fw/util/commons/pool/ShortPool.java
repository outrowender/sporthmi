/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.pool;

public final class ShortPool {
    private Item[] items;
    private int count;
    protected int next;

    public ShortPool(short s) {
        this.items = new Item[s];
        this.fill();
        this.count = 0;
        this.next = 0;
    }

    private void fill() {
        for (short s = 0; s < this.items.length; s = (short)(s + 1)) {
            Item item;
            this.items[s] = item = new Item(s);
        }
    }

    public void clear() {
        for (int n = 0; n < this.items.length; n = (int)((short)(n + 1))) {
            this.items[n].setObject(null);
        }
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    private void setNext(int n) {
        this.next = ++n >= this.items.length ? 0 : n;
    }

    public short add(Object object) {
        short s = -1;
        boolean bl = false;
        int n = this.next;
        while (true) {
            Item item;
            if (!(item = this.items[n]).isUsed()) {
                s = item.getKey();
                item.setObject(object);
                ++this.count;
                break;
            }
            if (bl && n == this.next) break;
            if (++n < this.items.length) continue;
            n = 0;
            bl = true;
        }
        this.setNext(s);
        return s;
    }

    public Object remove(short s) {
        for (int i2 = 0; i2 < this.items.length; ++i2) {
            Item item = this.items[i2];
            if (item.getKey() != s || !item.isUsed()) continue;
            Object object = item.getObject();
            item.setObject(null);
            --this.count;
            return object;
        }
        return null;
    }

    public Object getObject(short s) {
        return this.items[s].getObject();
    }

    public void setObject(short s, Object object) {
        this.items[s].setObject(object);
    }

    public short findObject(Object object) {
        for (int n = 0; n < this.items.length; n = (int)((short)(n + 1))) {
            Item item = this.items[n];
            if (item.getObject() != object) continue;
            return item.getKey();
        }
        return -1;
    }

    public short[] getUsedIDs() {
        if (this.count == 0) {
            return null;
        }
        short[] sArray = new short[this.count];
        int n = 0;
        for (int i2 = 0; i2 < this.items.length; ++i2) {
            Item item = this.items[i2];
            if (!item.isUsed()) continue;
            sArray[n] = item.getKey();
            ++n;
        }
        return sArray;
    }

    public Object[] getUsedObjects() {
        if (this.count == 0) {
            return null;
        }
        Object[] objectArray = new Object[this.count];
        int n = 0;
        for (int i2 = 0; i2 < this.items.length; ++i2) {
            Item item = this.items[i2];
            if (!item.isUsed()) continue;
            objectArray[n] = item.getObject();
            ++n;
        }
        return objectArray;
    }

    private static final class Item {
        private short key;
        private Object object;

        public Item(short s) {
            this.key = s;
            this.object = null;
        }

        public boolean isUsed() {
            return this.object != null;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public short getKey() {
            return this.key;
        }

        public Object getObject() {
            return this.object;
        }
    }
}

