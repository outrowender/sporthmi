/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.listeners;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.guidance.IVehicle;
import org.dsi.ifc.global.NavLocation;

public class ParkingInVincinityMapListener
extends DefaultButtonListener {
    private IPoiService poiService;
    private IVehicle vehicle;
    private NavigationEnv env;

    public ParkingInVincinityMapListener(NavigationEnv navigationEnv, IPoiService iPoiService, IVehicle iVehicle) {
        this.env = navigationEnv;
        this.poiService = iPoiService;
        this.vehicle = iVehicle;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.env.getLogChannel().log(-2137614336, "ParkingInVincinityMapListener#keyPressed, modelID %1, keyID %2, terminalID %3", (long)n, (long)n2, (long)n3);
        this.env.getChoiceModel(170).setValue(0);
        NavLocation navLocation = this.vehicle.getVehicleLocation();
        this.poiService.getParkingNearDestinationSequenceWithDistanceFromCCP(navLocation).execute("ParkingInVincinityMapListener#ParkingNearDestination");
        this.env.fireModelEvent(n, n3);
    }
}

