/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public abstract class AbstractOnlineSearchOptionModelListener
implements OptionModelListener {
    protected final LogChannel logChannel;
    protected final NavigationEnv env;
    protected final IOnlineSearchForm searchForm;
    protected final OnlineSearchSequence sequence;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public AbstractOnlineSearchOptionModelListener(LogChannel logChannel, NavigationEnv navigationEnv, OnlineSearchSequence onlineSearchSequence, IOnlineSearchForm iOnlineSearchForm) {
        this.logChannel = logChannel;
        this.env = navigationEnv;
        this.sequence = onlineSearchSequence;
        this.searchForm = iOnlineSearchForm;
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
    }

    protected NavLocation getNavLocation(int n) {
        PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = this.sequence.getSearchContext().getResultList().getPOIElementAt(n);
        int n2 = Util.degreeStringToWgs84(String.valueOf(poiOnlineSearchValuelistElement.longitude));
        int n3 = Util.degreeStringToWgs84(String.valueOf(poiOnlineSearchValuelistElement.latitude));
        NavLocation navLocation = Util.getLocationFromGeoPos(n2, n3);
        return navLocation;
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

