/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storage;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.ProviderFailedException;
import de.audi.atip.storage.ValueMissingException;
import de.audi.tghu.storage.DSIStorageProvider$Request;
import de.audi.tghu.storage.DSIStorageProvider$RequestRegistry;
import de.audi.tghu.storage.DSIStorageProvider$StorageWatchDog;
import de.audi.tghu.storage.StorageProvider;
import de.audi.tghu.storage.StorageStatistic;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.dsi.ifc.persistence.DSIPersistence;
import org.dsi.ifc.persistence.DSIPersistenceListener;

public final class DSIStorageProvider
implements StorageProvider,
DSIPersistenceListener {
    private static final int ERRORCODE_TIMEOUT;
    private final IFrameworkAccess fw;
    private final LogChannel log;
    private final StorageStatistic statistic;
    private volatile boolean blockFlush;
    private static int allowedDuration;
    private static final long LONG_RUNNING_READ_THRESHOLD;
    private DSIPersistence provider;
    private final DSIStorageProvider$RequestRegistry registry = new DSIStorageProvider$RequestRegistry(this, null);
    private final DSIStorageProvider$StorageWatchDog watchDog = new DSIStorageProvider$StorageWatchDog(this, null);

    DSIStorageProvider(IFrameworkAccess iFrameworkAccess, StorageStatistic storageStatistic) {
        this.fw = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("Fw.Storage.Provider");
        this.statistic = storageStatistic;
    }

    void setProvider(DSIPersistence dSIPersistence) {
        this.provider = dSIPersistence;
        allowedDuration = Integer.getInteger("DSI_PERSISTENCE_READ_TIMEOUT", allowedDuration);
        dSIPersistence.setNotification(this);
    }

    private void flush(int n, int n2) {
        if (this.provider != null && this.fw.getStartupMgr().isStartupCompleted() && !this.blockFlush) {
            this.log.log(-2137614336, "flush(namespace=%1, key=%2)", (long)n, (long)n2);
            this.provider.flushSQLDatabase();
            this.statistic.flush(n, n2);
        }
    }

    @Override
    public void flush() {
        if (this.provider != null) {
            this.log.log(-2137614336, "flush()");
            this.provider.flushSQLDatabase();
            this.statistic.flush();
        }
    }

    @Override
    public void blockFlush() {
        this.log.log(-2137614336, "blockFlush()");
        this.blockFlush = true;
    }

    @Override
    public void unblockFlush() {
        this.log.log(-2137614336, "unblockFlush()");
        this.blockFlush = false;
        this.flush();
    }

    @Override
    public void start() {
        DSIStorageProvider$StorageWatchDog.access$200(this.watchDog);
    }

    @Override
    public void stop() {
        DSIStorageProvider$StorageWatchDog.access$300(this.watchDog);
    }

    private static byte[] serializeLong(long l) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeLong(l);
        dataOutputStream.flush();
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private static long deserializeLong(byte[] byArray) {
        if (byArray == null) {
            return 0L;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        return dataInputStream.readLong();
    }

    private DSIStorageProvider$Request getRequest(int n, int n2) {
        return this.registry.getRequest(n, n2);
    }

    private void releaseRequest(DSIStorageProvider$Request request) {
        if (request != null) {
            this.registry.releaseRequest(request);
        }
    }

    @Override
    public boolean getBoolean(int n, int n2) {
        return this.getInt(n, n2) != 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getInt(int n, int n2) {
        DSIStorageProvider$Request dSIStorageProvider$Request = this.getRequest(n, n2);
        try {
            if (dSIStorageProvider$Request.scheduleRead()) {
                this.log.log(-2137614336, "-> readInt(%1, %2)", (long)DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), (long)DSIStorageProvider$Request.access$500(dSIStorageProvider$Request));
                this.provider.readIntTimeout(DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), DSIStorageProvider$Request.access$500(dSIStorageProvider$Request), allowedDuration);
            }
            int n3 = dSIStorageProvider$Request.getIntResult();
            return n3;
        }
        finally {
            this.releaseRequest(dSIStorageProvider$Request);
        }
    }

    @Override
    public long getLong(int n, int n2) {
        this.log.log(-2137614336, "getLong(%1, %2)", (long)n, (long)n2);
        DSIStorageProvider$Request dSIStorageProvider$Request = this.getRequest(n, n2);
        try {
            if (dSIStorageProvider$Request.scheduleRead()) {
                this.log.log(-2137614336, "-> readBuffer(%1, %2)", (long)DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), (long)DSIStorageProvider$Request.access$500(dSIStorageProvider$Request));
                this.provider.readBuffer(DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), DSIStorageProvider$Request.access$500(dSIStorageProvider$Request));
            }
            long l = DSIStorageProvider.deserializeLong(dSIStorageProvider$Request.getByteArrayResult());
            return l;
        }
        catch (IOException iOException) {
            throw new ValueMissingException(n, n2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new ValueMissingException(n, n2);
        }
        finally {
            this.releaseRequest(dSIStorageProvider$Request);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String getString(int n, int n2) {
        this.log.log(-2137614336, "getString(%1, %2)", (long)n, (long)n2);
        DSIStorageProvider$Request dSIStorageProvider$Request = this.getRequest(n, n2);
        try {
            if (dSIStorageProvider$Request.scheduleRead()) {
                this.log.log(-2137614336, "-> readString(%1, %2)", (long)DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), (long)DSIStorageProvider$Request.access$500(dSIStorageProvider$Request));
                this.provider.readStringTimeout(DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), DSIStorageProvider$Request.access$500(dSIStorageProvider$Request), allowedDuration);
            }
            String string = dSIStorageProvider$Request.getStringResult();
            return string;
        }
        finally {
            this.releaseRequest(dSIStorageProvider$Request);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public byte[] getByteArray(int n, int n2) {
        this.log.log(-2137614336, "getByteArray(%1, %2)", (long)n, (long)n2);
        DSIStorageProvider$Request dSIStorageProvider$Request = this.getRequest(n, n2);
        try {
            if (dSIStorageProvider$Request.scheduleRead()) {
                this.log.log(-2137614336, "-> readBuffer(%1, %2)", (long)DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), (long)DSIStorageProvider$Request.access$500(dSIStorageProvider$Request));
                this.provider.readBufferTimeout(DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), DSIStorageProvider$Request.access$500(dSIStorageProvider$Request), allowedDuration);
            }
            byte[] byArray = dSIStorageProvider$Request.getByteArrayResult();
            return byArray;
        }
        finally {
            this.releaseRequest(dSIStorageProvider$Request);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int[] getIntArray(int n, int n2) {
        this.log.log(-2137614336, "getIntArray(%1, %2)", (long)n, (long)n2);
        DSIStorageProvider$Request dSIStorageProvider$Request = this.getRequest(n, n2);
        try {
            if (dSIStorageProvider$Request.scheduleRead()) {
                this.log.log(-2137614336, "-> readBuffer(%1, %2)", (long)DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), (long)DSIStorageProvider$Request.access$500(dSIStorageProvider$Request));
                this.provider.readArrayTimeout(DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), DSIStorageProvider$Request.access$500(dSIStorageProvider$Request), allowedDuration);
            }
            int[] nArray = dSIStorageProvider$Request.getIntArrayResult();
            return nArray;
        }
        finally {
            this.releaseRequest(dSIStorageProvider$Request);
        }
    }

    @Override
    public void setBoolean(int n, int n2, boolean bl) {
        this.setInt(n, n2, bl ? 1 : 0);
    }

    @Override
    public void setInt(int n, int n2, int n3) {
        DSIStorageProvider$Request dSIStorageProvider$Request = this.getRequest(n, n2);
        while (!dSIStorageProvider$Request.scheduleWrite(n3)) {
            this.log.log(-2137614336, "retry scheduling %1, %2...", (long)n, (long)n2);
        }
        DSIStorageProvider$StorageWatchDog.access$600(this.watchDog, dSIStorageProvider$Request);
        this.log.log(-2137614336, "-> writeInt(%1, %2, %3)", (long)DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), (long)DSIStorageProvider$Request.access$500(dSIStorageProvider$Request), (long)n3);
        this.provider.writeInt(DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), DSIStorageProvider$Request.access$500(dSIStorageProvider$Request), n3);
    }

    @Override
    public void setLong(int n, int n2, long l) {
        byte[] byArray;
        DSIStorageProvider$Request dSIStorageProvider$Request = this.getRequest(n, n2);
        try {
            byArray = DSIStorageProvider.serializeLong(l);
            if (byArray.length == 0) {
                this.log.log(-1601830656, "Writing empty buffer");
            }
        }
        catch (IOException iOException) {
            throw new IllegalArgumentException(new StringBuffer().append("Data serialization failed! (long data = ").append(l).toString());
        }
        while (!dSIStorageProvider$Request.scheduleWrite(byArray)) {
            this.log.log(-2137614336, "retry scheduling %1, %2...", (long)n, (long)n2);
        }
        DSIStorageProvider$StorageWatchDog.access$600(this.watchDog, dSIStorageProvider$Request);
        this.log.log(-2137614336, "-> writeBuffer(%2, %3, %1)", l, (long)DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), (long)DSIStorageProvider$Request.access$500(dSIStorageProvider$Request));
        this.provider.writeBuffer(DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), DSIStorageProvider$Request.access$500(dSIStorageProvider$Request), byArray);
    }

    @Override
    public void setString(int n, int n2, String string) {
        DSIStorageProvider$Request dSIStorageProvider$Request = this.getRequest(n, n2);
        while (!dSIStorageProvider$Request.scheduleWrite(string)) {
            this.log.log(-2137614336, "retry scheduling %1, %2 ...", (long)n, (long)n2);
        }
        DSIStorageProvider$StorageWatchDog.access$600(this.watchDog, dSIStorageProvider$Request);
        this.log.log(-2137614336, "-> writeString(%2, %3, %1)", (Object)string, (long)DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), (long)DSIStorageProvider$Request.access$500(dSIStorageProvider$Request));
        this.provider.writeString(DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), DSIStorageProvider$Request.access$500(dSIStorageProvider$Request), string);
    }

    @Override
    public void setByteArray(int n, int n2, byte[] byArray) {
        if (byArray.length == 0) {
            this.log.log(-1601830656, "Writing empty buffer");
        }
        DSIStorageProvider$Request dSIStorageProvider$Request = this.getRequest(n, n2);
        while (!dSIStorageProvider$Request.scheduleWrite(byArray)) {
            this.log.log(-2137614336, "retry scheduling %1...", (long)n, (long)n2);
        }
        DSIStorageProvider$StorageWatchDog.access$600(this.watchDog, dSIStorageProvider$Request);
        this.log.log(-2137614336, "-> writeBuffer(%2, %3, %1)", (Object)byArray, (long)DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), (long)DSIStorageProvider$Request.access$500(dSIStorageProvider$Request));
        this.provider.writeBuffer(DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), DSIStorageProvider$Request.access$500(dSIStorageProvider$Request), byArray);
    }

    @Override
    public void setIntArray(int n, int n2, int[] nArray) {
        DSIStorageProvider$Request dSIStorageProvider$Request = this.getRequest(n, n2);
        while (!dSIStorageProvider$Request.scheduleWrite(nArray)) {
            this.log.log(-2137614336, "retry scheduling %1...", (long)n, (long)n2);
        }
        DSIStorageProvider$StorageWatchDog.access$600(this.watchDog, dSIStorageProvider$Request);
        this.log.log(-2137614336, "-> writeBuffer(%2, %3, %1)", (Object)nArray, (long)DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), (long)DSIStorageProvider$Request.access$500(dSIStorageProvider$Request));
        this.provider.writeArray(DSIStorageProvider$Request.access$400(dSIStorageProvider$Request), DSIStorageProvider$Request.access$500(dSIStorageProvider$Request), nArray);
    }

    private void replaceNulls(String[] stringArray) {
        if (stringArray == null) {
            this.log.log(10000, "replaceNulls: String[] data = null!");
            return;
        }
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (stringArray[i2] != null) continue;
            stringArray[i2] = "";
        }
    }

    @Override
    public void readArray(int n, long l, int[] nArray, int n2) {
        DSIStorageProvider$Request dSIStorageProvider$Request = this.registry.lookupRequest(n, l);
        if (dSIStorageProvider$Request != null) {
            this.log.log(-2137614336, "readArray: notify request(%1, %2)", (long)n, l);
            dSIStorageProvider$Request.done(n2, nArray);
        } else {
            this.log.log(-2137614336, "readArray: request(%1, %2) not found", (long)n, l);
        }
    }

    @Override
    public void readBuffer(int n, long l, byte[] byArray, int n2) {
        DSIStorageProvider$Request dSIStorageProvider$Request = this.registry.lookupRequest(n, l);
        if (dSIStorageProvider$Request != null) {
            this.log.log(-2137614336, "readBuffer: notify request(%1, %2)", (long)n, l);
            dSIStorageProvider$Request.done(n2, byArray);
        } else {
            this.log.log(-2137614336, "readBuffer: request(%1, %2) not found", (long)n, l);
        }
    }

    @Override
    public void readInt(int n, long l, int n2, int n3) {
        DSIStorageProvider$Request dSIStorageProvider$Request = this.registry.lookupRequest(n, l);
        if (dSIStorageProvider$Request != null) {
            this.log.log(-2137614336, "readInt: notify request(%1, %2)", (long)n, l);
            dSIStorageProvider$Request.done(n3, n2);
        } else {
            this.log.log(-2137614336, "readInt: request(%1, %2) not found", (long)n, l);
        }
    }

    @Override
    public void readString(int n, long l, String string, int n2) {
        DSIStorageProvider$Request dSIStorageProvider$Request = this.registry.lookupRequest(n, l);
        if (dSIStorageProvider$Request != null) {
            this.log.log(-2137614336, "readString: notify(%1, %2) request", (long)n, l);
            dSIStorageProvider$Request.done(n2, string);
        } else {
            this.log.log(-2137614336, "readString: request not found(%1, %2)", (long)n, l);
        }
    }

    @Override
    public void readStringArray(int n, long l, String[] stringArray, int n2) {
        DSIStorageProvider$Request dSIStorageProvider$Request = this.registry.lookupRequest(n, l);
        if (dSIStorageProvider$Request != null) {
            this.log.log(-2137614336, "readStringArray: notify(%1, %2) request", (long)n, l);
            dSIStorageProvider$Request.done(n2, stringArray);
        } else {
            this.log.log(-2137614336, "readStringArray: request not found(%1, %2)", (long)n, l);
        }
    }

    @Override
    public void writeArray(int n, long l, int n2) {
        this.completeWrite(n, l, n2);
    }

    @Override
    public void writeBuffer(int n, long l, int n2) {
        this.completeWrite(n, l, n2);
    }

    @Override
    public void writeInt(int n, long l, int n2) {
        this.completeWrite(n, l, n2);
    }

    @Override
    public void writeString(int n, long l, int n2) {
        this.completeWrite(n, l, n2);
    }

    @Override
    public void writeStringArray(int n, long l, int n2) {
        this.completeWrite(n, l, n2);
    }

    private void completeWrite(int n, long l, int n2) {
        DSIStorageProvider$Request dSIStorageProvider$Request = this.registry.lookupRequest(n, l);
        if (dSIStorageProvider$Request != null) {
            DSIStorageProvider$StorageWatchDog.access$700(this.watchDog, dSIStorageProvider$Request);
            dSIStorageProvider$Request.doneWrite(n2);
            if (n2 == 0) {
                this.statistic.writeOK(n, l);
            } else {
                this.statistic.writeError(new ProviderFailedException(n, l, new StringBuffer().append("DSI returned ERRORCODE=").append(n2).toString()));
            }
        } else {
            this.statistic.writeWarning(new ProviderFailedException(n, l, "unexpected response from DSI!"));
            this.log.log(-2137614336, "request(%1, %2) not found", (long)n, l);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "errorCode=%2, errorMsg=%, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void flushSQLDatabase(int n) {
        this.log.log(-2137614336, "flushSQLDatabase: errorCode=%1", (long)n);
        if (n != 0) {
            this.log.log(10000, "Failed with error code: %1", (long)n);
        }
    }

    @Override
    public void getVisibleSystemLanguages(String string) {
        this.log.log(-2137614336, "visibleSystemLanguages=%1", (Object)string);
    }

    @Override
    public void updateActiveSQLDatabaseMedium(int n, int n2) {
        this.log.log(-2137614336, "activeSQLDatabaseMedium=%1, validFlag=%2", (long)n, (long)n2);
    }

    @Override
    public void beginTransaction(int n, int n2) {
    }

    @Override
    public void endTransaction(int n, int n2) {
    }

    @Override
    public void valueChangedInt(int n, long l, int n2, int n3) {
    }

    @Override
    public void valueChangedString(int n, long l, String string, int n2) {
    }

    @Override
    public void valueChangedArray(int n, long l, int[] nArray, int n2) {
    }

    @Override
    public void valueChangedStringArray(int n, long l, String[] stringArray, int n2) {
    }

    @Override
    public void valueChangedBuffer(int n, long l, byte[] byArray, int n2) {
    }

    @Override
    public void unsubscribe(int n, int[] nArray, long[] lArray, int[] nArray2) {
    }

    static /* synthetic */ IFrameworkAccess access$800(DSIStorageProvider dSIStorageProvider) {
        return dSIStorageProvider.fw;
    }

    static /* synthetic */ LogChannel access$900(DSIStorageProvider dSIStorageProvider) {
        return dSIStorageProvider.log;
    }

    static /* synthetic */ DSIStorageProvider$RequestRegistry access$1000(DSIStorageProvider dSIStorageProvider) {
        return dSIStorageProvider.registry;
    }

    static /* synthetic */ int access$1100() {
        return allowedDuration;
    }

    static /* synthetic */ StorageStatistic access$1200(DSIStorageProvider dSIStorageProvider) {
        return dSIStorageProvider.statistic;
    }

    static /* synthetic */ void access$1300(DSIStorageProvider dSIStorageProvider, int n, int n2) {
        dSIStorageProvider.flush(n, n2);
    }

    static {
        allowedDuration = 5000;
    }
}

