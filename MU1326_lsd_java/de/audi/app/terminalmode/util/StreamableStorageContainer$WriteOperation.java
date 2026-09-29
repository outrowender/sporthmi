/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import de.audi.app.terminalmode.util.Streamable;
import de.audi.app.terminalmode.util.StreamableStorageContainer;
import de.audi.app.terminalmode.util.StreamableStorageContainer$DefaultOperation;
import java.io.DataOutputStream;
import java.util.Iterator;
import java.util.List;

class StreamableStorageContainer$WriteOperation
extends StreamableStorageContainer$DefaultOperation {
    private final List list;
    private final /* synthetic */ StreamableStorageContainer this$0;

    public StreamableStorageContainer$WriteOperation(StreamableStorageContainer streamableStorageContainer, List list) {
        this.this$0 = streamableStorageContainer;
        super(streamableStorageContainer, StreamableStorageContainer.access$000(streamableStorageContainer), 1, StreamableStorageContainer.access$100(streamableStorageContainer), StreamableStorageContainer.access$200(streamableStorageContainer));
        this.list = list;
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.list.size());
        Iterator iterator = this.list.iterator();
        while (iterator.hasNext()) {
            Streamable streamable = (Streamable)iterator.next();
            streamable.writeToStream(dataOutputStream);
        }
        StreamableStorageContainer.access$400(this.this$0).log(-2137614336, "[%1.serialize] wrote %2 items using %3 bytes.", (Object)StreamableStorageContainer.access$300(this.this$0), (long)this.list.size(), (long)dataOutputStream.size());
        if (dataOutputStream.size() > StreamableStorageContainer.access$500(this.this$0)) {
            StreamableStorageContainer.access$400(this.this$0).log(-1601830656, "[%1.serialize] Closing to the limit of %2", (Object)StreamableStorageContainer.access$300(this.this$0), (long)StreamableStorageContainer.access$500(this.this$0));
        }
    }
}

