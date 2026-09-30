/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IProgressManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItem;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;

public class SwdlListItemProgress
extends AbstractSwdlListItem {
    private static final String SWDL_CLASS_NAME = "[SwdlListItemProgress]";
    private int type;
    private int value;
    private IProgressManager progressManager;

    public SwdlListItemProgress(IProgressManager iProgressManager, ISwdlListItem iSwdlListItem, int n, DeviceOverviewProgress deviceOverviewProgress) {
        super(iSwdlListItem, n, deviceOverviewProgress.fileName);
        this.type = deviceOverviewProgress.type;
        this.value = deviceOverviewProgress.value;
        this.progressManager = iProgressManager;
    }

    public void updateListRow(BaseListRow baseListRow) {
        baseListRow.setInteger(0, this.getId());
        baseListRow.setText(1, this.getName());
        baseListRow.setInteger(3, 0);
        baseListRow.setInteger(5, 0);
        if (2 == this.type) {
            baseListRow.setText(2, "");
            baseListRow.setText(4, Integer.toString(this.value));
            baseListRow.setInteger(6, 1);
        } else if (this.value >= 0) {
            baseListRow.setText(2, Integer.toString(this.value).concat("%"));
            baseListRow.setText(4, "");
            baseListRow.setInteger(6, 0);
        } else {
            baseListRow.setText(2, Integer.toString(this.value));
            baseListRow.setText(4, "");
            baseListRow.setInteger(6, 2);
        }
    }

    public void select(int n) {
        this.progressManager.selectForDetails(this.getName());
    }

    public String getSwdlClassName() {
        return SWDL_CLASS_NAME;
    }
}

