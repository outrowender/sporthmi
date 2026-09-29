/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import de.audi.app.terminalmode.util.IStreamableStorageContainer;
import de.audi.app.terminalmode.util.Streamable$Creator;
import de.audi.app.terminalmode.util.StreamableStorageContainer$ReadOperation;
import de.audi.app.terminalmode.util.StreamableStorageContainer$WriteOperation;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import java.util.List;

public class StreamableStorageContainer
implements IStreamableStorageContainer {
    private static final int VERSION;
    private final String LOGTAG;
    private final int namespace;
    private final int key;
    private final LogChannel lc;
    private final IStorageAccess storageAccess;
    private final int byteArraySizeWarningLimit;

    public StreamableStorageContainer(IStorageAccess iStorageAccess, LogChannel logChannel, int n, int n2, int n3) {
        this.lc = logChannel;
        this.namespace = n;
        this.key = n2;
        this.storageAccess = iStorageAccess;
        this.LOGTAG = new StringBuffer().append("StreamableStorageContainer[").append(n).append(", ").append(n2).append("]").toString();
        this.byteArraySizeWarningLimit = (int)((float)n3 * 16447);
    }

    public StreamableStorageContainer(IStorageAccess iStorageAccess, LogChannel logChannel, int n, int n2) {
        this(iStorageAccess, logChannel, n, n2, -129);
    }

    @Override
    public List readListFromStorage(Streamable$Creator streamable$Creator) {
        return new StreamableStorageContainer$ReadOperation(this, streamable$Creator).readObjects();
    }

    @Override
    public void writeListToStorage(List list) {
        new StreamableStorageContainer$WriteOperation(this, list).serializeAndWrite();
    }

    static /* synthetic */ IStorageAccess access$000(StreamableStorageContainer streamableStorageContainer) {
        return streamableStorageContainer.storageAccess;
    }

    static /* synthetic */ int access$100(StreamableStorageContainer streamableStorageContainer) {
        return streamableStorageContainer.namespace;
    }

    static /* synthetic */ int access$200(StreamableStorageContainer streamableStorageContainer) {
        return streamableStorageContainer.key;
    }

    static /* synthetic */ String access$300(StreamableStorageContainer streamableStorageContainer) {
        return streamableStorageContainer.LOGTAG;
    }

    static /* synthetic */ LogChannel access$400(StreamableStorageContainer streamableStorageContainer) {
        return streamableStorageContainer.lc;
    }

    static /* synthetic */ int access$500(StreamableStorageContainer streamableStorageContainer) {
        return streamableStorageContainer.byteArraySizeWarningLimit;
    }
}

