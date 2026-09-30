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

public class ParkingAtLocationMapListener
implements ButtonListener {
    private final IPoiService poiService;
    private final IDestinationHandler destinationHandler;
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public ParkingAtLocationMapListener(IPoiService iPoiService, IDestinationHandler iDestinationHandler, NavigationEnv navigationEnv) {
        this.poiService = iPoiService;
        this.destinationHandler = iDestinationHandler;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#keyPressed - modelID=%2, keyID=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.env.getChoiceModel(170).setValue(0);
        this.poiService.getParkingNearDestinationSequenceWithDistanceFromCCP(this.destinationHandler.getLocation()).execute(this.CLASS_NAME + " - Parking at location");
        this.env.fireModelEvent(n, n3);
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

