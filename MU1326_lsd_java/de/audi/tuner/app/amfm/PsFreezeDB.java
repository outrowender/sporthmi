/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.IPSFreezeDB;
import de.audi.tuner.app.amfm.PsFreezeData;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.esolutions.fw.util.commons.Buffer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PsFreezeDB
implements TimerListener,
IPSFreezeDB {
    private static final int MAX_FREEZED_ENTRIES = 200;
    private static final int AUTOSTORE_INTERVAL_MS = 600000;
    private Map dataBase = new HashMap();
    private boolean dataBaseDirty = false;
    private final Timer autoStoreTimer;
    private final LogChannel log;
    private final TunerStorage storage;

    public PsFreezeDB(TunerBasics tunerBasics, TunerStorage tunerStorage) {
        this.log = tunerBasics.getLogger().amfmDeepDebug;
        this.storage = tunerStorage;
        this.autoStoreTimer = new Timer("psAutoStoreTimer", 5, tunerBasics.getLogger().timer, this, 600000L, false);
        this.autoStoreTimer.start();
        this.loadDataBase();
    }

    public void add(AMFMStation aMFMStation) {
        if (aMFMStation.isPsFreezed()) {
            if (this.isFull()) {
                this.log.log(10000000, "[PsFreezeDB#add], Database is full, removing an entry...");
                this.remove(this.getKeyOfOldestEntry());
            }
            Long l = this.createKey(aMFMStation);
            this.log.log(10000000, "[PsFreezeDB#add], key: %1", (Object)l);
            this.log.log(10000000, "[PsFreezeDB#add], name: %1", (Object)aMFMStation.name);
            this.dataBase.put(l, new PsFreezeData(aMFMStation.name));
            this.storeDataBase();
        } else {
            this.log.log(10000, "[PsFreezeDB#add], Station is not freezed PS, not adding it!");
        }
    }

    public void remove(AMFMStation aMFMStation) {
        if (!aMFMStation.isPsFreezed()) {
            this.remove(this.createKey(aMFMStation));
            this.storeDataBase();
        } else {
            this.log.log(10000, "[PsFreezeDB#remove], Station is freezed PS, not removing it!");
        }
    }

    public void removeAll() {
        this.log.log(10000000, "[PsFreezeDB#removeAll]");
        this.dataBase.clear();
        this.storeDataBase();
    }

    public String getFreezedName(AMFMStation aMFMStation) {
        String string = null;
        if (aMFMStation != null) {
            PsFreezeData psFreezeData = this.get(this.createKey(aMFMStation));
            this.dataBaseDirty = this.resetAge(psFreezeData);
            string = psFreezeData.getFreezedName();
        }
        this.log.log(10000000, "[PsFreezeDB#getFreezedName], returning: %1", string);
        return string;
    }

    public String getFreezedName(UnifiedStationExt unifiedStationExt) {
        String string = null;
        if (unifiedStationExt != null) {
            PsFreezeData psFreezeData = this.get(this.createKey(unifiedStationExt));
            this.dataBaseDirty = this.resetAge(psFreezeData);
            string = psFreezeData.getFreezedName();
        }
        this.log.log(10000000, "[PsFreezeDB#getFreezedName], returning: %1", string);
        return string;
    }

    public int getSize() {
        int n = this.dataBase.size();
        this.log.log(10000000, "[PsFreezeDB#getSize], returning: %1", (long)n);
        return n;
    }

    public int getMaxSize() {
        return 200;
    }

    private void loadDataBase() {
        this.log.log(10000000, "[PsFreezeDB#loadDataBase]");
        this.dataBase.clear();
        try {
            if (this.storage != null) {
                byte[] byArray = this.storage.loadPsFreezeDB();
                if (byArray.length != 0) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
                    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                    int n = dataInputStream.readInt();
                    this.log.log(1000000, "[PsFreezeDB#loadDataBase]: length %1", (long)n);
                    for (int i2 = 0; i2 < n; ++i2) {
                        long l = dataInputStream.readLong();
                        String string = dataInputStream.readUTF();
                        int n2 = dataInputStream.readInt();
                        this.dataBase.put(new Long(l), new PsFreezeData(string, n2));
                    }
                    dataInputStream.close();
                } else {
                    this.log.log(1000000, "[PsFreezeDB#loadDataBase]: empty byteArray");
                }
            }
        }
        catch (IOException iOException) {
            this.log.log(10000, "[PsFreezeDB#loadDataBase]: IOException", (Throwable)iOException);
        }
        this.ageEntries();
    }

    public String toString() {
        if (this.getSize() > 0) {
            Buffer buffer = new Buffer(this.getSize());
            Iterator iterator = this.dataBase.keySet().iterator();
            while (iterator.hasNext()) {
                Long l = (Long)iterator.next();
                PsFreezeData psFreezeData = this.get(l);
                int n = l.intValue() & 0xFFFF;
                if (n != 0) {
                    buffer.append("PI  : ").append(Long.toHexString(n));
                } else {
                    n = (int)((l & 0xFFFFFFFFFFFFFFFFL) >>> 16);
                    buffer.append("Freq : ").append(n);
                }
                buffer.append(" -> ").append(psFreezeData.toString());
                buffer.append('\n');
            }
            return buffer.toString();
        }
        return "Database is empty";
    }

    public void cancelTimer(Timer timer) {
    }

    public void fireTimer(Timer timer) {
        this.log.log(10000000, "[PsFreezeDB#fireTimer]");
        if (timer.equals(this.autoStoreTimer) && this.dataBaseDirty) {
            this.storeDataBase();
        }
    }

    private Long createKey(AMFMStation aMFMStation) {
        if (aMFMStation.rds && aMFMStation.pi != 0) {
            return new Long(aMFMStation.pi);
        }
        return new Long(aMFMStation.frequency << 16 | (long)(aMFMStation.pi & 0xFFFF));
    }

    private Long createKey(UnifiedStationExt unifiedStationExt) {
        if (unifiedStationExt.rds && unifiedStationExt.piSId != 0) {
            return new Long(unifiedStationExt.piSId);
        }
        return new Long(unifiedStationExt.frequency << 16 | (long)(unifiedStationExt.piSId & 0xFFFF));
    }

    private void storeDataBase() {
        this.log.log(10000000, "[PsFreezeDB#storeDataBase]");
        try {
            if (this.storage != null) {
                this.storage.storePsFreezeDB(this.toByteArray());
                this.dataBaseDirty = false;
            }
        }
        catch (IOException iOException) {
            this.log.log(10000, "Exception ", (Throwable)iOException);
        }
    }

    private byte[] toByteArray() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(this.dataBase.size());
        int n = 0;
        Iterator iterator = this.dataBase.keySet().iterator();
        while (iterator.hasNext() && n < this.dataBase.size()) {
            Long l = (Long)iterator.next();
            PsFreezeData psFreezeData = (PsFreezeData)this.dataBase.get(l);
            dataOutputStream.writeLong(l);
            dataOutputStream.writeUTF(psFreezeData.getFreezedName());
            dataOutputStream.writeInt(psFreezeData.getAge());
        }
        dataOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private void remove(Long l) {
        this.log.log(10000000, "[PsFreezeDB#remove], key: %1", (Object)l);
        if (this.dataBase.remove(l) == null) {
            this.log.log(100000, "[PsFreezeDB#remove], Could not remove object, invalid key (%1) given?", (Object)l);
        }
    }

    private PsFreezeData get(Long l) {
        PsFreezeData psFreezeData = (PsFreezeData)this.dataBase.get(l);
        return psFreezeData != null ? psFreezeData : new PsFreezeData(null);
    }

    private boolean isFull() {
        return this.dataBase.size() == 200;
    }

    private Long getKeyOfOldestEntry() {
        Long l = new Long(0L);
        if (this.getSize() != 0) {
            Iterator iterator = this.dataBase.keySet().iterator();
            l = (Long)iterator.next();
            Long l2 = new Long(this.get(l).getAge());
            while (iterator.hasNext()) {
                Long l3 = (Long)iterator.next();
                PsFreezeData psFreezeData = this.get(l3);
                if (!psFreezeData.isOlder(l2.intValue())) continue;
                l = l3;
                l2 = new Long(psFreezeData.getAge());
            }
        }
        return l;
    }

    final void ageEntries() {
        Iterator iterator = this.dataBase.keySet().iterator();
        while (iterator.hasNext()) {
            this.get((Long)iterator.next()).age();
        }
    }

    private boolean resetAge(PsFreezeData psFreezeData) {
        boolean bl = false;
        if (psFreezeData != null && psFreezeData.getAge() != 0) {
            psFreezeData.setAge(0);
            this.dataBaseDirty = true;
            bl = true;
        }
        this.log.log(10000000, "[PsFreezeDB#resetAge], resetDone: %1", bl);
        return bl;
    }
}

