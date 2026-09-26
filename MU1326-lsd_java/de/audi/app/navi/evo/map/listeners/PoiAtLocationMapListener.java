/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.listeners;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class PoiAtLocationMapListener
implements ButtonListener {
    private static final int BUTTON_MODEL;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final NavigationEnv env;
    private final IPoiService poiService;
    private final IDestinationHandler destinationHandler;
    private final LogChannel logChannel;

    public PoiAtLocationMapListener(NavigationEnv navigationEnv, IPoiService iPoiService, IDestinationHandler iDestinationHandler) {
        this.env = navigationEnv;
        this.poiService = iPoiService;
        this.destinationHandler = iDestinationHandler;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.initListeners();
    }

    private void initListeners() {
        this.env.getButtonModel(522323456).setButtonListener(this);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyPressed - modelId=%2, keyId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.env.getChoiceModel(170).setValue(0);
        NavLocation navLocation = this.destinationHandler.getLocation();
        this.poiService.startPoiWithSearchContext(4, navLocation, true, true);
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

