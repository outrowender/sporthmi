/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.log.NullLogChannel;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.RadioTextPlus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.IContainsDabStation;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;
import de.audi.tuner.app.storage.SerializingHelpers;
import de.audi.tuner.ifc.ISimpleTuner;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DabStation
implements Serializable,
IContainsDabStation {
    private static final long serialVersionUID = 7241439756220637715L;
    public static final int TYPE_ENSEMBLE = 1;
    public static final int TYPE_SERVICE = 2;
    public static final int TYPE_COMPONENT = 3;
    private static final RadioTextPlus EMPTY_RADIOTEXTPLUS = new RadioTextPlus(new SimpleIntObjectMap(0), NullLogChannel.getInstance());
    public EnsembleInfo ensemble;
    public ServiceInfo service;
    public ComponentInfo component;
    private int type;
    private boolean slideshowSupported;
    private RadioHMIResourceLocator slsImage = ISimpleTuner.EMPTY_RADIO_RL;
    private HMIResourceLocator stationLogo = ISimpleTuner.EMPTY_RL;
    private HMIResourceLocator dbStationLogo = ISimpleTuner.EMPTY_RL;
    private RadioHMIResourceLocator coverArt = ISimpleTuner.EMPTY_RADIO_RL;
    private RadioTextPlus radioTextPlus = EMPTY_RADIOTEXTPLUS;
    private int databaseId;
    private int presetPos;

    public DabStation(EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        this.ensemble = ensembleInfo;
        this.service = serviceInfo;
        this.component = componentInfo;
        this.type = serviceInfo.ensID == 0 && serviceInfo.ensECC == 0 && serviceInfo.sID == 0L ? 1 : (componentInfo.primaryService ? 2 : 3);
    }

    public DabStation(EnsembleInfo ensembleInfo, ServiceInfo serviceInfo) {
        this(ensembleInfo, serviceInfo, new ComponentInfo(serviceInfo.ensID, serviceInfo.ensECC, serviceInfo.sID, 0, "", "", true, false));
    }

    public DabStation(EnsembleInfo ensembleInfo) {
        this(ensembleInfo, new ServiceInfo(), new ComponentInfo());
    }

    public DabStation() {
        this(new EnsembleInfo(), new ServiceInfo(), new ComponentInfo());
    }

    public DabStation(DabStation dabStation) {
        this.ensemble = Utilities.copy(dabStation.ensemble);
        this.service = Utilities.copy(dabStation.service);
        this.component = Utilities.copy(dabStation.component);
        this.type = dabStation.type;
        this.slideshowSupported = dabStation.slideshowSupported;
        this.slsImage = dabStation.slsImage;
        this.stationLogo = dabStation.stationLogo;
        this.dbStationLogo = dabStation.dbStationLogo == null ? ISimpleTuner.EMPTY_RL : dabStation.dbStationLogo;
        this.coverArt = dabStation.coverArt;
        this.radioTextPlus = dabStation.radioTextPlus;
        this.databaseId = dabStation.databaseId;
    }

    public boolean isComponent() {
        return this.type == 3;
    }

    public boolean isService() {
        return this.type == 2;
    }

    public boolean isEnsemble() {
        return this.type == 1;
    }

    public int getDatabaseId() {
        return this.databaseId;
    }

    public void setDatabaseId(int n) {
        this.databaseId = n;
    }

    public int getPTY() {
        if (this.isService()) {
            return Utilities.getDABPty(this.service.ptyCodes);
        }
        return 0;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("DabStation: ");
        if (this.isEnsemble()) {
            buffer.append(this.ensemble);
        } else {
            buffer.append("Ens: \"").append(this.ensemble.fullName).append('/').append(this.ensemble.shortName).append("\" ");
            if (this.isService()) {
                buffer.append(this.service);
            } else {
                buffer.append(" Serv: \"").append(this.service.fullName).append('/').append(this.service.shortName).append("\" ");
                buffer.append(this.component);
            }
        }
        return buffer.toString();
    }

    public int getType() {
        return this.type;
    }

    public String getFullName() {
        switch (this.type) {
            case 1: {
                return this.ensemble.fullName;
            }
            case 2: {
                return this.service.fullName;
            }
            case 3: {
                return this.component.fullName;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getShortName() {
        switch (this.type) {
            case 1: {
                return this.ensemble.shortName;
            }
            case 2: {
                return this.service.shortName;
            }
            case 3: {
                return this.component.shortName;
            }
        }
        throw new IllegalArgumentException();
    }

    public HMIResourceLocator getSlsImage() {
        return this.slsImage;
    }

    public void setSlsImage(HMIResourceLocator hMIResourceLocator) {
        this.slsImage = new RadioHMIResourceLocator(hMIResourceLocator, 2);
    }

    public boolean isSlideshowSupported() {
        return this.slideshowSupported || this.slsImage.containsResourceURI();
    }

    public void setSlideshowSupported(boolean bl) {
        this.slideshowSupported = bl;
    }

    public HMIResourceLocator getStationLogo() {
        return Utilities.isEmpty(this.stationLogo.getResourceURI()) ? this.dbStationLogo : this.stationLogo;
    }

    public HMIResourceLocator getEpgImage() {
        return this.stationLogo;
    }

    public void setStationLogo(HMIResourceLocator hMIResourceLocator) {
        this.stationLogo = hMIResourceLocator == ISimpleTuner.EMPTY_RL ? ISimpleTuner.EMPTY_RADIO_RL : new RadioHMIResourceLocator(hMIResourceLocator, 0);
    }

    public void setLogoFromDb(HMIResourceLocator hMIResourceLocator) {
        this.dbStationLogo = hMIResourceLocator == null ? ISimpleTuner.EMPTY_RL : hMIResourceLocator;
    }

    public void setCoverArt(HMIResourceLocator hMIResourceLocator) {
        this.coverArt = new RadioHMIResourceLocator(hMIResourceLocator, 1);
    }

    public HMIResourceLocator getCoverArt() {
        return this.coverArt;
    }

    public RadioHMIResourceLocator getImage(int n) {
        return Utilities.getPreferredImage(n, this.slsImage, this.coverArt, new RadioHMIResourceLocator(this.getStationLogo(), 0));
    }

    public void setRadioTextPlus(RadioTextPlus radioTextPlus) {
        this.radioTextPlus = radioTextPlus;
    }

    public ArtistAndTitlePair getArtistAndTitlePair() {
        return this.radioTextPlus.getArtistAndTitlePair();
    }

    public String getAlbum() {
        return this.radioTextPlus.getTag(new int[]{2});
    }

    public String getTag(int n) {
        return this.radioTextPlus.getTag(new int[]{n});
    }

    public long getUniqueId() {
        return RadioObjectIds.getDabId(this.ensemble.ensID, this.ensemble.ensECC, this.service.sID, this.component.sCIDI, this.component.primaryService);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.type);
        objectOutputStream.writeUTF(this.ensemble.fullName);
        objectOutputStream.writeUTF(this.ensemble.shortName);
        objectOutputStream.writeInt(this.ensemble.getFrequencyValue());
        objectOutputStream.writeInt(this.ensemble.ensID);
        objectOutputStream.writeInt(this.ensemble.ensECC);
        if (this.type != 1) {
            objectOutputStream.writeUTF(this.service.fullName);
            objectOutputStream.writeUTF(this.service.shortName);
            objectOutputStream.writeLong(this.service.sID);
            SerializingHelpers.serializeByteArray(this.service.ptyCodes, objectOutputStream);
            objectOutputStream.writeUTF(this.component.fullName);
            objectOutputStream.writeUTF(this.component.shortName);
            objectOutputStream.writeInt(this.component.sCIDI);
            objectOutputStream.writeBoolean(this.component.primaryService);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.slsImage = ISimpleTuner.EMPTY_RADIO_RL;
        this.stationLogo = ISimpleTuner.EMPTY_RL;
        this.dbStationLogo = ISimpleTuner.EMPTY_RL;
        this.coverArt = ISimpleTuner.EMPTY_RADIO_RL;
        this.radioTextPlus = EMPTY_RADIOTEXTPLUS;
        this.type = objectInputStream.readInt();
        this.ensemble = new EnsembleInfo();
        this.service = new ServiceInfo();
        this.component = new ComponentInfo();
        this.ensemble.fullName = objectInputStream.readUTF();
        this.ensemble.shortName = objectInputStream.readUTF();
        this.ensemble.frequencyValue = objectInputStream.readInt();
        this.ensemble.ensID = objectInputStream.readInt();
        this.ensemble.ensECC = objectInputStream.readInt();
        if (this.type != 1) {
            this.service.fullName = objectInputStream.readUTF();
            this.service.shortName = objectInputStream.readUTF();
            this.service.sID = objectInputStream.readLong();
            this.service.ptyCodes = SerializingHelpers.deserializeByteArray(objectInputStream);
            this.service.ensID = this.ensemble.ensID;
            this.service.ensECC = this.ensemble.ensECC;
            this.component.fullName = objectInputStream.readUTF();
            this.component.shortName = objectInputStream.readUTF();
            this.component.sCIDI = objectInputStream.readInt();
            this.component.primaryService = objectInputStream.readBoolean();
            this.component.ensID = this.ensemble.ensID;
            this.component.ensECC = this.ensemble.ensECC;
            this.component.sID = this.service.sID;
        }
    }

    public RadioTextPlus getRtPlus() {
        return this.radioTextPlus;
    }

    public int getPresetPos() {
        return this.presetPos;
    }

    public void setPresetPos(int n) {
        this.presetPos = n;
    }

    public void resetProgramData() {
        this.radioTextPlus = EMPTY_RADIOTEXTPLUS;
        this.slsImage = ISimpleTuner.EMPTY_RADIO_RL;
        this.coverArt = ISimpleTuner.EMPTY_RADIO_RL;
    }

    public DabStation getService() {
        return new DabStation(this.ensemble, this.service);
    }

    public DabStation getDabStation() {
        return this;
    }
}

