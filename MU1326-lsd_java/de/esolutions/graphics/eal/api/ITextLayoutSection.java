/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.FlagFontStyle;
import de.esolutions.graphics.eal.api.IFont;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.ITextLayoutSection$alignment_t;
import de.esolutions.graphics.eal.api.ITextLayoutSection$hinting_t;
import de.esolutions.graphics.eal.api.ITextLayoutSection$lineExtender_t;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.ealswigJNI;

public class ITextLayoutSection
extends IObject {
    private long swigCPtr;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$ITextLayoutSection$alignment_t;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$ITextLayoutSection$style_t;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$ITextLayoutSection$lineExtender_t;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$ITextLayoutSection$hinting_t;

    public ITextLayoutSection(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITextLayoutSection_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITextLayoutSection iTextLayoutSection) {
        return iTextLayoutSection == null ? 0L : iTextLayoutSection.swigCPtr;
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
                ealswigJNI.delete_eal_api_ITextLayoutSection(this.swigCPtr);
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
        return ealswigJNI.eal_api_ITextLayoutSection_isValid(this.swigCPtr, this);
    }

    public boolean setBasic(IFont iFont, int n) {
        return ealswigJNI.eal_api_ITextLayoutSection_setBasic__SWIG_0(this.swigCPtr, this, IFont.getCPtr(iFont), iFont, n);
    }

    public boolean setBasic(IFont iFont, int n, long l) {
        return ealswigJNI.eal_api_ITextLayoutSection_setBasic__SWIG_1(this.swigCPtr, this, IFont.getCPtr(iFont), iFont, n, l);
    }

    public boolean setBasicFontGroup(int n, long l) {
        return ealswigJNI.eal_api_ITextLayoutSection_setBasicFontGroup(this.swigCPtr, this, n, l);
    }

    public boolean setAlignment(ITextLayoutSection$alignment_t iTextLayoutSection$alignment_t) {
        return ealswigJNI.eal_api_ITextLayoutSection_setAlignment(this.swigCPtr, this, iTextLayoutSection$alignment_t.swigValue());
    }

    public boolean setStartEndIndex(long l, long l2) {
        return ealswigJNI.eal_api_ITextLayoutSection_setStartEndIndex(this.swigCPtr, this, l, l2);
    }

    public boolean setLineGap(int n) {
        return ealswigJNI.eal_api_ITextLayoutSection_setLineGap(this.swigCPtr, this, n);
    }

    public boolean setFont(IFont iFont, int n, FlagFontStyle flagFontStyle) {
        return ealswigJNI.eal_api_ITextLayoutSection_setFont__SWIG_0(this.swigCPtr, this, IFont.getCPtr(iFont), iFont, n, FlagFontStyle.getCPtr(flagFontStyle), flagFontStyle);
    }

    public boolean setFont(IFont iFont, int n) {
        return ealswigJNI.eal_api_ITextLayoutSection_setFont__SWIG_1(this.swigCPtr, this, IFont.getCPtr(iFont), iFont, n);
    }

    public boolean setLineExtender(ITextLayoutSection$lineExtender_t iTextLayoutSection$lineExtender_t) {
        return ealswigJNI.eal_api_ITextLayoutSection_setLineExtender(this.swigCPtr, this, iTextLayoutSection$lineExtender_t.swigValue());
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_ITextLayoutSection_dispose(this.swigCPtr, this);
    }

    public boolean setColor(colorRGBAf colorRGBAf2) {
        return ealswigJNI.eal_api_ITextLayoutSection_setColor__SWIG_0(this.swigCPtr, this, colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    public boolean setColor(int n) {
        return ealswigJNI.eal_api_ITextLayoutSection_setColor__SWIG_1(this.swigCPtr, this, n);
    }

    public boolean setStyle(FlagFontStyle flagFontStyle) {
        return ealswigJNI.eal_api_ITextLayoutSection_setStyle(this.swigCPtr, this, FlagFontStyle.getCPtr(flagFontStyle), flagFontStyle);
    }

    public boolean setHinting(ITextLayoutSection$hinting_t iTextLayoutSection$hinting_t) {
        return ealswigJNI.eal_api_ITextLayoutSection_setHinting(this.swigCPtr, this, iTextLayoutSection$hinting_t.swigValue());
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

