/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.asia.warning;

import de.audi.tghu.navi.app.asia.warning.AsiaWarningsStateManager;
import de.esolutions.fw.util.commons.Buffer;

public class AsiaWarningsStateManager$MapWarningDataContainer {
    private boolean isLowFuelWarning;
    private boolean isMergingTrafficWarning;
    private boolean isLaneWarning;
    private boolean isRailwayWarning;
    private boolean isSpeedCameraWarning;
    private final /* synthetic */ AsiaWarningsStateManager this$0;

    public AsiaWarningsStateManager$MapWarningDataContainer(AsiaWarningsStateManager asiaWarningsStateManager) {
        this.this$0 = asiaWarningsStateManager;
    }

    public void initAsDefault() {
        AsiaWarningsStateManager.access$500((AsiaWarningsStateManager)this.this$0).isLowFuelWarning = this.this$0.LOW_FUEL_WARNING_DEFAULT_VALUE;
        AsiaWarningsStateManager.access$500((AsiaWarningsStateManager)this.this$0).isMergingTrafficWarning = this.this$0.MERGING_TRAFFIC_WARNING_DEFAULT_VALUE;
        AsiaWarningsStateManager.access$500((AsiaWarningsStateManager)this.this$0).isLaneWarning = this.this$0.LANE_WARNING_DEFAULT_VALUE;
        AsiaWarningsStateManager.access$500((AsiaWarningsStateManager)this.this$0).isRailwayWarning = this.this$0.RAILWAY_WARNING_DEFAULT_VALUE;
        AsiaWarningsStateManager.access$500((AsiaWarningsStateManager)this.this$0).isSpeedCameraWarning = this.this$0.SPEED_CAMERA_WARNING_DEFAULT_VALUE;
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

    static /* synthetic */ void access$000(AsiaWarningsStateManager$MapWarningDataContainer asiaWarningsStateManager$MapWarningDataContainer, boolean bl) {
        asiaWarningsStateManager$MapWarningDataContainer.setLowFuelWarning(bl);
    }

    static /* synthetic */ void access$100(AsiaWarningsStateManager$MapWarningDataContainer asiaWarningsStateManager$MapWarningDataContainer, boolean bl) {
        asiaWarningsStateManager$MapWarningDataContainer.setMergingTrafficWarning(bl);
    }

    static /* synthetic */ void access$200(AsiaWarningsStateManager$MapWarningDataContainer asiaWarningsStateManager$MapWarningDataContainer, boolean bl) {
        asiaWarningsStateManager$MapWarningDataContainer.setLaneWarning(bl);
    }

    static /* synthetic */ void access$300(AsiaWarningsStateManager$MapWarningDataContainer asiaWarningsStateManager$MapWarningDataContainer, boolean bl) {
        asiaWarningsStateManager$MapWarningDataContainer.setRailwayWarning(bl);
    }

    static /* synthetic */ void access$400(AsiaWarningsStateManager$MapWarningDataContainer asiaWarningsStateManager$MapWarningDataContainer, boolean bl) {
        asiaWarningsStateManager$MapWarningDataContainer.setSpeedCameraWarning(bl);
    }
}

