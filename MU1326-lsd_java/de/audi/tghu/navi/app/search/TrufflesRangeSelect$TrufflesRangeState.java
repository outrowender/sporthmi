/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;

class TrufflesRangeSelect$TrufflesRangeState
extends PersistentState {
    private static final int VERSION;
    String persistedCountryCode;
    int persistedCountryIconId;

    public TrufflesRangeSelect$TrufflesRangeState(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 5, 1004, 920, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.persistedCountryCode = "XX";
        this.persistedCountryIconId = -1;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.persistedCountryCode = "XX";
        this.persistedCountryIconId = -1;
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        this.serializeStringArray(new String[]{this.persistedCountryCode}, dataOutputStream);
        this.serializeIntArray(new int[]{this.persistedCountryIconId}, dataOutputStream);
        this.logChannel.log(-2137614336, "TrufflesRangeState serialize: persistedCountryCode=%1, persistedCountryIconId=%2", (Object)this.persistedCountryCode, (long)this.persistedCountryIconId);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        String[] stringArray = this.deserializeStringArray(dataInputStream);
        int[] nArray = this.deserializeIntArray(dataInputStream);
        try {
            this.persistedCountryCode = stringArray[0];
            this.persistedCountryIconId = nArray[0];
        }
        catch (Exception exception) {
            this.logChannel.log(-1601830656, "TrufflesRangeState WARNING deserialized: %1, deserializedString=%2, deserializedInt=%3", (Object)exception, (Object)stringArray, (Object)nArray);
            this.persistedCountryCode = "XX";
            this.persistedCountryIconId = -1;
        }
        this.logChannel.log(-2137614336, "TrufflesRangeState deserialize: persistedCountryCode=%1, persistedCountryIconId=%2", (Object)this.persistedCountryCode, (long)this.persistedCountryIconId);
    }

    public String getRangeSelection() {
        return this.persistedCountryCode;
    }

    public void setCountryCode(String string) {
        this.persistedCountryCode = string;
    }

    public int getCountryIconId() {
        return this.persistedCountryIconId;
    }

    public void setCountryIconId(int n) {
        this.persistedCountryIconId = n;
    }
}

