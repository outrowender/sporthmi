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
        navigationEnv.getHMIService().getOptionModel(1964901888).setCustomIDListener(this, 2);
        navigationEnv.getHMIService().getOptionModel(1948124672).setCustomIDListener(this, 2);
        navigationEnv.getHMIService().getOptionModel(1293944320).setCustomIDListener(this, 2);
        navigationEnv.getHMIService().getOptionModel(-467728896).setCustomIDListener(this, 2);
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "GeoCoordInputHmiListenerEvo#keyPressed modelID=%1, targetRow=%2", (long)n, (long)n3);
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
                this.logChannel.log(-2137614336, "GeoCoordInputHmiListenerEvo#keyPressed - invalid model id received. id=%1", (long)n);
            }
        }
        this.env.getHMIService().getOptionModel(n).fireEvent(n5);
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void enterGeoCoordInput(int n) {
        this.logChannel.log(-2137614336, "GeoCoordInputHmiListenerEvo#enterGeoCoordInput terminalID=%1", (long)n);
        super.enterGeoCoordInput(n);
        this.geoCoordInputManager.enter();
    }
}

