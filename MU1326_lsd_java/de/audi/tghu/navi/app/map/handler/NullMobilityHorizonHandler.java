/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.handler.IMobilityHorizonHandler;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public class NullMobilityHorizonHandler
implements IMobilityHorizonHandler {
    private final LogChannel logChannel;

    public NullMobilityHorizonHandler(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void setDSIMobilityHorizon(DSIMobilityHorizon dSIMobilityHorizon) {
        this.logChannel.log(100000000, "NullMobilityHorizonHandler#setDSIMobilityHorizon()");
    }

    public void updateLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray, int n) {
    }

    public void updateConsideredLocationTypes(int[] nArray, int n) {
    }

    public void updateDriveTrainMode(int n, int n2) {
    }

    public void updateMobilityHorizonStatus(int n, int n2) {
    }

    public void requestLocationRangeLevelResult(int n, int n2) {
    }

    public void locationRangeLevelChanged(int n) {
    }

    public void asyncException(int n, String string, int n2) {
    }
}

