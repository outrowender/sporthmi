/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.seek.AbstractListControllerButtonHandler;
import de.audi.tuner.app.sdars.seek.SelectedTeamRow;
import de.audi.tuner.ifc.ITunerVariantExt;
import java.util.Iterator;
import java.util.List;

class GameHandler$SelectedTeamsControllerButtonHandler
extends AbstractListControllerButtonHandler {
    private final SDARSDSISeekDownManager dsiSeek;
    private final ITunerVariantExt variantExt;

    public GameHandler$SelectedTeamsControllerButtonHandler(BaseListModelApp baseListModelApp, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ButtonModelApp buttonModelApp3, SDARSDSISeekDownManager sDARSDSISeekDownManager, ITunerVariantExt iTunerVariantExt) {
        super(baseListModelApp, buttonModelApp, buttonModelApp2, buttonModelApp3);
        this.dsiSeek = sDARSDSISeekDownManager;
        this.variantExt = iTunerVariantExt;
    }

    @Override
    public void deleteMarkedRows(List list) {
        int n = this.list.getLength();
        int[] nArray = new int[list.size()];
        int[] nArray2 = new int[list.size()];
        int n2 = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SelectedTeamRow selectedTeamRow = (SelectedTeamRow)iterator.next();
            nArray[n2] = selectedTeamRow.getTeamID();
            nArray2[n2] = selectedTeamRow.getLeagueId();
            ++n2;
        }
        this.dsiSeek.bulkManageSeek2(3, nArray, nArray2, 3);
        this.variantExt.showPartialPopup(4);
        if (n == list.size()) {
            this.list.fireEvent(0);
        }
    }
}

