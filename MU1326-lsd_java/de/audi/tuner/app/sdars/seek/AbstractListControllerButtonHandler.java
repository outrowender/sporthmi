/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tuner.app.sdars.seek.AbstractListControllerButtonHandler$IMarkableRow;
import de.audi.tuner.app.sdars.seek.SelectedTeamRow;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListControllerButtonHandler
extends DefaultButtonListener {
    private int markedEntryCount = 0;
    protected BaseListModelApp list;
    private final ButtonModelApp markAllButtonId;
    private final ButtonModelApp unmarkAllButtonId;
    private final ButtonModelApp deleteButtonId;

    public AbstractListControllerButtonHandler(BaseListModelApp baseListModelApp, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ButtonModelApp buttonModelApp3) {
        this.markAllButtonId = buttonModelApp;
        this.unmarkAllButtonId = buttonModelApp2;
        this.deleteButtonId = buttonModelApp3;
        this.setList(baseListModelApp);
        buttonModelApp.setButtonListener(this);
        buttonModelApp2.setButtonListener(this);
        buttonModelApp3.setButtonListener(this);
        this.setAllEntriesMarked(false);
    }

    public void setList(BaseListModelApp baseListModelApp) {
        this.list = baseListModelApp;
        this.markedEntryCount = 0;
        this.updateControllerButtons();
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.markAllButtonId.getID()) {
            this.setAllEntriesMarked(true);
        } else if (n == this.unmarkAllButtonId.getID()) {
            this.setAllEntriesMarked(false);
        } else {
            List list = this.getMarkedEntries();
            this.deleteMarkedRows(list);
        }
    }

    private void setAllEntriesMarked(boolean bl) {
        for (int i2 = 0; i2 < this.list.getLength(); ++i2) {
            SelectedTeamRow selectedTeamRow = (SelectedTeamRow)this.list.getRow(i2);
            this.markedEntryCount += selectedTeamRow.setMarkingCheckbox(bl);
            this.list.setRow(i2, selectedTeamRow);
        }
        this.updateControllerButtons();
    }

    private List getMarkedEntries() {
        int n = this.list.getLength();
        ArrayList arrayList = new ArrayList(n);
        for (int i2 = 0; i2 < this.list.getLength(); ++i2) {
            EvoListRow evoListRow = this.list.getRow(i2);
            if (!((AbstractListControllerButtonHandler$IMarkableRow)((Object)evoListRow)).isMarkingCheckboxSelected()) continue;
            arrayList.add(evoListRow);
        }
        return arrayList;
    }

    protected abstract void deleteMarkedRows(List list) {
    }

    private void updateControllerButtons() {
        int n = this.list.getLength() - this.markedEntryCount;
        this.deleteButtonId.setStatus(this.markedEntryCount > 0 ? 1 : 3);
        this.unmarkAllButtonId.setStatus(this.markedEntryCount > 0 ? 1 : 3);
        this.markAllButtonId.setStatus(n > 0 ? 1 : 3);
    }

    public void toggleRow(int n) {
        EvoListRow evoListRow = this.list.getRow(n);
        this.markedEntryCount += ((AbstractListControllerButtonHandler$IMarkableRow)((Object)evoListRow)).toggleMarkCheckbox();
        this.list.setRow(n, evoListRow);
        this.updateControllerButtons();
    }
}

