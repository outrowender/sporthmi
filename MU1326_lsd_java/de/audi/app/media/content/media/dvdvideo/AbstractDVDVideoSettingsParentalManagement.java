/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.dvdvideo;

import de.audi.app.media.AbstractSettingsList;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIBaseController;
import de.audi.app.media.dsi.media.IMediaParentalManagementListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public abstract class AbstractDVDVideoSettingsParentalManagement
extends AbstractSettingsList
implements IMediaParentalManagementListener {
    private static final String LOGCLASS;
    private final IMediaDSIBaseController dsiBaseController;
    protected final BaseListModelApp pmList;
    private final ChoiceModelApp settingPreview;
    private static final int PMLIST_LEVEL_COUNT;

    public AbstractDVDVideoSettingsParentalManagement(IMediaTerminal iMediaTerminal, BaseListModelApp baseListModelApp, ChoiceModelApp choiceModelApp) {
        super(iMediaTerminal);
        this.dsiBaseController = iMediaTerminal.getDSIBaseController();
        this.pmList = baseListModelApp;
        this.settingPreview = choiceModelApp;
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"DVDVideoSettingsParentalManagement");
        this.dsiBaseController.addParentalManagementListener(this);
        this.pmList.removeAll();
        this.pmList.setListener(this);
        this.prefillPMList();
        int n = this.getPMLevel();
        this.updateActiveEntry(n);
        this.settingPreview.setValue(n);
    }

    public void deinit() {
        this.dsiBaseController.removeParentalManagementListener(this);
        this.pmList.resetListener();
    }

    public void resetSettings() {
        this.dsiBaseController.setParentalML(0);
    }

    protected void setPMLLevel(int n) {
        this.dsiBaseController.setParentalML(n);
    }

    @Override
    protected abstract int getCheckboxColumn() {
    }

    @Override
    protected BaseListModelApp getListModel() {
        return this.pmList;
    }

    @Override
    protected abstract void entrySelected(int n) {
    }

    @Override
    public void updateParentalML(int n) {
        this.logger.hmi().log(1078071040, "[%1.updateParentalML] '%2'", (Object)"DVDVideoSettingsParentalManagement", (long)n);
        if (n < 0 || n > 8) {
            this.logger.dsi().log(-1601830656, "[%1.updateParentalML] unsupported pmLevel '%2', ignoring.", (Object)"DVDVideoSettingsParentalManagement", (long)n);
        }
        this.updateActiveEntry(n);
        this.settingPreview.setValue(n);
        this.setPMLevel(n);
    }

    private int getPMLevel() {
        int n = this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_DVDV_PM_LEVEL");
        this.logger.main().log(1078071040, "[%1.getPMLevel] getting current pm-level from persistence: '%2'.", (Object)"DVDVideoSettingsParentalManagement", (long)n);
        return n;
    }

    private void setPMLevel(int n) {
        this.logger.main().log(1078071040, "[%1.setPMLevel] storing new pm level ('%2') in persistence.", (Object)"DVDVideoSettingsParentalManagement", (long)n);
        this.getTerminal().getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_DVDV_PM_LEVEL", n);
    }

    private void prefillPMList() {
        BaseListModelApp baseListModelApp = this.pmList.getCopy();
        baseListModelApp.setLength(9);
        for (int i2 = 0; i2 < 9; ++i2) {
            baseListModelApp.setRow(i2, this.createRow(i2));
        }
        this.pmList.update(baseListModelApp);
    }

    protected abstract EvoListRow createRow(int n) {
    }
}

