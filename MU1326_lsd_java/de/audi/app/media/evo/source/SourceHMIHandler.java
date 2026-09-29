/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.source;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.IContentMedia;
import de.audi.app.media.evo.source.SourceHMIHandler$1;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.IMultipleSourceSlotListener;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceChangeListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.Sources;
import de.audi.app.media.source.media.BluetoothSource;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.phone.ITelServiceMedia;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import java.util.Map;

public class SourceHMIHandler
extends AbstractMediaTerminalComponent
implements ISourceChangeListener,
IActionProxyListener,
IMultipleSourceSlotListener,
TimerListener {
    private static final String LOGCLASS;
    private static final int NO_ERROR;
    private static final int ERROR_TEMP_TOO_COLD;
    private static final int ERROR_TEMP_TOO_HOT;
    private final Object mutex = new Object();
    private boolean isA2DPPopupOverdue = false;
    private ISourceSlot activationSlot;
    private boolean isSlotActivation;
    private boolean showErrorPopup;
    private volatile int slotError;
    private volatile ITelServiceMedia phoneService;
    private final IServiceTracker phoneServiceTracker;
    private volatile boolean iPodA2DPHandlingWaitBtAudioPlayerBecomeDisabled;
    private volatile String iPodA2DPHandlingIPodName = "";
    private static final int RESUME_DELAY;
    private Timer iPhoneResumeTimer = new Timer("DetailInfoTimer", 5, null, this, 0, true);
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceMedia;

    public SourceHMIHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.phoneServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$phone$ITelServiceMedia == null ? (class$de$audi$atip$interapp$phone$ITelServiceMedia = SourceHMIHandler.class$("de.audi.atip.interapp.phone.ITelServiceMedia")) : class$de$audi$atip$interapp$phone$ITelServiceMedia, new SourceHMIHandler$1(this));
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"SourceHMIHandler");
        this.getTerminal().getSourceController().addSourceChangeListener(this);
        this.getTerminal().addActionProxyListener(new int[]{1001, 1002}, (IActionProxyListener)this);
        this.getTerminal().getSourceController().addSlotListener(this);
        this.phoneServiceTracker.open();
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"SourceHMIHandler");
        this.getTerminal().removeActionProxyListener(this);
        this.iPhoneResumeTimer.cancel();
        this.phoneServiceTracker.close();
    }

    @Override
    public boolean handleConcurrentIPodConnection(ISourceSlot iSourceSlot, ISourceSlot iSourceSlot2) {
        if (iSourceSlot2 == null) {
            this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] No IPod device connected.", (Object)"SourceHMIHandler");
            this.iPodA2DPHandlingWaitBtAudioPlayerBecomeDisabled = false;
            this.iPodA2DPHandlingIPodName = "";
            this.iPhoneResumeTimer.cancel();
            return false;
        }
        if (iSourceSlot == null) {
            this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] No BT slot.", (Object)"SourceHMIHandler");
            this.iPodA2DPHandlingWaitBtAudioPlayerBecomeDisabled = false;
            this.iPodA2DPHandlingIPodName = "";
            this.iPhoneResumeTimer.cancel();
            return false;
        }
        if (this.iPodA2DPHandlingWaitBtAudioPlayerBecomeDisabled) {
            if (!iSourceSlot2.getName().equals(this.iPodA2DPHandlingIPodName)) {
                return false;
            }
            if (iSourceSlot.getError() == 10) {
                this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] A2DP player becomes deactivated", (Object)"SourceHMIHandler");
                this.iPodA2DPHandlingWaitBtAudioPlayerBecomeDisabled = false;
                this.iPodA2DPHandlingIPodName = "";
                ISourceSlot iSourceSlot3 = this.getTerminal().getSourceController().getSelectedSlot();
                if (iSourceSlot3 == null) {
                    this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] No selected source slot.", (Object)"SourceHMIHandler");
                    this.iPhoneResumeTimer.cancel();
                    return false;
                }
                if (iSourceSlot3.getSource().getType() == 11) {
                    this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] Bluetooth source active. Switch to Ipod.", (Object)"SourceHMIHandler");
                    ActivationContext activationContext = new ActivationContext(iSourceSlot2);
                    if (this.getTerminal().getAudioManager().hasAudioFocus()) {
                        this.getTerminal().getSourceController().activateSource(activationContext);
                        this.iPhoneResumeTimer.cancel();
                        return true;
                    }
                    this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] No audio focus, set selected source to USB", (Object)"SourceHMIHandler");
                    this.switchToSlotWithNextHMIActivation(iSourceSlot2);
                    return true;
                }
                if (iSourceSlot3.getMediaType() == 24) {
                    this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] IPod active. Try to resume.", (Object)"SourceHMIHandler");
                    if (this.getTerminal().getAudioManager().hasAudioFocus() && !this.getTerminal().getAudioManager().isMuted()) {
                        this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] IPod active. Media has Audio Focus and is not muted wait 1 second for playback state pause.", (Object)"SourceHMIHandler");
                        this.iPhoneResumeTimer.restart();
                    }
                    return false;
                }
                this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] Not BT, Ipod active source.", (Object)"SourceHMIHandler");
                this.iPhoneResumeTimer.cancel();
                return false;
            }
            this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] Waiting that A2DP player becomes deactivated.", (Object)"SourceHMIHandler");
            this.iPhoneResumeTimer.cancel();
            return false;
        }
        if (!iSourceSlot.getSource().isActivateable(iSourceSlot)) {
            this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] BT slot not activateable.", (Object)"SourceHMIHandler");
            return false;
        }
        if (iSourceSlot2.getName() != null && iSourceSlot2.getName().equals(iSourceSlot.getName())) {
            this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] IPod as USB and A2DP, disable A2DP audio player", (Object)"SourceHMIHandler");
            this.a2dpConnectionWillBeDisabledForIpod();
            ((BluetoothSource)iSourceSlot.getSource()).disabledAudioPlayer();
            this.iPodA2DPHandlingWaitBtAudioPlayerBecomeDisabled = true;
            this.iPodA2DPHandlingIPodName = iSourceSlot.getName();
            ISourceSlot iSourceSlot4 = this.getTerminal().getSourceController().getSelectedSlot();
            return iSourceSlot4 != null && iSourceSlot4.getSource().getType() == 11;
        }
        this.logger.main().log(1078071040, "[%1.handleConcurrentIPodConnection] Ipod not connected as A2DP player", (Object)"SourceHMIHandler");
        this.isA2DPPopupOverdue = false;
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a2dpConnectionWillBeDisabledForIpod() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.getTerminal().isVisible()) {
                this.logger.hmi().log(1078071040, "[%1.a2dpConnectionWillBeDisabledForIpod]", (Object)"SourceHMIHandler");
                this.isA2DPPopupOverdue = false;
                ChoiceModelApp choiceModelApp = this.getChoiceModel(974127872);
                choiceModelApp.setValue(choiceModelApp.getValue() == 1 ? 2 : 1);
            } else {
                this.logger.hmi().log(1078071040, "[%1.a2dpConnectionWillBeDisabledForIpod] Not visible. Delay popup.", (Object)"SourceHMIHandler");
                this.isA2DPPopupOverdue = true;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void switchToSlotWithNextHMIActivation(ISourceSlot iSourceSlot) {
        this.logger.hmi().log(1078071040, "[%1.switchToSlotWithNextHMIActivation]", (Object)"SourceHMIHandler");
        Object object = this.mutex;
        synchronized (object) {
            this.isSlotActivation = true;
            this.activationSlot = iSourceSlot;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateOpticalSourceState(ISourceSlot iSourceSlot) {
        if (this.slotError == iSourceSlot.getError()) {
            return;
        }
        this.slotError = iSourceSlot.getError();
        Object object = this.mutex;
        synchronized (object) {
            switch (iSourceSlot.getError()) {
                case 8: {
                    this.getChoiceModel(1376781056).setValue(2);
                    if (this.getTerminal().isVisible()) {
                        this.getTerminal().getFramework().getHmiServiceApp().showPopup(1225589504);
                        break;
                    }
                    this.showErrorPopup = true;
                    break;
                }
                case 9: {
                    this.getChoiceModel(1376781056).setValue(1);
                    if (this.getTerminal().isVisible()) {
                        this.getTerminal().getFramework().getHmiServiceApp().showPopup(1225589504);
                        break;
                    }
                    this.showErrorPopup = true;
                    break;
                }
                default: {
                    this.showErrorPopup = false;
                    this.getChoiceModel(1376781056).setValue(0);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 1001: {
                Object object = this.mutex;
                synchronized (object) {
                    this.logger.hmi().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_HMI_ACTIVATED", (Object)"SourceHMIHandler");
                    int n2 = this.getTerminal().getSourceController().getSelectedSlot().getSource().getType();
                    if (!(this.isSlotActivation || this.getTerminal().getAudioManager().hasFrontAudioFocus() || Sources.isTVSource(n2))) {
                        this.getTerminal().getAudioManager().requestAudioFocus();
                    }
                    if (this.isSlotActivation) {
                        this.logger.hmi().log(1078071040, "[%1.actionProxyCallPerformed] Switch to '%2'", (Object)"SourceHMIHandler", (Object)this.activationSlot);
                        this.isSlotActivation = false;
                        this.getTerminal().getSourceController().activateSource(new ActivationContext(this.activationSlot));
                    }
                    if (this.isA2DPPopupOverdue) {
                        this.logger.hmi().log(1078071040, "[%1.actionProxyCallPerformed] Show A2DP popup.", (Object)"SourceHMIHandler");
                        this.isA2DPPopupOverdue = false;
                        ChoiceModelApp choiceModelApp = this.getChoiceModel(974127872);
                        choiceModelApp.setValue(choiceModelApp.getValue() == 1 ? 2 : 1);
                    }
                    if (this.showErrorPopup) {
                        this.logger.hmi().log(1078071040, "[%1.actionProxyCallPerformed] Show error popup.", (Object)"SourceHMIHandler");
                        this.showErrorPopup = false;
                        this.getTerminal().getFramework().getHmiServiceApp().showPopup(1225589504);
                    }
                    break;
                }
            }
            case 1002: {
                Object object = this.mutex;
                synchronized (object) {
                    this.logger.hmi().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_HMI_DEACTIVATED Remove A2DP popup.", (Object)"SourceHMIHandler");
                    ChoiceModelApp choiceModelApp = this.getChoiceModel(974127872);
                    choiceModelApp.setValue(0);
                    break;
                }
            }
        }
    }

    @Override
    public void slotsChanged(ISource[] iSourceArray) {
        this.logger.hmi().log(1078071040, "[%1.slotsChanged]", (Object)"SourceHMIHandler");
        for (int i2 = 0; i2 < iSourceArray.length; ++i2) {
            if (0 == iSourceArray[i2].getType() || 2 == iSourceArray[i2].getType()) {
                this.updateOpticalSourceState(iSourceArray[i2].getSlot(0));
            }
            if (6 != iSourceArray[i2].getType() || 22 != iSourceArray[i2].getSlot(0).getError()) continue;
            this.resetRingtone();
        }
    }

    private void resetRingtone() {
        this.logger.hmi().log(1078071040, "[%1.resetRingtone]", (Object)"SourceHMIHandler");
        if (null != this.phoneService) {
            this.phoneService.resetUserDefinedRingtone();
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.main().log(1078071040, "[%1.fireTimer] try to resume.", (Object)"SourceHMIHandler");
        ((IContentMedia)this.getTerminal().getContentManager().getActiveContent()).getPlayer().resume();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ITelServiceMedia access$002(SourceHMIHandler sourceHMIHandler, ITelServiceMedia iTelServiceMedia) {
        sourceHMIHandler.phoneService = iTelServiceMedia;
        return sourceHMIHandler.phoneService;
    }

    static /* synthetic */ IMediaLogger access$100(SourceHMIHandler sourceHMIHandler) {
        return sourceHMIHandler.logger;
    }

    static /* synthetic */ ITelServiceMedia access$000(SourceHMIHandler sourceHMIHandler) {
        return sourceHMIHandler.phoneService;
    }
}

