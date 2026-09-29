/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.ealswigJNI;

public class ITextureShared
extends ITexture {
    private long swigCPtr;

    public ITextureShared(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITextureShared_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITextureShared iTextureShared) {
        return iTextureShared == null ? 0L : iTextureShared.swigCPtr;
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
                ealswigJNI.delete_eal_api_ITextureShared(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public ITextureShared(IProject iProject, String string, long l, long l2) {
        this(ealswigJNI.new_eal_api_ITextureShared(IProject.getCPtr(iProject), iProject, string, l, l2), true);
    }

    public boolean updateFromDisplay(long l) {
        return ealswigJNI.eal_api_ITextureShared_updateFromDisplay(this.swigCPtr, this, l);
    }

    public boolean updateFromDisplayable(long l) {
        return ealswigJNI.eal_api_ITextureShared_updateFromDisplayable__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean updateFromDisplayable(long l, long l2, long l3, long l4, long l5) {
        return ealswigJNI.eal_api_ITextureShared_updateFromDisplayable__SWIG_1(this.swigCPtr, this, l, l2, l3, l4, l5);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_ITextureShared_dispose(this.swigCPtr, this);
    }

    @Override
    public boolean destroy() {
        return ealswigJNI.eal_api_ITextureShared_destroy(this.swigCPtr, this);
    }
}

