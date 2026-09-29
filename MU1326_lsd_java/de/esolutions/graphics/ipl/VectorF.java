/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.ipl;

import de.esolutions.graphics.ealswigJNI;

public class VectorF {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public VectorF(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(VectorF vectorF) {
        return vectorF == null ? 0L : vectorF.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_ipl_VectorF(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public VectorF() {
        this(ealswigJNI.new_ipl_VectorF__SWIG_0(), true);
    }

    public VectorF(long l) {
        this(ealswigJNI.new_ipl_VectorF__SWIG_1(l), true);
    }

    public long size() {
        return ealswigJNI.ipl_VectorF_size(this.swigCPtr, this);
    }

    public long capacity() {
        return ealswigJNI.ipl_VectorF_capacity(this.swigCPtr, this);
    }

    public void reserve(long l) {
        ealswigJNI.ipl_VectorF_reserve(this.swigCPtr, this, l);
    }

    public boolean isEmpty() {
        return ealswigJNI.ipl_VectorF_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        ealswigJNI.ipl_VectorF_clear(this.swigCPtr, this);
    }

    public void add(float f2) {
        ealswigJNI.ipl_VectorF_add(this.swigCPtr, this, f2);
    }
}

