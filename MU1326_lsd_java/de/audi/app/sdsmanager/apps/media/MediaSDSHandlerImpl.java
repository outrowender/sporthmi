/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSDSApplication;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.media.IMediaCoverartReceiver;
import de.audi.app.sdsmanager.apps.media.IMediaPlayItemCommand;
import de.audi.app.sdsmanager.apps.media.MediaPlayModeEvo;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSPicklistHandler;
import de.audi.app.sdsmanager.apps.media.commands.MediaDeviceSetCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaDynDeviceSetCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaFolderSelectCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaFolderUpCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaG2POneshotFilterPicklistCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaG2POneshotIsAmbiguousCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaG2POneshotStoreDataCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaListHideCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaListLineDataGetCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaListLineSetCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaListShowCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaMediumSelectCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaPlayAllTracksCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaPlayItemCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaPlaymodeSetCommand;
import de.audi.app.sdsmanager.apps.media.commands.MediaUSBDeviceSetCommand;
import de.audi.app.sdsmanager.apps.system.PopupTrigger;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandler;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.grammar.DynamicSlotContent;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.app.sdsmanager.oneshot.OneshotHandlerFactory;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.def.NullMediaSDSService;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.interapp.media.IMediaSDSServiceListener;
import de.audi.atip.interapp.media.IMediaServiceListener;
import de.audi.atip.interapp.media.MediaCoverartEntry;
import de.audi.atip.interapp.media.MediaSDSEntry;
import de.audi.atip.interapp.media.MediaSlotInfo;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.CommandList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MediaSDSHandlerImpl
extends AbstractSDSApplication
implements MediaSDSHandler,
IMediaServiceListener,
IMediaSDSServiceListener,
TimerListener {
    private static final int[] commands = new int[]{20000, 20026, 20024, 20015, 20016, 20019, 20020, 20021, 20023, 20017, 1001, 20025, 20001, 20003, 20002, 20004, 20027};
    private final int[][] source2model = new int[][]{{1, 259}, {2, 258}, {3, 261}, {4, 260}, {9, 255}, {8, 256}, {11, 257}, {6, 263}, {5, 265}, {10, 498}, {12, 267}, {7, 266}};
    private LogChannel lc = Logger.getAppMediaLog();
    private final SystemSDSHandler systemHandler;
    private IMediaSDSService mediaSDSService = new NullMediaSDSService(this.lc);
    private final HMIService hmi;
    private int pickListMode = 1;
    private Long[] deviceIDs;
    private List availableDevices = new ArrayList(8);
    private final IDynamicLists dynamicLists;
    private SDSListEntry[] dynamicDevices;
    private ISDSPopupHelper sdsPopupHelper;
    private MediaSDSPicklistHandler picklistHandler;
    private final Timer ignoreDeviceChangesTimer;
    private int iPodSlot = -1;
    private List usbSlots = new ArrayList();
    private OneshotHandler oneshotHandler;
    private OneshotHandlerFactory oneshotHandlerFactory;

    public MediaSDSHandlerImpl(HMIService hMIService, SDSHandlerService sDSHandlerService, IDynamicLists iDynamicLists, NBestStorageAccess nBestStorageAccess, SystemSDSHandler systemSDSHandler, Long[] longArray, ISDSPopupHelper iSDSPopupHelper, OneshotHandlerFactory oneshotHandlerFactory) {
        super(sDSHandlerService, nBestStorageAccess);
        this.lc.log(10000000, "MediaSDSHandlerImpl: loadedIDs=%1", (Object)longArray);
        this.hmi = hMIService;
        this.deviceIDs = longArray;
        this.systemHandler = systemSDSHandler;
        this.dynamicLists = iDynamicLists;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.ignoreDeviceChangesTimer = new Timer("IgnoreDeviceChangeTimer", 5, this.lc, this, 10000L, true);
        this.oneshotHandlerFactory = oneshotHandlerFactory;
        this.picklistHandler = new MediaSDSPicklistHandler(hMIService, this);
    }

    public void setMediaSDSService(IMediaSDSService iMediaSDSService) {
        if (iMediaSDSService != null) {
            this.mediaSDSService = iMediaSDSService;
        }
    }

    public IMediaSDSService getMediaSDSService() {
        return this.mediaSDSService;
    }

    public void unsetMediaSDSService() {
        this.mediaSDSService = new NullMediaSDSService(this.lc);
    }

    public void processCommand(int n, ISystemCallParameter[] iSystemCallParameterArray) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#processCommand: id=%2, params=%1", (Object)SDSUtils.toString((Object[])iSystemCallParameterArray, false), (Object)SDSManagerBaseActivator.getSystemCallNames().getName(n));
        CommandList commandList = new CommandList(SDSManagerBaseActivator.getSysCallCmdListManager());
        switch (n) {
            case 20000: {
                commandList.add(new MediaDeviceSetCommand(this.lc, "MEDIA_DEVICESET", this.sdsHandlerService, this, this.mediaSDSService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL MEDIA_DEVICESET");
                break;
            }
            case 20015: {
                commandList.add(new MediaFolderUpCommand(this.lc, "MEDIA_FOLDERUP", this.sdsHandlerService, this.mediaSDSService));
                commandList.execute("SYSTEMCALL MEDIA_GROUPUP");
                break;
            }
            case 20016: {
                commandList.add(new MediaListHideCommand(this.lc, "MEDIA_LISTHIDE", this.sdsHandlerService, this.hmi, new PopupTrigger(this.sdsPopupHelper, 20, false)));
                commandList.execute("SYSTEMCALL MEDIA_LISTHIDE");
                break;
            }
            case 20019: {
                commandList.add(new MediaListShowCommand(this.lc, "MEDIA_LISTSHOW", this.sdsHandlerService, iSystemCallParameterArray, this.mediaSDSService, this.nBestStorage, new PopupTrigger(this.sdsPopupHelper, 20, true), this.hmi, this.picklistHandler, this.dynamicDevices, this, this.dynamicLists));
                commandList.execute("SYSTEMCALL MEDIA_LISTSHOW");
                break;
            }
            case 20024: {
                commandList.add(new MediaDynDeviceSetCommand(this.lc, "MEDIA_DYNDEVICESET", this.sdsHandlerService, this.nBestStorage, this.mediaSDSService, this, iSystemCallParameterArray, this.picklistHandler.getSelectedMediaItem()));
                commandList.execute("SYSTEMCALL MEDIA_DYNDEVICESET");
                break;
            }
            case 20026: {
                commandList.add(new MediaUSBDeviceSetCommand(this.lc, "MEDIA_USBDEVICESET", this.sdsHandlerService, this.mediaSDSService, this, this.nBestStorage, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL MEDIA_USBDEVICESET");
                break;
            }
            case 20020: {
                commandList.add(new MediaMediumSelectCommand(this.lc, "MEDIA_MEDIUMSELECT", this.sdsHandlerService, iSystemCallParameterArray, this.nBestStorage, this.mediaSDSService, this));
                commandList.execute("SYSTEMCALL MEDIA_MEDIUMSELECT");
                break;
            }
            case 20025: {
                commandList.add(new MediaListLineDataGetCommand(this.lc, "MEDIA_LISTLINEDATAGET", this.sdsHandlerService, this.nBestStorage, this.picklistHandler, this.hmi, this.dynamicDevices, this));
                commandList.execute("SYSTEMCALL MEDIA_LISTLINEDATAGET");
                break;
            }
            case 20023: {
                commandList.add(new MediaListLineSetCommand(this.lc, "MEDIA_LISTLINESET", this.sdsHandlerService, this.hmi));
                commandList.execute("SYSTEMCALL MEDIA_LISTLINESET");
                break;
            }
            case 20021: {
                commandList.add(new MediaPlaymodeSetCommand(this.lc, "MEDIA_PLAYMODESET", this.sdsHandlerService, iSystemCallParameterArray, this.mediaSDSService, new MediaPlayModeEvo()));
                commandList.execute("SYSTEMCALL MEDIA_PLAYMODESET");
                break;
            }
            case 20017: {
                commandList.add(new MediaFolderSelectCommand(this.lc, "MEDIA_FOLDERSELECT", this.sdsHandlerService, this.mediaSDSService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL MEDIA_FOLDERSELECT");
                break;
            }
            case 20001: {
                commandList.add(new MediaPlayItemCommand(this.lc, "MEDIA_PLAYITEM", this.sdsHandlerService, iSystemCallParameterArray, this.nBestStorage, this.mediaSDSService, this));
                commandList.execute("SYSTEMCALL MEDIA_PLAYITEM");
                break;
            }
            case 20002: {
                commandList.add(new MediaG2POneshotIsAmbiguousCommand(this.lc, "MEDIA_G2PONESHOTISAMBIGUOUS", this.sdsHandlerService, iSystemCallParameterArray, this.nBestStorage, this.picklistHandler, this));
                commandList.execute("SYSTEMCALL MEDIA_G2PONESHOTISAMBIGUOUS");
                break;
            }
            case 20003: {
                commandList.add(new MediaG2POneshotFilterPicklistCommand(this.lc, "MEDIA_G2PONESHOTFILTERPICKLIST", this.sdsHandlerService, iSystemCallParameterArray, this));
                commandList.execute("SYSTEMCALL MEDIA_G2PONESHOTFILTERPICKLIST");
                break;
            }
            case 20004: {
                commandList.add(new MediaG2POneshotStoreDataCommand(this.lc, "MEDIA_G2PONESHOTSTOREDATA", this.sdsHandlerService, this.picklistHandler, this.nBestStorage, this));
                commandList.execute("SYSTEMCALL MEDIA_G2PONESHOTSTOREDATA");
                break;
            }
            case 20027: {
                commandList.add(new MediaPlayAllTracksCommand(this.lc, "MEDIA_PLAYALLTRACKS", this.sdsHandlerService, this.mediaSDSService));
                commandList.execute("SYSTEMCALL MEDIA_PLAYALLTRACKS");
                break;
            }
            case 1001: {
                this.systemHandler.processCommand(n, iSystemCallParameterArray);
                break;
            }
            default: {
                this.lc.log(10000, "MediaSDSHandlerImpl#processCommand: Unhandled id %1!", (long)n);
            }
        }
    }

    public int[] getCommands() {
        return commands;
    }

    public MediaSDSPicklistHandler getPicklistHandler() {
        return this.picklistHandler;
    }

    public OneshotHandler initializeOneshotHandler(int n) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#initializeOneshotHandler: usecase=%1", (long)n);
        IPicklist iPicklist = n == 3 ? this.nBestStorage.getMatchingPicklist((byte)0) : this.nBestStorage.getMatchingPicklist((byte)2);
        this.oneshotHandler = this.oneshotHandlerFactory.initializeUsecase(n, iPicklist);
        return this.oneshotHandler;
    }

    public OneshotHandler getOneshotHandler() {
        return this.oneshotHandler;
    }

    public boolean freezeLists() {
        this.lc.log(10000000, "MediaSDSHandlerImpl#freezeLists: called");
        return this.mediaSDSService.freezeDynamicLists() == 0;
    }

    public boolean unfreezeLists() {
        this.lc.log(10000000, "MediaSDSHandlerImpl#unfreezeLists: called");
        return this.mediaSDSService.unfreezeDynamicLists() == 0;
    }

    public int getTerminalID() {
        return 0;
    }

    public void ignoreMediaDeviceChanges() {
        this.lc.log(10000000, "MediaSDSHandlerImpl#ignoreMediaDeviceChanges: called");
        SDSModelAccess.ignoreMediaDeviceUpdates(1);
        this.ignoreDeviceChangesTimer.restart();
    }

    public void sourceAvailable(int n, boolean bl) {
        Integer n2 = new Integer(n);
        if (!this.availableDevices.contains(n2) && bl) {
            this.availableDevices.add(n2);
        } else if (!bl) {
            this.availableDevices.remove(n2);
        }
        int n3 = SDSUtils.translate(n, this.source2model);
        if (n3 == Integer.MIN_VALUE) {
            this.lc.log(100000, "[MediaSDSHandlerImpl#sourceAvailable] Unhandled source ID %1!", (long)n);
            return;
        }
        SDSModelAccess.setMediaXYZAvailableChoice(n3, bl ? 1 : 0);
    }

    private List extractDeviceInformation(Iterator iterator, Iterator iterator2) throws ClassCastException {
        int n = (Integer)iterator.next();
        this.lc.log(10000000, "MediaSDSHandlerImpl#extractDeviceInformation: sourceID=%1!", (long)n);
        List list = (List)iterator2.next();
        this.lc.log(10000000, "MediaSDSHandlerImpl#extractDeviceInformation: slotInfoList=", (Object)SDSUtils.toString(list, true));
        ArrayList arrayList = new ArrayList();
        if (SDSUtils.isEmpty(list)) {
            this.lc.log(100000, "MediaSDSHandlerImpl#extractDeviceInformation: Empty slotInfoList!");
            this.dynamicLists.removeFromLookup(54);
            return arrayList;
        }
        int n2 = 0;
        int n3 = list.size();
        Iterator iterator3 = list.iterator();
        while (iterator3.hasNext()) {
            this.lc.log(10000000, "MediaSDSHandlerImpl#extractDeviceInformation: Checking mediaSlotInfoList #%1 of %2!", (long)(++n2), (long)n3);
            MediaSlotInfo mediaSlotInfo = (MediaSlotInfo)iterator3.next();
            if (mediaSlotInfo == null) {
                this.lc.log(10000000, "MediaSDSHandlerImpl#extractDeviceInformation: Empty curSlotInfo!");
                continue;
            }
            String string = mediaSlotInfo.getName();
            if (n == 10) {
                this.storeUSBDeviceInformation(mediaSlotInfo);
            }
            if (SDSUtils.isEmpty(string)) {
                this.lc.log(10000000, "MediaSDSHandlerImpl#extractDeviceInformation: Empty curMediaName!");
                continue;
            }
            this.lc.log(10000000, "MediaSDSHandlerImpl#extractDeviceInformation: Found dynamic device, curMediaName=%1!", (Object)string);
            int n4 = mediaSlotInfo.getSlotIdx();
            long l = SDSUtils.compressValues(n, n4);
            this.lc.log(10000000, "MediaSDSHandlerImpl#extractDeviceInformation: sourceID=%1, curMediaSlotIdx=%2, curMediaID=%3!", (long)n, (long)n4, l);
            arrayList.add(new SDSListEntry(string, l));
        }
        return arrayList;
    }

    private void storeUSBDeviceInformation(MediaSlotInfo mediaSlotInfo) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#storeUSBDeviceInformation: USB-Device available!");
        if (mediaSlotInfo == null) {
            return;
        }
        if (mediaSlotInfo.getType() == 10) {
            int n;
            this.iPodSlot = n = mediaSlotInfo.getSlotIdx();
            this.lc.log(10000000, "MediaSDSHandlerImpl#storeUSBDeviceInformation: iPod found at idx %1!", (long)n);
        } else {
            int n = mediaSlotInfo.getSlotIdx();
            this.usbSlots.add(new Integer(n));
            this.lc.log(10000000, "MediaSDSHandlerImpl#storeUSBDeviceInformation: USB-Device found at idx %1!", (long)n);
        }
    }

    public void sourceListChanged(Map map) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#sourceListChanged: called");
        this.iPodSlot = -1;
        this.usbSlots.clear();
        this.updateCdAndDvdAvailableModels(map);
        if (SDSUtils.isEmpty(map)) {
            this.lc.log(100000, "MediaSDSHandlerImpl#sourceListChanged: Empty sourceList!");
            this.dynamicLists.removeFromLookup(54);
            return;
        }
        int n = map.size();
        this.lc.log(10000000, "MediaSDSHandlerImpl#sourceListChanged: sourceListSize=%1!", (long)n);
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        boolean bl = false;
        Collection collection = map.values();
        if (SDSUtils.isEmpty(collection)) {
            this.lc.log(100000, "MediaSDSHandlerImpl#sourceListChanged: Empty sourceListValues!");
            this.dynamicLists.removeFromLookup(54);
            return;
        }
        Iterator iterator = map.keySet().iterator();
        Object[] objectArray = collection.iterator();
        while (objectArray.hasNext()) {
            try {
                this.lc.log(10000000, "MediaSDSHandlerImpl#sourceListChanged: Checking sourceListValues #%1 of %2!", (long)(++n2), (long)n);
                List list = this.extractDeviceInformation(iterator, (Iterator)objectArray);
                if (list.isEmpty()) continue;
                bl = true;
                arrayList.addAll(list);
            }
            catch (ClassCastException classCastException) {
                this.lc.log(100000, "MediaSDSHandlerImpl#sourceListChanged: Unexpected device list: %1", (Throwable)classCastException);
                return;
            }
        }
        if (!bl) {
            this.lc.log(100000, "MediaSDSHandlerImpl#sourceListChanged: No dynamic devices found!");
            return;
        }
        objectArray = (SDSListEntry[])arrayList.toArray(new SDSListEntry[arrayList.size()]);
        this.lc.log(10000000, "MediaSDSHandlerImpl#sourceListChanged: Adding entries %1!", (Object)SDSUtils.toString(objectArray, false));
        this.dynamicLists.addToLookup(54, new DynamicSlotContent("media sources", (SDSListEntry[])objectArray, 0));
        this.dynamicDevices = objectArray;
    }

    protected void updateCdAndDvdAvailableModels(Map map) {
    }

    public void setDeviceIDs(Long[] longArray) {
        this.deviceIDs = longArray;
        this.lc.log(10000000, "MediaSDSHandlerImpl#setDeviceIDs: deviceIDs=%1!", (Object)this.deviceIDs);
    }

    public boolean isListLineDataGetActive() {
        return SDSUtils.getActiveSystemCall() instanceof MediaListLineDataGetCommand;
    }

    public void sdsListLineDataGet(int n, int n2) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#sdsListLineDataGet: modelID=%1, absLine=%2", (long)n, (long)n2);
        try {
            ((MediaListLineDataGetCommand)SDSUtils.getActiveSystemCall()).sdsListLineDataGet(n2);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#sdsListLineDataGet: Active command is no MediaListLineDataGetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#sdsListLineDataGet: NullpointerException. No active command!");
        }
    }

    public void g2pStateChanged(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#g2pStateChanged: doing nothing");
    }

    public void playAllTracksResult(byte by) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#playAllTracksResult: successful=%1", (long)by);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof MediaPlayAllTracksCommand) {
            ((MediaPlayAllTracksCommand)abstractSystemCallCommand).playAllTracksResult(by);
        } else {
            this.lc.log(10000, "MediaSDSHandlerImpl#playAllTracksResult: Active command is no MediaPlayAllTracksCommand!");
        }
    }

    public void g2pPlayTitleResult(byte by) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#g2pPlayTitleResult: successful=%1", (long)by);
        this.g2pPlayItemResult(by);
    }

    public void g2pPlayAlbumResult(byte by) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#g2pPlayAlbumResult: successful=%1", (long)by);
        this.g2pPlayItemResult(by);
    }

    public void g2pPlayArtistResult(byte by) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#g2pPlayArtistResult: successful=%1", (long)by);
        this.g2pPlayItemResult(by);
    }

    private void g2pPlayItemResult(byte by) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#g2pPlayItemResult: successful=%1", (long)by);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            this.lc.log(10000, "MediaSDSHandlerImpl#g2pPlayItemResult: No active command!");
            return;
        }
        if (abstractSystemCallCommand instanceof IMediaPlayItemCommand) {
            ((IMediaPlayItemCommand)((Object)abstractSystemCallCommand)).playItemResult(by);
        } else {
            this.lc.log(10000, "MediaSDSHandlerImpl#g2pPlayItemResult: Active command doesn't implement the IMediaPlayItem interface");
        }
    }

    public void g2pPlayAlbumOfArtistResult(byte by) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#g2pPlayAlbumOfArtistResult: successful=%1", (long)by);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            this.lc.log(10000, "MediaSDSHandlerImpl#g2pPlayAlbumOfArtistResult: No active command!");
        } else {
            this.lc.log(10000, "MediaSDSHandlerImpl#g2pPlayAlbumOfArtistResult: Active command is no MediaG2PPlayFolderCommand or MediaG2PPlayFolder1Folder2Command!");
        }
    }

    public void g2pPlayTitleOfArtistResult(byte by) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#g2pPlayTitleOfArtistResult: successful=%1", (long)by);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            this.lc.log(10000, "MediaSDSHandlerImpl#g2pPlayTitleOfArtistResult: No active command!");
        } else {
            this.lc.log(10000, "MediaSDSHandlerImpl#g2pPlayTitleOfArtistResult: Active command is no MediaG2PPlayFolderCommand or MediaG2PPlayFolder1Folder2Command!");
        }
    }

    public void g2pPlayTitleOfAlbumResult(byte by) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#g2pPlayTitleOfAlbumResult: successful=%1", (long)by);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            this.lc.log(10000, "MediaSDSHandlerImpl#g2pPlayTitleOfAlbumResult: No active command!");
        } else {
            this.lc.log(10000, "MediaSDSHandlerImpl#g2pPlayTitleOfAlbumResult: Active command is no MediaG2PPlayFolderCommand or MediaG2PPlayFolder1Folder2Command!");
        }
    }

    public void g2pPlayGenreResult(byte by) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#g2pPlayGenreResult: successful=%1", (long)by);
        this.g2pPlayItemResult(by);
    }

    public void responseG2PArtistsOfGenre(byte by, long l, MediaSDSEntry[] mediaSDSEntryArray) {
        this.lc.log(100000, "MediaSDSHandlerImpl#responseG2PArtistsOfGenre: successful=%1, genreID=%2 => NOP!", (long)by, l);
    }

    public void responseG2pAlbumsOfArtist(byte by, long l, long l2, MediaSDSEntry[] mediaSDSEntryArray) {
        this.lc.log(100000, "MediaSDSHandlerImpl#responseG2pAlbumsOfArtist: successful=%1, genreID=%2, artistID=%3 => NOP!", (long)by, l, l2);
    }

    public void responseG2PAlbumsOfArtist(byte by, long l, MediaSDSEntry[] mediaSDSEntryArray) {
        this.lc.log(100000, "MediaSDSHandlerImpl#responseG2PAlbumsOfArtist: successful=%1, artistID=%2 => NOP!", (long)by, l);
    }

    public String toString() {
        return "MediaSDSHandlerImpl";
    }

    public void processedActivateSource(int n) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#processedActivateSource: state=%1", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            this.lc.log(100000, "MediaSDSHandlerImpl#processedActivateSource: No active command!");
        } else if (abstractSystemCallCommand instanceof MediaDeviceSetCommand) {
            ((MediaDeviceSetCommand)abstractSystemCallCommand).sendActivationReply(n);
        } else if (abstractSystemCallCommand instanceof MediaMediumSelectCommand) {
            ((MediaMediumSelectCommand)abstractSystemCallCommand).sendActivationReply(n);
        } else if (abstractSystemCallCommand instanceof MediaDynDeviceSetCommand) {
            ((MediaDynDeviceSetCommand)abstractSystemCallCommand).sendActivationReply(n);
        } else if (abstractSystemCallCommand instanceof MediaUSBDeviceSetCommand) {
            ((MediaUSBDeviceSetCommand)abstractSystemCallCommand).sendActivationReply(n);
        } else {
            this.lc.log(10000, "MediaSDSHandlerImpl#processedActivateSource: Active command is no MediaDeviceSetCommand/MediaMediumSelectCommand/MediaDynDeviceSetCommand!");
        }
    }

    public void processedSetTrackNumber(int n) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#processedSetTrackNumber: state=%1 -> NOP", (long)n);
    }

    public void processedFolderUp(int n) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#processedFolderUp: state=%1", (long)n);
        try {
            ((MediaFolderUpCommand)SDSUtils.getActiveSystemCall()).sendFolderUpReply(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#processedFolderUp: Active command is not MediaFolderUpCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#processedFolderUp: NullpointerException. No active command!");
        }
    }

    public void processedStartBrowsing(int n) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#processedStartBrowsing: state=%1", (long)n);
        try {
            ((MediaFolderSelectCommand)SDSUtils.getActiveSystemCall()).sendStartBrowsingReply(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#processedStartBrowsing: Active command is not MediaFolderSelectCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#processedStartBrowsing: NullpointerException. No active command!");
        }
    }

    public void processedMix(int n) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#processedMix: state=%1", (long)n);
        try {
            ((MediaPlaymodeSetCommand)SDSUtils.getActiveSystemCall()).sendPlaymodeReply(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#processedMix: Active command is not MediaPlaymodeSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#processedMix: NullpointerException. No active command!");
        }
    }

    public void processedRepeatTrack(int n) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#processedRepeatTrack: state=%1", (long)n);
        try {
            ((MediaPlaymodeSetCommand)SDSUtils.getActiveSystemCall()).sendPlaymodeReply(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#processedRepeatTrack: Active command is not MediaPlaymodeSetCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#processedRepeatTrack: NullpointerException. No active command!");
        }
    }

    public void processedPlayMoreLikeThis(int n) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#processedPlayMoreLikeThis: state=%1", (long)n);
        try {
            ((MediaFolderSelectCommand)SDSUtils.getActiveSystemCall()).sendPlayMoreLikeThisReply(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#processedPlayMoreLikeThis: Active command is not MediaFolderSelectCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#processedPlayMoreLikeThis: NullpointerException. No active command!");
        }
    }

    public int getPickListMode() {
        return this.pickListMode;
    }

    public void setPickListMode(int n) {
        this.pickListMode = n;
    }

    public int getIPodSlotIndex() {
        return this.iPodSlot;
    }

    public List getUSBSlotIndexes() {
        return this.usbSlots;
    }

    public void fireTimer(Timer timer) {
        if (timer == this.ignoreDeviceChangesTimer) {
            this.lc.log(10000000, "MediaSDSHandlerImpl#fireTimer: timer=%1", (Object)timer);
            SDSModelAccess.ignoreMediaDeviceUpdates(0);
        }
    }

    public void cancelTimer(Timer timer) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#ignoreDeviceChangesTimer: timer=%1", (Object)timer);
    }

    public void updateActiveSource(MediaSlotInfo mediaSlotInfo, boolean bl) {
        this.lc.log(10000000, "MediaSDSHandlerImpl#updateActiveSource: slotInfo=%1", (Object)mediaSlotInfo);
        if (mediaSlotInfo == null || mediaSlotInfo.isEmpty()) {
            SDSModelAccess.setAllMediaGrammarsAvailable(0);
        } else {
            SDSModelAccess.setMediumSyncState(mediaSlotInfo.isSyncedSource() ? 1 : 0);
            this.updateActiveSourceIfSdOrUsb(mediaSlotInfo);
        }
    }

    public void sourceDeactivated() {
    }

    protected void updateActiveSourceIfSdOrUsb(MediaSlotInfo mediaSlotInfo) {
    }

    public void g2pRequestCoverartsResult(byte by, MediaCoverartEntry[] mediaCoverartEntryArray) {
        try {
            ((IMediaCoverartReceiver)((Object)SDSUtils.getActiveSystemCall())).receiveCoverarts(by, mediaCoverartEntryArray);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#g2pRequestCoverartsResult: Active command doesn't implement IMediaCoverartReceiver!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "MediaSDSHandlerImpl#g2pRequestCoverartsResult: NullpointerException. No active command!");
        }
    }

    public void updatePlaybackState(int n) {
    }
}

