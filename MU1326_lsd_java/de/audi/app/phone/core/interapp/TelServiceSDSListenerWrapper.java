/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.interapp.TelServiceListenerWrapper;
import de.audi.atip.phone.ITelServiceSDSListener;
import org.dsi.ifc.telephoneng.LockStateStruct;

public class TelServiceSDSListenerWrapper
extends TelServiceListenerWrapper {
    private final ITelServiceSDSListener sdsListener;

    public TelServiceSDSListenerWrapper(ITelServiceSDSListener iTelServiceSDSListener) {
        super(iTelServiceSDSListener);
        this.sdsListener = iTelServiceSDSListener;
    }

    public void responseUnlockSIM(int n, int n2, LockStateStruct lockStateStruct) {
        this.sdsListener.unlockSIMResponse(this.mapResultCode(n));
    }

    public void responseSetMailboxContent(int n, int n2) {
        this.sdsListener.setMailboxResponse(this.mapResultCode(n));
    }
}

