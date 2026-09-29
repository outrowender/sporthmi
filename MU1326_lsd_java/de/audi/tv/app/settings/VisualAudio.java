/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.settings.ISettingListener;
import de.audi.tv.app.settings.SettingsStorage;
import de.audi.tv.app.settings.VisualAudio$1;
import de.audi.tv.app.settings.VisualAudio$ChoiceListener;

class VisualAudio {
    protected static final boolean DEFAULT;
    private static final int VISUAL_AUDIO_ENABLED;
    private static final int VISUAL_AUDIO_DISABLED;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final ISettingListener provider;
    private final ChoiceModelApp visualAudioChoice;

    VisualAudio(TVEnv tVEnv, SettingsStorage settingsStorage, ISettingListener iSettingListener) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.provider = iSettingListener;
        this.visualAudioChoice = tVEnv.getChoiceModel(1269573376);
        this.visualAudioChoice.setChoiceListener(new VisualAudio$ChoiceListener(this, null));
        this.visualAudioChoice.setValue(1);
        this.env.properties.settings.visualAudioActive.accept(new Boolean(true));
        this.env.properties.settings.visualAudioActive.subscribe(new VisualAudio$1(this));
        iSettingListener.updateVisualAudio(true);
    }

    void restore() {
        boolean bl = this.storage.loadVisualAudio();
        this.visualAudioChoice.setValue(bl ? 1 : 0);
        this.env.properties.settings.visualAudioActive.accept(new Boolean(bl));
        this.provider.updateVisualAudio(bl);
    }

    void resetToDefault() {
        this.update(true);
        this.env.properties.settings.visualAudioActive.accept(new Boolean(true));
    }

    private void update(boolean bl) {
        int n = bl ? 1 : 0;
        this.visualAudioChoice.setValue(n);
        this.provider.updateVisualAudio(bl);
        this.storage.saveVisualAudio(bl);
    }

    static /* synthetic */ void access$100(VisualAudio visualAudio, boolean bl) {
        visualAudio.update(bl);
    }

    static /* synthetic */ TVEnv access$200(VisualAudio visualAudio) {
        return visualAudio.env;
    }
}

