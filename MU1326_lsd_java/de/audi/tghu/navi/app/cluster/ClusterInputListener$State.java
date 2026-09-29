/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.cluster.ClusterInputListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClusterInputListener$State
extends PersistentState {
    public static final int VERSION;
    public static final int KEY;
    private NavigationEnv naviEnv;
    private int favoredViewMode;

    public ClusterInputListener$State(IStorageAccess iStorageAccess, LogChannel logChannel, NavigationEnv navigationEnv) {
        super(iStorageAccess, 1, 1004, 860, logChannel);
        this.naviEnv = navigationEnv;
    }

    @Override
    protected void initWithDefaultValues() {
        this.favoredViewMode = ClusterInputListener.access$000(this.naviEnv);
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.favoredViewMode = iStorageAccess.getInt(1004, 290, ClusterInputListener.access$000(this.naviEnv));
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.favoredViewMode);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.favoredViewMode = dataInputStream.readInt();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.getLogChannel().log(-2137614336, "ClusterInputListener.State#convertContainer( %1, %2 )", (long)n, (long)n2);
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.favoredViewMode = dataInputStream.readInt();
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "ClusterInputListener.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public int getFavoredViewMode() {
        return this.favoredViewMode;
    }

    public void setFavoredViewMode(int n) {
        this.favoredViewMode = n;
    }
}

