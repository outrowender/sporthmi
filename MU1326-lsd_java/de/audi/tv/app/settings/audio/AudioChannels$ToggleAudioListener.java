/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.audio;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tv.app.settings.audio.AudioChannelRow;
import de.audi.tv.app.settings.audio.AudioChannels;
import de.audi.tv.app.settings.audio.AudioChannels$1;

class AudioChannels$ToggleAudioListener
extends DefaultButtonListener {
    private final /* synthetic */ AudioChannels this$0;

    private AudioChannels$ToggleAudioListener(AudioChannels audioChannels) {
        this.this$0 = audioChannels;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void keyPressed(int n, int n2, int n3) {
        AudioChannels.access$200((AudioChannels)this.this$0).lcHMI.log(-2137614336, "[AudioChannels.keyPressed] toggle audio channel");
        int n4 = 0;
        Object object = AudioChannels.access$500(this.this$0);
        synchronized (object) {
            SelectedItem selectedItem = AudioChannels.access$400(this.this$0).getSelected();
            int n5 = AudioChannels.access$400(this.this$0).getLength();
            if (selectedItem == null || n5 < 2) {
                return;
            }
            int n6 = selectedItem.getIndex() + 1;
            if (n6 >= n5) {
                n6 = 0;
            }
            n4 = ((AudioChannelRow)AudioChannels.access$400((AudioChannels)this.this$0).getRow((int)n6)).getAudioChannel().channelID;
        }
        this.this$0.updateActiveAudioChannel(n4);
        AudioChannels.access$300(this.this$0).setAudioChannel(n4);
    }

    /* synthetic */ AudioChannels$ToggleAudioListener(AudioChannels audioChannels, AudioChannels$1 audioChannels$1) {
        this(audioChannels);
    }
}

