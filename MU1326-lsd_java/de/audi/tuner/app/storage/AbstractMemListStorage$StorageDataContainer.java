/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.storage.AbstractMemListStorage;
import java.io.DataInputStream;
import java.io.DataOutputStream;

class AbstractMemListStorage$StorageDataContainer
extends AbstractStorageDataContainer {
    private AbstractMemoryRow[] rows;
    private final /* synthetic */ AbstractMemListStorage this$0;

    AbstractMemListStorage$StorageDataContainer(AbstractMemListStorage abstractMemListStorage, int n) {
        this.this$0 = abstractMemListStorage;
        super(AbstractMemListStorage.access$000(abstractMemListStorage), 8, 1001, n);
        this.rows = this.this$0.getDefaultList();
    }

    @Override
    protected void handleCRC32Error() {
        AbstractMemListStorage.access$100(this.this$0).log(10000, "[AbstractMemListStorage.handleCRC32Error]");
        this.rows = this.this$0.getDefaultList();
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        AbstractMemListStorage.access$100(this.this$0).log(10000, "[AbstractMemListStorage.handleStorageReadError] %1", (Object)exception.getMessage());
        AbstractMemListStorage.access$100(this.this$0).log(-1601830656, "[AbstractMemListStorage.handleStorageReadError]", (Throwable)exception);
        this.rows = this.this$0.getDefaultList();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        AbstractMemListStorage.access$100(this.this$0).log(1078071040, "[AbstractMemListStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
        this.deserialize(dataInputStream, n);
    }

    void setRows(AbstractMemoryRow[] abstractMemoryRowArray) {
        this.rows = abstractMemoryRowArray;
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        AbstractMemListStorage.access$100(this.this$0).log(-2137614336, "[AbstractMemListStorage.serialize]");
        dataOutputStream.writeInt(this.rows.length);
        for (int i2 = 0; i2 < this.rows.length; ++i2) {
            AbstractMemListStorage.access$200(this.this$0, this.rows[i2], dataOutputStream);
        }
    }

    AbstractMemoryRow[] getRows() {
        return this.rows;
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        AbstractMemListStorage.access$100(this.this$0).log(-2137614336, "[AbstractMemListStorage.deserialize]");
        this.deserialize(dataInputStream, 8);
    }

    private void deserialize(DataInputStream dataInputStream, int n) {
        AbstractMemListStorage.access$100(this.this$0).log(-2137614336, "[AbstractMemListStorage.deserialize]");
        int n2 = dataInputStream.readInt();
        this.rows = new AbstractMemoryRow[n2];
        for (int i2 = 0; i2 < this.rows.length; ++i2) {
            int n3 = dataInputStream.readInt();
            this.rows[i2] = AbstractMemListStorage.access$300(this.this$0, i2, n3, dataInputStream, n);
        }
    }
}

