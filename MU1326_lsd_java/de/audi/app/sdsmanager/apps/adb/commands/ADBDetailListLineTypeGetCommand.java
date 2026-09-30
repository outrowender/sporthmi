/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb.commands;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.log.LogChannel;

public class ADBDetailListLineTypeGetCommand
extends AbstractSystemCallCommand {
    private final SDSHandlerService sdsAdapter;
    private int[][] modelMappingIdToADBDetailType = new int[][]{{12, 70002}, {13, 70003}, {14, 70004}};

    public ADBDetailListLineTypeGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService) {
        super(logChannel, string, sDSHandlerService);
        this.sdsAdapter = sDSHandlerService;
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute]", (Object)this.getName());
        int n = this.sdsAdapter.getSelectedModel();
        int n2 = this.sdsAdapter.getSelectedRow();
        int n3 = SDSManagerBaseActivator.getMapping().getModelMappingID(n);
        int n4 = SDSUtils.translate(n3, this.modelMappingIdToADBDetailType);
        this.logger.log(10000000, "[%1#execute] modelId=%2, mappingId=%3", (Object)this.getName(), (long)n, (long)n3);
        this.logger.log(10000000, "[%1#execute] rowIdx=%2", (Object)this.getName(), (long)n2);
        if (n4 == Integer.MIN_VALUE) {
            this.logger.log(10000, "[%1#execute] Invalid model Id!", (Object)this.getName());
            n4 = 70005;
        }
        this.sendResult(n4);
    }
}

