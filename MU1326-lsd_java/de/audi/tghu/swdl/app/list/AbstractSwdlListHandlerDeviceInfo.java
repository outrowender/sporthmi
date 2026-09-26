/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListHandlerText;

public class AbstractSwdlListHandlerDeviceInfo
extends AbstractSwdlListHandlerText {
    protected static final int DEVICEINFO_SELECTION_LAYOUT;
    protected static final int DEVICEINFO_RESULT_LAYOUT;
    protected static final int DEVICEINFO_STATE_LAYOUT;
    private final IDeviceInfoManager deviceInfoManager;
    private final ChoiceModelApp layoutChoice;

    public AbstractSwdlListHandlerDeviceInfo(IDeviceInfoManager iDeviceInfoManager, SwdlEnv swdlEnv, ListModelApp listModelApp, int n, int n2) {
        super(swdlEnv, listModelApp, n, n2);
        this.deviceInfoManager = iDeviceInfoManager;
        this.layoutChoice = swdlEnv.getSwdlModels().getSelectionLayoutChoice();
    }

    protected final IDeviceInfoManager getDeviceInfoManager() {
        return this.deviceInfoManager;
    }

    protected int getLayout() {
        int n = 0;
        if (this.isStateView()) {
            n = 2;
        } else if (this.isPostcondition() || this.isSummary()) {
            n = 1;
        }
        if (this.layoutChoice != null && this.layoutChoice.getValue() != n) {
            this.layoutChoice.setValue(n);
        }
        return n;
    }

    @Override
    public ListCell[] getNewRow() {
        ListCell[] listCellArray = new ListCell[this.getNrCol()];
        listCellArray[0] = new IntegerListCell(-1, 99);
        listCellArray[1] = new TextListCell("");
        listCellArray[2] = new IntegerListCell(0, 1);
        listCellArray[3] = new IntegerListCell(0, 3);
        return listCellArray;
    }

    protected boolean isSelection() {
        return this.getDeviceInfoManager().checkAccessType(1);
    }

    protected boolean isPrecondition() {
        return this.getDeviceInfoManager().checkAccessType(3);
    }

    protected boolean isPostcondition() {
        return this.getDeviceInfoManager().checkAccessType(4);
    }

    protected boolean isSummary() {
        return this.getDeviceInfoManager().checkAccessType(2);
    }

    protected boolean isStateView() {
        return this.getDeviceInfoManager().isStateView();
    }

    protected boolean isStandardSelection() {
        return this.getDeviceInfoManager().isStandardSelection();
    }
}

