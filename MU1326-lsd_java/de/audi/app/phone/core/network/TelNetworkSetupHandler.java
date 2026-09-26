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

    @Override
    protected int modelIDNetworkSelectionButton() {
        return -1416363008;
    }

    @Override
    protected int modelIDNetworkRegistrationType() {
        return 1670906880;
    }

    @Override
    protected int modelIDNetworkSelectionList() {
        return 1738015744;
    }

    @Override
    protected int modelIDNWSearchStatusChoice() {
        return -1449917440;
    }

    @Override
    protected int modelIDNWSelectedLabel() {
        return -1433140224;
    }

    @Override
    protected int modelIDNWRegisterStatusChoice() {
        return -1483471872;
    }
}

