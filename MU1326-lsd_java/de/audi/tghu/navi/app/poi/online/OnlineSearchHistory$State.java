/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class OnlineSearchHistory$State
extends PersistentState {
    public static final int VERSION;
    public static final int KEY;
    private static final String[] DEFAULT_HISTORY;
    private String[] history;

    public OnlineSearchHistory$State(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 1, 1004, 880, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.history = DEFAULT_HISTORY;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.history = DEFAULT_HISTORY;
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        this.serializeStringArray(this.history, dataOutputStream);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.history = this.deserializeStringArray(dataInputStream);
        if (this.history == null) {
            this.history = DEFAULT_HISTORY;
        }
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.getLogChannel().log(-2137614336, "OnlineSearchHistory.State#convertContainer( %1, %2 )", (long)n, (long)n2);
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.history = this.deserializeStringArray(dataInputStream);
                if (this.history == null) {
                    this.history = DEFAULT_HISTORY;
                }
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "OnlineSearchHistory.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public String[] getHistory() {
        return this.history;
    }

    public void setHistory(String[] stringArray) {
        this.history = stringArray;
    }

    static {
        DEFAULT_HISTORY = new String[0];
    }
}

