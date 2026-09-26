/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListSupplier;
import de.esolutions.fw.util.commons.Buffer;

class SDSCommandListSupplier
implements ICommandListSupplier {
    private static final String LOGCLASS;
    private LogChannel logger = Logger.getCommandLog();
    private final ISDSPopupHelper popupHelper;
    private final SDSAdapter sdsAdapter;

    SDSCommandListSupplier(ISDSPopupHelper iSDSPopupHelper, SDSAdapter sDSAdapter) {
        this.popupHelper = iSDSPopupHelper;
        this.sdsAdapter = sDSAdapter;
    }

    @Override
    public boolean isApplicationOperable() {
        return this.sdsAdapter != null && this.sdsAdapter.isSDSAndTTSReady();
    }

    @Override
    public boolean isDSIsAvailable(CommandList commandList) {
        return true;
    }

    @Override
    public String getApplicationName(CommandList commandList) {
        return "SDSCommandListSupplier";
    }

    @Override
    public void showDebugPopup(CommandList commandList, String string, String string2) {
    }

    @Override
    public void handleException(Exception exception) {
        this.logger.log(10000, "%1#handleException: Exception (%3) for SDS-commandlist: %2", (Object)"SDSCommandListSupplier", (Object)exception.getMessage(), (Object)super.getClass());
        SDSUtils.printExceptionStackTrace(exception, "SDSCommandListSupplier#handleException");
        StackTraceElement[] stackTraceElementArray = exception.getStackTrace();
        String string = new Buffer().append(super.getClass().toString()).append(" in ").append(stackTraceElementArray[0].getClassName()).append('#').append(stackTraceElementArray[0].getMethodName()).toString();
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        this.popupHelper.showDebugPopup(abstractSystemCallCommand == null ? "Command" : abstractSystemCallCommand.getName(), super.getClass().toString(), string);
        if (abstractSystemCallCommand instanceof AbstractSystemCallCommand) {
            this.logger.log(10000, "%2#handleException: command.sendResult() -> %1", (Object)abstractSystemCallCommand, (Object)"SDSCommandListSupplier");
            abstractSystemCallCommand.sendResult(3001);
        } else {
            this.logger.log(10000, "%1#handleException: adapter.sendResult()", (Object)"SDSCommandListSupplier");
            this.sdsAdapter.sendResult(3001);
        }
    }
}

