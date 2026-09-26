/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.ipl;

import de.esolutions.graphics.ealswigJNI;

public class VectorD {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public VectorD(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(VectorD vectorD) {
        return vectorD == null ? 0L : vectorD.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_ipl_VectorD(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public VectorD() {
        this(ealswigJNI.new_ipl_VectorD__SWIG_0(), true);
    }

    public VectorD(long l) {
        this(ealswigJNI.new_ipl_VectorD__SWIG_1(l), true);
    }

    public long size() {
        return ealswigJNI.ipl_VectorD_size(this.swigCPtr, this);
    }

    public long capacity() {
        return ealswigJNI.ipl_VectorD_capacity(this.swigCPtr, this);
    }

    public void reserve(long l) {
        ealswigJNI.ipl_VectorD_reserve(this.swigCPtr, this, l);
    }

    public boolean isEmpty() {
        return ealswigJNI.ipl_VectorD_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        ealswigJNI.ipl_VectorD_clear(this.swigCPtr, this);
    }

    public void add(double d2) {
        ealswigJNI.ipl_VectorD_add(this.swigCPtr, this, d2);
    }
}

