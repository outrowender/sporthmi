/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.interapp.TelStateImpl;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.atip.interapp.phone.ITelState;
import de.audi.atip.interapp.phone.ITelStateListener;
import de.audi.atip.job.JobLogger;
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
        this.addSubPhoneComponent(new TelServiceListenerTracker(iTelApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.dispatcher.start();
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.dispatcher.stop();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 65539 || n == 65551 || n == 65544 || n == 131080) {
            TelStateImpl telStateImpl = new TelStateImpl(n, iGlobalTelephoneStateStruct);
            this.telStateStruct = telStateImpl;
            this.updateListeners(telStateImpl.getKey(), telStateImpl);
        }
    }

    private void updateListeners(final int n, final ITelState iTelState) {
        this.dispatcher.execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                LinkedList linkedList;
                Object object = TelStateDispatcher.this.listeners;
                synchronized (object) {
                    linkedList = (LinkedList)TelStateDispatcher.this.listeners.clone();
                }
                object = linkedList.iterator();
                while (object.hasNext()) {
                    try {
                        ITelStateListener iTelStateListener = (ITelStateListener)object.next();
                        TelStateDispatcher.this.log.log(1000000, "[TelStateDispatcher.updateListeners(...).new Runnable() {...}#run] listener=%1, state=%2", (Object)iTelStateListener, (Object)iTelState);
                        iTelStateListener.updateTelState(n, iTelState);
                    }
                    catch (Exception exception) {
                        TelStateDispatcher.this.log.log(100000, "[TelStateDispatcher.updateListeners(...).new Runnable() {...}#run] exception occured: ", (Throwable)exception);
                    }
                }
            }
        });
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class TelServiceListenerTracker
    extends AbstractTelServiceTracker {
        public TelServiceListenerTracker(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", class$de$audi$atip$interapp$phone$ITelStateListener == null ? (class$de$audi$atip$interapp$phone$ITelStateListener = TelStateDispatcher.class$("de.audi.atip.interapp.phone.ITelStateListener")) : class$de$audi$atip$interapp$phone$ITelStateListener);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void serviceAvailable(Object object) {
            this.log.log(1000000, "[TelStateDispatcher.TelServiceListenerTracker#serviceAvailable] %1", object);
            LinkedList linkedList = TelStateDispatcher.this.listeners;
            synchronized (linkedList) {
                TelStateDispatcher.this.listeners.add(object);
                ITelState iTelState = TelStateDispatcher.this.telStateStruct;
                if (iTelState != null) {
                    ITelStateListener iTelStateListener = (ITelStateListener)object;
                    this.log.log(1000000, "[TelStateDispatcher.TelServiceListenerTracker#serviceAvailable] listener=%1, state=%2", (Object)iTelStateListener, (Object)iTelState);
                    iTelStateListener.updateTelState(0, iTelState);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void serviceRemoved(Object object) {
            this.log.log(1000000, "[TelStateDispatcher.TelServiceListenerTracker#serviceRemoved] %1", object);
            LinkedList linkedList = TelStateDispatcher.this.listeners;
            synchronized (linkedList) {
                TelStateDispatcher.this.listeners.remove(object);
            }
        }
    }
}

