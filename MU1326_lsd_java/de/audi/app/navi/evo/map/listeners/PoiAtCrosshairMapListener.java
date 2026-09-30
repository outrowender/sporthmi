/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.listeners;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public class PoiAtCrosshairMapListener
implements ButtonListener {
    private static final int BUTTON_MODEL = 401988;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    private ButtonModelApp buttonModel;
    private final IPoiService poiService;
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final MapInterface mapInterface;

    public PoiAtCrosshairMapListener(NavigationEnv navigationEnv, IPoiService iPoiService, MapInterface mapInterface) {
        this.env = navigationEnv;
        this.poiService = iPoiService;
        this.mapInterface = mapInterface;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.initListeners();
    }

    private void initListeners() {
        this.buttonModel = this.env.getButtonModel(401988);
        this.buttonModel.setButtonListener(this);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#keyPressed - modelId=%2, keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.env.getChoiceModel(170).setValue(0);
        NavLocationWgs84 navLocationWgs84 = this.mapInterface.getMapPosition();
        NavLocation navLocation = Util.getLocationFromGeoPos(navLocationWgs84.getLongitude(), navLocationWgs84.getLatitude());
        this.poiService.startPoiWithSearchContext(4, navLocation, true, true);
        this.env.fireModelEvent(n, n3);
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

