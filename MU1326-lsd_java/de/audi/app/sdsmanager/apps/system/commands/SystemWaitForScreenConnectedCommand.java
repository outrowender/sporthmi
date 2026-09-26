/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.system.ISDSScreenConnectedUpdatable;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemWaitForScreenConnectedCommand
extends AbstractSystemCallCommand
implements ISDSScreenConnectedUpdatable {
    private int screenModeIndex = -1;
    private int screenIdToWaitFor = -1;
    private static int[] screenModeIndexToMapping = new int[]{39, 3, 4, 7, 8, 41, 42, 43};
    private SDSHMIListener sdsHMIListener;

    public SystemWaitForScreenConnectedCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, SDSHMIListener sDSHMIListener, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHMIListener = sDSHMIListener;
        this.screenModeIndex = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: screenModeIndex=%2", (Object)this.getName(), (long)this.screenModeIndex);
        if (this.screenModeIndex < 0 || this.screenModeIndex > screenModeIndexToMapping.length - 1) {
            this.logger.log(-1601830656, "%1#execute: screenModeIndex is out of bounds!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        int n = screenModeIndexToMapping[this.screenModeIndex];
        this.screenIdToWaitFor = SDSManagerBaseActivator.getMapping().getScreenID(n);
        if (this.screenIdToWaitFor == -1) {
            this.logger.log(-1601830656, "%1#execute: no mapping for screenModeIndex!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        this.logger.log(-2137614336, "%1#execute: screenIdMapping=%2 with screenIdToWaitFor=%3.", (Object)this.getName(), (long)n, (long)this.screenIdToWaitFor);
        int n2 = this.sdsHMIListener.getCurrentSDSScreenId();
        if (n2 == this.screenIdToWaitFor) {
            this.logger.log(-2137614336, "%1#execute: currentScreenId is expected screenIdToWaitFor.", (Object)this.getName());
            this.sendResult(3000);
            return;
        }
    }

    @Override
    public void updateSDSScreenConnected(int n) {
        this.logger.log(-2137614336, "%1#updateSDSScreenConnected: screenID=%2", (Object)this.getName(), (long)n);
        if (this.screenIdToWaitFor != n) {
            this.logger.log(-1601830656, "%1#updateSDSScreenConnected: screenID %2 was not expected screenIdToWaitFor=%3!", (Object)this.getName(), (long)n, (long)this.screenIdToWaitFor);
            return;
        }
        this.logger.log(-2137614336, "%1#updateSDSScreenConnected: connected screenID %2 is expected screenIdToWaitFor!", (Object)this.getName(), (long)n);
        this.sendResult(3000);
    }
}

