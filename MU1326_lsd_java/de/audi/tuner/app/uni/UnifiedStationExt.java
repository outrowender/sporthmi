/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.log.NullLogChannel;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.RadioTextPlus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;
import de.audi.tuner.ifc.ISimpleTuner;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.UnifiedStation;

public class UnifiedStationExt
extends UnifiedStation
implements Serializable {
    private static final long serialVersionUID = -2043280983901947269L;
    public static final int UNI_FALLBACK_VERSION = 1;
    public static final int UNI_VERSION = 2;
    private static final RadioTextPlus EMPTY_RADIOTEXTPLUS = new RadioTextPlus(new SimpleIntObjectMap(0), NullLogChannel.getInstance());
    private int audioStatus;
    private RadioTextPlus rTextPlus = EMPTY_RADIOTEXTPLUS;
    private RadioHMIResourceLocator slsImage = ISimpleTuner.EMPTY_RADIO_RL;
    private RadioHMIResourceLocator coverArt = ISimpleTuner.EMPTY_RADIO_RL;
    private HMIResourceLocator dbStationLogo = ISimpleTuner.EMPTY_RL;
    private boolean psFreezed;
    private int databaseId;
    private UnifiedStationExt primaryService = null;

    public UnifiedStationExt(UnifiedStation unifiedStation) {
        super(unifiedStation.shortName, unifiedStation.longName, unifiedStation.frequency, unifiedStation.piSId, unifiedStation.ensId, unifiedStation.ecc, unifiedStation.sCIDI, unifiedStation.scrollingPS, unifiedStation.rds, unifiedStation.audioQuality, unifiedStation.tpAvailability, unifiedStation.ptyCodes, unifiedStation.radioText, unifiedStation.radioTextPlus, unifiedStation.enhancedRadioText, unifiedStation.slideshow, unifiedStation.stationLogo, unifiedStation.coChannel);
        this.audioStatus = this.ensId == 0 ? 1 : 2;
    }

    public UnifiedStationExt(UnifiedStationExt unifiedStationExt) {
        super(unifiedStationExt.shortName, unifiedStationExt.longName, unifiedStationExt.frequency, unifiedStationExt.piSId, unifiedStationExt.ensId, unifiedStationExt.ecc, unifiedStationExt.sCIDI, unifiedStationExt.scrollingPS, unifiedStationExt.rds, unifiedStationExt.audioQuality, unifiedStationExt.tpAvailability, unifiedStationExt.ptyCodes, unifiedStationExt.radioText, unifiedStationExt.radioTextPlus, unifiedStationExt.enhancedRadioText, unifiedStationExt.slideshow, unifiedStationExt.stationLogo, unifiedStationExt.coChannel);
        this.audioStatus = unifiedStationExt.audioStatus;
        this.rTextPlus = unifiedStationExt.rTextPlus;
        this.psFreezed = unifiedStationExt.psFreezed;
        this.databaseId = unifiedStationExt.databaseId;
        this.dbStationLogo = unifiedStationExt.dbStationLogo == null ? ISimpleTuner.EMPTY_RL : unifiedStationExt.dbStationLogo;
        this.primaryService = unifiedStationExt.primaryService;
    }

    public UnifiedStationExt() {
    }

    public void setPrimaryService(UnifiedStationExt unifiedStationExt) {
        if (unifiedStationExt.sCIDI == 0) {
            this.primaryService = unifiedStationExt;
        }
    }

    public void setPrimaryService(UnifiedStation unifiedStation) {
        this.setPrimaryService(new UnifiedStationExt(unifiedStation));
    }

    public UnifiedStationExt getPrimaryService() {
        return this.primaryService != null ? this.primaryService : null;
    }

    public boolean hasPrimaryService() {
        return this.primaryService != null;
    }

    public int getAudioStatus() {
        return this.audioStatus;
    }

    public void setAudioStatus(int n) {
        this.audioStatus = n;
    }

    public long getUniqueId() {
        return RadioObjectIds.getUniId(this.frequency, this.piSId, this.ensId, this.ecc, this.sCIDI);
    }

    public int getDatabaseId() {
        return this.databaseId;
    }

    public void setDatabaseId(int n) {
        this.databaseId = n;
    }

    public String getName(boolean bl) {
        if (bl && !Utilities.isEmpty(this.longName)) {
            return this.longName;
        }
        if (!Utilities.isEmpty(this.shortName)) {
            return this.shortName;
        }
        return Utilities.kHzToMHz(this.frequency) + " MHz";
    }

    public void setRadioTextPlus(RadioTextPlus radioTextPlus) {
        this.rTextPlus = radioTextPlus;
    }

    public ArtistAndTitlePair getArtistAndTitlePair() {
        return this.rTextPlus.getArtistAndTitlePair();
    }

    public String getTag(int n) {
        return this.rTextPlus.getTag(new int[]{n});
    }

    public void setCoverArt(HMIResourceLocator hMIResourceLocator) {
        this.coverArt = new RadioHMIResourceLocator(hMIResourceLocator, 1);
    }

    public HMIResourceLocator getCoverArt() {
        return this.coverArt;
    }

    public void setSlsImage(HMIResourceLocator hMIResourceLocator) {
        this.slsImage = new RadioHMIResourceLocator(hMIResourceLocator, 2);
    }

    public HMIResourceLocator getSlsImage() {
        return this.slsImage;
    }

    public RadioHMIResourceLocator getImage(int n) {
        RadioHMIResourceLocator radioHMIResourceLocator = null;
        radioHMIResourceLocator = this.stationLogo != null && !Utilities.isEmpty(this.stationLogo.url) ? new RadioHMIResourceLocator(this.stationLogo.url, 0) : new RadioHMIResourceLocator(this.dbStationLogo, 0);
        return Utilities.getPreferredImage(n, this.slsImage, this.coverArt, radioHMIResourceLocator);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.longName);
        objectOutputStream.writeUTF(this.shortName);
        objectOutputStream.writeLong(this.frequency);
        objectOutputStream.writeInt(this.piSId);
        objectOutputStream.writeInt(this.ensId);
        objectOutputStream.writeInt(this.ecc);
        objectOutputStream.writeInt(this.sCIDI);
        objectOutputStream.writeInt(this.scrollingPS);
        objectOutputStream.writeBoolean(this.rds);
        objectOutputStream.writeBoolean(this.radioText);
        objectOutputStream.writeBoolean(this.radioTextPlus);
        objectOutputStream.writeBoolean(this.enhancedRadioText);
        objectOutputStream.writeBoolean(this.slideshow);
        if (this.stationLogo != null) {
            objectOutputStream.writeUTF(this.stationLogo.url);
            objectOutputStream.writeInt(this.stationLogo.id);
        } else {
            objectOutputStream.writeUTF("");
            objectOutputStream.writeInt(-1);
        }
        objectOutputStream.writeInt(2);
        boolean bl = this.hasPrimaryService();
        objectOutputStream.writeBoolean(bl);
        if (bl && this.sCIDI > 0) {
            UnifiedStationExt unifiedStationExt = this.getPrimaryService();
            objectOutputStream.writeObject(unifiedStationExt);
        }
    }

    private int readVersionFromInputStream(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Integer n = null;
        try {
            n = new Integer(objectInputStream.readInt());
        }
        catch (EOFException eOFException) {
            Logger logger = new Logger(Utilities.getFramework());
            logger.uniDSI.log(100000, "[UnifiedStationExt.readVersionFromInputStream] old serialized data of station %1", (Object)this.toString());
        }
        return n != null ? n : 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        boolean bl;
        this.longName = objectInputStream.readUTF();
        this.shortName = objectInputStream.readUTF();
        this.frequency = objectInputStream.readLong();
        this.piSId = objectInputStream.readInt();
        this.ensId = objectInputStream.readInt();
        this.ecc = objectInputStream.readInt();
        this.sCIDI = objectInputStream.readInt();
        this.scrollingPS = objectInputStream.readInt();
        this.rds = objectInputStream.readBoolean();
        this.radioText = objectInputStream.readBoolean();
        this.radioTextPlus = objectInputStream.readBoolean();
        this.enhancedRadioText = objectInputStream.readBoolean();
        this.slideshow = objectInputStream.readBoolean();
        this.dbStationLogo = ISimpleTuner.EMPTY_RL;
        ResourceLocator resourceLocator = new ResourceLocator();
        resourceLocator.url = objectInputStream.readUTF();
        resourceLocator.id = objectInputStream.readInt();
        this.ptyCodes = new byte[0];
        this.rTextPlus = EMPTY_RADIOTEXTPLUS;
        this.slsImage = ISimpleTuner.EMPTY_RADIO_RL;
        this.coverArt = ISimpleTuner.EMPTY_RADIO_RL;
        if (this.readVersionFromInputStream(objectInputStream) > 1 && (bl = objectInputStream.readBoolean()) && this.sCIDI > 0) {
            this.primaryService = (UnifiedStationExt)objectInputStream.readObject();
            this.setPrimaryService(this.primaryService);
        }
    }

    public boolean isScroller() {
        return this.scrollingPS == 2 && !this.psFreezed;
    }

    public boolean isAnalog() {
        return this.ensId == 0;
    }

    public void freezePs(String string) {
        this.shortName = string;
        this.psFreezed = true;
    }

    public void unfreezePs() {
        this.psFreezed = false;
    }

    public boolean isPsFreezed() {
        return this.psFreezed;
    }

    public boolean isComponent() {
        return this.sCIDI != 0;
    }

    public AMFMStation getFmStation() {
        AMFMStation aMFMStation = new AMFMStation();
        aMFMStation.name = this.shortName;
        aMFMStation.frequency = this.frequency;
        aMFMStation.pi = this.piSId;
        aMFMStation.rds = this.rds;
        aMFMStation.waveband = 1;
        if (this.psFreezed) {
            aMFMStation.freezePs(this.shortName);
        }
        return aMFMStation;
    }

    public int getPty() {
        return Utilities.getDABPty(this.ptyCodes);
    }

    public RadioTextPlus getRtPlus() {
        return this.rTextPlus;
    }

    public void resetProgramData() {
        this.rTextPlus = EMPTY_RADIOTEXTPLUS;
        this.slsImage = ISimpleTuner.EMPTY_RADIO_RL;
        this.coverArt = ISimpleTuner.EMPTY_RADIO_RL;
    }

    public boolean isFM() {
        return this.ensId == 0;
    }

    public String toString() {
        int n;
        Buffer buffer = new Buffer(1900);
        buffer.append("UniStationExt(shortName=\"");
        buffer.append(this.shortName);
        buffer.append("\";longName=\"");
        buffer.append(this.longName);
        buffer.append("\";f=");
        buffer.append(this.frequency);
        buffer.append(";piSId=");
        buffer.append(this.piSId);
        buffer.append(";ensId=");
        buffer.append(this.ensId);
        buffer.append(";ecc=");
        buffer.append(this.ecc);
        buffer.append(";sCIDI=");
        buffer.append(this.sCIDI);
        buffer.append(";scrollingPS=");
        buffer.append(this.scrollingPS == 2);
        buffer.append(";rds=");
        buffer.append(this.rds);
        buffer.append(";audioQuality=");
        buffer.append(this.audioQuality);
        buffer.append(";pty[");
        if (this.ptyCodes != null) {
            buffer.append(this.ptyCodes.length);
        }
        buffer.append("]={");
        if (this.ptyCodes != null) {
            n = this.ptyCodes.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                buffer.append(this.ptyCodes[i2]);
                if (i2 >= n2) continue;
                buffer.append(';');
            }
        } else {
            buffer.append(this.ptyCodes);
        }
        buffer.append('}');
        buffer.append(";sls=");
        buffer.append(this.slideshow);
        buffer.append(";logo=");
        buffer.append(this.stationLogo);
        buffer.append(";coChannel=");
        buffer.append(this.coChannel);
        buffer.append(";psFreezed=");
        buffer.append(this.psFreezed);
        buffer.append(";audiostatus=");
        buffer.append(this.audioStatus);
        n = this.hasPrimaryService() ? 1 : 0;
        buffer.append("; hasPrimaryService=");
        buffer.append(n != 0);
        if (n != 0) {
            buffer.append("; (PRIMARY SERVICE=");
            buffer.append(this.primaryService.toString());
        }
        buffer.append("))");
        return buffer.toString();
    }

    public void setLogoFromDb(HMIResourceLocator hMIResourceLocator) {
        this.dbStationLogo = hMIResourceLocator == null ? ISimpleTuner.EMPTY_RL : hMIResourceLocator;
    }

    public static boolean equals(UnifiedStationExt unifiedStationExt, UnifiedStationExt unifiedStationExt2) {
        if (unifiedStationExt == null || unifiedStationExt2 == null) {
            return false;
        }
        if (unifiedStationExt.rds && unifiedStationExt.piSId > 0 && unifiedStationExt2.rds && unifiedStationExt2.piSId > 0) {
            return unifiedStationExt.piSId == unifiedStationExt2.piSId || unifiedStationExt.frequency == unifiedStationExt2.frequency;
        }
        if ((unifiedStationExt.rds && unifiedStationExt.piSId > 0 || unifiedStationExt.ensId != 0) && (unifiedStationExt2.rds && unifiedStationExt2.piSId > 0 || unifiedStationExt2.ensId != 0)) {
            return unifiedStationExt.piSId == unifiedStationExt2.piSId && unifiedStationExt.sCIDI == unifiedStationExt2.sCIDI;
        }
        return unifiedStationExt.frequency == unifiedStationExt2.frequency;
    }
}

