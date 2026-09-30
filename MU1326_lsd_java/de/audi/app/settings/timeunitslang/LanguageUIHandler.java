/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.timeunitslang;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.i18n.ILanguageUIHandler;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;

public final class LanguageUIHandler
implements ILanguageUIHandler,
ListListener,
PowerEventListener {
    private final IFrameworkAccess fw;
    private ILanguageManager langMngr;
    private LogChannel lc;
    private ChoiceModelApp flag;
    private ListModelApp languageList;
    private int lastSelectedLangIndex;
    private ChoiceModelApp languageVisibilityProxy;
    private ChoiceModelApp languageDisclaimer;

    public LanguageUIHandler(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.lc = this.fw.getLogChannel("Fw.Language.UI");
    }

    public void setLanguageManager(ILanguageManager iLanguageManager) {
        this.langMngr = iLanguageManager;
    }

    public void initModels() {
        this.lc.log(10000000, "initModels()");
        IHMIServiceApp iHMIServiceApp = this.fw.getHmiServiceApp();
        this.languageList = iHMIServiceApp.getListModel(1100222);
        this.languageList.setMaxColumns(3);
        this.languageList.setMaxRows(25);
        this.languageList.setListListener(this);
        this.flag = iHMIServiceApp.getChoiceModel(1100194);
        this.languageVisibilityProxy = iHMIServiceApp.getChoiceModel(1100291);
        this.languageDisclaimer = iHMIServiceApp.getChoiceModel(1100297);
        this.updateList();
        this.updateFlag();
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "itemSelected: modelID=%1, row=%2, terminalID=%3", (long)n, (long)n2, (long)n4);
        if (n == 1100222) {
            final Language language = this.langMngr.getAvailableLanguages("LANG_COMPONENT_HMI")[n2];
            if (language == this.langMngr.getCurrentLanguage("LANG_COMPONENT_HMI")) {
                this.lc.log(10000000, "new language is current language -> no language change");
            } else {
                this.lc.log(10000000, "new language is not current language -> start language change");
                this.fw.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(true, new Runnable(){

                    public void run() {
                        LanguageUIHandler.this.executeLanguageChange(language);
                    }
                }));
            }
        } else {
            this.lc.log(10000, "Invalid modelID=%1", (long)n);
        }
    }

    private void updateList() {
        this.lc.log(10000000, "updateList()");
        if (this.languageList != null) {
            this.languageList.clear();
            Language[] languageArray = this.langMngr.getAvailableLanguages("LANG_COMPONENT_HMI");
            for (int i2 = 0; i2 < languageArray.length; ++i2) {
                ListCell[] listCellArray = new ListCell[this.languageList.getMaxColumns()];
                listCellArray[0] = IntegerListCell.create(languageArray[i2].getLanguageIndex());
                listCellArray[1] = IntegerListCell.create(0);
                listCellArray[2] = IntegerListCell.create(languageArray[i2].getLanguageIndex());
                this.languageList.addRow(listCellArray);
            }
            this.updateListSelection();
        }
    }

    public void updateListSelection() {
        int n;
        this.lc.log(10000000, "updateListSelection()");
        if (this.languageList != null && (n = this.getLocaleIdxInLangCodes(this.langMngr.getCurrentLanguage("LANG_COMPONENT_HMI"))) >= 0 && n < this.languageList.getLength()) {
            this.languageList.setSelected(n);
            this.languageList.setCell(this.lastSelectedLangIndex, 1, IntegerListCell.create(0));
            this.languageList.setCell(n, 1, IntegerListCell.create(1));
            this.lastSelectedLangIndex = n;
        }
    }

    private int getLocaleIdxInLangCodes(Language language) {
        Language[] languageArray = this.langMngr.getAvailableLanguages("LANG_COMPONENT_HMI");
        int n = 0;
        for (int i2 = 0; i2 < languageArray.length; ++i2) {
            if (!languageArray[i2].equals(language)) continue;
            n = i2;
            break;
        }
        return n;
    }

    public void updateFlag() {
        int n;
        this.lc.log(10000000, "updateFlag()");
        if (this.flag != null && (n = this.getLocaleIdxInLangCodes(this.langMngr.getCurrentLanguage("LANG_COMPONENT_HMI"))) < this.languageList.getLength()) {
            this.flag.setValue(((IntegerListCell)this.languageList.getCell(n, 2)).getValue());
        }
    }

    public void executeLanguageChange(Language language) {
        this.lc.log(10000000, "executeLanguageChange: languageCode=%1", (Object)language);
        this.langMngr.checkAndSetNewLanguage(language);
    }

    public void setWaiting() {
        this.fw.getHmiServiceApp().getChoiceModel(1100338).setValue(1);
        this.languageList.setStatus(0);
        this.languageList.fireEvent(0);
    }

    public void langChangeFinished() {
        this.lc.log(10000000, "langChangeFinished()");
        this.languageList.setStatus(1);
        this.fw.getHmiServiceApp().getChoiceModel(1100338).setValue(0);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl2) {
            this.languageVisibilityProxy.setValue(0);
            this.languageDisclaimer.setValue(0);
        } else {
            this.languageVisibilityProxy.setValue(2);
            this.languageDisclaimer.setValue(3);
        }
    }
}

