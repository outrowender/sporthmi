/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.lists.NormAreaSublist;
import de.audi.tv.app.lists.NormAreaSublist$Key;
import java.io.DataInputStream;
import java.io.DataOutputStream;

class NormAreaSublist$StorageDataContainer
extends AbstractStorageDataContainer {
    private final /* synthetic */ NormAreaSublist this$0;

    NormAreaSublist$StorageDataContainer(NormAreaSublist normAreaSublist, IStorageAccess iStorageAccess) {
        this.this$0 = normAreaSublist;
        super(iStorageAccess, 1, 1007, 49);
    }

    @Override
    protected void handleCRC32Error() {
        NormAreaSublist.access$100(this.this$0).log(10000, "[NormAreaStore.handleCRC32Error]");
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        NormAreaSublist.access$100(this.this$0).log(-1601830656, "[NormAreaStore.handleStorageReadError] %1", (Object)exception.toString());
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        NormAreaSublist.access$100(this.this$0).log(-1601830656, "[NormAreaStore.convertContainer] persistedVersion:%1 containerVersion:%2", (long)n, (long)n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        NormAreaSublist normAreaSublist = this.this$0;
        synchronized (normAreaSublist) {
            int n = NormAreaSublist.access$200(this.this$0).size();
            NormAreaSublist$Key[] normAreaSublist$KeyArray = (NormAreaSublist$Key[])NormAreaSublist.access$200(this.this$0).keySet().toArray(new NormAreaSublist$Key[n]);
            Integer[] integerArray = (Integer[])NormAreaSublist.access$200(this.this$0).values().toArray(new Integer[n]);
            dataOutputStream.writeInt(n);
            for (int i2 = 0; i2 < n; ++i2) {
                dataOutputStream.writeLong(normAreaSublist$KeyArray[i2].namePID);
                dataOutputStream.writeInt(normAreaSublist$KeyArray[i2].servicePID);
                dataOutputStream.writeInt(normAreaSublist$KeyArray[i2].sType);
                dataOutputStream.writeInt(integerArray[i2]);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        NormAreaSublist normAreaSublist = this.this$0;
        synchronized (normAreaSublist) {
            NormAreaSublist.access$200(this.this$0).clear();
            int n = dataInputStream.readInt();
            for (int i2 = 0; i2 < n; ++i2) {
                long l = dataInputStream.readLong();
                int n2 = dataInputStream.readInt();
                int n3 = dataInputStream.readInt();
                int n4 = dataInputStream.readInt();
                NormAreaSublist.access$200(this.this$0).put(new NormAreaSublist$Key(l, n2, n3), new Integer(n4));
            }
        }
    }
}

