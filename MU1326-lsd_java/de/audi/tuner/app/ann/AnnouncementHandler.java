/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.ann;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.audio.IAnnouncementStateListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerConfiguration;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.IPSFreezeDB;
import de.audi.tuner.app.ann.AnnoncementVolumeChangeHandler;
import de.audi.tuner.app.ann.AnnouncementHandler$1;
import de.audi.tuner.app.ann.AnnouncementHandler$ChoiceListener;
import de.audi.tuner.app.ann.AnnouncementHandler$PowerEventListener;
import de.audi.tuner.app.ann.AnnouncementHandler$TunerActionProxyListenerExt;
import de.audi.tuner.app.ann.AnnouncementHandler$TunerDiagnosisSessionListener;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.ITunerAnnounce;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.sds.UpdateListenerHandler;
import de.audi.tuner.util.NullDSITunerAnnouncement;
import de.esolutions.fw.util.commons.Buffer;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSITunerAnnouncement;
import org.dsi.ifc.radio.DSITunerAnnouncementListener;

public final class AnnouncementHandler
extends UpdateListenerHandler
implements DSITunerAnnouncementListener,
ITunerAnnounce {
    public final AnnouncementHandler$PowerEventListener powerEventListener = new AnnouncementHandler$PowerEventListener(this, null);
    public final AnnouncementHandler$TunerDiagnosisSessionListener diagnosisListener = new AnnouncementHandler$TunerDiagnosisSessionListener(null);
    public static final int ANNOUNCEMENTS_OFF;
    private static final int ANNOUNCEMENTS_FM;
    public static final int ANNOUNCEMENTS_FM_AND_DAB;
    public static final int FILTER_MASK_NONE;
    private static final int FILTER_MASK_DAB_ADD;
    private static final int FILTER_MASK_FM_TA;
    private static final int FILTER_MASK_FM_EON_TA;
    private static final int FILTER_MASK_AMFM_TA;
    private static final int FILTER_MASK_PTY31;
    private static final int FILTER_MASK_DAB_ALARM;
    private static final int FILTER_MASK_DAB_TA;
    private static final int FILTER_MASK_DAB_TRANSPORT;
    public final TunerActionProxyListener actionProxyListener = new AnnouncementHandler$TunerActionProxyListenerExt(this, null);
    private DSITunerAnnouncement dsi;
    private int activeFilter = 0;
    private boolean taReceiveStatus = false;
    private boolean dabAvailable = false;
    private boolean firstAudioReached;
    private final Logger logger;
    private final TunerModels models;
    private final TunerStorage storage;
    private final TunerAudioMgmt audio;
    private final AnnoncementVolumeChangeHandler annVolChange;
    private final Object mutex = new Object();
    private final ITunerVariantExt variantExt;
    private final IPSFreezeDB psFreezeDB;
    private final ChoiceModelApp suppressTAPopupChoice;
    private int activeAnnouncement = 20;
    private volatile int pwrevt = 0;
    private volatile int backupStatus = 20;
    private boolean amAvailable;
    private int taLastMode = 0;
    private List announcementStateListenerList;
    private boolean dsiNotificationDone = false;

    public AnnouncementHandler(TunerBasics tunerBasics, TunerStorage tunerStorage, TunerAudioMgmt tunerAudioMgmt, ITunerVariantExt iTunerVariantExt, IPSFreezeDB iPSFreezeDB) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.storage = tunerStorage;
        this.audio = tunerAudioMgmt;
        this.variantExt = iTunerVariantExt;
        this.psFreezeDB = iPSFreezeDB;
        this.announcementStateListenerList = new LinkedList();
        this.annVolChange = new AnnoncementVolumeChangeHandler(tunerBasics, this, tunerAudioMgmt);
        if (Utilities.isTASupported()) {
            this.models.getChoiceModel(4115).setValue(1);
        }
        this.dsi = new NullDSITunerAnnouncement(this.logger.announce);
        this.models.getLabelModel(397).setText("");
        this.models.getChoiceModel(1535574272).setStatus(0);
        this.models.getChoiceModel(-1534656256).setStatus(1);
        this.models.getChoiceModel(0x880100).setStatus(0);
        AnnouncementHandler$ChoiceListener announcementHandler$ChoiceListener = new AnnouncementHandler$ChoiceListener(this, null);
        this.models.getChoiceModel(1535574272).setChoiceListener(announcementHandler$ChoiceListener);
        this.models.getChoiceModel(-1534656256).setChoiceListener(announcementHandler$ChoiceListener);
        this.models.getChoiceModel(0x880100).setChoiceListener(announcementHandler$ChoiceListener);
        this.models.getChoiceModel(-1635254016).setChoiceListener(announcementHandler$ChoiceListener);
        this.models.getButtonModel(-1115225856).setButtonListener(announcementHandler$ChoiceListener);
        this.models.getButtonModel(5551).setButtonListener(announcementHandler$ChoiceListener);
        this.models.getButtonModel(3826).setButtonListener(announcementHandler$ChoiceListener);
        this.models.getButtonModel(3827).setButtonListener(announcementHandler$ChoiceListener);
        this.suppressTAPopupChoice = this.models.getChoiceModel(-2138504960);
        this.suppressTAPopupChoice.setChoiceListener(new AnnouncementHandler$1(this));
        this.setDABAvailable(Utilities.isDABPresent());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setDeviceService(DSITunerAnnouncement dSITunerAnnouncement) {
        Object object = this.mutex;
        synchronized (object) {
            this.dsi = dSITunerAnnouncement;
            this.init();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setAudioAvailable(boolean bl) {
        this.amAvailable = bl;
        Object object = this.mutex;
        synchronized (object) {
            if (!this.firstAudioReached && bl) {
                this.firstAudioReached = bl;
                this.init();
            }
        }
    }

    private void init() {
        this.logger.announce.log(1078071040, "[AnnouncementHandler.init] firstAudioReached:%1 DSI:%2", this.firstAudioReached, (Object)this.dsi);
        if (!(this.dsi instanceof NullDSITunerAnnouncement) && this.firstAudioReached) {
            int[] nArray = this.storage.loadTASetup();
            this.taLastMode = nArray[1];
            this.suppressTAPopupChoice.setValue(TunerModels.booleanToCheckboxConstant(this.storage.loadSuppressTAPopup()));
            this.switchTrafficAnnouncements(nArray[0], nArray[2] == 1);
            this.setNotification(new int[]{1, 4, 3, 2});
            this.dsiNotificationDone = true;
        }
    }

    public void deinit() {
        this.logger.announce.log(-2137614336, "[AnnouncementHandler.deinit]");
        int[] nArray = new int[]{1, 4, 3, 2};
        this.logger.announce.log(1078071040, "[AnnouncementHandler.deinit] Clearing notification on announce attributes ");
        this.dsi.clearNotification(nArray, (DSIListener)this);
        this.dsiNotificationDone = false;
    }

    public void addAnnouncementStateListener(IAnnouncementStateListener iAnnouncementStateListener) {
        if (!this.announcementStateListenerList.contains(iAnnouncementStateListener)) {
            this.logger.announce.log(-2137614336, "[AnnouncementHandler.addAnnouncementStateListener] listener:%1", (Object)iAnnouncementStateListener);
            this.announcementStateListenerList.add(iAnnouncementStateListener);
            if (this.dsiNotificationDone) {
                this.setNotification(new int[]{1});
            }
        }
    }

    public void removeAnnouncementStateListener(IAnnouncementStateListener iAnnouncementStateListener) {
        if (this.announcementStateListenerList.contains(iAnnouncementStateListener)) {
            this.logger.announce.log(-2137614336, "[AnnouncementHandler.removeAnnouncementStateListener] listener:%1", (Object)iAnnouncementStateListener);
            this.announcementStateListenerList.remove(iAnnouncementStateListener);
        }
    }

    public int getActiveFilter() {
        return this.activeFilter;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.announce.log(-1601830656, "[AnnouncementHandler.asyncException] msg:%1 error:%2 request:%3", (Object)string, (long)n, (long)n2);
    }

    public void switchTrafficAnnouncements(int n, boolean bl) {
        int n2;
        this.logger.announce.log(-2137614336, "[AnnouncementHandler.switchTrafficAnnouncements] %1", (long)n);
        if (Utilities.isTASupported()) {
            n2 = n > 0 ? 1 : 0;
            this.setTpIcon(n2 != 0);
        }
        n2 = AnnouncementHandler.getAlarmMask();
        if (bl) {
            n2 |= 0x3FC0;
        }
        switch (n) {
            case 0: {
                this.logger.announce.log(-2137614336, "[AnnouncementHandler.switchTrafficAnnouncements] Disable traffic announcements");
                if (this.activeAnnouncement == 20) break;
                this.abortAnnouncement();
                break;
            }
            case 1: {
                this.logger.announce.log(-2137614336, "[AnnouncementHandler.switchTrafficAnnouncements] Enable FM traffic announcements");
                n2 |= 5;
                if (this.activeAnnouncement == 3 || this.activeAnnouncement == 1) break;
                this.abortAnnouncement();
                break;
            }
            case 2: {
                this.logger.announce.log(-2137614336, "[AnnouncementHandler.switchTrafficAnnouncements] Enable FM+DAB traffic announcements");
                n2 = n2 | 5 | 0x10 | 0x20;
                if (bl || !AnnouncementHandler.isDABAnnouncement(this.activeAnnouncement)) break;
                this.abortAnnouncement();
                break;
            }
        }
        this.setFilter(n2);
    }

    private static boolean isDABAnnouncement(int n) {
        switch (n) {
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
                return true;
            }
        }
        return false;
    }

    private void setTpIcon(boolean bl) {
        ChoiceModelApp choiceModelApp = this.models.getChoiceModel(-1635254016);
        choiceModelApp.setPressed(bl);
        choiceModelApp.setValue(bl ? 1 : 0);
    }

    @Override
    public void updateAvailability(int n, int n2) {
        this.logger.announce.log(-2137614336, "[AnnouncementHandler.updateAvailability] availability:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            boolean bl = this.taReceiveStatus = (n & 1) == 1 || (n & 4) == 4 || (n & 0x10) == 16 || (n & 0x20) == 32;
            if (Utilities.isTASupported()) {
                boolean bl2 = this.models.getChoiceModel(1535574272).getValue() > 0;
                this.setTpIcon(bl2);
            }
        }
    }

    @Override
    public void updateFilter(int n, int n2) {
        this.logger.announce.log(1078071040, "[AnnouncementHandler.updateFilter] filter:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.activeFilter = n;
            this.activeFilter <<= 8;
            this.activeFilter >>= 8;
            boolean bl = (n & 1) == 1;
            boolean bl2 = (n & 4) == 4;
            boolean bl3 = bl || bl2;
            boolean bl4 = (n & 0x10) == 16;
            boolean bl5 = (n & 0x20) == 32;
            boolean bl6 = bl4 || bl5;
            boolean bl7 = (n & 0x3FC0) == 16320;
            this.logger.announce.log(1078071040, "[AnnouncementHandler.updateFilter] fm:%1 dab:%2 dabAdd:%3", bl3, bl6, bl7);
            boolean bl8 = true;
            int n3 = 0;
            if (!bl3) {
                n3 = 0;
                bl8 = false;
            } else if (bl3 && !bl6) {
                n3 = 1;
            } else if (bl3 && bl6) {
                n3 = 2;
            }
            if (bl7) {
                this.models.getChoiceModel(0x880100).setValue(1);
            } else {
                this.models.getChoiceModel(0x880100).setValue(0);
            }
            if (n3 != this.models.getChoiceModel(1535574272).getValue()) {
                this.taLastMode = this.models.getChoiceModel(1535574272).getValue();
            }
            this.models.getChoiceModel(1535574272).setValue(n3);
            this.models.getChoiceModel(-1534656256).setValue(n3 == 0 ? 0 : 1);
            this.setTpIcon(bl8);
            this.storage.storeTASetup(n3, this.taLastMode, bl7);
            int n4 = 10 + n3;
            this.logger.announce.log(-2137614336, "[AnnouncementHandler.updateFilter] sending %1 to IAnnouncementStateListener", (long)n4);
            for (int i2 = 0; i2 < this.announcementStateListenerList.size(); ++i2) {
                IAnnouncementStateListener iAnnouncementStateListener = (IAnnouncementStateListener)this.announcementStateListenerList.get(i2);
                iAnnouncementStateListener.updateAnnouncementState(n4, 2);
            }
        }
    }

    @Override
    public void updateStationName(String string, int n, long l, int n2) {
        Object object;
        if (this.logger.announce.isDebug()) {
            object = new Buffer(100);
            ((Buffer)object).append("Name: ").append(string).append(" pi: ").append(n);
            ((Buffer)object).append(" f: ").append(l).append(" valid: ").append(n2);
            this.logger.announce.log(-2137614336, "[AnnouncementHandler.updateStationName] %1", (Object)((Buffer)object).toString());
        }
        if (n2 == 1) {
            String string2 = null;
            if (n != -1) {
                AMFMStation aMFMStation = new AMFMStation();
                aMFMStation.frequency = l;
                aMFMStation.pi = n;
                aMFMStation.rds = true;
                string2 = this.psFreezeDB.getFreezedName(aMFMStation);
            }
            if (string2 != null && l < 0) {
                object = string2;
                this.logger.announce.log(-2137614336, "[AnnouncementHandler.updateStationName] found freezedName %1", string2);
            } else {
                Object object2 = object = string != null ? string.trim() : "";
            }
            if (Utilities.isEmpty((String)object) && l != 0L) {
                object = Utilities.kHzToMHz(l);
                this.logger.announce.log(-2137614336, "[AnnouncementHandler.updateStationName] Replaced empty station name with %1", object);
            }
            this.models.getLabelModel(397).setText((String)object);
            this.propagateUpdatedTAStationName((String)object, n, l);
            int n3 = this.getActiveAnnouncement();
            if (n3 != 20 && n3 != 0) {
                this.propagateupdatedAnnouncementStatus(n3);
            }
        }
    }

    @Override
    public void updateStatus(int n, int n2) {
        this.logger.announce.log(-2137614336, "[AnnouncementHandler.updateStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            if (this.pwrevt == 0 || this.pwrevt == 1 || n == 20) {
                this.backupStatus = 20;
                this.updateStatus(n);
            } else {
                this.logger.announce.log(1078071040, "[AnnouncementHandler.updateStatus] status backed up");
                this.backupStatus = n;
            }
        }
    }

    private void updateStatus(int n) {
        this.logger.announce.log(-2137614336, "[AnnouncementHandler.updateStatus] status:%1 ", (long)n);
        boolean bl = false;
        switch (n) {
            case 1: 
            case 3: {
                if (this.getActiveAnnouncement() != 20 && this.getActiveAnnouncement() != 1 && this.getActiveAnnouncement() != 3) {
                    this.audio.returnAnnouncementAudio(33);
                    this.audio.returnAnnouncementAudio(34);
                    this.audio.returnAnnouncementAudio(32);
                    this.audio.returnAnnouncementAudio(35);
                }
                this.setActiveAnnouncement(n);
                if (this.models.getChoiceModel(1535574272).getValue() <= 0 && !AnnouncementHandler$TunerDiagnosisSessionListener.access$600(this.diagnosisListener)) break;
                this.audio.requestAudioChannel(31, 0);
                this.audio.unlockVolume(1, "Unlock Volume caused by FM_TA");
                this.showPopup(1);
                bl = true;
                break;
            }
            case 2: {
                this.setActiveAnnouncement(n);
                this.audio.requestAudioChannel(33, 0);
                this.audio.unlockVolume(1, "Unlock Volume caused by FM_PTY31");
                this.showPopup(n);
                bl = true;
                break;
            }
            case 4: {
                this.setActiveAnnouncement(n);
                this.audio.requestAudioChannel(34, 0);
                this.audio.unlockVolume(5, "Unlock Volume caused by DAB_PTY31");
                this.showPopup(n);
                bl = true;
                break;
            }
            case 5: 
            case 6: {
                this.setActiveAnnouncement(n);
                if (this.models.getChoiceModel(1535574272).getValue() != 2 && !AnnouncementHandler$TunerDiagnosisSessionListener.access$600(this.diagnosisListener)) break;
                this.audio.requestAudioChannel(32, 0);
                this.audio.unlockVolume(5, "Unlock Volume caused by DAB_TA");
                this.showPopup(n);
                bl = true;
                break;
            }
            case 22: {
                n = 1;
                this.setActiveAnnouncement(n);
                if (this.models.getChoiceModel(1535574272).getValue() <= 0 && !AnnouncementHandler$TunerDiagnosisSessionListener.access$600(this.diagnosisListener)) break;
                this.audio.requestAudioChannel(32, 0);
                this.audio.unlockVolume(5, "Unlock Volume caused by DAB_TA");
                this.showPopup(n);
                bl = true;
                break;
            }
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                this.setActiveAnnouncement(n);
                if (this.models.getChoiceModel(0x880100).getValue() != 1 && !AnnouncementHandler$TunerDiagnosisSessionListener.access$600(this.diagnosisListener)) break;
                this.audio.requestAudioChannel(35, 0);
                this.audio.unlockVolume(5, "Unlock Volume caused by DAB_ANN");
                this.showPopup(n);
                bl = true;
                break;
            }
            default: {
                this.logger.announce.log(-2137614336, "[AnnouncementHandler.updateStatus] TA inactive");
                this.showPopup(0);
                if (this.getActiveAnnouncement() != 20) {
                    this.audio.returnAnnouncementAudio(31);
                    this.audio.returnAnnouncementAudio(33);
                    this.audio.returnAnnouncementAudio(34);
                    this.audio.returnAnnouncementAudio(32);
                    this.audio.returnAnnouncementAudio(35);
                }
                this.setActiveAnnouncement(20);
                bl = true;
            }
        }
        if (bl) {
            this.propagateupdatedAnnouncementStatus(n);
        }
    }

    private void setActiveAnnouncement(int n) {
        this.activeAnnouncement = n;
        this.annVolChange.setActiveAnnouncement(n);
    }

    public boolean abortAnnouncement() {
        if (this.getActiveAnnouncement() != 20) {
            this.logger.announce.log(-2137614336, "[AnnouncementHandler.abortAnnouncement] Abort announcements and release AC");
            this.showPopup(0);
            int n = this.audio.getActiveAnnouncementConnection();
            if (n != -1) {
                this.audio.releaseAudioChannel(n, 0);
            }
            this.dsi.abort(21);
            return true;
        }
        return false;
    }

    private void setFilter(int n) {
        int n2 = Utilities.isTASupported() ? n : 0;
        this.logger.announce.log(-2137614336, "[AnnouncementHandler.setFilter] %1", (long)n2);
        this.dsi.setFilter(n2);
    }

    public void setNotification(int[] nArray) {
        this.logger.announce.log(-2137614336, "[AnnouncementHandler.setNotification] %1", (Object)nArray);
        this.dsi.setNotification(nArray, (DSIListener)this);
    }

    public boolean isTPStatus() {
        return this.taReceiveStatus;
    }

    private void setDABAvailable(boolean bl) {
        this.dabAvailable = bl;
        if (bl) {
            this.models.getChoiceModel(1535574272).setStatus(1);
            this.models.getChoiceModel(-1534656256).setStatus(0);
            this.models.getChoiceModel(0x880100).setStatus(1);
        } else {
            this.models.getChoiceModel(1535574272).setStatus(0);
            this.models.getChoiceModel(-1534656256).setStatus(1);
            this.models.getChoiceModel(0x880100).setStatus(0);
        }
    }

    public void resetToDefaultSettings() {
        this.abortAnnouncement();
        this.taLastMode = 0;
        int[] nArray = this.storage.loadTASetup();
        this.storage.storeTASetup(nArray[0], this.taLastMode, nArray[2] == 1);
        this.setFilter(TunerConfiguration.getDefaultAnnouncementFilter());
    }

    public static int getAlarmMask() {
        int n = 0;
        if (Utilities.isFmPty31AlarmOn()) {
            n |= 2;
        }
        if (Utilities.isDabAlarmAnnouncementActivated()) {
            n |= 8;
        }
        return n;
    }

    @Override
    public int getActiveAnnouncement() {
        return this.activeAnnouncement;
    }

    private void taVolumeAdjustmentActivated(int n) {
        this.annVolChange.taVolumeAdjustmentActivated();
    }

    private void taVolumeAdjustmentDeactivated(int n) {
        this.annVolChange.taVolumeAdjustmentDeactivated(n);
    }

    public void resetVolumeAdjustment() {
        this.logger.announce.log(-2137614336, "[AnnouncementHandler.resetTAVolumeAdjustment]");
        this.annVolChange.resetVolumeAdjustment();
    }

    public boolean toggleTaMode() {
        int n = this.models.getChoiceModel(1535574272).getValue();
        if (n == 1 || n == 2) {
            this.switchTrafficAnnouncements(0, false);
            return false;
        }
        if (this.taLastMode == 1 || !this.dabAvailable) {
            this.switchTrafficAnnouncements(1, false);
        } else {
            this.switchTrafficAnnouncements(2, true);
        }
        return true;
    }

    private void showPopup(int n) {
        boolean bl = false;
        if (n == 0) {
            bl = true;
        } else if (this.amAvailable && this.suppressTAPopupChoice.getValue() == 0) {
            bl = true;
        }
        if (bl) {
            this.models.getChoiceModel(419).setValue(n);
            if (n == 0) {
                this.variantExt.hidePartialPopup(26);
            } else {
                this.variantExt.showPartialPopup(26);
            }
            if (Utilities.isEvoHighMMIKombi()) {
                switch (n) {
                    case 0: 
                    case 1: 
                    case 5: {
                        Utilities.getHMIService().removePopup(this.variantExt.getPopupId(6), 0);
                        break;
                    }
                    default: {
                        Utilities.getHMIService().showPopup(this.variantExt.getPopupId(6), 0);
                    }
                }
            }
        }
    }

    static /* synthetic */ ChoiceModelApp access$400(AnnouncementHandler announcementHandler) {
        return announcementHandler.suppressTAPopupChoice;
    }

    static /* synthetic */ TunerStorage access$500(AnnouncementHandler announcementHandler) {
        return announcementHandler.storage;
    }

    static /* synthetic */ void access$700(AnnouncementHandler announcementHandler, int n) {
        announcementHandler.taVolumeAdjustmentActivated(n);
    }

    static /* synthetic */ void access$800(AnnouncementHandler announcementHandler, int n) {
        announcementHandler.taVolumeAdjustmentDeactivated(n);
    }

    static /* synthetic */ ITunerVariantExt access$900(AnnouncementHandler announcementHandler) {
        return announcementHandler.variantExt;
    }

    static /* synthetic */ void access$1000(AnnouncementHandler announcementHandler, int n) {
        announcementHandler.showPopup(n);
    }

    static /* synthetic */ TunerModels access$1100(AnnouncementHandler announcementHandler) {
        return announcementHandler.models;
    }

    static /* synthetic */ int access$1202(AnnouncementHandler announcementHandler, int n) {
        announcementHandler.pwrevt = n;
        return announcementHandler.pwrevt;
    }

    static /* synthetic */ int access$1200(AnnouncementHandler announcementHandler) {
        return announcementHandler.pwrevt;
    }

    static /* synthetic */ int access$1300(AnnouncementHandler announcementHandler) {
        return announcementHandler.activeAnnouncement;
    }

    static /* synthetic */ int access$1400(AnnouncementHandler announcementHandler) {
        return announcementHandler.backupStatus;
    }

    static /* synthetic */ void access$1500(AnnouncementHandler announcementHandler, int n) {
        announcementHandler.updateStatus(n);
    }

    static /* synthetic */ int access$1402(AnnouncementHandler announcementHandler, int n) {
        announcementHandler.backupStatus = n;
        return announcementHandler.backupStatus;
    }
}

