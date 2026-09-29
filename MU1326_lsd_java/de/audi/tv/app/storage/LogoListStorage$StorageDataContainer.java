/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.tv.app.storage.LogoListStorage;
import de.audi.tv.app.storage.ServiceStoreHelper;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import org.dsi.ifc.tvtuner.LogoInfo;

class LogoListStorage$StorageDataContainer
extends AbstractStorageDataContainer {
    private LogoInfo[] rows;
    private final /* synthetic */ LogoListStorage this$0;

    LogoListStorage$StorageDataContainer(LogoListStorage logoListStorage) {
        this.this$0 = logoListStorage;
        super(LogoListStorage.access$100(logoListStorage), 1, 1007, 3);
        this.rows = LogoListStorage.access$000(this.this$0);
    }

    @Override
    protected void handleCRC32Error() {
        LogoListStorage.access$200(this.this$0).log(10000, "[LogoListStorage.handleCRC32Error]");
        this.rows = LogoListStorage.access$000(this.this$0);
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        LogoListStorage.access$200(this.this$0).log(-1601830656, "[LogoListStorage.handleStorageReadError] %1", (Object)exception.getMessage());
        this.rows = LogoListStorage.access$000(this.this$0);
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        LogoListStorage.access$200(this.this$0).log(1078071040, "[LogoListStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
        this.rows = LogoListStorage.access$000(this.this$0);
    }

    void setRows(LogoInfo[] logoInfoArray) {
        this.rows = logoInfoArray;
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        LogoListStorage.access$200(this.this$0).log(-2137614336, "[LogoListStorage.serialize]");
        dataOutputStream.writeInt(this.rows.length);
        for (int i2 = 0; i2 < this.rows.length; ++i2) {
            boolean bl = this.rows[i2] != null;
            dataOutputStream.writeBoolean(bl);
            if (!bl) continue;
            ServiceStoreHelper.serializeLogo(this.rows[i2], dataOutputStream);
        }
    }

    LogoInfo[] getRows() {
        return this.rows;
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        LogoListStorage.access$200(this.this$0).log(-2137614336, "[LogoListStorage.deserialize]");
        int n = dataInputStream.readInt();
        if (n != 50) {
            LogoListStorage.access$200(this.this$0).log(-1601830656, "[LogoListStorage.deserialize] List size mismatch! stored:%1 expected:%2", (long)n, (long)0);
            return;
        }
        this.rows = new LogoInfo[n];
        for (int i2 = 0; i2 < this.rows.length; ++i2) {
            boolean bl = dataInputStream.readBoolean();
            if (!bl) continue;
            this.rows[i2] = ServiceStoreHelper.deserializeLogo(dataInputStream);
        }
    }
}

