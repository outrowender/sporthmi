/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.ealswigJNI;

public class IFontGroupFontHandle
extends IObject {
    private long swigCPtr;

    public IFontGroupFontHandle(long l, boolean bl) {
        super(ealswigJNI.eal_api_IFontGroupFontHandle_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IFontGroupFontHandle iFontGroupFontHandle) {
        return iFontGroupFontHandle == null ? 0L : iFontGroupFontHandle.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IFontGroupFontHandle(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_IFontGroupFontHandle_isValid(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_api_IFontGroupFontHandle_dispose(this.swigCPtr, this);
    }
}

