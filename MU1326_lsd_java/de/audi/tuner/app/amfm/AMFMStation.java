/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.log.NullLogChannel;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.RadioTextPlus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.HdStationInfoExt;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;
import de.audi.tuner.ifc.ISimpleTuner;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.Station;

public class AMFMStation
extends Station
implements Serializable {
    private static final long serialVersionUID = -7519748479206899055L;
    private static final RadioTextPlus EMPTY_RADIOTEXTPLUS = new RadioTextPlus(new SimpleIntObjectMap(0), NullLogChannel.getInstance());
    private boolean tmpAdded;
    private boolean psFreezed;
    private int hdStructure;
    private int audioStatus;
    private int presetPos;
    private RadioTextPlus radioTextPlus = EMPTY_RADIOTEXTPLUS;
    private HdStationInfoExt hdInfo = ISimpleTuner.EMPTY_HDSTATIONINFO;
    private int databaseId;
    private HMIResourceLocator coverArt = ISimpleTuner.EMPTY_RL;
    private HMIResourceLocator dbStationLogo = ISimpleTuner.EMPTY_RL;

    public AMFMStation(Station station) {
        super(station.name, station.frequency, station.pi, station.receptionQuality, station.ptyCode, station.waveband, station.rds, station.tp, station.ta, station.tmc, station.scrollingPS, station.radioText, station.realPS, station.hd, station.shortNameHD, station.longNameHD, station.fullDigital, station.serviceId, station.subscription, station.eon, station.coChannel, station.stationArt);
        if (station.stationArt == null) {
            this.stationArt = new ResourceLocator(-1, "");
        }
        this.tmpAdded = false;
        this.psFreezed = false;
        this.audioStatus = 1;
    }

    public AMFMStation(Station station, int n) {
        super(station.name, station.frequency, station.pi, station.receptionQuality, station.ptyCode, station.waveband, station.rds, station.tp, station.ta, station.tmc, station.scrollingPS, station.radioText, station.realPS, station.hd, station.shortNameHD, station.longNameHD, station.fullDigital, station.serviceId, station.subscription, station.eon, station.coChannel, station.stationArt);
        if (station.stationArt == null) {
            this.stationArt = new ResourceLocator(-1, "");
        }
        this.tmpAdded = false;
        this.psFreezed = false;
        this.hdStructure = n;
        this.audioStatus = 1;
    }

    public AMFMStation(AMFMStation aMFMStation) {
        super(aMFMStation.name, aMFMStation.frequency, aMFMStation.pi, aMFMStation.receptionQuality, aMFMStation.ptyCode, aMFMStation.waveband, aMFMStation.rds, aMFMStation.tp, aMFMStation.ta, aMFMStation.tmc, aMFMStation.scrollingPS, aMFMStation.radioText, aMFMStation.realPS, aMFMStation.hd, aMFMStation.shortNameHD, aMFMStation.longNameHD, aMFMStation.fullDigital, aMFMStation.serviceId, aMFMStation.subscription, aMFMStation.eon, aMFMStation.coChannel, aMFMStation.stationArt);
        if (aMFMStation.stationArt == null) {
            this.stationArt = new ResourceLocator(-1, "");
        }
        this.tmpAdded = aMFMStation.tmpAdded;
        this.psFreezed = aMFMStation.psFreezed;
        this.hdStructure = aMFMStation.hdStructure;
        this.audioStatus = aMFMStation.audioStatus;
        this.presetPos = aMFMStation.presetPos;
        this.hdInfo = new HdStationInfoExt(aMFMStation.hdInfo);
        this.radioTextPlus = new RadioTextPlus(aMFMStation.radioTextPlus);
        this.coverArt = aMFMStation.coverArt;
        this.databaseId = aMFMStation.databaseId;
        this.dbStationLogo = aMFMStation.dbStationLogo == null ? ISimpleTuner.EMPTY_RL : aMFMStation.dbStationLogo;
    }

    public AMFMStation(String string, long l, int n, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, String string2, boolean bl7, String string3, String string4, boolean bl8, int n5) {
        super(string, l, n, n2, n3, n4, bl, bl2, bl3, bl4, bl5, bl6, string2, bl7, string3, string4, bl8, n5, 0, false, false, new ResourceLocator());
        this.tmpAdded = false;
        this.psFreezed = false;
        this.audioStatus = 1;
    }

    public AMFMStation(String string, long l, int n, int n2, int n3, boolean bl, boolean bl2) {
        this.name = string;
        this.frequency = l;
        this.pi = n;
        this.receptionQuality = 42;
        this.ptyCode = n2;
        this.waveband = n3;
        this.rds = bl;
        this.tp = false;
        this.ta = false;
        this.tmc = false;
        this.scrollingPS = bl2;
        this.radioText = false;
        this.realPS = "";
        this.hd = false;
        this.shortNameHD = "";
        this.longNameHD = "";
        this.fullDigital = false;
        this.serviceId = 0;
        this.tmpAdded = false;
        this.psFreezed = false;
        this.audioStatus = 1;
    }

    public AMFMStation() {
        this.tmpAdded = false;
        this.psFreezed = false;
        this.audioStatus = 1;
    }

    public int getDatabaseId() {
        return this.databaseId;
    }

    public void setDatabaseId(int n) {
        this.databaseId = n;
    }

    public boolean isTmpAdded() {
        return this.tmpAdded;
    }

    public void setTmpAdded(boolean bl) {
        this.tmpAdded = bl;
    }

    public void freezePs(String string) {
        this.name = string;
        this.psFreezed = true;
    }

    public void unfreezePs() {
        this.psFreezed = false;
    }

    public boolean isPsFreezed() {
        return this.psFreezed;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("AMFMStation(");
        buffer.append(this.name);
        buffer.append(';');
        buffer.append(String.valueOf(this.frequency));
        buffer.append(";0x");
        buffer.append(Integer.toHexString(this.pi));
        buffer.append(";pty");
        buffer.append(String.valueOf(this.ptyCode));
        buffer.append(";wb");
        buffer.append(String.valueOf(this.waveband));
        buffer.append(";rds=");
        buffer.append(String.valueOf(this.rds));
        buffer.append(";tp=");
        buffer.append(String.valueOf(this.tp));
        buffer.append(";scr=");
        buffer.append(String.valueOf(this.scrollingPS));
        buffer.append(";RT=");
        buffer.append(String.valueOf(this.radioText));
        buffer.append(";freezed=");
        buffer.append(String.valueOf(this.psFreezed));
        buffer.append(";HD=");
        buffer.append(String.valueOf(this.hd));
        buffer.append(";sID=");
        buffer.append(String.valueOf(this.serviceId));
        buffer.append(";HDShort=");
        buffer.append(this.shortNameHD);
        buffer.append(";HDLong=");
        buffer.append(this.longNameHD);
        buffer.append(";logo=");
        if (this.stationArt != null && this.stationArt.url != null) {
            buffer.append(this.stationArt.url);
        } else {
            buffer.append("null");
        }
        buffer.append(";tmpAdd=");
        buffer.append(String.valueOf(this.tmpAdded));
        buffer.append(";pP=");
        buffer.append(String.valueOf(this.presetPos));
        buffer.append(";audio=");
        buffer.append(String.valueOf(this.audioStatus));
        if (this.dbStationLogo != null && !Utilities.isEmpty(this.dbStationLogo.getResourceURI())) {
            buffer.append(";dbLogo=");
            buffer.append(this.dbStationLogo.getResourceURI());
        }
        buffer.append(')');
        return buffer.toString();
    }

    public String getHDNameAndExt() {
        Buffer buffer = new Buffer();
        buffer.append(this.getShortNameHD());
        if (this.waveband == 1) {
            buffer.append(' ');
            buffer.append(this.getHdExtension());
        }
        return buffer.toString();
    }

    public String getHDNameLongAndExt() {
        Buffer buffer = new Buffer();
        buffer.append(this.getLongNameHD());
        if (this.waveband == 1) {
            buffer.append(' ');
            buffer.append(this.getHdExtension());
        }
        return buffer.toString();
    }

    public String getHdExtension() {
        if (this.hd) {
            switch (this.serviceId) {
                case 1: {
                    return this.hdStructure > 1 ? "HD1" : "HD";
                }
                case 2: {
                    return "HD2";
                }
                case 4: {
                    return "HD3";
                }
                case 8: {
                    return "HD4";
                }
                case 16: {
                    return "HD5";
                }
                case 32: {
                    return "HD6";
                }
                case 64: {
                    return "HD7";
                }
                case 128: {
                    return "HD8";
                }
            }
        }
        return "";
    }

    public String getFullName() {
        if (this.isHd()) {
            return this.getHDNameAndExt();
        }
        return this.name;
    }

    public String getFullNameNoExtension() {
        if (this.isHd()) {
            return this.getShortNameHD();
        }
        return this.name;
    }

    public String getRawFrequencyString() {
        String string;
        if (this.waveband == 1) {
            long l = this.frequency / 1000L;
            long l2 = this.frequency % 1000L / 100L;
            string = new Buffer(10).append(l).append(".").append(l2).toString();
        } else {
            string = String.valueOf(this.frequency);
        }
        return string;
    }

    public String getFrequencyStringAndExt() {
        Buffer buffer = new Buffer(20);
        buffer.append(this.getFrequencyString());
        buffer.append(' ');
        buffer.append(this.getHdExtension());
        return buffer.toString();
    }

    public String getFrequencyString() {
        Buffer buffer = new Buffer();
        buffer.append(this.getRawFrequencyString());
        if (Utilities.isShowFreqUnit()) {
            buffer.append(" ").append(this.getFrequencyUnit());
        }
        return buffer.toString();
    }

    public String getFrequencyUnit() {
        if (this.waveband == 1) {
            return "MHz";
        }
        return "kHz";
    }

    public int getHdStructure() {
        return this.hdStructure;
    }

    public void setHdStructure(int n) {
        this.hdStructure = n;
    }

    public void validateHd() {
        if (this.hd) {
            this.hdStructure |= 1;
            this.hdStructure |= this.serviceId;
        } else {
            this.hdStructure = 0;
            this.serviceId = 1;
        }
    }

    public int getAudioStatus() {
        return this.audioStatus;
    }

    public void setAudioStatus(int n) {
        this.audioStatus = n;
    }

    public void setRadioTextPlus(RadioTextPlus radioTextPlus) {
        if (radioTextPlus == null) {
            this.radioTextPlus = EMPTY_RADIOTEXTPLUS;
            throw new IllegalArgumentException();
        }
        this.radioTextPlus = radioTextPlus;
    }

    public ArtistAndTitlePair getArtistAndTitlePair() {
        if (this.hd) {
            return new ArtistAndTitlePair(this.hdInfo.artistName, this.hdInfo.songTitle);
        }
        return this.radioTextPlus.getArtistAndTitlePair();
    }

    public String getAlbum() {
        if (this.hd) {
            return this.hdInfo.getAlbumTitle();
        }
        return this.radioTextPlus.getTag(new int[]{2});
    }

    public String getTag(int n) {
        return this.radioTextPlus.getTag(new int[]{n});
    }

    public RadioTextPlus getRtPlus() {
        return this.radioTextPlus;
    }

    public long getUniqueId() {
        return RadioObjectIds.getAmFmId(this.waveband, this.frequency, this.pi, this.serviceId, this.hd);
    }

    public int getPresetPos() {
        return this.presetPos;
    }

    public void setPresetPos(int n) {
        this.presetPos = n;
    }

    public void setStationLogo(HMIResourceLocator hMIResourceLocator) {
        this.stationArt = new ResourceLocator(hMIResourceLocator.getResourceID(), hMIResourceLocator.getResourceURI());
    }

    public void setCoverArt(HMIResourceLocator hMIResourceLocator) {
        this.coverArt = hMIResourceLocator;
    }

    public RadioHMIResourceLocator getCoverArt() {
        if (this.hdInfo.coverArt != null && !Utilities.isEmpty(this.hdInfo.coverArt.url)) {
            return new RadioHMIResourceLocator(this.hdInfo.coverArt.url, 1);
        }
        return new RadioHMIResourceLocator(this.coverArt, 1);
    }

    public RadioHMIResourceLocator getImage(int n) {
        RadioHMIResourceLocator radioHMIResourceLocator = this.stationArt != null && !Utilities.isEmpty(this.stationArt.url) ? new RadioHMIResourceLocator(this.stationArt.url, 0) : new RadioHMIResourceLocator(this.dbStationLogo, 0);
        return Utilities.getPreferredImage(n, null, this.getCoverArt(), radioHMIResourceLocator);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.name);
        objectOutputStream.writeLong(this.frequency);
        objectOutputStream.writeInt(this.pi);
        objectOutputStream.writeInt(this.waveband);
        objectOutputStream.writeBoolean(this.rds);
        objectOutputStream.writeInt(this.ptyCode);
        objectOutputStream.writeBoolean(this.isPsFreezed());
        boolean bl = this.isHd();
        objectOutputStream.writeBoolean(bl);
        if (bl) {
            objectOutputStream.writeInt(this.serviceId);
            objectOutputStream.writeUTF(this.longNameHD);
            objectOutputStream.writeUTF(this.shortNameHD);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.name = objectInputStream.readUTF();
        this.frequency = objectInputStream.readLong();
        this.pi = objectInputStream.readInt();
        this.waveband = objectInputStream.readInt();
        this.rds = objectInputStream.readBoolean();
        this.ptyCode = objectInputStream.readInt();
        boolean bl = objectInputStream.readBoolean();
        if (bl) {
            this.freezePs(this.name);
        }
        this.hd = objectInputStream.readBoolean();
        if (this.isHd()) {
            this.serviceId = objectInputStream.readInt();
            this.longNameHD = objectInputStream.readUTF();
            this.shortNameHD = objectInputStream.readUTF();
        }
        this.hdInfo = ISimpleTuner.EMPTY_HDSTATIONINFO;
        this.radioTextPlus = EMPTY_RADIOTEXTPLUS;
        this.coverArt = ISimpleTuner.EMPTY_RADIO_RL;
        this.dbStationLogo = ISimpleTuner.EMPTY_RL;
        this.stationArt = new ResourceLocator("");
    }

    public void resetProgramData() {
        this.radioTextPlus = EMPTY_RADIOTEXTPLUS;
        this.hdInfo = ISimpleTuner.EMPTY_HDSTATIONINFO;
        this.coverArt = ISimpleTuner.EMPTY_RADIO_RL;
        this.audioStatus = 1;
    }

    public HdStationInfoExt getHdInfo() {
        return this.hdInfo;
    }

    public void setHdInfo(HdStationInfoExt hdStationInfoExt) {
        this.hdInfo = (long)hdStationInfoExt.frequency == this.frequency && hdStationInfoExt.serviceId == this.serviceId ? hdStationInfoExt : ISimpleTuner.EMPTY_HDSTATIONINFO;
    }

    public int getProgramNr() {
        switch (this.serviceId) {
            case 2: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 8: {
                return 4;
            }
            case 16: {
                return 5;
            }
            case 32: {
                return 6;
            }
            case 64: {
                return 7;
            }
            case 128: {
                return 8;
            }
        }
        return 1;
    }

    public boolean isScroller() {
        return this.scrollingPS && !this.psFreezed;
    }

    public void setLogoFromDb(HMIResourceLocator hMIResourceLocator) {
        this.dbStationLogo = hMIResourceLocator == null ? ISimpleTuner.EMPTY_RL : hMIResourceLocator;
    }

    public boolean isFm() {
        return this.waveband == 1;
    }
}

