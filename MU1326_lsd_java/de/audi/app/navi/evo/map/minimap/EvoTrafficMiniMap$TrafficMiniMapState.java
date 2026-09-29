/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.minimap;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EvoTrafficMiniMap$TrafficMiniMapState
extends PersistentState {
    public static final int VERSION;
    public static final int KEY;
    private boolean active;

    public EvoTrafficMiniMap$TrafficMiniMapState(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 1, 1004, 1041, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.active = false;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.active = iStorageAccess.getBoolean(1004, 1041, false);
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.deserialize(dataInputStream);
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "TrafficMiniMapState#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeBoolean(this.active);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.active = dataInputStream.readBoolean();
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean bl) {
        this.active = bl;
    }
}

