/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.SettingsStorage;
import de.audi.tv.app.settings.TVNormList$ListListener;
import de.audi.tv.app.settings.TVNormList$ResetButtonListener;
import de.audi.tv.app.settings.TVNormList$TVNormRow;

public class TVNormList {
    private static final int TV_NORM_FACTORY_SETTINGS_INTERNAL;
    private static final int TVNORM_EMPTY_PREVIEW_INDEX;
    static final int DEFAULT;
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
        this.tvNormList = tVEnv.getBaseListModel(1454122752);
        this.tvNormList.setListener(new TVNormList$ListListener(this, null));
        this.tvNormPreview = tVEnv.getChoiceModel(1772889856);
        tVEnv.getButtonModel(-1582553344).setButtonListener(new TVNormList$ResetButtonListener(this, null));
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
        this.env.lcHMI.log(-2137614336, "[TVNormList.updateTVNormList] items:%1", (long)nArray.length);
        BaseListModelApp baseListModelApp = this.tvNormList.getEmptyCopy();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            TVNormList$TVNormRow tVNormList$TVNormRow = new TVNormList$TVNormRow(this, nArray[i2], 0);
            baseListModelApp.append(tVNormList$TVNormRow);
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
            TVNormList$TVNormRow tVNormList$TVNormRow = (TVNormList$TVNormRow)baseListModelApp.getRow(i2);
            int n3 = tVNormList$TVNormRow.id;
            int n4 = 0;
            if (n3 == this.activeTVNorm) {
                n4 = 1;
                n2 = i2;
            }
            tVNormList$TVNormRow.setSelected(n4);
            baseListModelApp.setRow(i2, tVNormList$TVNormRow);
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

    static /* synthetic */ TVEnv access$200(TVNormList tVNormList) {
        return tVNormList.env;
    }

    static /* synthetic */ void access$300(TVNormList tVNormList, int n) {
        tVNormList.setTVNorm(n);
    }
}

