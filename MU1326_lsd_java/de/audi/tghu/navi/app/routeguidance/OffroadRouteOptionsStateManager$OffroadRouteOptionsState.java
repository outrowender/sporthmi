/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.routeguidance.OffroadRouteOptionsStateManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class OffroadRouteOptionsStateManager$OffroadRouteOptionsState
extends PersistentState {
    public static final int OFFORAD_ROUTE_OPTIONS_DEFAULT;
    private static final int VERSION;
    private static final int KEY;
    private int offroadRouteOptions;
    private final /* synthetic */ OffroadRouteOptionsStateManager this$0;

    public OffroadRouteOptionsStateManager$OffroadRouteOptionsState(OffroadRouteOptionsStateManager offroadRouteOptionsStateManager, IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.this$0 = offroadRouteOptionsStateManager;
        super(iStorageAccess, 1, 1004, 1044, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.offroadRouteOptions = 1;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.offroadRouteOptions);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.offroadRouteOptions = dataInputStream.readInt();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.logChannel.log(-2137614336, "OffroadRouteOptionsState#convertContainer( %1, %2 )", (long)n, (long)n2);
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.offroadRouteOptions = dataInputStream.readInt();
            }
        }
        catch (IOException iOException) {
            this.logChannel.log(10000, "OffroadRouteOptionsState#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public int getDsiRouteOptionOffRoad() {
        return this.offroadRouteOptions;
    }

    public void setDsiRouteOptionOffRoad(int n) {
        this.offroadRouteOptions = n;
    }
}

