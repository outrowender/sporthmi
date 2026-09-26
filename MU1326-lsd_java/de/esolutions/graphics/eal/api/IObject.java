/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.ealswigJNI;

public class IObject {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public IObject(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(IObject iObject) {
        return iObject == null ? 0L : iObject.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IObject(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean isDisposed() {
        return ealswigJNI.eal_api_IObject_isDisposed(this.swigCPtr, this);
    }

    public boolean equals(IObject iObject) {
        return ealswigJNI.eal_api_IObject_equals(this.swigCPtr, this, IObject.getCPtr(iObject), iObject);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_IObject_isValid(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_api_IObject_dispose(this.swigCPtr, this);
    }
}

