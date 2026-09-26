/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.config;

import de.audi.app.bap.fw.config.BAPConfig;

public final class BAPConfigChecker {
    private final BAPConfig supportedConfig;

    public static BAPConfigChecker getInstance(BAPConfig bAPConfig) {
        return new BAPConfigChecker(bAPConfig);
    }

    private BAPConfigChecker(BAPConfig bAPConfig) {
        this.supportedConfig = bAPConfig;
    }

    public boolean isConfigSupported(BAPConfig bAPConfig) {
        return this.supportedConfig.isCompatibleWith(bAPConfig);
    }
}

