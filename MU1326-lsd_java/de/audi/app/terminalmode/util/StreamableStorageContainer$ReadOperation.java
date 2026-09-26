/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import de.audi.app.terminalmode.util.Streamable$Creator;
import de.audi.app.terminalmode.util.StreamableStorageContainer;
import de.audi.app.terminalmode.util.StreamableStorageContainer$DefaultOperation;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StreamableStorageContainer$ReadOperation
extends StreamableStorageContainer$DefaultOperation {
    private final Streamable$Creator creator;
    private final ArrayList list;
    private final /* synthetic */ StreamableStorageContainer this$0;

    public StreamableStorageContainer$ReadOperation(StreamableStorageContainer streamableStorageContainer, Streamable$Creator streamable$Creator) {
        this.this$0 = streamableStorageContainer;
        super(streamableStorageContainer, StreamableStorageContainer.access$000(streamableStorageContainer), 1, StreamableStorageContainer.access$100(streamableStorageContainer), StreamableStorageContainer.access$200(streamableStorageContainer));
        this.creator = streamable$Creator;
        this.list = new ArrayList();
    }

    public List readObjects() {
        this.readAndDeserialize();
        return Collections.unmodifiableList(this.list);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        try {
            int n = dataInputStream.readInt();
            this.list.ensureCapacity(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.list.add(this.creator.readFromStream(dataInputStream));
            }
        }
        catch (Exception exception) {
            StreamableStorageContainer.access$400(this.this$0).log(10000, "[%1.deserialize] failed to deserialize with %2, data format mismatch???", (Object)StreamableStorageContainer.access$300(this.this$0), (Object)super.getClass());
        }
    }
}

