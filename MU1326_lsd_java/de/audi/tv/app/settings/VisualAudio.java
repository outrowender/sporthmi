/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.utils.generics.Consumer;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.settings.ISettingListener;
import de.audi.tv.app.settings.SettingsStorage;

class VisualAudio {
    protected static final boolean DEFAULT = true;
    private static final int VISUAL_AUDIO_ENABLED = 1;
    private static final int VISUAL_AUDIO_DISABLED = 0;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final ISettingListener provider;
    private final ChoiceModelApp visualAudioChoice;

    VisualAudio(TVEnv tVEnv, SettingsStorage settingsStorage, ISettingListener iSettingListener) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.provider = iSettingListener;
        this.visualAudioChoice = tVEnv.getChoiceModel(2600011);
        this.visualAudioChoice.setChoiceListener(new ChoiceListener());
        this.visualAudioChoice.setValue(1);
        this.env.properties.settings.visualAudioActive.accept(new Boolean(true));
        this.env.properties.settings.visualAudioActive.subscribe(new Consumer<Boolean>(){

            @Override
            public void accept(Boolean bl) {
                VisualAudio.this.update(bl);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Boolean)object);
            }
        });
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

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            boolean bl = n2 == 1;
            ((VisualAudio)VisualAudio.this).env.lcHMI.log(10000000, "[VisualAudio.itemSelected] %2 -> %1", bl, (long)n2);
            VisualAudio.this.update(bl);
            ((VisualAudio)VisualAudio.this).env.properties.settings.visualAudioActive.accept(new Boolean(bl));
        }
    }
}

