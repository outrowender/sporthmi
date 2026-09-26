/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.common.search.organizer;

import de.audi.app.addressbook.core.common.search.organizer.AbstractADBOrganizerSearch;
import de.audi.app.addressbook.evo.common.ADBEvoApplication;
import de.audi.app.addressbook.evo.common.search.organizer.ADBEvoOrganizerSearchListRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.DataSet;

public class ADBEvoOrganizerSearch
extends AbstractADBOrganizerSearch {
    protected ADBEvoApplication appAdr;
    protected int entryDrawerCategory;

    public ADBEvoOrganizerSearch(TiledListModelApp tiledListModelApp, MatchspellerModelApp matchspellerModelApp, ResourceLocatorModelApp resourceLocatorModelApp, HMIModelApp hMIModelApp, ADBEvoApplication aDBEvoApplication, LogChannel logChannel, int n) {
        super(tiledListModelApp, matchspellerModelApp, resourceLocatorModelApp, hMIModelApp, aDBEvoApplication, logChannel);
        this.appAdr = aDBEvoApplication;
        this.entryDrawerCategory = n;
    }

    @Override
    public void setRowOpenState(EvoListRow evoListRow, boolean bl, BaseListModelApp baseListModelApp) {
        if (evoListRow != null && evoListRow instanceof ADBEvoOrganizerSearchListRow) {
            ((ADBEvoOrganizerSearchListRow)evoListRow).setOpen(bl);
            baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(evoListRow.getUniqueID()), evoListRow);
        } else {
            this.log.log(-1601830656, "ADBEvoOrganizerSearch#setRowOpenState null row passed to the method");
        }
    }

    @Override
    public EvoListRow[] createSearchListRows(DataSet[] dataSetArray) {
        return ADBEvoOrganizerSearchListRow.createFromDataSets(dataSetArray, this.appAdr.getAdbMode(), this.entryDrawerCategory);
    }
}

