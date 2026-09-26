/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.settings.SettingsManager;
import de.audi.app.messaging.core.settings.SettingsManager$1;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;

class SettingsManager$MyChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ SettingsManager this$0;

    private SettingsManager$MyChoiceListener(SettingsManager settingsManager) {
        this.this$0 = settingsManager;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 2200114: {
                SettingsManager.access$400(this.this$0, n2);
                break;
            }
            case 2200116: {
                SettingsManager.access$500(this.this$0, n2);
                break;
            }
            case 2200118: {
                SettingsManager.access$600(this.this$0, n2);
                break;
            }
            case 2200132: {
                SettingsManager.access$700(this.this$0, n2);
                break;
            }
            default: {
                SettingsManager.access$800(this.this$0).log(10000, "[SettingsManager#itemSelected] Unexpected modelID = %1", (long)n);
            }
        }
    }

    /* synthetic */ SettingsManager$MyChoiceListener(SettingsManager settingsManager, SettingsManager$1 settingsManager$1) {
        this(settingsManager);
    }
}

