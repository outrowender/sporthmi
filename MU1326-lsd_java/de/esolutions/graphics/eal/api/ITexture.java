/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.IImageAsync;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.graphics.ealswigJNI;
import java.nio.ByteBuffer;

public class ITexture
extends IObject {
    private long swigCPtr;

    public ITexture(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITexture_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITexture iTexture) {
        return iTexture == null ? 0L : iTexture.swigCPtr;
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
                ealswigJNI.delete_eal_api_ITexture(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public ITexture(IProject iProject, IImage iImage) {
        this(ealswigJNI.new_eal_api_ITexture__SWIG_0(IProject.getCPtr(iProject), iProject, IImage.getCPtr(iImage), iImage), true);
    }

    public ITexture(IProject iProject, IImage iImage, FlagTexture flagTexture) {
        this(ealswigJNI.new_eal_api_ITexture__SWIG_1(IProject.getCPtr(iProject), iProject, IImage.getCPtr(iImage), iImage, FlagTexture.getCPtr(flagTexture), flagTexture), true);
    }

    public ITexture(IProject iProject, IImageAsync iImageAsync, FlagTexture flagTexture) {
        this(ealswigJNI.new_eal_api_ITexture__SWIG_2(IProject.getCPtr(iProject), iProject, IImageAsync.getCPtr(iImageAsync), iImageAsync, FlagTexture.getCPtr(flagTexture), flagTexture), true);
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_ITexture_isValid(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_ITexture_dispose(this.swigCPtr, this);
    }

    public boolean destroy() {
        return ealswigJNI.eal_api_ITexture_destroy(this.swigCPtr, this);
    }

    public long getWidth() {
        return ealswigJNI.eal_api_ITexture_getWidth(this.swigCPtr, this);
    }

    public long getHeight() {
        return ealswigJNI.eal_api_ITexture_getHeight(this.swigCPtr, this);
    }

    public boolean getData(ByteBuffer byteBuffer) {
        return ealswigJNI.eal_api_ITexture_getData(this.swigCPtr, this, byteBuffer);
    }

    public boolean testIfReferenced() {
        return ealswigJNI.eal_api_ITexture_testIfReferenced(this.swigCPtr, this);
    }

    public IProperty getProperty(String string) {
        long l = ealswigJNI.eal_api_ITexture_getProperty(this.swigCPtr, this, string);
        return l == 0L ? null : new IProperty(l, true);
    }
}

