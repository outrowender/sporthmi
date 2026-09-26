/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.app.navi.evo.poi.online.AbstractOnlineSearchOptionModelListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import org.dsi.ifc.global.NavLocation;

public class AddressBookOptionModelListener
extends AbstractOnlineSearchOptionModelListener {
    private final NaviADBHandler naviAdbHandler;

    public AddressBookOptionModelListener(LogChannel logChannel, NavigationEnv navigationEnv, OnlineSearchSequence onlineSearchSequence, IOnlineSearchForm iOnlineSearchForm, NaviADBHandler naviADBHandler) {
        super(logChannel, navigationEnv, onlineSearchSequence, iOnlineSearchForm);
        this.naviAdbHandler = naviADBHandler;
        navigationEnv.getHMIService().getOptionModel(1293944320).setListener(this, -367262208);
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(1078071040, "AddressBookOptionModelListener#keyPressed(NAV_DEST_ADD_TO_CONTACT_OPTION): entering map screen");
        NavLocation navLocation = this.sequence.getSearchContext().getResultList().getTransformedLocationAt(n3);
        if (navLocation == null) {
            this.logChannel.log(10000, "AddressBookOptionModelListener#keyPressed: location is null, probably was not resolved");
        } else if (this.naviAdbHandler == null) {
            this.logChannel.log(10000, "AddressBookOptionModelListener#keyPressed: poiInput is null");
        } else {
            this.naviAdbHandler.startStoringAddress(navLocation);
            this.env.fireModelEvent(n, n5);
        }
    }
}

