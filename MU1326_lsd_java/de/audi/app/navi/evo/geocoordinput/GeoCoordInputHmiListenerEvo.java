/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.geocoordinput;

import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.geocoordinput.GeoCoordInputHmiListener;
import de.audi.tghu.navi.app.geocoordinput.GeoCoordInputManager;

public class GeoCoordInputHmiListenerEvo
extends GeoCoordInputHmiListener
implements OptionModelListener {
    private NaviADBHandler navAdbHandler;
    private final IPoiService poiService;

    public GeoCoordInputHmiListenerEvo(NavigationEnv navigationEnv, GeoCoordInputManager geoCoordInputManager, NaviFavoriteHandler naviFavoriteHandler, NaviADBHandler naviADBHandler, IPoiService iPoiService) {
        super(navigationEnv, geoCoordInputManager, naviFavoriteHandler);
        this.navAdbHandler = naviADBHandler;
        this.poiService = iPoiService;
        navigationEnv.getHMIService().getOptionModel(401013).setCustomIDListener(this, 2);
        navigationEnv.getHMIService().getOptionModel(401012).setCustomIDListener(this, 2);
        navigationEnv.getHMIService().getOptionModel(401485).setCustomIDListener(this, 2);
        navigationEnv.getHMIService().getOptionModel(401380).setCustomIDListener(this, 2);
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(10000000, "GeoCoordInputHmiListenerEvo#keyPressed modelID=%1, targetRow=%2", (long)n, (long)n3);
        switch (n) {
            case 401013: {
                this.favoriteHandler.addToFavorites(this.geoCoordInputManager.getCurrentCoordinates());
                break;
            }
            case 401012: {
                this.geoCoordInputManager.destOptShowInMap();
                break;
            }
            case 401485: {
                this.navAdbHandler.startStoringAddress(this.geoCoordInputManager.getCurrentCoordinates());
                break;
            }
            case 401380: {
                this.poiService.startParkingNearDestination(this.geoCoordInputManager.getCurrentCoordinates());
                break;
            }
            default: {
                this.logChannel.log(10000000, "GeoCoordInputHmiListenerEvo#keyPressed - invalid model id received. id=%1", (long)n);
            }
        }
        this.env.getHMIService().getOptionModel(n).fireEvent(n5);
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    public void enterGeoCoordInput(int n) {
        this.logChannel.log(10000000, "GeoCoordInputHmiListenerEvo#enterGeoCoordInput terminalID=%1", (long)n);
        super.enterGeoCoordInput(n);
        this.geoCoordInputManager.enter();
    }
}

