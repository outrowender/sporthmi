/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.settings.RestoreFactorySettingsCommand$ResultHandler;
import de.audi.app.messaging.core.settings.SettingsManager;
import de.audi.app.messaging.core.settings.SettingsManager$1;

final class SettingsManager$CommandResultHandler
implements RestoreFactorySettingsCommand$ResultHandler {
    private final /* synthetic */ SettingsManager this$0;

    private SettingsManager$CommandResultHandler(SettingsManager settingsManager) {
        this.this$0 = settingsManager;
    }

    @Override
    public void handleResult(int n) {
        SettingsManager.access$1200(this.this$0).log(-2137614336, "[SettingsManager#handleCommandResult] result = %1", (long)n);
        SettingsManager.access$1300(this.this$0);
    }

    /* synthetic */ SettingsManager$CommandResultHandler(SettingsManager settingsManager, SettingsManager$1 settingsManager$1) {
        this(settingsManager);
    }
}

