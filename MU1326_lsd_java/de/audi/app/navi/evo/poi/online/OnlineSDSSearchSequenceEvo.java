/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.app.navi.evo.poi.online.OnlineSDSSearchSequenceEvo$1;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.poi.online.OnlineSDSSearchSequence;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import org.dsi.ifc.global.NavLocation;

public class OnlineSDSSearchSequenceEvo
extends OnlineSDSSearchSequence {
    public OnlineSDSSearchSequenceEvo(NavigationEnv navigationEnv, LogChannel logChannel, ICommandListFactory iCommandListFactory, OnlineSearchSequence onlineSearchSequence, IOnlineSearchForm iOnlineSearchForm) {
        super(navigationEnv, logChannel, iCommandListFactory, onlineSearchSequence, iOnlineSearchForm);
    }

    @Override
    public boolean indicateError(int n) {
        boolean bl = true;
        if (n == 57 || n == 61 || n == 62 || n == 44) {
            this.logChannel.log(-2137614336, "OnlineSDSSearchSequenceEvo#indicateError: setting result list model to status_ok");
            ListModelApp listModelApp = this.env.getListModel(-367262208);
            listModelApp.clear();
            listModelApp.setStatus(1);
            bl = false;
        }
        byte by = this.getSDSReturnCode(n);
        this.logChannel.log(-2137614336, "OnlineSDSSearchSequenceEvo#indicateError(%1): converting to SDS code %2", (long)n, (long)by);
        this.form.setSearchTextLabel("");
        this.sdsServiceListener.updatePOIOnlineSearchResults(by, "", null);
        return bl;
    }

    @Override
    public void selectDestination(int n) {
        if (n == -1) {
            this.logChannel.log(-2137614336, "OnlineSDSSearchSequenceEvo#selectDestination: unknown row called %1", (long)n);
            this.sdsServiceListener.responseSelectDestination(null);
            return;
        }
        OnlinePOIResultList onlinePOIResultList = this.onlineSearchSequence.getSearchContext().getResultList();
        if (onlinePOIResultList == null || onlinePOIResultList.length() < n) {
            this.logChannel.log(-2137614336, "OnlineSDSSearchSequenceEvo#selectDestination: resultlist is smaller than selected row %1", (long)n);
            this.sdsServiceListener.responseSelectDestination(null);
            return;
        }
        this.logChannel.log(-2137614336, "OnlineSDSSearchSequenceEvo#selectDestination: Called with row %1", (long)n);
        CommandList commandList = this.onlineSearchSequence.refreshDetailsFor(n);
        commandList.add(new OnlineSDSSearchSequenceEvo$1(this, "OnlineSDSSearchSequenceEvo#selectDestination", n));
        commandList.execute("OnlineSDSSearchSequenceEvo#NAV_P_O_I_ONLINE_RESULTS_LIST");
    }

    public void setSelectedLocation(int n) {
        NavLocation navLocation = null;
        if (this.onlineSearchSequence.getSearchContext() == null) {
            this.logChannel.log(-1601830656, "OnlineSDSSearchSequenceEvo#setSelectedLocation: no searchContext available");
            this.sdsServiceListener.responseSelectDestination(null);
            return;
        }
        OnlinePOIResultList onlinePOIResultList = this.onlineSearchSequence.getSearchContext().getResultList();
        if (onlinePOIResultList != null) {
            navLocation = onlinePOIResultList.getTransformedLocationAt(n);
        } else {
            this.logChannel.log(-1601830656, "OnlineSDSSearchSequenceEvo#setSelectedLocation: no resultList available");
        }
        this.sdsServiceListener.responseSelectDestination(navLocation);
    }

    @Override
    public byte poiOnlineSearchCancel() {
        this.logChannel.log(-2137614336, "OnlineSDSSearchSequenceEvo#poiOnlineSearchCancel()");
        this.setSearchCanceled(true);
        this.onlineSearchSequence.abortSearch();
        this.form.resetAfterAbort();
        return 0;
    }
}

