/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IFont;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.graphics.eal.api.ITextLayoutResult;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.ealswigJNI;

public class IINodeText
extends IObject {
    private long swigCPtr;

    public IINodeText(long l, boolean bl) {
        super(ealswigJNI.eal_api_IINodeText_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IINodeText iINodeText) {
        return iINodeText == null ? 0L : iINodeText.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IINodeText(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean setText(IFont iFont, int n, String string) {
        return ealswigJNI.eal_api_IINodeText_setText__SWIG_0(this.swigCPtr, this, IFont.getCPtr(iFont), iFont, n, string);
    }

    public boolean setText(int n, String string) {
        return ealswigJNI.eal_api_IINodeText_setText__SWIG_1(this.swigCPtr, this, n, string);
    }

    public boolean setText(ITextLayout iTextLayout, String string) {
        return ealswigJNI.eal_api_IINodeText_setText__SWIG_2(this.swigCPtr, this, ITextLayout.getCPtr(iTextLayout), iTextLayout, string);
    }

    public boolean setText(ITextLayoutResult iTextLayoutResult) {
        return ealswigJNI.eal_api_IINodeText_setText__SWIG_3(this.swigCPtr, this, ITextLayoutResult.getCPtr(iTextLayoutResult), iTextLayoutResult);
    }

    public boolean setColor(colorRGBAf colorRGBAf2) {
        return ealswigJNI.eal_api_IINodeText_setColor__SWIG_0(this.swigCPtr, this, colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    public boolean setColor(long l) {
        return ealswigJNI.eal_api_IINodeText_setColor__SWIG_1(this.swigCPtr, this, l);
    }

    public long getWidth() {
        return ealswigJNI.eal_api_IINodeText_getWidth(this.swigCPtr, this);
    }

    public long getHeight() {
        return ealswigJNI.eal_api_IINodeText_getHeight(this.swigCPtr, this);
    }

    public long getAscent() {
        return ealswigJNI.eal_api_IINodeText_getAscent(this.swigCPtr, this);
    }

    public long getDescent() {
        return ealswigJNI.eal_api_IINodeText_getDescent(this.swigCPtr, this);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_IINodeText_isValid(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_api_IINodeText_dispose(this.swigCPtr, this);
    }

    public boolean setFading(float f2, float f3) {
        return ealswigJNI.eal_api_IINodeText_setFading__SWIG_0(this.swigCPtr, this, f2, f3);
    }

    public boolean setFading(float f2, float f3, boolean bl) {
        return ealswigJNI.eal_api_IINodeText_setFading__SWIG_1(this.swigCPtr, this, f2, f3, bl);
    }
}

