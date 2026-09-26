/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media;

import de.audi.app.sdsmanager.apps.media.IMediaSDSPicklistHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;

public class MediaSDSPicklistHandler
extends DefaultBaseListModelListener
implements IMediaSDSPicklistHandler {
    private final LogChannel lc = Logger.getAppMediaLog();
    private final MediaSDSHandler sdsHandler;
    private final HMIService hmi;
    private IPicklist entryPicklist;
    private IPicklist initialEntryPicklist;
    private SDSListEntry selectedMediaItem;
    private byte picklistMode = (byte)-1;
    private static final int MAX_MEDIA_COLUMNS;

    public MediaSDSPicklistHandler(HMIService hMIService, MediaSDSHandler mediaSDSHandler) {
        this.hmi = hMIService;
        this.sdsHandler = mediaSDSHandler;
        this.entryPicklist = null;
        SDSUtils.initPickList(hMIService.getBaseListModel(254), 3, this);
        this.lc.log(-2137614336, "MediaSDSPicklistListener started.");
    }

    public IPicklistElement getPicklistElementByIndex(int n) {
        if (this.entryPicklist == null) {
            return null;
        }
        return this.entryPicklist.get(n);
    }

    @Override
    public IPicklist getEntryPicklist() {
        return this.entryPicklist;
    }

    @Override
    public void setEntryPicklist(IPicklist iPicklist) {
        this.entryPicklist = iPicklist;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(-2137614336, "MediaSDSPicklistHandler#itemSelected: id=%1, row=%2 (0-indexed)", (long)n, (long)n2);
        SDSUtils.handleItemSelected(n, n2, this.hmi, this.sdsHandler, this.lc);
    }

    public IPicklist getInitialEntryPicklist() {
        return this.initialEntryPicklist;
    }

    public void initializeEntryPicklist(NBestStorageAccess nBestStorageAccess) {
        IPicklist iPicklist = nBestStorageAccess.getMatchingPicklist((byte)2);
        if (iPicklist == null || iPicklist.getSize() == 0) {
            iPicklist = nBestStorageAccess.getMatchingPicklist((byte)0);
            this.lc.log(-1601830656, "MediaSDSPicklistHandler#execute: Empty nBestPicklist for multislot, using flat list instead");
        }
        this.setInitialEntryPicklist(iPicklist);
        this.setSelectedMediaItem(null);
    }

    public void setInitialEntryPicklist(IPicklist iPicklist) {
        this.lc.log(-2137614336, "[MediaSDSPicklistHandler#setInitialEntryPicklist] picklist=%1!", (Object)iPicklist);
        this.initialEntryPicklist = iPicklist;
    }

    public SDSListEntry getSelectedMediaItem() {
        return this.selectedMediaItem;
    }

    public void setSelectedMediaItem(SDSListEntry sDSListEntry) {
        this.selectedMediaItem = sDSListEntry;
    }

    @Override
    public void setListmode(byte by) {
        this.picklistMode = by;
    }

    public byte getListmode() {
        return this.picklistMode;
    }
}

