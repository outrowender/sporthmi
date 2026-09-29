/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.displaySize_t;
import de.esolutions.graphics.ealswigJNI;

public class IContext
extends IObject {
    private long swigCPtr;

    public IContext(long l, boolean bl) {
        super(ealswigJNI.eal_api_IContext_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IContext iContext) {
        return iContext == null ? 0L : iContext.swigCPtr;
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
                ealswigJNI.delete_eal_api_IContext(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean setVSync(boolean bl) {
        return ealswigJNI.eal_api_IContext_setVSync(this.swigCPtr, this, bl);
    }

    public void disableDepthBuffer() {
        ealswigJNI.eal_api_IContext_disableDepthBuffer(this.swigCPtr, this);
    }

    public boolean setWidth(long l) {
        return ealswigJNI.eal_api_IContext_setWidth(this.swigCPtr, this, l);
    }

    public boolean setHeight(long l) {
        return ealswigJNI.eal_api_IContext_setHeight(this.swigCPtr, this, l);
    }

    public IImage getScreenData() {
        long l = ealswigJNI.eal_api_IContext_getScreenData(this.swigCPtr, this);
        return l == 0L ? null : new IImage(l, true);
    }

    public boolean setDisplayId(long l) {
        return ealswigJNI.eal_api_IContext_setDisplayId(this.swigCPtr, this, l);
    }

    public long getDisplayId() {
        return ealswigJNI.eal_api_IContext_getDisplayId(this.swigCPtr, this);
    }

    public boolean setAnnotation(boolean bl) {
        return ealswigJNI.eal_api_IContext_setAnnotation(this.swigCPtr, this, bl);
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_IContext_isValid(this.swigCPtr, this);
    }

    public boolean getScreenResolution(displaySize_t displaySize_t2) {
        return ealswigJNI.eal_api_IContext_getScreenResolution(this.swigCPtr, this, displaySize_t.getCPtr(displaySize_t2), displaySize_t2);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_IContext_dispose(this.swigCPtr, this);
    }
}

