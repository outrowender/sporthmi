/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.eal.utility.IImageStorageListener$enType_t;
import de.esolutions.graphics.ealswigJNI;

public class IImageStorageListener {
    private long swigCPtr;
    protected boolean swigCMemOwn;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$utility$IImageStorageListener;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$utility$IImageStorageListener$enType_t;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$utility$IImageStorageListener$enIdent_t;

    public IImageStorageListener(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(IImageStorageListener iImageStorageListener) {
        return iImageStorageListener == null ? 0L : iImageStorageListener.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_utility_IImageStorageListener(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        this.delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        ealswigJNI.eal_utility_IImageStorageListener_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ealswigJNI.eal_utility_IImageStorageListener_change_ownership(this, this.swigCPtr, true);
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IImageStorageListener() {
        this(ealswigJNI.new_eal_utility_IImageStorageListener(), true);
        ealswigJNI.eal_utility_IImageStorageListener_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void process(IImageStorageListener$enType_t iImageStorageListener$enType_t, long l) {
        if (super.getClass() == (class$de$esolutions$graphics$eal$utility$IImageStorageListener == null ? (class$de$esolutions$graphics$eal$utility$IImageStorageListener = IImageStorageListener.class$("de.esolutions.graphics.eal.utility.IImageStorageListener")) : class$de$esolutions$graphics$eal$utility$IImageStorageListener)) {
            ealswigJNI.eal_utility_IImageStorageListener_process(this.swigCPtr, this, iImageStorageListener$enType_t.swigValue(), l);
        } else {
            ealswigJNI.eal_utility_IImageStorageListener_processSwigExplicitIImageStorageListener(this.swigCPtr, this, iImageStorageListener$enType_t.swigValue(), l);
        }
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

