/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.network;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.network.AbstractTelNetworkSetupHandler;

public class TelNetworkSetupHandler
extends AbstractTelNetworkSetupHandler {
    public TelNetworkSetupHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
    }

    protected int modelIDNetworkSelectionButton() {
        return 300203;
    }

    protected int modelIDNetworkRegistrationType() {
        return 301155;
    }

    protected int modelIDNetworkSelectionList() {
        return 301159;
    }

    protected int modelIDNWSearchStatusChoice() {
        return 300201;
    }

    protected int modelIDNWSelectedLabel() {
        return 300202;
    }

    protected int modelIDNWRegisterStatusChoice() {
        return 300199;
    }
}

