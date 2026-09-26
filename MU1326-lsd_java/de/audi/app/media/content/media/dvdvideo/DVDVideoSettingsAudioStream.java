/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.dvdvideo;

import de.audi.app.media.AbstractSettingsList;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.MediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.dsi.ifc.media.AudioStream;

public class DVDVideoSettingsAudioStream
extends AbstractSettingsList {
    private static final String LOGCLASS;
    private final BaseListModelApp audioStreamList;
    private final ChoiceModelApp leaveSettingsTrigger;
    private final ChoiceModelApp previewLanguage;
    private final ChoiceModelApp previewChannel;
    private final ChoiceModelApp previewFormat;
    private final MediaTerminal mediaTerminal;
    private static final int AUDIOSTREAM_LIST_COLUMNS;
    private static final int AUDIOSTREAM_LIST_COL_LANGUAGE;
    private static final int AUDIOSTREAM_LIST_COL_CHANNELS;
    private static final int AUDIOSTREAM_LIST_COL_FORMAT;
    private static final int AUDIOSTREAM_LIST_COL_SELECTION;
    private static final int AUDIOSTREAM_LIST_COL_LANGUAGE_CODE;
    private static final int CODING_UNDEF;
    private static final int CODING_DOLBYAC3;
    private static final int CODING_MPEG;
    private static final int CODING_MPEGEXT;
    private static final int CODING_LPCM;
    private static final int CODING_DTS;
    private static final int CODING_SDDS;
    private static final int CODING_MLP;
    private static final int CHANNELS_UNKNOWN;
    private static final int CHANNELS_1;
    private static final int CHANNELS_2;
    private static final int CHANNELS_21;
    private static final int CHANNELS_4;
    private static final int CHANNELS_51;
    private static final int CHANNELS_71;
    private final IMediaDSIPlayerController dsiPlayer;

    public DVDVideoSettingsAudioStream(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, BaseListModelApp baseListModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4) {
        super(iMediaTerminal);
        this.dsiPlayer = iMediaDSIPlayerController;
        this.audioStreamList = baseListModelApp;
        this.leaveSettingsTrigger = choiceModelApp4;
        this.previewChannel = choiceModelApp2;
        this.previewFormat = choiceModelApp3;
        this.previewLanguage = choiceModelApp;
        this.audioStreamList.setListener(this);
        this.audioStreamList.removeAll();
        this.mediaTerminal = (MediaTerminal)iMediaTerminal;
    }

    @Override
    protected int getCheckboxColumn() {
        return 3;
    }

    @Override
    protected BaseListModelApp getListModel() {
        return this.audioStreamList;
    }

    @Override
    protected void entrySelected(int n) {
        this.dsiPlayer.setAudioStream(n);
    }

    public void updateAudioStreamList(AudioStream[] audioStreamArray) {
        this.logger.main().log(1078071040, "[%1.updateAudioStreamList] called.", (Object)"DVDVideoSettingsAudioStream");
        if (0 == audioStreamArray.length) {
            this.leaveSettingsTrigger.setValue(this.leaveSettingsTrigger.getValue() == 1 ? 2 : 1);
        }
        BaseListModelApp baseListModelApp = this.audioStreamList.getCopy();
        baseListModelApp.removeAll();
        baseListModelApp.setSelectedIndex(-1);
        baseListModelApp.setLength(audioStreamArray.length);
        for (int i2 = 0; i2 < audioStreamArray.length; ++i2) {
            baseListModelApp.setRow(i2, this.createRow(i2, audioStreamArray[i2]));
        }
        this.audioStreamList.update(baseListModelApp);
    }

    public void updateActiveAudioStream(int n) {
        this.logger.main().log(1078071040, "[%1.updateActiveAudioStream] activeAudioStreamIdx='%2'.", (Object)"DVDVideoSettingsAudioStream", (long)n);
        if (this.updateActiveEntry(n)) {
            int n2 = this.audioStreamList.getRow(n).getInteger(4);
            this.previewLanguage.setValue(this.languageMapper.getArrayPosition(n2));
            int n3 = this.audioStreamList.getRow(n).getInteger(1);
            this.previewChannel.setValue(n3);
            int n4 = this.audioStreamList.getRow(n).getInteger(2);
            this.previewFormat.setValue(n4);
            this.logger.main().log(1078071040, "[%1.updateActiveAudioStream] updateActiveEntry called.", (Object)"DVDVideoSettingsAudioStream");
            if (n3 == 5 || n3 == 6) {
                this.logger.main().log(1078071040, "[%1.updateActiveAudioStream] channelID:%2 (%3)", (Object)"DVDVideoSettingsAudioStream", (Object)Integer.toString(n3), (Object)(n3 == 5 ? "5.1" : "7.1"));
                this.mediaTerminal.getAudioManager().getToneService().setSurroundForActiveEntertainment(true);
            }
        } else {
            this.previewLanguage.setValue(this.languageMapper.getArrayPosition(0));
            this.previewChannel.setValue(0);
        }
    }

    private EvoListRow createRow(long l, AudioStream audioStream) {
        EvoListRow evoListRow = new EvoListRow(l, 5);
        evoListRow.setInteger(0, this.languageMapper.getArrayPosition(audioStream.getLanguageCode()));
        evoListRow.setInteger(1, this.getChannelsID(audioStream));
        evoListRow.setInteger(2, this.getAudioFormatIconID(audioStream));
        evoListRow.setInteger(3, 0);
        evoListRow.setInteger(4, audioStream.getLanguageCode());
        return evoListRow;
    }

    private int getChannelsID(AudioStream audioStream) {
        switch (audioStream.getNumChannels()) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: 
            case 6: 
            case 7: {
                return 5;
            }
            case 8: {
                return 6;
            }
        }
        this.logger.dsi().log(1078071040, "[%1.getChannelsID()] Invalid number of channels in audiostream: '%1'", (Object)audioStream);
        return 0;
    }

    private int getAudioFormatIconID(AudioStream audioStream) {
        switch (audioStream.audioCoding) {
            case -1: {
                return 0;
            }
            case 0: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 6: {
                return 5;
            }
            case 7: {
                return 6;
            }
            case 8: {
                return 7;
            }
        }
        this.logger.dsi().log(1078071040, "[%1.getAudioFormatIconID()] Invalid audio coding in audiostream: '%1'", (Object)audioStream);
        return 0;
    }
}

