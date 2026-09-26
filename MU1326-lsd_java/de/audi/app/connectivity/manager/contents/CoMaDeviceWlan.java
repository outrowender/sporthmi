/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;
import de.audi.atip.hmi.model.PropertyListCell;

public class CoMaDeviceWlan
extends AbstractCoMaDevice {
    public CoMaDeviceWlan(int n, int n2, int n3, String string, String string2) {
        super(2, n, n2, n3, string2, string, 0);
    }

    @Override
    PropertyListCell getProperties() {
        return PropertyListCell.create(1303657598, null);
    }
}

