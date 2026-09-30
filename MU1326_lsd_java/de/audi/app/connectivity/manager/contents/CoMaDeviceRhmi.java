/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;
import de.audi.atip.hmi.model.PropertyListCell;

public class CoMaDeviceRhmi
extends AbstractCoMaDevice {
    public CoMaDeviceRhmi(String string, String string2, boolean bl) {
        super(4, 8, bl ? 8 : 0, 8, string2, string, 0);
    }

    PropertyListCell getProperties() {
        return null;
    }
}

