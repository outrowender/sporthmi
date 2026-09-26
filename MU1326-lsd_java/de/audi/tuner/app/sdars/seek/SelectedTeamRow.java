/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.sdars.seek.AbstractListControllerButtonHandler$IMarkableRow;
import de.audi.tuner.app.sdars.seek.AbstractTeamRow;

public class SelectedTeamRow
extends AbstractTeamRow
implements AbstractListControllerButtonHandler$IMarkableRow {
    private static final int INDEX_SELTEAMS_LEAGUE_NAME;
    private static final int INDEX_SELTEAMS_TEAM_NAME;
    private static final int INDEX_SELTEAMS_ACTIVATION_CHECKBOX;
    private static final int INDEX_SELTEAMS_MARKING_CHECKBOX;
    private static final int INDEX_SELTEAMS_ID;
    private static final int INDEX_LEAGUE_TEAM_SEPARATOR_CHAR;
    private static final int INDEX_PROPERTIES;
    private static final int SELTEAMS_COLUMNS;

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

    @Override
    public EvoListRow copy() {
        return new SelectedTeamRow(this);
    }

    @Override
    public int getTeamID() {
        return this.getInteger(4);
    }

    @Override
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

    @Override
    public boolean isMarkingCheckboxSelected() {
        return TunerModels.checkboxConstantToBoolean(this.getInteger(3));
    }

    public void toggleActivationCheckbox() {
        this.setActivationCheckbox(!this.isActivationCheckboxSelected());
    }

    @Override
    public int toggleMarkCheckbox() {
        return this.setMarkingCheckbox(!this.isMarkingCheckboxSelected());
    }
}

