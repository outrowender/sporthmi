/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.dsi.IDSIControllerStateListener;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.AbstractSource;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.app.media.source.IMultipleSourceSlotListener;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceActivationCallbackHandler;
import de.audi.app.media.source.ISourceActivationExtension;
import de.audi.app.media.source.ISourceChangeListener;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceListListener;
import de.audi.app.media.source.ISourceListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.source.ISourceStartupListener;
import de.audi.app.media.source.LastModeManager;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.source.SourceController$1;
import de.audi.app.media.source.SourceControllerHMIHandler;
import de.audi.app.media.source.SourceControllerParameterFactory;
import de.audi.app.media.source.SourceListProvider;
import de.audi.app.media.source.media.AUXSource;
import de.audi.app.media.source.media.AVSource;
import de.audi.app.media.source.media.BluetoothSource;
import de.audi.app.media.source.media.DiscChangerSource;
import de.audi.app.media.source.media.DiscDriveSource;
import de.audi.app.media.source.media.FilePlayerSource;
import de.audi.app.media.source.media.HDDSource;
import de.audi.app.media.source.media.OnlinePlayerSource;
import de.audi.app.media.source.media.SDCardSource;
import de.audi.app.media.source.media.TVSource;
import de.audi.app.media.source.media.USBSource;
import de.audi.app.media.source.media.WLANSource;
import de.audi.app.media.source.state.ISourceStateHandler;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SourceController
extends AbstractMediaTerminalComponent
implements ISourceController,
IMultipleSourceSlotListener,
ISourceActivationCallbackHandler,
ISourceStartupListener,
IContentListener,
IDSIControllerStateListener {
    private static final String LOGCLASS;
    private static final int TV_AV_START_WARMUP_MILLIS;
    private final Object sourceActivationMutex = new Object();
    final ISourceStateHandler sourceStateHandler;
    final IMediaDSIPlayerController mediaDSIPlayerController;
    final SourceListProvider sourceListProvider;
    final LastModeManager lastModeManager;
    final SourceControllerHMIHandler hmiHandler;
    volatile ISourceActivationExtension sourceActivationExtension;
    final ISourceActivationExtension noSourceActivationExtension;
    private volatile ISource[] sourceList;
    private volatile ISourceSlot selectedSourceSlot = null;
    private volatile boolean[] automaticSourceChangeRelevantSources = new boolean[14];
    private boolean restoreLastPlaymodeAfterDeactivation = false;
    private boolean demuteOnActivation = true;
    private volatile ISourceSlot lastFilePlayerSourceSlot = null;
    private volatile boolean onLoading = false;
    List activeSourceListenerList;
    private ActiveSourceState currentNotifiedActiveSourceState;
    private volatile ActivationContext currentActivationContext;
    private volatile ISourceChangeListener sourceChangeListener;
    private volatile boolean noActiveSourceUpdateSinceDeactivation;
    private long lastAVActivation;

    public SourceController(IMediaTerminal iMediaTerminal, ISourceStateHandler iSourceStateHandler, IMediaDSIPlayerController iMediaDSIPlayerController) {
        this(iMediaTerminal, iSourceStateHandler, iMediaDSIPlayerController, new SourceControllerParameterFactory());
    }

    SourceController(IMediaTerminal iMediaTerminal, ISourceStateHandler iSourceStateHandler, IMediaDSIPlayerController iMediaDSIPlayerController, SourceControllerParameterFactory sourceControllerParameterFactory) {
        super(iMediaTerminal);
        this.sourceStateHandler = iSourceStateHandler;
        this.mediaDSIPlayerController = iMediaDSIPlayerController;
        this.sourceListProvider = sourceControllerParameterFactory.createSourceListProvider(this.logger.main());
        this.lastModeManager = sourceControllerParameterFactory.createLastModeManager(iMediaTerminal);
        this.hmiHandler = sourceControllerParameterFactory.createSourceControllerHMIHandler(iMediaTerminal);
        this.activeSourceListenerList = sourceControllerParameterFactory.createArrayList(0);
        this.sourceActivationExtension = this.noSourceActivationExtension = sourceControllerParameterFactory.createNoSourceActivationExtension();
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"SourceController");
        ISource[] iSourceArray = new ISource[14];
        for (int i2 = 0; i2 < 14; ++i2) {
            boolean bl = this.getTerminal().getConfiguration().isSourceInstalled(i2);
            if (bl) {
                iSourceArray[i2] = this.initSource(i2);
                continue;
            }
            this.logger.main().log(1078071040, "[%1.init] '%2' disabled.", (Object)"SourceController", (Object)LogUtil.getSourceTypeStr(i2));
        }
        this.sourceList = iSourceArray;
        this.hmiHandler.init();
        this.hmiHandler.setOnlineSourceInstalled(this.getTerminal().getConfiguration().isSourceInstalled(13));
        this.addSlotListener(this);
        this.addSlotListener(this.sourceListProvider);
        this.lastModeManager.init();
        this.lastModeManager.setStartupListener(this);
        this.mediaDSIPlayerController.setStateListener(this);
    }

    public void deinit() {
        this.logger.main().log(-2137614336, "[%1.deinit]", (Object)"SourceController");
        this.mediaDSIPlayerController.setStateListener(null);
        this.hmiHandler.deinit();
        this.sourceListProvider.deinit();
        this.removeAllActiveSourceListener();
        for (int i2 = 0; i2 < 14; ++i2) {
            if (this.sourceList[i2] == null) continue;
            this.sourceList[i2].deinit();
            this.sourceList[i2] = null;
        }
    }

    @Override
    public void addSourceListener(ISourceListener iSourceListener) {
        this.logger.main().log(1078071040, "[%1.addSourceListener] '%2'", (Object)"SourceController", (Object)iSourceListener);
        for (int i2 = 0; i2 < 14; ++i2) {
            ISource iSource = this.getSource(i2);
            if (iSource == null) continue;
            iSource.addSourceListener(iSourceListener);
        }
    }

    @Override
    public void addSlotListener(IMultipleSourceSlotListener iMultipleSourceSlotListener) {
        this.logger.main().log(1078071040, "[%1.addSlotListener] '%2'", (Object)"SourceController", (Object)iMultipleSourceSlotListener);
        this.sourceStateHandler.addSourceSlotListener(iMultipleSourceSlotListener);
    }

    @Override
    public void addSourceSlotListener(ISource iSource, ISourceSlotListener iSourceSlotListener, boolean bl) {
        this.sourceStateHandler.addSourceSlotListener(iSource, iSourceSlotListener, bl);
    }

    @Override
    public void removeSlotListener(ISource iSource, ISourceSlotListener iSourceSlotListener) {
        this.sourceStateHandler.removeSlotListener(iSource, iSourceSlotListener);
    }

    @Override
    public void addSourceListListener(ISourceListListener iSourceListListener) {
        this.sourceListProvider.addSourceListListener(iSourceListListener);
    }

    @Override
    public void addActiveSourceListener(IActiveSourceListener iActiveSourceListener) {
        this.addActiveSourceListener(iActiveSourceListener, false);
    }

    @Override
    public void addActiveSourceListenerAndNotifyState(IActiveSourceListener iActiveSourceListener) {
        this.addActiveSourceListener(iActiveSourceListener, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addActiveSourceListener(IActiveSourceListener iActiveSourceListener, boolean bl) {
        if (iActiveSourceListener == null) {
            throw new IllegalArgumentException();
        }
        this.logger.main().log(1078071040, "[%1.addActiveSourceListener] '%2' %3", (Object)"SourceController", (Object)super.getClass(), (Object)(bl ? "NOTIFY" : ""));
        Object object = this.sourceActivationMutex;
        synchronized (object) {
            if (this.activeSourceListenerList.contains(iActiveSourceListener)) {
                this.logger.main().log(1078071040, "[%1.addActiveSourceListener] Already registered", (Object)"SourceController");
                return;
            }
            this.activeSourceListenerList.add(iActiveSourceListener);
            if (bl) {
                if (this.currentNotifiedActiveSourceState != null) {
                    this.logger.main().log(1078071040, "[%1.addActiveSourceListener] Notify added listener: '%2' (changed)", (Object)"SourceController", (Object)this.currentNotifiedActiveSourceState);
                    iActiveSourceListener.activeSourceChanged(true, this.currentNotifiedActiveSourceState);
                } else {
                    this.logger.main().log(1078071040, "[%1.addActiveSourceListener] Notify added listener: No previous notification.", (Object)"SourceController");
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeActiveSourceListener(IActiveSourceListener iActiveSourceListener) {
        this.logger.main().log(1078071040, "[%1.removeActiveSourceListener] '%2'", (Object)"SourceController", (Object)iActiveSourceListener);
        if (iActiveSourceListener == null) {
            throw new IllegalArgumentException();
        }
        Object object = this.sourceActivationMutex;
        synchronized (object) {
            if (!this.activeSourceListenerList.contains(iActiveSourceListener)) {
                this.logger.main().log(1078071040, "[%1.removeActiveSourceListener] listener not registered", (Object)"SourceController");
                return;
            }
            this.logger.main().log(-2137614336, "[%1.removeActiveSourceListener] listener=%2", (Object)"SourceController", (Object)super.getClass());
            this.activeSourceListenerList.remove(iActiveSourceListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removeAllActiveSourceListener() {
        Object object = this.sourceActivationMutex;
        synchronized (object) {
            this.logger.main().log(-2137614336, "[%1.removeAllListeners]", (Object)"SourceController");
            this.activeSourceListenerList = new ArrayList(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void notifyActiveSourceChanged(ISourceSlot iSourceSlot, int n) {
        ActiveSourceState activeSourceState = new ActiveSourceState(iSourceSlot, n);
        if (activeSourceState.equals(this.currentNotifiedActiveSourceState)) {
            this.logger.main().log(1078071040, "[%1.notifyActiveSourceChanged] '%3' '%2' (not changed)", (Object)"SourceController", (Object)activeSourceState, (Object)this.currentNotifiedActiveSourceState);
            if (this.noActiveSourceUpdateSinceDeactivation) {
                this.logger.main().log(1078071040, "[%1.notifyActiveSourceChanged] No active source update since the last deactivation. -> Force notification.", (Object)"SourceController");
            } else {
                return;
            }
        }
        this.logger.main().log(1078071040, "[%1.notifyActiveSourceChanged] '%2'", (Object)"SourceController", (Object)activeSourceState);
        this.noActiveSourceUpdateSinceDeactivation = false;
        this.hmiHandler.setActiveSourceState(activeSourceState);
        boolean bl = this.currentNotifiedActiveSourceState == null || !((Object)activeSourceState.getSlot()).equals(this.currentNotifiedActiveSourceState.getSlot());
        boolean bl2 = this.currentNotifiedActiveSourceState != null && 10 == this.currentNotifiedActiveSourceState.getSlot().getSource().getType() && 24 != this.currentNotifiedActiveSourceState.getSlot().getMediaType() && 24 == activeSourceState.getSlot().getMediaType();
        boolean bl3 = this.currentNotifiedActiveSourceState != null && 24 == this.currentNotifiedActiveSourceState.getSlot().getMediaType() && 10 == activeSourceState.getSlot().getSource().getType() && 24 != activeSourceState.getSlot().getMediaType();
        this.currentNotifiedActiveSourceState = activeSourceState;
        Object object = this.sourceActivationMutex;
        synchronized (object) {
            Iterator iterator = this.activeSourceListenerList.iterator();
            while (iterator.hasNext()) {
                try {
                    IActiveSourceListener iActiveSourceListener = (IActiveSourceListener)iterator.next();
                    this.logger.main().log(-2137614336, "[%1.notifyActiveSourceChanged listener=%2] changed = %3", (Object)"SourceController", (Object)super.getClass(), (Object)Boolean.toString(bl || bl2 || bl3));
                    iActiveSourceListener.activeSourceChanged(bl || bl2 || bl3, activeSourceState);
                }
                catch (Exception exception) {
                    this.logger.main().log(-1601830656, "[%1.notifyActiveSourceChanged] %2", (Object)"SourceController", (Throwable)exception);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void notifySourceDeactivated() {
        this.noActiveSourceUpdateSinceDeactivation = true;
        Object object = this.sourceActivationMutex;
        synchronized (object) {
            Iterator iterator = this.activeSourceListenerList.iterator();
            while (iterator.hasNext()) {
                try {
                    IActiveSourceListener iActiveSourceListener = (IActiveSourceListener)iterator.next();
                    this.logger.main().log(1078071040, "[%1.notifySourceDeactivated] %2", (Object)"SourceController", (Object)iActiveSourceListener);
                    iActiveSourceListener.sourceDeactivated();
                }
                catch (Exception exception) {
                    this.logger.main().log(-1601830656, "[%1.notifySourceDeactivated] %2", (Object)"SourceController", (Throwable)exception);
                }
            }
        }
    }

    @Override
    public int activateSource(IActivationContext iActivationContext) {
        Object object;
        boolean bl;
        if (this.getActivationContext() != null && iActivationContext != null) {
            int n = this.getActivationContext().getSlot().getSource().getType();
            int n2 = iActivationContext.getSlot().getSource().getType();
            boolean bl2 = bl = System.currentTimeMillis() - this.lastAVActivation < 0;
            if (n == 8 && n2 == 7 && bl) {
                this.logger.main().log(1078071040, "[%1.activateSource] [%2] suppress call while already running activation ", (Object)"SourceController", (long)n2);
                return 2;
            }
            if (n2 == 8) {
                this.lastAVActivation = System.currentTimeMillis();
            }
        }
        this.logger.main().log(1078071040, "[%1.activateSource] '%2'", (Object)"SourceController", (Object)iActivationContext);
        this.lastModeManager.stopLastModeTracking();
        ISourceSlot iSourceSlot = iActivationContext.getSlot();
        ISourceSlot iSourceSlot2 = this.getSelectedSlot();
        if (((Object)iSourceSlot).equals(iSourceSlot2) && iSourceSlot2.getSource().isActive()) {
            this.logger.main().log(1078071040, "[%1.activateSource] [%2] Already in activation", (Object)"SourceController", (Object)iSourceSlot.getSource());
            if (iSourceSlot.getSource().isDeviceActivated()) {
                this.getTerminal().getAudioManager().resumeAudio(true);
            }
            return 2;
        }
        this.logger.main().log(1078071040, "[%1.activateSource] [%2] Deactivate old content.", (Object)"SourceController", (Object)iSourceSlot.getSource());
        this.getTerminal().getContentManager().deactivateActiveContent();
        if (iSourceSlot2 != null) {
            this.logger.main().log(1078071040, "[%1.activateSource] [%2] Deactivate old source.", (Object)"SourceController", (Object)iSourceSlot.getSource());
            bl = iSourceSlot2.getSource().getType() == 7 || iSourceSlot2.getSource().getType() == 8;
            boolean bl3 = (iSourceSlot.getSource().getType() == 7 || iSourceSlot.getSource().getType() == 8) && !bl;
            boolean bl4 = iSourceSlot2.getSource().getType() == 13 && iSourceSlot.getSource().getType() == 13 && iSourceSlot2.getSource().isDeviceActivated();
            this.notifySourceDeactivated();
            boolean bl5 = this.selectedSourceSlot != null && this.selectedSourceSlot.getSource().isActivateable(this.selectedSourceSlot) || bl3 || bl4;
            iSourceSlot2.getSource().deactivate(bl5);
            if (bl5 && !bl) {
                try {
                    this.mediaDSIPlayerController.deactivateSource();
                }
                catch (InterruptedException interruptedException) {
                    this.logger.main().log(-1601830656, "[%1.deactivateSource] source deactivion sync interrupted %2", (Object)"SourceController", (Throwable)interruptedException);
                    return 3;
                }
            }
        }
        if ((object = iActivationContext.getParameter("REQUEST_AUDIO_IN_ADVANCE")) != null && object instanceof Boolean && ((Boolean)object).booleanValue()) {
            this.logger.main().log(1078071040, "[%1.activateSource] [%2] Requesting audio focus in advance.", (Object)"SourceController");
            this.getTerminal().getAudioManager().requestAudioFocus();
        }
        ActivationContext activationContext = (ActivationContext)iActivationContext;
        activationContext.addParameter("RESTORE_STATE", Boolean.FALSE);
        activationContext.addParameter("IS_STARTUP", Boolean.FALSE);
        activationContext.addParameter("RESTORE_BROWSER_PATH_POSSIBLE", iSourceSlot.getSource().getType() == 11 ? Boolean.FALSE : Boolean.TRUE);
        this.triggerSourceActivation(activationContext, true);
        return 1;
    }

    public boolean isSlotInActivation(ISourceSlot iSourceSlot) {
        if (this.currentActivationContext == null) {
            return false;
        }
        ISourceSlot iSourceSlot2 = this.currentActivationContext.getSlot();
        if (iSourceSlot2 == null) {
            return false;
        }
        if (((Object)iSourceSlot).equals(iSourceSlot2)) {
            this.logger.main().log(1078071040, "[%1.isSlotInActivation] [%2] Already in activation", (Object)"SourceController", (Object)iSourceSlot.getSource());
            return true;
        }
        return false;
    }

    public void restoreLastModeSource() {
        this.logger.main().log(1078071040, "[%1.restoreLastModeSource]", (Object)"SourceController");
        this.getTerminal().getDispatcher().execute(new SourceController$1(this, "SourceController.restoreLastModeSource"));
    }

    @Override
    public void sourceStartupFinished(ISourceSlot iSourceSlot) {
        ISourceSlot iSourceSlot2;
        Object object;
        this.logger.main().log(1078071040, "[%1.sourceStartupFinished] '%2'", (Object)"SourceController", (Object)iSourceSlot);
        this.getTerminal().getFramework().getStartupMgr().logStartupEvent(new StringBuffer().append("[MEDIA] Last mode source '").append(iSourceSlot).append("' available. Trigger activation.").toString());
        ISource iSource = iSourceSlot.getSource();
        if (iSource.getType() == 10 && iSourceSlot.isEmpty() && !iSource.isEmpty()) {
            this.logger.main().log(1078071040, "[%1.sourceStartupFinished] USB not complete empty.", (Object)"SourceController");
            object = iSource.getSlots().iterator();
            while (object.hasNext()) {
                iSourceSlot2 = (ISourceSlot)object.next();
                if (iSourceSlot2.isEmpty()) continue;
                this.logger.main().log(1078071040, "[%1.sourceStartupFinished] slotIdx '%2' not empty.", (Object)"SourceController", (long)iSourceSlot2.getIndex());
                this.setSelectedSlot(this.selectedSourceSlot);
                break;
            }
        }
        if (!(iSource.getType() != 3 && iSource.getType() != 1 || iSource.isEmpty())) {
            if (iSource.isActivateable(iSourceSlot)) {
                this.setSelectedSlot(iSourceSlot);
                ((DiscChangerSource)iSource).setWildCardActivation();
            } else {
                object = iSource.getSlots().iterator();
                while (object.hasNext()) {
                    iSourceSlot2 = (ISourceSlot)object.next();
                    if (!iSource.isActivateable(iSourceSlot2)) continue;
                    this.setSelectedSlot(iSourceSlot2);
                    ((DiscChangerSource)iSource).setWildCardActivation();
                    break;
                }
            }
        }
        if (iSource.getType() == 13) {
            this.logger.main().log(1078071040, "[%1.sourceStartupFinished] lastSource is OnlinePlayer update selected slot.", (Object)"SourceController");
            if (!iSource.isLastSelectedSlot(iSourceSlot)) {
                object = iSource.getActivatableSlot(this.selectedSourceSlot);
                this.setSelectedSlot((ISourceSlot)object);
            }
        }
        this.reactivateSelectedSource(true);
    }

    private void reactivateSelectedSource(boolean bl) {
        ISourceSlot iSourceSlot = this.getSelectedSlot();
        if (iSourceSlot == null) {
            this.logger.main().log(-1601830656, "[%1.reactivateSelectedSource] No active source", (Object)"SourceController");
            return;
        }
        if (iSourceSlot.getSource().getType() == 4) {
            this.logger.main().log(1078071040, "[%1.reactivateSelectedSource] FilePlayer active", (Object)"SourceController");
            return;
        }
        if (iSourceSlot.getSource().isActive()) {
            this.logger.main().log(1078071040, "[%1.reactivateSelectedSource] '%2' already active", (Object)"SourceController", (Object)iSourceSlot);
            return;
        }
        this.logger.main().log(1078071040, "[%1.reactivateSelectedSource] slot='%2' isStartup=%3 .", (Object)"SourceController", (Object)iSourceSlot, (Object)bl);
        int n = iSourceSlot.getSource().getType();
        ActivationContext activationContext = new ActivationContext(iSourceSlot);
        activationContext.addParameter("RESTORE_STATE", Boolean.TRUE);
        activationContext.addParameter("DEMUTE", bl && this.getTerminal().getAudioManager().hasAudioFocus() ? Boolean.FALSE : Boolean.TRUE);
        activationContext.addParameter("IS_STARTUP", bl);
        activationContext.addParameter("RESTORE_BROWSER_PATH_POSSIBLE", n == 11 ? Boolean.FALSE : Boolean.TRUE);
        this.triggerSourceActivation(activationContext, false);
        if (n == 7 && this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
            this.logger.main().log(1078071040, "[%1.reactivateSelectedSource] Forcing correction of front audio focus for TV", (Object)"SourceController");
            this.getTerminal().getAudioManager().switchAudioFocusToTV();
        }
        if (n == 7 && this.getTerminal().getAudioManager().hasRearSeatAudioFocus()) {
            this.logger.main().log(1078071040, "[%1.reactivateSelectedSource] Forcing correction of rear audio focus for TV", (Object)"SourceController");
            this.getTerminal().getAudioManager().switchSDISAudioFocusToTV();
        }
    }

    private void triggerSourceActivation(ActivationContext activationContext, boolean bl) {
        this.logger.main().log(1078071040, "[%1.triggerSourceActivation] '%2' (resumeAudio='%3')", (Object)"SourceController", (Object)activationContext, (Object)bl);
        this.setActivationContext(activationContext);
        ISourceSlot iSourceSlot = activationContext.getSlot();
        this.switchToActiveMedia(iSourceSlot, bl);
        iSourceSlot.getSource().activate(iSourceSlot);
    }

    private void switchToActiveMedia(ISourceSlot iSourceSlot, boolean bl) {
        this.logger.main().log(1078071040, "[%1.switchToActiveMedia] '%2' (resumeAudio='%3')", (Object)"SourceController", (Object)iSourceSlot, (Object)bl);
        this.lastModeManager.setLastSelectedSource(iSourceSlot);
        this.setSelectedSlot(iSourceSlot);
        if (iSourceSlot.getSource().getType() != 7 && iSourceSlot.getSource().getType() != 8) {
            this.getTerminal().getAudioManager().requestEntSuppression();
        }
        if (bl) {
            this.getTerminal().getAudioManager().resumeAudio(true);
        }
        this.getTerminal().getAudioManager().requestVolumelock(new StringBuffer().append("Activate '").append(iSourceSlot).append("'").toString());
        this.setOnLoading(true);
        this.updateActiveSourceState(iSourceSlot);
        this.getTerminal().getTitlelineHMIHandler().setSourceIcon(iSourceSlot);
        this.getTerminal().getTitlelineHMIHandler().resetIcons();
        this.getTerminal().getTitlelineHMIHandler().flush();
        this.hmiHandler.setActiveMedia(iSourceSlot);
        this.hmiHandler.setActiveSlotSyncState(iSourceSlot);
        this.hmiHandler.setActiveMediaCapabilities(iSourceSlot.getCapabilities());
    }

    @Override
    public void restorePreviousFilePlayerSource() {
        this.logger.main().log(1078071040, "[%1.restorePreviousFilePlayerSource] '%2'", (Object)"SourceController", (Object)this.lastFilePlayerSourceSlot);
        ISourceSlot iSourceSlot = this.getSelectedSlot();
        if (iSourceSlot == null || iSourceSlot.getSource().getType() != 4) {
            this.logger.main().log(-1601830656, "[%1.restorePreviousFilePlayerSource] Fileplayer not active.", (Object)"SourceController");
            return;
        }
        if (this.lastFilePlayerSourceSlot == null) {
            this.logger.main().log(-1601830656, "[%1.lastFilePlayerSourceSlot] No previous file player slot.", (Object)"SourceController");
            this.lastFilePlayerSourceSlot = this.getSource(2).getSlot(0);
        }
        boolean bl = this.lastFilePlayerSourceSlot.getSource().getType() == 7 || this.lastFilePlayerSourceSlot.getSource().getType() == 8;
        iSourceSlot.getSource().deactivate(!this.lastFilePlayerSourceSlot.getSource().isActivateable(this.lastFilePlayerSourceSlot) || bl);
        this.getTerminal().getContentManager().deactivateActiveContent();
        this.setSelectedSlot(this.lastFilePlayerSourceSlot);
        this.reactivateSelectedSource(false);
    }

    private void setActivationContext(ActivationContext activationContext) {
        this.logger.main().log(1078071040, "[%1.setActivationContext] '%2'", (Object)"SourceController", (Object)activationContext);
        this.currentActivationContext = activationContext;
    }

    @Override
    public IActivationContext getActivationContext() {
        return this.currentActivationContext;
    }

    @Override
    public ISourceSlot getSelectedSlot() {
        if (this.selectedSourceSlot != null) {
            return this.selectedSourceSlot.getSource().getSlot(this.selectedSourceSlot.getIndex());
        }
        this.logger.main().log(-1601830656, "[%1.getSelectedSlot] slot is null", (Object)"SourceController");
        return null;
    }

    @Override
    public boolean isSelectedSource(ISource iSource) {
        try {
            return iSource.equals(this.getSelectedSlot().getSource());
        }
        catch (Exception exception) {
            return false;
        }
    }

    private void setSelectedSlot(ISourceSlot iSourceSlot) {
        this.logger.main().log(1078071040, "[%1.setSelectedSlot] '%2'", (Object)"SourceController", (Object)iSourceSlot);
        this.selectedSourceSlot = iSourceSlot;
        if (iSourceSlot.getSource().getType() != 4) {
            this.lastFilePlayerSourceSlot = this.selectedSourceSlot;
        }
        this.hmiHandler.setActiveSourceSlot(this.selectedSourceSlot);
    }

    private ISource initSource(int n) {
        AbstractSource abstractSource;
        switch (n) {
            case 0: {
                this.logger.main().log(1078071040, "[%1.initSource] CD", (Object)"SourceController");
                DiscDriveSource discDriveSource = new DiscDriveSource(this.getTerminal(), this.mediaDSIPlayerController, n, "CD");
                this.sourceStateHandler.registerSource(discDriveSource);
                abstractSource = discDriveSource;
                break;
            }
            case 1: {
                this.logger.main().log(1078071040, "[%1.initSource] CDC", (Object)"SourceController");
                DiscChangerSource discChangerSource = new DiscChangerSource(this.getTerminal(), this.mediaDSIPlayerController, n, "CDC");
                this.sourceStateHandler.registerSource(discChangerSource);
                abstractSource = discChangerSource;
                break;
            }
            case 2: {
                this.logger.main().log(1078071040, "[%1.initSource] DVD", (Object)"SourceController");
                DiscDriveSource discDriveSource = new DiscDriveSource(this.getTerminal(), this.mediaDSIPlayerController, n, "DVD");
                this.sourceStateHandler.registerSource(discDriveSource);
                abstractSource = discDriveSource;
                break;
            }
            case 3: {
                this.logger.main().log(1078071040, "[%1.initSource] DVDC", (Object)"SourceController");
                DiscChangerSource discChangerSource = new DiscChangerSource(this.getTerminal(), this.mediaDSIPlayerController, n, "DVDC");
                this.sourceStateHandler.registerSource(discChangerSource);
                abstractSource = discChangerSource;
                break;
            }
            case 5: {
                this.logger.main().log(1078071040, "[%1.initSource] SDCARD", (Object)"SourceController");
                SDCardSource sDCardSource = new SDCardSource(this.getTerminal(), this.mediaDSIPlayerController);
                this.sourceStateHandler.registerSource(sDCardSource);
                abstractSource = sDCardSource;
                break;
            }
            case 10: {
                this.logger.main().log(1078071040, "[%1.initSource] USB", (Object)"SourceController");
                USBSource uSBSource = new USBSource(this.getTerminal(), this.mediaDSIPlayerController, n, "USB");
                this.sourceStateHandler.registerSource(uSBSource);
                abstractSource = uSBSource;
                break;
            }
            case 6: {
                this.logger.main().log(1078071040, "[%1.initSource] HDD", (Object)"SourceController");
                HDDSource hDDSource = new HDDSource(this.getTerminal(), this.mediaDSIPlayerController);
                this.sourceStateHandler.registerSource(hDDSource);
                abstractSource = hDDSource;
                break;
            }
            case 7: {
                this.logger.main().log(1078071040, "[%1.initSource] TV", (Object)"SourceController");
                TVSource tVSource = new TVSource(this.getTerminal(), this.sourceStateHandler.getSourceStateUpdater(), this);
                this.sourceStateHandler.registerSource(tVSource);
                abstractSource = tVSource;
                break;
            }
            case 8: {
                this.logger.main().log(1078071040, "[%1.initSource] AV", (Object)"SourceController");
                AVSource aVSource = new AVSource(this.getTerminal(), this.sourceStateHandler.getSourceStateUpdater(), this);
                this.sourceStateHandler.registerSource(aVSource);
                abstractSource = aVSource;
                break;
            }
            case 9: {
                this.logger.main().log(1078071040, "[%1.initSource] AMI", (Object)"SourceController");
                AUXSource aUXSource = new AUXSource(this.getTerminal(), this.mediaDSIPlayerController, n, "AUX");
                this.sourceStateHandler.registerSource(aUXSource);
                abstractSource = aUXSource;
                break;
            }
            case 11: {
                this.logger.main().log(1078071040, "[%1.initSource] BLUETOOTH", (Object)"SourceController");
                BluetoothSource bluetoothSource = new BluetoothSource(this.getTerminal(), this.mediaDSIPlayerController);
                bluetoothSource.init();
                abstractSource = bluetoothSource;
                this.sourceStateHandler.registerSource(bluetoothSource);
                break;
            }
            case 12: {
                this.logger.main().log(1078071040, "[%1.initSource] WLAN.", (Object)"SourceController");
                WLANSource wLANSource = new WLANSource(this.getTerminal(), this.mediaDSIPlayerController);
                wLANSource.init();
                abstractSource = wLANSource;
                this.sourceStateHandler.registerSource(wLANSource);
                break;
            }
            case 4: {
                FilePlayerSource filePlayerSource;
                this.logger.main().log(1078071040, "[%1.initSource] FILEPLAYER.", (Object)"SourceController");
                abstractSource = filePlayerSource = new FilePlayerSource(this.getTerminal(), this.mediaDSIPlayerController);
                this.sourceStateHandler.registerSource(filePlayerSource);
                break;
            }
            case 13: {
                this.logger.main().log(1078071040, "[%1.initSource] ONLINEPLAYER", (Object)"SourceController");
                OnlinePlayerSource onlinePlayerSource = new OnlinePlayerSource(this.getTerminal(), this.mediaDSIPlayerController);
                abstractSource = onlinePlayerSource;
                this.sourceStateHandler.registerSource(onlinePlayerSource);
                break;
            }
            default: {
                this.logger.main().log(-1601830656, "[%1.initSource] '%2' not supported.", (Object)"SourceController", (Object)LogUtil.getSourceTypeStr(n));
                return null;
            }
        }
        return abstractSource;
    }

    @Override
    public ISource getSource(int n) {
        try {
            return this.sourceList[n];
        }
        catch (Exception exception) {
            this.logger.main().log(-1601830656, "[%1.getSource] Invalid ID '%2'.", (Object)"SourceController", (long)n);
            return null;
        }
    }

    @Override
    public void setAutomaticSourceChange(int[] nArray) {
        if (nArray == null) {
            throw new IllegalArgumentException();
        }
        if (this.logger.main().isInfo()) {
            Buffer buffer = new Buffer(100);
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                buffer.append(LogUtil.getSourceTypeStr(nArray[i2])).append(",");
            }
            this.logger.main().log(1078071040, "[%1.setAutomaticSourceChange] '%2'", (Object)"SourceController", (Object)buffer.toString());
        }
        Arrays.fill(this.automaticSourceChangeRelevantSources, false);
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            this.automaticSourceChangeRelevantSources[nArray[i3]] = true;
        }
    }

    boolean isRelevantForAutomaticSourceChange(ISource iSource) {
        return this.automaticSourceChangeRelevantSources[iSource.getType()];
    }

    private List getAutomaticSourceChangeRelevantSources(ISource[] iSourceArray) {
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < iSourceArray.length; ++i2) {
            if (!this.isRelevantForAutomaticSourceChange(iSourceArray[i2])) continue;
            linkedList.add(iSourceArray[i2]);
        }
        return linkedList;
    }

    private boolean checkAutomaticSourceChange(ISource[] iSourceArray) {
        List list = this.getAutomaticSourceChangeRelevantSources(iSourceArray);
        if (list.isEmpty()) {
            return false;
        }
        this.logger.main().log(1078071040, "[%1.checkAutomaticSourceChange] Automatic source change relevant sources changed", (Object)"SourceController");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ISource iSource = (ISource)iterator.next();
            Iterator iterator2 = iSource.getSlots().iterator();
            while (iterator2.hasNext()) {
                ISourceSlot iSourceSlot = (ISourceSlot)iterator2.next();
                if (!iSourceSlot.isLoading()) continue;
                this.logger.main().log(1078071040, "[%1.checkAutomaticSourceChange] '%2', slot '%3' inserted", (Object)"SourceController", (Object)iSourceSlot.getSource(), (long)iSourceSlot.getIndex());
                ISourceSlot iSourceSlot2 = this.getSelectedSlot();
                if (iSourceSlot2.getSource().getType() == 4) {
                    this.logger.main().log(1078071040, "[%1.checkAutomaticSourceChange] Fileplayer active", (Object)"SourceController");
                    this.lastFilePlayerSourceSlot = iSourceSlot;
                    return true;
                }
                if (((Object)iSourceSlot).equals(iSourceSlot2)) {
                    iSourceSlot.getSource().deactivate(false);
                }
                this.activateSource(new ActivationContext(iSourceSlot));
                return true;
            }
        }
        this.logger.main().log(1078071040, "[%1.checkAutomaticSourceChange] No change neccessary", (Object)"SourceController");
        return false;
    }

    @Override
    public void slotsChanged(ISource[] iSourceArray) {
        this.logger.main().log(1078071040, "[%1.slotsChanged]", (Object)"SourceController");
        if (this.ipodAMIandA2DPSwitch(iSourceArray)) {
            return;
        }
        if (this.checkAutomaticSourceChange(iSourceArray)) {
            return;
        }
        ISourceSlot iSourceSlot = this.getSelectedSlot();
        if (iSourceSlot == null) {
            return;
        }
        if (!SourceController.isSourceIncluded(iSourceSlot.getSource(), iSourceArray)) {
            return;
        }
        ISource iSource = iSourceSlot.getSource();
        this.logger.main().log(1078071040, "[%1.slotsChanged] Selected source '%2' changed", (Object)"SourceController", (Object)iSource);
        if (!iSource.isActive()) {
            this.logger.main().log(1078071040, "[%1.slotsChanged] Source not active", (Object)"SourceController");
            return;
        }
        if (!iSource.isDeviceActivated() && iSource.isActivateable(iSourceSlot) && iSource.isLastSelectedSlot(iSourceSlot)) {
            ActivationContext activationContext = new ActivationContext(iSourceSlot);
            activationContext.addParameter("RESTORE_STATE", this.restoreLastPlaymodeAfterDeactivation);
            activationContext.addParameter("IS_STARTUP", Boolean.FALSE);
            activationContext.addParameter("RESTORE_BROWSER_PATH_POSSIBLE", iSourceSlot.getSource().getType() == 11 ? Boolean.FALSE : Boolean.TRUE);
            this.logger.main().log(1078071040, "[%1.slotsChanged] Active media available again. RestoreLastPlayModeAfterDeactivation = '%2', currentSelectedSourceSlot = '%3', id = '%4'.", (Object)"SourceController", (Object)Boolean.toString(this.restoreLastPlaymodeAfterDeactivation), (Object)iSourceSlot.getName(), (long)iSourceSlot.getDeviceIndex());
            this.triggerSourceActivation(activationContext, this.demuteOnActivation);
            return;
        }
        if (this.sourceActivationExtension.slotsChanged(iSourceArray, iSourceSlot)) {
            return;
        }
        this.updateActiveSourceState(iSourceSlot);
        this.hmiHandler.setActiveSlotSyncState(iSourceSlot);
        this.hmiHandler.setActiveMedia(iSourceSlot);
        this.hmiHandler.setActiveSourceSlot(iSourceSlot);
        this.hmiHandler.setActiveMediaCapabilities(iSourceSlot.getCapabilities());
        if (iSource.isDeviceActivated() && !iSource.isActivateable(iSourceSlot)) {
            this.logger.main().log(1078071040, "[%1.slotChanged] Active media unavailable.", (Object)"SourceController");
            this.getTerminal().getAudioManager().requestEntSuppression();
            this.getTerminal().getAudioManager().requestVolumelock("Active source unavailable.");
            if (iSourceSlot.getError() == 15 || iSourceSlot.getError() == 4) {
                this.logger.main().log(1078071040, "[%1.slotChanged] PULS detected.", (Object)"SourceController");
                this.restoreLastPlaymodeAfterDeactivation = true;
                this.demuteOnActivation = false;
            } else if (12 == iSource.getType()) {
                this.logger.main().log(1078071040, "[%1.slotChanged] WLAN deactivated.", (Object)"SourceController");
                this.restoreLastPlaymodeAfterDeactivation = true;
                this.demuteOnActivation = true;
            } else {
                this.restoreLastPlaymodeAfterDeactivation = false;
                this.demuteOnActivation = true;
                IContent iContent = this.getTerminal().getContentManager().getActiveContent();
                if (iContent != null) {
                    iContent.resetSettings();
                }
            }
            this.logger.main().log(-2137614336, "[%2.slotChanged] restorePlaymode='%1'.", this.restoreLastPlaymodeAfterDeactivation, (Object)"SourceController");
            this.getTerminal().getContentManager().deactivateActiveContent();
            iSource.deactivateSourceDevice();
            this.getTerminal().getTitlelineHMIHandler().resetIcons();
            this.getTerminal().getTitlelineHMIHandler().flush();
        }
    }

    private static boolean isSourceIncluded(ISource iSource, ISource[] iSourceArray) {
        for (int i2 = 0; i2 < iSourceArray.length; ++i2) {
            if (!iSourceArray[i2].equals(iSource)) continue;
            return true;
        }
        return false;
    }

    private void setOnLoading(boolean bl) {
        this.logger.main().log(1078071040, "[%1.setOnLoading] '%2'", (Object)"SourceController", (Object)(bl ? "LOADING" : "NOT LOADING"));
        this.onLoading = bl;
    }

    private boolean isOnLoading() {
        return this.onLoading;
    }

    private void updateActiveSourceState(ISourceSlot iSourceSlot) {
        int n = iSourceSlot.getError();
        int n2 = iSourceSlot.getState();
        if (n == 0) {
            if (!(this.isOnLoading() || n2 != 1 && n2 != 2)) {
                this.setOnLoading(true);
            }
            if (this.isOnLoading()) {
                boolean bl = n2 == 3;
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] %2", (Object)"SourceController", (Object)(bl ? "ON SOURCE CHANGE" : "LOADING"));
                this.notifyActiveSourceChanged(iSourceSlot, bl ? 3 : 2);
                return;
            }
            this.logger.main().log(1078071040, "[%1.updateActiveSourceState] READY", (Object)"SourceController");
            this.notifyActiveSourceChanged(iSourceSlot, 1);
            return;
        }
        switch (n) {
            case 1: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_WRONG_REGION_CODE_NO_CHANGES_LEFT", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 10);
                break;
            }
            case 2: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_WRONG_REGION_CODE_CHANGES_LEFT", (Object)"SourceController");
                int n3 = this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_DVDV_REGIONCODE_CHANGES_LEFT");
                this.getLabelModel(2047804160).setText(Integer.toString(n3));
                this.notifyActiveSourceChanged(iSourceSlot, 9);
                break;
            }
            case 3: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_CHILDLOCK.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 18);
                break;
            }
            case 16: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_UNREADABLE.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 5);
                break;
            }
            case 17: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_UNSUPPORTED.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 20);
                break;
            }
            case 18: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_UNSUPPORTED_WRONG_FIRMWARE.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 21);
                break;
            }
            case 23: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_CORRUPTED_PARTITION.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 26);
                break;
            }
            case 19: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_EMPTY.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 4);
                break;
            }
            case 4: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_IMPORT_RUNNING.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 16);
                break;
            }
            case 6: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_DELETION_RUNNING.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 17);
                break;
            }
            case 7: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_OVERCURRENT.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 19);
                break;
            }
            case 5: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_NO_PLAYABLE_FILES.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 8);
                break;
            }
            case 22: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_JUKEBOX_NOT_FILLED.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 24);
                break;
            }
            case 8: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_TEMPERATURE_TOO_HIGH.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 6);
                break;
            }
            case 9: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_TEMPERATURE_TOO_LOW.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 7);
                break;
            }
            case 15: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_DEVICE_UNAVAILABLE.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 25);
                break;
            }
            case 10: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_BT_AUDIOPLAYER_DEACTIVATED.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 14);
                break;
            }
            case 11: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_BT_AUDIOPLAYER_NOT_CONNECTED.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 15);
                break;
            }
            case 12: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_BT_DEACTIVATED.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 11);
                break;
            }
            case 13: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_BT_DEACTIVATED_CLAMP_S_OFF.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 12);
                break;
            }
            case 14: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_BT_RECONNECTING.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 13);
                break;
            }
            case 21: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_WLAN_DEACTIVATED.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 22);
                break;
            }
            case 20: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_WLAN_DEACTIVATED_CLAMP_S_OFF.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 23);
                break;
            }
            case 24: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_CHARGING.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 27);
                break;
            }
            case 25: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_ONLINE_DEACTIVATED_CLAMP_S_OFF.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 28);
                break;
            }
            case 27: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_ONLINE_DEACTIVATED_WLAN_NO_CONN.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 30);
                break;
            }
            case 26: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_ONLINE_DEACTIVATED_WLAN_OFF.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 29);
                break;
            }
            case 28: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_ONLINE_NO_APP.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 31);
                break;
            }
            case 29: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_WLAN_NO_DEVICE.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 32);
                break;
            }
            case 30: {
                this.logger.main().log(1078071040, "[%1.updateActiveSourceState] ERR_WLAN_NO_APP.", (Object)"SourceController");
                this.notifyActiveSourceChanged(iSourceSlot, 33);
                break;
            }
            default: {
                this.logger.main().log(-1601830656, "[%1.updateActiveSourceState] Unexpected media state error (e%2) ", (Object)"SourceController", (long)n);
            }
        }
    }

    @Override
    public void sourceDeviceActivated(ISourceSlot iSourceSlot, int n, boolean bl) {
        ISourceSlot iSourceSlot2 = this.getSelectedSlot();
        if (!bl) {
            if (iSourceSlot2 == null) {
                this.logger.main().log(1078071040, "[%1.sourceDeviceActivated] Pruning detected - Current active source slot is null.", (Object)"SourceController");
                return;
            }
            this.logger.main().log(1078071040, "[%1.sourceDeviceActivated] Pruning detected, device could not be activated.", (Object)"SourceController");
            iSourceSlot2.getSource().deactivateSourceDevice();
            return;
        }
        if (iSourceSlot2 != null && iSourceSlot.getSource().getType() != iSourceSlot2.getSource().getType()) {
            this.logger.main().log(1078071040, "[%1.sourceDeviceActivated] not same source -> ignore '%2'!='%3' ", (Object)"SourceController", (Object)iSourceSlot2, (Object)iSourceSlot);
            return;
        }
        iSourceSlot.getSource().sourceActivated(iSourceSlot);
        this.logger.main().log(1078071040, "[%1.sourceDeviceActivated] '%2'", (Object)"SourceController", (Object)iSourceSlot);
        if (iSourceSlot.getSource().getType() == 13) {
            this.getTerminal().getContentManager().activateContent(this.getActivationContext());
            return;
        }
        if (iSourceSlot.getSource().getType() == 8 || iSourceSlot.getSource().getType() == 7) {
            this.logger.main().log(1078071040, "[%1.sourceDeviceActivated] activate TV Content: %2 ", (Object)"SourceController", (Object)(iSourceSlot.getSource().getType() == 8 ? "AV" : "TV"));
            this.getTerminal().getContentManager().activateContent(this.getActivationContext());
            return;
        }
        if (iSourceSlot.getSource().getType() == 3) {
            this.getTerminal().getFramework().getMsgDistrib().sendMessage(201);
        }
        if (!((Object)iSourceSlot).equals(iSourceSlot2)) {
            this.logger.main().log(1078071040, "[%1.sourceDeviceActivated] Not selected source slot activated.", (Object)"SourceController");
            ActivationContext activationContext = new ActivationContext(iSourceSlot);
            if (iSourceSlot.getSource().getType() != 3) {
                activationContext.addParameter("RESTORE_STATE", Boolean.FALSE);
                activationContext.addParameter("IS_STARTUP", Boolean.FALSE);
            } else {
                activationContext.addParameter("RESTORE_STATE", this.getActivationContext().getParameter("RESTORE_STATE"));
                activationContext.addParameter("IS_STARTUP", this.getActivationContext().getParameter("IS_STARTUP"));
            }
            activationContext.addParameter("RESTORE_BROWSER_PATH_POSSIBLE", iSourceSlot.getSource().getType() == 11 ? Boolean.FALSE : Boolean.TRUE);
            this.setActivationContext(activationContext);
            this.switchToActiveMedia(iSourceSlot, true);
        } else {
            ((ActivationContext)this.getActivationContext()).updateSlot(iSourceSlot);
        }
        ((ActivationContext)this.getActivationContext()).addParameter("PHYSICAL_PLAYER_ID", new Integer(n));
        this.getTerminal().getContentManager().activateContent(this.getActivationContext());
    }

    @Override
    public void sourceDevicePending(long l) {
        ISourceSlot iSourceSlot = this.getActivationContext().getSlot();
        if (!(iSourceSlot instanceof MediaSourceSlot)) {
            this.logger.main().log(-1601830656, "[%1.sourceDevicePending] active slot is null or no mediaslot -> ignore ", (Object)"SourceController");
            return;
        }
        if (((MediaSourceSlot)iSourceSlot).getDeviceID() != l) {
            this.logger.main().log(-1601830656, "[%1.sourceDevicePending] pendingSource does not match active source -> ignore ", (Object)"SourceController");
            return;
        }
        this.logger.main().log(1078071040, "[%1.sourceDevicePending] active source is pending -> request Entertainment Suppression Connection ", (Object)"SourceController");
        this.getTerminal().getAudioManager().requestEntSuppression();
        this.setOnLoading(true);
        this.notifyActiveSourceChanged(iSourceSlot, 2);
    }

    @Override
    public void sourceDeviceDeactivated() {
        this.logger.main().log(1078071040, "[%1.sourceDeviceDeactivated] ", (Object)"SourceController");
        this.getTerminal().getFramework().getMsgDistrib().sendMessage(200);
    }

    @Override
    public void sourceActivationFailed() {
        DiscChangerSource discChangerSource;
        this.logger.main().log(1078071040, "[%1.sourceActivationFailed]", (Object)"SourceController");
        if (this.getSelectedSlot().getSource().getType() == 3 && (discChangerSource = (DiscChangerSource)this.getSelectedSlot().getSource()).wasWildCardActivation()) {
            this.reactivateSelectedSource(true);
        }
    }

    @Override
    public void contentActivationFinished(IContent iContent) {
        this.logger.main().log(1078071040, "[%1.contentActivationFinished] '%2'", (Object)"SourceController", (Object)LogUtil.getContentTypeStr(iContent.getContentType()));
        ISourceSlot iSourceSlot = iContent.getActiveSlot();
        if (iSourceSlot == null) {
            this.logger.main().log(1078071040, "[%1.contentActivationFinished] Content not active any more.", (Object)"SourceController");
            return;
        }
        ISourceSlot iSourceSlot2 = this.getSelectedSlot();
        if (iSourceSlot2 == null) {
            this.logger.main().log(1078071040, "[%1.contentActivationFinished] No selected source slot.", (Object)"SourceController");
            return;
        }
        if (!((Object)iSourceSlot2).equals(iSourceSlot)) {
            this.logger.main().log(1078071040, "[%1.contentActivationFinished] Active slot changed", (Object)"SourceController");
            return;
        }
        this.setOnLoading(false);
        this.updateActiveSourceState(iSourceSlot);
    }

    @Override
    public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
    }

    @Override
    public void contentDeactivated(IContent iContent) {
    }

    private boolean ipodAMIandA2DPSwitch(ISource[] iSourceArray) {
        int n;
        if (!this.getTerminal().getConfiguration().isSourceInstalled(11)) {
            this.logger.main().log(1078071040, "[%1.ipodAMIandA2DPSwitch] No BT source installed.", (Object)"SourceController");
            return false;
        }
        boolean bl = false;
        for (int i2 = 0; i2 < iSourceArray.length; ++i2) {
            n = iSourceArray[i2].getType();
            if (n != 11 && n != 10) continue;
            bl = true;
            break;
        }
        if (!bl) {
            return false;
        }
        ISourceSlot[] iSourceSlotArray = this.getIPodSlots();
        if (iSourceSlotArray != null) {
            for (n = 0; n < iSourceSlotArray.length; ++n) {
                if (!this.sourceChangeListener.handleConcurrentIPodConnection(this.getSource(11).getSlot(0), iSourceSlotArray[n])) continue;
                return true;
            }
        } else {
            this.logger.main().log(-1601830656, "[%1.ipodAMIandA2DPSwitch] IPod list is empty.", (Object)"SourceController");
        }
        return false;
    }

    private ISourceSlot[] getIPodSlots() {
        this.logger.main().log(1078071040, "[%1.getIPodSlot]", (Object)"SourceController");
        ISource iSource = this.getSource(10);
        if (null == iSource) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        ArrayList arrayList2 = new ArrayList(iSource.getSlots());
        Object[] objectArray = arrayList2.iterator();
        while (objectArray.hasNext()) {
            ISourceSlot iSourceSlot = (ISourceSlot)objectArray.next();
            if (null == iSourceSlot || 24 != iSourceSlot.getMediaType() || 24 == iSourceSlot.getError()) continue;
            this.logger.main().log(1078071040, "[%1.getIPodSlot] Found '%2'", (Object)"SourceController", (Object)iSourceSlot);
            arrayList.add(iSourceSlot);
        }
        objectArray = new ISourceSlot[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    @Override
    public void addSourceChangeListener(ISourceChangeListener iSourceChangeListener) {
        this.logger.main().log(1078071040, "[%1.addSourceChangeListener]", (Object)"SourceController");
        this.sourceChangeListener = iSourceChangeListener;
    }

    public ISourceChangeListener getSourceChangeListener() {
        return this.sourceChangeListener;
    }

    @Override
    public void dsiAvailable() {
    }

    @Override
    public void dsiUnavailable() {
        this.logger.main().log(1078071040, "[%1.dsiUnavailable] Player DSI unavailable.", (Object)"SourceController");
        ISourceSlot iSourceSlot = this.getSelectedSlot();
        if (iSourceSlot == null) {
            return;
        }
        ISource iSource = iSourceSlot.getSource();
        if (iSource.isDeviceActivated()) {
            this.logger.main().log(1078071040, "[%1.dsiUnavailable] Deactivate active media.", (Object)"SourceController");
            this.getTerminal().getAudioManager().requestEntSuppression();
            this.getTerminal().getAudioManager().requestVolumelock("Active source unavailable.");
            this.getTerminal().getContentManager().deactivateActiveContent();
            this.getTerminal().getTitlelineHMIHandler().resetIcons();
            this.getTerminal().getTitlelineHMIHandler().flush();
        }
    }

    @Override
    public void setSourceActivationExtension(ISourceActivationExtension iSourceActivationExtension) {
        if (null == iSourceActivationExtension) {
            this.sourceActivationExtension = this.noSourceActivationExtension;
            return;
        }
        this.sourceActivationExtension = iSourceActivationExtension;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("SourceController").append("@").append(this.hashCode());
        return buffer.toString();
    }

    static /* synthetic */ IMediaLogger access$000(SourceController sourceController) {
        return sourceController.logger;
    }

    static /* synthetic */ IMediaLogger access$100(SourceController sourceController) {
        return sourceController.logger;
    }

    static /* synthetic */ void access$200(SourceController sourceController, ISourceSlot iSourceSlot) {
        sourceController.setSelectedSlot(iSourceSlot);
    }

    static /* synthetic */ ISourceSlot access$300(SourceController sourceController) {
        return sourceController.selectedSourceSlot;
    }

    static /* synthetic */ void access$400(SourceController sourceController, ISourceSlot iSourceSlot, int n) {
        sourceController.notifyActiveSourceChanged(iSourceSlot, n);
    }
}

