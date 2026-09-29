/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;
import de.audi.app.connectivity.manager.contents.CoMaDeviceBlue;
import de.audi.app.connectivity.manager.contents.IDeviceSelection;
import de.audi.atip.hmi.model.list.EvoListRow;

public class CoMaRow
extends EvoListRow
implements IDeviceSelection {
    private static final int ENABLED;
    private static final int DISABLED;
    private static final int MAX_COLUMN_CONNECT_NEW_DEVICE;
    private static final int MAX_COLUMN_CATEGORY;
    private static final int MAX_COLUMN_DEVICE;
    static final int COLUMN_RECORDSET;
    private static final int COLUMN_ENABLED;
    private static final int COLUMN_CATEGORY;
    static final int COLUMN_NAME;
    static final int COLUMN_PROPERTY_OBJECT;
    private static final int COLUMN_DEVICETYPE;
    static final int COLUMN_KEY;
    private static final int COLUMN_CONNECTED;
    private static final int COLUMN_PRIO_RECONNECT;
    private static final int COLUMN_SMARTPHONE_INTEGRATIONTYPE;
    private static final int COLUMN_INFOLINE_TEXT_DISABLED;
    static final int RS_CATEGORY_CLOSED;
    static final int RS_CATEGORY_OPEN;
    static final int RS_DEVICE;
    static final int RS_ACTION_CONNECT;
    static final int RS_SMARTPHONE_INTEGRATION_DEVICE;
    static final int INFOLINE_TEXT_DISABLED_WHILE_DRIVING;
    static final int INFOLINE_TEXT_DISABLED_DEFAULT;

    CoMaRow(int n, String string) {
        super(n, 7);
        this.setInteger(0, 0);
        this.setInteger(1, 1);
        this.setInteger(2, n);
        this.setText(3, string);
        this.setInteger(5, 128);
    }

    CoMaRow(int n) {
        super((n + 1) * 100, 11);
        this.setInteger(0, 3);
        this.setInteger(1, n == 4 ? 0 : 1);
        this.setInteger(2, n);
    }

    CoMaRow(long l, int n, int n2, AbstractCoMaDevice abstractCoMaDevice) {
        super(l, 10);
        this.setInteger(0, abstractCoMaDevice.getType() == 7 ? 4 : 2);
        this.setInteger(1, abstractCoMaDevice.isChangeable(n2) && (!abstractCoMaDevice.isConnected(64) || n == 6) ? 1 : 0);
        this.setInteger(2, n);
        this.setText(3, abstractCoMaDevice.getName());
        this.setInteger(5, abstractCoMaDevice.getType());
        this.setText(6, abstractCoMaDevice.getAddress());
        this.setInteger(7, abstractCoMaDevice.isConnected(n2) ? 1 : 0);
        this.setPropertyCell(4, abstractCoMaDevice.getProperties());
        this.setInteger(9, abstractCoMaDevice.getsmartPhoneIntegrationType());
        if (abstractCoMaDevice instanceof CoMaDeviceBlue) {
            this.setInteger(8, this.isPhoneCategory(n) && ((CoMaDeviceBlue)abstractCoMaDevice).isPrioReconnect() ? 1 : 0);
        }
    }

    private final boolean isPhoneCategory(int n) {
        return n == 0 || n == 5;
    }

    CoMaRow(CoMaRow coMaRow) {
        super(coMaRow);
    }

    public int getRecordSet() {
        return this.getInteger(0);
    }

    public int getCategory() {
        return this.getInteger(2);
    }

    public void setActivation(boolean bl) {
        this.setInteger(1, bl ? 1 : 0);
    }

    public void setInfolineTextDisabled(boolean bl) {
        this.setInteger(10, bl ? 0 : -1);
    }

    @Override
    public int getType() {
        return this.getInteger(5);
    }

    @Override
    public String getDeviceIdentifier() {
        return this.getText(6);
    }

    @Override
    public String getName() {
        return this.getText(3);
    }

    @Override
    public boolean isConnected() {
        return this.getInteger(7) == 1;
    }

    boolean isActive() {
        return this.getInteger(1) == 1;
    }

    @Override
    public EvoListRow copy() {
        return new CoMaRow(this);
    }
}

