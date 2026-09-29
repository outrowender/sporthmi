/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigEmptyListener;
import de.audi.app.messaging.core.settings.SettingsManager;
import de.audi.app.messaging.core.settings.SettingsManager$1;

class SettingsManager$MyDsiMessagingConfigListener
extends DsiMessagingConfigEmptyListener {
    private final /* synthetic */ SettingsManager this$0;

    private SettingsManager$MyDsiMessagingConfigListener(SettingsManager settingsManager) {
        this.this$0 = settingsManager;
    }

    @Override
    public void updateStoreSmsOnSent(boolean bl, int n) {
        SettingsManager.access$1400(this.this$0).log(-2137614336, "[SettingsManager#updateStoreSmsOnSent] store = %1", bl);
        int n2 = bl ? 1 : 0;
        SettingsManager.access$1500(this.this$0).getHmiServiceApp().getChoiceModel(848437504).setValue(n2);
    }

    @Override
    public void updatePushSms(boolean bl, int n) {
        SettingsManager.access$1600(this.this$0).log(-2137614336, "[SettingsManager#updatePushSms] pushSms = %1", bl);
        int n2 = bl ? 1 : 0;
        SettingsManager.access$1700(this.this$0).getHmiServiceApp().getChoiceModel(881991936).setValue(n2);
    }

    @Override
    public void updateSmsIndications(boolean bl, int n) {
        SettingsManager.access$1800(this.this$0).log(-2137614336, "[SettingsManager#updateSmsIndications] smsIndications = %1", bl);
        int n2 = bl ? 1 : 0;
        SettingsManager.access$1900(this.this$0).getHmiServiceApp().getChoiceModel(915546368).setValue(n2);
    }

    @Override
    public void updateEmailIndications(boolean bl, int n) {
        SettingsManager.access$2000(this.this$0).log(-2137614336, "[SettingsManager#updateEmailIndications] emailIndications = %1", bl);
        int n2 = bl ? 1 : 0;
        SettingsManager.access$2100(this.this$0).getHmiServiceApp().getChoiceModel(1150427392).setValue(n2);
    }

    /* synthetic */ SettingsManager$MyDsiMessagingConfigListener(SettingsManager settingsManager, SettingsManager$1 settingsManager$1) {
        this(settingsManager);
    }
}

