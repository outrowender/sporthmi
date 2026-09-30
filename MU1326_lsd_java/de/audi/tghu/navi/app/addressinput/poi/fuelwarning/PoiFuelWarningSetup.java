/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PoiFuelWarningSetup {
    private static final int FUEL_WARNING_RECOMMENDATION_ON = 0;
    private static final int FUEL_WARNING_RECOMMENDATION_OFF = 1;
    private boolean fuelWarningActive;
    private final NavigationEnv env;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public PoiFuelWarningSetup(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.loadState(navigationEnv.getFramework().getStorageMgr(), navigationEnv.getLogChannel());
    }

    public final boolean isFuelWarningActive() {
        return this.fuelWarningActive;
    }

    private void doSetFuelWarningActive(boolean bl, boolean bl2) {
        this.fuelWarningActive = bl;
        this.doPersistFuelWarningActive();
    }

    public void setFuelWarningActive(boolean bl, boolean bl2) {
        this.doSetFuelWarningActive(bl, bl2);
    }

    public void persistFuelWarningActive() {
        this.doPersistFuelWarningActive();
    }

    private void doPersistFuelWarningActive() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        FuelWarningState fuelWarningState = new FuelWarningState(iStorageAccess, this.env.getLogChannel());
        fuelWarningState.setRecommendation(this.fuelWarningActive ? 0 : 1);
        fuelWarningState.serializeAndWrite();
    }

    public final void loadState(IStorageAccess iStorageAccess, LogChannel logChannel) {
        if (iStorageAccess == null) {
            logChannel.log(10000, "%1#loadState() - no storage manager available!!!", (Object)this.CLASS_NAME);
            return;
        }
        FuelWarningState fuelWarningState = new FuelWarningState(iStorageAccess, logChannel);
        fuelWarningState.readAndDeserialize();
        boolean bl = fuelWarningState.getRecommendation() != 1;
        this.doSetFuelWarningActive(bl, false);
    }

    void saveState(IStorageAccess iStorageAccess, LogChannel logChannel) {
        if (iStorageAccess == null) {
            logChannel.log(10000, "%1#saveState() - no storage manager available!!!", (Object)this.CLASS_NAME);
            return;
        }
        FuelWarningState fuelWarningState = new FuelWarningState(iStorageAccess, logChannel);
        int n = this.isFuelWarningActive() ? 0 : 1;
        fuelWarningState.setRecommendation(n);
        fuelWarningState.serializeAndWrite();
    }

    public void resetSettings() {
        this.env.getLogChannel().log(10000000, "%1#resetSettings() - reset FuelWarningActive - true", (Object)this.CLASS_NAME);
        this.setFuelWarningActive(true, true);
    }

    public static class FuelWarningState
    extends PersistentState {
        public static final int VERSION = 1;
        public static final int KEY = 400;
        private int recommendation;
        private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

        public FuelWarningState(IStorageAccess iStorageAccess, LogChannel logChannel) {
            super(iStorageAccess, 1, 1004, 400, logChannel);
        }

        protected void initWithDefaultValues() {
            this.recommendation = 0;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.recommendation = iStorageAccess.getInt(1004, 400, 0);
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(this.recommendation);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.recommendation = dataInputStream.readInt();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.getLogChannel().log(10000000, "%1#convertContainer - persistedVersion=%2; containerVersion=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
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
}

