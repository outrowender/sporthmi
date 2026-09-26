/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.IEvent;
import de.esolutions.graphics.eal.api.IFontGroupAsync;
import de.esolutions.graphics.ealswigJNI;

public class IEventFontGroup
extends IEvent {
    private long swigCPtr;

    public IEventFontGroup(long l, boolean bl) {
        super(ealswigJNI.eal_IEventFontGroup_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IEventFontGroup iEventFontGroup) {
        return iEventFontGroup == null ? 0L : iEventFontGroup.swigCPtr;
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
                ealswigJNI.delete_eal_IEventFontGroup(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IFontGroupAsync requestFontgroup() {
        long l = ealswigJNI.eal_IEventFontGroup_requestFontgroup(this.swigCPtr, this);
        return l == 0L ? null : new IFontGroupAsync(l, false);
    }
}

