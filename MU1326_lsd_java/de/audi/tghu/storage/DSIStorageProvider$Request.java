/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storage;

import de.audi.atip.storage.ProviderFailedException;
import de.audi.atip.storage.ValueMissingException;
import de.audi.tghu.storage.DSIStorageProvider;
import de.audi.tghu.storage.DSIStorageProvider$1;
import de.audi.tghu.storage.FlushValuesDict;
import de.esolutions.fw.util.commons.Buffer;

class DSIStorageProvider$Request {
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
    private final /* synthetic */ DSIStorageProvider this$0;

    private DSIStorageProvider$Request(DSIStorageProvider dSIStorageProvider) {
        this.this$0 = dSIStorageProvider;
    }

    public String toString() {
        return new Buffer().append("Request(Namespace=").append(this.namespace).append(", Key=").append(this.key).append(", timeout=").append(this.timestamp).append(", errorCode=").append(this.errorCode).append(')').toString();
    }

    private void reset() {
        this.reading = 0;
        this.writing = 0;
        this.errorCode = 0;
        this.timestamp = DSIStorageProvider.access$800(this.this$0).getMonotonicTime();
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

    private DSIStorageProvider$Request init(int n, int n2) {
        this.namespace = n;
        this.key = n2;
        this.reset();
        return this;
    }

    synchronized boolean scheduleRead() {
        if (this.isIdle()) {
            ++this.reading;
            this.timestamp = DSIStorageProvider.access$800(this.this$0).getMonotonicTime();
            DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[Request#scheduleRead] no call in progress, issue a DSI Read call!");
            return true;
        }
        if (this.isReading()) {
            ++this.reading;
            DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[Request#scheduleRead] read in progress, use its response!");
            return false;
        }
        ++this.reading;
        this.readDone = true;
        DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[Request#scheduleRead] write in progress, use data of write as response!");
        return false;
    }

    synchronized boolean scheduleWrite() {
        if (this.isIdle()) {
            ++this.writing;
            this.timestamp = DSIStorageProvider.access$800(this.this$0).getMonotonicTime();
            DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[Request#scheduleWrite] no call in progress, issue a DSI write!");
            return true;
        }
        if (this.isWriting()) {
            ++this.writing;
            this.timestamp = DSIStorageProvider.access$800(this.this$0).getMonotonicTime();
            DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[Request#scheduleWrite] write call in progress, issue parallel DSI write call!");
            return true;
        }
        DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[Request#scheduleWrite] read in progress, wait 1s");
        try {
            super.wait(0);
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
        DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[DSIStorageProvider#leaveReading]");
        --this.reading;
        if (this.isIdle()) {
            this.reset();
            super.notifyAll();
        }
    }

    synchronized void leaveWriting() {
        DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[DSIStorageProvider#leaveWriting]");
        --this.writing;
        if (this.isIdle()) {
            this.reset();
            super.notifyAll();
            DSIStorageProvider.access$1000(this.this$0).releaseRequest(this);
        }
    }

    synchronized long getTimeToWait() {
        long l = this.timestamp - DSIStorageProvider.access$800(this.this$0).getMonotonicTime() + (long)DSIStorageProvider.access$1100() + 0;
    }

    synchronized void waitForResponse() {
        while (!this.readDone) {
            long l = this.getTimeToWait();
            DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[DSIStorageProvider#waitForResponse] No response yet, waiting %1ms...", l);
            if (l > 0L) {
                try {
                    super.wait(l);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
                continue;
            }
            this.errorCode = 100;
            DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[DSIStorageProvider#waitForResponse] Read request timed out! %1", (Object)this);
            throw new ProviderFailedException(this.namespace, (long)this.key, new Throwable(new StringBuffer().append("Timeout=").append(DSIStorageProvider.access$800(this.this$0).getMonotonicTime() - this.timestamp).toString()));
        }
        long l = DSIStorageProvider.access$800(this.this$0).getMonotonicTime() - this.timestamp;
        if (l > 0) {
            DSIStorageProvider.access$1200(this.this$0).addLongRunningRead(this.namespace, this.key, this.timestamp, DSIStorageProvider.access$800(this.this$0).getMonotonicTime());
        }
        DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[DSIStorageProvider#waitForResponse] Response available, errorCode: %1", (long)this.errorCode);
        if (this.errorCode != 0) {
            if (this.errorCode == 1 || this.errorCode == 2) {
                throw new ValueMissingException(this.namespace, this.key);
            }
            DSIStorageProvider.access$900(this.this$0).log(-1601830656, "[DSIStorageProvider#waitForResponse] Read request %1 failed with error code %2", (Object)this, (long)this.errorCode);
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
        DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[DSIStorageProvider#doneRead]");
        if (this.isReading()) {
            this.readDone = true;
            this.errorCode = n;
            super.notifyAll();
        }
    }

    synchronized void doneWrite(int n) {
        DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[DSIStorageProvider#doneWrite]");
        if (this.isWriting()) {
            this.errorCode = n;
            if (n == 100 && this.writing > 1) {
                this.writing = 1;
            }
            this.leaveWriting();
            if (FlushValuesDict.isFlushRequired(this.namespace, this.key)) {
                DSIStorageProvider.access$1300(this.this$0, this.namespace, this.key);
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

    static /* synthetic */ int access$400(DSIStorageProvider$Request dSIStorageProvider$Request) {
        return dSIStorageProvider$Request.namespace;
    }

    static /* synthetic */ int access$500(DSIStorageProvider$Request dSIStorageProvider$Request) {
        return dSIStorageProvider$Request.key;
    }

    static /* synthetic */ int access$1410(DSIStorageProvider$Request dSIStorageProvider$Request) {
        return dSIStorageProvider$Request.references--;
    }

    static /* synthetic */ int access$1400(DSIStorageProvider$Request dSIStorageProvider$Request) {
        return dSIStorageProvider$Request.references;
    }

    /* synthetic */ DSIStorageProvider$Request(DSIStorageProvider dSIStorageProvider, DSIStorageProvider$1 dSIStorageProvider$1) {
        this(dSIStorageProvider);
    }

    static /* synthetic */ DSIStorageProvider$Request access$1600(DSIStorageProvider$Request dSIStorageProvider$Request, int n, int n2) {
        return dSIStorageProvider$Request.init(n, n2);
    }

    static /* synthetic */ int access$1408(DSIStorageProvider$Request dSIStorageProvider$Request) {
        return dSIStorageProvider$Request.references++;
    }
}

