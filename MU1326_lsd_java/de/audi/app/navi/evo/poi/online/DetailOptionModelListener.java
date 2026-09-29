/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.app.navi.evo.poi.online.AbstractOnlineSearchOptionModelListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;

public class DetailOptionModelListener
extends AbstractOnlineSearchOptionModelListener {
    public DetailOptionModelListener(LogChannel logChannel, NavigationEnv navigationEnv, OnlineSearchSequence onlineSearchSequence, IOnlineSearchForm iOnlineSearchForm) {
        super(logChannel, navigationEnv, onlineSearchSequence, iOnlineSearchForm);
        navigationEnv.getHMIService().getOptionModel(1679689216).setListener(this, -367262208);
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "DetailOptionModelListener#keyPressed(NAV_DEST_ONLINE_SEARCH_INFORMATION_OPTION): showing details. Model Id is %1", (Object)new Integer(n));
        this.env.fireModelEvent(n, n5);
    }
}

