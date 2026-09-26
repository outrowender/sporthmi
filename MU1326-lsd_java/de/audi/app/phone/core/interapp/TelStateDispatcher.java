/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.interapp.TelStateDispatcher$1;
import de.audi.app.phone.core.interapp.TelStateDispatcher$TelServiceListenerTracker;
import de.audi.app.phone.core.interapp.TelStateImpl;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.phone.ITelState;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.LinkedList;

public class TelStateDispatcher
extends AbstractPhoneComponent {
    private final LinkedList listeners = new LinkedList();
    private final DispatcherBase dispatcher;
    private volatile ITelState telStateStruct;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelStateListener;

    public TelStateDispatcher(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.dispatcher = iTelApplication.getFrameworkAccess().getDispatcherManager().createDispatcher("TelStateDispatcher", new JobLogger(NullLogChannel.getInstance()));
        this.addSubPhoneComponent(new TelStateDispatcher$TelServiceListenerTracker(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.dispatcher.start();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.dispatcher.stop();
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 0x3000100 || n == 0xF000100 || n == 0x8000100 || n == 0x8000200) {
            TelStateImpl telStateImpl = new TelStateImpl(n, iGlobalTelephoneStateStruct);
            this.telStateStruct = telStateImpl;
            this.updateListeners(telStateImpl.getKey(), telStateImpl);
        }
    }

    private void updateListeners(int n, ITelState iTelState) {
        this.dispatcher.execute(new TelStateDispatcher$1(this, iTelState, n));
    }

    static /* synthetic */ LinkedList access$000(TelStateDispatcher telStateDispatcher) {
        return telStateDispatcher.listeners;
    }

    static /* synthetic */ LogChannel access$100(TelStateDispatcher telStateDispatcher) {
        return telStateDispatcher.log;
    }

    static /* synthetic */ LogChannel access$200(TelStateDispatcher telStateDispatcher) {
        return telStateDispatcher.log;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ITelState access$300(TelStateDispatcher telStateDispatcher) {
        return telStateDispatcher.telStateStruct;
    }
}

