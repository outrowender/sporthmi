/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IRenderer;
import de.esolutions.graphics.ealswigJNI;
import java.nio.ByteBuffer;

public class IRendererAnnotation
extends IObject {
    private long swigCPtr;

    public IRendererAnnotation(long l, boolean bl) {
        super(ealswigJNI.eal_api_IRendererAnnotation_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IRendererAnnotation iRendererAnnotation) {
        return iRendererAnnotation == null ? 0L : iRendererAnnotation.swigCPtr;
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
                ealswigJNI.delete_eal_api_IRendererAnnotation(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IRendererAnnotation(IRenderer iRenderer) {
        this(ealswigJNI.new_eal_api_IRendererAnnotation(IRenderer.getCPtr(iRenderer), iRenderer), true);
    }

    public boolean setData(short s, String string) {
        return ealswigJNI.eal_api_IRendererAnnotation_setData__SWIG_0(this.swigCPtr, this, s, string);
    }

    public boolean setData(short s, ByteBuffer byteBuffer, long l) {
        return ealswigJNI.eal_api_IRendererAnnotation_setData__SWIG_1(this.swigCPtr, this, s, byteBuffer, l);
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_IRendererAnnotation_isValid(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_IRendererAnnotation_dispose(this.swigCPtr, this);
    }

    public boolean setErrorCorrection(boolean bl) {
        return ealswigJNI.eal_api_IRendererAnnotation_setErrorCorrection(this.swigCPtr, this, bl);
    }
}

