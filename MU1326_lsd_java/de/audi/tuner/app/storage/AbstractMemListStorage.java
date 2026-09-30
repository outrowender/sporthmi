/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.atip.interapp.tv.TVStation;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.memory.AbstractTVMemoryRow;
import de.audi.tuner.app.memory.AmFmMemoryRow;
import de.audi.tuner.app.memory.DABMemoryRow;
import de.audi.tuner.app.memory.SDARSMemoryRow;
import de.audi.tuner.app.memory.UniMemoryRow;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.storage.IMemListStorage;
import de.audi.tuner.app.storage.SerializingHelpers;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.ILogoDatabase;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class AbstractMemListStorage
implements IMemListStorage {
    public static final int VERSION = 8;
    private final IStorageAccess storageAccess;
    private final LogChannel lc;
    protected final AbstractListRowFactory rowFactory;
    private int imgType;
    private ILogoDatabase logoDb = null;

    public AbstractMemListStorage(IStorageAccess iStorageAccess, LogChannel logChannel, AbstractListRowFactory abstractListRowFactory) {
        this.storageAccess = iStorageAccess;
        this.lc = logChannel;
        this.rowFactory = abstractListRowFactory;
    }

    public void setPreferredImgType(int n) {
        this.imgType = n;
    }

    protected void setLogoDb(ILogoDatabase iLogoDatabase) {
        this.logoDb = iLogoDatabase;
    }

    protected synchronized void doWrite(AbstractMemoryRow[] abstractMemoryRowArray, int n) {
        this.lc.log(10000000, "[AbstractMemListStorage.doWrite]");
        StorageDataContainer storageDataContainer = new StorageDataContainer(n);
        storageDataContainer.setRows(abstractMemoryRowArray);
        storageDataContainer.serializeAndWrite();
    }

    public AbstractMemoryRow[] doRead(int n) {
        this.lc.log(10000000, "[AbstractMemListStorage.doRead]");
        StorageDataContainer storageDataContainer = new StorageDataContainer(n);
        storageDataContainer.readAndDeserialize();
        AbstractMemoryRow[] abstractMemoryRowArray = storageDataContainer.getRows();
        if (n == 338) {
            abstractMemoryRowArray = this.chkLength(abstractMemoryRowArray);
        }
        return abstractMemoryRowArray;
    }

    private AbstractMemoryRow[] chkLength(AbstractMemoryRow[] abstractMemoryRowArray) {
        if (abstractMemoryRowArray.length < 50) {
            AbstractMemoryRow[] abstractMemoryRowArray2 = new AbstractMemoryRow[50];
            System.arraycopy((Object)abstractMemoryRowArray, 0, (Object)abstractMemoryRowArray2, 0, abstractMemoryRowArray.length);
            for (int i2 = abstractMemoryRowArray.length; i2 < abstractMemoryRowArray2.length; ++i2) {
                abstractMemoryRowArray2[i2] = this.rowFactory.getEmptyFavRow(i2);
            }
            return abstractMemoryRowArray2;
        }
        return abstractMemoryRowArray;
    }

    private void serializeRow(AbstractMemoryRow abstractMemoryRow, DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(abstractMemoryRow.getBand());
        if (abstractMemoryRow.isEmpty()) {
            return;
        }
        if (abstractMemoryRow instanceof AmFmMemoryRow) {
            AMFMStation aMFMStation = ((AmFmMemoryRow)abstractMemoryRow).getStation();
            SerializingHelpers.serializeAmFm(dataOutputStream, aMFMStation);
            return;
        }
        if (abstractMemoryRow instanceof DABMemoryRow) {
            DabStation dabStation = abstractMemoryRow.getTOContainer().getDABStation();
            SerializingHelpers.serializeDab(dataOutputStream, dabStation);
            return;
        }
        if (abstractMemoryRow instanceof UniMemoryRow) {
            UnifiedStationExt unifiedStationExt = abstractMemoryRow.getTOContainer().getUniStation();
            SerializingHelpers.serializeUni(dataOutputStream, unifiedStationExt);
            return;
        }
        if (abstractMemoryRow instanceof SDARSMemoryRow) {
            StationInfoExt stationInfoExt = ((SDARSMemoryRow)abstractMemoryRow).getStation();
            SerializingHelpers.serializeSdars(dataOutputStream, stationInfoExt);
            return;
        }
        if (abstractMemoryRow instanceof AbstractTVMemoryRow) {
            TVStation tVStation = abstractMemoryRow.getTOContainer().getTVStation();
            SerializingHelpers.serializeTV(dataOutputStream, tVStation);
            return;
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown memory row: ").append(abstractMemoryRow).toString());
    }

    private AbstractMemoryRow deserializeRow(int n, int n2, DataInputStream dataInputStream, int n3) throws IOException {
        switch (n2) {
            case 8: {
                return this.rowFactory.getEmptyFavRow(n);
            }
            case 1: 
            case 4: {
                AMFMStation aMFMStation = SerializingHelpers.deserializeAMFM(dataInputStream, n3);
                aMFMStation.setPresetPos(n + 1);
                if (this.logoDb != null) {
                    aMFMStation.setLogoFromDb(this.logoDb.getLogo(aMFMStation.getUniqueId()));
                }
                return this.rowFactory.getAmFmFavRow(aMFMStation, n + 1, this.imgType);
            }
            case 5: {
                TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(SerializingHelpers.deserializeDAB(dataInputStream, n3));
                tunerObjectContainer.setPresetPos(n + 1);
                if (this.logoDb != null) {
                    tunerObjectContainer.setLogoFromDb(this.logoDb.getLogo(tunerObjectContainer.getRadioId()));
                }
                return this.rowFactory.getDabFavRow(tunerObjectContainer, this.imgType);
            }
            case 11: {
                UnifiedStationExt unifiedStationExt = SerializingHelpers.deserializeUni(dataInputStream, n3);
                if (this.logoDb != null) {
                    unifiedStationExt.setLogoFromDb(this.logoDb.getLogo(unifiedStationExt.getUniqueId()));
                }
                return this.rowFactory.getUniFavRow(unifiedStationExt, this.imgType);
            }
            case 7: {
                TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(SerializingHelpers.deserializeSDARS(dataInputStream));
                tunerObjectContainer.setPresetPos(n + 1);
                return this.rowFactory.getSdarsFavRow(tunerObjectContainer, n + 1, this.imgType);
            }
            case 15: {
                TunerObjectContainer tunerObjectContainer = SerializingHelpers.deserializeTV(dataInputStream);
                return this.rowFactory.getFavRow(tunerObjectContainer, n + 1, -1);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown band ").append(n2).append(" at index ").append(n).toString());
    }

    protected abstract AbstractMemoryRow[] getDefaultList();

    private class StorageDataContainer
    extends AbstractStorageDataContainer {
        private AbstractMemoryRow[] rows;

        StorageDataContainer(int n) {
            super(AbstractMemListStorage.this.storageAccess, 8, 1001, n);
            this.rows = AbstractMemListStorage.this.getDefaultList();
        }

        protected void handleCRC32Error() {
            AbstractMemListStorage.this.lc.log(10000, "[AbstractMemListStorage.handleCRC32Error]");
            this.rows = AbstractMemListStorage.this.getDefaultList();
        }

        protected void handleStorageReadError(Exception exception) {
            AbstractMemListStorage.this.lc.log(10000, "[AbstractMemListStorage.handleStorageReadError] %1", (Object)exception.getMessage());
            AbstractMemListStorage.this.lc.log(100000, "[AbstractMemListStorage.handleStorageReadError]", (Throwable)exception);
            this.rows = AbstractMemListStorage.this.getDefaultList();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
            AbstractMemListStorage.this.lc.log(1000000, "[AbstractMemListStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
            this.deserialize(dataInputStream, n);
        }

        void setRows(AbstractMemoryRow[] abstractMemoryRowArray) {
            this.rows = abstractMemoryRowArray;
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            AbstractMemListStorage.this.lc.log(10000000, "[AbstractMemListStorage.serialize]");
            dataOutputStream.writeInt(this.rows.length);
            for (int i2 = 0; i2 < this.rows.length; ++i2) {
                AbstractMemListStorage.this.serializeRow(this.rows[i2], dataOutputStream);
            }
        }

        AbstractMemoryRow[] getRows() {
            return this.rows;
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            AbstractMemListStorage.this.lc.log(10000000, "[AbstractMemListStorage.deserialize]");
            this.deserialize(dataInputStream, 8);
        }

        private void deserialize(DataInputStream dataInputStream, int n) throws IOException {
            AbstractMemListStorage.this.lc.log(10000000, "[AbstractMemListStorage.deserialize]");
            int n2 = dataInputStream.readInt();
            this.rows = new AbstractMemoryRow[n2];
            for (int i2 = 0; i2 < this.rows.length; ++i2) {
                int n3 = dataInputStream.readInt();
                this.rows[i2] = AbstractMemListStorage.this.deserializeRow(i2, n3, dataInputStream, n);
            }
        }
    }
}

