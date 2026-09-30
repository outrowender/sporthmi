/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.log.LogChannel;
import java.util.List;

public class MediaDeviceSetCommand
extends AbstractSystemCallCommand {
    private final IMediaSDSService mediaSDSService;
    private final byte device;
    private final MediaSDSHandler mediaSDSHandler;

    public MediaDeviceSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, MediaSDSHandler mediaSDSHandler, IMediaSDSService iMediaSDSService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.mediaSDSService = iMediaSDSService;
        this.mediaSDSHandler = mediaSDSHandler;
        this.device = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        int n = MediaSDSUtils.getSourceIDForDevice(this.device);
        this.logger.log(10000000, "[%1#execute] device=%2, sourceID=%3!", (Object)this.getName(), (long)this.device, (long)n);
        if (n == Integer.MIN_VALUE) {
            this.logger.log(100000, "[%1#execute] Unexpected device %2, sending ERROR!", (Object)this.getName(), (long)this.device);
            this.sendResult(20001);
            return;
        }
        switch (this.device) {
            case 7: {
                this.handleIPod(n);
                break;
            }
            case 10: {
                this.handleUSB(n);
                break;
            }
            default: {
                this.mediaSDSHandler.ignoreMediaDeviceChanges();
                this.mediaSDSService.activateSource(n);
            }
        }
    }

    private void handleIPod(int n) {
        int n2 = this.mediaSDSHandler.getIPodSlotIndex();
        if (n2 == -1) {
            this.logger.log(10000000, "[%1#handleIPod] no iPod available", (Object)this.getName());
            this.sendResult(20003);
        } else {
            this.mediaSDSHandler.ignoreMediaDeviceChanges();
            this.logger.log(10000000, "[%1#handleIPod] slot=%2", (Object)this.getName(), (long)n2);
            this.mediaSDSService.activateSource(n, n2);
        }
    }

    private void handleUSB(int n) {
        List list = this.mediaSDSHandler.getUSBSlotIndexes();
        if (SDSUtils.isEmpty(list) || list.get(0) == null) {
            this.logger.log(10000000, "[%1#handleUSB] no USB-Device available -> try iPod", (Object)this.getName());
            this.handleIPod(n);
        } else {
            int n2 = (Integer)list.get(0);
            this.logger.log(10000000, "[%1#handleUSB] slot=%2", (Object)this.getName(), (long)n2);
            this.mediaSDSHandler.ignoreMediaDeviceChanges();
            this.mediaSDSService.activateSource(n, n2);
        }
    }

    protected void handleSDSLineNumbering() {
        SDSUtils.updateSDSNumbers(false);
    }

    public void sendActivationReply(int n) {
        this.logger.log(10000000, "[%1#sendActivationReply] state=%2!", (Object)this.getName(), (long)n);
        this.sendResult(MediaSDSUtils.getActivationResponseEvent(n, this.logger));
    }
}

