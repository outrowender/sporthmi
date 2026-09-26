/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.settings.SettingsStorage;
import de.audi.tv.app.settings.parental.IChildLockListener;
import de.audi.tv.app.settings.parental.ParentalLevelList$ListListener;
import de.audi.tv.app.settings.parental.ParentalLevelList$ParentalLevelRow;
import de.audi.tv.app.settings.parental.ParentalLevelList$SelectionListener;

public class ParentalLevelList {
    public static final int DEFAULT_PML_LEVEL;
    private static final int PARENTAL_LEVEL_UNLOCKED;
    private static final int PARENTAL_LEVEL_LOCKED;
    private final BaseListModelApp levelList;
    private final ChoiceModelApp levelChoice;
    private final TVEnv env;
    private final SettingsStorage storage;
    public final DSICallListener callListener = new ParentalLevelList$SelectionListener(this, null);
    private final IChildLockListener childLockListener;
    private volatile int currentRequiredAge = 0;
    private boolean isChildLockActive = false;

    public ParentalLevelList(TVEnv tVEnv, SettingsStorage settingsStorage, IChildLockListener iChildLockListener) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.childLockListener = iChildLockListener;
        this.levelChoice = tVEnv.getChoiceModel(1303127808);
        this.levelList = tVEnv.getBaseListModel(1403791104);
        this.levelList.setListener(new ParentalLevelList$ListListener(this, null));
        this.fillLevelList();
    }

    private void fillLevelList() {
        EvoListRow[] evoListRowArray = new ParentalLevelList$ParentalLevelRow[]{new ParentalLevelList$ParentalLevelRow(this, 0), new ParentalLevelList$ParentalLevelRow(this, 1), new ParentalLevelList$ParentalLevelRow(this, 2), new ParentalLevelList$ParentalLevelRow(this, 3), new ParentalLevelList$ParentalLevelRow(this, 4), new ParentalLevelList$ParentalLevelRow(this, 5), new ParentalLevelList$ParentalLevelRow(this, 6), new ParentalLevelList$ParentalLevelRow(this, 7), new ParentalLevelList$ParentalLevelRow(this, 8), new ParentalLevelList$ParentalLevelRow(this, 9), new ParentalLevelList$ParentalLevelRow(this, 10), new ParentalLevelList$ParentalLevelRow(this, 11), new ParentalLevelList$ParentalLevelRow(this, 12)};
        this.levelList.append(evoListRowArray);
    }

    public void restore() {
        int n = this.storage.loadParentalLevel();
        ParentalLevelList$ParentalLevelRow parentalLevelList$ParentalLevelRow = (ParentalLevelList$ParentalLevelRow)this.levelList.getRow(n);
        parentalLevelList$ParentalLevelRow.setSelected(1);
        this.levelList.setRow(n, parentalLevelList$ParentalLevelRow);
        this.levelList.setSelectedIndex(n);
        this.levelChoice.setValue(n);
        this.childLockListener.parentalLevelSettingChanged(parentalLevelList$ParentalLevelRow.ageLevel);
        this.env.lcMain.log(-2137614336, "[ParentalLevelList.restore] selected:%1", (long)n);
    }

    private int getSelectedAgeLevel() {
        if (this.env.getChoiceModel(2058102528).getValue() == 0) {
            return 0;
        }
        SelectedItem selectedItem = this.levelList.getSelected();
        if (selectedItem == null) {
            this.restore();
            this.env.lcMain.log(-1601830656, "[ParentalLevelList.getSelectedAgeLevel] no level information, trying to restore data!");
        }
        if ((selectedItem = this.levelList.getSelected()) == null) {
            ParentalLevelList$ParentalLevelRow parentalLevelList$ParentalLevelRow = (ParentalLevelList$ParentalLevelRow)this.levelList.getRow(0);
            parentalLevelList$ParentalLevelRow.setSelected(1);
            this.levelList.setRow(0, parentalLevelList$ParentalLevelRow);
            this.levelList.setSelectedIndex(0);
            this.levelChoice.setValue(0);
            selectedItem = this.levelList.getSelected();
            this.env.lcMain.log(-1601830656, "[ParentalLevelList.getSelectedAgeLevel] unable to restore data -> defaults loaded!");
        }
        return ((ParentalLevelList$ParentalLevelRow)this.levelList.getRow((int)selectedItem.getIndex())).ageLevel;
    }

    private int getIndexForNeededAgeLevel(int n) {
        for (int i2 = 0; i2 < this.levelList.getLength(); ++i2) {
            ParentalLevelList$ParentalLevelRow parentalLevelList$ParentalLevelRow = (ParentalLevelList$ParentalLevelRow)this.levelList.getRow(i2);
            if (parentalLevelList$ParentalLevelRow.ageLevel < n) continue;
            return i2;
        }
        return 0;
    }

    public void updateRequiredAge(short s) {
        this.currentRequiredAge = TVUtil.singleByteBCDToDual(s);
        this.env.getChoiceModel(-1884543232).setValue(this.getIndexForNeededAgeLevel(this.currentRequiredAge));
        int n = this.getSelectedAgeLevel();
        this.env.getChoiceModel(-1867766016).setValue(0);
        if (this.currentRequiredAge > n && n != 0) {
            if (!this.isChildLockActive) {
                this.childLockListener.onChildLockEnabled();
                this.isChildLockActive = true;
            }
            this.env.getChoiceModel(-1867766016).setValue(1);
        } else if (this.isChildLockActive) {
            this.childLockListener.onChildLockDisabled();
            this.isChildLockActive = false;
        }
    }

    static /* synthetic */ TVEnv access$200(ParentalLevelList parentalLevelList) {
        return parentalLevelList.env;
    }

    static /* synthetic */ BaseListModelApp access$300(ParentalLevelList parentalLevelList) {
        return parentalLevelList.levelList;
    }

    static /* synthetic */ ChoiceModelApp access$400(ParentalLevelList parentalLevelList) {
        return parentalLevelList.levelChoice;
    }

    static /* synthetic */ SettingsStorage access$500(ParentalLevelList parentalLevelList) {
        return parentalLevelList.storage;
    }

    static /* synthetic */ int access$600(ParentalLevelList parentalLevelList) {
        return parentalLevelList.getSelectedAgeLevel();
    }

    static /* synthetic */ int access$700(ParentalLevelList parentalLevelList) {
        return parentalLevelList.currentRequiredAge;
    }

    static /* synthetic */ IChildLockListener access$800(ParentalLevelList parentalLevelList) {
        return parentalLevelList.childLockListener;
    }
}

