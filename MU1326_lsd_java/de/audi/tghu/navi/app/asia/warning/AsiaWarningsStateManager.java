/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.asia.warning;

import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storage.ValueMissingException;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.asia.warning.AsiaWarningsStateManager$MapWarningDataContainer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AsiaWarningsStateManager
extends AbstractStorageDataContainer {
    public static final int VERSION;
    protected boolean LOW_FUEL_WARNING_DEFAULT_VALUE;
    protected boolean MERGING_TRAFFIC_WARNING_DEFAULT_VALUE;
    protected boolean LANE_WARNING_DEFAULT_VALUE;
    protected boolean RAILWAY_WARNING_DEFAULT_VALUE;
    protected boolean SPEED_CAMERA_WARNING_DEFAULT_VALUE;
    private final IStorageAccess storageAccess;
    private AsiaWarningsStateManager$MapWarningDataContainer dataContainer;
    private NavigationEnv env;

    public AsiaWarningsStateManager(NavigationEnv navigationEnv) {
        super(navigationEnv.getFramework().getStorageMgr(), 1, 1113, 8081);
        this.env = navigationEnv;
        this.storageAccess = navigationEnv.getFramework().getStorageMgr();
        this.initializeDefaultValues();
        this.dataContainer = new AsiaWarningsStateManager$MapWarningDataContainer(this);
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
        AsiaWarningsStateManager$MapWarningDataContainer.access$000(this.dataContainer, 1 == n);
    }

    public int getLowFuelWarningState() {
        return this.dataContainer.isLowFuelWarning() ? 1 : 0;
    }

    public void setMergingTrafficState(int n) {
        AsiaWarningsStateManager$MapWarningDataContainer.access$100(this.dataContainer, 1 == n);
    }

    public int getMergingTrafficState() {
        return this.dataContainer.isMergingTrafficWarning() ? 1 : 0;
    }

    public void setLaneWarningState(int n) {
        AsiaWarningsStateManager$MapWarningDataContainer.access$200(this.dataContainer, 1 == n);
    }

    public int getLaneWarningState() {
        return this.dataContainer.isLaneWarning() ? 1 : 0;
    }

    public void setRailwayCrossingWarningState(int n) {
        AsiaWarningsStateManager$MapWarningDataContainer.access$300(this.dataContainer, 1 == n);
    }

    public int getRailwayCrossingWarningState() {
        return this.dataContainer.isRailwayWarning() ? 1 : 0;
    }

    public void setSpeedCameraWarningState(int n) {
        AsiaWarningsStateManager$MapWarningDataContainer.access$400(this.dataContainer, 1 == n);
    }

    public int getSpeedCameraWarningState() {
        return this.dataContainer.isSpeedCameraWarning() ? 1 : 0;
    }

    public void saveWarningStates() {
        if (this.storageAccess != null) {
            this.env.getLogChannel().log(-2137614336, "AsiaWarningsStateManager#saveWarningStates(), save following map warning settings Asia: - %1", (Object)this.dataContainer.toString());
            this.serializeAndWrite();
        } else {
            this.env.getLogChannel().log(10000, "AsiaWarningsStateManager#saveWarningStates() - no storage manager available!!! ");
        }
    }

    @Override
    protected void handleCRC32Error() {
        this.env.getLogChannel().log(10000, "AsiaWarningsStateManager#handleCRC32Error - invalid persistent state, using default values");
        this.dataContainer.initAsDefault();
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        if (exception instanceof ValueMissingException) {
            this.env.getLogChannel().log(1078071040, "AsiaWarningsStateManager#handleStorageReadError - no persistent state available, trying old keys");
            this.dataContainer.initAsDefault();
        } else {
            this.env.getLogChannel().log(-1601830656, "AsiaWarningsStateManager#handleStorageReadError - cannot read persistent state, using default values (namespace: %1, key: %2)", (long)this.getNamespace(), (long)this.getKey());
            this.dataContainer.initAsDefault();
        }
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        this.env.getLogChannel().log(-2137614336, "AsiaWarningsStateManager#serialize() - %1", (Object)this.dataContainer.toString());
        dataOutputStream.writeBoolean(this.dataContainer.isLowFuelWarning());
        dataOutputStream.writeBoolean(this.dataContainer.isMergingTrafficWarning());
        dataOutputStream.writeBoolean(this.dataContainer.isLaneWarning());
        dataOutputStream.writeBoolean(this.dataContainer.isRailwayWarning());
        dataOutputStream.writeBoolean(this.dataContainer.isSpeedCameraWarning());
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.env.getLogChannel().log(-2137614336, "AsiaWarningsStateManager#deserialize() - %1", (Object)this.dataContainer.toString());
        AsiaWarningsStateManager$MapWarningDataContainer.access$000(this.dataContainer, dataInputStream.readBoolean());
        AsiaWarningsStateManager$MapWarningDataContainer.access$100(this.dataContainer, dataInputStream.readBoolean());
        AsiaWarningsStateManager$MapWarningDataContainer.access$200(this.dataContainer, dataInputStream.readBoolean());
        AsiaWarningsStateManager$MapWarningDataContainer.access$300(this.dataContainer, dataInputStream.readBoolean());
        AsiaWarningsStateManager$MapWarningDataContainer.access$400(this.dataContainer, dataInputStream.readBoolean());
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.dataContainer.initAsDefault();
        try {
            if (n > 0) {
                AsiaWarningsStateManager$MapWarningDataContainer.access$000(this.dataContainer, dataInputStream.readBoolean());
                AsiaWarningsStateManager$MapWarningDataContainer.access$100(this.dataContainer, dataInputStream.readBoolean());
                AsiaWarningsStateManager$MapWarningDataContainer.access$200(this.dataContainer, dataInputStream.readBoolean());
                AsiaWarningsStateManager$MapWarningDataContainer.access$300(this.dataContainer, dataInputStream.readBoolean());
                AsiaWarningsStateManager$MapWarningDataContainer.access$400(this.dataContainer, dataInputStream.readBoolean());
            }
        }
        catch (IOException iOException) {
            this.env.getLogChannel().log(10000, "AsiaWarningsStateManager#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    static /* synthetic */ AsiaWarningsStateManager$MapWarningDataContainer access$500(AsiaWarningsStateManager asiaWarningsStateManager) {
        return asiaWarningsStateManager.dataContainer;
    }
}

