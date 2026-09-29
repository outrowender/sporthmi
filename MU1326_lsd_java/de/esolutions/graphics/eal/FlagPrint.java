/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.ealPrintOption_t;
import de.esolutions.graphics.ealswigJNI;

public class FlagPrint {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public FlagPrint(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(FlagPrint flagPrint) {
        return flagPrint == null ? 0L : flagPrint.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_FlagPrint(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public FlagPrint() {
        this(ealswigJNI.new_eal_FlagPrint__SWIG_0(), true);
    }

    public FlagPrint(ealPrintOption_t ealPrintOption_t2) {
        this(ealswigJNI.new_eal_FlagPrint__SWIG_1(ealPrintOption_t2.swigValue()), true);
    }

    public FlagPrint(long l) {
        this(ealswigJNI.new_eal_FlagPrint__SWIG_2(l), true);
    }

    public long getFlagValue() {
        return ealswigJNI.eal_FlagPrint_getFlagValue(this.swigCPtr, this);
    }

    public void setFlag(ealPrintOption_t ealPrintOption_t2) {
        ealswigJNI.eal_FlagPrint_setFlag(this.swigCPtr, this, ealPrintOption_t2.swigValue());
    }

    public boolean isFlag(ealPrintOption_t ealPrintOption_t2) {
        return ealswigJNI.eal_FlagPrint_isFlag(this.swigCPtr, this, ealPrintOption_t2.swigValue());
    }

    public void reset() {
        ealswigJNI.eal_FlagPrint_reset(this.swigCPtr, this);
    }

    public void resetPos(long l) {
        ealswigJNI.eal_FlagPrint_resetPos(this.swigCPtr, this, l);
    }

    public void unsetFlag(ealPrintOption_t ealPrintOption_t2) {
        ealswigJNI.eal_FlagPrint_unsetFlag(this.swigCPtr, this, ealPrintOption_t2.swigValue());
    }

    public void setFlagValue(long l) {
        ealswigJNI.eal_FlagPrint_setFlagValue(this.swigCPtr, this, l);
    }

    public long getHexValueAtPos(long l) {
        return ealswigJNI.eal_FlagPrint_getHexValueAtPos(this.swigCPtr, this, l);
    }

    public long extractPosition(long l) {
        return ealswigJNI.eal_FlagPrint_extractPosition(this.swigCPtr, this, l);
    }

    public long getByMask(long l) {
        return ealswigJNI.eal_FlagPrint_getByMask(this.swigCPtr, this, l);
    }

    public boolean equal(long l) {
        return ealswigJNI.eal_FlagPrint_equal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean equal(ealPrintOption_t ealPrintOption_t2) {
        return ealswigJNI.eal_FlagPrint_equal__SWIG_1(this.swigCPtr, this, ealPrintOption_t2.swigValue());
    }

    public boolean unequal(long l) {
        return ealswigJNI.eal_FlagPrint_unequal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean unequal(ealPrintOption_t ealPrintOption_t2) {
        return ealswigJNI.eal_FlagPrint_unequal__SWIG_1(this.swigCPtr, this, ealPrintOption_t2.swigValue());
    }

    public boolean contains(ealPrintOption_t ealPrintOption_t2) {
        return ealswigJNI.eal_FlagPrint_contains__SWIG_0(this.swigCPtr, this, ealPrintOption_t2.swigValue());
    }

    public boolean contains(FlagPrint flagPrint) {
        return ealswigJNI.eal_FlagPrint_contains__SWIG_1(this.swigCPtr, this, FlagPrint.getCPtr(flagPrint), flagPrint);
    }
}

