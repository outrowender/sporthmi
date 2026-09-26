/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.Utilities;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.radio.HdStationInfo;

public class HdStationInfoExt
extends HdStationInfo {
    private int taggingStatus = 0;

    public HdStationInfoExt(HdStationInfo hdStationInfo) {
        this.frequency = hdStationInfo.frequency;
        this.pi = hdStationInfo.pi;
        this.serviceId = hdStationInfo.serviceId;
        this.artistName = hdStationInfo.artistName;
        this.albumTitle = hdStationInfo.albumTitle;
        this.songTitle = hdStationInfo.songTitle;
        this.genre = hdStationInfo.genre;
        this.stationArt = hdStationInfo.stationArt;
        this.coverArt = hdStationInfo.coverArt;
        this.language = hdStationInfo.language;
        this.shortDescription = hdStationInfo.shortDescription;
        this.contentField = hdStationInfo.contentField;
        this.price = hdStationInfo.price;
        this.validUntil = hdStationInfo.validUntil;
        this.contactURL = hdStationInfo.contactURL;
        this.receivedAs = hdStationInfo.receivedAs;
        this.nameOfSeller = hdStationInfo.nameOfSeller;
        this.comrDescription = hdStationInfo.comrDescription;
        this.mimeType = hdStationInfo.mimeType;
        this.binaryData = hdStationInfo.binaryData;
        this.affiliateID = hdStationInfo.affiliateID;
        this.iTunesID = hdStationInfo.iTunesID;
        this.iTunesFrontID = hdStationInfo.iTunesFrontID;
        this.podcastFeedURL = hdStationInfo.podcastFeedURL;
        this.unknownData = hdStationInfo.unknownData;
        this.stationURL = hdStationInfo.stationURL;
    }

    public HdStationInfoExt(HdStationInfoExt hdStationInfoExt) {
        this((HdStationInfo)hdStationInfoExt);
        this.taggingStatus = hdStationInfoExt.taggingStatus;
    }

    public int getTaggingStatus() {
        return this.taggingStatus;
    }

    public void setTaggingStatus(int n) {
        this.taggingStatus = n;
    }

    public boolean isAlreadyTaggedForITunes() {
        return this.taggingStatus == 3;
    }

    public boolean artistAndTitleInformationAvailable() {
        return !Utilities.isEmpty(this.artistName) && !Utilities.isEmpty(this.songTitle);
    }

    public String constructSimulatedRadioText() {
        String[] stringArray = this.getStringItemForSimulatedRadioText();
        Buffer buffer = new Buffer(100);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (Utilities.isEmpty(stringArray[i2])) continue;
            buffer.append(stringArray[i2].trim()).append('\n');
        }
        return buffer.toString();
    }

    public boolean hasSufficientDataForSimulatedRadioText() {
        String[] stringArray = this.getStringItemForSimulatedRadioText();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (Utilities.isEmpty(stringArray[i2])) continue;
            return true;
        }
        return false;
    }

    private String[] getStringItemForSimulatedRadioText() {
        return new String[]{this.artistName, this.songTitle, this.albumTitle, this.shortDescription};
    }
}

