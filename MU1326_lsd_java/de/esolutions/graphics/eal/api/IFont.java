/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.ealswigJNI;

public class IFont
extends IObject {
    private long swigCPtr;

    public IFont(long l, boolean bl) {
        super(ealswigJNI.eal_api_IFont_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IFont iFont) {
        return iFont == null ? 0L : iFont.swigCPtr;
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
                ealswigJNI.delete_eal_api_IFont(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IFont(IManager iManager, String string) {
        this(ealswigJNI.new_eal_api_IFont(IManager.getCPtr(iManager), iManager, string), true);
    }

    public String getName() {
        return ealswigJNI.eal_api_IFont_getName(this.swigCPtr, this);
    }

    public int getAscent(long l) {
        return ealswigJNI.eal_api_IFont_getAscent(this.swigCPtr, this, l);
    }

    public int getDescent(long l) {
        return ealswigJNI.eal_api_IFont_getDescent(this.swigCPtr, this, l);
    }

    public int getMaximumHeight(long l) {
        return ealswigJNI.eal_api_IFont_getMaximumHeight(this.swigCPtr, this, l);
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_IFont_isValid(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_IFont_dispose(this.swigCPtr, this);
    }

    public boolean destroy(IManager iManager) {
        return ealswigJNI.eal_api_IFont_destroy(this.swigCPtr, this, IManager.getCPtr(iManager), iManager);
    }

    public void copy(IFont iFont) {
        ealswigJNI.eal_api_IFont_copy(this.swigCPtr, this, IFont.getCPtr(iFont), iFont);
    }

    public boolean overwriteNotDefGlyph(long l) {
        return ealswigJNI.eal_api_IFont_overwriteNotDefGlyph(this.swigCPtr, this, l);
    }
}

