/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.listeners;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;

public class ParkingAlongRouteMapListener
extends DefaultButtonListener {
    private IPoiService poiService;
    private NavigationEnv env;

    public ParkingAlongRouteMapListener(NavigationEnv navigationEnv, IPoiService iPoiService) {
        this.env = navigationEnv;
        this.poiService = iPoiService;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.env.getLogChannel().log(-2137614336, "ParkingAlongRouteMapListener#keyPressed, modelID %1, keyID %2, terminalID %3", (long)n, (long)n2, (long)n3);
        this.env.getChoiceModel(170).setValue(0);
        this.poiService.getParkingAlongTheRouteSequence().execute("ParkingAlongRouteMapListener#ParkingAlongTheRoute");
        this.env.fireModelEvent(n, n3);
    }
}

