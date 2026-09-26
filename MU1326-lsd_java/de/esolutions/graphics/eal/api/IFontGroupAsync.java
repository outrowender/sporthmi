/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IFontGroup;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.ealswigJNI;

public class IFontGroupAsync {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public IFontGroupAsync(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(IFontGroupAsync iFontGroupAsync) {
        return iFontGroupAsync == null ? 0L : iFontGroupAsync.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IFontGroupAsync(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean addFont(String string) {
        return ealswigJNI.eal_api_IFontGroupAsync_addFont(this.swigCPtr, this, string);
    }

    public boolean linkUnicodeRanges(String string) {
        return ealswigJNI.eal_api_IFontGroupAsync_linkUnicodeRanges(this.swigCPtr, this, string);
    }

    public IFontGroup takeOwnership(IManager iManager) {
        long l = ealswigJNI.eal_api_IFontGroupAsync_takeOwnership(this.swigCPtr, this, IManager.getCPtr(iManager), iManager);
        return l == 0L ? null : new IFontGroup(l, true);
    }
}

