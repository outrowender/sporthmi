/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.connection;

import de.audi.app.data.core.AbstractDataConnectionComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.dsi.ifc.networking.DataConnectionStateStruct;

public class AbstractConnectionState
extends AbstractDataConnectionComponent {
    private static final int DISCONNECTED = 0;
    private static final int CONNECTED = 1;
    private final int[] attributeNotifications = new int[]{1};
    private final ChoiceModelApp connectionState = this.getChoiceModel(93);

    public AbstractConnectionState(IDataApplication iDataApplication) {
        super(iDataApplication);
    }

    protected int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    public void updateStateDataConnection(DataConnectionStateStruct dataConnectionStateStruct, int n) {
        boolean bl;
        if (n != 1 || dataConnectionStateStruct == null) {
            return;
        }
        switch (dataConnectionStateStruct.getContextState()) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        this.log.log(1000000, "AbstractConnectionState#updateStateDataConnection(): connected=%1", bl);
        this.connectionState.setValue(bl ? 1 : 0);
    }
}

