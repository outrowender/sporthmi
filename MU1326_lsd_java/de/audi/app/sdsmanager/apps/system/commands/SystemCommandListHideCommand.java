/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.system.ISDSScreenFadedOutUpdatable;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemCommandListHideCommand
extends AbstractSystemCallCommand
implements ISDSScreenFadedOutUpdatable {
    private final ISDSPopupHelper sdsPopupHelper;
    private final SDSHMIListener hmiListener;
    private final byte commandType;

    public SystemCommandListHideCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISDSPopupHelper iSDSPopupHelper, SDSHMIListener sDSHMIListener, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.sdsPopupHelper = iSDSPopupHelper;
        this.hmiListener = sDSHMIListener;
        this.commandType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: commandType=%2", (Object)this.getName(), (long)this.commandType);
        boolean bl = true;
        switch (this.commandType) {
            case 1: {
                bl = this.removeBigCommandDisplay();
                break;
            }
            case 2: {
                bl = this.removeFurtherCommandDisplay();
                break;
            }
            case 0: {
                this.sdsPopupHelper.removeSmallCommandDisplay();
                break;
            }
            case 3: {
                this.logger.log(10000000, "%1#execute: command type HELP -> NOP!", (Object)this.getName());
                break;
            }
            case 4: {
                this.logger.log(10000000, "%1#execute: command type DISPLAY OFF -> NOP!", (Object)this.getName());
                break;
            }
            default: {
                this.logger.log(100000, "%1#execute: Unhandled command type %2!", (Object)this.getName(), (long)this.commandType);
            }
        }
        if (bl) {
            this.finishedCommand();
        }
    }

    private boolean removeBigCommandDisplay() {
        this.sdsPopupHelper.removeBigCommandDisplay();
        int n = this.hmiListener.getCurrentSDSScreenId();
        if (SDSManagerBaseActivator.getMapping().isBigCommandDisplay(n)) {
            this.logger.log(10000000, "%1#removeBigCommandDisplay: current screen ID belongs to big command display -> wait for fading out", (Object)this.getName());
            return false;
        }
        return true;
    }

    private boolean removeFurtherCommandDisplay() {
        this.sdsPopupHelper.removeFurtherCommandDisplay();
        int n = this.hmiListener.getCurrentSDSScreenId();
        if (SDSManagerBaseActivator.getMapping().isFurtherCommandDisplay(n)) {
            this.logger.log(10000000, "%1#removeFurtherCommandDisplay: current screen ID belongs to further command display -> wait for fading out", (Object)this.getName());
            return false;
        }
        return true;
    }

    private void finishedCommand() {
        this.hmiListener.updateSDSStatusCommands();
        this.processingFinished();
    }

    public void updateSDSScreenFadedOut(int n) {
        this.logger.log(10000000, "%1#updateSDSScreenFadedOut: called -> finish command", (Object)this.getName());
        this.finishedCommand();
    }
}

