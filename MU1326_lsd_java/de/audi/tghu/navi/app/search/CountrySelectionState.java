/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CountrySelectionState
extends PersistentState {
    private static final int VERSION = 5;
    protected String persistedCountryCode;
    protected int persistedCountryIconId;

    public CountrySelectionState(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 5, 1004, 920, logChannel);
    }

    protected void initWithDefaultValues() {
        this.persistedCountryCode = "XX";
        this.persistedCountryIconId = -1;
    }

    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.persistedCountryCode = "XX";
        this.persistedCountryIconId = -1;
    }

    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
    }

    protected void serialize(DataOutputStream dataOutputStream) throws IOException {
        this.serializeStringArray(new String[]{this.persistedCountryCode}, dataOutputStream);
        this.serializeIntArray(new int[]{this.persistedCountryIconId}, dataOutputStream);
        this.logChannel.log(10000000, "CountrySelectionState serialize: persistedCountryCode=%1, persistedCountryIconId=%2", (Object)this.persistedCountryCode, (long)this.persistedCountryIconId);
    }

    protected void deserialize(DataInputStream dataInputStream) throws IOException {
        String[] stringArray = this.deserializeStringArray(dataInputStream);
        int[] nArray = this.deserializeIntArray(dataInputStream);
        try {
            this.persistedCountryCode = stringArray != null && stringArray.length > 0 ? stringArray[0] : "XX";
            if (nArray != null && nArray.length > 0) {
                this.persistedCountryIconId = nArray[0];
            }
        }
        catch (Exception exception) {
            this.logChannel.log(100000, "CountrySelectionState WARNING deserialized: %1, deserializedString=%2, deserializedInt=%3", (Object)exception, (Object)stringArray, (Object)nArray);
            this.persistedCountryCode = "XX";
            this.persistedCountryIconId = -1;
        }
        this.logChannel.log(10000000, "CountrySelectionState deserialize: persistedCountryCode=%1, persistedCountryIconId=%2", (Object)this.persistedCountryCode, (long)this.persistedCountryIconId);
    }

    public String getCountryCode() {
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

