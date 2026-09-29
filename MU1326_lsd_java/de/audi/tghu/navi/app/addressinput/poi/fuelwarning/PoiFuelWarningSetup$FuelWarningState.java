/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PoiFuelWarningSetup$FuelWarningState
extends PersistentState {
    public static final int VERSION;
    public static final int KEY;
    private int recommendation;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());

    public PoiFuelWarningSetup$FuelWarningState(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 1, 1004, 400, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.recommendation = 0;
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.recommendation = iStorageAccess.getInt(1004, 400, 0);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.recommendation);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.recommendation = dataInputStream.readInt();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.getLogChannel().log(-2137614336, "%1#convertContainer - persistedVersion=%2; containerVersion=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.recommendation = dataInputStream.readInt();
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "%1#convertContainer - error on converting the persistent state format, error=%2", (Object)this.CLASS_NAME, (Throwable)iOException);
        }
    }

    public int getRecommendation() {
        return this.recommendation;
    }

    public void setRecommendation(int n) {
        this.recommendation = n;
    }
}

