/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemCommandListShowCommand
extends AbstractSystemCallCommand {
    private final SDSHMIListener hmiListener;
    private final ISDSPopupHelper sdsPopupHelper;
    private final byte commandType;
    private final SpeechRecognitionHandler speechRecogntionHandler;

    public SystemCommandListShowCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, SDSHMIListener sDSHMIListener, ISDSPopupHelper iSDSPopupHelper, SpeechRecognitionHandler speechRecognitionHandler, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.hmiListener = sDSHMIListener;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.speechRecogntionHandler = speechRecognitionHandler;
        this.commandType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: commandType=%2", (Object)this.getName(), (long)this.commandType);
        int n = 3001;
        switch (this.commandType) {
            case 0: {
                n = this.showSmallCommandDisplay();
                break;
            }
            case 1: {
                n = this.showBigCommandDisplay();
                break;
            }
            case 2: {
                this.sdsPopupHelper.showFurtherCommandDisplay();
                n = 3000;
                break;
            }
            case 4: {
                this.logger.log(-2137614336, "%1#execute: command type DISPLAY OFF -> NOP!", (Object)this.getName());
                n = 3000;
                break;
            }
            default: {
                this.logger.log(-1601830656, "%1#execute: Unhandled commandType %2!", (Object)this.getName(), (long)this.commandType);
            }
        }
        this.sendResult(n);
    }

    private int showSmallCommandDisplay() {
        this.logger.log(-2137614336, "%1#showSmallCommandDisplay: called", (Object)this.getName());
        SDSModelAccess.setCommandType(0);
        SDSModelAccess.setSmallCommandDisplayVisible(1);
        return 3000;
    }

    private int showBigCommandDisplay() {
        SDSModelAccess.setCommandType(1);
        int n = this.sdsPopupHelper.getCurrentBigCommandScreenPopupMapping();
        this.logger.log(-2137614336, "%1#showBigCommandDisplay: currentBigCommandScreenPopupMapping=%2!", (Object)this.getName(), (long)n);
        int n2 = SDSModelAccess.getCommandModeBig();
        int n3 = this.sdsPopupHelper.getCommandScreenPopupMapping(n2);
        if (n3 != n && n != -1) {
            this.logger.log(-2137614336, "%1#showBigCommandDisplay: New command popup with ID %2 requested, removing current one with ID %3 once the new one connects!", (Object)this.getName(), (long)n3, (long)n);
            this.sdsPopupHelper.setBigCommandDisplayToRemove(n);
        } else {
            this.sdsPopupHelper.setBigCommandDisplayToRemove(-1);
        }
        this.logger.log(-2137614336, "%1#showBigCommandDisplay: commandModeBig=%2, popupMappingID=%3!", (Object)this.getName(), (long)n2, (long)n3);
        this.sdsPopupHelper.setCurrentBigCommandScreenPopupMapping(n3);
        this.sdsPopupHelper.triggerHapticalPopup(n3, true);
        this.hmiListener.updateSDSStatusCommands();
        this.speechRecogntionHandler.setExpectedLongRecognitionTimeoutMode(true);
        return n3 == -1 ? 3001 : 3000;
    }
}

