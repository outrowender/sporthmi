/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.listeners;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public class ParkingAtCrosshairMapListener
extends DefaultButtonListener {
    private IPoiService poiService;
    private MapInterface mapInterface;
    private NavigationEnv env;

    public ParkingAtCrosshairMapListener(NavigationEnv navigationEnv, IPoiService iPoiService, MapInterface mapInterface) {
        this.env = navigationEnv;
        this.poiService = iPoiService;
        this.mapInterface = mapInterface;
    }

    public void keyPressed(int n, int n2, int n3) {
        this.env.getLogChannel().log(10000000, "ParkingAtCrosshairMapListener#keyPressed, modelID %1, keyID %2, terminalID %3", (long)n, (long)n2, (long)n3);
        this.env.getChoiceModel(170).setValue(0);
        NavLocationWgs84 navLocationWgs84 = this.mapInterface.getMapPosition();
        NavLocation navLocation = Util.getLocationFromGeoPos(navLocationWgs84.getLongitude(), navLocationWgs84.getLatitude());
        this.poiService.getParkingNearDestinationSequenceWithDistanceFromDestination(navLocation).execute("ParkingAtCrosshairMapListener#ParkingNearDestination");
        this.env.fireModelEvent(n, n3);
    }
}

