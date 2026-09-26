/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.audio;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.tvtuner.AudioChannel;

class AudioChannelRow
extends EvoListRow {
    private static final int MAX_COLS;
    private static final int AUDIO_CHANNEL_ID;
    private static final int AUDIO_LANGUAGE_CODE;
    private static final int AUDIO_CHANNEL_FORMAT;
    private static final int AUDIO_CHANNEL_DESCRIPTION;
    private static final int AUDIO_CHANNEL_SELECTED;
    private static final int AUDIO_CHANNEL_IMAGE_RECORDSET;
    private static final int AUDIO_CHANNEL_CLOSE_OPTIONMENU;
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

    @Override
    public EvoListRow copy() {
        return new AudioChannelRow(this);
    }
}

