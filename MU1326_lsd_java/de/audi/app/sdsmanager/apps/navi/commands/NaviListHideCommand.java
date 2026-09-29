/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.apps.system.ISDSScreenFadedOutUpdatable;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class NaviListHideCommand
extends AbstractSystemCallCommand
implements ISDSScreenFadedOutUpdatable {
    private final ISDSPopupHelper sdsPopupHelper;
    private final HMIService hmi;
    private final byte listMode;

    public NaviListHideCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, HMIService hMIService, ISDSPopupHelper iSDSPopupHelper) {
        super(logChannel, string, sDSHandlerService);
        this.sdsPopupHelper = iSDSPopupHelper;
        this.hmi = hMIService;
        this.listMode = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] listMode=%2", (Object)this.getName(), (long)this.listMode);
        int n = SDSUtils.translate((int)this.listMode, NaviSDSUtils.listMode2PopupMappingID);
        this.logger.log(-2137614336, "[%1#execute] popupMappingID=%2!", (Object)this.getName(), (long)n);
        boolean bl = false;
        if (n != 128) {
            switch (n) {
                case 47: 
                case 48: 
                case 49: {
                    this.sdsPopupHelper.triggerHapticalPartialPopup(n, false);
                    break;
                }
                default: {
                    int n2 = SDSManagerBaseActivator.getMapping().getPopupMappingID(this.hmi.getCurrentPopup());
                    this.sdsPopupHelper.triggerHapticalPopup(n, false);
                    boolean bl2 = bl = n2 == n;
                }
            }
        }
        if (bl) {
            this.logger.log(-2137614336, "[%1#execute] wait until current popup is removed!", (Object)this.getName());
        } else {
            this.processingFinished();
        }
    }

    @Override
    public void updateSDSScreenFadedOut(int n) {
        this.processingFinished();
    }
}

