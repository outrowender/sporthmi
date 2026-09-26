/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

public final class IntStack {
    private int fDepth;
    private int[] fData;

    public int size() {
        return this.fDepth;
    }

    public void push(int n) {
        this.ensureCapacity(this.fDepth + 1);
        this.fData[this.fDepth++] = n;
    }

    public int peek() {
        return this.fData[this.fDepth - 1];
    }

    public int elementAt(int n) {
        return this.fData[n];
    }

    public int pop() {
        return this.fData[--this.fDepth];
    }

    public void clear() {
        this.fDepth = 0;
    }

    public void print() {
        System.out.print('(');
        System.out.print(this.fDepth);
        System.out.print(") {");
        for (int i2 = 0; i2 < this.fDepth; ++i2) {
            if (i2 == 3) {
                System.out.print(" ...");
                break;
            }
            System.out.print(' ');
            System.out.print(this.fData[i2]);
            if (i2 >= this.fDepth - 1) continue;
            System.out.print(',');
        }
        System.out.print(" }");
        System.out.println();
    }

    private void ensureCapacity(int n) {
        if (this.fData == null) {
            this.fData = new int[32];
        } else if (this.fData.length <= n) {
            int[] nArray = new int[this.fData.length * 2];
            System.arraycopy((Object)this.fData, 0, (Object)nArray, 0, this.fData.length);
            this.fData = nArray;
        }
    }
}

