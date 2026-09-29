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

    @Override
    public void setDSIMobilityHorizon(DSIMobilityHorizon dSIMobilityHorizon) {
        this.logChannel.log(14808325, "NullMobilityHorizonHandler#setDSIMobilityHorizon()");
    }

    @Override
    public void updateLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray, int n) {
    }

    @Override
    public void updateConsideredLocationTypes(int[] nArray, int n) {
    }

    @Override
    public void updateDriveTrainMode(int n, int n2) {
    }

    @Override
    public void updateMobilityHorizonStatus(int n, int n2) {
    }

    @Override
    public void requestLocationRangeLevelResult(int n, int n2) {
    }

    @Override
    public void locationRangeLevelChanged(int n) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }
}

