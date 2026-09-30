/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.organizer.AddressData;

public class NavigationLocationListRow
extends EvoListRow {
    private static final int COLUMN_COUNT = 3;
    private static final int CELL_IDX_ADDRESS_ICON = 0;
    private static final int CELL_IDX_ADDRESS = 1;
    private static final int CELL_IDX_ADDRESS_SECONDARY = 2;
    private final AddressData data;
    private final String[] address;
    private final int type;

    public NavigationLocationListRow(int n, String[] stringArray, AddressData addressData) {
        super(n, 3);
        this.data = addressData;
        this.type = n;
        this.address = stringArray;
        this.setInteger(0, n);
        this.setText(1, stringArray[0] != null ? stringArray[0] : "");
        this.setText(2, stringArray[1] != null ? stringArray[1] : "");
    }

    public AddressData getData() {
        return this.data;
    }

    public String[] getAddress() {
        return this.address;
    }

    public int getType() {
        return this.type;
    }

    public EvoListRow copy() {
        return new NavigationLocationListRow(this.type, this.address, this.data);
    }
}

