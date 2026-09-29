/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.ealMouseState_t;
import de.esolutions.graphics.ealswigJNI;

public class IInputListener {
    private long swigCPtr;
    protected boolean swigCMemOwn;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$IInputListener;

    public IInputListener(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(IInputListener iInputListener) {
        return iInputListener == null ? 0L : iInputListener.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_IInputListener(this.swigCPtr);
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
        ealswigJNI.eal_IInputListener_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ealswigJNI.eal_IInputListener_change_ownership(this, this.swigCPtr, true);
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IInputListener(IManager iManager) {
        this(ealswigJNI.new_eal_IInputListener(IManager.getCPtr(iManager), iManager), true);
        ealswigJNI.eal_IInputListener_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void mouseEvent(ealMouseState_t ealMouseState_t2, int n, int n2) {
        if (super.getClass() == (class$de$esolutions$graphics$eal$IInputListener == null ? (class$de$esolutions$graphics$eal$IInputListener = IInputListener.class$("de.esolutions.graphics.eal.IInputListener")) : class$de$esolutions$graphics$eal$IInputListener)) {
            ealswigJNI.eal_IInputListener_mouseEvent(this.swigCPtr, this, ealMouseState_t2.swigValue(), n, n2);
        } else {
            ealswigJNI.eal_IInputListener_mouseEventSwigExplicitIInputListener(this.swigCPtr, this, ealMouseState_t2.swigValue(), n, n2);
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

