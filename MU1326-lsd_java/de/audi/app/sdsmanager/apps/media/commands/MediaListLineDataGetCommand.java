/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.IJoystickBlock;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSPicklistHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;

public class MediaListLineDataGetCommand
extends AbstractSystemCallCommand
implements IJoystickBlock {
    private final HMIService hmi;
    private final NBestStorageAccess nBestStorage;
    private final MediaSDSPicklistHandler picklistHandler;
    private final SDSListEntry[] dynamicDevices;
    private final MediaSDSHandler mediaSDSHandler;
    private static int[][] buttonModelMappingToDeviceType = new int[][]{{21, 2}, {22, 3}, {23, 1}};

    public MediaListLineDataGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, MediaSDSPicklistHandler mediaSDSPicklistHandler, HMIService hMIService, SDSListEntry[] sDSListEntryArray, MediaSDSHandler mediaSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
        this.picklistHandler = mediaSDSPicklistHandler;
        this.hmi = hMIService;
        this.dynamicDevices = sDSListEntryArray;
        this.mediaSDSHandler = mediaSDSHandler;
    }

    @Override
    public void execute() {
        int n;
        String string = SDSModelAccess.getSlotModelStrings()[0];
        this.logger.log(-2137614336, "%1#execute: lineNumberStr=%2", (Object)this.getName(), (Object)string);
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.log(-1601830656, "%1#execute: Exception for lineNumberStr %2: %3!", (Object)this.getName(), (Object)string, (Object)numberFormatException.getMessage());
            this.sendResult(20001);
            return;
        }
        int[] nArray = new int[]{20000, 20006, 20001};
        this.logger.log(-2137614336, "%1#execute: Setting lineNumber %2 with answers for OK/INVALID/ERROR!", (Object)this.getName(), (long)n);
        this.hmi.fireSDSEvent(1, 5, n, nArray);
    }

    @Override
    public boolean handleKeyTyped(int n, int n2, int n3) {
        int n4 = SDSManagerBaseActivator.getMapping().getModelMappingID(n);
        this.logger.log(-2137614336, "%1#handleKeyTyped: received for model %2", (Object)this.getName(), (long)n);
        int n5 = SDSUtils.translate(n4, buttonModelMappingToDeviceType);
        if (n5 != 128) {
            this.logger.log(-2137614336, "%1#handleKeyTyped: set device type %2", (Object)this.getName(), (long)n5);
            SDSModelAccess.setMediaPicklistPlayMusicSelectedType(n5);
            this.sendResult(20000);
            return true;
        }
        return false;
    }

    public void sdsListLineDataGet(int n) {
        byte by = this.picklistHandler.getListmode();
        this.logger.log(-2137614336, "%1#sdsListLineDataGet: absLine=%2 (0-indexed), listmode=%3", (Object)this.getName(), (long)n, (long)by);
        if (by == 4) {
            if (this.dynamicDevices == null || n >= this.dynamicDevices.length) {
                this.logger.log(10000, "%1#sdsListLineDataGet: index %2 invalid", (Object)this.getName(), (long)n);
                this.sendResult(20001);
                return;
            }
            SDSModelAccess.setMediaPicklistPlayMusicSelectedType(0);
            this.picklistHandler.setSelectedMediaItem(this.dynamicDevices[n]);
            this.sendResult(20000);
            return;
        }
        this.nBestStorage.resetPicklistsWithHistory();
        this.nBestStorage.setLastRecogLine(true, n);
        this.mediaListLineDataGet(n);
    }

    private void mediaListLineDataGet(int n) {
        byte by = this.picklistHandler.getListmode();
        this.logger.log(-2137614336, "%1#sdsListLineDataGet: absLine=%2 (0-indexed), listmode=%3", (Object)this.getName(), (long)n, (long)by);
        OneshotHandler oneshotHandler = this.mediaSDSHandler.getOneshotHandler();
        if (oneshotHandler == null) {
            this.handleMediaListLineDataGetWithoutOneshotHandler(by, n);
        } else {
            this.handleMediaListLineDataGetViaOneshotHandler(oneshotHandler, by, n);
        }
    }

    private void handleMediaListLineDataGetViaOneshotHandler(OneshotHandler oneshotHandler, int n, int n2) {
        IPicklistElement iPicklistElement;
        this.logger.log(-2137614336, "%1#handleMediaListLineDataGetViaOneshotHandler: absLine=%2 (0-indexed), listmode=%3", (Object)this.getName(), (long)n2, (long)n);
        IPicklistElement iPicklistElement2 = iPicklistElement = !MediaSDSUtils.isOneshotListmode(n) ? this.nBestStorage.getMatchingPicklist((byte)0).get(n2) : oneshotHandler.getCurrentPicklist().get(n2);
        if (iPicklistElement == null) {
            this.logger.log(-1601830656, "%1#handleMediaListLineDataGetViaOneshotHandler: Unhandled absLine %2, sending INVALID!", (Object)this.getName(), (long)n2);
            this.sendResult(20006);
            return;
        }
        if (!MediaSDSUtils.isOneshotListmode(n)) {
            SDSUtils.storeLineData(iPicklistElement, this.logger);
        } else {
            IPicklistElement[] iPicklistElementArray = oneshotHandler.getCurrentPicklist().getElements();
            if (iPicklistElementArray.length > n2) {
                SDSUtils.storeLineData(iPicklistElementArray[n2], this.logger);
            }
        }
        this.logger.log(-1601830656, "%1#handleMediaListLineDataGetViaOneshotHandler: selected Element %2!", (Object)this.getName(), (Object)iPicklistElement);
        if (!oneshotHandler.setOneshotData(iPicklistElement, n)) {
            this.logger.log(-1601830656, "%1#handleMediaListLineDataGetViaOneshotHandler: Storing oneshot data failed, sending ERROR!", (Object)this.getName());
            this.sendResult(20001);
            return;
        }
        this.sendResult(20000);
    }

    private void handleMediaListLineDataGetWithoutOneshotHandler(int n, int n2) {
        this.logger.log(-2137614336, "%1#handleMediaListLineDataGetWithoutOneshotHandler: absLine=%2 (0-indexed), listmode=%3", (Object)this.getName(), (long)n2, (long)n);
        if (MediaSDSUtils.isOneshotListmode(n)) {
            IPicklistSlot iPicklistSlot = this.picklistHandler.getEntryPicklist().getSlot(n2, 0);
            if (iPicklistSlot == null) {
                this.logger.log(10000, "%1#handleMediaListLineDataGetWithoutOneshotHandler: slot for selected element is null", (Object)this.getName());
                this.sendResult(20001);
                return;
            }
            this.picklistHandler.setSelectedMediaItem(new SDSListEntry(iPicklistSlot.getText(), iPicklistSlot.getObjID()));
            IPicklistElement[] iPicklistElementArray = this.picklistHandler.getEntryPicklist().getElements();
            if (iPicklistElementArray.length > n2) {
                SDSUtils.storeLineData(iPicklistElementArray[n2], this.logger);
            }
            this.sendResult(20000);
            return;
        }
        IPicklistElement iPicklistElement = this.nBestStorage.getMatchingPicklist((byte)0).get(n2);
        if (iPicklistElement == null) {
            this.logger.log(-2137614336, "%1#handleMediaListLineDataGetWithoutOneshotHandler: error: IPicklistElement is null.", (Object)this.getName());
            this.sendResult(20001);
            return;
        }
        SDSUtils.storeLineData(iPicklistElement, this.logger);
        this.sendResult(20000);
    }
}

