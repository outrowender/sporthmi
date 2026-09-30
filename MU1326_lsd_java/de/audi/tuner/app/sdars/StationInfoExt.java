/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.ifc.ISimpleTuner;
import de.esolutions.fw.util.commons.Buffer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.StationInfo;

public class StationInfoExt
extends StationInfo
implements Serializable {
    private static final long serialVersionUID = -4354368266343016400L;
    private RadioHMIResourceLocator stationArt = ISimpleTuner.EMPTY_RADIO_RL;
    private CategoryInfoExt category = CategoryInfoExt.EMPTY_CATEGORY;
    private int presetPos;
    private boolean audioOk = true;
    private SdarsRadioText pdt = SdarsRadioText.EMPTY_RADIOTEXT;

    public StationInfoExt() {
    }

    public StationInfoExt(StationInfo stationInfo) {
        super(stationInfo.stationNumber, stationInfo.sID, stationInfo.shortLabel, stationInfo.fullLabel, stationInfo.subscription, stationInfo.categoryNumber, stationInfo.mature, stationInfo.channelArt);
    }

    public StationInfoExt(StationInfoExt stationInfoExt) {
        super(stationInfoExt.stationNumber, stationInfoExt.sID, stationInfoExt.shortLabel, stationInfoExt.fullLabel, stationInfoExt.subscription, stationInfoExt.categoryNumber, stationInfoExt.mature, stationInfoExt.channelArt);
        this.stationArt = stationInfoExt.stationArt;
        this.category = stationInfoExt.category;
        this.presetPos = stationInfoExt.presetPos;
        this.audioOk = stationInfoExt.audioOk;
    }

    public RadioHMIResourceLocator getStationArt() {
        return this.stationArt;
    }

    public void setStationArt(HMIResourceLocator hMIResourceLocator) {
        this.stationArt = new RadioHMIResourceLocator(hMIResourceLocator, 0);
    }

    public String getShortCategory() {
        return this.category.shortLabel;
    }

    public String getFullCategory() {
        return this.category.fullLabel;
    }

    public void setCategory(CategoryInfoExt categoryInfoExt) {
        this.category = categoryInfoExt;
    }

    public int getPresetPos() {
        return this.presetPos;
    }

    public void setPresetPos(int n) {
        this.presetPos = n;
    }

    public boolean isAudioOk() {
        return this.audioOk;
    }

    public boolean isGraceNoteRequest() {
        return this.category.isGracenoteRequest;
    }

    public void setAudioOk(boolean bl) {
        this.audioOk = bl;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(this.stationNumber);
        objectOutputStream.writeInt(this.sID);
        objectOutputStream.writeUTF(this.shortLabel);
        objectOutputStream.writeUTF(this.fullLabel);
        objectOutputStream.writeInt(this.subscription);
        objectOutputStream.writeShort(this.categoryNumber);
        objectOutputStream.writeBoolean(this.mature);
        objectOutputStream.writeUTF(this.stationArt.getResourceURI());
        objectOutputStream.writeInt(this.stationArt.getResourceID());
        objectOutputStream.writeUTF(this.category.shortLabel);
        objectOutputStream.writeUTF(this.category.fullLabel);
        objectOutputStream.writeBoolean(this.category.isGracenoteRequest);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.audioOk = true;
        this.pdt = SdarsRadioText.EMPTY_RADIOTEXT;
        this.stationNumber = objectInputStream.readShort();
        this.sID = objectInputStream.readInt();
        this.shortLabel = objectInputStream.readUTF();
        this.fullLabel = objectInputStream.readUTF();
        this.subscription = objectInputStream.readInt();
        this.categoryNumber = objectInputStream.readShort();
        this.mature = objectInputStream.readBoolean();
        this.channelArt = new ResourceLocator();
        String string = objectInputStream.readUTF();
        int n = objectInputStream.readInt();
        this.stationArt = new RadioHMIResourceLocator(new HMIResourceLocator(n, string), 0);
        String string2 = objectInputStream.readUTF();
        String string3 = objectInputStream.readUTF();
        boolean bl = objectInputStream.readBoolean();
        this.category = new CategoryInfoExt(this.categoryNumber, string2, string3, bl);
    }

    public void setRadioText(SdarsRadioText sdarsRadioText) {
        this.pdt = sdarsRadioText != null && sdarsRadioText.sID == this.sID ? sdarsRadioText : SdarsRadioText.EMPTY_RADIOTEXT;
    }

    public HMIResourceLocator getImage(int n) {
        return Utilities.getPreferredImage(n, null, this.pdt.getCoverArt(), this.stationArt);
    }

    public ArtistAndTitlePair getArtistAndTitlePair() {
        return new ArtistAndTitlePair(this.pdt.getLongestAvailableArtistName(), this.pdt.getLongestAvailableProgramTitle());
    }

    public String toString() {
        Buffer buffer = new Buffer(200);
        buffer.append("StationInfoExt");
        buffer.append('(');
        buffer.append("number");
        buffer.append('=');
        buffer.append(this.stationNumber);
        buffer.append(',');
        buffer.append("sID");
        buffer.append('=');
        buffer.append(this.sID);
        buffer.append(',');
        buffer.append("short");
        buffer.append('=');
        buffer.append('\"');
        buffer.append(this.shortLabel);
        buffer.append('\"');
        buffer.append(',');
        buffer.append("full");
        buffer.append('=');
        buffer.append('\"');
        buffer.append(this.fullLabel);
        buffer.append('\"');
        buffer.append(',');
        buffer.append("subscr.");
        buffer.append('=');
        buffer.append(this.subscription);
        buffer.append(',');
        buffer.append("cat");
        buffer.append('=');
        buffer.append(this.category.shortLabel);
        buffer.append(',');
        buffer.append("mature");
        buffer.append('=');
        buffer.append(this.mature);
        buffer.append(',');
        buffer.append("channelArt");
        buffer.append('=');
        buffer.append(this.stationArt);
        buffer.append(",PP");
        buffer.append('=');
        buffer.append(this.presetPos);
        buffer.append(')');
        return buffer.toString();
    }

    public long getUniqueId() {
        return RadioObjectIds.getSDARSObjectId(this.sID);
    }
}

