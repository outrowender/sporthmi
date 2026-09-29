/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.ealswigJNI;

public class ITextureAtlas
extends IObject {
    private long swigCPtr;

    public ITextureAtlas(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITextureAtlas_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITextureAtlas iTextureAtlas) {
        return iTextureAtlas == null ? 0L : iTextureAtlas.swigCPtr;
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
                ealswigJNI.delete_eal_api_ITextureAtlas(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public ITextureAtlas(IProject iProject, String string) {
        this(ealswigJNI.new_eal_api_ITextureAtlas(IProject.getCPtr(iProject), iProject, string), true);
    }

    public ITexture getTexture(long l) {
        long l2 = ealswigJNI.eal_api_ITextureAtlas_getTexture(this.swigCPtr, this, l);
        return l2 == 0L ? null : new ITexture(l2, true);
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_ITextureAtlas_isValid(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_ITextureAtlas_dispose(this.swigCPtr, this);
    }

    public boolean destroy() {
        return ealswigJNI.eal_api_ITextureAtlas_destroy(this.swigCPtr, this);
    }
}

