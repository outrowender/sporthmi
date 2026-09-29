/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.listeners;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class PoiInVicinityMapListener
implements ButtonListener {
    private static final int BUTTON_MODEL;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private ButtonModelApp buttonModel;
    private final IPoiService poiService;
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final IVehicle vehicle;

    public PoiInVicinityMapListener(NavigationEnv navigationEnv, IPoiService iPoiService, IVehicle iVehicle) {
        this.env = navigationEnv;
        this.poiService = iPoiService;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.vehicle = iVehicle;
        this.initListeners();
    }

    private void initListeners() {
        this.buttonModel = this.env.getButtonModel(1193412096);
        this.buttonModel.setButtonListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyPressed - modelId=%2, keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        NavLocation navLocation = this.vehicle.getVehicleLocationDescription();
        this.env.getChoiceModel(170).setValue(0);
        this.poiService.startPoiWithSearchContext(0, navLocation, true, true);
        this.env.fireModelEvent(n, n3);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

