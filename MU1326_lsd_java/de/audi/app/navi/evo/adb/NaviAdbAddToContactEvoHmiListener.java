/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.adb;

import de.audi.app.navi.evo.adb.AddAddressToContactSelectionListRow;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;

public class NaviAdbAddToContactEvoHmiListener
implements BaseListModelListener,
ButtonListener {
    private NavigationEnv env;
    private LogChannel lc;
    private NaviADBHandler adbHandler;

    public NaviAdbAddToContactEvoHmiListener(NavigationEnv navigationEnv, LogChannel logChannel, NaviADBHandler naviADBHandler) {
        this.env = navigationEnv;
        this.lc = logChannel;
        this.adbHandler = naviADBHandler;
        this.registerListeners();
    }

    private void registerListeners() {
        this.env.getHMIService().getButtonModel(401488).setButtonListener(this);
        this.env.getHMIService().getBaseListModel(401549).setListener(this);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.lc.log(10000000, "NaviAdbAddToContactEvoHmiListener#keyPressed, modelID=%1", (long)n);
        this.adbHandler.finishStoringLocation();
        this.env.getHMIService().getButtonModel(n).fireEvent(n3);
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "NaviAdbAddToContactEvoHmiListener#itemSelected, row is [%1]", (Object)evoListRow);
        AddAddressToContactSelectionListRow addAddressToContactSelectionListRow = (AddAddressToContactSelectionListRow)evoListRow;
        this.setAddressTypeModel(this.getAddressType(addAddressToContactSelectionListRow));
        if (this.isAddressAvailableOnRow(addAddressToContactSelectionListRow)) {
            this.setAddressAvailableChoiceModel(true);
        } else {
            this.setAddressAvailableChoiceModel(false);
            this.adbHandler.finishStoringLocation();
        }
        this.env.getHMIService().getBaseListModel(n).fireEvent(n4);
    }

    private void setAddressTypeModel(int n) {
        this.env.getChoiceModel(400515).setValue(n);
    }

    private boolean isAddressAvailableOnRow(AddAddressToContactSelectionListRow addAddressToContactSelectionListRow) {
        return addAddressToContactSelectionListRow.isAddressPresent();
    }

    private void setAddressAvailableChoiceModel(boolean bl) {
        this.env.getHMIService().getChoiceModel(401548).setValue(bl ? 1 : 0);
    }

    private int getAddressType(AddAddressToContactSelectionListRow addAddressToContactSelectionListRow) {
        return addAddressToContactSelectionListRow.getCommonlyKnownAddressType();
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

