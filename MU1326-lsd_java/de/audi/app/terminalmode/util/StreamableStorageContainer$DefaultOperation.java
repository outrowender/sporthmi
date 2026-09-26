/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import de.audi.app.terminalmode.util.StreamableStorageContainer;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import java.io.DataInputStream;
import java.io.DataOutputStream;

class StreamableStorageContainer$DefaultOperation
extends AbstractStorageDataContainer {
    private final /* synthetic */ StreamableStorageContainer this$0;

    public StreamableStorageContainer$DefaultOperation(StreamableStorageContainer streamableStorageContainer, IStorageAccess iStorageAccess, int n, int n2, int n3) {
        this.this$0 = streamableStorageContainer;
        super(iStorageAccess, n, n2, n3);
    }

    @Override
    protected void handleCRC32Error() {
        StreamableStorageContainer.access$400(this.this$0).log(10000, "[%1.handleCRC32Error]", (Object)StreamableStorageContainer.access$300(this.this$0));
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        StreamableStorageContainer.access$400(this.this$0).log(-1601830656, "[%1.handleStorageReadError] %2", (Object)StreamableStorageContainer.access$300(this.this$0), (Object)exception.getMessage());
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        StreamableStorageContainer.access$400(this.this$0).log(-1601830656, "[%1.convertContainer] NOT SUPPORTED! persisted:%2 container:%3", (Object)StreamableStorageContainer.access$300(this.this$0), (long)n, (long)n2);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        throw new UnsupportedOperationException("override serialize if writing!");
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        throw new UnsupportedOperationException("override deserialize if reading!");
    }
}

