/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.asia.warning;

import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storage.ValueMissingException;
import de.audi.tghu.navi.app.NavigationEnv;
import de.esolutions.fw.util.commons.Buffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AsiaWarningsStateManager
extends AbstractStorageDataContainer {
    public static final int VERSION = 1;
    protected boolean LOW_FUEL_WARNING_DEFAULT_VALUE;
    protected boolean MERGING_TRAFFIC_WARNING_DEFAULT_VALUE;
    protected boolean LANE_WARNING_DEFAULT_VALUE;
    protected boolean RAILWAY_WARNING_DEFAULT_VALUE;
    protected boolean SPEED_CAMERA_WARNING_DEFAULT_VALUE;
    private final IStorageAccess storageAccess;
    private MapWarningDataContainer dataContainer;
    private NavigationEnv env;

    public AsiaWarningsStateManager(NavigationEnv navigationEnv) {
        super(navigationEnv.getFramework().getStorageMgr(), 1, 1113, 8081);
        this.env = navigationEnv;
        this.storageAccess = navigationEnv.getFramework().getStorageMgr();
        this.initializeDefaultValues();
        this.dataContainer = new MapWarningDataContainer();
        if (this.storageAccess != null) {
            this.readAndDeserialize();
        } else {
            navigationEnv.getLogChannel().log(10000, "AsiaWarningsStateManager#constructor - no storage manager available!! init asia map warning settings Asia with Default value");
            this.dataContainer.initAsDefault();
        }
    }

    protected void initializeDefaultValues() {
        this.LOW_FUEL_WARNING_DEFAULT_VALUE = true;
        this.MERGING_TRAFFIC_WARNING_DEFAULT_VALUE = true;
        this.LANE_WARNING_DEFAULT_VALUE = true;
        this.RAILWAY_WARNING_DEFAULT_VALUE = true;
        this.SPEED_CAMERA_WARNING_DEFAULT_VALUE = true;
    }

    public void restoreDefault() {
        this.dataContainer.initAsDefault();
    }

    public void setLowFuelWarningState(int n) {
        this.dataContainer.setLowFuelWarning(1 == n);
    }

    public int getLowFuelWarningState() {
        return this.dataContainer.isLowFuelWarning() ? 1 : 0;
    }

    public void setMergingTrafficState(int n) {
        this.dataContainer.setMergingTrafficWarning(1 == n);
    }

    public int getMergingTrafficState() {
        return this.dataContainer.isMergingTrafficWarning() ? 1 : 0;
    }

    public void setLaneWarningState(int n) {
        this.dataContainer.setLaneWarning(1 == n);
    }

    public int getLaneWarningState() {
        return this.dataContainer.isLaneWarning() ? 1 : 0;
    }

    public void setRailwayCrossingWarningState(int n) {
        this.dataContainer.setRailwayWarning(1 == n);
    }

    public int getRailwayCrossingWarningState() {
        return this.dataContainer.isRailwayWarning() ? 1 : 0;
    }

    public void setSpeedCameraWarningState(int n) {
        this.dataContainer.setSpeedCameraWarning(1 == n);
    }

    public int getSpeedCameraWarningState() {
        return this.dataContainer.isSpeedCameraWarning() ? 1 : 0;
    }

    public void saveWarningStates() {
        if (this.storageAccess != null) {
            this.env.getLogChannel().log(10000000, "AsiaWarningsStateManager#saveWarningStates(), save following map warning settings Asia: - %1", (Object)this.dataContainer.toString());
            this.serializeAndWrite();
        } else {
            this.env.getLogChannel().log(10000, "AsiaWarningsStateManager#saveWarningStates() - no storage manager available!!! ");
        }
    }

    protected void handleCRC32Error() {
        this.env.getLogChannel().log(10000, "AsiaWarningsStateManager#handleCRC32Error - invalid persistent state, using default values");
        this.dataContainer.initAsDefault();
    }

    protected void handleStorageReadError(Exception exception) {
        if (exception instanceof ValueMissingException) {
            this.env.getLogChannel().log(1000000, "AsiaWarningsStateManager#handleStorageReadError - no persistent state available, trying old keys");
            this.dataContainer.initAsDefault();
        } else {
            this.env.getLogChannel().log(100000, "AsiaWarningsStateManager#handleStorageReadError - cannot read persistent state, using default values (namespace: %1, key: %2)", (long)this.getNamespace(), (long)this.getKey());
            this.dataContainer.initAsDefault();
        }
    }

    protected void serialize(DataOutputStream dataOutputStream) throws IOException {
        this.env.getLogChannel().log(10000000, "AsiaWarningsStateManager#serialize() - %1", (Object)this.dataContainer.toString());
        dataOutputStream.writeBoolean(this.dataContainer.isLowFuelWarning());
        dataOutputStream.writeBoolean(this.dataContainer.isMergingTrafficWarning());
        dataOutputStream.writeBoolean(this.dataContainer.isLaneWarning());
        dataOutputStream.writeBoolean(this.dataContainer.isRailwayWarning());
        dataOutputStream.writeBoolean(this.dataContainer.isSpeedCameraWarning());
    }

    protected void deserialize(DataInputStream dataInputStream) throws IOException {
        this.env.getLogChannel().log(10000000, "AsiaWarningsStateManager#deserialize() - %1", (Object)this.dataContainer.toString());
        this.dataContainer.setLowFuelWarning(dataInputStream.readBoolean());
        this.dataContainer.setMergingTrafficWarning(dataInputStream.readBoolean());
        this.dataContainer.setLaneWarning(dataInputStream.readBoolean());
        this.dataContainer.setRailwayWarning(dataInputStream.readBoolean());
        this.dataContainer.setSpeedCameraWarning(dataInputStream.readBoolean());
    }

    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.dataContainer.initAsDefault();
        try {
            if (n > 0) {
                this.dataContainer.setLowFuelWarning(dataInputStream.readBoolean());
                this.dataContainer.setMergingTrafficWarning(dataInputStream.readBoolean());
                this.dataContainer.setLaneWarning(dataInputStream.readBoolean());
                this.dataContainer.setRailwayWarning(dataInputStream.readBoolean());
                this.dataContainer.setSpeedCameraWarning(dataInputStream.readBoolean());
            }
        }
        catch (IOException iOException) {
            this.env.getLogChannel().log(10000, "AsiaWarningsStateManager#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public class MapWarningDataContainer {
        private boolean isLowFuelWarning;
        private boolean isMergingTrafficWarning;
        private boolean isLaneWarning;
        private boolean isRailwayWarning;
        private boolean isSpeedCameraWarning;

        public void initAsDefault() {
            ((AsiaWarningsStateManager)AsiaWarningsStateManager.this).dataContainer.isLowFuelWarning = AsiaWarningsStateManager.this.LOW_FUEL_WARNING_DEFAULT_VALUE;
            ((AsiaWarningsStateManager)AsiaWarningsStateManager.this).dataContainer.isMergingTrafficWarning = AsiaWarningsStateManager.this.MERGING_TRAFFIC_WARNING_DEFAULT_VALUE;
            ((AsiaWarningsStateManager)AsiaWarningsStateManager.this).dataContainer.isLaneWarning = AsiaWarningsStateManager.this.LANE_WARNING_DEFAULT_VALUE;
            ((AsiaWarningsStateManager)AsiaWarningsStateManager.this).dataContainer.isRailwayWarning = AsiaWarningsStateManager.this.RAILWAY_WARNING_DEFAULT_VALUE;
            ((AsiaWarningsStateManager)AsiaWarningsStateManager.this).dataContainer.isSpeedCameraWarning = AsiaWarningsStateManager.this.SPEED_CAMERA_WARNING_DEFAULT_VALUE;
        }

        public boolean isLowFuelWarning() {
            return this.isLowFuelWarning;
        }

        private void setLowFuelWarning(boolean bl) {
            this.isLowFuelWarning = bl;
        }

        public boolean isMergingTrafficWarning() {
            return this.isMergingTrafficWarning;
        }

        private void setMergingTrafficWarning(boolean bl) {
            this.isMergingTrafficWarning = bl;
        }

        public boolean isLaneWarning() {
            return this.isLaneWarning;
        }

        private void setLaneWarning(boolean bl) {
            this.isLaneWarning = bl;
        }

        public boolean isRailwayWarning() {
            return this.isRailwayWarning;
        }

        private void setRailwayWarning(boolean bl) {
            this.isRailwayWarning = bl;
        }

        public boolean isSpeedCameraWarning() {
            return this.isSpeedCameraWarning;
        }

        private void setSpeedCameraWarning(boolean bl) {
            this.isSpeedCameraWarning = bl;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("isLowFuelWarning=").append(this.isLowFuelWarning).append(", ");
            buffer.append("isMergingTrafficWarning=").append(this.isMergingTrafficWarning).append(", ");
            buffer.append("isLaneWarning=").append(this.isLaneWarning).append(", ");
            buffer.append("isRailwayWarning=").append(this.isRailwayWarning).append(", ");
            buffer.append("isSpeedCameraWarning=").append(this.isSpeedCameraWarning);
            return buffer.toString();
        }
    }
}

