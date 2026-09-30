/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sds;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TVService;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.base.INotificationHandler;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.interapp.ISourceActivator;
import de.audi.tv.app.lists.DefaultListContentSupplier;
import de.audi.tv.app.lists.FocusHandler;
import de.audi.tv.app.lists.IListContentSupplier;

public class TVServiceImpl
implements TVService {
    private final LogChannel lc;
    private final FocusHandler focusHandler;
    private final DSITV dsi;
    private final INotificationHandler notificationHandler;
    private final ISourceActivator sourceActivator;
    public final ITVEventListener eventListener = new EventListener();
    private IListContentSupplier stationList = new DefaultListContentSupplier();
    private IListContentSupplier favoritesList = new DefaultListContentSupplier();
    private volatile boolean muHasAudioFocus = false;

    public TVServiceImpl(LogChannel logChannel, FocusHandler focusHandler, DSITV dSITV, INotificationHandler iNotificationHandler, ISourceActivator iSourceActivator) {
        this.lc = logChannel;
        this.focusHandler = focusHandler;
        this.dsi = dSITV;
        this.notificationHandler = iNotificationHandler;
        this.sourceActivator = iSourceActivator;
    }

    public void setStationList(IListContentSupplier iListContentSupplier) {
        this.stationList = iListContentSupplier;
    }

    public void setFavoritesList(IListContentSupplier iListContentSupplier) {
        this.favoritesList = iListContentSupplier;
    }

    public byte freezeDynamicLists() {
        this.lc.log(10000000, "[TVServiceImpl.freezeDynamicLists]");
        this.notificationHandler.clearNotification(3);
        return 0;
    }

    public byte unfreezeDynamicLists() {
        this.lc.log(10000000, "[TVServiceImpl.unfreezeDynamicLists]");
        this.notificationHandler.setNotification(3);
        return 0;
    }

    public TVService.TVSettingResult tuneStationByID(long l) {
        TVService.TVSettingResult tVSettingResult;
        this.lc.log(10000000, "[TVServiceImpl.tuneStationByID] unique ID: %1", l);
        int n = this.stationList.getIndexForUniqueID(l);
        int n2 = this.favoritesList.getIndexForUniqueID(l);
        if (n == -1 && n2 == -1) {
            tVSettingResult = new TVService.TVSettingResult(0, l);
        } else {
            if (this.focusHandler.getFocusedListId() == 0) {
                if (n >= 0) {
                    this.dsi.changeService(this.stationList.getRowByIndex((int)n).service, true);
                    tVSettingResult = new TVService.TVSettingResult(this.muHasAudioFocus ? (byte)1 : 2, l);
                } else {
                    this.dsi.changeService(this.favoritesList.getRowByIndex((int)n2).service, true);
                    this.focusHandler.changeFocus(1);
                    tVSettingResult = new TVService.TVSettingResult(3, l);
                }
            } else if (n2 >= 0) {
                this.dsi.changeService(this.favoritesList.getRowByIndex((int)n2).service, true);
                tVSettingResult = new TVService.TVSettingResult(this.muHasAudioFocus ? (byte)1 : 3, l);
            } else {
                this.dsi.changeService(this.stationList.getRowByIndex((int)n).service, true);
                this.focusHandler.changeFocus(0);
                tVSettingResult = new TVService.TVSettingResult(2, l);
            }
            if (!this.muHasAudioFocus) {
                this.sourceActivator.activate(0);
            }
        }
        return tVSettingResult;
    }

    public byte getTypeOfListRow(int n) {
        this.lc.log(10000000, "[TVServiceImpl.getTypeOfListRow] index: %1", (long)n);
        return 0;
    }

    public byte selectSource(int n) {
        this.lc.log(10000000, "[TVServiceImpl.selectSource] source: %1", (long)n);
        switch (n) {
            case 3: {
                this.sourceActivator.activate(1);
                break;
            }
            case 1: 
            case 2: {
                this.focusHandler.changeFocus(n == 1 ? 0 : 1);
                this.sourceActivator.activate(0);
                break;
            }
            default: {
                this.lc.log(100000, "[TVServiceImpl.selectSource] tried to set an invalid source");
                return 0;
            }
        }
        return 1;
    }

    public byte fillTvPickList(SDSListEntry[] sDSListEntryArray) {
        this.lc.log(10000000, "[TVServiceImpl.fillTvPickList]");
        return 0;
    }

    public SDSListEntry getTvPicklistEntry(int n) {
        this.lc.log(10000000, "[TVServiceImpl.getTvPicklistEntry] index: %1", (long)n);
        return null;
    }

    private class EventListener
    extends TVEventDefaultListener {
        private EventListener() {
        }

        public void onMuGotTvAudioFocus() {
            TVServiceImpl.this.muHasAudioFocus = true;
        }

        public void onMuLostTvAudioFocus() {
            TVServiceImpl.this.muHasAudioFocus = false;
        }
    }
}

