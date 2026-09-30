/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public class ICacheCallback {
    private long swigCPtr;
    protected boolean swigCMemOwn;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ICacheCallback;

    public ICacheCallback(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(ICacheCallback iCacheCallback) {
        return iCacheCallback == null ? 0L : iCacheCallback.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_ICacheCallback(this.swigCPtr);
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
        ealswigJNI.eal_ICacheCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ealswigJNI.eal_ICacheCallback_change_ownership(this, this.swigCPtr, true);
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public ICacheCallback() {
        this(ealswigJNI.new_eal_ICacheCallback(), true);
        ealswigJNI.eal_ICacheCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void destroy(int n) {
        if (this.getClass() == (class$de$esolutions$graphics$eal$ICacheCallback == null ? (class$de$esolutions$graphics$eal$ICacheCallback = ICacheCallback.class$("de.esolutions.graphics.eal.ICacheCallback")) : class$de$esolutions$graphics$eal$ICacheCallback)) {
            ealswigJNI.eal_ICacheCallback_destroy(this.swigCPtr, this, n);
        } else {
            ealswigJNI.eal_ICacheCallback_destroySwigExplicitICacheCallback(this.swigCPtr, this, n);
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

