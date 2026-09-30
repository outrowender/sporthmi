/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.interapp.MediaServiceImpl;
import de.audi.app.media.osgi.AbstractServiceListTracker;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.sds.PickListHandler;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.interapp.media.IMediaSDSServiceListener;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.ArrayUtils;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SDSController
extends AbstractMediaTerminalComponent
implements IMediaSDSService,
IDiagnosisCommandProvider {
    private static final String LOGCLASS = "SDSController";
    private volatile ServiceRegistration serviceRegistration;
    private final IServiceTracker sdsServiceTracker;
    private volatile SDSService sdsService;
    private final IServiceManager serviceManager;
    final AbstractServiceListTracker sdsCallbackListenerTracker;
    private final PickListHandler pickListHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaSDSServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaSDSService;

    public SDSController(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.serviceManager = iMediaTerminal.getServiceManager();
        this.pickListHandler = new PickListHandler(iMediaTerminal);
        this.sdsServiceTracker = iMediaTerminal.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = SDSController.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                SDSController.this.logger.sds().log(1000000, "[%1.removedService] SDS service removed", (Object)SDSController.LOGCLASS);
                SDSController.this.serviceManager.releaseService(serviceReference);
                SDSController.this.sdsService = null;
            }

            public Object addingService(ServiceReference serviceReference) {
                SDSController.this.sdsService = (SDSService)SDSController.this.serviceManager.getService(serviceReference);
                SDSController.this.logger.sds().log(1000000, "[%1.addingService] '%2'", (Object)SDSController.LOGCLASS, (Object)SDSController.this.sdsService);
                return SDSController.this.sdsService;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
        this.sdsCallbackListenerTracker = new AbstractServiceListTracker(this.logger.sds(), this.serviceManager){

            protected void serviceRemoved(Object object) {
            }

            protected void serviceAdded(Object object) {
            }

            protected Class getTrackedServiceClass() {
                return class$de$audi$atip$interapp$media$IMediaSDSServiceListener == null ? (class$de$audi$atip$interapp$media$IMediaSDSServiceListener = SDSController.class$("de.audi.atip.interapp.media.IMediaSDSServiceListener")) : class$de$audi$atip$interapp$media$IMediaSDSServiceListener;
            }

            protected boolean checkServiceProperties(Dictionary dictionary) {
                return true;
            }
        };
    }

    public void init() {
        this.logger.sds().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.getTerminal().getDiagnosisManager().addCommandProvider(this.getTerminal().getTerminalID(), this);
        this.serviceRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$interapp$media$IMediaSDSService == null ? (class$de$audi$atip$interapp$media$IMediaSDSService = SDSController.class$("de.audi.atip.interapp.media.IMediaSDSService")) : class$de$audi$atip$interapp$media$IMediaSDSService, this, new Hashtable(0));
        this.sdsServiceTracker.open();
        this.sdsCallbackListenerTracker.init();
    }

    public void deinit() {
        this.logger.sds().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.sdsCallbackListenerTracker.deinit();
        this.serviceRegistration.unregister();
        this.sdsServiceTracker.close();
    }

    public void activateSource(final int n, final int n2, final int n3) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("SDS.activateSource"){

            public void run() {
                SDSController.this.logger.sds().log(1000000, "[%1.activateSource] '%2' (slotIdx='%3', partIdx='%4').", (Object)SDSController.LOGCLASS, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Integer.toString(n3));
                int n4 = MediaServiceImpl.getISourceIDFromMediaSourceID(n);
                if (n4 == -1) {
                    SDSController.this.logger.sds().log(100000, "[%1.activateSource] SourceID '%2' is invalid.", (Object)SDSController.LOGCLASS, (long)n);
                    SDSController.this.notifyProcessedActivateSource(9);
                    return;
                }
                ISourceController iSourceController = SDSController.this.getTerminal().getSourceController();
                ISource iSource = iSourceController.getSource(n4);
                if (iSource == null) {
                    SDSController.this.notifyProcessedActivateSource(1);
                    return;
                }
                int n22 = -1 == n3 ? n2 : iSource.getSlotNumberByPartition(n2, n3);
                SDSController.this.activateSourceSlot(iSource.getSlot(n22));
            }
        });
    }

    public void activateSource(int n, int n2) {
        this.activateSource(n, n2, -1);
    }

    public void activateSource(final int n) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("SDS.activateSource"){

            public void run() {
                SDSController.this.logger.sds().log(1000000, "[%1.activateSource] '%2' ", (Object)SDSController.LOGCLASS, (long)n);
                int n2 = MediaServiceImpl.getISourceIDFromMediaSourceID(n);
                if (n2 == -1) {
                    SDSController.this.logger.sds().log(100000, "[%1.activateSource] SourceID '%2' is invalid.", (Object)SDSController.LOGCLASS, (long)n);
                    SDSController.this.notifyProcessedActivateSource(9);
                    return;
                }
                ISourceController iSourceController = SDSController.this.getTerminal().getSourceController();
                ISource iSource = iSourceController.getSource(n2);
                if (iSource == null) {
                    SDSController.this.notifyProcessedActivateSource(1);
                    return;
                }
                ISourceSlot iSourceSlot = null;
                if (n2 == 11 || n2 == 12) {
                    iSourceSlot = iSource.getSlot(0);
                } else {
                    Iterator iterator = iSource.getSlots().iterator();
                    ISourceSlot iSourceSlot2 = null;
                    while (iterator.hasNext()) {
                        ISourceSlot iSourceSlot3 = (ISourceSlot)iterator.next();
                        if (iSource.isActivateable(iSourceSlot3)) {
                            iSourceSlot = iSourceSlot3;
                            break;
                        }
                        if (iSourceSlot2 != null || iSourceSlot3.isEmpty()) continue;
                        iSourceSlot2 = iSourceSlot3;
                    }
                    if (iSourceSlot == null) {
                        iSourceSlot = iSourceSlot2;
                    }
                }
                SDSController.this.activateSourceSlot(iSourceSlot);
            }
        });
    }

    void activateSourceSlot(ISourceSlot iSourceSlot) {
        if (iSourceSlot == null) {
            this.notifyProcessedActivateSource(3);
            return;
        }
        if (iSourceSlot.isLoading() || iSourceSlot.isReloading()) {
            this.notifyProcessedActivateSource(16);
            return;
        }
        int n = iSourceSlot.getError();
        if (SDSController.isCriticalError(n)) {
            int n2 = this.getSDSErrorCode(n);
            this.notifyProcessedActivateSource(n2);
        } else {
            this.getTerminal().getAudioManager().requestAudioFocus();
            int n3 = this.getTerminal().getSourceController().activateSource(new ActivationContext(iSourceSlot));
            int n4 = iSourceSlot.getError();
            int n5 = SDSController.getSDSActivationResultCode(n3, n4);
            this.notifyProcessedActivateSource(n5);
        }
    }

    private static int getSDSActivationResultCode(int n, int n2) {
        int n3;
        block0 : switch (n) {
            case 3: {
                n3 = 1;
                break;
            }
            case 1: 
            case 2: {
                switch (n2) {
                    case 10: {
                        n3 = 13;
                        break block0;
                    }
                    case 11: {
                        n3 = 14;
                        break block0;
                    }
                    case 14: {
                        n3 = 12;
                        break block0;
                    }
                    case 12: 
                    case 21: {
                        n3 = 10;
                        break block0;
                    }
                    case 13: 
                    case 20: 
                    case 25: {
                        n3 = 11;
                        break block0;
                    }
                    case 26: {
                        n3 = 17;
                        break block0;
                    }
                    case 27: {
                        n3 = 18;
                        break block0;
                    }
                    case 28: {
                        n3 = 19;
                        break block0;
                    }
                }
                n3 = 0;
                break;
            }
            default: {
                n3 = 9;
            }
        }
        return n3;
    }

    private int getSDSErrorCode(int n) {
        int n2;
        switch (n) {
            case 5: {
                n2 = 6;
                break;
            }
            case 19: {
                n2 = 4;
                break;
            }
            case 16: {
                n2 = 5;
                break;
            }
            case 17: 
            case 18: {
                n2 = 1;
                break;
            }
            case 4: {
                n2 = 8;
                break;
            }
            case 24: {
                n2 = 15;
                break;
            }
            case 1: 
            case 2: {
                this.logger.sds().log(1000000, "[%1.activateSource] +++ activateSourceSlot special errors ", (Object)LOGCLASS);
                n2 = 6;
                break;
            }
            default: {
                n2 = 3;
            }
        }
        return n2;
    }

    private static boolean isCriticalError(int n) {
        return n != 0 && n != 12 && n != 13 && n != 10 && n != 11 && n != 14 && n != 21 && n != 20 && n != 3 && n != 25 && n != 26 && n != 27 && n != 28 && n != 29 && n != 30;
    }

    private boolean isActiveSlotReady() {
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        return iSourceSlot != null && iSourceSlot.getSource().isActivateable(iSourceSlot);
    }

    public void setTrackNumber(final int n) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("SDS.setTrackNumber"){

            public void run() {
                SDSController.this.logger.sds().log(1000000, "[%1.setTrackNumber] trackNr='%2'.", (Object)SDSController.LOGCLASS, (long)n);
                if (!SDSController.this.isActiveSlotReady()) {
                    SDSController.this.notifyProcessedSetTracknumber(2);
                    return;
                }
                HashMap hashMap = new HashMap(1);
                hashMap.put("TRACK_NUMBER", new Integer(n));
                Integer n2 = (Integer)SDSController.this.getTerminal().getSDSDispatcher().notifyCommand(20002, SDSController.this.getTerminal().getTerminalID(), hashMap);
                if (n2 == null) {
                    SDSController.this.notifyProcessedSetTracknumber(6);
                    return;
                }
                switch (n2) {
                    case 11001: {
                        SDSController.this.notifyProcessedSetTracknumber(0);
                        break;
                    }
                    default: {
                        SDSController.this.notifyProcessedSetTracknumber(3);
                    }
                }
            }
        });
    }

    public void folderUp() {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("SDS.folderUp"){

            public void run() {
                SDSController.this.logger.sds().log(1000000, "[%1.folderUp]", (Object)SDSController.LOGCLASS);
                if (!SDSController.this.isActiveSlotReady()) {
                    SDSController.this.notifyProcessedFolderUp(2);
                    return;
                }
                Integer n = (Integer)SDSController.this.getTerminal().getSDSDispatcher().notifyCommand(20001, SDSController.this.getTerminal().getTerminalID(), new HashMap(0));
                if (n == null) {
                    SDSController.this.notifyProcessedFolderUp(4);
                    return;
                }
                switch (n) {
                    case 21002: {
                        SDSController.this.notifyProcessedFolderUp(4);
                        break;
                    }
                    case 21001: {
                        SDSController.this.notifyProcessedFolderUp(3);
                        break;
                    }
                    case 11001: {
                        SDSController.this.notifyHMIAboutFolderUp();
                        SDSController.this.notifyProcessedFolderUp(0);
                        break;
                    }
                    default: {
                        SDSController.this.notifyProcessedFolderUp(3);
                    }
                }
            }
        });
    }

    public void startBrowsing(final int n) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("SDS.startBrowsing"){

            public void run() {
                SDSController.this.logger.sds().log(1000000, "[%1.startBrowsing] type='%2'.", (Object)SDSController.LOGCLASS, (long)n);
                if (!SDSController.this.isActiveSlotReady()) {
                    SDSController.this.notifyProcessedStartBrowsing(2);
                    return;
                }
                HashMap hashMap = new HashMap(1);
                hashMap.put(new String("BROWSE_TYPE"), new Integer(n));
                Integer n2 = (Integer)SDSController.this.getTerminal().getSDSDispatcher().notifyCommand(20003, SDSController.this.getTerminal().getTerminalID(), hashMap);
                if (n2 == null) {
                    SDSController.this.notifyProcessedStartBrowsing(1);
                    return;
                }
                switch (n2) {
                    case 11004: {
                        SDSController.this.notifyProcessedStartBrowsing(1);
                        break;
                    }
                    case 11001: {
                        SDSController.this.notifyProcessedStartBrowsing(0);
                        break;
                    }
                    default: {
                        SDSController.this.notifyProcessedStartBrowsing(1);
                    }
                }
            }
        });
    }

    public void playMoreLikeThis() {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("SDS.playMoreLikeThis"){

            public void run() {
                SDSController.this.logger.sds().log(1000000, "[%1.playMoreLikeThis]", (Object)SDSController.LOGCLASS);
                Integer n = (Integer)SDSController.this.getTerminal().getSDSDispatcher().notifyCommand(20005, SDSController.this.getTerminal().getTerminalID(), new HashMap(0));
                if (n == null) {
                    SDSController.this.logger.sds().log(1000000, "[%1.playMoreLikeThis] NOT SUPPORTED", (Object)SDSController.LOGCLASS);
                    SDSController.this.notifyProcessedPlayMoreLikeThis(1);
                    return;
                }
                switch (n) {
                    case 11003: {
                        SDSController.this.logger.sds().log(1000000, "[%1.playMoreLikeThis] FAILED", (Object)SDSController.LOGCLASS);
                        SDSController.this.notifyProcessedPlayMoreLikeThis(3);
                        break;
                    }
                    case 11005: {
                        SDSController.this.logger.sds().log(1000000, "[%1.playMoreLikeThis] NOT READY", (Object)SDSController.LOGCLASS);
                        SDSController.this.notifyProcessedPlayMoreLikeThis(2);
                        break;
                    }
                    case 11001: {
                        SDSController.this.logger.sds().log(1000000, "[%1.playMoreLikeThis] READY", (Object)SDSController.LOGCLASS);
                        SDSController.this.notifyProcessedPlayMoreLikeThis(0);
                        break;
                    }
                    default: {
                        SDSController.this.logger.sds().log(1000000, "[%1.playMoreLikeThis] NOT SUPPORTED", (Object)SDSController.LOGCLASS);
                        SDSController.this.notifyProcessedPlayMoreLikeThis(1);
                    }
                }
            }
        });
    }

    public void mix(final boolean bl) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("SDS.mix"){

            public void run() {
                SDSController.this.logger.sds().log(1000000, "[%1.mix] '%2'", (Object)SDSController.LOGCLASS, (Object)(bl ? "ON" : "OFF"));
                HashMap hashMap = new HashMap(1);
                hashMap.put("MIX", bl);
                Integer n = (Integer)SDSController.this.getTerminal().getSDSDispatcher().notifyCommand(20008, SDSController.this.getTerminal().getTerminalID(), hashMap);
                if (n == null) {
                    SDSController.this.logger.sds().log(1000000, "[%1.mix] NOT SUPPORTED", (Object)SDSController.LOGCLASS);
                    SDSController.this.notifyProcessedMix(1);
                    return;
                }
                switch (n) {
                    case 11002: {
                        SDSController.this.logger.sds().log(1000000, "[%1.mix] RET_ALREADY_SET", (Object)SDSController.LOGCLASS);
                        SDSController.this.notifyProcessedMix(2);
                        break;
                    }
                    case 11001: {
                        SDSController.this.logger.sds().log(1000000, "[%1.mix] SUCCESSFUL", (Object)SDSController.LOGCLASS);
                        SDSController.this.notifyProcessedMix(0);
                        break;
                    }
                    default: {
                        SDSController.this.logger.sds().log(1000000, "[%1.mix] NOT SUPPORTED", (Object)SDSController.LOGCLASS);
                        SDSController.this.notifyProcessedMix(1);
                    }
                }
            }
        });
    }

    public void repeatTrack(final boolean bl) {
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("SDS.repeatTrack"){

            public void run() {
                SDSController.this.logger.sds().log(1000000, "[%1.repeatTrack] '%2'", (Object)SDSController.LOGCLASS, (Object)(bl ? "ON" : "OFF"));
                HashMap hashMap = new HashMap(1);
                hashMap.put("REPEAT_TRACK", bl);
                Integer n = (Integer)SDSController.this.getTerminal().getSDSDispatcher().notifyCommand(20006, SDSController.this.getTerminal().getTerminalID(), hashMap);
                if (null == n) {
                    SDSController.this.logger.sds().log(1000000, "[%1.repeatTrack] NOT SUPPORTED", (Object)SDSController.LOGCLASS);
                    SDSController.this.notifyProcessedRepeatTrack(1);
                    return;
                }
                switch (n) {
                    case 11002: {
                        SDSController.this.logger.sds().log(1000000, "[%1.repeatTrack] RET_ALREADY_SET", (Object)SDSController.LOGCLASS);
                        SDSController.this.notifyProcessedRepeatTrack(4);
                        break;
                    }
                    case 11001: {
                        SDSController.this.logger.sds().log(1000000, "[%1.repeatTrack] SUCCESSFUL", (Object)SDSController.LOGCLASS);
                        SDSController.this.notifyProcessedRepeatTrack(0);
                        break;
                    }
                    default: {
                        SDSController.this.logger.sds().log(1000000, "[%1.repeatTrack] default: NOT SUPPORTED", (Object)SDSController.LOGCLASS);
                        SDSController.this.notifyProcessedRepeatTrack(1);
                    }
                }
            }
        });
    }

    public void playAllTracks() {
        this.logger.sds().log(1000000, "[%1.playAllTracks]", (Object)LOGCLASS);
        byte by = this.g2pCommand(10009, new HashMap(0));
        if (by != 0) {
            this.notifyPlayTitleResult(by);
        }
    }

    public void g2pPlayTitle(long l) {
        this.logger.sds().log(1000000, "[%1.g2pPlayTitle] entryID='%2'.", (Object)LOGCLASS, l);
        HashMap hashMap = new HashMap(1);
        hashMap.put("TITLEID", new Long(l));
        byte by = this.g2pCommand(10001, hashMap);
        if (by != 0) {
            this.notifyPlayTitleResult(by);
        }
    }

    public void g2pPlayTitleOfAlbum(long l, long l2) {
        this.logger.sds().log(1000000, "[%1.g2pPlayTitleOfAlbum] albumID='%2',titleID='%3'.", (Object)LOGCLASS, l, l2);
        HashMap hashMap = new HashMap(2);
        hashMap.put("TITLEID", new Long(l2));
        hashMap.put("ALBUMID", new Long(l));
        byte by = this.g2pCommand(10006, hashMap);
        if (by != 0) {
            this.notifyPlayTitleOfAlbumResult(by);
        }
    }

    public void g2pPlayTitleOfArtist(long l, long l2) {
        this.logger.sds().log(1000000, "[%1.g2pPlayTitleOfArtist] artistID='%2',titleID='%3'.", (Object)LOGCLASS, l, l2);
        HashMap hashMap = new HashMap(2);
        hashMap.put("TITLEID", new Long(l2));
        hashMap.put("ARTISTID", new Long(l));
        byte by = this.g2pCommand(10007, hashMap);
        if (by != 0) {
            this.notifyPlayTitleOfArtistResult(by);
        }
    }

    public void g2pPlayAlbum(long l) {
        this.logger.sds().log(1000000, "[%1.g2pPlayAlbum] albumID='%2'.", (Object)LOGCLASS, l);
        HashMap hashMap = new HashMap(1);
        hashMap.put("ALBUMID", new Long(l));
        byte by = this.g2pCommand(10002, hashMap);
        if (by != 0) {
            this.notifyPlayAlbumResult(by);
        }
    }

    public void g2pPlayAlbumOfArtist(long l, long l2) {
        this.logger.sds().log(1000000, "[%1.g2pPlayAlbumOfArtist] artistID='%2',albumID='%3'.", (Object)LOGCLASS, l, l2);
        HashMap hashMap = new HashMap(2);
        hashMap.put("ALBUMID", new Long(l2));
        hashMap.put("ARTISTID", new Long(l));
        byte by = this.g2pCommand(10008, hashMap);
        if (by != 0) {
            this.notifyPlayAlbumOfArtistResult(by);
        }
    }

    public void g2pPlayArtist(long l) {
        this.logger.sds().log(1000000, "[%1.g2pPlayArtist] artistID='%2'.", (Object)LOGCLASS, l);
        HashMap hashMap = new HashMap(1);
        hashMap.put("ARTISTID", new Long(l));
        byte by = this.g2pCommand(10003, hashMap);
        if (by != 0) {
            this.notifyPlayArtistResult(by);
        }
    }

    public void g2pPlayGenre(long l) {
        this.logger.sds().log(1000000, "[%1.g2pPlayGenre] artistID='%2'.", (Object)LOGCLASS, l);
        HashMap hashMap = new HashMap(1);
        hashMap.put("GENREID", new Long(l));
        byte by = this.g2pCommand(10005, hashMap);
        if (by != 0) {
            this.notifyPlayGenreResult(by);
        }
    }

    private byte g2pCommand(int n, HashMap hashMap) {
        if (!this.isActiveSlotReady()) {
            this.logger.sds().log(1000000, "[%1.g2pCommand] Active slot not ready.", (Object)LOGCLASS);
            return 2;
        }
        Integer n2 = (Integer)this.getTerminal().getSDSDispatcher().notifyCommand(n, this.getTerminal().getTerminalID(), hashMap);
        if (n2 == null) {
            this.logger.sds().log(1000000, "[%1.g2pCommand] Command not found.", (Object)LOGCLASS);
            return 3;
        }
        if (n2 == -1) {
            this.logger.sds().log(1000000, "[%1.g2pCommand] Call failed.", (Object)LOGCLASS);
            return 1;
        }
        return 0;
    }

    public byte fillPickList(SDSListEntry[] sDSListEntryArray) {
        this.logger.sds().log(1000000, "[%1.fillPickList] called.", (Object)LOGCLASS);
        return 1;
    }

    public void showPickList() {
        this.logger.sds().log(1000000, "[%1.showPickList] called.", (Object)LOGCLASS);
    }

    public void hidePickList() {
        this.logger.sds().log(1000000, "[%1.hidePickList] called.", (Object)LOGCLASS);
    }

    public byte freezeDynamicLists() {
        return 0;
    }

    public byte unfreezeDynamicLists() {
        return 0;
    }

    public String[] getDiagKeys() {
        return new String[]{"sds.activateSource", "sds.folderup", "sds.cda.setTrack", "sds.isCoverflowAccessible", "sds.playMoreLikeThis", "sds.mix", "sds.repeatTrack", "sds.requestCoverarts", "sds.startBrowsing", "sds.fillBrowserPicklist", "sds.playAllTracks"};
    }

    public void executeDiagCommand(String string, String[] stringArray) {
        if ("sds.folderup".equals(string)) {
            this.folderUp();
        } else if ("sds.cda.setTrack".equals(string)) {
            this.setTrackNumber(new Integer(stringArray[0]));
        } else if ("sds.playMoreLikeThis".equals(string)) {
            this.playMoreLikeThis();
        } else if ("sds.mix".equals(string)) {
            this.mix("ON".equals(stringArray[0].toUpperCase()));
        } else if ("sds.repeatTrack".equals(string)) {
            this.repeatTrack("ON".equals(stringArray[0].toUpperCase()));
        } else if ("sds.startBrowsing".equals(string)) {
            this.startBrowsing(Integer.parseInt(stringArray[0]));
        } else if ("sds.requestCoverarts".equals(string)) {
            int n = Integer.parseInt(stringArray[0]);
            long[] lArray = new long[stringArray.length - 1];
            for (int i2 = 0; i2 < stringArray.length - 1; ++i2) {
                lArray[i2] = Long.parseLong(stringArray[i2 + 1]);
            }
            this.g2pRequestCoverarts(lArray, n);
        } else if ("sds.activateSource".equals(string)) {
            this.activateSource(Integer.parseInt(stringArray[0]));
        } else if ("sds.fillBrowserPicklist".equals(string)) {
            byte by = Byte.parseByte(stringArray[0]);
            int n = Integer.parseInt(stringArray[1]);
            IMediaSDSService.MediaSDSListEntry[] mediaSDSListEntryArray = new IMediaSDSService.MediaSDSListEntry[n];
            for (int i3 = 0; i3 < n; ++i3) {
                mediaSDSListEntryArray[i3] = new IMediaSDSService.MediaSDSListEntry(new StringBuffer().append("Dummy ").append(i3).toString(), i3, 0);
            }
            this.fillPickList(mediaSDSListEntryArray, by);
        } else if ("sds.playAllTracks".equals(string)) {
            this.playAllTracks();
        }
    }

    private void notifyProcessedActivateSource(final int n) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).processedActivateSource(n);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyProcessedSetTracknumber(final int n) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).processedSetTrackNumber(n);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyProcessedFolderUp(final int n) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).processedFolderUp(n);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyProcessedMix(final int n) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).processedMix(n);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyProcessedRepeatTrack(final int n) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).processedRepeatTrack(n);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyProcessedStartBrowsing(final int n) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).processedStartBrowsing(n);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyProcessedPlayMoreLikeThis(final int n) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).processedPlayMoreLikeThis(n);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyPlayAlbumOfArtistResult(final byte by) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).g2pPlayAlbumOfArtistResult(by);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyPlayAlbumResult(final byte by) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).g2pPlayAlbumResult(by);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyPlayArtistResult(final byte by) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).g2pPlayArtistResult(by);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyPlayTitleOfAlbumResult(final byte by) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).g2pPlayTitleOfAlbumResult(by);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyPlayTitleOfArtistResult(final byte by) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).g2pPlayTitleOfArtistResult(by);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyPlayTitleResult(final byte by) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).g2pPlayTitleResult(by);
            }
        };
        abstractListenerCallback.execute();
    }

    private void notifyPlayGenreResult(final byte by) {
        AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

            public void doCall(Object object) {
                ((IMediaSDSServiceListener)object).g2pPlayGenreResult(by);
            }
        };
        abstractListenerCallback.execute();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public byte fillPickList(IMediaSDSService.MediaSDSListEntry[] mediaSDSListEntryArray, byte by) {
        byte by2;
        switch (by) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                this.logger.sds().log(1000000, "[%1.fillPicklist] browser: listmode = %2", (Object)LOGCLASS, (long)by);
                this.pickListHandler.fillBrowserPickList(mediaSDSListEntryArray, by);
                by2 = 1;
                break;
            }
            case 0: {
                this.logger.sds().log(1000000, "[%1.fillPicklist] device", (Object)LOGCLASS);
                this.pickListHandler.fillSourcePickList(mediaSDSListEntryArray);
                by2 = 1;
                break;
            }
            default: {
                this.logger.sds().log(100000, "[%1.fillPicklist] unknown listmode(%2)", (Object)LOGCLASS, (long)by);
                by2 = 2;
            }
        }
        return by2;
    }

    public void g2pRequestCoverarts(long[] lArray, int n) {
        this.logger.sds().log(1000000, "[%1.requestCoverArts]", (Object)LOGCLASS);
        HashMap hashMap = new HashMap(2);
        hashMap.put("ENTRYIDS", ArrayUtils.toObjects(lArray));
        hashMap.put("LISTMODE", Util.createInteger(n));
        final byte by = this.g2pCommand(10004, hashMap);
        if (by != 0) {
            AbstractListenerCallback abstractListenerCallback = new AbstractListenerCallback(this.sdsCallbackListenerTracker.getServices()){

                public void doCall(Object object) {
                    ((IMediaSDSServiceListener)object).g2pRequestCoverartsResult(by, null);
                }
            };
            abstractListenerCallback.execute();
        }
    }

    private void notifyHMIAboutFolderUp() {
        this.logger.sds().log(1000000, "[%1.notifyHMIAboutFolderUp]", (Object)LOGCLASS);
        int n = this.getChoiceModel(200863).getValue() != 1 ? 1 : 0;
        this.getChoiceModel(200863).setValue(n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private abstract class AbstractListenerCallback {
        private final List serviceList;

        public AbstractListenerCallback(List list) {
            this.serviceList = list;
        }

        public abstract void doCall(Object var1);

        public void execute() {
            Iterator iterator = this.serviceList.iterator();
            while (iterator.hasNext()) {
                try {
                    this.doCall(iterator.next());
                }
                catch (Exception exception) {
                    SDSController.this.logger.sds().log(100000, "[%1.notifyActivateSourceProcessed] %2", (Object)SDSController.LOGCLASS, (Throwable)exception);
                }
            }
        }
    }
}

