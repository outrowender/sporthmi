/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.utility.IImageStorageListener;
import de.esolutions.graphics.ealswigJNI;

public class CImageStorage {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CImageStorage(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CImageStorage cImageStorage) {
        return cImageStorage == null ? 0L : cImageStorage.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_utility_CImageStorage(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CImageStorage(IManager iManager, IImageStorageListener iImageStorageListener) {
        this(ealswigJNI.new_eal_utility_CImageStorage(IManager.getCPtr(iManager), iManager, IImageStorageListener.getCPtr(iImageStorageListener), iImageStorageListener), true);
    }

    public boolean add(long l, String string, FlagImage flagImage) {
        return ealswigJNI.eal_utility_CImageStorage_add__SWIG_0(this.swigCPtr, this, l, string, FlagImage.getCPtr(flagImage), flagImage);
    }

    public boolean add(long l, String string, FlagImage flagImage, long l2, long l3) {
        return ealswigJNI.eal_utility_CImageStorage_add__SWIG_1(this.swigCPtr, this, l, string, FlagImage.getCPtr(flagImage), flagImage, l2, l3);
    }

    public IImage get(long l) {
        long l2 = ealswigJNI.eal_utility_CImageStorage_get(this.swigCPtr, this, l);
        return l2 == 0L ? null : new IImage(l2, false);
    }

    public boolean flush() {
        return ealswigJNI.eal_utility_CImageStorage_flush(this.swigCPtr, this);
    }

    public boolean clear() {
        return ealswigJNI.eal_utility_CImageStorage_clear(this.swigCPtr, this);
    }

    public boolean destroy() {
        return ealswigJNI.eal_utility_CImageStorage_destroy(this.swigCPtr, this);
    }

    public boolean remove(long l) {
        return ealswigJNI.eal_utility_CImageStorage_remove(this.swigCPtr, this, l);
    }
}

