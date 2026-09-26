/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.interapp.tv.TVStation;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.ISimpleTuner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class SerializingHelpers {
    public static final int VERSION;

    static void serializeAmFm(DataOutputStream dataOutputStream, AMFMStation aMFMStation) {
        ResourceLocator resourceLocator;
        dataOutputStream.writeUTF(aMFMStation.name);
        dataOutputStream.writeLong(aMFMStation.frequency);
        dataOutputStream.writeInt(aMFMStation.pi);
        dataOutputStream.writeInt(aMFMStation.waveband);
        dataOutputStream.writeBoolean(aMFMStation.rds);
        dataOutputStream.writeInt(aMFMStation.ptyCode);
        dataOutputStream.writeBoolean(aMFMStation.isPsFreezed());
        boolean bl = aMFMStation.isHd();
        dataOutputStream.writeBoolean(bl);
        if (bl) {
            dataOutputStream.writeInt(aMFMStation.serviceId);
            dataOutputStream.writeUTF(aMFMStation.longNameHD);
            dataOutputStream.writeUTF(aMFMStation.shortNameHD);
        }
        if ((resourceLocator = aMFMStation.getStationArt()) != null && resourceLocator.url != null) {
            dataOutputStream.writeUTF(resourceLocator.url);
        } else {
            dataOutputStream.writeUTF("");
        }
        dataOutputStream.writeBoolean(aMFMStation.scrollingPS);
        dataOutputStream.writeInt(aMFMStation.getHdStructure());
        dataOutputStream.writeInt(aMFMStation.getDatabaseId());
    }

    private static AMFMStation deserializeAMFM_V03(DataInputStream dataInputStream) {
        AMFMStation aMFMStation = new AMFMStation();
        aMFMStation.name = dataInputStream.readUTF();
        aMFMStation.frequency = dataInputStream.readLong();
        aMFMStation.pi = dataInputStream.readInt();
        aMFMStation.waveband = dataInputStream.readInt();
        aMFMStation.rds = dataInputStream.readBoolean();
        aMFMStation.ptyCode = dataInputStream.readInt();
        boolean bl = dataInputStream.readBoolean();
        if (bl) {
            aMFMStation.freezePs(aMFMStation.name);
        }
        aMFMStation.hd = dataInputStream.readBoolean();
        if (aMFMStation.isHd()) {
            aMFMStation.serviceId = dataInputStream.readInt();
            aMFMStation.longNameHD = dataInputStream.readUTF();
            aMFMStation.shortNameHD = dataInputStream.readUTF();
        }
        return aMFMStation;
    }

    private static AMFMStation deserializeAMFM_V04(DataInputStream dataInputStream) {
        AMFMStation aMFMStation = SerializingHelpers.deserializeAMFM_V03(dataInputStream);
        String string = dataInputStream.readUTF();
        aMFMStation.stationArt = new ResourceLocator(string);
        return aMFMStation;
    }

    private static AMFMStation deserializeAMFM_V05(DataInputStream dataInputStream) {
        AMFMStation aMFMStation = SerializingHelpers.deserializeAMFM_V04(dataInputStream);
        aMFMStation.scrollingPS = dataInputStream.readBoolean();
        return aMFMStation;
    }

    private static AMFMStation deserializeAMFM_V06(DataInputStream dataInputStream) {
        AMFMStation aMFMStation = SerializingHelpers.deserializeAMFM_V05(dataInputStream);
        aMFMStation.setHdStructure(dataInputStream.readInt());
        return aMFMStation;
    }

    private static AMFMStation deserializeAMFM_V07(DataInputStream dataInputStream) {
        AMFMStation aMFMStation = SerializingHelpers.deserializeAMFM_V06(dataInputStream);
        aMFMStation.setDatabaseId(dataInputStream.readInt());
        return aMFMStation;
    }

    public static AMFMStation deserializeAMFM(DataInputStream dataInputStream, int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: {
                return SerializingHelpers.deserializeAMFM_V03(dataInputStream);
            }
            case 4: {
                return SerializingHelpers.deserializeAMFM_V04(dataInputStream);
            }
            case 5: {
                return SerializingHelpers.deserializeAMFM_V05(dataInputStream);
            }
            case 6: {
                return SerializingHelpers.deserializeAMFM_V06(dataInputStream);
            }
        }
        return SerializingHelpers.deserializeAMFM_V07(dataInputStream);
    }

    static void serializeDab(DataOutputStream dataOutputStream, DabStation dabStation) {
        dataOutputStream.writeUTF(dabStation.ensemble.fullName);
        dataOutputStream.writeUTF(dabStation.ensemble.shortName);
        dataOutputStream.writeInt(dabStation.ensemble.getFrequencyValue());
        dataOutputStream.writeInt(dabStation.ensemble.ensID);
        dataOutputStream.writeInt(dabStation.ensemble.ensECC);
        dataOutputStream.writeUTF(dabStation.service.fullName);
        dataOutputStream.writeUTF(dabStation.service.shortName);
        dataOutputStream.writeLong(dabStation.service.sID);
        SerializingHelpers.serializeByteArray(dabStation.service.ptyCodes, dataOutputStream);
        dataOutputStream.writeUTF(dabStation.component.fullName);
        dataOutputStream.writeUTF(dabStation.component.shortName);
        dataOutputStream.writeInt(dabStation.component.sCIDI);
        dataOutputStream.writeBoolean(dabStation.component.primaryService);
        if (dabStation.getEpgImage().containsResourceURI()) {
            dataOutputStream.writeUTF(dabStation.getEpgImage().getResourceURI());
        } else {
            dataOutputStream.writeUTF("");
        }
        dataOutputStream.writeInt(dabStation.getDatabaseId());
    }

    static DabStation deserializeDAB(DataInputStream dataInputStream, int n) {
        return n < 7 ? SerializingHelpers.deserializeDab_V06(dataInputStream) : SerializingHelpers.deserializeDab_V07(dataInputStream);
    }

    private static DabStation deserializeDab_V06(DataInputStream dataInputStream) {
        EnsembleInfo ensembleInfo = new EnsembleInfo();
        ensembleInfo.fullName = dataInputStream.readUTF();
        ensembleInfo.shortName = dataInputStream.readUTF();
        ensembleInfo.frequencyValue = dataInputStream.readInt();
        ensembleInfo.ensID = dataInputStream.readInt();
        ensembleInfo.ensECC = dataInputStream.readInt();
        ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.fullName = dataInputStream.readUTF();
        serviceInfo.shortName = dataInputStream.readUTF();
        serviceInfo.sID = dataInputStream.readLong();
        serviceInfo.ptyCodes = SerializingHelpers.deserializeByteArray(dataInputStream);
        serviceInfo.ensID = ensembleInfo.ensID;
        serviceInfo.ensECC = ensembleInfo.ensECC;
        ComponentInfo componentInfo = new ComponentInfo();
        componentInfo.fullName = dataInputStream.readUTF();
        componentInfo.shortName = dataInputStream.readUTF();
        componentInfo.sCIDI = dataInputStream.readInt();
        componentInfo.primaryService = dataInputStream.readBoolean();
        componentInfo.ensID = ensembleInfo.ensID;
        componentInfo.ensECC = ensembleInfo.ensECC;
        componentInfo.sID = serviceInfo.sID;
        DabStation dabStation = new DabStation(ensembleInfo, serviceInfo, componentInfo);
        String string = dataInputStream.readUTF();
        if (SerializingHelpers.isWhitespaceOnly(string)) {
            dabStation.setStationLogo(ISimpleTuner.EMPTY_RL);
        } else {
            dabStation.setStationLogo(new HMIResourceLocator(string));
        }
        return dabStation;
    }

    private static boolean isWhitespaceOnly(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (Character.isWhitespace(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    private static DabStation deserializeDab_V07(DataInputStream dataInputStream) {
        DabStation dabStation = SerializingHelpers.deserializeDab_V06(dataInputStream);
        dabStation.setDatabaseId(dataInputStream.readInt());
        return dabStation;
    }

    static void serializeUni(DataOutputStream dataOutputStream, UnifiedStationExt unifiedStationExt) {
        dataOutputStream.writeUTF(unifiedStationExt.longName);
        dataOutputStream.writeUTF(unifiedStationExt.shortName);
        dataOutputStream.writeLong(unifiedStationExt.frequency);
        dataOutputStream.writeInt(unifiedStationExt.piSId);
        dataOutputStream.writeBoolean(unifiedStationExt.rds);
        dataOutputStream.writeInt(unifiedStationExt.ensId);
        dataOutputStream.writeInt(unifiedStationExt.ecc);
        dataOutputStream.writeInt(unifiedStationExt.sCIDI);
        if (unifiedStationExt.stationLogo != null && unifiedStationExt.stationLogo.url != null) {
            dataOutputStream.writeUTF(unifiedStationExt.stationLogo.url);
            dataOutputStream.writeInt(unifiedStationExt.stationLogo.id);
        } else {
            dataOutputStream.writeUTF("");
            dataOutputStream.writeInt(-1);
        }
        dataOutputStream.writeBoolean(unifiedStationExt.isPsFreezed());
        dataOutputStream.writeInt(unifiedStationExt.scrollingPS);
        dataOutputStream.writeInt(unifiedStationExt.getDatabaseId());
        boolean bl = unifiedStationExt.hasPrimaryService();
        dataOutputStream.writeBoolean(bl);
        if (bl) {
            UnifiedStationExt unifiedStationExt2 = unifiedStationExt.getPrimaryService();
            dataOutputStream.writeUTF(unifiedStationExt2.longName);
            dataOutputStream.writeUTF(unifiedStationExt2.shortName);
            dataOutputStream.writeLong(unifiedStationExt2.frequency);
            dataOutputStream.writeInt(unifiedStationExt2.piSId);
            dataOutputStream.writeBoolean(unifiedStationExt2.rds);
            dataOutputStream.writeInt(unifiedStationExt2.ensId);
            dataOutputStream.writeInt(unifiedStationExt2.ecc);
            dataOutputStream.writeInt(unifiedStationExt2.sCIDI);
            if (unifiedStationExt2.stationLogo != null && unifiedStationExt2.stationLogo.url != null) {
                dataOutputStream.writeUTF(unifiedStationExt2.stationLogo.url);
                dataOutputStream.writeInt(unifiedStationExt2.stationLogo.id);
            } else {
                dataOutputStream.writeUTF("");
                dataOutputStream.writeInt(-1);
            }
            dataOutputStream.writeBoolean(unifiedStationExt2.isPsFreezed());
            dataOutputStream.writeInt(unifiedStationExt2.scrollingPS);
            dataOutputStream.writeInt(unifiedStationExt2.getDatabaseId());
        }
    }

    static UnifiedStationExt deserializeUni(DataInputStream dataInputStream, int n) {
        return n < 8 ? SerializingHelpers.deserializeUni_V07(dataInputStream, n) : SerializingHelpers.deserializeUni_V08(dataInputStream, n);
    }

    static UnifiedStationExt deserializeUni_V07(DataInputStream dataInputStream, int n) {
        UnifiedStationExt unifiedStationExt = new UnifiedStationExt();
        unifiedStationExt.longName = dataInputStream.readUTF();
        unifiedStationExt.shortName = dataInputStream.readUTF();
        unifiedStationExt.frequency = dataInputStream.readLong();
        unifiedStationExt.piSId = dataInputStream.readInt();
        unifiedStationExt.rds = dataInputStream.readBoolean();
        unifiedStationExt.ensId = dataInputStream.readInt();
        unifiedStationExt.ecc = dataInputStream.readInt();
        unifiedStationExt.sCIDI = dataInputStream.readInt();
        ResourceLocator resourceLocator = new ResourceLocator();
        resourceLocator.url = dataInputStream.readUTF();
        resourceLocator.id = dataInputStream.readInt();
        unifiedStationExt.stationLogo = resourceLocator;
        boolean bl = dataInputStream.readBoolean();
        if (bl) {
            unifiedStationExt.freezePs(unifiedStationExt.getName(true));
        }
        unifiedStationExt.ptyCodes = new byte[0];
        if (n > 4) {
            unifiedStationExt.scrollingPS = dataInputStream.readInt();
        }
        if (n >= 7) {
            unifiedStationExt.setDatabaseId(dataInputStream.readInt());
        }
        return unifiedStationExt;
    }

    static UnifiedStationExt deserializeUni_V08(DataInputStream dataInputStream, int n) {
        boolean bl;
        UnifiedStationExt unifiedStationExt = new UnifiedStationExt();
        unifiedStationExt = SerializingHelpers.deserializeUni_V07(dataInputStream, n);
        if (n > 7 && (bl = dataInputStream.readBoolean())) {
            UnifiedStationExt unifiedStationExt2 = new UnifiedStationExt();
            unifiedStationExt2.longName = dataInputStream.readUTF();
            unifiedStationExt2.shortName = dataInputStream.readUTF();
            unifiedStationExt2.frequency = dataInputStream.readLong();
            unifiedStationExt2.piSId = dataInputStream.readInt();
            unifiedStationExt2.rds = dataInputStream.readBoolean();
            unifiedStationExt2.ensId = dataInputStream.readInt();
            unifiedStationExt2.ecc = dataInputStream.readInt();
            unifiedStationExt2.sCIDI = dataInputStream.readInt();
            ResourceLocator resourceLocator = new ResourceLocator();
            resourceLocator.url = dataInputStream.readUTF();
            resourceLocator.id = dataInputStream.readInt();
            unifiedStationExt2.stationLogo = resourceLocator;
            boolean bl2 = dataInputStream.readBoolean();
            if (bl2) {
                unifiedStationExt2.freezePs(unifiedStationExt.getName(true));
            }
            unifiedStationExt2.ptyCodes = new byte[0];
            unifiedStationExt2.scrollingPS = dataInputStream.readInt();
            unifiedStationExt2.setDatabaseId(dataInputStream.readInt());
            unifiedStationExt.setPrimaryService(unifiedStationExt2);
        }
        return unifiedStationExt;
    }

    static void serializeSdars(DataOutputStream dataOutputStream, StationInfoExt stationInfoExt) {
        dataOutputStream.writeUTF(stationInfoExt.fullLabel);
        dataOutputStream.writeUTF(stationInfoExt.shortLabel);
        dataOutputStream.writeShort(stationInfoExt.sID);
        dataOutputStream.writeShort(stationInfoExt.stationNumber);
        dataOutputStream.writeShort(stationInfoExt.categoryNumber);
        dataOutputStream.writeInt(stationInfoExt.subscription);
        if (stationInfoExt.getStationArt().containsResourceURI()) {
            dataOutputStream.writeUTF(stationInfoExt.getStationArt().getResourceURI());
        } else {
            dataOutputStream.writeUTF("");
        }
        dataOutputStream.writeUTF(stationInfoExt.getShortCategory());
        dataOutputStream.writeUTF(stationInfoExt.getFullCategory());
        dataOutputStream.writeBoolean(stationInfoExt.isGraceNoteRequest());
    }

    static StationInfoExt deserializeSDARS(DataInputStream dataInputStream) {
        StationInfoExt stationInfoExt = new StationInfoExt();
        stationInfoExt.fullLabel = dataInputStream.readUTF();
        stationInfoExt.shortLabel = dataInputStream.readUTF();
        stationInfoExt.sID = dataInputStream.readShort();
        stationInfoExt.stationNumber = dataInputStream.readShort();
        stationInfoExt.categoryNumber = dataInputStream.readShort();
        stationInfoExt.subscription = dataInputStream.readInt();
        String string = dataInputStream.readUTF();
        stationInfoExt.setStationArt(new HMIResourceLocator(string));
        String string2 = dataInputStream.readUTF();
        String string3 = dataInputStream.readUTF();
        boolean bl = dataInputStream.readBoolean();
        stationInfoExt.setCategory(new CategoryInfoExt(stationInfoExt.categoryNumber, string2, string3, bl));
        return stationInfoExt;
    }

    static void serializeTV(DataOutputStream dataOutputStream, TVStation tVStation) {
        dataOutputStream.writeLong(tVStation.namePID);
        dataOutputStream.writeInt(tVStation.servicePID);
        dataOutputStream.writeInt(tVStation.sType);
        dataOutputStream.writeUTF(tVStation.name);
        dataOutputStream.writeInt(tVStation.contentGroup);
        if (tVStation.logo != null && tVStation.logo.url != null) {
            dataOutputStream.writeUTF(tVStation.logo.url);
            dataOutputStream.writeInt(tVStation.logo.id);
        } else {
            dataOutputStream.writeUTF("");
            dataOutputStream.writeInt(-1);
        }
    }

    static TunerObjectContainer deserializeTV(DataInputStream dataInputStream) {
        long l = dataInputStream.readLong();
        int n = dataInputStream.readInt();
        int n2 = dataInputStream.readInt();
        String string = dataInputStream.readUTF();
        int n3 = dataInputStream.readInt();
        String string2 = dataInputStream.readUTF();
        int n4 = dataInputStream.readInt();
        return new TunerObjectContainer(new TVStation(l, n, string, n2, n3, new ResourceLocator(n4, string2)));
    }

    static void serializeByteArray(byte[] byArray, DataOutputStream dataOutputStream) {
        if (byArray == null) {
            dataOutputStream.writeInt(-1);
            return;
        }
        dataOutputStream.writeInt(byArray.length);
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            dataOutputStream.writeByte(byArray[i2]);
        }
    }

    static byte[] deserializeByteArray(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        if (n > 1024) {
            throw new IOException("deserializeByteArray: length to large!");
        }
        if (n == -1) {
            return null;
        }
        byte[] byArray = new byte[n];
        for (int i2 = 0; i2 < n; ++i2) {
            byArray[i2] = dataInputStream.readByte();
        }
        return byArray;
    }

    public static void serializeByteArray(byte[] byArray, ObjectOutputStream objectOutputStream) {
        if (byArray == null) {
            objectOutputStream.writeInt(-1);
            return;
        }
        objectOutputStream.writeInt(byArray.length);
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            objectOutputStream.writeByte(byArray[i2]);
        }
    }

    public static byte[] deserializeByteArray(ObjectInputStream objectInputStream) {
        int n = objectInputStream.readInt();
        if (n > 1024) {
            throw new IOException("deserializeByteArray: length to large!");
        }
        if (n == -1) {
            return null;
        }
        byte[] byArray = new byte[n];
        for (int i2 = 0; i2 < n; ++i2) {
            byArray[i2] = objectInputStream.readByte();
        }
        return byArray;
    }
}

