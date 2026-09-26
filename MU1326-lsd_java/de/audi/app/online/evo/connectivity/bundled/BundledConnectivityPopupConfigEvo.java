/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.connectivity.bundled;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.connectivity.bundled.BundledConnectivityPopupConfig;

public class BundledConnectivityPopupConfigEvo
extends BundledConnectivityPopupConfig {
    private static final int TYPE_ID_DEFAULT;
    private int popupTypeChoiceModelId = -1;
    private int serviceAvailableChoiceModelId = -1;

    public BundledConnectivityPopupConfigEvo(LogChannel logChannel, int n, int n2, int n3, int n4) {
        super(logChannel, n, n2);
        this.popupTypeChoiceModelId = n3;
        this.serviceAvailableChoiceModelId = n4;
    }

    public void registerDefaultPopupId(int n) {
        this.registerPopupIdToType(0, n);
    }

    public int getDefaultPopupId() {
        return this.getPopupId(0);
    }

    public int getPopupTypeChoiceModelId() {
        return this.popupTypeChoiceModelId;
    }

    public int getServiceAvailableChoiceModelId() {
        return this.serviceAvailableChoiceModelId;
    }
}

