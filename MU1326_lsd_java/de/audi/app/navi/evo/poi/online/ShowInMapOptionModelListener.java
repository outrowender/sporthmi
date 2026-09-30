/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.app.navi.evo.poi.online.AbstractOnlineSearchOptionModelListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;

public class ShowInMapOptionModelListener
extends AbstractOnlineSearchOptionModelListener {
    public ShowInMapOptionModelListener(LogChannel logChannel, NavigationEnv navigationEnv, OnlineSearchSequence onlineSearchSequence, IOnlineSearchForm iOnlineSearchForm) {
        super(logChannel, navigationEnv, onlineSearchSequence, iOnlineSearchForm);
        navigationEnv.getHMIService().getOptionModel(401375).setListener(this, 400618);
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(1000000, "ShowInMapOptionModelListener#keyPressed(NAV_DEST_ONLINE_SEARCH_SHOW_IN_MAP_OPTION): entering map screen");
        this.sequence.prepareMapScreen(n3);
        this.env.fireModelEvent(n, n5);
    }
}

