/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.log.LogChannel;

public class MediaUSBDeviceSetCommand
extends AbstractSystemCallCommand {
    private static final int PARTITION_1;
    private static final int PARTITION_1_1;
    private static final int PARTITION_1_2;
    private static final int PARTITION_2;
    private static final int PARTITION_2_1;
    private static final int PARTITION_2_2;
    private static final int PARTITION_NLU;
    private static final int[][] SLOT_AND_PARTITION_TRANSLATION_TABLE;
    private static final int NLU_PARTITION_1;
    private static final int NLU_PARTITION_1_1;
    private static final int NLU_PARTITION_1_2;
    private static final int NLU_PARTITION_2;
    private static final int NLU_PARTITION_2_1;
    private static final int NLU_PARTITION_2_2;
    private static final int[][] SLOT_AND_PARTITION_TRANSLATION_TABLE_NLU;
    private final IMediaSDSService mediaSDSService;
    private final int mediaUSBPartition;
    private final NBestStorageAccess nBestStorage;
    private final MediaSDSHandler mediaSDSHandler;

    public MediaUSBDeviceSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMediaSDSService iMediaSDSService, MediaSDSHandler mediaSDSHandler, NBestStorageAccess nBestStorageAccess, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.mediaSDSService = iMediaSDSService;
        this.nBestStorage = nBestStorageAccess;
        this.mediaSDSHandler = mediaSDSHandler;
        this.mediaUSBPartition = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        int[] nArray;
        this.logger.log(-2137614336, "%1#execute: slotAndPartition=%2!", (Object)this.getName(), (long)this.mediaUSBPartition);
        if (this.mediaUSBPartition == 6) {
            IPicklistSlot iPicklistSlot = this.nBestStorage.getMatchingPicklist((byte)0).getSlot(0, 0);
            long l = iPicklistSlot != null ? iPicklistSlot.getObjID() : -1L;
            this.logger.log(-2137614336, "%1#execute: firstSlotObjID=%2!", (Object)this.getName(), l);
            nArray = SDSUtils.translateMulti((int)l, SLOT_AND_PARTITION_TRANSLATION_TABLE_NLU);
        } else {
            nArray = SDSUtils.translateMulti(this.mediaUSBPartition, SLOT_AND_PARTITION_TRANSLATION_TABLE);
        }
        int n = nArray[0];
        int n2 = nArray[1];
        if (n == 128 || n2 == 128) {
            this.logger.log(-1601830656, "%1#execute: Unexpected mediaUSBPartition %2, sending ERROR!", (Object)this.getName(), (long)this.mediaUSBPartition);
            this.sendResult(20003);
            return;
        }
        this.mediaSDSHandler.ignoreMediaDeviceChanges();
        this.logger.log(-2137614336, "%1#execute: Activating source USB with slotIndex %2 and partitionIndex %3!", (Object)this.getName(), (long)n, (long)n2);
        this.mediaSDSService.activateSource(10, n, n2);
    }

    @Override
    protected void handleSDSLineNumbering() {
        SDSUtils.updateSDSNumbers(false);
    }

    public void sendActivationReply(int n) {
        this.logger.log(-2137614336, "[%1#sendActivationReply] state=%2!", (Object)this.getName(), (long)n);
        this.sendResult(MediaSDSUtils.getActivationResponseEvent(n, this.logger));
    }

    static {
        SLOT_AND_PARTITION_TRANSLATION_TABLE = new int[][]{{0, 0, -1}, {1, 0, 1}, {2, 0, 2}, {3, 2, -1}, {4, 1, 1}, {5, 1, 2}};
        SLOT_AND_PARTITION_TRANSLATION_TABLE_NLU = new int[][]{{1, 0, -1}, {3, 0, 1}, {4, 0, 2}, {2, 2, -1}, {5, 1, 1}, {6, 1, 2}};
    }
}

