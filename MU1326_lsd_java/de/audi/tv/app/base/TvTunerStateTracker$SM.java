/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.AbstractTunerState;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$TemporaryState;
import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.sm.StateMachine;
import de.audi.tv.app.util.sm.StateMachineInflator;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class TvTunerStateTracker$SM
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
    private final /* synthetic */ TvTunerStateTracker this$0;

    protected TvTunerStateTracker$SM(TvTunerStateTracker tvTunerStateTracker, LogChannel logChannel, DispatcherBase dispatcherBase) {
        this.this$0 = tvTunerStateTracker;
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
            this.setInitialState(this.getStateForClass(TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnknown == null ? (TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnknown = TvTunerStateTracker.class$("de.audi.tv.app.base.TvTunerStateTracker$SM$BaseState$TunerUnknown")) : TvTunerStateTracker.class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnknown));
        }
        catch (Exception exception) {
            logChannel.log(1000, "[TvTunerStateTracker.SM] unable to create state machine. Exception: %1", (Throwable)exception);
        }
        this.activeSourceType = TvTunerStateTracker.access$800(tvTunerStateTracker).getActiveSource();
    }

    @Override
    protected void unhandledMessage(Message message) {
        if (this.getCurrentState() instanceof TvTunerStateTracker.TemporaryState) {
            this.deferMessage(message);
        } else {
            super.unhandledMessage(message);
        }
    }

    protected void switchSource(int n, boolean bl) {
        if (n == 0 || n == 1) {
            this.activeSourceType = n;
            TvTunerStateTracker.access$900(this.this$0).switchSource(TVUtil.getTvTunerSourceRepresentation(n, this.isEsmHandlingRequired), bl);
        }
    }

    protected void changeEsmState(boolean bl, boolean bl2) {
        this.isLeavingESM = bl;
        if (bl) {
            TvTunerStateTracker.access$700((TvTunerStateTracker)this.this$0).tunerStatusListener.onDsiLockStateChanged(true);
            if (bl2) {
                TvTunerStateTracker.access$1000(this.this$0).acquire();
            }
        } else {
            if (bl2) {
                TvTunerStateTracker.access$1000(this.this$0).release();
            }
            TvTunerStateTracker.access$700((TvTunerStateTracker)this.this$0).tunerStatusListener.onDsiLockStateChanged(false);
        }
    }

    static /* synthetic */ boolean access$1102(TvTunerStateTracker$SM tvTunerStateTracker$SM, boolean bl) {
        tvTunerStateTracker$SM.isMUAudioFocusFromLastMode = bl;
        return tvTunerStateTracker$SM.isMUAudioFocusFromLastMode;
    }

    static /* synthetic */ boolean access$1200(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        return tvTunerStateTracker$SM.tvHasAudioFocusMU;
    }

    static /* synthetic */ boolean access$1202(TvTunerStateTracker$SM tvTunerStateTracker$SM, boolean bl) {
        tvTunerStateTracker$SM.tvHasAudioFocusMU = bl;
        return tvTunerStateTracker$SM.tvHasAudioFocusMU;
    }

    static /* synthetic */ TvTunerStateTracker access$1300(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        return tvTunerStateTracker$SM.this$0;
    }

    static /* synthetic */ boolean access$1400(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        return tvTunerStateTracker$SM.tvHasAudioFocusSDIS;
    }

    static /* synthetic */ boolean access$1402(TvTunerStateTracker$SM tvTunerStateTracker$SM, boolean bl) {
        tvTunerStateTracker$SM.tvHasAudioFocusSDIS = bl;
        return tvTunerStateTracker$SM.tvHasAudioFocusSDIS;
    }

    static /* synthetic */ boolean access$1500(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        return tvTunerStateTracker$SM.isSdisConnected;
    }

    static /* synthetic */ boolean access$1502(TvTunerStateTracker$SM tvTunerStateTracker$SM, boolean bl) {
        tvTunerStateTracker$SM.isSdisConnected = bl;
        return tvTunerStateTracker$SM.isSdisConnected;
    }

    static /* synthetic */ int access$1602(TvTunerStateTracker$SM tvTunerStateTracker$SM, int n) {
        tvTunerStateTracker$SM.activeSourceType = n;
        return tvTunerStateTracker$SM.activeSourceType;
    }

    static /* synthetic */ void access$1800(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ boolean access$1902(TvTunerStateTracker$SM tvTunerStateTracker$SM, boolean bl) {
        tvTunerStateTracker$SM.isTunerActive = bl;
        return tvTunerStateTracker$SM.isTunerActive;
    }

    static /* synthetic */ boolean access$2002(TvTunerStateTracker$SM tvTunerStateTracker$SM, boolean bl) {
        tvTunerStateTracker$SM.isEsmHandlingRequired = bl;
        return tvTunerStateTracker$SM.isEsmHandlingRequired;
    }

    static /* synthetic */ boolean access$2102(TvTunerStateTracker$SM tvTunerStateTracker$SM, boolean bl) {
        tvTunerStateTracker$SM.isStartUpConfigReceived = bl;
        return tvTunerStateTracker$SM.isStartUpConfigReceived;
    }

    static /* synthetic */ void access$2200(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ boolean access$1900(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        return tvTunerStateTracker$SM.isTunerActive;
    }

    static /* synthetic */ boolean access$2100(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        return tvTunerStateTracker$SM.isStartUpConfigReceived;
    }

    static /* synthetic */ boolean access$2300(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        return tvTunerStateTracker$SM.isLeavingESM;
    }

    static /* synthetic */ void access$2400(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ int access$1600(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        return tvTunerStateTracker$SM.activeSourceType;
    }

    static /* synthetic */ void access$2500(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ boolean access$2000(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        return tvTunerStateTracker$SM.isEsmHandlingRequired;
    }

    static /* synthetic */ void access$2600(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$2700(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$2800(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$2900(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$3000(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ boolean access$3100(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        return tvTunerStateTracker$SM.isChildLockEnabled;
    }

    static /* synthetic */ boolean access$3102(TvTunerStateTracker$SM tvTunerStateTracker$SM, boolean bl) {
        tvTunerStateTracker$SM.isChildLockEnabled = bl;
        return tvTunerStateTracker$SM.isChildLockEnabled;
    }

    static /* synthetic */ boolean access$1100(TvTunerStateTracker$SM tvTunerStateTracker$SM) {
        return tvTunerStateTracker$SM.isMUAudioFocusFromLastMode;
    }

    static /* synthetic */ void access$3200(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$3300(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$3700(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$3900(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4000(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4100(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4200(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4300(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4400(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4500(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4600(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4700(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4800(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$4900(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$5000(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$5100(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }

    static /* synthetic */ void access$5200(TvTunerStateTracker$SM tvTunerStateTracker$SM, Class clazz) {
        tvTunerStateTracker$SM.transitionTo(clazz);
    }
}

