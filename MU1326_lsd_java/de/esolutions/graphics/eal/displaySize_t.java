/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public class displaySize_t {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public displaySize_t(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(displaySize_t displaySize_t2) {
        return displaySize_t2 == null ? 0L : displaySize_t2.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_displaySize_t(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public void setUiWidth(long l) {
        ealswigJNI.eal_displaySize_t_uiWidth_set(this.swigCPtr, this, l);
    }

    public long getUiWidth() {
        return ealswigJNI.eal_displaySize_t_uiWidth_get(this.swigCPtr, this);
    }

    public void setUiHeight(long l) {
        ealswigJNI.eal_displaySize_t_uiHeight_set(this.swigCPtr, this, l);
    }

    public long getUiHeight() {
        return ealswigJNI.eal_displaySize_t_uiHeight_get(this.swigCPtr, this);
    }

    public displaySize_t() {
        this(ealswigJNI.new_eal_displaySize_t(), true);
    }
}

