/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.audio;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.audio.AudioChannelRow;
import de.audi.tv.app.settings.audio.AudioLanguageCodes;
import org.dsi.ifc.tvtuner.AudioChannel;

public class AudioChannels {
    private static final int CHANNEL_DISABLED = 0;
    private static final int CHANNEL_ENABLED = 1;
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
        this.listModel = tVEnv.getBaseListModel(2600031);
        this.listModel.setListener(new AudioFormatListListener());
        tVEnv.getButtonModel(2600173).setButtonListener(new ToggleAudioListener());
        this.updateAudioToggleButtonStatus();
    }

    public void resetToDefault() {
        this.dsi.setAudioChannel(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateActiveAudioChannel(int n) {
        this.env.lcMain.log(10000000, "[AudioChannels.updateActiveAudioChannel] channelID:%1", (long)n);
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
                this.env.lcMain.log(10000000, "[AudioChannels.update] [%2] %1", (Object)audioChannelArray[i2], (long)i2);
            }
        }
        Object object = this.mutex;
        synchronized (object) {
            this.hasMultipleAudioChannels = audioChannelArray.length > 1;
            this.env.getChoiceModel(2600187).setValue(audioChannelArray.length);
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
                    this.env.lcMain.log(100000, "[AudioChannels.update] No text ID found for %1", (Object)audioChannel);
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
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(2600100);
        if (n == -1) {
            choiceModelApp.setValue(0);
        } else {
            choiceModelApp.setValue(((AudioChannelRow)this.listModel.getRow(n)).getTextCode());
        }
    }

    private final void updateAudioToggleButtonStatus() {
        this.env.getButtonModel(2600173).setStatus(this.showAudioToggleButton ? (this.hasMultipleAudioChannels ? 1 : 3) : 0);
    }

    private class ToggleAudioListener
    extends DefaultButtonListener {
        private ToggleAudioListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void keyPressed(int n, int n2, int n3) {
            ((AudioChannels)AudioChannels.this).env.lcHMI.log(10000000, "[AudioChannels.keyPressed] toggle audio channel");
            int n4 = 0;
            Object object = AudioChannels.this.mutex;
            synchronized (object) {
                SelectedItem selectedItem = AudioChannels.this.listModel.getSelected();
                int n5 = AudioChannels.this.listModel.getLength();
                if (selectedItem == null || n5 < 2) {
                    return;
                }
                int n6 = selectedItem.getIndex() + 1;
                if (n6 >= n5) {
                    n6 = 0;
                }
                n4 = ((AudioChannelRow)((AudioChannels)AudioChannels.this).listModel.getRow((int)n6)).getAudioChannel().channelID;
            }
            AudioChannels.this.updateActiveAudioChannel(n4);
            AudioChannels.this.dsi.setAudioChannel(n4);
        }
    }

    private class AudioFormatListListener
    extends DefaultBaseListModelListener {
        private AudioFormatListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            ((AudioChannels)AudioChannels.this).env.lcHMI.log(10000000, "[AudioChannels.itemSelected] [%2] %1", (Object)((AudioChannelRow)evoListRow).getAudioChannel(), (long)n2);
            AudioChannels.this.updateActiveAudioChannel(((AudioChannelRow)evoListRow).getAudioChannel().channelID);
            AudioChannels.this.dsi.setAudioChannel(((AudioChannelRow)evoListRow).getAudioChannel().channelID);
            AudioChannels.this.listModel.fireEvent(n4);
        }
    }
}

