/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class SystemListPageSetCommand
extends AbstractSystemCallCommand {
    private static final int SYSTEM_LIST_PAGE_DOWN;
    private static final int SYSTEM_LIST_PAGE_UP;
    private static final int SYSTEM_LIST_PAGE_FIRST;
    private static final int SYSTEM_LIST_PAGE_LAST;
    private final HMIService hmiService;
    private final int pageType;
    private ISDSPopupHelper sdsPopupHelper;

    public SystemListPageSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISDSPopupHelper iSDSPopupHelper, HMIService hMIService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.pageType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.hmiService = hMIService;
        this.sdsPopupHelper = iSDSPopupHelper;
    }

    @Override
    public void execute() {
        if (this.pageType == -1) {
            this.logger.log(-1601830656, "%1#execute: Invalid page type!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        int n = SystemListPageSetCommand.getPageEvent(this.pageType);
        if (n == -1) {
            this.logger.log(-1601830656, "%1#execute: Invalid page event!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        this.closeProgressIcon();
        int[] nArray = this.getAnswerEvents();
        int n2 = 0;
        if (this.sdsPopupHelper.getCurrentHelpScreenPopupMappingID() != -1 && (n == 4 || n == 3)) {
            n2 = 11;
        }
        this.logger.log(-2137614336, "%1#execute: Setting pageEvent %2 with generic answers for OK/INVALID/ERROR and value=%3!", (Object)this.getName(), (long)n, (long)n2);
        this.hmiService.fireSDSEvent(2, n, n2, nArray);
    }

    protected int[] getAnswerEvents() {
        return new int[]{3000, 3004, 3001};
    }

    protected void closeProgressIcon() {
    }

    private static int getPageEvent(int n) {
        switch (n) {
            case 0: {
                return 4;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 1: {
                return 3;
            }
        }
        return -1;
    }
}

