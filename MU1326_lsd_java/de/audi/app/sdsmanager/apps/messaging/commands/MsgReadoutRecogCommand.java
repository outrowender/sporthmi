/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.messaging.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.messaging.MessagingSDSUtils;
import de.audi.app.sdsmanager.apps.messaging.MsgReadoutRecogInterface;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.IMessagingReadoutService;
import de.audi.atip.log.LogChannel;

public class MsgReadoutRecogCommand
extends AbstractSystemCallCommand
implements MsgReadoutRecogInterface {
    private static final int SELECT_LEVEL_CURRENT_MSG;
    private static final int SELECT_LEVEL_MESSAGE_LIST;
    private static final int SELECT_LEVEL_ACCOUNT_LIST;
    private static final int[][] internalToExternalSelectLevel;
    private final IMessagingReadoutService messagingService;
    private final boolean newMsgMode;
    private final int msgType;
    private final int selectLevel;

    public MsgReadoutRecogCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMessagingReadoutService iMessagingReadoutService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.messagingService = iMessagingReadoutService;
        this.newMsgMode = SDSUtils.retrieveBoolean(iSystemCallParameterArray, 0);
        this.msgType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 1);
        this.selectLevel = SDSUtils.retrieveInteger(iSystemCallParameterArray, 2);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: newMsgMode=%2, msgType=%3", (Object)this.getName(), (Object)this.newMsgMode, (long)this.msgType);
        int n = this.newMsgMode ? 2 : (this.selectLevel == 1 ? 3 : 1);
        this.logger.log(-2137614336, "%1#execute: selectLevel=%2, readOutModelValue=%3", (Object)this.getName(), (long)this.selectLevel, (long)n);
        SDSModelAccess.setMsgReadoutActiveModel(n);
        int n2 = SDSUtils.translate(this.msgType, MessagingSDSUtils.internalToExternalMsgType);
        if (n2 == 128) {
            this.logger.log(-1601830656, "%1#execute: Unhandled msgType %2, sending ERROR!", (Object)this.getName(), (long)this.msgType);
            this.sendResult(-115080960);
            return;
        }
        int n3 = SDSUtils.translate(this.selectLevel, internalToExternalSelectLevel);
        if (n3 == 128) {
            this.logger.log(-1601830656, "%1#execute: Unhandled selectLevel %2, sending ERROR!", (Object)this.getName(), (long)this.selectLevel);
            this.sendResult(-115080960);
            return;
        }
        this.messagingService.requestBeginDialog(this.newMsgMode, n2, n3);
    }

    @Override
    public void responseBeginDialog(int n) {
        this.logger.log(-2137614336, "%1#responseBeginDialog: result=%2", (Object)this.getName(), (long)n);
        this.sendResult(n == 0 ? -131858176 : -115080960);
    }

    static {
        internalToExternalSelectLevel = new int[][]{{2, 0}, {1, 1}, {0, 2}};
    }
}

