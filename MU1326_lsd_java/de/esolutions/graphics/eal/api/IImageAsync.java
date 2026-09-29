/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.ealswigJNI;
import java.nio.ByteBuffer;

public class IImageAsync {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public IImageAsync(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(IImageAsync iImageAsync) {
        return iImageAsync == null ? 0L : iImageAsync.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IImageAsync(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IImageAsync(ByteBuffer byteBuffer, long l) {
        this(ealswigJNI.new_eal_api_IImageAsync__SWIG_0(byteBuffer, l), true);
    }

    public IImageAsync(ByteBuffer byteBuffer, long l, long l2, long l3, FlagImage flagImage) {
        this(ealswigJNI.new_eal_api_IImageAsync__SWIG_1(byteBuffer, l, l2, l3, FlagImage.getCPtr(flagImage), flagImage), true);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_IImageAsync_isValid(this.swigCPtr, this);
    }

    public boolean destroy() {
        return ealswigJNI.eal_api_IImageAsync_destroy(this.swigCPtr, this);
    }

    public long getWidth() {
        return ealswigJNI.eal_api_IImageAsync_getWidth(this.swigCPtr, this);
    }

    public long getHeight() {
        return ealswigJNI.eal_api_IImageAsync_getHeight(this.swigCPtr, this);
    }
}

