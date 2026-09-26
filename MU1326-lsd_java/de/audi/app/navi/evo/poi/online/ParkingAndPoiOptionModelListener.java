/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.app.navi.evo.poi.online.AbstractOnlineSearchOptionModelListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import org.dsi.ifc.global.NavLocation;

public class ParkingAndPoiOptionModelListener
extends AbstractOnlineSearchOptionModelListener {
    private IPoiService poiService;

    public ParkingAndPoiOptionModelListener(LogChannel logChannel, NavigationEnv navigationEnv, OnlineSearchSequence onlineSearchSequence, IOnlineSearchForm iOnlineSearchForm, IPoiService iPoiService) {
        super(logChannel, navigationEnv, onlineSearchSequence, iOnlineSearchForm);
        this.poiService = iPoiService;
        navigationEnv.getHMIService().getOptionModel(-467728896).setListener(this, -367262208);
        navigationEnv.getHMIService().getOptionModel(1176634880).setListener(this, -367262208);
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "%1#keyPressed - modelId=%2, targetModelId=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        NavLocation navLocation = this.sequence.getSearchContext().getResultList().getTransformedLocationAt(n3);
        if (navLocation == null) {
            this.logChannel.log(10000, "%1#keyPressed: location is null, probably was not resolved", (Object)this.CLASS_NAME);
        } else if (this.poiService == null) {
            this.logChannel.log(10000, "%1#keyPressed: poiService is null", (Object)this.CLASS_NAME);
        } else if (n == -467728896) {
            this.poiService.getParkingNearDestinationSequenceWithDistanceFromCCP(navLocation).execute(new StringBuffer().append(this.CLASS_NAME).append("#ParkingNearDestination").toString());
        } else if (n == 1176634880) {
            this.poiService.startPoiWithSearchContext(4, navLocation, true, true);
        }
        this.env.fireModelEvent(n, n5);
    }
}

