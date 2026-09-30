/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.sdars.seek.AbstractListControllerButtonHandler;
import de.audi.tuner.app.sdars.seek.AbstractTeamRow;

public class SelectedTeamRow
extends AbstractTeamRow
implements AbstractListControllerButtonHandler.IMarkableRow {
    private static final int INDEX_SELTEAMS_LEAGUE_NAME = 0;
    private static final int INDEX_SELTEAMS_TEAM_NAME = 1;
    private static final int INDEX_SELTEAMS_ACTIVATION_CHECKBOX = 2;
    private static final int INDEX_SELTEAMS_MARKING_CHECKBOX = 3;
    private static final int INDEX_SELTEAMS_ID = 4;
    private static final int INDEX_LEAGUE_TEAM_SEPARATOR_CHAR = 5;
    private static final int INDEX_PROPERTIES = 6;
    private static final int SELTEAMS_COLUMNS = 7;

    SelectedTeamRow(String string, int n, int n2, String string2) {
        super(n2, n, 7);
        this.setText(0, string);
        this.setText(1, string2);
        this.setInteger(2, TunerModels.booleanToCheckboxConstant(true));
        this.setInteger(3, TunerModels.booleanToCheckboxConstant(false));
        this.setInteger(4, n2);
        this.setText(5, "-");
        this.setPropertyCell(6, new PropertyListCell(0, new int[0]));
    }

    private SelectedTeamRow(SelectedTeamRow selectedTeamRow) {
        super(selectedTeamRow);
    }

    public EvoListRow copy() {
        return new SelectedTeamRow(this);
    }

    public int getTeamID() {
        return this.getInteger(4);
    }

    int getActivationCheckBox() {
        return this.getInteger(2);
    }

    int getMarkingCheckBox() {
        return this.getInteger(3);
    }

    public void setActivationCheckbox(boolean bl) {
        int n = TunerModels.booleanToCheckboxConstant(bl);
        this.setInteger(2, n);
    }

    public int setMarkingCheckbox(boolean bl) {
        int n = this.getInteger(3);
        int n2 = TunerModels.booleanToCheckboxConstant(bl);
        this.setInteger(3, n2);
        if (n != n2) {
            return bl ? 1 : -1;
        }
        return 0;
    }

    public boolean isActivationCheckboxSelected() {
        return TunerModels.checkboxConstantToBoolean(this.getInteger(2));
    }

    public boolean isMarkingCheckboxSelected() {
        return TunerModels.checkboxConstantToBoolean(this.getInteger(3));
    }

    public void toggleActivationCheckbox() {
        this.setActivationCheckbox(!this.isActivationCheckboxSelected());
    }

    public int toggleMarkCheckbox() {
        return this.setMarkingCheckbox(!this.isMarkingCheckboxSelected());
    }
}

