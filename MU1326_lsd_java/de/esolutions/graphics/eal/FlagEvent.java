/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.event_t;
import de.esolutions.graphics.ealswigJNI;

public class FlagEvent {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public FlagEvent(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(FlagEvent flagEvent) {
        return flagEvent == null ? 0L : flagEvent.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_FlagEvent(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public FlagEvent() {
        this(ealswigJNI.new_eal_FlagEvent__SWIG_0(), true);
    }

    public FlagEvent(event_t event_t2) {
        this(ealswigJNI.new_eal_FlagEvent__SWIG_1(event_t2.swigValue()), true);
    }

    public FlagEvent(long l) {
        this(ealswigJNI.new_eal_FlagEvent__SWIG_2(l), true);
    }

    public long getFlagValue() {
        return ealswigJNI.eal_FlagEvent_getFlagValue(this.swigCPtr, this);
    }

    public void setFlag(event_t event_t2) {
        ealswigJNI.eal_FlagEvent_setFlag(this.swigCPtr, this, event_t2.swigValue());
    }

    public boolean isFlag(event_t event_t2) {
        return ealswigJNI.eal_FlagEvent_isFlag(this.swigCPtr, this, event_t2.swigValue());
    }

    public void reset() {
        ealswigJNI.eal_FlagEvent_reset(this.swigCPtr, this);
    }

    public void resetPos(long l) {
        ealswigJNI.eal_FlagEvent_resetPos(this.swigCPtr, this, l);
    }

    public void unsetFlag(event_t event_t2) {
        ealswigJNI.eal_FlagEvent_unsetFlag(this.swigCPtr, this, event_t2.swigValue());
    }

    public void setFlagValue(long l) {
        ealswigJNI.eal_FlagEvent_setFlagValue(this.swigCPtr, this, l);
    }

    public long getHexValueAtPos(long l) {
        return ealswigJNI.eal_FlagEvent_getHexValueAtPos(this.swigCPtr, this, l);
    }

    public long extractPosition(long l) {
        return ealswigJNI.eal_FlagEvent_extractPosition(this.swigCPtr, this, l);
    }

    public long getByMask(long l) {
        return ealswigJNI.eal_FlagEvent_getByMask(this.swigCPtr, this, l);
    }

    public boolean equal(long l) {
        return ealswigJNI.eal_FlagEvent_equal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean equal(event_t event_t2) {
        return ealswigJNI.eal_FlagEvent_equal__SWIG_1(this.swigCPtr, this, event_t2.swigValue());
    }

    public boolean unequal(long l) {
        return ealswigJNI.eal_FlagEvent_unequal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean unequal(event_t event_t2) {
        return ealswigJNI.eal_FlagEvent_unequal__SWIG_1(this.swigCPtr, this, event_t2.swigValue());
    }

    public boolean contains(event_t event_t2) {
        return ealswigJNI.eal_FlagEvent_contains__SWIG_0(this.swigCPtr, this, event_t2.swigValue());
    }

    public boolean contains(FlagEvent flagEvent) {
        return ealswigJNI.eal_FlagEvent_contains__SWIG_1(this.swigCPtr, this, FlagEvent.getCPtr(flagEvent), flagEvent);
    }
}

