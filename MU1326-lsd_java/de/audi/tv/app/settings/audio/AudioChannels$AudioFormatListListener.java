/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.audio;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.settings.audio.AudioChannelRow;
import de.audi.tv.app.settings.audio.AudioChannels;
import de.audi.tv.app.settings.audio.AudioChannels$1;

class AudioChannels$AudioFormatListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ AudioChannels this$0;

    private AudioChannels$AudioFormatListListener(AudioChannels audioChannels) {
        this.this$0 = audioChannels;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        AudioChannels.access$200((AudioChannels)this.this$0).lcHMI.log(-2137614336, "[AudioChannels.itemSelected] [%2] %1", (Object)((AudioChannelRow)evoListRow).getAudioChannel(), (long)n2);
        this.this$0.updateActiveAudioChannel(((AudioChannelRow)evoListRow).getAudioChannel().channelID);
        AudioChannels.access$300(this.this$0).setAudioChannel(((AudioChannelRow)evoListRow).getAudioChannel().channelID);
        AudioChannels.access$400(this.this$0).fireEvent(n4);
    }

    /* synthetic */ AudioChannels$AudioFormatListListener(AudioChannels audioChannels, AudioChannels$1 audioChannels$1) {
        this(audioChannels);
    }
}

