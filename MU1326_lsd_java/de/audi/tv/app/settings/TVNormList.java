/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.SettingsStorage;

public class TVNormList {
    private static final int TV_NORM_FACTORY_SETTINGS_INTERNAL = 254;
    private static final int TVNORM_EMPTY_PREVIEW_INDEX = 100;
    static final int DEFAULT = 100;
    private final ChoiceModelApp tvNormPreview;
    private final ModelGroup tvNormModelCache = new ModelGroup();
    private final BaseListModelApp tvNormList;
    private volatile int activeTVNorm = 0;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final DSITV dsi;
    private volatile boolean isDsiLocked = false;
    private volatile boolean isResetWaiting = false;

    TVNormList(TVEnv tVEnv, SettingsStorage settingsStorage, DSITV dSITV) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.dsi = dSITV;
        this.tvNormList = tVEnv.getBaseListModel(2600022);
        this.tvNormList.setListener(new ListListener());
        this.tvNormPreview = tVEnv.getChoiceModel(2600041);
        tVEnv.getButtonModel(2600097).setButtonListener(new ResetButtonListener());
        this.tvNormModelCache.add(this.tvNormList);
        this.tvNormModelCache.add(this.tvNormPreview);
    }

    protected void restore() {
        this.dsi.setNormArea(this.storage.loadTVNorm());
    }

    protected void resetToDefault() {
        if (this.isDsiLocked) {
            this.isResetWaiting = true;
        } else {
            this.dsi.setNormArea(254);
            this.isResetWaiting = false;
        }
    }

    protected void dsiLockStateChanged(boolean bl) {
        this.isDsiLocked = bl;
        if (this.isResetWaiting) {
            this.resetToDefault();
        }
    }

    void updateTVNormList(int[] nArray) {
        this.env.lcHMI.log(10000000, "[TVNormList.updateTVNormList] items:%1", (long)nArray.length);
        BaseListModelApp baseListModelApp = this.tvNormList.getEmptyCopy();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            TVNormRow tVNormRow = new TVNormRow(nArray[i2], 0);
            baseListModelApp.append(tVNormRow);
        }
        this.updateTVNormArea(baseListModelApp, this.activeTVNorm);
        this.tvNormList.update(baseListModelApp);
    }

    void updateTVNormArea(int n) {
        this.updateTVNormArea(this.tvNormList, n);
    }

    private void updateTVNormArea(BaseListModelApp baseListModelApp, int n) {
        this.activeTVNorm = n;
        this.storage.saveTVNorm(this.activeTVNorm);
        int n2 = -1;
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            TVNormRow tVNormRow = (TVNormRow)baseListModelApp.getRow(i2);
            int n3 = tVNormRow.id;
            int n4 = 0;
            if (n3 == this.activeTVNorm) {
                n4 = 1;
                n2 = i2;
            }
            tVNormRow.setSelected(n4);
            baseListModelApp.setRow(i2, tVNormRow);
        }
        baseListModelApp.setSelectedIndex(n2);
        this.tvNormPreview.setValue(this.activeTVNorm);
        this.tvNormModelCache.flush();
    }

    private void setTVNorm(int n) {
        if (n != this.activeTVNorm) {
            this.tvNormPreview.setValue(100);
            this.tvNormModelCache.flush();
            this.dsi.setNormArea(n);
        }
    }

    private class TVNormRow
    extends EvoListRow {
        private static final int COL_COUNT = 3;
        private static final int COL_NORM_ID = 0;
        private static final int COL_NORM_SELECTED = 1;
        private static final int COL_NORM_CLOSE_OPTION = 2;
        static final int NORM_NOT_SELECTED = 0;
        static final int NORM_IS_SELECTED = 1;
        final int id;

        private TVNormRow(TVNormRow tVNormRow) {
            super(tVNormRow);
            this.id = tVNormRow.id;
        }

        protected TVNormRow(int n, int n2) {
            super(n, 3);
            this.id = n;
            this.setInteger(0, n);
            this.setInteger(1, n2);
            this.setInteger(2, 1);
        }

        public void setSelected(int n) {
            this.setInteger(1, n);
        }

        public EvoListRow copy() {
            return new TVNormRow(this);
        }
    }

    private class ListListener
    extends DefaultBaseListModelListener {
        private ListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            ((TVNormList)TVNormList.this).env.lcHMI.log(1000000, "[TVNormList.ListListener.listItemSelected] item:%1", evoListRow.getUniqueID());
            TVNormList.this.setTVNorm(((TVNormRow)evoListRow).id);
            TVNormList.this.env.getBaseListModel(2600022).fireEvent(n4);
        }
    }

    private class ResetButtonListener
    extends DefaultButtonListener {
        private ResetButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            ((TVNormList)TVNormList.this).env.lcHMI.log(1000000, "[TVNormList.ResetButtonListener.keyPressed] Reset to default requested.");
            TVNormList.this.setTVNorm(254);
            TVNormList.this.env.getBaseListModel(2600022).fireEvent(n3);
        }
    }
}

