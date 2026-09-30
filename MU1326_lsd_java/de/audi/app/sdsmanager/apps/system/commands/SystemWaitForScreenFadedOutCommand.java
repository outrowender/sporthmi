/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.system.ISDSScreenFadedOutUpdatable;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemWaitForScreenFadedOutCommand
extends AbstractSystemCallCommand
implements ISDSScreenFadedOutUpdatable {
    private static final int SCREEN_MODE_FURTHER_COMMANDS = 0;
    private int screenMode = -1;
    private SDSHMIListener sdsHMIListener;

    public SystemWaitForScreenFadedOutCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, SDSHMIListener sDSHMIListener, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHMIListener = sDSHMIListener;
        this.screenMode = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: screenMode=%2", (Object)this.getName(), (long)this.screenMode);
        switch (this.screenMode) {
            case 0: {
                if (SDSManagerBaseActivator.getMapping().isFurtherCommandDisplay(this.sdsHMIListener.getCurrentSDSScreenId())) break;
                this.logger.log(10000000, "%1#execute: currentScreenId is other screen than screenIdToWaitForFadingOut -> OK, already faded out!", (Object)this.getName());
                this.sendResult(3000);
                return;
            }
            default: {
                this.logger.log(100000, "%1#execute: screen mode %2 is unknown!", (Object)this.getName(), (long)this.screenMode);
                this.sendResult(3001);
                return;
            }
        }
    }

    public void updateSDSScreenFadedOut(int n) {
        this.logger.log(10000000, "%1#updateSDSScreenFadedOut: screenID=%2", (Object)this.getName(), (long)n);
        if (this.screenMode == 0 && SDSManagerBaseActivator.getMapping().isFurtherCommandDisplay(n)) {
            this.logger.log(10000000, "%1#updateSDSScreenFadedOut: screenIdToWaitForFadingOut was faded out -> OK", (Object)this.getName());
            this.sendResult(3000);
            return;
        }
        this.logger.log(10000000, "%1#updateSDSScreenFadedOut: other screen than screenIdToWaitForFadingOut was faded out -> NOK!", (Object)this.getName(), (long)n);
        this.sendResult(3001);
    }
}

