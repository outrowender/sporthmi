/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.storage.AllTunerLSMStorrage;
import de.audi.tuner.app.storage.SerializingHelpers;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

class AllTunerLSMStorrage$StorageDataContainer
extends AbstractStorageDataContainer {
    private final /* synthetic */ AllTunerLSMStorrage this$0;

    public AllTunerLSMStorrage$StorageDataContainer(AllTunerLSMStorrage allTunerLSMStorrage) {
        this.this$0 = allTunerLSMStorrage;
        super(AllTunerLSMStorrage.access$000(allTunerLSMStorrage), 10, 1001, Utilities.isPGen1OrBentley() ? 30 : 29);
    }

    @Override
    protected void handleCRC32Error() {
        AllTunerLSMStorrage.access$100((AllTunerLSMStorrage)this.this$0).main.log(10000, "[AllTunerLSMStorrage.handleCRC32Error]");
        this.this$0.defaultValues();
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        AllTunerLSMStorrage.access$100((AllTunerLSMStorrage)this.this$0).main.log(10000, "[AllTunerLSMStorrage.handleStorageReadError]: %1", (Object)exception.toString());
        this.this$0.defaultValues();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        AllTunerLSMStorrage.access$100((AllTunerLSMStorrage)this.this$0).main.log(10000, "[AllTunerLSMStorrage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
        this.this$0.defaultValues();
        switch (n) {
            case 9: {
                this.deserializeV9(dataInputStream);
                break;
            }
            case 8: {
                this.deserializeV8(dataInputStream);
                break;
            }
            case 7: {
                this.deserializeV7(dataInputStream);
                break;
            }
            case 6: {
                this.deserializeV6(dataInputStream);
                break;
            }
            case 5: {
                this.deserializeV5(dataInputStream);
                break;
            }
            case 4: {
                this.deserializeV4(dataInputStream);
                break;
            }
            case 3: {
                this.deserializeV3(dataInputStream);
                break;
            }
            case 2: {
                this.deserializeV2(dataInputStream);
                break;
            }
        }
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(AllTunerLSMStorrage.access$200(this.this$0));
        dataOutputStream.writeInt(AllTunerLSMStorrage.access$300(this.this$0));
        dataOutputStream.writeInt(8);
        SerializingHelpers.serializeAmFm(dataOutputStream, AllTunerLSMStorrage.access$400(this.this$0)[0]);
        SerializingHelpers.serializeAmFm(dataOutputStream, AllTunerLSMStorrage.access$400(this.this$0)[1]);
        SerializingHelpers.serializeAmFm(dataOutputStream, AllTunerLSMStorrage.access$400(this.this$0)[2]);
        this.serializeIntArray(AllTunerLSMStorrage.access$500(this.this$0), dataOutputStream);
        SerializingHelpers.serializeDab(dataOutputStream, AllTunerLSMStorrage.access$600(this.this$0));
        this.serializeIntArray(AllTunerLSMStorrage.access$700(this.this$0), dataOutputStream);
        int[] nArray = AllTunerLSMStorrage.access$800(this.this$0).getKeys();
        int[] nArray2 = AllTunerLSMStorrage.access$800(this.this$0).getValues();
        this.serializeIntArray(nArray, dataOutputStream);
        this.serializeIntArray(nArray2, dataOutputStream);
        SerializingHelpers.serializeUni(dataOutputStream, AllTunerLSMStorrage.access$900(this.this$0));
        SerializingHelpers.serializeSdars(dataOutputStream, AllTunerLSMStorrage.access$1000(this.this$0));
        this.serializeIntArray(AllTunerLSMStorrage.access$1100(this.this$0), dataOutputStream);
        nArray = AllTunerLSMStorrage.access$1200(this.this$0).getKeys();
        nArray2 = AllTunerLSMStorrage.access$1200(this.this$0).getValues();
        this.serializeIntArray(nArray, dataOutputStream);
        this.serializeIntArray(nArray2, dataOutputStream);
        this.serializeIntArray(AllTunerLSMStorrage.access$1300(this.this$0), dataOutputStream);
        dataOutputStream.writeInt(AllTunerLSMStorrage.access$1400(this.this$0));
        dataOutputStream.writeBoolean(AllTunerLSMStorrage.access$1500(this.this$0));
        dataOutputStream.writeBoolean(AllTunerLSMStorrage.access$1600(this.this$0));
        dataOutputStream.writeBoolean(AllTunerLSMStorrage.access$1700(this.this$0));
        dataOutputStream.writeInt(AllTunerLSMStorrage.access$1800(this.this$0));
        dataOutputStream.writeInt(AllTunerLSMStorrage.access$1900(this.this$0));
        dataOutputStream.writeInt(AllTunerLSMStorrage.access$2000(this.this$0));
        dataOutputStream.writeInt(AllTunerLSMStorrage.access$2100(this.this$0));
        dataOutputStream.writeBoolean(AllTunerLSMStorrage.access$2200(this.this$0));
        dataOutputStream.writeBoolean(AllTunerLSMStorrage.access$2300(this.this$0));
        this.serializeIntArray(AllTunerLSMStorrage.access$2400(this.this$0), dataOutputStream);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.deserializeV10(dataInputStream);
    }

    private void deserializeV10(DataInputStream dataInputStream) {
        this.deserializeV9(dataInputStream);
        AllTunerLSMStorrage.access$2402(this.this$0, this.deserializeIntArray(dataInputStream));
    }

    private void deserializeV9(DataInputStream dataInputStream) {
        this.deserializeV8(dataInputStream);
        AllTunerLSMStorrage.access$2302(this.this$0, dataInputStream.readBoolean());
    }

    private void deserializeV8(DataInputStream dataInputStream) {
        this.deserializeV7(dataInputStream);
        AllTunerLSMStorrage.access$2202(this.this$0, dataInputStream.readBoolean());
    }

    private void deserializeV7(DataInputStream dataInputStream) {
        this.deserializeV6(dataInputStream);
        AllTunerLSMStorrage.access$2102(this.this$0, dataInputStream.readInt());
    }

    private void deserializeV6(DataInputStream dataInputStream) {
        this.deserializeV5(dataInputStream);
        AllTunerLSMStorrage.access$2002(this.this$0, dataInputStream.readInt());
    }

    private void deserializeV5(DataInputStream dataInputStream) {
        int n;
        AllTunerLSMStorrage.access$202(this.this$0, dataInputStream.readInt());
        AllTunerLSMStorrage.access$302(this.this$0, dataInputStream.readInt());
        int n2 = dataInputStream.readInt();
        AllTunerLSMStorrage.access$402(this.this$0, new AMFMStation[3]);
        AllTunerLSMStorrage.access$400((AllTunerLSMStorrage)this.this$0)[0] = SerializingHelpers.deserializeAMFM(dataInputStream, n2);
        AllTunerLSMStorrage.access$400((AllTunerLSMStorrage)this.this$0)[1] = SerializingHelpers.deserializeAMFM(dataInputStream, n2);
        AllTunerLSMStorrage.access$400((AllTunerLSMStorrage)this.this$0)[2] = SerializingHelpers.deserializeAMFM(dataInputStream, n2);
        AllTunerLSMStorrage.access$502(this.this$0, this.deserializeIntArray(dataInputStream));
        AllTunerLSMStorrage.access$602(this.this$0, SerializingHelpers.deserializeDAB(dataInputStream, n2));
        AllTunerLSMStorrage.access$702(this.this$0, this.deserializeIntArray(dataInputStream));
        int[] nArray = this.deserializeIntArray(dataInputStream);
        int[] nArray2 = this.deserializeIntArray(dataInputStream);
        AllTunerLSMStorrage.access$802(this.this$0, new SimpleIntIntMap(nArray.length + 10));
        for (n = 0; n < nArray.length; ++n) {
            AllTunerLSMStorrage.access$800(this.this$0).add(nArray[n], nArray2[n]);
        }
        AllTunerLSMStorrage.access$902(this.this$0, SerializingHelpers.deserializeUni(dataInputStream, n2));
        AllTunerLSMStorrage.access$1002(this.this$0, SerializingHelpers.deserializeSDARS(dataInputStream));
        AllTunerLSMStorrage.access$1102(this.this$0, this.deserializeIntArray(dataInputStream));
        nArray = this.deserializeIntArray(dataInputStream);
        nArray2 = this.deserializeIntArray(dataInputStream);
        AllTunerLSMStorrage.access$1202(this.this$0, new SimpleIntIntMap(nArray.length + 10));
        for (n = 0; n < nArray.length; ++n) {
            AllTunerLSMStorrage.access$1200(this.this$0).add(nArray[n], nArray2[n]);
        }
        AllTunerLSMStorrage.access$1302(this.this$0, this.deserializeIntArray(dataInputStream));
        AllTunerLSMStorrage.access$1402(this.this$0, dataInputStream.readInt());
        AllTunerLSMStorrage.access$1502(this.this$0, dataInputStream.readBoolean());
        AllTunerLSMStorrage.access$1602(this.this$0, dataInputStream.readBoolean());
        AllTunerLSMStorrage.access$1702(this.this$0, dataInputStream.readBoolean());
        AllTunerLSMStorrage.access$1802(this.this$0, dataInputStream.readInt());
        AllTunerLSMStorrage.access$1902(this.this$0, dataInputStream.readInt());
    }

    private void deserializeV2(DataInputStream dataInputStream) {
        int n;
        AllTunerLSMStorrage.access$202(this.this$0, dataInputStream.readInt());
        AllTunerLSMStorrage.access$302(this.this$0, dataInputStream.readInt());
        AllTunerLSMStorrage.access$402(this.this$0, this.deserialzieAmFmLsmOld(dataInputStream));
        AllTunerLSMStorrage.access$502(this.this$0, this.deserializeIntArray(dataInputStream));
        this.deserializeDabLsmOld(dataInputStream);
        AllTunerLSMStorrage.access$702(this.this$0, this.deserializeIntArray(dataInputStream));
        int[] nArray = this.deserializeIntArray(dataInputStream);
        int[] nArray2 = this.deserializeIntArray(dataInputStream);
        AllTunerLSMStorrage.access$802(this.this$0, new SimpleIntIntMap(nArray.length + 10));
        for (n = 0; n < nArray.length; ++n) {
            AllTunerLSMStorrage.access$800(this.this$0).add(nArray[n], nArray2[n]);
        }
        AllTunerLSMStorrage.access$902(this.this$0, AllTunerLSMStorrage.access$2500(this.this$0, dataInputStream));
        AllTunerLSMStorrage.access$1002(this.this$0, this.deserializeSdarsLsmOld(dataInputStream));
        AllTunerLSMStorrage.access$1102(this.this$0, this.deserializeIntArray(dataInputStream));
        nArray = this.deserializeIntArray(dataInputStream);
        nArray2 = this.deserializeIntArray(dataInputStream);
        AllTunerLSMStorrage.access$1202(this.this$0, new SimpleIntIntMap(nArray.length + 10));
        for (n = 0; n < nArray.length; ++n) {
            AllTunerLSMStorrage.access$1200(this.this$0).add(nArray[n], nArray2[n]);
        }
        AllTunerLSMStorrage.access$1302(this.this$0, this.deserializeIntArray(dataInputStream));
        AllTunerLSMStorrage.access$1402(this.this$0, dataInputStream.readInt());
        AllTunerLSMStorrage.access$1502(this.this$0, dataInputStream.readBoolean());
    }

    private void deserializeV3(DataInputStream dataInputStream) {
        this.deserializeV2(dataInputStream);
        AllTunerLSMStorrage.access$1602(this.this$0, dataInputStream.readBoolean());
    }

    private void deserializeV4(DataInputStream dataInputStream) {
        this.deserializeV3(dataInputStream);
        AllTunerLSMStorrage.access$1702(this.this$0, dataInputStream.readBoolean());
        AllTunerLSMStorrage.access$1802(this.this$0, dataInputStream.readInt());
        AllTunerLSMStorrage.access$1902(this.this$0, dataInputStream.readInt());
    }

    private StationInfoExt deserializeSdarsLsmOld(DataInputStream dataInputStream) {
        StationInfoExt stationInfoExt = new StationInfoExt();
        stationInfoExt.sID = dataInputStream.readInt();
        stationInfoExt.stationNumber = (short)dataInputStream.readInt();
        stationInfoExt.categoryNumber = (short)dataInputStream.readInt();
        stationInfoExt.fullLabel = dataInputStream.readUTF();
        stationInfoExt.shortLabel = dataInputStream.readUTF();
        String string = dataInputStream.readUTF();
        int n = dataInputStream.readInt();
        stationInfoExt.setStationArt(new HMIResourceLocator(n, string));
        stationInfoExt.subscription = 2;
        return stationInfoExt;
    }

    private AMFMStation[] deserialzieAmFmLsmOld(DataInputStream dataInputStream) {
        AMFMStation[] aMFMStationArray = new AMFMStation[3];
        aMFMStationArray[0] = new AMFMStation();
        aMFMStationArray[0].waveband = 1;
        aMFMStationArray[0].frequency = dataInputStream.readInt();
        aMFMStationArray[0].pi = dataInputStream.readInt();
        aMFMStationArray[0].rds = dataInputStream.readBoolean();
        aMFMStationArray[0].serviceId = dataInputStream.readInt();
        aMFMStationArray[0].name = dataInputStream.readUTF();
        aMFMStationArray[0].shortNameHD = dataInputStream.readUTF();
        aMFMStationArray[0].longNameHD = dataInputStream.readUTF();
        aMFMStationArray[0].hd = dataInputStream.readBoolean();
        aMFMStationArray[0].setHdStructure(1 | aMFMStationArray[0].serviceId);
        aMFMStationArray[1] = new AMFMStation();
        aMFMStationArray[1].waveband = 3;
        aMFMStationArray[1].frequency = dataInputStream.readInt();
        aMFMStationArray[1].pi = -1;
        aMFMStationArray[1].name = dataInputStream.readUTF();
        aMFMStationArray[1].shortNameHD = dataInputStream.readUTF();
        aMFMStationArray[1].longNameHD = dataInputStream.readUTF();
        aMFMStationArray[2] = new AMFMStation();
        aMFMStationArray[2].waveband = 3;
        aMFMStationArray[2].frequency = dataInputStream.readInt();
        aMFMStationArray[2].pi = -1;
        return aMFMStationArray;
    }

    private void deserializeDabLsmOld(DataInputStream dataInputStream) {
        EnsembleInfo ensembleInfo = new EnsembleInfo();
        ensembleInfo.ensID = dataInputStream.readInt();
        ensembleInfo.ensECC = dataInputStream.readInt();
        ensembleInfo.frequencyValue = dataInputStream.readInt();
        ensembleInfo.fullName = dataInputStream.readUTF();
        ensembleInfo.shortName = dataInputStream.readUTF();
        ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.ensID = ensembleInfo.ensID;
        serviceInfo.ensECC = ensembleInfo.ensECC;
        serviceInfo.sID = dataInputStream.readInt();
        serviceInfo.fullName = dataInputStream.readUTF();
        serviceInfo.shortName = dataInputStream.readUTF();
        serviceInfo.ptyCodes = new byte[]{0};
        ComponentInfo componentInfo = new ComponentInfo();
        componentInfo.ensID = ensembleInfo.ensID;
        componentInfo.ensECC = ensembleInfo.ensECC;
        componentInfo.sID = serviceInfo.sID;
        componentInfo.sCIDI = dataInputStream.readInt();
        componentInfo.primaryService = dataInputStream.readBoolean();
        componentInfo.fullName = dataInputStream.readUTF();
        componentInfo.shortName = dataInputStream.readUTF();
        AllTunerLSMStorrage.access$602(this.this$0, new DabStation(ensembleInfo, serviceInfo, componentInfo));
    }
}

