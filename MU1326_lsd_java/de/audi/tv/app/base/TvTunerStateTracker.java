/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.ISourceChanger;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.base.AbstractTunerState;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.interapp.IInterappConnectionListener;
import de.audi.tv.app.interapp.ISourceActivator;
import de.audi.tv.app.settings.parental.IChildLockListener;
import de.audi.tv.app.storage.TVStorage;
import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.sm.StateMachine;
import de.audi.tv.app.util.sm.StateMachineInflator;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class TvTunerStateTracker {
    final DefaultTVListener tvListener = new TVListenerImpl();
    final ITVEventListener tvEventListener = new TVEventListenerImpl();
    final IAudioListener audioFocusListener = new AudioFocusListener();
    final IChildLockListener childLockListener = new ChildLockListener();
    final ISourceChanger switchSourceListener = new SwitchSourceListener();
    final IInterappConnectionListener interappConnectionListener = new InterappConnectionListener();
    private final TVEventDispatcher eventDistributor;
    private final LogChannel log;
    private final SM sm;
    private final IAudioListener audioService;
    private final ISourceChanger sourceManager;
    private final ISourceActivator sourceActivator;
    private final DSIHandler.DSIDownCallLock dsiDownCallLock;
    private final TVStorage storage;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnknown;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly;

    TvTunerStateTracker(TVEventDispatcher tVEventDispatcher, LogChannel logChannel, DispatcherBase dispatcherBase, IAudioListener iAudioListener, ISourceChanger iSourceChanger, ISourceActivator iSourceActivator, DSIHandler.DSIDownCallLock dSIDownCallLock, TVStorage tVStorage) {
        this.eventDistributor = tVEventDispatcher;
        this.log = logChannel;
        this.audioService = iAudioListener;
        this.sourceManager = iSourceChanger;
        this.sourceActivator = iSourceActivator;
        this.dsiDownCallLock = dSIDownCallLock;
        this.storage = tVStorage;
        this.sm = new SM(logChannel, dispatcherBase);
        this.sm.start();
    }

    void deinit() {
        this.sm.sendMessage(16);
    }

    public void setPendingSource(int n) {
        this.sm.activeSourceType = n;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public class SM
    extends StateMachine {
        private int activeSourceType;
        private boolean tvHasAudioFocusMU;
        private boolean tvHasAudioFocusSDIS;
        private boolean isSdisConnected;
        private boolean isEsmHandlingRequired;
        private boolean isChildLockEnabled;
        private boolean isStartUpConfigReceived;
        private boolean isTunerActive;
        private boolean isLeavingESM;
        private boolean isMUAudioFocusFromLastMode;

        protected SM(LogChannel logChannel, DispatcherBase dispatcherBase) {
            super("TV SM", logChannel, dispatcherBase, AbstractTunerState.getMessageCodeConverter());
            this.activeSourceType = 0;
            this.tvHasAudioFocusMU = false;
            this.tvHasAudioFocusSDIS = false;
            this.isSdisConnected = false;
            this.isEsmHandlingRequired = false;
            this.isChildLockEnabled = false;
            this.isStartUpConfigReceived = false;
            this.isTunerActive = false;
            this.isLeavingESM = true;
            this.isMUAudioFocusFromLastMode = false;
            StateMachineInflator stateMachineInflator = new StateMachineInflator(this);
            try {
                stateMachineInflator.inflate();
                this.setInitialState(this.getStateForClass(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnknown == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnknown = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnknown")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnknown));
            }
            catch (Exception exception) {
                logChannel.log(1000, "[TvTunerStateTracker.SM] unable to create state machine. Exception: %1", (Throwable)exception);
            }
            this.activeSourceType = TvTunerStateTracker.this.storage.getActiveSource();
        }

        protected void unhandledMessage(Message message) {
            if (this.getCurrentState() instanceof TemporaryState) {
                this.deferMessage(message);
            } else {
                super.unhandledMessage(message);
            }
        }

        protected void switchSource(int n, boolean bl) {
            if (n == 0 || n == 1) {
                this.activeSourceType = n;
                TvTunerStateTracker.this.sourceManager.switchSource(TVUtil.getTvTunerSourceRepresentation(n, this.isEsmHandlingRequired), bl);
            }
        }

        protected void changeEsmState(boolean bl, boolean bl2) {
            this.isLeavingESM = bl;
            if (bl) {
                ((TvTunerStateTracker)TvTunerStateTracker.this).eventDistributor.tunerStatusListener.onDsiLockStateChanged(true);
                if (bl2) {
                    TvTunerStateTracker.this.dsiDownCallLock.acquire();
                }
            } else {
                if (bl2) {
                    TvTunerStateTracker.this.dsiDownCallLock.release();
                }
                ((TvTunerStateTracker)TvTunerStateTracker.this).eventDistributor.tunerStatusListener.onDsiLockStateChanged(false);
            }
        }

        public class BaseState
        extends AbstractTunerState {
            protected void onMuGotAudioFocus(boolean bl) {
                SM.this.isMUAudioFocusFromLastMode = bl;
                if (!SM.this.tvHasAudioFocusMU) {
                    SM.this.tvHasAudioFocusMU = true;
                    ((TvTunerStateTracker)((SM)SM.this).TvTunerStateTracker.this).eventDistributor.audioListener.onMuGotTvAudioFocus(bl);
                }
            }

            protected void onMuLostAudioFocus() {
                if (SM.this.tvHasAudioFocusMU) {
                    SM.this.tvHasAudioFocusMU = false;
                    ((TvTunerStateTracker)((SM)SM.this).TvTunerStateTracker.this).eventDistributor.audioListener.onMuLostTvAudioFocus();
                }
            }

            protected void onSdisGotAudioFocus() {
                if (!SM.this.tvHasAudioFocusSDIS) {
                    SM.this.tvHasAudioFocusSDIS = true;
                    if (SM.this.isSdisConnected) {
                        ((TvTunerStateTracker)((SM)SM.this).TvTunerStateTracker.this).eventDistributor.audioListener.onSdisGotTvAudioFocus();
                    }
                }
            }

            protected void onSdisLostAudioFocus() {
                if (SM.this.tvHasAudioFocusSDIS) {
                    SM.this.tvHasAudioFocusSDIS = false;
                    if (SM.this.isSdisConnected) {
                        ((TvTunerStateTracker)((SM)SM.this).TvTunerStateTracker.this).eventDistributor.audioListener.onSdisLostTvAudioFocus();
                    }
                }
            }

            protected void onGotSdisConnection() {
                if (!SM.this.isSdisConnected) {
                    SM.this.isSdisConnected = true;
                    if (SM.this.tvHasAudioFocusSDIS) {
                        ((TvTunerStateTracker)((SM)SM.this).TvTunerStateTracker.this).eventDistributor.audioListener.onSdisGotTvAudioFocus();
                    }
                }
            }

            protected void onLostSdisConnection() {
                if (SM.this.isSdisConnected) {
                    SM.this.isSdisConnected = false;
                    if (SM.this.tvHasAudioFocusSDIS) {
                        ((TvTunerStateTracker)((SM)SM.this).TvTunerStateTracker.this).eventDistributor.audioListener.onSdisLostTvAudioFocus();
                    }
                }
            }

            protected void onFactoryReset() {
                SM.this.activeSourceType = 0;
            }

            protected void onEsmActivated() {
                SM.this.changeEsmState(true, false);
            }

            protected void onEsmDeactivated() {
                SM.this.changeEsmState(false, false);
            }

            public class Active
            extends AbstractTunerState {
                protected void onTunerDeactivated() {
                    SM.this.changeEsmState(true, false);
                    this.deactivateAudio();
                    ((TvTunerStateTracker)((SM)((BaseState)BaseState.this).SM.this).TvTunerStateTracker.this).eventDistributor.childLockListener.onChildLockDisabled();
                    SM.this.isTunerActive = false;
                    SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnavailable")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable);
                }

                protected void onDeinit() {
                    SM.this.isTunerActive = false;
                    SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnavailable")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable);
                }

                protected void onHighTemperatureShutdown() {
                    this.deactivateAudio();
                    if (SM.this.isEsmHandlingRequired) {
                        TvTunerStateTracker.this.sourceManager.switchSource(6, false);
                    }
                    ((TvTunerStateTracker)((SM)((BaseState)BaseState.this).SM.this).TvTunerStateTracker.this).eventDistributor.tunerStatusListener.onHighTemperatureShutdown();
                    SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode);
                }

                protected void onChildLockEnabled() {
                    if (!SM.this.isChildLockEnabled) {
                        SM.this.isChildLockEnabled = true;
                        ((TvTunerStateTracker)((SM)((BaseState)BaseState.this).SM.this).TvTunerStateTracker.this).eventDistributor.childLockListener.onChildLockEnabled();
                    }
                }

                protected void onChildLockDisabled() {
                    if (SM.this.isChildLockEnabled) {
                        SM.this.isChildLockEnabled = false;
                        ((TvTunerStateTracker)((SM)((BaseState)BaseState.this).SM.this).TvTunerStateTracker.this).eventDistributor.childLockListener.onChildLockDisabled();
                    }
                }

                protected void onMuLostAudioFocus() {
                    BaseState.this.onMuLostAudioFocus();
                    this.checkLostAllAudioFocus();
                }

                protected void onSdisLostAudioFocus() {
                    BaseState.this.onSdisLostAudioFocus();
                    this.checkLostAllAudioFocus();
                }

                protected void onLostSdisConnection() {
                    BaseState.this.onLostSdisConnection();
                    this.checkLostAllAudioFocus();
                }

                protected void onSourceSwitchRequested(int n) {
                    if (SM.this.isMUAudioFocusFromLastMode && n != SM.this.activeSourceType) {
                        SM.this.isMUAudioFocusFromLastMode = false;
                    }
                    SM.this.switchSource(n, !SM.this.isMUAudioFocusFromLastMode);
                }

                protected void onFactoryReset() {
                    BaseState.this.onFactoryReset();
                    SM.this.switchSource(SM.this.activeSourceType, false);
                }

                protected void onEsmActivated() {
                    if (SM.this.isEsmHandlingRequired) {
                        TvTunerStateTracker.this.sourceManager.switchSource(6, false);
                    }
                    SM.this.changeEsmState(true, true);
                    SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode);
                }

                private void checkLostAllAudioFocus() {
                    if (!(SM.this.tvHasAudioFocusMU || SM.this.tvHasAudioFocusSDIS && SM.this.isSdisConnected)) {
                        this.deactivateAudio();
                        if (SM.this.isEsmHandlingRequired) {
                            TvTunerStateTracker.this.sourceManager.switchSource(6, false);
                        }
                        SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode);
                    }
                }

                private void deactivateAudio() {
                    TvTunerStateTracker.this.audioService.onMuLostTvAudioFocus();
                    TvTunerStateTracker.this.audioService.onSdisLostTvAudioFocus();
                }

                public class SdisOnly
                extends AbstractTunerState {
                    protected void onMuGotAudioFocus(boolean bl) {
                        TvTunerStateTracker.this.audioService.onMuGotTvAudioFocus(bl);
                        BaseState.this.onMuGotAudioFocus(bl);
                        SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis);
                    }
                }

                public class MainUnitOnly
                extends AbstractTunerState {
                    protected void onSdisGotAudioFocus() {
                        BaseState.this.onSdisGotAudioFocus();
                        if (SM.this.isSdisConnected) {
                            TvTunerStateTracker.this.audioService.onSdisGotTvAudioFocus();
                            SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis);
                        }
                    }

                    protected void onGotSdisConnection() {
                        BaseState.this.onGotSdisConnection();
                        if (SM.this.tvHasAudioFocusSDIS) {
                            TvTunerStateTracker.this.audioService.onSdisGotTvAudioFocus();
                            SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis);
                        }
                    }
                }

                public class ActivationMeta
                extends AbstractTunerState
                implements TemporaryState {
                    public void enter(Message message) {
                        if (!SM.this.isLeavingESM) {
                            this.onEsmDeactivated();
                        }
                        SM.this.changeEsmState(false, false);
                    }

                    protected void onEsmActivated() {
                        Active.this.onEsmActivated();
                    }

                    protected void onEsmDeactivated() {
                        ((TvTunerStateTracker)((SM)((BaseState)((Active)Active.this).BaseState.this).SM.this).TvTunerStateTracker.this).eventDistributor.tunerStatusListener.onEsmLeft();
                        if (SM.this.tvHasAudioFocusMU && SM.this.tvHasAudioFocusSDIS && SM.this.isSdisConnected) {
                            TvTunerStateTracker.this.audioService.onMuGotTvAudioFocus(SM.this.isMUAudioFocusFromLastMode);
                            TvTunerStateTracker.this.audioService.onSdisGotTvAudioFocus();
                            SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis);
                        } else if (SM.this.tvHasAudioFocusMU) {
                            TvTunerStateTracker.this.audioService.onMuGotTvAudioFocus(SM.this.isMUAudioFocusFromLastMode);
                            SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly);
                        } else if (SM.this.tvHasAudioFocusSDIS && SM.this.isSdisConnected) {
                            TvTunerStateTracker.this.audioService.onSdisGotTvAudioFocus();
                            SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$SdisOnly")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly);
                        } else {
                            TvTunerStateTracker.this.log.log(10000, "[SM.ActivationMeta.onEsmDeactivated] no MU AudioFocus and (no SDIS available or no SDIS AudioFocus) ... returning to ESM");
                            if (SM.this.isEsmHandlingRequired) {
                                TvTunerStateTracker.this.sourceManager.switchSource(6, false);
                            }
                            SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode);
                        }
                    }
                }

                public class MainUnitAndSdis
                extends AbstractTunerState {
                    protected void onMuLostAudioFocus() {
                        TvTunerStateTracker.this.audioService.onMuLostTvAudioFocus();
                        BaseState.this.onMuLostAudioFocus();
                        SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$SdisOnly")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly);
                    }

                    protected void onSdisLostAudioFocus() {
                        TvTunerStateTracker.this.audioService.onSdisLostTvAudioFocus();
                        BaseState.this.onSdisLostAudioFocus();
                        SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly);
                    }

                    protected void onLostSdisConnection() {
                        TvTunerStateTracker.this.audioService.onSdisLostTvAudioFocus();
                        BaseState.this.onLostSdisConnection();
                        SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly);
                    }
                }

                public class EnergySavingMode
                extends AbstractTunerState {
                    public void enter(Message message) {
                        TvTunerStateTracker.this.log.log(1000000, "[TvTunerStateTracker.EnergySavingMode.enter] entering ESM  %1", (Object)message);
                        ((TvTunerStateTracker)((SM)((BaseState)((Active)Active.this).BaseState.this).SM.this).TvTunerStateTracker.this).eventDistributor.tunerStatusListener.onEsmEntered();
                    }

                    protected void onTunerDeactivated() {
                        TvTunerStateTracker.this.log.log(1000000, "[TvTunerStateTracker.EnergySavingMode.onTunerDeactivated]");
                        SM.this.changeEsmState(true, false);
                        ((TvTunerStateTracker)((SM)((BaseState)((Active)Active.this).BaseState.this).SM.this).TvTunerStateTracker.this).eventDistributor.childLockListener.onChildLockDisabled();
                        TvTunerStateTracker.this.dsiDownCallLock.release();
                        SM.this.isTunerActive = false;
                        SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnavailable")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable);
                    }

                    protected void onMuGotAudioFocus(boolean bl) {
                        BaseState.this.onMuGotAudioFocus(bl);
                        TvTunerStateTracker.this.dsiDownCallLock.release();
                        SM.this.switchSource(SM.this.activeSourceType, !bl);
                        TvTunerStateTracker.this.sourceActivator.activate(SM.this.activeSourceType);
                        SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$ActivationMeta")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta);
                    }

                    protected void onSdisGotAudioFocus() {
                        BaseState.this.onSdisGotAudioFocus();
                        if (SM.this.isSdisConnected) {
                            TvTunerStateTracker.this.dsiDownCallLock.release();
                            SM.this.switchSource(SM.this.activeSourceType, false);
                            SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$ActivationMeta")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta);
                        }
                    }

                    protected void onGotSdisConnection() {
                        BaseState.this.onGotSdisConnection();
                        if (SM.this.tvHasAudioFocusSDIS) {
                            TvTunerStateTracker.this.dsiDownCallLock.release();
                            SM.this.switchSource(SM.this.activeSourceType, false);
                            SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$ActivationMeta")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta);
                        }
                    }

                    protected void onMuLostAudioFocus() {
                        BaseState.this.onMuLostAudioFocus();
                    }

                    protected void onSdisLostAudioFocus() {
                        BaseState.this.onSdisLostAudioFocus();
                    }

                    protected void onLostSdisConnection() {
                        BaseState.this.onLostSdisConnection();
                    }

                    protected void onFactoryReset() {
                        TvTunerStateTracker.this.dsiDownCallLock.release();
                        Active.this.onFactoryReset();
                    }

                    protected void onEsmActivated() {
                        TvTunerStateTracker.this.log.log(1000000, "[TvTunerStateTracker.EnergySavingMode.onEsmActivated]");
                        SM.this.changeEsmState(true, true);
                    }

                    protected void onEsmDeactivated() {
                        TvTunerStateTracker.this.log.log(1000000, "[TvTunerStateTracker.EnergySavingMode.onEsmDeactivated]");
                        SM.this.changeEsmState(false, true);
                        if (SM.this.tvHasAudioFocusMU || SM.this.tvHasAudioFocusSDIS && SM.this.isSdisConnected) {
                            SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$ActivationMeta")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta);
                        }
                    }
                }
            }

            public class StartUpMeta
            extends AbstractTunerState
            implements TemporaryState {
                public void enter(Message message) {
                    if (SM.this.tvHasAudioFocusMU || SM.this.tvHasAudioFocusSDIS && SM.this.isSdisConnected) {
                        SM.this.switchSource(SM.this.activeSourceType, false);
                        SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$ActivationMeta")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta);
                    } else {
                        if (SM.this.isEsmHandlingRequired) {
                            TvTunerStateTracker.this.sourceManager.switchSource(6, false);
                        } else {
                            SM.this.switchSource(SM.this.activeSourceType, false);
                        }
                        SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode);
                    }
                }

                protected void onDeinit() {
                    SM.this.isTunerActive = false;
                    SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnavailable")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable);
                }
            }

            public class TunerUnknown
            extends AbstractTunerState {
                protected void onMuGotAudioFocus(boolean bl) {
                    BaseState.this.onMuGotAudioFocus(bl);
                    SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnavailable")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable);
                }

                protected void onTunerActivated() {
                    SM.this.isTunerActive = true;
                }

                protected void onStartUpMUConfig(StartUpConfig startUpConfig) {
                    SM.this.isEsmHandlingRequired = TVUtil.doesTunerRequireHmiEsmHandling(startUpConfig);
                    ((TvTunerStateTracker)((SM)((BaseState)BaseState.this).SM.this).TvTunerStateTracker.this).eventDistributor.tunerStatusListener.onTunerAvailable();
                    SM.this.isStartUpConfigReceived = true;
                    SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$StartUpMeta")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta);
                }
            }

            public class TunerUnavailable
            extends AbstractTunerState {
                public void enter(Message message) {
                    ((TvTunerStateTracker)((SM)((BaseState)BaseState.this).SM.this).TvTunerStateTracker.this).eventDistributor.tunerStatusListener.onTunerUnavailable();
                }

                public void exit(Message message) {
                    ((TvTunerStateTracker)((SM)((BaseState)BaseState.this).SM.this).TvTunerStateTracker.this).eventDistributor.tunerStatusListener.onTunerAvailable();
                }

                protected void onStartUpMUConfig(StartUpConfig startUpConfig) {
                    SM.this.isEsmHandlingRequired = TVUtil.doesTunerRequireHmiEsmHandling(startUpConfig);
                    SM.this.isStartUpConfigReceived = true;
                    this.makeStartTransition();
                }

                protected void onTunerActivated() {
                    SM.this.isTunerActive = true;
                    this.makeStartTransition();
                }

                private void makeStartTransition() {
                    if (SM.this.isTunerActive && SM.this.isStartUpConfigReceived) {
                        if (!SM.this.isLeavingESM && (SM.this.tvHasAudioFocusMU || SM.this.tvHasAudioFocusSDIS && SM.this.isSdisConnected)) {
                            ((TvTunerStateTracker)((SM)((BaseState)BaseState.this).SM.this).TvTunerStateTracker.this).eventDistributor.tunerStatusListener.onEsmLeft();
                        }
                        SM.this.transitionTo(class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta == null ? (class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$StartUpMeta")) : class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta);
                    }
                }
            }
        }
    }

    private class TVListenerImpl
    extends DefaultTVListener {
        private TVListenerImpl() {
        }

        public void updateMessageService(int n) {
            boolean bl = n == 1;
            TvTunerStateTracker.this.sm.sendMessage(bl ? 9 : 10);
            if (n == 3) {
                TvTunerStateTracker.this.sm.sendMessage(15);
            }
        }

        public void updateTunerState(int n) {
            boolean bl = n == 1;
            TvTunerStateTracker.this.sm.sendMessage(bl ? 6 : 7);
        }

        public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
            TvTunerStateTracker.this.sm.sendMessage(8, startUpConfig);
        }
    }

    private static interface TemporaryState {
    }

    private class ChildLockListener
    implements IChildLockListener {
        private ChildLockListener() {
        }

        public void onChildLockEnabled() {
            TvTunerStateTracker.this.sm.sendMessage(0);
        }

        public void onChildLockDisabled() {
            TvTunerStateTracker.this.sm.sendMessage(1);
        }

        public void parentalLevelSettingChanged(int n) {
            ((TvTunerStateTracker)TvTunerStateTracker.this).eventDistributor.childLockListener.parentalLevelSettingChanged(n);
        }
    }

    private class AudioFocusListener
    implements IAudioListener {
        private AudioFocusListener() {
        }

        public void onMuGotTvAudioFocus(boolean bl) {
            TvTunerStateTracker.this.sm.sendMessage(2, bl ? Boolean.TRUE : Boolean.FALSE);
        }

        public void onMuLostTvAudioFocus() {
            TvTunerStateTracker.this.sm.sendMessage(3);
        }

        public void onSdisGotTvAudioFocus() {
            TvTunerStateTracker.this.sm.sendMessage(4);
        }

        public void onSdisLostTvAudioFocus() {
            TvTunerStateTracker.this.sm.sendMessage(5);
        }

        public void onMuteChange(boolean bl) {
        }
    }

    private class TVEventListenerImpl
    extends TVEventDefaultListener {
        private TVEventListenerImpl() {
        }

        public void makeFactoryReset() {
            TvTunerStateTracker.this.sm.sendMessage(12);
        }
    }

    private class SwitchSourceListener
    implements ISourceChanger {
        private SwitchSourceListener() {
        }

        public void switchSource(int n, boolean bl) {
            TvTunerStateTracker.this.sm.sendMessage(11, n);
        }
    }

    private class InterappConnectionListener
    implements IInterappConnectionListener {
        private InterappConnectionListener() {
        }

        public void onGotInterappConnection() {
            TvTunerStateTracker.this.sm.sendMessage(13);
        }

        public void onLostInterappConnection() {
            TvTunerStateTracker.this.sm.sendMessage(14);
        }
    }
}

