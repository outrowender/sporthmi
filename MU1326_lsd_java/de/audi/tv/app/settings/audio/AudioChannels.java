/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.audio;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.audio.AudioChannelRow;
import de.audi.tv.app.settings.audio.AudioChannels$AudioFormatListListener;
import de.audi.tv.app.settings.audio.AudioChannels$ToggleAudioListener;
import de.audi.tv.app.settings.audio.AudioLanguageCodes;
import org.dsi.ifc.tvtuner.AudioChannel;

public class AudioChannels {
    private static final int CHANNEL_DISABLED;
    private static final int CHANNEL_ENABLED;
    private final BaseListModelApp listModel;
    private int currentlySelectedAudioChannelID = -1;
    private final TVEnv env;
    private final DSITV dsi;
    private final Object mutex = new Object();
    private boolean hasMultipleAudioChannels = false;
    private boolean showAudioToggleButton = true;

    public AudioChannels(TVEnv tVEnv, DSITV dSITV) {
        this.env = tVEnv;
        this.dsi = dSITV;
        this.listModel = tVEnv.getBaseListModel(1605117696);
        this.listModel.setListener(new AudioChannels$AudioFormatListListener(this, null));
        tVEnv.getButtonModel(-307484928).setButtonListener(new AudioChannels$ToggleAudioListener(this, null));
        this.updateAudioToggleButtonStatus();
    }

    public void resetToDefault() {
        this.dsi.setAudioChannel(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateActiveAudioChannel(int n) {
        this.env.lcMain.log(-2137614336, "[AudioChannels.updateActiveAudioChannel] channelID:%1", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            this.currentlySelectedAudioChannelID = n;
            int n2 = -1;
            BaseListModelApp baseListModelApp = this.listModel.getCopy();
            for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
                int n3;
                AudioChannelRow audioChannelRow = (AudioChannelRow)this.listModel.getRow(i2);
                if (audioChannelRow.getAudioChannel().channelID == n) {
                    n3 = 1;
                    n2 = i2;
                } else {
                    n3 = 0;
                }
                audioChannelRow.setSelected(n3);
                baseListModelApp.setRow(i2, audioChannelRow);
            }
            baseListModelApp.setSelectedUniqueID(n);
            this.listModel.update(baseListModelApp);
            this.updatePreview(n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setAudioToggleButtonAvailability(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            this.showAudioToggleButton = bl;
            this.updateAudioToggleButtonStatus();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void update(AudioChannel[] audioChannelArray) {
        if (this.env.lcMain.isDebug()) {
            for (int i2 = 0; i2 < audioChannelArray.length; ++i2) {
                this.env.lcMain.log(-2137614336, "[AudioChannels.update] [%2] %1", (Object)audioChannelArray[i2], (long)i2);
            }
        }
        Object object = this.mutex;
        synchronized (object) {
            this.hasMultipleAudioChannels = audioChannelArray.length > 1;
            this.env.getChoiceModel(-72603904).setValue(audioChannelArray.length);
            this.updateAudioToggleButtonStatus();
            BaseListModelApp baseListModelApp = this.listModel.getEmptyCopy();
            int n = -1;
            for (int i3 = 0; i3 < audioChannelArray.length; ++i3) {
                int n2;
                AudioChannel audioChannel = audioChannelArray[i3];
                if (audioChannel.channelID == this.currentlySelectedAudioChannelID) {
                    n2 = 1;
                    n = i3;
                } else {
                    n2 = 0;
                }
                int n3 = AudioLanguageCodes.getTextID(audioChannel);
                if (n3 == 0) {
                    this.env.lcMain.log(-1601830656, "[AudioChannels.update] No text ID found for %1", (Object)audioChannel);
                }
                AudioChannelRow audioChannelRow = new AudioChannelRow(audioChannel, n3, n2);
                baseListModelApp.append(audioChannelRow);
            }
            baseListModelApp.setSelectedIndex(n);
            this.listModel.update(baseListModelApp);
            this.updatePreview(n);
        }
    }

    private void updatePreview(int n) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-1532221696);
        if (n == -1) {
            choiceModelApp.setValue(0);
        } else {
            choiceModelApp.setValue(((AudioChannelRow)this.listModel.getRow(n)).getTextCode());
        }
    }

    private final void updateAudioToggleButtonStatus() {
        this.env.getButtonModel(-307484928).setStatus(this.showAudioToggleButton ? (this.hasMultipleAudioChannels ? 1 : 3) : 0);
    }

    static /* synthetic */ TVEnv access$200(AudioChannels audioChannels) {
        return audioChannels.env;
    }

    static /* synthetic */ DSITV access$300(AudioChannels audioChannels) {
        return audioChannels.dsi;
    }

    static /* synthetic */ BaseListModelApp access$400(AudioChannels audioChannels) {
        return audioChannels.listModel;
    }

    static /* synthetic */ Object access$500(AudioChannels audioChannels) {
        return audioChannels.mutex;
    }
}

