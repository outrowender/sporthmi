/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.IMediaSDSPicklistHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSUtils;
import de.audi.app.sdsmanager.apps.system.PopupStrategy;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.grammar.DynamicSlotContent;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.interapp.media.IMediaSDSService$MediaSDSListEntry;
import de.audi.atip.log.LogChannel;

public class MediaListShowCommand
extends AbstractSystemCallCommand {
    private final byte listMode;
    private final IMediaSDSService mediaSDSService;
    private final NBestStorageAccess nBestStorage;
    private final HMIService hmi;
    private final PopupStrategy popupHelper;
    private final IMediaSDSPicklistHandler picklistHandler;
    private final SDSListEntry[] dynamicDevices;
    private final MediaSDSHandler mediaSDSHandler;
    private final IDynamicLists dynamicLists;

    public MediaListShowCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, IMediaSDSService iMediaSDSService, NBestStorageAccess nBestStorageAccess, PopupStrategy popupStrategy, HMIService hMIService, IMediaSDSPicklistHandler iMediaSDSPicklistHandler, SDSListEntry[] sDSListEntryArray, MediaSDSHandler mediaSDSHandler, IDynamicLists iDynamicLists) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
        this.listMode = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.mediaSDSService = iMediaSDSService;
        this.hmi = hMIService;
        this.popupHelper = popupStrategy;
        this.picklistHandler = iMediaSDSPicklistHandler;
        this.dynamicDevices = sDSListEntryArray;
        this.mediaSDSHandler = mediaSDSHandler;
        this.dynamicLists = iDynamicLists;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: listMode=%2!", (Object)this.getName(), (long)this.listMode);
        Object[] objectArray = null;
        if (this.listMode == 4) {
            SDSModelAccess.setMediaPicklistIsPlayMusic(true);
            objectArray = this.createDynamicDeviceEntries();
        } else {
            SDSModelAccess.setMediaPicklistIsPlayMusic(false);
            objectArray = this.createEntriesFromPicklist();
        }
        if (!this.areEntriesValid((IMediaSDSService$MediaSDSListEntry[])objectArray)) {
            this.sendResult(20001);
            return;
        }
        this.logger.log(-2137614336, "%1#execute: entries=%2", (Object)this.getName(), (Object)SDSUtils.toString(objectArray, true));
        byte by = this.mediaSDSService.fillPickList((IMediaSDSService$MediaSDSListEntry[])objectArray, MediaSDSUtils.getMediaModeForListMode(this.listMode));
        if (by == 2) {
            this.sendResult(20001);
            return;
        }
        if (this.listMode == 11 || this.listMode == 13 || this.listMode == 12 || this.listMode == 5 || this.listMode == 7 || this.listMode == 6) {
            this.dynamicLists.addToLookup(this.listMode, new DynamicSlotContent("media picklist", (SDSListEntry[])objectArray, 0));
        }
        this.picklistHandler.setListmode(this.listMode);
        SDSModelAccess.setMediaPicklistTitle(MediaSDSUtils.getPicklistTitleForListMode(this.listMode));
        SDSUtils.unlockPicklistModel(254, this.hmi, this.logger);
        this.popupHelper.triggerPopup();
        if (objectArray.length == 2 && ((SDSListEntry)objectArray[0]).getName().equalsIgnoreCase(((SDSListEntry)objectArray[1]).getName())) {
            this.sendResult(20012);
        } else {
            this.sendResult(20000);
        }
    }

    private boolean areEntriesValid(IMediaSDSService$MediaSDSListEntry[] iMediaSDSService$MediaSDSListEntryArray) {
        if (iMediaSDSService$MediaSDSListEntryArray == null) {
            this.logger.log(10000, "%1#execute: entries are null", (Object)this.getName());
            return false;
        }
        for (int i2 = 0; i2 < iMediaSDSService$MediaSDSListEntryArray.length; ++i2) {
            if (iMediaSDSService$MediaSDSListEntryArray[i2] != null) continue;
            this.logger.log(10000, "%1#execute: entry %2 is null", (Object)this.getName(), (long)i2);
            return false;
        }
        return true;
    }

    private IMediaSDSService$MediaSDSListEntry[] createDynamicDeviceEntries() {
        if (this.dynamicDevices != null) {
            IMediaSDSService$MediaSDSListEntry[] iMediaSDSService$MediaSDSListEntryArray = new IMediaSDSService$MediaSDSListEntry[this.dynamicDevices.length];
            for (int i2 = 0; i2 < iMediaSDSService$MediaSDSListEntryArray.length; ++i2) {
                SDSListEntry sDSListEntry = this.dynamicDevices[i2];
                long l = sDSListEntry.getId();
                int n = SDSUtils.getLowNibble(l);
                int n2 = SDSUtils.getHighNibble(l);
                iMediaSDSService$MediaSDSListEntryArray[i2] = new IMediaSDSService$MediaSDSListEntry(sDSListEntry.getName(), l, sDSListEntry.getChildren(), n, n2);
            }
            return iMediaSDSService$MediaSDSListEntryArray;
        }
        this.logger.log(1078071040, "%1#execute: dynamic devices is null", (Object)this.getName());
        return new IMediaSDSService$MediaSDSListEntry[0];
    }

    private IMediaSDSService$MediaSDSListEntry[] createEntriesFromPicklist() {
        IPicklist iPicklist;
        if (MediaSDSUtils.isOneshotListmode(this.listMode)) {
            this.logger.log(-2137614336, "%1#execute: oneshot", (Object)this.getName());
            OneshotHandler oneshotHandler = this.mediaSDSHandler.getOneshotHandler();
            iPicklist = oneshotHandler == null ? this.picklistHandler.getEntryPicklist() : oneshotHandler.getCurrentPicklist();
        } else {
            this.nBestStorage.storeCurrentPicklistInHistory();
            iPicklist = this.nBestStorage.getMatchingPicklist((byte)0);
            this.picklistHandler.setEntryPicklist(iPicklist);
        }
        if (iPicklist == null) {
            return null;
        }
        return MediaSDSUtils.toMediaDeviceArray(iPicklist.getElements(), this.listMode);
    }
}

