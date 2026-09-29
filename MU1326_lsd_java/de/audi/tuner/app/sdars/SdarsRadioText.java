/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;
import de.audi.tuner.ifc.ISimpleTuner;
import org.dsi.ifc.sdars.RadioText;

public class SdarsRadioText
extends RadioText {
    public static final SdarsRadioText EMPTY_RADIOTEXT = new SdarsRadioText(new RadioText(0, "", "", "", "", "", "", "", 0));
    private int taggingStatus = 0;
    private RadioHMIResourceLocator coverArt = ISimpleTuner.EMPTY_RADIO_RL;

    public SdarsRadioText(RadioText radioText) {
        this.sID = radioText.sID;
        this.shortArtistName = radioText.shortArtistName;
        this.longArtistName = radioText.longArtistName;
        this.artistID = radioText.artistID;
        this.shortProgramTitle = radioText.shortProgramTitle;
        this.longProgramTitle = radioText.longProgramTitle;
        this.programID = radioText.programID;
        this.composer = radioText.composer;
        this.iTunesID = radioText.iTunesID;
    }

    public SdarsRadioText(SdarsRadioText sdarsRadioText) {
        this((RadioText)sdarsRadioText);
        this.taggingStatus = sdarsRadioText.taggingStatus;
        this.coverArt = sdarsRadioText.coverArt;
    }

    public int getTaggingStatus() {
        return this.taggingStatus;
    }

    public void setTaggingStatus(int n) {
        this.taggingStatus = n;
    }

    public void setCoverArt(HMIResourceLocator hMIResourceLocator) {
        this.coverArt = hMIResourceLocator == null ? ISimpleTuner.EMPTY_RADIO_RL : new RadioHMIResourceLocator(hMIResourceLocator, 1);
    }

    public boolean isAlreadyTaggedForITunes() {
        return this.taggingStatus == 3;
    }

    public RadioHMIResourceLocator getCoverArt() {
        return this.coverArt;
    }

    public boolean artistOrTitleInformationAvailable() {
        return !Utilities.isEmpty(this.getLongestAvailableArtistName()) || !Utilities.isEmpty(this.getLongestAvailableProgramTitle());
    }

    public boolean iTunesIdAvailable() {
        return this.iTunesID != 0;
    }

    public String getLongestAvailableArtistName() {
        return Utilities.isEmpty(this.longArtistName) ? this.shortArtistName : this.longArtistName;
    }

    public String getLongestAvailableProgramTitle() {
        return Utilities.isEmpty(this.longProgramTitle) ? this.shortProgramTitle : this.longProgramTitle;
    }
}

