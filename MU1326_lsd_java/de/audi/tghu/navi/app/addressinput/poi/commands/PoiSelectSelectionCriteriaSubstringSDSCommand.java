/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiSelectSelectionCriteriaSubstringSDSCommand
extends PoiSelectSelectionCriteriaSubstringCommand {
    private boolean ignoreFurtherUpdates = false;
    private final Timer timer;
    private final ValueListStatus fakedFinishedSearchStatusWithNoResults = new ValueListStatus(3, 0, 0);

    public PoiSelectSelectionCriteriaSubstringSDSCommand(int n, int n2, SubstringSearchHandler substringSearchHandler) {
        super(n, n2, substringSearchHandler);
        this.timer = new Timer("POI Search Waiting Timer", 10000L, true, this);
    }

    public void execute() {
        this.logger.log(1000000, "%1#execute() - selectionCriteriaIndex: %2, maxItemsCount: %3", (Object)this.CLASS_NAME, (long)this.selectionCriteriaIndex, (long)this.maxItemsCount);
        this.getDSINavigation().poiSelectSelectionCriteria(this.selectionCriteriaIndex);
        this.timer.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fireTimer(Timer timer) {
        this.logger.log(1000000, "%1#fireTimer - timer fired, ending command.", (Object)this.CLASS_NAME);
        ValueListStatus valueListStatus = this.dsiResponseContainer.getPoiSubstringSearchStatus();
        if (valueListStatus == null) {
            valueListStatus = this.fakedFinishedSearchStatusWithNoResults;
        } else {
            valueListStatus.status = 3;
        }
        PoiSelectSelectionCriteriaSubstringSDSCommand poiSelectSelectionCriteriaSubstringSDSCommand = this;
        synchronized (poiSelectSelectionCriteriaSubstringSDSCommand) {
            this.fakeCheckFinished();
            this.updatePoiSubstringSearchStatus(valueListStatus);
            this.ignoreFurtherUpdates = true;
        }
    }

    private void fakeCheckFinished() {
        this.substringSearchStarted = true;
        this.liValueListResponded = true;
        this.lispUpdateSpellerResponded = true;
        this.liResultResponded = true;
    }

    public synchronized void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        this.logger.log(10000000, "%1#updatePoiSubstringSearchStatus( %2 ), minimumItems to move on = %3", (Object)this.CLASS_NAME, (Object)valueListStatus, (long)this.maxItemsCount);
        this.dsiResponseContainer.setPoiSubstringSearchStatus(valueListStatus);
        if (!this.ignoreFurtherUpdates) {
            super.updatePoiSubstringSearchStatus(valueListStatus);
        }
    }

    protected void checkFinished() {
        if (this.liValueListResponded && this.lispUpdateSpellerResponded && this.updatePoiSubstringSearchResponded && this.liResultResponded) {
            this.timer.cancel();
            this.getCommandList().commandFinished();
        }
    }
}

