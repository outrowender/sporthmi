/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;
import de.audi.atip.hmi.model.PropertyListCell;

public class CoMaDeviceUpnp
extends AbstractCoMaDevice {
    public CoMaDeviceUpnp(String string) {
        super(3, 128, 128, 128, string, string, 0);
    }

    @Override
    PropertyListCell getProperties() {
        return null;
    }
}

