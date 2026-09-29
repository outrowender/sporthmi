/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.settings.ISettingHandler;

public class PorscheModelHelper {
    public static void setHideTvOptionsChoice(TVEnv tVEnv, int n) {
        tVEnv.getChoiceModel(4113).setValue(n);
    }

    public static void fireEpgDetailsButtonEvent(TVEnv tVEnv) {
        tVEnv.getButtonModel(-1062459648).fireEvent(0);
    }

    public static void showVisualAudioButton(TVEnv tVEnv, boolean bl, ISettingHandler iSettingHandler) {
        tVEnv.getButtonModel(-324262144).setStatus(bl ? 1 : 0);
        iSettingHandler.setAudioToggleButtonAvailability(!bl);
    }
}

