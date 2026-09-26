/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.audio.TelAudioCmdManager;
import de.audi.app.phone.core.audio.TelRingtoneManager$RingtoneMediaSession;
import de.audi.app.phone.core.audio.TelRingtoneManager$TelAudioDiag;
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
import de.audi.atip.interapp.phone.ITelServiceMedia;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;
import java.util.Hashtable;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelRingtoneManager
extends AbstractPhoneComponent
implements ListListener,
ChoiceListener,
ServiceTrackerCustomizer,
ITelServiceMedia {
    private final int[] RELEVANT_ATTRIBUTES = new int[]{0x21000100, 0x21000200, 0x3000100, 0x8000100};
    private static final int ENABLE_SET_CUSTOM_RINGTONE_OPTION;
    private static final int DISABLE_SET_CUSTOM_RINGTONE_OPTION;
    public static final int MEDIA_SESSION_MODE_RINGING;
    public static final int MEDIA_SESSION_MODE_RINGTONE_LIST;
    static final int INDEX_INDIVIDUAL_RINGTONE_DSI;
    static final int RINGTONE_LIST_DEFAULT_LENGTH;
    static final int INDEX_INDIVIDUAL_RINGTONE;
    static final int DEFAULT_RINGTONE;
    static final int RINGTONE_SELECTED;
    static final int RINGTONE_NOT_SELECTED;
    static final int RINGTONE_LIST_MAX_COLUMNS;
    static final int RINGTONE_LIST_COL_CHECKBOX;
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
    private volatile TelRingtoneManager$RingtoneMediaSession currentMediaSession;
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

    @Override
    public void init() {
        long l = this.getApplication().getFrameworkAccess().getMonotonicTime();
        super.init();
        this.registerTelServiceMedia();
        this.getApplication().getGlobalTelephoneStateManager().registerListenerForSpecificAttributeUpdate(this.RELEVANT_ATTRIBUTES, (IGlobalTelephoneStateListener)this);
        this.getChoiceModel(-862714880).setChoiceListener(this);
        this.getButtonModel(-896138240).setButtonListener(this);
        this.initRingtoneList();
        this.getApplication().addDiagnosisComponent(new TelRingtoneManager$TelAudioDiag(this, null));
        this.toneServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$audio$ToneService == null ? (class$de$audi$atip$interapp$audio$ToneService = TelRingtoneManager.class$("de.audi.atip.interapp.audio.ToneService")) : class$de$audi$atip$interapp$audio$ToneService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.toneServiceTracker.openTracker();
        this.wavePlayerServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = TelRingtoneManager.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.wavePlayerServiceTracker.openTracker();
        this.mediaServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$media$IMediaFilePlayerService == null ? (class$de$audi$atip$interapp$media$IMediaFilePlayerService = TelRingtoneManager.class$("de.audi.atip.interapp.media.IMediaFilePlayerService")) : class$de$audi$atip$interapp$media$IMediaFilePlayerService).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.mediaServiceTracker.openTracker();
        this.getApplication().getStartupLogChannel().log(1078071040, "[TelRingtoneManager#init] done in %1 ms", this.getApplication().getFrameworkAccess().getMonotonicTime() - l);
    }

    protected void registerTelServiceMedia() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.telServiceMediaProvider = new PhoneServiceProvider((class$de$audi$atip$interapp$phone$ITelServiceMedia == null ? (class$de$audi$atip$interapp$phone$ITelServiceMedia = TelRingtoneManager.class$("de.audi.atip.interapp.phone.ITelServiceMedia")) : class$de$audi$atip$interapp$phone$ITelServiceMedia).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.telServiceMediaProvider.startService();
    }

    void initRingtoneList() {
        this.log.log(-2137614336, "[TelRingtoneManager#initRingtoneList] called");
        ListModelApp listModelApp = this.getListModel(-845937664);
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

    @Override
    public void deinit() {
        super.deinit();
        this.unregisterTelServiceMedia();
        this.getApplication().getGlobalTelephoneStateManager().removeListenerForSpecificAttributeUpdate(this.RELEVANT_ATTRIBUTES, (IGlobalTelephoneStateListener)this);
        this.getChoiceModel(-862714880).resetListener();
        this.getButtonModel(-896138240).resetListener();
        this.getListModel(-845937664).clear();
        this.getListModel(-845937664).resetListener();
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

    @Override
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

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
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
            this.log.log(1078071040, "[TelRingtoneManager#removedService] ToneService=%1", object);
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.toneService = null;
        } else if (object instanceof WavePlayer) {
            this.log.log(1078071040, "[TelRingtoneManager#removedService] WavePlayer=%1", object);
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.ringtonePlayer = null;
        } else if (object instanceof IMediaFilePlayerService) {
            this.log.log(1078071040, "[TelRingtoneManager#removedService] IMediaFilePlayerService=%1", object);
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.mediaService = null;
        }
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        boolean bl;
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "TelRingtoneManager#updateGlobalTelephoneStateProperty stateStruct is null");
            return;
        }
        this.telState = iGlobalTelephoneStateStruct;
        if (n == 0x21000100) {
            this.updateSelectedRingtone(iGlobalTelephoneStateStruct.getRingtoneIndex(), iGlobalTelephoneStateStruct.getRingtonePath());
            this.updateToneServiceUserDefinedRingtone();
        }
        if (n == 0x21000200) {
            this.setSelectedRingtoneAssociated();
        } else if (n == 0x3000100 && (bl = iGlobalTelephoneStateStruct.inbandRingingSupported()) != this.inbandRingingSupported) {
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
                this.log.log(1078071040, "[TelRingtoneManager#updateToneServiceUserDefinedRingtone] url=%1", (Object)iGlobalTelephoneStateStruct.getRingtonePath());
                toneService.updateUserDefinedRingtone(iGlobalTelephoneStateStruct.getRingtonePath(), "");
            }
        } else {
            this.log.log(10000, "TelRingtoneManager#updateToneServiceUserDefinedRingtone toneService is null");
        }
    }

    private void updateToneServiceRingingMode() {
        int n = this.inbandRingingSupported ? 1 : (this.selectedRingtonePrimaryDevice == 10 ? 3 : 2);
        this.log.log(1078071040, "[TelRingtoneManager#updateToneServiceRingingMode] new ringtone scenario %1 old ringtone mode %2 selectedRingtone %3 ", (long)n, (long)this.previousRingtoneMode, (long)this.selectedRingtonePrimaryDevice);
        if (this.previousRingtoneMode != n) {
            ToneService toneService = this.toneService;
            if (toneService != null) {
                this.log.log(1078071040, "[TelRingtoneManager#setRingtoneMode] updating ToneService with new ringtone scenario %1", (long)n);
                toneService.updatePhoneAudioScenario(n);
                this.previousRingtoneMode = n;
            } else {
                this.log.log(10000, "TelRingtoneManager#updateToneServiceRingingMode toneService is null");
            }
        }
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelRingtoneManager#itemSelected] %1", (Object)TelLoggingUtils.itemSelectedList(n, n2, n3, n4));
        }
        if (n == -845937664 && n2 >= 0) {
            this.getApplication().getTelephoneDSIAccess().requestSetPhoneRingtone(n2 == 10 ? -1 : n2, this.getRingtonePath(), n4);
        }
    }

    public void updateSelectedRingtone(int n, String string) {
        this.log.log(1078071040, "[TelRingtoneManager#updateSelectedRingtone] ringtoneIndex=%2, ringtonePath=%1", (Object)string, (long)n);
        ListModelApp listModelApp = this.getListModel(-845937664);
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
        this.getChoiceModel(-862714880).setValue(this.selectedRingtonePrimaryDevice);
        this.getChoiceModel(338).setValue(this.selectedRingtonePrimaryDevice);
    }

    private void playSelectedRingtone(int n, int n2) {
        if (n == n2) {
            this.log.log(-2137614336, "[TelRingtoneManager#playSelectedRingtone] selected ringtone has not changed --> NOP!");
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
            this.log.log(-1601830656, "[TelRingtoneManager#abortRingtoneListPlayback] Ringtone was already started, do nothing.");
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
            this.log.log(-1601830656, "[TelRingtoneManager#abortRingtoneListPlayback] Ringtone was already aborted, do nothing.");
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
        this.log.log(-1601830656, "[TelRingtoneManager#notifyMediaPlaybackError] playback of media file not possible! Reverting to default waveplayer tone.");
        this.getApplication().getTelephoneDSIAccess().requestSetPhoneRingtone(0, "", 0);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelRingtoneManager#keyTyped] modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
        if (n == -862714880) {
            ListModelApp listModelApp = this.getListModel(-845937664);
            listModelApp.setSelected(this.selectedRingtonePrimaryDevice);
            this.getButtonModel(n).fireEvent(n3);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void updateAMAvailable(boolean bl) {
        this.log.log(-2137614336, "[TelRingtoneManager#updateAMAvailable] available=%1", bl);
    }

    public void ringtoneListEntered(boolean bl) {
        boolean bl2;
        this.ringtoneListEntered = bl;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telState;
        boolean bl3 = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallState() != null ? iGlobalTelephoneStateStruct.getCallState().getMpCallState() == 15 : (bl2 = false);
        if (bl) {
            this.startRingtoneListPlayback();
        } else if (bl2) {
            this.log.log(1078071040, "[TelRingtoneManager#ringtoneListEntered] entered=%1, ringing=%2 --> Not aborting ringtone", bl, bl2);
        } else {
            this.abortRingtoneListPlayback();
        }
    }

    public boolean isIndividualRingtoneSelected() {
        return this.selectedRingtonePrimaryDevice == 10;
    }

    void setIndividualRingtone(String string) {
        this.log.log(-2137614336, "[TelRingtoneManager#setIndividualRingtone] url=%1", (Object)string);
        this.getApplication().getTelephoneDSIAccess().requestSetPhoneRingtone(-1, string, 0);
    }

    int getSelectedRingtone() {
        return this.selectedRingtonePrimaryDevice;
    }

    @Override
    public void setUserDefinedRingtone(String string, String string2) {
        this.log.log(1078071040, "[TelRingtoneManager#setUserDefinedRingtone] url=%1, title=%2", (Object)string, (Object)string2);
        this.setIndividualRingtone(string);
    }

    @Override
    public void resetUserDefinedRingtone() {
        if (this.isIndividualRingtoneSelected()) {
            this.log.log(1078071040, "[TelRingtoneManager#resetUserDefinedRingtone] Jukebox was emptied => reseting custom ringtone, selectedRingtone=%1", (long)this.getSelectedRingtone());
            this.getApplication().getTelephoneDSIAccess().requestSetPhoneRingtone(0, "", 0);
        }
    }

    private void setCustomRingtoneOptionVisibility(boolean bl) {
        if (bl) {
            this.getChoiceModel(-124320768).setValue(0);
            this.log.log(-2137614336, "[TelRingtoneManager#setCustomRingtoneOptionVisibility] enabling <Set custom ringtone> option. Setting model=%1 to value=%2", (long)0, 0L);
        } else {
            this.getChoiceModel(-124320768).setValue(1);
            this.log.log(-2137614336, "[TelRingtoneManager#setCustomRingtoneOptionVisibility] disabling <Set custom ringtone> option. Setting model=%1 to value=%2", (long)0, 1L);
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
                this.log.log(1078071040, "[TelRingtoneManager#startOutbandRinging] incoming call --> start outband ringing at primary device.");
                this.cmdManager.scheduleOutbandRinging(this.ringtonePlayer, this.selectedRingtonePrimaryDevice);
                break;
            }
            case 131072: {
                this.log.log(1078071040, "[TelRingtoneManager#startOutbandRinging] incoming call --> start outband ringing at associated device.");
                this.cmdManager.scheduleOutbandRinging(this.ringtonePlayer, this.selectedRingtoneAssociatedDevice);
                break;
            }
            default: {
                this.log.log(1078071040, "[TelRingtoneManager#startOutbandRinging] (default) incoming call --> start outband ringing at primary device.");
                this.cmdManager.scheduleOutbandRinging(this.ringtonePlayer, this.selectedRingtonePrimaryDevice);
            }
        }
    }

    public void abortOutbandRinging() {
        this.log.log(1078071040, "[TelRingtoneManager#abortOutbandRinging] incoming call no longer present --> aborting outband ringing.");
        this.cmdManager.scheduleAbortOutbandRinging(this.ringtonePlayer);
    }

    public void startMediaRinging() {
        this.log.log(1078071040, "[TelRingtoneManager#startMediaRinging] incoming call --> start media ringing.");
        if (this.mediaService != null) {
            TelRingtoneManager$RingtoneMediaSession telRingtoneManager$RingtoneMediaSession;
            if (this.currentMediaSession != null && this.currentMediaSession.isSessionStarted() && this.currentMediaSession.getAudioConnection() == 95) {
                telRingtoneManager$RingtoneMediaSession = this.currentMediaSession;
            } else if (this.currentMediaSession != null && this.currentMediaSession.isSessionStarted() && this.currentMediaSession.getAudioConnection() == 91) {
                this.abortRingtoneListMediaPlayback();
                telRingtoneManager$RingtoneMediaSession = new TelRingtoneManager$RingtoneMediaSession(this, 95, 0, this.getRingtonePath());
            } else {
                telRingtoneManager$RingtoneMediaSession = new TelRingtoneManager$RingtoneMediaSession(this, 95, 0, this.getRingtonePath());
            }
            this.currentMediaSession = telRingtoneManager$RingtoneMediaSession;
            this.cmdManager.scheduleMediaRinging(this.mediaService, this.currentMediaSession);
        } else {
            this.log.log(-1601830656, "[TelRingtoneManager#startMediaRinging] media service is null --> default ringtone");
            this.cmdManager.scheduleRingingDefaultRingtoneFallback(this.ringtonePlayer);
        }
    }

    public void abortMediaRinging() {
        this.log.log(1078071040, "[TelRingtoneManager#abortMediaRinging] incoming call no longer present --> aborting media ringing.");
        this.currentMediaSession.setSessionStarted(false);
        this.cmdManager.scheduleAbortMediaRinging(this.mediaService, this.currentMediaSession, this.ringtonePlayer);
    }

    public void startRingtoneListOutbandPlayback() {
        this.log.log(1078071040, "[TelRingtoneManager#startRingtoneListOutbandPlayback] ringtone=%1", (long)this.getSelectedRingtone());
        this.cmdManager.scheduleOutbandRingtoneList(this.ringtonePlayer, this.getSelectedRingtone());
    }

    public void startRingtoneListMediaPlayback() {
        this.log.log(1078071040, "[TelRingtoneManager#startRingtoneListMediaPlayback] url=%1", (Object)this.getRingtonePath());
        IMediaFilePlayerService iMediaFilePlayerService = this.mediaService;
        if (iMediaFilePlayerService != null) {
            this.currentMediaSession = new TelRingtoneManager$RingtoneMediaSession(this, 91, 1, this.getRingtonePath());
            this.cmdManager.scheduleRingtoneListMediaPlayback(iMediaFilePlayerService, this.currentMediaSession);
        } else {
            this.log.log(-1601830656, "[TelRingtoneManager#startRingtoneListMediaPlayback] media service is null --> default ringtone");
            this.cmdManager.scheduleRingtoneListDefaultRingtoneFallback(this.ringtonePlayer);
        }
    }

    public void abortRingtoneListOutbandPlayback() {
        this.log.log(1078071040, "[TelRingtoneManager#abortRingtoneListWavePlayerPlayback]");
        this.cmdManager.scheduleAbortRingtoneListWavePlayerPlayback(this.ringtonePlayer);
    }

    public void abortRingtoneListMediaPlayback() {
        this.log.log(1078071040, "[TelRingtoneManager#abortRingtoneListMediaPlayback]");
        this.currentMediaSession.setSessionStarted(false);
        this.cmdManager.scheduleAbortRingtoneListMediaPlayback(this.mediaService, this.currentMediaSession, this.ringtonePlayer);
    }

    IMediaFilePlayerSession getCurrentMediaSession() {
        return this.currentMediaSession;
    }

    ListModelApp getRingtoneList() {
        return this.getListModel(-845937664);
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

    static /* synthetic */ LogChannel access$100(TelRingtoneManager telRingtoneManager) {
        return telRingtoneManager.log;
    }

    static /* synthetic */ LogChannel access$200(TelRingtoneManager telRingtoneManager) {
        return telRingtoneManager.log;
    }

    static /* synthetic */ LogChannel access$300(TelRingtoneManager telRingtoneManager) {
        return telRingtoneManager.log;
    }

    static /* synthetic */ LogChannel access$400(TelRingtoneManager telRingtoneManager) {
        return telRingtoneManager.log;
    }

    static /* synthetic */ LogChannel access$500(TelRingtoneManager telRingtoneManager) {
        return telRingtoneManager.log;
    }

    static /* synthetic */ RingTonePlayer access$600(TelRingtoneManager telRingtoneManager) {
        return telRingtoneManager.ringtonePlayer;
    }

    static /* synthetic */ IMediaFilePlayerService access$700(TelRingtoneManager telRingtoneManager) {
        return telRingtoneManager.mediaService;
    }

    static /* synthetic */ TelRingtoneManager$RingtoneMediaSession access$800(TelRingtoneManager telRingtoneManager) {
        return telRingtoneManager.currentMediaSession;
    }

    static /* synthetic */ TelAudioCmdManager access$900(TelRingtoneManager telRingtoneManager) {
        return telRingtoneManager.cmdManager;
    }

    static /* synthetic */ LogChannel access$1000(TelRingtoneManager telRingtoneManager) {
        return telRingtoneManager.log;
    }
}

