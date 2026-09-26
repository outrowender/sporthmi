/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.ealswigJNI;

public class CLerpF {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CLerpF(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CLerpF cLerpF) {
        return cLerpF == null ? 0L : cLerpF.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_utility_CLerpF(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CLerpF() {
        this(ealswigJNI.new_eal_utility_CLerpF__SWIG_0(), true);
    }

    public CLerpF(float f2, float f3, long l) {
        this(ealswigJNI.new_eal_utility_CLerpF__SWIG_1(f2, f3, l), true);
    }

    public void start() {
        ealswigJNI.eal_utility_CLerpF_start(this.swigCPtr, this);
    }

    public float evaluate() {
        return ealswigJNI.eal_utility_CLerpF_evaluate(this.swigCPtr, this);
    }

    public boolean isFinished() {
        return ealswigJNI.eal_utility_CLerpF_isFinished(this.swigCPtr, this);
    }

    public void setStart(float f2) {
        ealswigJNI.eal_utility_CLerpF_setStart(this.swigCPtr, this, f2);
    }

    public void setEnd(float f2) {
        ealswigJNI.eal_utility_CLerpF_setEnd(this.swigCPtr, this, f2);
    }

    public void setStartEnd(float f2, float f3) {
        ealswigJNI.eal_utility_CLerpF_setStartEnd(this.swigCPtr, this, f2, f3);
    }

    public void setDuration(long l) {
        ealswigJNI.eal_utility_CLerpF_setDuration(this.swigCPtr, this, l);
    }

    public float getStart() {
        return ealswigJNI.eal_utility_CLerpF_getStart(this.swigCPtr, this);
    }

    public float getEnd() {
        return ealswigJNI.eal_utility_CLerpF_getEnd(this.swigCPtr, this);
    }

    public long getDuration() {
        return ealswigJNI.eal_utility_CLerpF_getDuration(this.swigCPtr, this);
    }

    public void invert() {
        ealswigJNI.eal_utility_CLerpF_invert(this.swigCPtr, this);
    }
}

