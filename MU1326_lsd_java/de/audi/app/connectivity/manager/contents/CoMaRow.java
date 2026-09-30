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
    private static final int ENABLED = 1;
    private static final int DISABLED = 0;
    private static final int MAX_COLUMN_CONNECT_NEW_DEVICE = 11;
    private static final int MAX_COLUMN_CATEGORY = 7;
    private static final int MAX_COLUMN_DEVICE = 10;
    static final int COLUMN_RECORDSET = 0;
    private static final int COLUMN_ENABLED = 1;
    private static final int COLUMN_CATEGORY = 2;
    static final int COLUMN_NAME = 3;
    static final int COLUMN_PROPERTY_OBJECT = 4;
    private static final int COLUMN_DEVICETYPE = 5;
    static final int COLUMN_KEY = 6;
    private static final int COLUMN_CONNECTED = 7;
    private static final int COLUMN_PRIO_RECONNECT = 8;
    private static final int COLUMN_SMARTPHONE_INTEGRATIONTYPE = 9;
    private static final int COLUMN_INFOLINE_TEXT_DISABLED = 10;
    static final int RS_CATEGORY_CLOSED = 0;
    static final int RS_CATEGORY_OPEN = 1;
    static final int RS_DEVICE = 2;
    static final int RS_ACTION_CONNECT = 3;
    static final int RS_SMARTPHONE_INTEGRATION_DEVICE = 4;
    static final int INFOLINE_TEXT_DISABLED_WHILE_DRIVING = 0;
    static final int INFOLINE_TEXT_DISABLED_DEFAULT = -1;

    CoMaRow(int n, String string) {
        super(n, 7);
        this.setInteger(0, 0);
        this.setInteger(1, 1);
        this.setInteger(2, n);
        this.setText(3, string);
        this.setInteger(5, Integer.MIN_VALUE);
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

    public int getType() {
        return this.getInteger(5);
    }

    public String getDeviceIdentifier() {
        return this.getText(6);
    }

    public String getName() {
        return this.getText(3);
    }

    public boolean isConnected() {
        return this.getInteger(7) == 1;
    }

    boolean isActive() {
        return this.getInteger(1) == 1;
    }

    public EvoListRow copy() {
        return new CoMaRow(this);
    }
}

