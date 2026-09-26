/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

class DeferredDocumentImpl$IntVector {
    private int[] data;
    private int size;

    DeferredDocumentImpl$IntVector() {
    }

    public int size() {
        return this.size;
    }

    public int elementAt(int n) {
        return this.data[n];
    }

    public void addElement(int n) {
        this.ensureCapacity(this.size + 1);
        this.data[this.size++] = n;
    }

    public void removeAllElements() {
        this.size = 0;
    }

    private void ensureCapacity(int n) {
        if (this.data == null) {
            this.data = new int[n + 15];
        } else if (n > this.data.length) {
            int[] nArray = new int[n + 15];
            System.arraycopy((Object)this.data, 0, (Object)nArray, 0, this.data.length);
            this.data = nArray;
        }
    }
}

