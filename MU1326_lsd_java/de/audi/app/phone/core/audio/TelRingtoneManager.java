/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.audio.TelAudioCmdManager;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.audio.ToneService;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.interapp.media.IMediaFileSessionPlayer;
import de.audi.atip.interapp.media.IMediaSessionPlayer;
import de.audi.atip.interapp.phone.ITelServiceMedia;
import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import java.util.Hashtable;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelRingtoneManager
extends AbstractPhoneComponent
implements ListListener,
ChoiceListener,
ServiceTrackerCustomizer,
ITelServiceMedia {
    private final int[] RELEVANT_ATTRIBUTES = new int[]{65569, 131105, 65539, 65544};
    private static final int ENABLE_SET_CUSTOM_RINGTONE_OPTION = 0;
    private static final int DISABLE_SET_CUSTOM_RINGTONE_OPTION = 1;
    public static final int MEDIA_SESSION_MODE_RINGING = 0;
    public static final int MEDIA_SESSION_MODE_RINGTONE_LIST = 1;
    static final int INDEX_INDIVIDUAL_RINGTONE_DSI = -1;
    static final int RINGTONE_LIST_DEFAULT_LENGTH = 10;
    static final int INDEX_INDIVIDUAL_RINGTONE = 10;
    static final int DEFAULT_RINGTONE = 0;
    static final int RINGTONE_SELECTED = 1;
    static final int RINGTONE_NOT_SELECTED = 0;
    static final int RINGTONE_LIST_MAX_COLUMNS = 2;
    static final int RINGTONE_LIST_COL_CHECKBOX = 1;
    private volatile PhoneServiceProvider telServiceMediaProvider;
    private volatile String ringtonePath;
    protected volatile boolean ringtoneListEntered;
    private int selectedRingtonePrimaryDevice;
    private int selectedRingtoneAssociatedDevice;
    private volatile boolean inbandRingingSupported;
    private volatile ToneService toneService;
    private volatile PhoneServiceTracker toneServiceTracker;
    private volatile int previousRingtoneMode = 0;
    private TelAudioCmdManager cmdManager;
    protected volatile IGlobalTelephoneStateStruct telState;
    private volatile PhoneServiceTracker wavePlayerServiceTracker;
    private volatile RingTonePlayer ringtonePlayer;
    private volatile PhoneServiceTracker mediaServiceTracker;
    private volatile IMediaFilePlayerService mediaService;
    private volatile RingtoneMediaSession currentMediaSession;
    private volatile boolean ringtoneListPlaybackStarted;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ToneService;
    static /* synthetic */ Class class$de$audi$tghu$waveplayer$WavePlayer;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaFilePlayerService;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceMedia;

    public TelRingtoneManager(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Audio");
    }

    void setCommandManager(TelAudioCmdManager telAudioCmdManager) {
        this.cmdManager = telAudioCmdManager;
    }

    public void init() {
        long l = this.getApplication().getFrameworkAccess().getMonotonicTime();
        super.init();
        this.registerTelServiceMedia();
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(this.RELEVANT_ATTRIBUTES, (IGlobalTelephoneStateListener)this);
        this.getChoiceModel(300236).setChoiceListener(this);
        this.getButtonModel(300746).setButtonListener(this);
        this.initRingtoneList();
        this.getApplication().addDiagnosisComponent(new TelAudioDiag());
        this.toneServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$audio$ToneService == null ? (class$de$audi$atip$interapp$audio$ToneService = TelRingtoneManager.class$("de.audi.atip.interapp.audio.ToneService")) : class$de$audi$atip$interapp$audio$ToneService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.toneServiceTracker.openTracker();
        this.wavePlayerServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = TelRingtoneManager.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.wavePlayerServiceTracker.openTracker();
        this.mediaServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$media$IMediaFilePlayerService == null ? (class$de$audi$atip$interapp$media$IMediaFilePlayerService = TelRingtoneManager.class$("de.audi.atip.interapp.media.IMediaFilePlayerService")) : class$de$audi$atip$interapp$media$IMediaFilePlayerService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.mediaServiceTracker.openTracker();
        this.getApplication().getStartupLogChannel().log(1000000, "[TelRingtoneManager#init] done in %1 ms", this.getApplication().getFrameworkAccess().getMonotonicTime() - l);
    }

    protected void registerTelServiceMedia() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.telServiceMediaProvider = new PhoneServiceProvider((class$de$audi$atip$interapp$phone$ITelServiceMedia == null ? (class$de$audi$atip$interapp$phone$ITelServiceMedia = TelRingtoneManager.class$("de.audi.atip.interapp.phone.ITelServiceMedia")) : class$de$audi$atip$interapp$phone$ITelServiceMedia).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.telServiceMediaProvider.startService();
    }

    void initRingtoneList() {
        this.log.log(10000000, "[TelRingtoneManager#initRingtoneList] called");
        ListModelApp listModelApp = this.getListModel(300237);
        listModelApp.setListListener(this);
        listModelApp.clear();
        listModelApp.setMaxColumns(2);
        IntegerListCell integerListCell = IntegerListCell.create(0);
        for (int i2 = 0; i2 < 10; ++i2) {
            listModelApp.addRow(new ListCell[]{IntegerListCell.create(i2), integerListCell});
        }
        this.selectedRingtonePrimaryDevice = 0;
        this.setSelectedRingtone(listModelApp);
    }

    public void deinit() {
        super.deinit();
        this.unregisterTelServiceMedia();
        this.getApplication().getGlobalTelephoneStateManager().removeListenerForSpecificAttributeUpdate(this.RELEVANT_ATTRIBUTES, (IGlobalTelephoneStateListener)this);
        this.getChoiceModel(300236).resetListener();
        this.getButtonModel(300746).resetListener();
        this.getListModel(300237).clear();
        this.getListModel(300237).resetListener();
        if (this.toneServiceTracker != null) {
            this.toneServiceTracker.closeTracker();
            this.toneServiceTracker = null;
        }
        if (this.wavePlayerServiceTracker != null) {
            this.wavePlayerServiceTracker.closeTracker();
            this.wavePlayerServiceTracker = null;
        }
        if (this.mediaServiceTracker != null) {
            this.mediaServiceTracker.closeTracker();
            this.mediaServiceTracker = null;
        }
    }

    private void unregisterTelServiceMedia() {
        PhoneServiceProvider phoneServiceProvider = this.telServiceMediaProvider;
        if (phoneServiceProvider != null) {
            phoneServiceProvider.stopService();
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "TelRingtoneManager#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "TelRingtoneManager#addingService service is null");
            return null;
        }
        if (object instanceof ToneService) {
            this.setToneService((ToneService)object);
            return object;
        }
        if (object instanceof WavePlayer) {
            WavePlayer wavePlayer = (WavePlayer)object;
            if (wavePlayer != null) {
                this.setRingtonePlayerService(wavePlayer.getRingTonePlayer());
            }
            return object;
        }
        if (object instanceof IMediaFilePlayerService) {
            this.setMediaService((IMediaFilePlayerService)object);
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    void setRingtonePlayerService(RingTonePlayer ringTonePlayer) {
        this.ringtonePlayer = ringTonePlayer;
    }

    void setMediaService(IMediaFilePlayerService iMediaFilePlayerService) {
        this.mediaService = iMediaFilePlayerService;
    }

    void setToneService(ToneService toneService) {
        this.toneService = toneService;
        this.updateToneServiceRingingMode();
        this.updateToneServiceUserDefinedRingtone();
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (serviceReference == null) {
            this.log.log(10000, "TelRingtoneManager#removedService reference is null");
            return;
        }
        if (object == null) {
            this.log.log(10000, "TelRingtoneManager#removedService service is null");
            return;
        }
        if (object instanceof ToneService) {
            this.log.log(1000000, "[TelRingtoneManager#removedService] ToneService=%1", object);
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.toneService = null;
        } else if (object instanceof WavePlayer) {
            this.log.log(1000000, "[TelRingtoneManager#removedService] WavePlayer=%1", object);
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.ringtonePlayer = null;
        } else if (object instanceof IMediaFilePlayerService) {
            this.log.log(1000000, "[TelRingtoneManager#removedService] IMediaFilePlayerService=%1", object);
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.mediaService = null;
        }
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        boolean bl;
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "TelRingtoneManager#updateGlobalTelephoneStateProperty stateStruct is null");
            return;
        }
        this.telState = iGlobalTelephoneStateStruct;
        if (n == 65569) {
            this.updateSelectedRingtone(iGlobalTelephoneStateStruct.getRingtoneIndex(), iGlobalTelephoneStateStruct.getRingtonePath());
            this.updateToneServiceUserDefinedRingtone();
        }
        if (n == 131105) {
            this.setSelectedRingtoneAssociated();
        } else if (n == 65539 && (bl = iGlobalTelephoneStateStruct.inbandRingingSupported()) != this.inbandRingingSupported) {
            this.inbandRingingSupported = bl;
            this.updateToneServiceRingingMode();
        }
    }

    private void setSelectedRingtoneAssociated() {
        if (this.telState.getAssociatedDeviceState() != null) {
            this.selectedRingtoneAssociatedDevice = this.telState.getAssociatedDeviceState().getRingtoneIndex();
        }
    }

    private void updateToneServiceUserDefinedRingtone() {
        ToneService toneService = this.toneService;
        if (toneService != null) {
            IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telState;
            if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getRingtonePath() != null) {
                this.log.log(1000000, "[TelRingtoneManager#updateToneServiceUserDefinedRingtone] url=%1", (Object)iGlobalTelephoneStateStruct.getRingtonePath());
                toneService.updateUserDefinedRingtone(iGlobalTelephoneStateStruct.getRingtonePath(), "");
            }
        } else {
            this.log.log(10000, "TelRingtoneManager#updateToneServiceUserDefinedRingtone toneService is null");
        }
    }

    private void updateToneServiceRingingMode() {
        int n = this.inbandRingingSupported ? 1 : (this.selectedRingtonePrimaryDevice == 10 ? 3 : 2);
        this.log.log(1000000, "[TelRingtoneManager#updateToneServiceRingingMode] new ringtone scenario %1 old ringtone mode %2 selectedRingtone %3 ", (long)n, (long)this.previousRingtoneMode, (long)this.selectedRingtonePrimaryDevice);
        if (this.previousRingtoneMode != n) {
            ToneService toneService = this.toneService;
            if (toneService != null) {
                this.log.log(1000000, "[TelRingtoneManager#setRingtoneMode] updating ToneService with new ringtone scenario %1", (long)n);
                toneService.updatePhoneAudioScenario(n);
                this.previousRingtoneMode = n;
            } else {
                this.log.log(10000, "TelRingtoneManager#updateToneServiceRingingMode toneService is null");
            }
        }
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[TelRingtoneManager#itemSelected] %1", (Object)TelLoggingUtils.itemSelectedList(n, n2, n3, n4));
        }
        if (n == 300237 && n2 >= 0) {
            this.getApplication().getTelephoneDSIAccess().requestSetPhoneRingtone(n2 == 10 ? -1 : n2, this.getRingtonePath(), n4);
        }
    }

    public void updateSelectedRingtone(int n, String string) {
        this.log.log(1000000, "[TelRingtoneManager#updateSelectedRingtone] ringtoneIndex=%2, ringtonePath=%1", (Object)string, (long)n);
        ListModelApp listModelApp = this.getListModel(300237);
        int n2 = this.selectedRingtonePrimaryDevice;
        this.selectedRingtonePrimaryDevice = n == -1 ? 10 : n;
        this.setRingtonePath(string);
        if (string != null && string.equals("") && listModelApp.getLength() > 10) {
            listModelApp.removeRow(10);
            this.setCustomRingtoneOptionVisibility(true);
        } else if (this.selectedRingtonePrimaryDevice == 10 && listModelApp.getLength() == 10) {
            listModelApp.addRow(new ListCell[]{IntegerListCell.create(10), IntegerListCell.create(0)});
            this.setCustomRingtoneOptionVisibility(false);
        }
        this.refreshRingtonesListSelection(listModelApp);
        this.updateToneServiceRingingMode();
        if (this.ringtoneListEntered) {
            this.playSelectedRingtone(n2, this.selectedRingtonePrimaryDevice);
        }
    }

    private void refreshRingtonesListSelection(ListModelApp listModelApp) {
        if (listModelApp == null) {
            this.log.log(10000, "TelRingtoneManager#refreshRingtonesListSelection ringtoneList is null");
            return;
        }
        for (int i2 = 0; i2 < listModelApp.getLength(); ++i2) {
            listModelApp.setCell(i2, 1, IntegerListCell.create(0));
        }
        this.setSelectedRingtone(listModelApp);
    }

    private void setSelectedRingtone(ListModelApp listModelApp) {
        if (listModelApp == null) {
            this.log.log(10000, "TelRingtoneManager#setSelectedRingtone ringtoneList is null");
            return;
        }
        listModelApp.setCell(this.selectedRingtonePrimaryDevice, 1, IntegerListCell.create(1));
        listModelApp.setSelected(this.selectedRingtonePrimaryDevice);
        this.getChoiceModel(300236).setValue(this.selectedRingtonePrimaryDevice);
        this.getChoiceModel(338).setValue(this.selectedRingtonePrimaryDevice);
    }

    private void playSelectedRingtone(int n, int n2) {
        if (n == n2) {
            this.log.log(10000000, "[TelRingtoneManager#playSelectedRingtone] selected ringtone has not changed --> NOP!");
            return;
        }
        if (n == 10) {
            this.abortRingtoneListMediaPlayback();
            this.startRingtoneListOutbandPlayback();
        } else if (n2 == 10) {
            this.abortRingtoneListOutbandPlayback();
            this.startRingtoneListMediaPlayback();
        } else {
            this.startRingtoneListOutbandPlayback();
        }
    }

    public void startRingtoneListPlayback() {
        if (this.isRingtoneListPlaybackStarted()) {
            this.log.log(100000, "[TelRingtoneManager#abortRingtoneListPlayback] Ringtone was already started, do nothing.");
            return;
        }
        if (this.selectedRingtonePrimaryDevice == 10) {
            this.startRingtoneListMediaPlayback();
        } else {
            this.startRingtoneListOutbandPlayback();
        }
        this.setRingtoneListPlaybackStarted(true);
    }

    public void checkAbortRingtoneListPlayback() {
        if (this.ringtoneListEntered) {
            this.abortRingtoneListPlayback();
        }
    }

    public void abortRingtoneListPlayback() {
        if (!this.isRingtoneListPlaybackStarted()) {
            this.log.log(100000, "[TelRingtoneManager#abortRingtoneListPlayback] Ringtone was already aborted, do nothing.");
            return;
        }
        if (this.selectedRingtonePrimaryDevice == 10) {
            this.abortRingtoneListMediaPlayback();
        } else {
            this.abortRingtoneListOutbandPlayback();
        }
        this.setRingtoneListPlaybackStarted(false);
    }

    public void notifyMediaPlaybackError() {
        this.log.log(100000, "[TelRingtoneManager#notifyMediaPlaybackError] playback of media file not possible! Reverting to default waveplayer tone.");
        this.getApplication().getTelephoneDSIAccess().requestSetPhoneRingtone(0, "", 0);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "[TelRingtoneManager#keyTyped] modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
        if (n == 300236) {
            ListModelApp listModelApp = this.getListModel(300237);
            listModelApp.setSelected(this.selectedRingtonePrimaryDevice);
            this.getButtonModel(n).fireEvent(n3);
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void updateAMAvailable(boolean bl) {
        this.log.log(10000000, "[TelRingtoneManager#updateAMAvailable] available=%1", bl);
    }

    public void ringtoneListEntered(boolean bl) {
        boolean bl2;
        this.ringtoneListEntered = bl;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telState;
        boolean bl3 = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallState() != null ? iGlobalTelephoneStateStruct.getCallState().getMpCallState() == 15 : (bl2 = false);
        if (bl) {
            this.startRingtoneListPlayback();
        } else if (bl2) {
            this.log.log(1000000, "[TelRingtoneManager#ringtoneListEntered] entered=%1, ringing=%2 --> Not aborting ringtone", bl, bl2);
        } else {
            this.abortRingtoneListPlayback();
        }
    }

    public boolean isIndividualRingtoneSelected() {
        return this.selectedRingtonePrimaryDevice == 10;
    }

    void setIndividualRingtone(String string) {
        this.log.log(10000000, "[TelRingtoneManager#setIndividualRingtone] url=%1", (Object)string);
        this.getApplication().getTelephoneDSIAccess().requestSetPhoneRingtone(-1, string, 0);
    }

    int getSelectedRingtone() {
        return this.selectedRingtonePrimaryDevice;
    }

    public void setUserDefinedRingtone(String string, String string2) {
        this.log.log(1000000, "[TelRingtoneManager#setUserDefinedRingtone] url=%1, title=%2", (Object)string, (Object)string2);
        this.setIndividualRingtone(string);
    }

    public void resetUserDefinedRingtone() {
        if (this.isIndividualRingtoneSelected()) {
            this.log.log(1000000, "[TelRingtoneManager#resetUserDefinedRingtone] Jukebox was emptied => reseting custom ringtone, selectedRingtone=%1", (long)this.getSelectedRingtone());
            this.getApplication().getTelephoneDSIAccess().requestSetPhoneRingtone(0, "", 0);
        }
    }

    private void setCustomRingtoneOptionVisibility(boolean bl) {
        if (bl) {
            this.getChoiceModel(301048).setValue(0);
            this.log.log(10000000, "[TelRingtoneManager#setCustomRingtoneOptionVisibility] enabling <Set custom ringtone> option. Setting model=%1 to value=%2", 301048L, 0L);
        } else {
            this.getChoiceModel(301048).setValue(1);
            this.log.log(10000000, "[TelRingtoneManager#setCustomRingtoneOptionVisibility] disabling <Set custom ringtone> option. Setting model=%1 to value=%2", 301048L, 1L);
        }
    }

    String getRingtonePath() {
        return this.ringtonePath;
    }

    void setRingtonePath(String string) {
        this.ringtonePath = string;
    }

    public void startOutbandRinging(int n) {
        switch (n) {
            case 65536: {
                this.log.log(1000000, "[TelRingtoneManager#startOutbandRinging] incoming call --> start outband ringing at primary device.");
                this.cmdManager.scheduleOutbandRinging(this.ringtonePlayer, this.selectedRingtonePrimaryDevice);
                break;
            }
            case 131072: {
                this.log.log(1000000, "[TelRingtoneManager#startOutbandRinging] incoming call --> start outband ringing at associated device.");
                this.cmdManager.scheduleOutbandRinging(this.ringtonePlayer, this.selectedRingtoneAssociatedDevice);
                break;
            }
            default: {
                this.log.log(1000000, "[TelRingtoneManager#startOutbandRinging] (default) incoming call --> start outband ringing at primary device.");
                this.cmdManager.scheduleOutbandRinging(this.ringtonePlayer, this.selectedRingtonePrimaryDevice);
            }
        }
    }

    public void abortOutbandRinging() {
        this.log.log(1000000, "[TelRingtoneManager#abortOutbandRinging] incoming call no longer present --> aborting outband ringing.");
        this.cmdManager.scheduleAbortOutbandRinging(this.ringtonePlayer);
    }

    public void startMediaRinging() {
        this.log.log(1000000, "[TelRingtoneManager#startMediaRinging] incoming call --> start media ringing.");
        if (this.mediaService != null) {
            RingtoneMediaSession ringtoneMediaSession;
            if (this.currentMediaSession != null && this.currentMediaSession.isSessionStarted() && this.currentMediaSession.getAudioConnection() == 95) {
                ringtoneMediaSession = this.currentMediaSession;
            } else if (this.currentMediaSession != null && this.currentMediaSession.isSessionStarted() && this.currentMediaSession.getAudioConnection() == 91) {
                this.abortRingtoneListMediaPlayback();
                ringtoneMediaSession = new RingtoneMediaSession(95, 0, this.getRingtonePath());
            } else {
                ringtoneMediaSession = new RingtoneMediaSession(95, 0, this.getRingtonePath());
            }
            this.currentMediaSession = ringtoneMediaSession;
            this.cmdManager.scheduleMediaRinging(this.mediaService, this.currentMediaSession);
        } else {
            this.log.log(100000, "[TelRingtoneManager#startMediaRinging] media service is null --> default ringtone");
            this.cmdManager.scheduleRingingDefaultRingtoneFallback(this.ringtonePlayer);
        }
    }

    public void abortMediaRinging() {
        this.log.log(1000000, "[TelRingtoneManager#abortMediaRinging] incoming call no longer present --> aborting media ringing.");
        this.currentMediaSession.setSessionStarted(false);
        this.cmdManager.scheduleAbortMediaRinging(this.mediaService, this.currentMediaSession, this.ringtonePlayer);
    }

    public void startRingtoneListOutbandPlayback() {
        this.log.log(1000000, "[TelRingtoneManager#startRingtoneListOutbandPlayback] ringtone=%1", (long)this.getSelectedRingtone());
        this.cmdManager.scheduleOutbandRingtoneList(this.ringtonePlayer, this.getSelectedRingtone());
    }

    public void startRingtoneListMediaPlayback() {
        this.log.log(1000000, "[TelRingtoneManager#startRingtoneListMediaPlayback] url=%1", (Object)this.getRingtonePath());
        IMediaFilePlayerService iMediaFilePlayerService = this.mediaService;
        if (iMediaFilePlayerService != null) {
            this.currentMediaSession = new RingtoneMediaSession(91, 1, this.getRingtonePath());
            this.cmdManager.scheduleRingtoneListMediaPlayback(iMediaFilePlayerService, this.currentMediaSession);
        } else {
            this.log.log(100000, "[TelRingtoneManager#startRingtoneListMediaPlayback] media service is null --> default ringtone");
            this.cmdManager.scheduleRingtoneListDefaultRingtoneFallback(this.ringtonePlayer);
        }
    }

    public void abortRingtoneListOutbandPlayback() {
        this.log.log(1000000, "[TelRingtoneManager#abortRingtoneListWavePlayerPlayback]");
        this.cmdManager.scheduleAbortRingtoneListWavePlayerPlayback(this.ringtonePlayer);
    }

    public void abortRingtoneListMediaPlayback() {
        this.log.log(1000000, "[TelRingtoneManager#abortRingtoneListMediaPlayback]");
        this.currentMediaSession.setSessionStarted(false);
        this.cmdManager.scheduleAbortRingtoneListMediaPlayback(this.mediaService, this.currentMediaSession, this.ringtonePlayer);
    }

    IMediaFilePlayerSession getCurrentMediaSession() {
        return this.currentMediaSession;
    }

    ListModelApp getRingtoneList() {
        return this.getListModel(300237);
    }

    protected boolean isRingtoneListPlaybackStarted() {
        return this.ringtoneListPlaybackStarted;
    }

    protected void setRingtoneListPlaybackStarted(boolean bl) {
        this.ringtoneListPlaybackStarted = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class TelAudioDiag
    implements IPhoneDiagComponent {
        private TelAudioDiag() {
        }

        public void cmdSetUserDefinedRingtone(String string, String string2) {
            TelRingtoneManager.this.setUserDefinedRingtone(string, string2);
        }
    }

    private class RingtoneMediaSession
    implements IMediaFilePlayerSession {
        private final int audioConnection;
        private final int mode;
        private final String url;
        private volatile IMediaFileSessionPlayer filePlayerSession;
        private boolean sessionStarted;

        public RingtoneMediaSession(int n, int n2, String string) {
            this.audioConnection = n;
            this.mode = n2;
            this.url = string;
            this.setSessionStarted(true);
        }

        public int getAudioConnection() {
            return this.audioConnection;
        }

        public int getType() {
            return 1;
        }

        public String getName() {
            return "RingtoneMediaSession";
        }

        public void onActive(IMediaSessionPlayer iMediaSessionPlayer) {
            TelRingtoneManager.this.log.log(1000000, "[TelRingtoneManager.RingtoneMediaSession#onActive] playing %1", (Object)this.url);
            this.filePlayerSession = (IMediaFileSessionPlayer)iMediaSessionPlayer;
            this.filePlayerSession.play(this.url, true);
        }

        public void onSuspend() {
            TelRingtoneManager.this.log.log(1000000, "[TelRingtoneManager.RingtoneMediaSession#onSuspend]");
        }

        public void onClose() {
            TelRingtoneManager.this.log.log(1000000, "[TelRingtoneManager.RingtoneMediaSession#onClose]");
        }

        public void updateState(int n) {
            TelRingtoneManager.this.log.log(1000000, "[TelRingtoneManager.RingtoneMediaSession#updateState] state=%1", (long)n);
            if (n == 6) {
                TelRingtoneManager.this.log.log(100000, "[TelRingtoneManager.RingtoneMediaSession#updateState] STATE_STOPPED_WITH_ERROR");
                if (this.mode == 0) {
                    TelRingtoneManager.this.cmdManager.scheduleRingingDefaultRingtoneFallback(TelRingtoneManager.this.ringtonePlayer, TelRingtoneManager.this.mediaService, TelRingtoneManager.this.currentMediaSession);
                } else if (this.mode == 1) {
                    TelRingtoneManager.this.cmdManager.scheduleRingtoneListDefaultRingtoneFallback(TelRingtoneManager.this.ringtonePlayer, TelRingtoneManager.this.mediaService, TelRingtoneManager.this.currentMediaSession);
                } else {
                    TelRingtoneManager.this.log.log(100000, "[TelRingtoneManager.RingtoneMediaSession#updateState] unknown mode %1", (long)this.mode);
                }
                TelRingtoneManager.this.notifyMediaPlaybackError();
            }
        }

        public void updatePlayPosition(int n, int n2) {
        }

        public void updateVideoContext(int n) {
        }

        public boolean isSessionStarted() {
            return this.sessionStarted;
        }

        public void setSessionStarted(boolean bl) {
            this.sessionStarted = bl;
        }
    }
}

