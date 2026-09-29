/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.tv.app.settings.ISettingHandler;
import de.audi.tv.app.settings.TVSettings;
import de.audi.tv.app.settings.TVSettings$1;

class TVSettings$SettingHandler
implements ISettingHandler {
    private final /* synthetic */ TVSettings this$0;

    private TVSettings$SettingHandler(TVSettings tVSettings) {
        this.this$0 = tVSettings;
    }

    @Override
    public void setAudioToggleButtonAvailability(boolean bl) {
        TVSettings.access$700(this.this$0).setAudioToggleButtonAvailability(bl);
    }

    @Override
    public void resetPasswordConfirmation() {
        TVSettings.access$800(this.this$0).resetPasswordConfirmation();
    }

    @Override
    public void parentalRatingLeft() {
    }

    /* synthetic */ TVSettings$SettingHandler(TVSettings tVSettings, TVSettings$1 tVSettings$1) {
        this(tVSettings);
    }
}

