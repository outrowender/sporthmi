/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.settings.SettingsStorage;
import de.audi.tv.app.settings.parental.IChildLockListener;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class ParentalLevelList {
    public static final int DEFAULT_PML_LEVEL = 0;
    private static final int PARENTAL_LEVEL_UNLOCKED = 0;
    private static final int PARENTAL_LEVEL_LOCKED = 1;
    private final BaseListModelApp levelList;
    private final ChoiceModelApp levelChoice;
    private final TVEnv env;
    private final SettingsStorage storage;
    public final DSICallListener callListener = new SelectionListener();
    private final IChildLockListener childLockListener;
    private volatile int currentRequiredAge = 0;
    private boolean isChildLockActive = false;

    public ParentalLevelList(TVEnv tVEnv, SettingsStorage settingsStorage, IChildLockListener iChildLockListener) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.childLockListener = iChildLockListener;
        this.levelChoice = tVEnv.getChoiceModel(2600013);
        this.levelList = tVEnv.getBaseListModel(2600019);
        this.levelList.setListener(new ListListener());
        this.fillLevelList();
    }

    private void fillLevelList() {
        EvoListRow[] evoListRowArray = new ParentalLevelRow[]{new ParentalLevelRow(0), new ParentalLevelRow(1), new ParentalLevelRow(2), new ParentalLevelRow(3), new ParentalLevelRow(4), new ParentalLevelRow(5), new ParentalLevelRow(6), new ParentalLevelRow(7), new ParentalLevelRow(8), new ParentalLevelRow(9), new ParentalLevelRow(10), new ParentalLevelRow(11), new ParentalLevelRow(12)};
        this.levelList.append(evoListRowArray);
    }

    public void restore() {
        int n = this.storage.loadParentalLevel();
        ParentalLevelRow parentalLevelRow = (ParentalLevelRow)this.levelList.getRow(n);
        parentalLevelRow.setSelected(1);
        this.levelList.setRow(n, parentalLevelRow);
        this.levelList.setSelectedIndex(n);
        this.levelChoice.setValue(n);
        this.childLockListener.parentalLevelSettingChanged(parentalLevelRow.ageLevel);
        this.env.lcMain.log(10000000, "[ParentalLevelList.restore] selected:%1", (long)n);
    }

    private int getSelectedAgeLevel() {
        if (this.env.getChoiceModel(2600058).getValue() == 0) {
            return 0;
        }
        SelectedItem selectedItem = this.levelList.getSelected();
        if (selectedItem == null) {
            this.restore();
            this.env.lcMain.log(100000, "[ParentalLevelList.getSelectedAgeLevel] no level information, trying to restore data!");
        }
        if ((selectedItem = this.levelList.getSelected()) == null) {
            ParentalLevelRow parentalLevelRow = (ParentalLevelRow)this.levelList.getRow(0);
            parentalLevelRow.setSelected(1);
            this.levelList.setRow(0, parentalLevelRow);
            this.levelList.setSelectedIndex(0);
            this.levelChoice.setValue(0);
            selectedItem = this.levelList.getSelected();
            this.env.lcMain.log(100000, "[ParentalLevelList.getSelectedAgeLevel] unable to restore data -> defaults loaded!");
        }
        return ((ParentalLevelRow)this.levelList.getRow((int)selectedItem.getIndex())).ageLevel;
    }

    private int getIndexForNeededAgeLevel(int n) {
        for (int i2 = 0; i2 < this.levelList.getLength(); ++i2) {
            ParentalLevelRow parentalLevelRow = (ParentalLevelRow)this.levelList.getRow(i2);
            if (parentalLevelRow.ageLevel < n) continue;
            return i2;
        }
        return 0;
    }

    public void updateRequiredAge(short s) {
        this.currentRequiredAge = TVUtil.singleByteBCDToDual(s);
        this.env.getChoiceModel(2600079).setValue(this.getIndexForNeededAgeLevel(this.currentRequiredAge));
        int n = this.getSelectedAgeLevel();
        this.env.getChoiceModel(2600080).setValue(0);
        if (this.currentRequiredAge > n && n != 0) {
            if (!this.isChildLockActive) {
                this.childLockListener.onChildLockEnabled();
                this.isChildLockActive = true;
            }
            this.env.getChoiceModel(2600080).setValue(1);
        } else if (this.isChildLockActive) {
            this.childLockListener.onChildLockDisabled();
            this.isChildLockActive = false;
        }
    }

    private class ListListener
    extends DefaultBaseListModelListener {
        private ListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            ((ParentalLevelList)ParentalLevelList.this).env.lcHMI.log(10000000, "[ParentalLevelList.itemSelected] selected:%1", (long)n2);
            int n5 = ParentalLevelList.this.levelList.getSelected().getIndex();
            if (n2 != n5) {
                ParentalLevelRow parentalLevelRow = (ParentalLevelRow)ParentalLevelList.this.levelList.getRow(n5);
                parentalLevelRow.setSelected(0);
                ((ParentalLevelRow)evoListRow).setSelected(1);
                ParentalLevelList.this.levelChoice.setValue(n2);
                ParentalLevelList.this.levelList.setRow(n2, evoListRow);
                ParentalLevelList.this.levelList.setRow(n5, parentalLevelRow);
                ParentalLevelList.this.levelList.setSelectedIndex(n2);
                ParentalLevelList.this.storage.saveParentalLevel(n2);
                int n6 = ParentalLevelList.this.getSelectedAgeLevel();
                if (ParentalLevelList.this.currentRequiredAge > n6 && n6 != 0) {
                    ParentalLevelList.this.childLockListener.onChildLockEnabled();
                    ParentalLevelList.this.env.getChoiceModel(2600080).setValue(1);
                } else {
                    ParentalLevelList.this.env.getChoiceModel(2600080).setValue(0);
                    ParentalLevelList.this.childLockListener.onChildLockDisabled();
                }
                ParentalLevelList.this.childLockListener.parentalLevelSettingChanged(n6);
                ParentalLevelList.this.levelList.fireEvent(n4);
            }
        }
    }

    private class ParentalLevelRow
    extends EvoListRow {
        private static final int MAX_COLUMNS = 4;
        private static final int COL_ID = 0;
        private static final int COL_SELECTED = 1;
        private static final int COL_CLOSE_OPTIONS = 2;
        private static final int COL_RECORDSET = 3;
        private static final int RECORDSET_UNRESTRICTED = 0;
        private static final int RECORDSET_RESTRICTED = 1;
        static final int LEVEL_SELECTED = 1;
        static final int LEVEL_UNSELECTED = 0;
        final int ageLevel;

        ParentalLevelRow(int n) {
            this(n, 0);
        }

        ParentalLevelRow(int n, int n2) {
            super(n, 4);
            this.ageLevel = n * 2;
            this.setInteger(0, n);
            this.setInteger(1, n2);
            this.setInteger(2, 1);
            this.setInteger(3, n == 0 ? 0 : 1);
        }

        private ParentalLevelRow(ParentalLevelRow parentalLevelRow) {
            super(parentalLevelRow);
            this.ageLevel = parentalLevelRow.ageLevel;
        }

        void setSelected(int n) {
            this.setInteger(1, n);
        }

        public EvoListRow copy() {
            return new ParentalLevelRow(this);
        }
    }

    private class SelectionListener
    extends DSICallListener {
        private SelectionListener() {
        }

        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            ParentalLevelList.this.env.getChoiceModel(2600080).setValue(0);
        }

        public void selectNextService(int n) {
            ParentalLevelList.this.env.getChoiceModel(2600080).setValue(0);
        }
    }
}

