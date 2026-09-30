/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.audio;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.tvtuner.AudioChannel;

class AudioChannelRow
extends EvoListRow {
    private static final int MAX_COLS = 7;
    private static final int AUDIO_CHANNEL_ID = 0;
    private static final int AUDIO_LANGUAGE_CODE = 1;
    private static final int AUDIO_CHANNEL_FORMAT = 2;
    private static final int AUDIO_CHANNEL_DESCRIPTION = 3;
    private static final int AUDIO_CHANNEL_SELECTED = 4;
    private static final int AUDIO_CHANNEL_IMAGE_RECORDSET = 5;
    private static final int AUDIO_CHANNEL_CLOSE_OPTIONMENU = 6;
    private final AudioChannel audioChannel;
    private int selected;
    private int textCode;

    private AudioChannelRow(AudioChannelRow audioChannelRow) {
        super(audioChannelRow);
        this.audioChannel = audioChannelRow.audioChannel;
        this.selected = audioChannelRow.selected;
        this.textCode = audioChannelRow.textCode;
        this.setColumns();
    }

    AudioChannelRow(AudioChannel audioChannel, int n, int n2) {
        super(audioChannel.channelID, 7);
        this.audioChannel = audioChannel;
        this.selected = n2;
        this.textCode = n;
        this.setColumns();
    }

    public AudioChannel getAudioChannel() {
        return this.audioChannel;
    }

    public int getSelected() {
        return this.selected;
    }

    public void setSelected(int n) {
        this.selected = n;
        this.setInteger(4, n);
    }

    public int getTextCode() {
        return this.textCode;
    }

    private void setImageRecordset(boolean bl, boolean bl2) {
        if (bl && bl2) {
            this.setInteger(5, 3);
        } else if (bl2) {
            this.setInteger(5, 2);
        } else if (bl) {
            this.setInteger(5, 1);
        } else {
            this.setInteger(5, 0);
        }
    }

    private void setColumns() {
        this.setInteger(0, this.audioChannel.channelID);
        this.setInteger(1, this.textCode);
        this.setInteger(2, this.audioChannel.audioFormat);
        this.setInteger(3, this.audioChannel.audioDescription);
        this.setInteger(4, this.selected);
        this.setImageRecordset(this.audioChannel.audioFormat > 0, this.audioChannel.audioDescription > 0);
        this.setInteger(6, 1);
    }

    public EvoListRow copy() {
        return new AudioChannelRow(this);
    }
}

