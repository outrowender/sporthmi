/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.interapp.media.DVDVideoSettingsLanguageMapping;

public abstract class AbstractSettingsList
extends AbstractMediaTerminalComponent
implements BaseListModelListener {
    protected final String EMPTY_TEXT;
    protected final DVDVideoSettingsLanguageMapping languageMapper = new DVDVideoSettingsLanguageMapping();
    private static final String LOGCLASS;

    protected AbstractSettingsList(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.EMPTY_TEXT = "";
    }

    protected abstract int getCheckboxColumn() {
    }

    protected abstract BaseListModelApp getListModel() {
    }

    protected abstract void entrySelected(int n) {
    }

    protected boolean updateActiveEntry(int n) {
        EvoListRow evoListRow;
        this.logger.hmi().log(1078071040, "[%1.updateActiveEntry] Select entry '%2'.", (Object)"AbstractSettingsList", (long)n);
        BaseListModelApp baseListModelApp = this.getListModel();
        BaseListModelApp baseListModelApp2 = baseListModelApp.getCopy();
        SelectedItem selectedItem = baseListModelApp2.getSelected();
        if (selectedItem != null && selectedItem.getIndex() != n && (evoListRow = baseListModelApp2.getRow(selectedItem.getIndex())) != null) {
            evoListRow.setInteger(this.getCheckboxColumn(), 0);
            baseListModelApp2.setRow(selectedItem.getIndex(), evoListRow);
        }
        evoListRow = baseListModelApp2.getRow(n);
        if (n < 0 || n >= baseListModelApp.getLength() || evoListRow == null) {
            this.logger.hmi().log(1078071040, "[%1.updateActiveEntry] Index out of range or selected row is null. Ignore.", (Object)"AbstractSettingsList");
            baseListModelApp2.setSelectedIndex(n);
            baseListModelApp.update(baseListModelApp2);
            return false;
        }
        baseListModelApp2.setSelectedIndex(n);
        evoListRow.setInteger(this.getCheckboxColumn(), 1);
        baseListModelApp2.setRow(n, evoListRow);
        baseListModelApp.update(baseListModelApp2);
        return true;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logger.hmi().log(1078071040, "[%1.itemSelected] model '%2', row '%3'.", (Object)"AbstractSettingsList", (long)n, evoListRow.getUniqueID());
        this.entrySelected(n2);
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

