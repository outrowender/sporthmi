/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.ealswigJNI;

public class IAnimation
extends IObject {
    private long swigCPtr;

    public IAnimation(long l, boolean bl) {
        super(ealswigJNI.eal_api_IAnimation_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IAnimation iAnimation) {
        return iAnimation == null ? 0L : iAnimation.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    @Override
    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IAnimation(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean setTargetPropertyBlendIntensity() {
        return ealswigJNI.eal_api_IAnimation_setTargetPropertyBlendIntensity(this.swigCPtr, this);
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_IAnimation_isValid(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_IAnimation_dispose(this.swigCPtr, this);
    }

    public boolean getValue(long l, float[] fArray) {
        return ealswigJNI.eal_api_IAnimation_getValue(this.swigCPtr, this, l, fArray);
    }

    public String getName() {
        return ealswigJNI.eal_api_IAnimation_getName(this.swigCPtr, this);
    }
}

