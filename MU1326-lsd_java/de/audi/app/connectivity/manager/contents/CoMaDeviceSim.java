/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;
import de.audi.atip.hmi.model.PropertyListCell;

public final class CoMaDeviceSim
extends AbstractCoMaDevice {
    private static final PropertyListCell SIM = PropertyListCell.create(899035788, new int[]{87838446});
    private static final PropertyListCell SIM_WITH_CALL = PropertyListCell.create(899035788, new int[]{87838446, -1376557054});
    private static final PropertyListCell ESIM = PropertyListCell.create(899035788, new int[]{486525952});
    private final boolean hasActiveCall;
    private final boolean isEsim;

    public CoMaDeviceSim(int n, int n2, int n3, String string, String string2, boolean bl, boolean bl2) {
        super(0, n, n2, n3, string, string2, 0);
        this.hasActiveCall = bl;
        this.isEsim = bl2;
    }

    @Override
    PropertyListCell getProperties() {
        return this.isEsim ? ESIM : (this.hasActiveCall ? SIM_WITH_CALL : SIM);
    }
}

