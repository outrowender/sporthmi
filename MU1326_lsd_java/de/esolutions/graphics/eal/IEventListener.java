/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.FlagEvent;
import de.esolutions.graphics.eal.IEvent;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.ealswigJNI;

public class IEventListener {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public IEventListener(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(IEventListener iEventListener) {
        return iEventListener == null ? 0L : iEventListener.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_IEventListener(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public String getName() {
        return ealswigJNI.eal_IEventListener_getName(this.swigCPtr, this);
    }

    public void process(IEvent iEvent) {
        ealswigJNI.eal_IEventListener_process(this.swigCPtr, this, IEvent.getCPtr(iEvent), iEvent);
    }

    public FlagEvent getTypes() {
        return new FlagEvent(ealswigJNI.eal_IEventListener_getTypes(this.swigCPtr, this), false);
    }

    public boolean attach(IManager iManager) {
        return ealswigJNI.eal_IEventListener_attach(this.swigCPtr, this, IManager.getCPtr(iManager), iManager);
    }

    public boolean detach() {
        return ealswigJNI.eal_IEventListener_detach(this.swigCPtr, this);
    }
}

