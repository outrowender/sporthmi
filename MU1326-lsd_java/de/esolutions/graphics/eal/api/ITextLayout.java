/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IFont;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.ITextLayout$kerning_t;
import de.esolutions.graphics.eal.api.ITextLayoutSection;
import de.esolutions.graphics.ealswigJNI;

public class ITextLayout
extends IObject {
    private long swigCPtr;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$ITextLayout$kerning_t;

    public ITextLayout(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITextLayout_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITextLayout iTextLayout) {
        return iTextLayout == null ? 0L : iTextLayout.swigCPtr;
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
                ealswigJNI.delete_eal_api_ITextLayout(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public ITextLayout() {
        this(ealswigJNI.new_eal_api_ITextLayout__SWIG_0(), true);
    }

    public ITextLayout(IFont iFont, int n) {
        this(ealswigJNI.new_eal_api_ITextLayout__SWIG_1(IFont.getCPtr(iFont), iFont, n), true);
    }

    public ITextLayout(int n) {
        this(ealswigJNI.new_eal_api_ITextLayout__SWIG_2(n), true);
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_ITextLayout_isValid(this.swigCPtr, this);
    }

    public void setTruncation(boolean bl) {
        ealswigJNI.eal_api_ITextLayout_setTruncation(this.swigCPtr, this, bl);
    }

    public void setMaximumSize(long l, long l2) {
        ealswigJNI.eal_api_ITextLayout_setMaximumSize(this.swigCPtr, this, l, l2);
    }

    public void setMaximumLineCount(long l) {
        ealswigJNI.eal_api_ITextLayout_setMaximumLineCount(this.swigCPtr, this, l);
    }

    public boolean setTextLayoutSectionNum(long l) {
        return ealswigJNI.eal_api_ITextLayout_setTextLayoutSectionNum(this.swigCPtr, this, l);
    }

    public ITextLayoutSection getLayoutSection(long l) {
        long l2 = ealswigJNI.eal_api_ITextLayout_getLayoutSection(this.swigCPtr, this, l);
        return l2 == 0L ? null : new ITextLayoutSection(l2, true);
    }

    public void print() {
        ealswigJNI.eal_api_ITextLayout_print(this.swigCPtr, this);
    }

    public boolean destroy() {
        return ealswigJNI.eal_api_ITextLayout_destroy(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_ITextLayout_dispose(this.swigCPtr, this);
    }

    public boolean setPreformattedText(boolean bl) {
        return ealswigJNI.eal_api_ITextLayout_setPreformattedText(this.swigCPtr, this, bl);
    }

    public boolean setKerning(ITextLayout$kerning_t iTextLayout$kerning_t) {
        return ealswigJNI.eal_api_ITextLayout_setKerning(this.swigCPtr, this, iTextLayout$kerning_t.swigValue());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

