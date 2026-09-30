/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.FlagEvent;
import de.esolutions.graphics.eal.IEvent;
import de.esolutions.graphics.eal.IEventListener;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.ealswigJNI;

public class CAbstractEventListener
extends IEventListener {
    private long swigCPtr;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$CAbstractEventListener;

    public CAbstractEventListener(long l, boolean bl) {
        super(ealswigJNI.eal_CAbstractEventListener_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(CAbstractEventListener cAbstractEventListener) {
        return cAbstractEventListener == null ? 0L : cAbstractEventListener.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_CAbstractEventListener(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        this.delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        ealswigJNI.eal_CAbstractEventListener_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ealswigJNI.eal_CAbstractEventListener_change_ownership(this, this.swigCPtr, true);
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CAbstractEventListener(IManager iManager, FlagEvent flagEvent) {
        this(ealswigJNI.new_eal_CAbstractEventListener(IManager.getCPtr(iManager), iManager, FlagEvent.getCPtr(flagEvent), flagEvent), true);
        ealswigJNI.eal_CAbstractEventListener_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public String getName() {
        return this.getClass() == (class$de$esolutions$graphics$eal$CAbstractEventListener == null ? (class$de$esolutions$graphics$eal$CAbstractEventListener = CAbstractEventListener.class$("de.esolutions.graphics.eal.CAbstractEventListener")) : class$de$esolutions$graphics$eal$CAbstractEventListener) ? ealswigJNI.eal_CAbstractEventListener_getName(this.swigCPtr, this) : ealswigJNI.eal_CAbstractEventListener_getNameSwigExplicitCAbstractEventListener(this.swigCPtr, this);
    }

    public void process(IEvent iEvent) {
        if (this.getClass() == (class$de$esolutions$graphics$eal$CAbstractEventListener == null ? (class$de$esolutions$graphics$eal$CAbstractEventListener = CAbstractEventListener.class$("de.esolutions.graphics.eal.CAbstractEventListener")) : class$de$esolutions$graphics$eal$CAbstractEventListener)) {
            ealswigJNI.eal_CAbstractEventListener_process(this.swigCPtr, this, IEvent.getCPtr(iEvent), iEvent);
        } else {
            ealswigJNI.eal_CAbstractEventListener_processSwigExplicitCAbstractEventListener(this.swigCPtr, this, IEvent.getCPtr(iEvent), iEvent);
        }
    }

    public void dispose() {
        ealswigJNI.eal_CAbstractEventListener_dispose(this.swigCPtr, this);
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

