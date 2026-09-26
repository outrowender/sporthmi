/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.view.IPartialPopupController;

public class RegisterPartialPopupsEvent
extends ATIPEvent {
    private final IPartialPopupController[] popups;
    private final boolean serviceAdded;
    private final int bundleID;

    public RegisterPartialPopupsEvent(ATIPEventListener aTIPEventListener, IPartialPopupController[] iPartialPopupControllerArray, boolean bl, int n) {
        super(aTIPEventListener, 19001);
        this.popups = iPartialPopupControllerArray;
        this.serviceAdded = bl;
        this.bundleID = n;
    }

    public IPartialPopupController[] getPopups() {
        return this.popups;
    }

    public boolean isServiceAdded() {
        return this.serviceAdded;
    }

    public int getBundleID() {
        return this.bundleID;
    }
}

