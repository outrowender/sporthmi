/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;

public class SystemDisambiguationListShowCommand
extends AbstractSystemCallCommand {
    private ISDSPopupHelper sdsPopupHelper;
    private final NBestStorageAccess nBestStorage;
    private int listMode;

    public SystemDisambiguationListShowCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, ISDSPopupHelper iSDSPopupHelper, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.sdsPopupHelper = iSDSPopupHelper;
        this.nBestStorage = nBestStorageAccess;
        this.listMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: listmode=%2", (Object)this.getName(), (long)this.listMode);
        switch (this.listMode) {
            case 0: {
                this.fillCommandDisambiguationList();
                this.sdsPopupHelper.triggerHapticalPopup(101, true);
                this.sendResult(3000);
                break;
            }
            case 1: {
                this.sdsPopupHelper.triggerHapticalPopup(113, true);
                this.sendResult(3000);
                break;
            }
            default: {
                this.logger.log(100000, "%1#execute: unhandled listmode!", (Object)this.getName());
                this.sendResult(3001);
            }
        }
    }

    private void fillCommandDisambiguationList() {
        int n = this.nBestStorage.getPicklistSize((byte)0);
        BaseListModelApp baseListModelApp = SDSModelAccess.getDisambiguationListModel();
        baseListModelApp.setSelectedIndex(-1);
        baseListModelApp.clearAll();
        for (int i2 = 0; i2 < n; ++i2) {
            EvoListRow evoListRow = new EvoListRow(i2, 1);
            evoListRow.setText(0, this.nBestStorage.getRecognitionText(i2));
            baseListModelApp.append(evoListRow);
        }
    }
}

