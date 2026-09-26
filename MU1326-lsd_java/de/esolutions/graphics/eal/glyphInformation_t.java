/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public class glyphInformation_t {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public glyphInformation_t(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(glyphInformation_t glyphInformation_t2) {
        return glyphInformation_t2 == null ? 0L : glyphInformation_t2.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_glyphInformation_t(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public void setUiTotalGlyphs(long l) {
        ealswigJNI.eal_glyphInformation_t_uiTotalGlyphs_set(this.swigCPtr, this, l);
    }

    public long getUiTotalGlyphs() {
        return ealswigJNI.eal_glyphInformation_t_uiTotalGlyphs_get(this.swigCPtr, this);
    }

    public void setUiAvailableGlyphs(long l) {
        ealswigJNI.eal_glyphInformation_t_uiAvailableGlyphs_set(this.swigCPtr, this, l);
    }

    public long getUiAvailableGlyphs() {
        return ealswigJNI.eal_glyphInformation_t_uiAvailableGlyphs_get(this.swigCPtr, this);
    }

    public glyphInformation_t() {
        this(ealswigJNI.new_eal_glyphInformation_t(), true);
    }
}

