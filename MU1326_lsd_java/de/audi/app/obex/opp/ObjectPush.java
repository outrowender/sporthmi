/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.obex.opp;

import de.audi.app.obex.IEvoObexApplication;
import de.audi.app.obex.core.opp.AbstractObjectPush;

public class ObjectPush
extends AbstractObjectPush {
    private final IEvoObexApplication application;

    public ObjectPush(IEvoObexApplication iEvoObexApplication) {
        super(iEvoObexApplication);
        this.application = iEvoObexApplication;
    }

    protected boolean isTrustedDevice(String string) {
        return this.application.getEvoConnectivity().getBluetooth().getTrustedDeviceList().get(string) != null;
    }
}

