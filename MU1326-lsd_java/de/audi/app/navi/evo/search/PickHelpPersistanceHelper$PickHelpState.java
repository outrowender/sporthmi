/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.PickHelpPersistanceHelper;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PickHelpPersistanceHelper$PickHelpState
extends PersistentState {
    public static final int VERSION;
    private int serializedPickHelpState;
    private NavigationEnv navEnv;

    public PickHelpPersistanceHelper$PickHelpState(IStorageAccess iStorageAccess, NavigationEnv navigationEnv, LogChannel logChannel, int n) {
        super(iStorageAccess, 2, 1004, n, logChannel);
        this.navEnv = navigationEnv;
    }

    public void setPickHelpState(int n) {
        this.serializedPickHelpState = n;
    }

    public int getPickHelpState() {
        return PickHelpPersistanceHelper.getPickHelpStateDefault(this.navEnv.getFramework());
    }

    @Override
    protected void initWithDefaultValues() {
        this.serializedPickHelpState = PickHelpPersistanceHelper.getPickHelpStateDefault(this.navEnv.getFramework());
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.serializedPickHelpState = PickHelpPersistanceHelper.getPickHelpStateDefault(this.navEnv.getFramework());
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
            this.getLogChannel().log(10000, "%1.PickHelpState#convertContainer - error on converting the persistent state format", (Object)"PickHelpPersistanceHelper", (Throwable)iOException);
        }
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        if (this.serializedPickHelpState > 1 || this.serializedPickHelpState < 0) {
            dataOutputStream.writeInt(-1);
        } else {
            dataOutputStream.writeInt(this.serializedPickHelpState);
        }
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.serializedPickHelpState = PickHelpPersistanceHelper.getPickHelpStateDefault(this.navEnv.getFramework());
    }
}

