/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storage;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.ProviderFailedException;
import de.audi.atip.storage.ValueMissingException;
import de.audi.tghu.storage.FlushValuesDict;
import de.audi.tghu.storage.StorageProvider;
import de.audi.tghu.storage.StorageStatistic;
import de.esolutions.fw.util.commons.Buffer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.persistence.DSIPersistence;
import org.dsi.ifc.persistence.DSIPersistenceListener;

public final class DSIStorageProvider
implements StorageProvider,
DSIPersistenceListener {
    private static final int ERRORCODE_TIMEOUT = 100;
    private final IFrameworkAccess fw;
    private final LogChannel log;
    private final StorageStatistic statistic;
    private volatile boolean blockFlush;
    private static int allowedDuration = 5000;
    private static final long LONG_RUNNING_READ_THRESHOLD = 50L;
    private DSIPersistence provider;
    private final RequestRegistry registry = new RequestRegistry();
    private final StorageWatchDog watchDog = new StorageWatchDog();

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
            this.log.log(10000000, "flush(namespace=%1, key=%2)", (long)n, (long)n2);
            this.provider.flushSQLDatabase();
            this.statistic.flush(n, n2);
        }
    }

    public void flush() {
        if (this.provider != null) {
            this.log.log(10000000, "flush()");
            this.provider.flushSQLDatabase();
            this.statistic.flush();
        }
    }

    public void blockFlush() {
        this.log.log(10000000, "blockFlush()");
        this.blockFlush = true;
    }

    public void unblockFlush() {
        this.log.log(10000000, "unblockFlush()");
        this.blockFlush = false;
        this.flush();
    }

    public void start() {
        this.watchDog.start();
    }

    public void stop() {
        this.watchDog.stop();
    }

    private static byte[] serializeLong(long l) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeLong(l);
        dataOutputStream.flush();
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private static long deserializeLong(byte[] byArray) throws IOException, ClassNotFoundException {
        if (byArray == null) {
            return 0L;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        return dataInputStream.readLong();
    }

    private Request getRequest(int n, int n2) throws IllegalArgumentException {
        return this.registry.getRequest(n, n2);
    }

    private void releaseRequest(Request request) {
        if (request != null) {
            this.registry.releaseRequest(request);
        }
    }

    public boolean getBoolean(int n, int n2) {
        return this.getInt(n, n2) != 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getInt(int n, int n2) {
        Request request = this.getRequest(n, n2);
        try {
            if (request.scheduleRead()) {
                this.log.log(10000000, "-> readInt(%1, %2)", (long)request.namespace, (long)request.key);
                this.provider.readIntTimeout(request.namespace, request.key, allowedDuration);
            }
            int n3 = request.getIntResult();
            return n3;
        }
        finally {
            this.releaseRequest(request);
        }
    }

    public long getLong(int n, int n2) {
        this.log.log(10000000, "getLong(%1, %2)", (long)n, (long)n2);
        Request request = this.getRequest(n, n2);
        try {
            if (request.scheduleRead()) {
                this.log.log(10000000, "-> readBuffer(%1, %2)", (long)request.namespace, (long)request.key);
                this.provider.readBuffer(request.namespace, request.key);
            }
            long l = DSIStorageProvider.deserializeLong(request.getByteArrayResult());
            return l;
        }
        catch (IOException iOException) {
            throw new ValueMissingException(n, n2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new ValueMissingException(n, n2);
        }
        finally {
            this.releaseRequest(request);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getString(int n, int n2) throws ValueMissingException, ProviderFailedException, IllegalArgumentException {
        this.log.log(10000000, "getString(%1, %2)", (long)n, (long)n2);
        Request request = this.getRequest(n, n2);
        try {
            if (request.scheduleRead()) {
                this.log.log(10000000, "-> readString(%1, %2)", (long)request.namespace, (long)request.key);
                this.provider.readStringTimeout(request.namespace, request.key, allowedDuration);
            }
            String string = request.getStringResult();
            return string;
        }
        finally {
            this.releaseRequest(request);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public byte[] getByteArray(int n, int n2) throws ValueMissingException, ProviderFailedException, IllegalArgumentException {
        this.log.log(10000000, "getByteArray(%1, %2)", (long)n, (long)n2);
        Request request = this.getRequest(n, n2);
        try {
            if (request.scheduleRead()) {
                this.log.log(10000000, "-> readBuffer(%1, %2)", (long)request.namespace, (long)request.key);
                this.provider.readBufferTimeout(request.namespace, request.key, allowedDuration);
            }
            byte[] byArray = request.getByteArrayResult();
            return byArray;
        }
        finally {
            this.releaseRequest(request);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int[] getIntArray(int n, int n2) throws ValueMissingException, ProviderFailedException, IllegalArgumentException {
        this.log.log(10000000, "getIntArray(%1, %2)", (long)n, (long)n2);
        Request request = this.getRequest(n, n2);
        try {
            if (request.scheduleRead()) {
                this.log.log(10000000, "-> readBuffer(%1, %2)", (long)request.namespace, (long)request.key);
                this.provider.readArrayTimeout(request.namespace, request.key, allowedDuration);
            }
            int[] nArray = request.getIntArrayResult();
            return nArray;
        }
        finally {
            this.releaseRequest(request);
        }
    }

    public void setBoolean(int n, int n2, boolean bl) throws UnsupportedOperationException {
        this.setInt(n, n2, bl ? 1 : 0);
    }

    public void setInt(int n, int n2, int n3) throws ProviderFailedException, IllegalArgumentException {
        Request request = this.getRequest(n, n2);
        while (!request.scheduleWrite(n3)) {
            this.log.log(10000000, "retry scheduling %1, %2...", (long)n, (long)n2);
        }
        this.watchDog.addToPendingQueue(request);
        this.log.log(10000000, "-> writeInt(%1, %2, %3)", (long)request.namespace, (long)request.key, (long)n3);
        this.provider.writeInt(request.namespace, request.key, n3);
    }

    public void setLong(int n, int n2, long l) throws UnsupportedOperationException {
        byte[] byArray;
        Request request = this.getRequest(n, n2);
        try {
            byArray = DSIStorageProvider.serializeLong(l);
            if (byArray.length == 0) {
                this.log.log(100000, "Writing empty buffer");
            }
        }
        catch (IOException iOException) {
            throw new IllegalArgumentException(new StringBuffer().append("Data serialization failed! (long data = ").append(l).toString());
        }
        while (!request.scheduleWrite(byArray)) {
            this.log.log(10000000, "retry scheduling %1, %2...", (long)n, (long)n2);
        }
        this.watchDog.addToPendingQueue(request);
        this.log.log(10000000, "-> writeBuffer(%2, %3, %1)", l, (long)request.namespace, (long)request.key);
        this.provider.writeBuffer(request.namespace, request.key, byArray);
    }

    public void setString(int n, int n2, String string) throws ProviderFailedException, IllegalArgumentException {
        Request request = this.getRequest(n, n2);
        while (!request.scheduleWrite(string)) {
            this.log.log(10000000, "retry scheduling %1, %2 ...", (long)n, (long)n2);
        }
        this.watchDog.addToPendingQueue(request);
        this.log.log(10000000, "-> writeString(%2, %3, %1)", (Object)string, (long)request.namespace, (long)request.key);
        this.provider.writeString(request.namespace, request.key, string);
    }

    public void setByteArray(int n, int n2, byte[] byArray) throws ProviderFailedException, IllegalArgumentException {
        if (byArray.length == 0) {
            this.log.log(100000, "Writing empty buffer");
        }
        Request request = this.getRequest(n, n2);
        while (!request.scheduleWrite(byArray)) {
            this.log.log(10000000, "retry scheduling %1...", (long)n, (long)n2);
        }
        this.watchDog.addToPendingQueue(request);
        this.log.log(10000000, "-> writeBuffer(%2, %3, %1)", (Object)byArray, (long)request.namespace, (long)request.key);
        this.provider.writeBuffer(request.namespace, request.key, byArray);
    }

    public void setIntArray(int n, int n2, int[] nArray) throws ProviderFailedException, IllegalArgumentException {
        Request request = this.getRequest(n, n2);
        while (!request.scheduleWrite(nArray)) {
            this.log.log(10000000, "retry scheduling %1...", (long)n, (long)n2);
        }
        this.watchDog.addToPendingQueue(request);
        this.log.log(10000000, "-> writeBuffer(%2, %3, %1)", (Object)nArray, (long)request.namespace, (long)request.key);
        this.provider.writeArray(request.namespace, request.key, nArray);
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

    public void readArray(int n, long l, int[] nArray, int n2) {
        Request request = this.registry.lookupRequest(n, l);
        if (request != null) {
            this.log.log(10000000, "readArray: notify request(%1, %2)", (long)n, l);
            request.done(n2, nArray);
        } else {
            this.log.log(10000000, "readArray: request(%1, %2) not found", (long)n, l);
        }
    }

    public void readBuffer(int n, long l, byte[] byArray, int n2) {
        Request request = this.registry.lookupRequest(n, l);
        if (request != null) {
            this.log.log(10000000, "readBuffer: notify request(%1, %2)", (long)n, l);
            request.done(n2, byArray);
        } else {
            this.log.log(10000000, "readBuffer: request(%1, %2) not found", (long)n, l);
        }
    }

    public void readInt(int n, long l, int n2, int n3) {
        Request request = this.registry.lookupRequest(n, l);
        if (request != null) {
            this.log.log(10000000, "readInt: notify request(%1, %2)", (long)n, l);
            request.done(n3, n2);
        } else {
            this.log.log(10000000, "readInt: request(%1, %2) not found", (long)n, l);
        }
    }

    public void readString(int n, long l, String string, int n2) {
        Request request = this.registry.lookupRequest(n, l);
        if (request != null) {
            this.log.log(10000000, "readString: notify(%1, %2) request", (long)n, l);
            request.done(n2, string);
        } else {
            this.log.log(10000000, "readString: request not found(%1, %2)", (long)n, l);
        }
    }

    public void readStringArray(int n, long l, String[] stringArray, int n2) {
        Request request = this.registry.lookupRequest(n, l);
        if (request != null) {
            this.log.log(10000000, "readStringArray: notify(%1, %2) request", (long)n, l);
            request.done(n2, stringArray);
        } else {
            this.log.log(10000000, "readStringArray: request not found(%1, %2)", (long)n, l);
        }
    }

    public void writeArray(int n, long l, int n2) {
        this.completeWrite(n, l, n2);
    }

    public void writeBuffer(int n, long l, int n2) {
        this.completeWrite(n, l, n2);
    }

    public void writeInt(int n, long l, int n2) {
        this.completeWrite(n, l, n2);
    }

    public void writeString(int n, long l, int n2) {
        this.completeWrite(n, l, n2);
    }

    public void writeStringArray(int n, long l, int n2) {
        this.completeWrite(n, l, n2);
    }

    private void completeWrite(int n, long l, int n2) {
        Request request = this.registry.lookupRequest(n, l);
        if (request != null) {
            this.watchDog.removeFromPendingQueue(request);
            request.doneWrite(n2);
            if (n2 == 0) {
                this.statistic.writeOK(n, l);
            } else {
                this.statistic.writeError(new ProviderFailedException(n, l, new StringBuffer().append("DSI returned ERRORCODE=").append(n2).toString()));
            }
        } else {
            this.statistic.writeWarning(new ProviderFailedException(n, l, "unexpected response from DSI!"));
            this.log.log(10000000, "request(%1, %2) not found", (long)n, l);
        }
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "errorCode=%2, errorMsg=%, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    public void flushSQLDatabase(int n) {
        this.log.log(10000000, "flushSQLDatabase: errorCode=%1", (long)n);
        if (n != 0) {
            this.log.log(10000, "Failed with error code: %1", (long)n);
        }
    }

    public void getVisibleSystemLanguages(String string) {
        this.log.log(10000000, "visibleSystemLanguages=%1", (Object)string);
    }

    public void updateActiveSQLDatabaseMedium(int n, int n2) {
        this.log.log(10000000, "activeSQLDatabaseMedium=%1, validFlag=%2", (long)n, (long)n2);
    }

    public void beginTransaction(int n, int n2) {
    }

    public void endTransaction(int n, int n2) {
    }

    public void valueChangedInt(int n, long l, int n2, int n3) {
    }

    public void valueChangedString(int n, long l, String string, int n2) {
    }

    public void valueChangedArray(int n, long l, int[] nArray, int n2) {
    }

    public void valueChangedStringArray(int n, long l, String[] stringArray, int n2) {
    }

    public void valueChangedBuffer(int n, long l, byte[] byArray, int n2) {
    }

    public void unsubscribe(int n, int[] nArray, long[] lArray, int[] nArray2) {
    }

    private class Request {
        private int namespace;
        private int key;
        private int references = 0;
        private int reading = 0;
        private int writing = 0;
        private int intValue;
        private String stringValue;
        private byte[] byteArray;
        private int[] intArray;
        private String[] stringArray;
        private int errorCode;
        private long timestamp;
        private boolean readDone;

        private Request() {
        }

        public String toString() {
            return new Buffer().append("Request(Namespace=").append(this.namespace).append(", Key=").append(this.key).append(", timeout=").append(this.timestamp).append(", errorCode=").append(this.errorCode).append(')').toString();
        }

        private void reset() {
            this.reading = 0;
            this.writing = 0;
            this.errorCode = 0;
            this.timestamp = DSIStorageProvider.this.fw.getMonotonicTime();
            this.readDone = false;
            this.intValue = 0;
            this.stringValue = null;
            this.byteArray = null;
            this.intArray = null;
            this.stringArray = null;
        }

        private boolean isReading() {
            return this.reading > 0;
        }

        private boolean isWriting() {
            return this.writing > 0;
        }

        private boolean isIdle() {
            return !this.isReading() && !this.isWriting();
        }

        private Request init(int n, int n2) {
            this.namespace = n;
            this.key = n2;
            this.reset();
            return this;
        }

        synchronized boolean scheduleRead() {
            if (this.isIdle()) {
                ++this.reading;
                this.timestamp = DSIStorageProvider.this.fw.getMonotonicTime();
                DSIStorageProvider.this.log.log(10000000, "[Request#scheduleRead] no call in progress, issue a DSI Read call!");
                return true;
            }
            if (this.isReading()) {
                ++this.reading;
                DSIStorageProvider.this.log.log(10000000, "[Request#scheduleRead] read in progress, use its response!");
                return false;
            }
            ++this.reading;
            this.readDone = true;
            DSIStorageProvider.this.log.log(10000000, "[Request#scheduleRead] write in progress, use data of write as response!");
            return false;
        }

        synchronized boolean scheduleWrite() {
            if (this.isIdle()) {
                ++this.writing;
                this.timestamp = DSIStorageProvider.this.fw.getMonotonicTime();
                DSIStorageProvider.this.log.log(10000000, "[Request#scheduleWrite] no call in progress, issue a DSI write!");
                return true;
            }
            if (this.isWriting()) {
                ++this.writing;
                this.timestamp = DSIStorageProvider.this.fw.getMonotonicTime();
                DSIStorageProvider.this.log.log(10000000, "[Request#scheduleWrite] write call in progress, issue parallel DSI write call!");
                return true;
            }
            DSIStorageProvider.this.log.log(10000000, "[Request#scheduleWrite] read in progress, wait 1s");
            try {
                this.wait(1000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
            }
            return false;
        }

        synchronized boolean scheduleWrite(int n) {
            boolean bl = this.scheduleWrite();
            if (bl) {
                this.intValue = n;
            }
            return bl;
        }

        synchronized boolean scheduleWrite(String string) {
            boolean bl = this.scheduleWrite();
            if (bl) {
                this.stringValue = string;
            }
            return bl;
        }

        synchronized boolean scheduleWrite(byte[] byArray) {
            boolean bl = this.scheduleWrite();
            if (bl) {
                this.byteArray = byArray;
            }
            return bl;
        }

        synchronized boolean scheduleWrite(int[] nArray) {
            boolean bl = this.scheduleWrite();
            if (bl) {
                this.intArray = nArray;
            }
            return bl;
        }

        synchronized boolean scheduleWrite(String[] stringArray) {
            boolean bl = this.scheduleWrite();
            if (bl) {
                this.stringArray = stringArray;
            }
            return bl;
        }

        synchronized void leaveReading() {
            DSIStorageProvider.this.log.log(10000000, "[DSIStorageProvider#leaveReading]");
            --this.reading;
            if (this.isIdle()) {
                this.reset();
                this.notifyAll();
            }
        }

        synchronized void leaveWriting() {
            DSIStorageProvider.this.log.log(10000000, "[DSIStorageProvider#leaveWriting]");
            --this.writing;
            if (this.isIdle()) {
                this.reset();
                this.notifyAll();
                DSIStorageProvider.this.registry.releaseRequest(this);
            }
        }

        synchronized long getTimeToWait() {
            return this.timestamp - DSIStorageProvider.this.fw.getMonotonicTime() + (long)allowedDuration + 10L;
        }

        synchronized void waitForResponse() throws ValueMissingException, ProviderFailedException {
            while (!this.readDone) {
                long l = this.getTimeToWait();
                DSIStorageProvider.this.log.log(10000000, "[DSIStorageProvider#waitForResponse] No response yet, waiting %1ms...", l);
                if (l > 0L) {
                    try {
                        this.wait(l);
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.interrupted();
                    }
                    continue;
                }
                this.errorCode = 100;
                DSIStorageProvider.this.log.log(10000000, "[DSIStorageProvider#waitForResponse] Read request timed out! %1", (Object)this);
                throw new ProviderFailedException(this.namespace, (long)this.key, new Throwable(new StringBuffer().append("Timeout=").append(DSIStorageProvider.this.fw.getMonotonicTime() - this.timestamp).toString()));
            }
            long l = DSIStorageProvider.this.fw.getMonotonicTime() - this.timestamp;
            if (l > 50L) {
                DSIStorageProvider.this.statistic.addLongRunningRead(this.namespace, this.key, this.timestamp, DSIStorageProvider.this.fw.getMonotonicTime());
            }
            DSIStorageProvider.this.log.log(10000000, "[DSIStorageProvider#waitForResponse] Response available, errorCode: %1", (long)this.errorCode);
            if (this.errorCode != 0) {
                if (this.errorCode == 1 || this.errorCode == 2) {
                    throw new ValueMissingException(this.namespace, this.key);
                }
                DSIStorageProvider.this.log.log(100000, "[DSIStorageProvider#waitForResponse] Read request %1 failed with error code %2", (Object)this, (long)this.errorCode);
                throw new ProviderFailedException(this.namespace, (long)this.key, new Throwable(new StringBuffer().append("ErrorCode=").append(this.errorCode).toString()));
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        int getIntResult() {
            try {
                this.waitForResponse();
                int n = this.intValue;
                return n;
            }
            finally {
                this.leaveReading();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        String getStringResult() {
            try {
                this.waitForResponse();
                String string = this.stringValue;
                return string;
            }
            finally {
                this.leaveReading();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        byte[] getByteArrayResult() {
            try {
                this.waitForResponse();
                byte[] byArray = this.byteArray;
                return byArray;
            }
            finally {
                this.leaveReading();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        int[] getIntArrayResult() {
            try {
                this.waitForResponse();
                int[] nArray = this.intArray;
                return nArray;
            }
            finally {
                this.leaveReading();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        String[] getStringArrayResult() {
            try {
                this.waitForResponse();
                String[] stringArray = this.stringArray;
                return stringArray;
            }
            finally {
                this.leaveReading();
            }
        }

        synchronized void doneRead(int n) {
            DSIStorageProvider.this.log.log(10000000, "[DSIStorageProvider#doneRead]");
            if (this.isReading()) {
                this.readDone = true;
                this.errorCode = n;
                this.notifyAll();
            }
        }

        synchronized void doneWrite(int n) {
            DSIStorageProvider.this.log.log(10000000, "[DSIStorageProvider#doneWrite]");
            if (this.isWriting()) {
                this.errorCode = n;
                if (n == 100 && this.writing > 1) {
                    this.writing = 1;
                }
                this.leaveWriting();
                if (FlushValuesDict.isFlushRequired(this.namespace, this.key)) {
                    DSIStorageProvider.this.flush(this.namespace, this.key);
                }
            }
        }

        void done(int n, int n2) {
            this.intValue = n2;
            this.doneRead(n);
        }

        void done(int n, int[] nArray) {
            this.intArray = nArray;
            this.doneRead(n);
        }

        void done(int n, String string) {
            this.stringValue = string;
            this.doneRead(n);
        }

        void done(int n, String[] stringArray) {
            this.stringArray = stringArray;
            this.doneRead(n);
        }

        void done(int n, byte[] byArray) {
            this.byteArray = byArray;
            this.doneRead(n);
        }
    }

    private class RequestRegistry {
        private Map namespaces = new HashMap();

        private RequestRegistry() {
        }

        private Map getNamespace(int n) {
            HashMap hashMap = (HashMap)this.namespaces.get(new Integer(n));
            if (hashMap == null) {
                hashMap = new HashMap();
                this.namespaces.put(new Integer(n), hashMap);
            }
            return hashMap;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void releaseRequest(Request request) {
            Map map = this.namespaces;
            synchronized (map) {
                request.references--;
                if (request.references == 0) {
                    this.getNamespace(request.namespace).remove(new Long(request.key));
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        Request lookupRequest(int n, long l) {
            Map map = this.namespaces;
            synchronized (map) {
                return (Request)this.getNamespace(n).get(new Long(l));
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        Request getRequest(int n, int n2) {
            Map map = this.namespaces;
            synchronized (map) {
                Request request = this.lookupRequest(n, n2);
                if (request == null) {
                    request = new Request().init(n, n2);
                    this.getNamespace(n).put(new Long(n2), request);
                }
                request.references++;
                return request;
            }
        }
    }

    private class StorageWatchDog
    implements Runnable {
        private boolean active;
        private final List pendingQueue = new ArrayList(10);

        private StorageWatchDog() {
        }

        private synchronized void addToPendingQueue(Request request) {
            DSIStorageProvider.this.log.log(10000000, "[StorageWatchDog#addToPendingQueue]");
            this.pendingQueue.add(request);
            this.notifyAll();
        }

        private synchronized void removeFromPendingQueue(Request request) {
            DSIStorageProvider.this.log.log(10000000, "[StorageWatchDog#removeFromPendingQueue]");
            this.pendingQueue.remove(request);
            this.notifyAll();
        }

        private synchronized void stop() {
            this.active = false;
            this.notifyAll();
        }

        private synchronized void start() {
            DSIStorageProvider.this.fw.getHMIThreadPool().execute(this);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            Thread.currentThread().setName(new StringBuffer().append(Thread.currentThread().getName()).append("StorageWatchDog").toString());
            this.active = true;
            while (this.active) {
                long l = 10000L;
                StorageWatchDog storageWatchDog = this;
                synchronized (storageWatchDog) {
                    if (!this.pendingQueue.isEmpty()) {
                        l = ((Request)this.pendingQueue.get(0)).getTimeToWait();
                        DSIStorageProvider.this.log.log(10000000, "WatchDog: next timeout in %1 ms", l);
                    } else {
                        DSIStorageProvider.this.log.log(10000000, "WatchDog: no pending request, waiting %1 ms", l);
                    }
                    if (l > 0L) {
                        try {
                            this.wait(l);
                        }
                        catch (InterruptedException interruptedException) {
                            Thread.interrupted();
                        }
                    } else {
                        Request request = (Request)this.pendingQueue.remove(0);
                        DSIStorageProvider.this.log.log(10000000, "WatchDog: request timed out! %1", (Object)request);
                        request.doneWrite(100);
                    }
                }
            }
        }
    }
}

