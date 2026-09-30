/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.bcme;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.bcme.AbstractConsumerDisplayComponent;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class ConsumerDisplayComponentEvo
extends AbstractConsumerDisplayComponent {
    private static final int MAX_DISPLAYABLE_CONSUMERS = 3;

    public ConsumerDisplayComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(BCmEViewOptions bCmEViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(18, this.getMenuEntryVisibilityState(bCmEViewOptions.getCurrentRange()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(19, this.getMenuEntryVisibilityState(bCmEViewOptions.getCurrentRange()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(20, this.getMenuEntryVisibilityState(bCmEViewOptions.getConsumerListRange()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(21, this.getMenuEntryVisibilityState(new CarViewOption[]{bCmEViewOptions.getCatalogueRange(), bCmEViewOptions.getCurrentRange()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(251, this.isConsumerListRequestBlocked() || this.getMenuEntryVisibilityState(bCmEViewOptions.getConsumerList()) != 0 ? 1 : 0);
        if (bCmEViewOptions.getConsumption().state == 0) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(252, 1);
        } else if (bCmEViewOptions.getConsumption().state == 2) {
            if (this.isCurrentConsumptionInvalid()) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(252, 2);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(252, 0);
            }
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(252, 7);
        }
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(18, (short)36);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(19, (short)36);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(20, (short)36);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(21, (short)36);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(251, (short)36);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(252, (short)36);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(18);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(19);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(20);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(21);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(251);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(252);
    }

    public int getID() {
        return 26;
    }

    protected int getMaxNrDisplayableConsumers() {
        return 3;
    }

    public void updateBCmEListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        this.getLogChannel().log(1000000, "[ConsumerDisplayComponentEvo#updateBCmEListUpdateInfo] Ignored on the RangeMonitor System");
    }

    public void responseBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerList[] bCmEConsumerListArray) {
        this.getLogChannel().log(1000000, "[ConsumerDisplayComponentEvo#responseBCmEConsumerList] Ignored on the RangeMonitor System");
    }

    public void updateBCmEConsumerListTotalNumberOfElements(int n, int n2) {
        this.getLogChannel().log(1000000, "[ConsumerDisplayComponentEvo#updateBCmEConsumerListTotalNumberOfElements] Ignored on the RangeMonitor System");
    }
}

