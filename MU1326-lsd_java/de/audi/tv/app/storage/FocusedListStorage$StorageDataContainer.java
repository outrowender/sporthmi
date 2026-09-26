/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.storage.FocusedListStorage;
import java.io.DataInputStream;
import java.io.DataOutputStream;

class FocusedListStorage$StorageDataContainer
extends AbstractStorageDataContainer {
    private final /* synthetic */ FocusedListStorage this$0;

    public FocusedListStorage$StorageDataContainer(FocusedListStorage focusedListStorage, IStorageAccess iStorageAccess) {
        this.this$0 = focusedListStorage;
        super(iStorageAccess, 1, 1007, 2);
    }

    @Override
    protected void handleCRC32Error() {
        FocusedListStorage.access$000(this.this$0).log(10000, "[ActiveListStorage.handleCRC32Error]");
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        FocusedListStorage.access$000(this.this$0).log(-1601830656, "[ActiveListStorage.handleStorageReadError] %1", (Object)exception.getMessage());
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        FocusedListStorage.access$000(this.this$0).log(1078071040, "[ActiveListStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        FocusedListStorage.access$000(this.this$0).log(-2137614336, "[ActiveListStorage.serialize] focused list: %1", (long)FocusedListStorage.access$100(this.this$0));
        dataOutputStream.writeInt(FocusedListStorage.access$100(this.this$0));
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        FocusedListStorage.access$102(this.this$0, dataInputStream.readInt());
        FocusedListStorage.access$000(this.this$0).log(-2137614336, "[ActiveListStorage.deserialize] focused list: %1", (long)FocusedListStorage.access$100(this.this$0));
    }
}

