/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.poiwarning;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PoiWarningPersistenceHelper$Items
extends PersistentState {
    public static final int VERSION;
    private int[] serializedItems = new int[]{-1};

    public PoiWarningPersistenceHelper$Items(IStorageAccess iStorageAccess, LogChannel logChannel, int n) {
        super(iStorageAccess, 1, 1004, n, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.serializedItems = new int[1];
        this.serializedItems[0] = -1;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.serializedItems = this.deserializeIntArray(dataInputStream);
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "PoiWarningPersistenceHelper.Items#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        this.serializeIntArray(this.serializedItems, dataOutputStream);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.serializedItems = this.deserializeIntArray(dataInputStream);
    }

    public void setSelectedPoiCategories(int[] nArray) {
        this.serializedItems = nArray;
    }

    public int[] getSelectedPoiCategories() {
        return this.serializedItems;
    }
}

