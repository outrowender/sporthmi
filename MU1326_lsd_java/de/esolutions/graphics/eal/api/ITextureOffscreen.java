/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.ealswigJNI;

public class ITextureOffscreen
extends ITexture {
    private long swigCPtr;

    public ITextureOffscreen(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITextureOffscreen_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITextureOffscreen iTextureOffscreen) {
        return iTextureOffscreen == null ? 0L : iTextureOffscreen.swigCPtr;
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
                ealswigJNI.delete_eal_api_ITextureOffscreen(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public ITextureOffscreen(IProject iProject, String string, long l, long l2) {
        this(ealswigJNI.new_eal_api_ITextureOffscreen__SWIG_0(IProject.getCPtr(iProject), iProject, string, l, l2), true);
    }

    public ITextureOffscreen(IProject iProject, String string, long l, long l2, FlagTexture flagTexture) {
        this(ealswigJNI.new_eal_api_ITextureOffscreen__SWIG_1(IProject.getCPtr(iProject), iProject, string, l, l2, FlagTexture.getCPtr(flagTexture), flagTexture), true);
    }

    public ITextureOffscreen(IProject iProject, String string, long l, long l2, FlagTexture flagTexture, boolean bl) {
        this(ealswigJNI.new_eal_api_ITextureOffscreen__SWIG_2(IProject.getCPtr(iProject), iProject, string, l, l2, FlagTexture.getCPtr(flagTexture), flagTexture, bl), true);
    }
}

