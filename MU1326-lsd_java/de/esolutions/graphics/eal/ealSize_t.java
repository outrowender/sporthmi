/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public class ealSize_t {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public ealSize_t(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(ealSize_t ealSize_t2) {
        return ealSize_t2 == null ? 0L : ealSize_t2.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_ealSize_t(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public void setWidth(long l) {
        ealswigJNI.eal_ealSize_t_width_set(this.swigCPtr, this, l);
    }

    public long getWidth() {
        return ealswigJNI.eal_ealSize_t_width_get(this.swigCPtr, this);
    }

    public void setHeight(long l) {
        ealswigJNI.eal_ealSize_t_height_set(this.swigCPtr, this, l);
    }

    public long getHeight() {
        return ealswigJNI.eal_ealSize_t_height_get(this.swigCPtr, this);
    }

    public ealSize_t() {
        this(ealswigJNI.new_eal_ealSize_t(), true);
    }
}

