/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.texOptions_t;
import de.esolutions.graphics.ealswigJNI;

public class FlagTexture {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public FlagTexture(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(FlagTexture flagTexture) {
        return flagTexture == null ? 0L : flagTexture.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_FlagTexture(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public FlagTexture() {
        this(ealswigJNI.new_eal_FlagTexture__SWIG_0(), true);
    }

    public FlagTexture(texOptions_t texOptions_t2) {
        this(ealswigJNI.new_eal_FlagTexture__SWIG_1(texOptions_t2.swigValue()), true);
    }

    public FlagTexture(long l) {
        this(ealswigJNI.new_eal_FlagTexture__SWIG_2(l), true);
    }

    public long getFlagValue() {
        return ealswigJNI.eal_FlagTexture_getFlagValue(this.swigCPtr, this);
    }

    public void setFlag(texOptions_t texOptions_t2) {
        ealswigJNI.eal_FlagTexture_setFlag(this.swigCPtr, this, texOptions_t2.swigValue());
    }

    public boolean isFlag(texOptions_t texOptions_t2) {
        return ealswigJNI.eal_FlagTexture_isFlag(this.swigCPtr, this, texOptions_t2.swigValue());
    }

    public void reset() {
        ealswigJNI.eal_FlagTexture_reset(this.swigCPtr, this);
    }

    public void resetPos(long l) {
        ealswigJNI.eal_FlagTexture_resetPos(this.swigCPtr, this, l);
    }

    public void unsetFlag(texOptions_t texOptions_t2) {
        ealswigJNI.eal_FlagTexture_unsetFlag(this.swigCPtr, this, texOptions_t2.swigValue());
    }

    public void setFlagValue(long l) {
        ealswigJNI.eal_FlagTexture_setFlagValue(this.swigCPtr, this, l);
    }

    public long getHexValueAtPos(long l) {
        return ealswigJNI.eal_FlagTexture_getHexValueAtPos(this.swigCPtr, this, l);
    }

    public long extractPosition(long l) {
        return ealswigJNI.eal_FlagTexture_extractPosition(this.swigCPtr, this, l);
    }

    public long getByMask(long l) {
        return ealswigJNI.eal_FlagTexture_getByMask(this.swigCPtr, this, l);
    }

    public boolean equal(long l) {
        return ealswigJNI.eal_FlagTexture_equal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean equal(texOptions_t texOptions_t2) {
        return ealswigJNI.eal_FlagTexture_equal__SWIG_1(this.swigCPtr, this, texOptions_t2.swigValue());
    }

    public boolean unequal(long l) {
        return ealswigJNI.eal_FlagTexture_unequal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean unequal(texOptions_t texOptions_t2) {
        return ealswigJNI.eal_FlagTexture_unequal__SWIG_1(this.swigCPtr, this, texOptions_t2.swigValue());
    }

    public boolean contains(texOptions_t texOptions_t2) {
        return ealswigJNI.eal_FlagTexture_contains__SWIG_0(this.swigCPtr, this, texOptions_t2.swigValue());
    }

    public boolean contains(FlagTexture flagTexture) {
        return ealswigJNI.eal_FlagTexture_contains__SWIG_1(this.swigCPtr, this, FlagTexture.getCPtr(flagTexture), flagTexture);
    }
}

