/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.AbstractServiceListTracker;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.sds.PickListHandler;
import de.audi.app.media.sds.SDSController$1;
import de.audi.app.media.sds.SDSController$10;
import de.audi.app.media.sds.SDSController$11;
import de.audi.app.media.sds.SDSController$12;
import de.audi.app.media.sds.SDSController$13;
import de.audi.app.media.sds.SDSController$14;
import de.audi.app.media.sds.SDSController$15;
import de.audi.app.media.sds.SDSController$16;
import de.audi.app.media.sds.SDSController$17;
import de.audi.app.media.sds.SDSController$18;
import de.audi.app.media.sds.SDSController$19;
import de.audi.app.media.sds.SDSController$2;
import de.audi.app.media.sds.SDSController$20;
import de.audi.app.media.sds.SDSController$21;
import de.audi.app.media.sds.SDSController$22;
import de.audi.app.media.sds.SDSController$23;
import de.audi.app.media.sds.SDSController$24;
import de.audi.app.media.sds.SDSController$25;
import de.audi.app.media.sds.SDSController$3;
import de.audi.app.media.sds.SDSController$4;
import de.audi.app.media.sds.SDSController$5;
import de.audi.app.media.sds.SDSController$6;
import de.audi.app.media.sds.SDSController$7;
import de.audi.app.media.sds.SDSController$8;
import de.audi.app.media.sds.SDSController$9;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.interapp.media.IMediaSDSService$MediaSDSListEntry;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.ArrayUtils;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class SDSController
extends AbstractMediaTerminalComponent
implements IMediaSDSService,
IDiagnosisCommandProvider {
    private static final String LOGCLASS;
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
        this.sdsServiceTracker = iMediaTerminal.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = SDSController.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService, new SDSController$1(this));
        this.sdsCallbackListenerTracker = new SDSController$2(this, this.logger.sds(), this.serviceManager);
    }

    public void init() {
        this.logger.sds().log(1078071040, "[%1.init]", (Object)"SDSController");
        this.getTerminal().getDiagnosisManager().addCommandProvider(this.getTerminal().getTerminalID(), this);
        this.serviceRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$atip$interapp$media$IMediaSDSService == null ? (class$de$audi$atip$interapp$media$IMediaSDSService = SDSController.class$("de.audi.atip.interapp.media.IMediaSDSService")) : class$de$audi$atip$interapp$media$IMediaSDSService, this, new Hashtable(0));
        this.sdsServiceTracker.open();
        this.sdsCallbackListenerTracker.init();
    }

    public void deinit() {
        this.logger.sds().log(1078071040, "[%1.deinit]", (Object)"SDSController");
        this.sdsCallbackListenerTracker.deinit();
        this.serviceRegistration.unregister();
        this.sdsServiceTracker.close();
    }

    @Override
    public void activateSource(int n, int n2, int n3) {
        this.getTerminal().getDispatcher().execute(new SDSController$3(this, "SDS.activateSource", n, n2, n3));
    }

    @Override
    public void activateSource(int n, int n2) {
        this.activateSource(n, n2, -1);
    }

    @Override
    public void activateSource(int n) {
        this.getTerminal().getDispatcher().execute(new SDSController$4(this, "SDS.activateSource", n));
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
                this.logger.sds().log(1078071040, "[%1.activateSource] +++ activateSourceSlot special errors ", (Object)"SDSController");
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

    @Override
    public void setTrackNumber(int n) {
        this.getTerminal().getDispatcher().execute(new SDSController$5(this, "SDS.setTrackNumber", n));
    }

    @Override
    public void folderUp() {
        this.getTerminal().getDispatcher().execute(new SDSController$6(this, "SDS.folderUp"));
    }

    @Override
    public void startBrowsing(int n) {
        this.getTerminal().getDispatcher().execute(new SDSController$7(this, "SDS.startBrowsing", n));
    }

    @Override
    public void playMoreLikeThis() {
        this.getTerminal().getDispatcher().execute(new SDSController$8(this, "SDS.playMoreLikeThis"));
    }

    @Override
    public void mix(boolean bl) {
        this.getTerminal().getDispatcher().execute(new SDSController$9(this, "SDS.mix", bl));
    }

    @Override
    public void repeatTrack(boolean bl) {
        this.getTerminal().getDispatcher().execute(new SDSController$10(this, "SDS.repeatTrack", bl));
    }

    @Override
    public void playAllTracks() {
        this.logger.sds().log(1078071040, "[%1.playAllTracks]", (Object)"SDSController");
        byte by = this.g2pCommand(10009, new HashMap(0));
        if (by != 0) {
            this.notifyPlayTitleResult(by);
        }
    }

    @Override
    public void g2pPlayTitle(long l) {
        this.logger.sds().log(1078071040, "[%1.g2pPlayTitle] entryID='%2'.", (Object)"SDSController", l);
        HashMap hashMap = new HashMap(1);
        hashMap.put("TITLEID", new Long(l));
        byte by = this.g2pCommand(10001, hashMap);
        if (by != 0) {
            this.notifyPlayTitleResult(by);
        }
    }

    @Override
    public void g2pPlayTitleOfAlbum(long l, long l2) {
        this.logger.sds().log(1078071040, "[%1.g2pPlayTitleOfAlbum] albumID='%2',titleID='%3'.", (Object)"SDSController", l, l2);
        HashMap hashMap = new HashMap(2);
        hashMap.put("TITLEID", new Long(l2));
        hashMap.put("ALBUMID", new Long(l));
        byte by = this.g2pCommand(10006, hashMap);
        if (by != 0) {
            this.notifyPlayTitleOfAlbumResult(by);
        }
    }

    @Override
    public void g2pPlayTitleOfArtist(long l, long l2) {
        this.logger.sds().log(1078071040, "[%1.g2pPlayTitleOfArtist] artistID='%2',titleID='%3'.", (Object)"SDSController", l, l2);
        HashMap hashMap = new HashMap(2);
        hashMap.put("TITLEID", new Long(l2));
        hashMap.put("ARTISTID", new Long(l));
        byte by = this.g2pCommand(10007, hashMap);
        if (by != 0) {
            this.notifyPlayTitleOfArtistResult(by);
        }
    }

    @Override
    public void g2pPlayAlbum(long l) {
        this.logger.sds().log(1078071040, "[%1.g2pPlayAlbum] albumID='%2'.", (Object)"SDSController", l);
        HashMap hashMap = new HashMap(1);
        hashMap.put("ALBUMID", new Long(l));
        byte by = this.g2pCommand(10002, hashMap);
        if (by != 0) {
            this.notifyPlayAlbumResult(by);
        }
    }

    @Override
    public void g2pPlayAlbumOfArtist(long l, long l2) {
        this.logger.sds().log(1078071040, "[%1.g2pPlayAlbumOfArtist] artistID='%2',albumID='%3'.", (Object)"SDSController", l, l2);
        HashMap hashMap = new HashMap(2);
        hashMap.put("ALBUMID", new Long(l2));
        hashMap.put("ARTISTID", new Long(l));
        byte by = this.g2pCommand(10008, hashMap);
        if (by != 0) {
            this.notifyPlayAlbumOfArtistResult(by);
        }
    }

    @Override
    public void g2pPlayArtist(long l) {
        this.logger.sds().log(1078071040, "[%1.g2pPlayArtist] artistID='%2'.", (Object)"SDSController", l);
        HashMap hashMap = new HashMap(1);
        hashMap.put("ARTISTID", new Long(l));
        byte by = this.g2pCommand(10003, hashMap);
        if (by != 0) {
            this.notifyPlayArtistResult(by);
        }
    }

    @Override
    public void g2pPlayGenre(long l) {
        this.logger.sds().log(1078071040, "[%1.g2pPlayGenre] artistID='%2'.", (Object)"SDSController", l);
        HashMap hashMap = new HashMap(1);
        hashMap.put("GENREID", new Long(l));
        byte by = this.g2pCommand(10005, hashMap);
        if (by != 0) {
            this.notifyPlayGenreResult(by);
        }
    }

    private byte g2pCommand(int n, HashMap hashMap) {
        if (!this.isActiveSlotReady()) {
            this.logger.sds().log(1078071040, "[%1.g2pCommand] Active slot not ready.", (Object)"SDSController");
            return 2;
        }
        Integer n2 = (Integer)this.getTerminal().getSDSDispatcher().notifyCommand(n, this.getTerminal().getTerminalID(), hashMap);
        if (n2 == null) {
            this.logger.sds().log(1078071040, "[%1.g2pCommand] Command not found.", (Object)"SDSController");
            return 3;
        }
        if (n2 == -1) {
            this.logger.sds().log(1078071040, "[%1.g2pCommand] Call failed.", (Object)"SDSController");
            return 1;
        }
        return 0;
    }

    @Override
    public byte fillPickList(SDSListEntry[] sDSListEntryArray) {
        this.logger.sds().log(1078071040, "[%1.fillPickList] called.", (Object)"SDSController");
        return 1;
    }

    @Override
    public void showPickList() {
        this.logger.sds().log(1078071040, "[%1.showPickList] called.", (Object)"SDSController");
    }

    @Override
    public void hidePickList() {
        this.logger.sds().log(1078071040, "[%1.hidePickList] called.", (Object)"SDSController");
    }

    @Override
    public byte freezeDynamicLists() {
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        return 0;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"sds.activateSource", "sds.folderup", "sds.cda.setTrack", "sds.isCoverflowAccessible", "sds.playMoreLikeThis", "sds.mix", "sds.repeatTrack", "sds.requestCoverarts", "sds.startBrowsing", "sds.fillBrowserPicklist", "sds.playAllTracks"};
    }

    @Override
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
            IMediaSDSService$MediaSDSListEntry[] iMediaSDSService$MediaSDSListEntryArray = new IMediaSDSService$MediaSDSListEntry[n];
            for (int i3 = 0; i3 < n; ++i3) {
                iMediaSDSService$MediaSDSListEntryArray[i3] = new IMediaSDSService$MediaSDSListEntry(new StringBuffer().append("Dummy ").append(i3).toString(), i3, 0);
            }
            this.fillPickList(iMediaSDSService$MediaSDSListEntryArray, by);
        } else if ("sds.playAllTracks".equals(string)) {
            this.playAllTracks();
        }
    }

    private void notifyProcessedActivateSource(int n) {
        SDSController$11 sDSController$11 = new SDSController$11(this, this.sdsCallbackListenerTracker.getServices(), n);
        sDSController$11.execute();
    }

    private void notifyProcessedSetTracknumber(int n) {
        SDSController$12 sDSController$12 = new SDSController$12(this, this.sdsCallbackListenerTracker.getServices(), n);
        sDSController$12.execute();
    }

    private void notifyProcessedFolderUp(int n) {
        SDSController$13 sDSController$13 = new SDSController$13(this, this.sdsCallbackListenerTracker.getServices(), n);
        sDSController$13.execute();
    }

    private void notifyProcessedMix(int n) {
        SDSController$14 sDSController$14 = new SDSController$14(this, this.sdsCallbackListenerTracker.getServices(), n);
        sDSController$14.execute();
    }

    private void notifyProcessedRepeatTrack(int n) {
        SDSController$15 sDSController$15 = new SDSController$15(this, this.sdsCallbackListenerTracker.getServices(), n);
        sDSController$15.execute();
    }

    private void notifyProcessedStartBrowsing(int n) {
        SDSController$16 sDSController$16 = new SDSController$16(this, this.sdsCallbackListenerTracker.getServices(), n);
        sDSController$16.execute();
    }

    private void notifyProcessedPlayMoreLikeThis(int n) {
        SDSController$17 sDSController$17 = new SDSController$17(this, this.sdsCallbackListenerTracker.getServices(), n);
        sDSController$17.execute();
    }

    private void notifyPlayAlbumOfArtistResult(byte by) {
        SDSController$18 sDSController$18 = new SDSController$18(this, this.sdsCallbackListenerTracker.getServices(), by);
        sDSController$18.execute();
    }

    private void notifyPlayAlbumResult(byte by) {
        SDSController$19 sDSController$19 = new SDSController$19(this, this.sdsCallbackListenerTracker.getServices(), by);
        sDSController$19.execute();
    }

    private void notifyPlayArtistResult(byte by) {
        SDSController$20 sDSController$20 = new SDSController$20(this, this.sdsCallbackListenerTracker.getServices(), by);
        sDSController$20.execute();
    }

    private void notifyPlayTitleOfAlbumResult(byte by) {
        SDSController$21 sDSController$21 = new SDSController$21(this, this.sdsCallbackListenerTracker.getServices(), by);
        sDSController$21.execute();
    }

    private void notifyPlayTitleOfArtistResult(byte by) {
        SDSController$22 sDSController$22 = new SDSController$22(this, this.sdsCallbackListenerTracker.getServices(), by);
        sDSController$22.execute();
    }

    private void notifyPlayTitleResult(byte by) {
        SDSController$23 sDSController$23 = new SDSController$23(this, this.sdsCallbackListenerTracker.getServices(), by);
        sDSController$23.execute();
    }

    private void notifyPlayGenreResult(byte by) {
        SDSController$24 sDSController$24 = new SDSController$24(this, this.sdsCallbackListenerTracker.getServices(), by);
        sDSController$24.execute();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("SDSController").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public byte fillPickList(IMediaSDSService$MediaSDSListEntry[] iMediaSDSService$MediaSDSListEntryArray, byte by) {
        byte by2;
        switch (by) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                this.logger.sds().log(1078071040, "[%1.fillPicklist] browser: listmode = %2", (Object)"SDSController", (long)by);
                this.pickListHandler.fillBrowserPickList(iMediaSDSService$MediaSDSListEntryArray, by);
                by2 = 1;
                break;
            }
            case 0: {
                this.logger.sds().log(1078071040, "[%1.fillPicklist] device", (Object)"SDSController");
                this.pickListHandler.fillSourcePickList(iMediaSDSService$MediaSDSListEntryArray);
                by2 = 1;
                break;
            }
            default: {
                this.logger.sds().log(-1601830656, "[%1.fillPicklist] unknown listmode(%2)", (Object)"SDSController", (long)by);
                by2 = 2;
            }
        }
        return by2;
    }

    @Override
    public void g2pRequestCoverarts(long[] lArray, int n) {
        this.logger.sds().log(1078071040, "[%1.requestCoverArts]", (Object)"SDSController");
        HashMap hashMap = new HashMap(2);
        hashMap.put("ENTRYIDS", ArrayUtils.toObjects(lArray));
        hashMap.put("LISTMODE", Util.createInteger(n));
        byte by = this.g2pCommand(10004, hashMap);
        if (by != 0) {
            SDSController$25 sDSController$25 = new SDSController$25(this, this.sdsCallbackListenerTracker.getServices(), by);
            sDSController$25.execute();
        }
    }

    private void notifyHMIAboutFolderUp() {
        this.logger.sds().log(1078071040, "[%1.notifyHMIAboutFolderUp]", (Object)"SDSController");
        int n = this.getChoiceModel(-1626340608).getValue() != 1 ? 1 : 0;
        this.getChoiceModel(-1626340608).setValue(n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IMediaLogger access$000(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IServiceManager access$100(SDSController sDSController) {
        return sDSController.serviceManager;
    }

    static /* synthetic */ SDSService access$202(SDSController sDSController, SDSService sDSService) {
        sDSController.sdsService = sDSService;
        return sDSController.sdsService;
    }

    static /* synthetic */ SDSService access$200(SDSController sDSController) {
        return sDSController.sdsService;
    }

    static /* synthetic */ IMediaLogger access$300(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$400(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$500(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ void access$600(SDSController sDSController, int n) {
        sDSController.notifyProcessedActivateSource(n);
    }

    static /* synthetic */ IMediaLogger access$700(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$800(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$900(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ boolean access$1000(SDSController sDSController) {
        return sDSController.isActiveSlotReady();
    }

    static /* synthetic */ void access$1100(SDSController sDSController, int n) {
        sDSController.notifyProcessedSetTracknumber(n);
    }

    static /* synthetic */ IMediaLogger access$1200(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ void access$1300(SDSController sDSController, int n) {
        sDSController.notifyProcessedFolderUp(n);
    }

    static /* synthetic */ void access$1400(SDSController sDSController) {
        sDSController.notifyHMIAboutFolderUp();
    }

    static /* synthetic */ IMediaLogger access$1500(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ void access$1600(SDSController sDSController, int n) {
        sDSController.notifyProcessedStartBrowsing(n);
    }

    static /* synthetic */ IMediaLogger access$1700(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$1800(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ void access$1900(SDSController sDSController, int n) {
        sDSController.notifyProcessedPlayMoreLikeThis(n);
    }

    static /* synthetic */ IMediaLogger access$2000(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$2100(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$2200(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$2300(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$2400(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$2500(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ void access$2600(SDSController sDSController, int n) {
        sDSController.notifyProcessedMix(n);
    }

    static /* synthetic */ IMediaLogger access$2700(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$2800(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$2900(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$3000(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$3100(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ void access$3200(SDSController sDSController, int n) {
        sDSController.notifyProcessedRepeatTrack(n);
    }

    static /* synthetic */ IMediaLogger access$3300(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$3400(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$3500(SDSController sDSController) {
        return sDSController.logger;
    }

    static /* synthetic */ IMediaLogger access$3600(SDSController sDSController) {
        return sDSController.logger;
    }
}

