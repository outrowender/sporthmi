/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import de.audi.app.terminalmode.util.IStreamableStorageContainer;
import de.audi.app.terminalmode.util.Streamable;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StreamableStorageContainer
implements IStreamableStorageContainer {
    private static final int VERSION = 1;
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
        this.byteArraySizeWarningLimit = (int)((float)n3 * 0.75f);
    }

    public StreamableStorageContainer(IStorageAccess iStorageAccess, LogChannel logChannel, int n, int n2) {
        this(iStorageAccess, logChannel, n, n2, Integer.MAX_VALUE);
    }

    public List readListFromStorage(Streamable.Creator creator) {
        return new ReadOperation(creator).readObjects();
    }

    public void writeListToStorage(List list) {
        new WriteOperation(list).serializeAndWrite();
    }

    private class ReadOperation
    extends DefaultOperation {
        private final Streamable.Creator creator;
        private final ArrayList list;

        public ReadOperation(Streamable.Creator creator) {
            super(StreamableStorageContainer.this.storageAccess, 1, StreamableStorageContainer.this.namespace, StreamableStorageContainer.this.key);
            this.creator = creator;
            this.list = new ArrayList();
        }

        public List readObjects() {
            this.readAndDeserialize();
            return Collections.unmodifiableList(this.list);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            try {
                int n = dataInputStream.readInt();
                this.list.ensureCapacity(n);
                for (int i2 = 0; i2 < n; ++i2) {
                    this.list.add(this.creator.readFromStream(dataInputStream));
                }
            }
            catch (Exception exception) {
                StreamableStorageContainer.this.lc.log(10000, "[%1.deserialize] failed to deserialize with %2, data format mismatch???", (Object)StreamableStorageContainer.this.LOGTAG, (Object)this.creator.getClass());
            }
        }
    }

    private class WriteOperation
    extends DefaultOperation {
        private final List list;

        public WriteOperation(List list) {
            super(StreamableStorageContainer.this.storageAccess, 1, StreamableStorageContainer.this.namespace, StreamableStorageContainer.this.key);
            this.list = list;
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(this.list.size());
            Iterator iterator = this.list.iterator();
            while (iterator.hasNext()) {
                Streamable streamable = (Streamable)iterator.next();
                streamable.writeToStream(dataOutputStream);
            }
            StreamableStorageContainer.this.lc.log(10000000, "[%1.serialize] wrote %2 items using %3 bytes.", (Object)StreamableStorageContainer.this.LOGTAG, (long)this.list.size(), (long)dataOutputStream.size());
            if (dataOutputStream.size() > StreamableStorageContainer.this.byteArraySizeWarningLimit) {
                StreamableStorageContainer.this.lc.log(100000, "[%1.serialize] Closing to the limit of %2", (Object)StreamableStorageContainer.this.LOGTAG, (long)StreamableStorageContainer.this.byteArraySizeWarningLimit);
            }
        }
    }

    private class DefaultOperation
    extends AbstractStorageDataContainer {
        public DefaultOperation(IStorageAccess iStorageAccess, int n, int n2, int n3) {
            super(iStorageAccess, n, n2, n3);
        }

        protected void handleCRC32Error() {
            StreamableStorageContainer.this.lc.log(10000, "[%1.handleCRC32Error]", (Object)StreamableStorageContainer.this.LOGTAG);
        }

        protected void handleStorageReadError(Exception exception) {
            StreamableStorageContainer.this.lc.log(100000, "[%1.handleStorageReadError] %2", (Object)StreamableStorageContainer.this.LOGTAG, (Object)exception.getMessage());
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            StreamableStorageContainer.this.lc.log(100000, "[%1.convertContainer] NOT SUPPORTED! persisted:%2 container:%3", (Object)StreamableStorageContainer.this.LOGTAG, (long)n, (long)n2);
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            throw new UnsupportedOperationException("override serialize if writing!");
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            throw new UnsupportedOperationException("override deserialize if reading!");
        }
    }
}

