/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;
import de.audi.app.connectivity.manager.contents.CoMaRow;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;

class CoMaCategoryRow
extends CoMaRow {
    CoMaCategoryRow(int n, String string) {
        super(n, string);
    }

    private CoMaCategoryRow(CoMaCategoryRow coMaCategoryRow) {
        super(coMaCategoryRow);
    }

    public void setDeviceName(String string) {
        this.setText(3, string);
    }

    void resetDevice(String string) {
        this.setDeviceName(string);
        this.setPropertyCell(4, PropertyListCell.EMPTY_CELL);
        this.setText(6, string);
    }

    public void setDevice(AbstractCoMaDevice abstractCoMaDevice) {
        if (abstractCoMaDevice != null) {
            this.setDeviceName(abstractCoMaDevice.getName());
            this.setPropertyCell(4, abstractCoMaDevice.getProperties());
            this.setText(6, abstractCoMaDevice.getAddress());
        }
    }

    void open() {
        this.setInteger(0, 1);
    }

    void close() {
        this.setInteger(0, 0);
    }

    @Override
    public EvoListRow copy() {
        return new CoMaCategoryRow(this);
    }
}

