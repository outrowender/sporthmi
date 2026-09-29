/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.ISourceChanger;
import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.base.TvTunerStateTracker$AudioFocusListener;
import de.audi.tv.app.base.TvTunerStateTracker$ChildLockListener;
import de.audi.tv.app.base.TvTunerStateTracker$InterappConnectionListener;
import de.audi.tv.app.base.TvTunerStateTracker$SM;
import de.audi.tv.app.base.TvTunerStateTracker$SwitchSourceListener;
import de.audi.tv.app.base.TvTunerStateTracker$TVEventListenerImpl;
import de.audi.tv.app.base.TvTunerStateTracker$TVListenerImpl;
import de.audi.tv.app.dsi.DSIHandler$DSIDownCallLock;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.interapp.IInterappConnectionListener;
import de.audi.tv.app.interapp.ISourceActivator;
import de.audi.tv.app.settings.parental.IChildLockListener;
import de.audi.tv.app.storage.TVStorage;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class TvTunerStateTracker {
    final DefaultTVListener tvListener = new TvTunerStateTracker$TVListenerImpl(this, null);
    final ITVEventListener tvEventListener = new TvTunerStateTracker$TVEventListenerImpl(this, null);
    final IAudioListener audioFocusListener = new TvTunerStateTracker$AudioFocusListener(this, null);
    final IChildLockListener childLockListener = new TvTunerStateTracker$ChildLockListener(this, null);
    final ISourceChanger switchSourceListener = new TvTunerStateTracker$SwitchSourceListener(this, null);
    final IInterappConnectionListener interappConnectionListener = new TvTunerStateTracker$InterappConnectionListener(this, null);
    private final TVEventDispatcher eventDistributor;
    private final LogChannel log;
    private final TvTunerStateTracker$SM sm;
    private final IAudioListener audioService;
    private final ISourceChanger sourceManager;
    private final ISourceActivator sourceActivator;
    private final DSIHandler$DSIDownCallLock dsiDownCallLock;
    private final TVStorage storage;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnknown;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$TunerUnavailable;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$StartUpMeta;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$ActivationMeta;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$EnergySavingMode;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitAndSdis;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$MainUnitOnly;
    static /* synthetic */ Class class$de$audi$tv$app$base$TvTunerStateTracker$SM$BaseState$Active$SdisOnly;

    TvTunerStateTracker(TVEventDispatcher tVEventDispatcher, LogChannel logChannel, DispatcherBase dispatcherBase, IAudioListener iAudioListener, ISourceChanger iSourceChanger, ISourceActivator iSourceActivator, DSIHandler$DSIDownCallLock dSIHandler$DSIDownCallLock, TVStorage tVStorage) {
        this.eventDistributor = tVEventDispatcher;
        this.log = logChannel;
        this.audioService = iAudioListener;
        this.sourceManager = iSourceChanger;
        this.sourceActivator = iSourceActivator;
        this.dsiDownCallLock = dSIHandler$DSIDownCallLock;
        this.storage = tVStorage;
        this.sm = new TvTunerStateTracker$SM(this, logChannel, dispatcherBase);
        this.sm.start();
    }

    void deinit() {
        this.sm.sendMessage(16);
    }

    public void setPendingSource(int n) {
        TvTunerStateTracker$SM.access$1602(this.sm, n);
    }

    static /* synthetic */ TvTunerStateTracker$SM access$600(TvTunerStateTracker tvTunerStateTracker) {
        return tvTunerStateTracker.sm;
    }

    static /* synthetic */ TVEventDispatcher access$700(TvTunerStateTracker tvTunerStateTracker) {
        return tvTunerStateTracker.eventDistributor;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ TVStorage access$800(TvTunerStateTracker tvTunerStateTracker) {
        return tvTunerStateTracker.storage;
    }

    static /* synthetic */ ISourceChanger access$900(TvTunerStateTracker tvTunerStateTracker) {
        return tvTunerStateTracker.sourceManager;
    }

    static /* synthetic */ DSIHandler$DSIDownCallLock access$1000(TvTunerStateTracker tvTunerStateTracker) {
        return tvTunerStateTracker.dsiDownCallLock;
    }

    static /* synthetic */ IAudioListener access$3400(TvTunerStateTracker tvTunerStateTracker) {
        return tvTunerStateTracker.audioService;
    }

    static /* synthetic */ LogChannel access$3600(TvTunerStateTracker tvTunerStateTracker) {
        return tvTunerStateTracker.log;
    }

    static /* synthetic */ ISourceActivator access$3800(TvTunerStateTracker tvTunerStateTracker) {
        return tvTunerStateTracker.sourceActivator;
    }
}

