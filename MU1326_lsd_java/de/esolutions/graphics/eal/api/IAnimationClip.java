/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IAnimation;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.ealswigJNI;

public class IAnimationClip
extends IObject {
    private long swigCPtr;

    public IAnimationClip(long l, boolean bl) {
        super(ealswigJNI.eal_api_IAnimationClip_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IAnimationClip iAnimationClip) {
        return iAnimationClip == null ? 0L : iAnimationClip.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IAnimationClip(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean setStartTime(float f2) {
        return ealswigJNI.eal_api_IAnimationClip_setStartTime(this.swigCPtr, this, f2);
    }

    public boolean setRepeat(int n) {
        return ealswigJNI.eal_api_IAnimationClip_setRepeat(this.swigCPtr, this, n);
    }

    public int getUniqueId() {
        return ealswigJNI.eal_api_IAnimationClip_getUniqueId(this.swigCPtr, this);
    }

    public float getDuration() {
        return ealswigJNI.eal_api_IAnimationClip_getDuration(this.swigCPtr, this);
    }

    public float getStartTime() {
        return ealswigJNI.eal_api_IAnimationClip_getStartTime(this.swigCPtr, this);
    }

    public float getEndTime() {
        return ealswigJNI.eal_api_IAnimationClip_getEndTime(this.swigCPtr, this);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_IAnimationClip_isValid(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_api_IAnimationClip_dispose(this.swigCPtr, this);
    }

    public long getSize() {
        return ealswigJNI.eal_api_IAnimationClip_getSize(this.swigCPtr, this);
    }

    public IAnimation getAnimation(long l) {
        long l2 = ealswigJNI.eal_api_IAnimationClip_getAnimation(this.swigCPtr, this, l);
        return l2 == 0L ? null : new IAnimation(l2, true);
    }
}

