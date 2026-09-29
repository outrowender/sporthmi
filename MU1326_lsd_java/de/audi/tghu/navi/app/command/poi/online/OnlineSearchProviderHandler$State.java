/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class OnlineSearchProviderHandler$State
extends PersistentState {
    public static final int VERSION;
    public static final int KEY;
    private String poiOnlineProvider;

    public OnlineSearchProviderHandler$State(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 1, 1004, 890, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.poiOnlineProvider = "Google";
        if (Util.isHURegionCN()) {
            this.poiOnlineProvider = "AutoNavi";
        }
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        String string = "Google";
        if (Util.isHURegionCN()) {
            string = "AutoNavi";
        }
        this.poiOnlineProvider = iStorageAccess.getString(1004, 800, string);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeUTF(this.poiOnlineProvider);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.poiOnlineProvider = dataInputStream.readUTF();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.getLogChannel().log(-2137614336, "OnlineSearchService.State#convertContainer( %1, %2 )", (long)n, (long)n2);
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.poiOnlineProvider = dataInputStream.readUTF();
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "OnlineSearchService.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public String getPoiOnlineProvider() {
        return this.poiOnlineProvider;
    }

    public void setPoiOnlineProvider(String string) {
        this.poiOnlineProvider = string;
    }
}

