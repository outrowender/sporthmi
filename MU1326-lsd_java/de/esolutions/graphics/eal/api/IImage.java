/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.api.IFont;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.ealImageFormat_t;
import de.esolutions.graphics.eal.ealSize_t;
import de.esolutions.graphics.ealswigJNI;
import java.nio.ByteBuffer;

public class IImage
extends IObject {
    private long swigCPtr;

    public IImage(long l, boolean bl) {
        super(ealswigJNI.eal_api_IImage_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IImage iImage) {
        return iImage == null ? 0L : iImage.swigCPtr;
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
                ealswigJNI.delete_eal_api_IImage(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IImage(IManager iManager, String string) {
        this(ealswigJNI.new_eal_api_IImage__SWIG_0(IManager.getCPtr(iManager), iManager, string), true);
    }

    public IImage(IManager iManager, String string, FlagImage flagImage) {
        this(ealswigJNI.new_eal_api_IImage__SWIG_1(IManager.getCPtr(iManager), iManager, string, FlagImage.getCPtr(flagImage), flagImage), true);
    }

    public IImage(IManager iManager, String string, FlagImage flagImage, long l, long l2) {
        this(ealswigJNI.new_eal_api_IImage__SWIG_2(IManager.getCPtr(iManager), iManager, string, FlagImage.getCPtr(flagImage), flagImage, l, l2), true);
    }

    public IImage(IManager iManager, ByteBuffer byteBuffer, long l) {
        this(ealswigJNI.new_eal_api_IImage__SWIG_3(IManager.getCPtr(iManager), iManager, byteBuffer, l), true);
    }

    public IImage(IManager iManager, ByteBuffer byteBuffer, long l, long l2) {
        this(ealswigJNI.new_eal_api_IImage__SWIG_4(IManager.getCPtr(iManager), iManager, byteBuffer, l, l2), true);
    }

    public IImage(IManager iManager, ByteBuffer byteBuffer, long l, long l2, FlagImage flagImage) {
        this(ealswigJNI.new_eal_api_IImage__SWIG_5(IManager.getCPtr(iManager), iManager, byteBuffer, l, l2, FlagImage.getCPtr(flagImage), flagImage), true);
    }

    public ByteBuffer getData() {
        return ealswigJNI.eal_api_IImage_getData(this.swigCPtr, this);
    }

    public long getSize() {
        return ealswigJNI.eal_api_IImage_getSize(this.swigCPtr, this);
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_IImage_isValid(this.swigCPtr, this);
    }

    public long getWidth() {
        return ealswigJNI.eal_api_IImage_getWidth(this.swigCPtr, this);
    }

    public long getHeight() {
        return ealswigJNI.eal_api_IImage_getHeight(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_IImage_dispose(this.swigCPtr, this);
    }

    public boolean destroy() {
        return ealswigJNI.eal_api_IImage_destroy(this.swigCPtr, this);
    }

    public boolean save(String string, ealImageFormat_t ealImageFormat_t2) {
        return ealswigJNI.eal_api_IImage_save(this.swigCPtr, this, string, ealImageFormat_t2.swigValue());
    }

    public boolean addText(IFont iFont, int n, String string) {
        return ealswigJNI.eal_api_IImage_addText(this.swigCPtr, this, IFont.getCPtr(iFont), iFont, n, string);
    }

    public static ealSize_t getImageInfo(String string) {
        return new ealSize_t(ealswigJNI.eal_api_IImage_getImageInfo__SWIG_0(string), true);
    }

    public static ealSize_t getImageInfo(ByteBuffer byteBuffer, long l) {
        return new ealSize_t(ealswigJNI.eal_api_IImage_getImageInfo__SWIG_1(byteBuffer, l), true);
    }
}

