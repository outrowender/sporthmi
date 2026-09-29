/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.ealMergeFlag_t;
import de.esolutions.graphics.ealswigJNI;

public class FlagMerge {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public FlagMerge(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(FlagMerge flagMerge) {
        return flagMerge == null ? 0L : flagMerge.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_FlagMerge(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public FlagMerge() {
        this(ealswigJNI.new_eal_FlagMerge__SWIG_0(), true);
    }

    public FlagMerge(ealMergeFlag_t ealMergeFlag_t2) {
        this(ealswigJNI.new_eal_FlagMerge__SWIG_1(ealMergeFlag_t2.swigValue()), true);
    }

    public FlagMerge(long l) {
        this(ealswigJNI.new_eal_FlagMerge__SWIG_2(l), true);
    }

    public long getFlagValue() {
        return ealswigJNI.eal_FlagMerge_getFlagValue(this.swigCPtr, this);
    }

    public void setFlag(ealMergeFlag_t ealMergeFlag_t2) {
        ealswigJNI.eal_FlagMerge_setFlag(this.swigCPtr, this, ealMergeFlag_t2.swigValue());
    }

    public boolean isFlag(ealMergeFlag_t ealMergeFlag_t2) {
        return ealswigJNI.eal_FlagMerge_isFlag(this.swigCPtr, this, ealMergeFlag_t2.swigValue());
    }

    public void reset() {
        ealswigJNI.eal_FlagMerge_reset(this.swigCPtr, this);
    }

    public void resetPos(long l) {
        ealswigJNI.eal_FlagMerge_resetPos(this.swigCPtr, this, l);
    }

    public void unsetFlag(ealMergeFlag_t ealMergeFlag_t2) {
        ealswigJNI.eal_FlagMerge_unsetFlag(this.swigCPtr, this, ealMergeFlag_t2.swigValue());
    }

    public void setFlagValue(long l) {
        ealswigJNI.eal_FlagMerge_setFlagValue(this.swigCPtr, this, l);
    }

    public long getHexValueAtPos(long l) {
        return ealswigJNI.eal_FlagMerge_getHexValueAtPos(this.swigCPtr, this, l);
    }

    public long extractPosition(long l) {
        return ealswigJNI.eal_FlagMerge_extractPosition(this.swigCPtr, this, l);
    }

    public long getByMask(long l) {
        return ealswigJNI.eal_FlagMerge_getByMask(this.swigCPtr, this, l);
    }

    public boolean equal(long l) {
        return ealswigJNI.eal_FlagMerge_equal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean equal(ealMergeFlag_t ealMergeFlag_t2) {
        return ealswigJNI.eal_FlagMerge_equal__SWIG_1(this.swigCPtr, this, ealMergeFlag_t2.swigValue());
    }

    public boolean unequal(long l) {
        return ealswigJNI.eal_FlagMerge_unequal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean unequal(ealMergeFlag_t ealMergeFlag_t2) {
        return ealswigJNI.eal_FlagMerge_unequal__SWIG_1(this.swigCPtr, this, ealMergeFlag_t2.swigValue());
    }

    public boolean contains(ealMergeFlag_t ealMergeFlag_t2) {
        return ealswigJNI.eal_FlagMerge_contains__SWIG_0(this.swigCPtr, this, ealMergeFlag_t2.swigValue());
    }

    public boolean contains(FlagMerge flagMerge) {
        return ealswigJNI.eal_FlagMerge_contains__SWIG_1(this.swigCPtr, this, FlagMerge.getCPtr(flagMerge), flagMerge);
    }
}

