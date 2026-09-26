/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.ealBlendmode_t;
import de.esolutions.graphics.ealswigJNI;

public class IMaterial
extends IObject {
    private long swigCPtr;

    public IMaterial(long l, boolean bl) {
        super(ealswigJNI.eal_api_IMaterial_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IMaterial iMaterial) {
        return iMaterial == null ? 0L : iMaterial.swigCPtr;
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
                ealswigJNI.delete_eal_api_IMaterial(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_IMaterial_isValid(this.swigCPtr, this);
    }

    public boolean setTexture(ITexture iTexture, String string) {
        return ealswigJNI.eal_api_IMaterial_setTexture__SWIG_0(this.swigCPtr, this, ITexture.getCPtr(iTexture), iTexture, string);
    }

    public boolean setTexture(ITexture iTexture) {
        return ealswigJNI.eal_api_IMaterial_setTexture__SWIG_1(this.swigCPtr, this, ITexture.getCPtr(iTexture), iTexture);
    }

    public IProperty getProperty(String string) {
        long l = ealswigJNI.eal_api_IMaterial_getProperty(this.swigCPtr, this, string);
        return l == 0L ? null : new IProperty(l, true);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_IMaterial_dispose(this.swigCPtr, this);
    }

    public boolean setBlendMode(ealBlendmode_t ealBlendmode_t2) {
        return ealswigJNI.eal_api_IMaterial_setBlendMode(this.swigCPtr, this, ealBlendmode_t2.swigValue());
    }
}

