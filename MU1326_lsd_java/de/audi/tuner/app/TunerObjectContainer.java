/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.interapp.tv.TVStation;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.ISimpleTuner;
import de.esolutions.fw.util.commons.Buffer;
import java.io.Serializable;
import org.dsi.ifc.global.ResourceLocator;

public class TunerObjectContainer
implements Serializable {
    private static final long serialVersionUID = 5327078046367180179L;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_AMFM_SERVICE = 3;
    public static final int TYPE_SDARS_SERVICE = 5;
    public static final int TYPE_DAB_STATION = 6;
    public static final int TYPE_UNI_STATION = 7;
    public static final int TYPE_TV_STATION = 8;
    public static final TunerObjectContainer EMPTY_CONTAINER = new TunerObjectContainer();
    private final int type;
    private final Object data;
    private long listId = 0L;
    private boolean enabled = true;
    private int memoryIndex = 0;
    private int receptionStatus;

    public TunerObjectContainer(TunerObjectContainer tunerObjectContainer) {
        this.type = tunerObjectContainer.type;
        switch (this.type) {
            case 3: {
                this.data = new AMFMStation((AMFMStation)tunerObjectContainer.data);
                break;
            }
            case 6: {
                this.data = new DabStation((DabStation)tunerObjectContainer.data);
                break;
            }
            case 7: {
                this.data = new UnifiedStationExt((UnifiedStationExt)tunerObjectContainer.data);
                break;
            }
            case 5: 
            case 8: {
                this.data = tunerObjectContainer.data;
                break;
            }
            default: {
                this.data = null;
            }
        }
        this.listId = tunerObjectContainer.listId;
        this.enabled = tunerObjectContainer.enabled;
        this.memoryIndex = tunerObjectContainer.memoryIndex;
        this.receptionStatus = tunerObjectContainer.receptionStatus;
    }

    public TunerObjectContainer(int n, Object object) {
        this.type = n;
        this.data = object;
    }

    TunerObjectContainer(StationInfoExt stationInfoExt, boolean bl) {
        this.type = 5;
        this.data = stationInfoExt;
        this.enabled = bl;
    }

    public TunerObjectContainer(Object object) {
        if (object instanceof AMFMStation) {
            this.type = 3;
        } else if (object instanceof StationInfoExt) {
            this.type = 5;
        } else if (object instanceof DabStation) {
            this.type = 6;
        } else if (object instanceof UnifiedStationExt) {
            this.type = 7;
        } else if (object instanceof TVStation) {
            this.type = 8;
        } else {
            throw new IllegalArgumentException("Unknown parameter: " + object);
        }
        this.data = object;
    }

    private TunerObjectContainer() {
        this.type = -1;
        this.data = null;
    }

    public DabStation getDABStation() {
        return (DabStation)this.data;
    }

    public UnifiedStationExt getUniStation() {
        return (UnifiedStationExt)this.data;
    }

    public AMFMStation getAMFMService() {
        return (AMFMStation)this.data;
    }

    public StationInfoExt getSDARSService() {
        return (StationInfoExt)this.data;
    }

    public TVStation getTVStation() {
        return (TVStation)this.data;
    }

    public int getType() {
        return this.type;
    }

    public int getBand() {
        switch (this.type) {
            case 3: {
                AMFMStation aMFMStation = this.getAMFMService();
                if (aMFMStation != null && aMFMStation.getWaveband() != 1) {
                    return 4;
                }
                return 1;
            }
            case 6: {
                return 5;
            }
            case 5: {
                return 7;
            }
            case 7: {
                return 11;
            }
            case 8: {
                return 15;
            }
            case -1: {
                return 8;
            }
        }
        throw new IllegalArgumentException("Can't match type " + this.getType() + " to component ID!");
    }

    public boolean equals(Object object) {
        TunerObjectContainer tunerObjectContainer;
        try {
            tunerObjectContainer = (TunerObjectContainer)object;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        return RadioComparators.equals(this, tunerObjectContainer);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.data == null ? 0 : this.data.hashCode());
        n = 31 * n + this.getType();
        return n;
    }

    public String toString() {
        Buffer buffer = new Buffer(200);
        buffer.append("type:").append(this.type).append(' ').append(this.data);
        buffer.append(" listID:").append(this.listId).append(" ena:").append(this.enabled);
        return buffer.toString();
    }

    public boolean containsAMFMService() {
        return this.data instanceof AMFMStation;
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setListID(int n) {
        this.listId = n;
    }

    public long getListID() {
        if (this.listId != 0L) {
            return this.listId;
        }
        return this.getRadioId();
    }

    public long getRadioId() {
        switch (this.type) {
            case 3: {
                return ((AMFMStation)this.data).getUniqueId();
            }
            case 6: {
                return ((DabStation)this.data).getUniqueId();
            }
            case 7: {
                return ((UnifiedStationExt)this.data).getUniqueId();
            }
            case 5: {
                return RadioObjectIds.getSDARSObjectId(((StationInfoExt)this.data).sID);
            }
        }
        throw new IllegalArgumentException();
    }

    public String getStationName(boolean bl) {
        return this.getStationName(bl, true);
    }

    public String getStationName(boolean bl, boolean bl2) {
        switch (this.type) {
            case 3: {
                AMFMStation aMFMStation = (AMFMStation)this.data;
                String string = aMFMStation.getFullName();
                return Utilities.isEmpty(string) && bl2 ? aMFMStation.getFrequencyString() : string;
            }
            case 6: {
                return bl ? ((DabStation)this.data).getFullName() : ((DabStation)this.data).getShortName();
            }
            case 7: {
                return ((UnifiedStationExt)this.data).getName(bl);
            }
            case 5: {
                return bl ? ((StationInfoExt)this.data).getFullLabel() : ((StationInfoExt)this.data).getShortLabel();
            }
        }
        throw new IllegalArgumentException();
    }

    public int getFrequency() {
        switch (this.type) {
            case 3: {
                return (int)((AMFMStation)this.data).frequency;
            }
            case 6: {
                return ((DabStation)this.data).ensemble.frequencyValue;
            }
            case 7: {
                return (int)((UnifiedStationExt)this.data).frequency;
            }
            case 5: {
                return ((StationInfoExt)this.data).stationNumber;
            }
        }
        throw new IllegalArgumentException();
    }

    public void setReceptionStatus(int n) {
        this.receptionStatus = n;
    }

    public int getReceptionStatus() {
        switch (this.type) {
            case 6: {
                return this.receptionStatus;
            }
            case 7: {
                return ((UnifiedStationExt)this.data).getAudioStatus() == 3 ? 2 : 0;
            }
        }
        return 0;
    }

    public void setPresetPos(int n) {
        switch (this.type) {
            case 3: {
                ((AMFMStation)this.data).setPresetPos(n);
                break;
            }
            case 6: {
                ((DabStation)this.data).setPresetPos(n);
                break;
            }
            case 5: {
                ((StationInfoExt)this.data).setPresetPos(n);
                break;
            }
            case 7: 
            case 8: {
                this.memoryIndex = n;
                break;
            }
        }
    }

    public int getPresetPos() {
        switch (this.type) {
            case 3: {
                return ((AMFMStation)this.data).getPresetPos();
            }
            case 6: {
                return ((DabStation)this.data).getPresetPos();
            }
            case 5: {
                return ((StationInfoExt)this.data).getPresetPos();
            }
            case 7: 
            case 8: {
                return this.memoryIndex;
            }
        }
        return 0;
    }

    public long getObjectID() {
        switch (this.type) {
            case 3: {
                return ((AMFMStation)this.data).getUniqueId();
            }
            case 6: {
                return ((DabStation)this.data).getUniqueId();
            }
            case 7: {
                return ((UnifiedStationExt)this.data).getUniqueId();
            }
            case 5: {
                return RadioObjectIds.getSDARSObjectId(((StationInfoExt)this.data).sID);
            }
        }
        return 0L;
    }

    public ArtistAndTitlePair getArtistAndTitlePair() {
        switch (this.type) {
            case 3: {
                return ((AMFMStation)this.data).getArtistAndTitlePair();
            }
            case 6: {
                return ((DabStation)this.data).getArtistAndTitlePair();
            }
            case 7: {
                return ((UnifiedStationExt)this.data).getArtistAndTitlePair();
            }
            case 5: {
                return ((StationInfoExt)this.data).getArtistAndTitlePair();
            }
        }
        return ArtistAndTitlePair.EMPTY_PAIR;
    }

    public String getTag(int n) {
        switch (this.type) {
            case 3: {
                return ((AMFMStation)this.data).getTag(n);
            }
            case 6: {
                return ((DabStation)this.data).getTag(n);
            }
            case 7: {
                return ((UnifiedStationExt)this.data).getTag(n);
            }
            case 5: {
                return "";
            }
        }
        return "";
    }

    public HMIResourceLocator getImage(int n) {
        switch (this.type) {
            case 3: {
                return ((AMFMStation)this.data).getImage(n);
            }
            case 6: {
                return ((DabStation)this.data).getImage(n);
            }
            case 7: {
                return ((UnifiedStationExt)this.data).getImage(n);
            }
            case 5: {
                return ((StationInfoExt)this.data).getImage(n);
            }
            case 8: {
                ResourceLocator resourceLocator = ((TVStation)this.data).logo;
                if (resourceLocator == null) break;
                return new HMIResourceLocator(resourceLocator.id, resourceLocator.url);
            }
        }
        return ISimpleTuner.EMPTY_RL;
    }

    public HMIResourceLocator getSlsImage() {
        switch (this.type) {
            case 6: {
                return ((DabStation)this.data).getSlsImage();
            }
            case 7: {
                return ((UnifiedStationExt)this.data).getSlsImage();
            }
        }
        return ISimpleTuner.EMPTY_RL;
    }

    public int getDbStationId() {
        switch (this.type) {
            case 3: {
                return ((AMFMStation)this.data).getDatabaseId();
            }
            case 6: {
                return ((DabStation)this.data).getDatabaseId();
            }
            case 7: {
                return ((UnifiedStationExt)this.data).getDatabaseId();
            }
        }
        return 0;
    }

    public void setLogoFromDb(HMIResourceLocator hMIResourceLocator) {
        switch (this.type) {
            case 3: {
                ((AMFMStation)this.data).setLogoFromDb(hMIResourceLocator);
                break;
            }
            case 6: {
                ((DabStation)this.data).setLogoFromDb(hMIResourceLocator);
                break;
            }
            case 7: {
                ((UnifiedStationExt)this.data).setLogoFromDb(hMIResourceLocator);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
}

