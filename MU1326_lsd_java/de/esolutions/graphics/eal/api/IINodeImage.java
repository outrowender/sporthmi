/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.ealswigJNI;

public class IINodeImage
extends IObject {
    private long swigCPtr;

    public IINodeImage(long l, boolean bl) {
        super(ealswigJNI.eal_api_IINodeImage_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IINodeImage iINodeImage) {
        return iINodeImage == null ? 0L : iINodeImage.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IINodeImage(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean setTexture(ITexture iTexture) {
        return ealswigJNI.eal_api_IINodeImage_setTexture(this.swigCPtr, this, ITexture.getCPtr(iTexture), iTexture);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_IINodeImage_isValid(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_api_IINodeImage_dispose(this.swigCPtr, this);
    }

    public boolean setModulateColor(colorRGBAf colorRGBAf2) {
        return ealswigJNI.eal_api_IINodeImage_setModulateColor__SWIG_0(this.swigCPtr, this, colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    public boolean setModulateColor(long l) {
        return ealswigJNI.eal_api_IINodeImage_setModulateColor__SWIG_1(this.swigCPtr, this, l);
    }

    public boolean clipImage(float f2, float f3, float f4, float f5) {
        return ealswigJNI.eal_api_IINodeImage_clipImage(this.swigCPtr, this, f2, f3, f4, f5);
    }
}

