/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.interapp.INaviServiceListenerObserver;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.search.ILastDestHandler;

public class NaviServiceListenerObserver
implements INaviServiceListenerObserver {
    private final LogChannel logChannel;
    private final OperationManager operationManager;
    private final IAddressInputForm addressInputForm;
    private final NaviFavoriteHandler naviFavoriteHandler;
    private ILastDestHandler lastDestHandler;
    private final NaviServiceListenerController naviServiceListenerController;

    public NaviServiceListenerObserver(LogChannel logChannel, OperationManager operationManager, IAddressInputForm iAddressInputForm, NaviFavoriteHandler naviFavoriteHandler, NaviServiceListenerController naviServiceListenerController) {
        this.logChannel = logChannel;
        this.operationManager = operationManager;
        this.addressInputForm = iAddressInputForm;
        this.naviFavoriteHandler = naviFavoriteHandler;
        this.naviServiceListenerController = naviServiceListenerController;
    }

    public void listenerAdded(NaviServiceListener naviServiceListener) {
        this.logChannel.log(1000000, "NaviServiceListenerObserver#listenerAdded()");
        this.updateNaviOperableState(naviServiceListener);
        this.updateFavoriteDestinations(naviServiceListener);
        this.updateLastDestinationCountry(naviServiceListener);
        this.updateLastDestinationList(naviServiceListener);
    }

    private void updateLastDestinationList(NaviServiceListener naviServiceListener) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "NaviServiceListenerObserver#updateLastDestinationList()");
        }
        if (this.lastDestHandler != null) {
            naviServiceListener.updateLastDestinations(this.lastDestHandler.getLastDestListForSDS());
        } else {
            this.logChannel.log(1000000, "NaviServiceListenerObserver#updateLastDestinationList() - LastDestHandler is null");
        }
    }

    private void updateLastDestinationCountry(NaviServiceListener naviServiceListener) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "NaviServiceListenerObserver#updateLastDestinationCountry()");
        }
        if (!this.operationManager.isFullyOperable()) {
            this.logChannel.log(100000, "NaviServiceListenerObserver#updateLastDestinationCountry() navigation not fully operable, call will be ignored!");
            return;
        }
        this.addressInputForm.onNewNaviServiceListener();
    }

    private void updateNaviOperableState(NaviServiceListener naviServiceListener) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "NaviServiceListenerObserver#updateNaviOperableState()");
        }
        this.operationManager.updateNaviOperableState(naviServiceListener);
    }

    private void updateFavoriteDestinations(NaviServiceListener naviServiceListener) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "NaviServiceListenerObserver#updateFavoriteDestinations()");
        }
        naviServiceListener.updateFavoriteDestinations(this.naviFavoriteHandler.getFavoriteSDSEntries());
    }

    public void setLastDestHandler(ILastDestHandler iLastDestHandler) {
        this.lastDestHandler = iLastDestHandler;
        this.naviServiceListenerController.updateLastDestinations(this.lastDestHandler.getLastDestListForSDS());
    }
}

