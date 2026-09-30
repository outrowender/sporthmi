/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemIncrementModelCommand
extends AbstractSystemCallCommand {
    private static final int MODEL_TYPE_POSTTRAINING = 0;
    private static final int MODEL_TYPE_POSTTRAINING_FAILURE = 1;
    private final int modelType;

    public SystemIncrementModelCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.modelType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        switch (this.modelType) {
            case 0: {
                this.logger.log(10000000, "%1#execute: Incrementing posttraining model!", (Object)this.getName());
                SDSModelAccess.setPosttrainingShowTextValue(SDSModelAccess.getPosttrainingShowTextValue() + 1);
                break;
            }
            case 1: {
                this.logger.log(10000000, "%1#execute: Incrementing posttraining failure model!", (Object)this.getName());
                SDSModelAccess.setPosttrainingRecordCountValue(SDSModelAccess.getPosttrainingRecogCountValue() + 1);
                break;
            }
            default: {
                this.logger.log(10000000, "%1#execute: Unhandled model type %2!", (Object)this.getName(), (long)this.modelType);
                this.sendResult(3001);
                return;
            }
        }
        this.processingFinished();
    }
}

