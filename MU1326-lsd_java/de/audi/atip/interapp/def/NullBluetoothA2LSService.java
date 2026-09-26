/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.IBluetoothA2LSService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullBluetoothA2LSService
extends NullService
implements IBluetoothA2LSService {
    public NullBluetoothA2LSService(LogChannel logChannel) {
        super(logChannel, "NullBluetoothA2LSService");
    }

    @Override
    public void updateA2LSActive(boolean bl) {
        this.log("updateA2LSActive");
    }
}

