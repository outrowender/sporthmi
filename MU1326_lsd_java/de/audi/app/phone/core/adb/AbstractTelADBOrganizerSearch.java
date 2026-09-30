/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.search.organizer.AbstractADBOrganizerSearch;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.DataSet;

public abstract class AbstractTelADBOrganizerSearch
extends AbstractADBOrganizerSearch {
    private final TiledListModelApp matchList;
    protected final HMIService hmiService;

    protected AbstractTelADBOrganizerSearch(HMIService hMIService, ADBApplication aDBApplication, LogChannel logChannel) {
        super(hMIService.getTiledListModel(300748), hMIService.getMatchSpellerModel(300749), null, hMIService.getChoiceModel(300750), aDBApplication, logChannel);
        this.matchList = hMIService.getTiledListModel(300748);
        this.hmiService = hMIService;
    }

    protected AbstractTelADBOrganizerSearch(HMIService hMIService, TiledListModelApp tiledListModelApp, MatchspellerModelApp matchspellerModelApp, HMIModelApp hMIModelApp, ADBApplication aDBApplication, LogChannel logChannel) {
        super(tiledListModelApp, matchspellerModelApp, null, hMIModelApp, aDBApplication, logChannel);
        this.matchList = tiledListModelApp;
        this.hmiService = hMIService;
    }

    public EvoListRow[] createSearchListRows(DataSet[] dataSetArray) {
        return this.getRows(dataSetArray);
    }

    protected abstract EvoListRow[] getRows(DataSet[] var1);

    protected TiledListModelApp getMatchListModel() {
        return this.matchList;
    }
}

