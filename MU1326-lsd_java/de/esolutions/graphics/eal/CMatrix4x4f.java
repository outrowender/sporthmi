/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public class CMatrix4x4f {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CMatrix4x4f(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CMatrix4x4f cMatrix4x4f) {
        return cMatrix4x4f == null ? 0L : cMatrix4x4f.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_CMatrix4x4f(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CMatrix4x4f() {
        this(ealswigJNI.new_eal_CMatrix4x4f(), true);
    }

    public CMatrix4x4f interpolate(CMatrix4x4f cMatrix4x4f, float f2) {
        return new CMatrix4x4f(ealswigJNI.eal_CMatrix4x4f_interpolate(this.swigCPtr, this, CMatrix4x4f.getCPtr(cMatrix4x4f), cMatrix4x4f, f2), true);
    }
}

