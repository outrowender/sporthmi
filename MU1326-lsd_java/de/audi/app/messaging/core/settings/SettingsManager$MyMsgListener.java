/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.settings.RestoreFactorySettingsCommand;
import de.audi.app.messaging.core.settings.SettingsManager;
import de.audi.app.messaging.core.settings.SettingsManager$1;
import de.audi.atip.msg.MsgListener;

class SettingsManager$MyMsgListener
implements MsgListener {
    private final /* synthetic */ SettingsManager this$0;

    private SettingsManager$MyMsgListener(SettingsManager settingsManager) {
        this.this$0 = settingsManager;
    }

    @Override
    public void processMsg(int n) {
        if (n == 35) {
            SettingsManager.access$900(this.this$0).log(1078071040, "[SettingsManager#processMsg] message = %1, resetting to factory settings.", (long)n);
            new RestoreFactorySettingsCommand(SettingsManager.access$1000(this.this$0), SettingsManager.access$1100(this.this$0)).schedule();
        }
    }

    /* synthetic */ SettingsManager$MyMsgListener(SettingsManager settingsManager, SettingsManager$1 settingsManager$1) {
        this(settingsManager);
    }
}

