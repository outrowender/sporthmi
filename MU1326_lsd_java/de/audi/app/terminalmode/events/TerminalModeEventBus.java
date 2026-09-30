/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.events.CallStateChangedEvent;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.events.IEventListener;
import de.audi.app.terminalmode.events.PhoneStateChangedEvent;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.esolutions.fw.util.commons.job.DispatcherBase;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TerminalModeEventBus
implements IEventBus {
    private final GCopyOnWriteList<IEventListener> listeners = Generics.newCopyOnWriteArrayList();
    private final LogChannel lc;
    private final DispatcherBase dispatcher;

    public TerminalModeEventBus(LogChannel logChannel, DispatcherBase dispatcherBase) {
        this.lc = logChannel;
        this.dispatcher = dispatcherBase;
    }

    @Override
    public void updateNowPlayingData(final TrackDataChangedEvent trackDataChangedEvent) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.updateNowPlayingData"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.updateNowPlayingData] %1", (Object)trackDataChangedEvent);
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).updateNowPlayingData(trackDataChangedEvent);
                }
            }
        });
    }

    @Override
    public void updatePlaybackInfo(final PlaybackInfoChangedEvent playbackInfoChangedEvent) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.updatePlaybackInfo"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.updatePlaybackInfo] %1", (Object)playbackInfoChangedEvent);
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).updatePlaybackInfo(playbackInfoChangedEvent);
                }
            }
        });
    }

    @Override
    public void updatePlayPosition(final TrackPlayPositionEvent trackPlayPositionEvent) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.updatePlayPosition"){

            public void run() {
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).updatePlayPosition(trackPlayPositionEvent);
                }
            }
        });
    }

    @Override
    public void requestUserDecision(final TMDevice tMDevice) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.requestUserDecision"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.requestUserDecision] %1", (Object)tMDevice);
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).requestUserDecision(tMDevice);
                }
            }
        });
    }

    @Override
    public void readyForActivation(final TMDevice tMDevice) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.readyForActivation"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.readyForActivation] %1", (Object)tMDevice);
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).readyForActivation(tMDevice);
                }
            }
        });
    }

    @Override
    public void startupFinished() {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.startupFinished"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.startupFinished]");
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).startupFinished();
                }
            }
        });
    }

    @Override
    public void deviceActivated(final TMDevice tMDevice) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.deviceActivated"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.deviceActivated] %1", (Object)tMDevice);
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).deviceActivated(tMDevice);
                }
            }
        });
    }

    @Override
    public void mediaAudioAvailable(final boolean bl) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.mediaAudioAvailable"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.mediaAudioAvailable] %1", bl);
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).mediaAudioAvailable(bl);
                }
            }
        });
    }

    @Override
    public void updateKombiStage(final boolean bl) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.updateKombiState"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.updateKombiStage] %1", bl);
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).updateKombiStage(bl);
                }
            }
        });
    }

    @Override
    public void triggerBigStage() {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.triggerBigStage"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.triggerBigStage]");
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).triggerBigStage();
                }
            }
        });
    }

    @Override
    public void updatePhoneState(final PhoneStateChangedEvent phoneStateChangedEvent) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.updatePhoneState"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.updatePhoneState]");
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).updatePhoneState(phoneStateChangedEvent);
                }
            }
        });
    }

    @Override
    public boolean registerListener(IEventListener iEventListener) {
        return this.listeners.addIfAbsent(iEventListener);
    }

    @Override
    public boolean unregisterListener(IEventListener iEventListener) {
        return this.listeners.remove(iEventListener);
    }

    @Override
    public void updateCallState(final GList<CallStateChangedEvent> gList) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.updateCallState"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.updateCallState]");
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).updateCallState(gList);
                }
            }
        });
    }

    @Override
    public void callNumber(final String string) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.callNumber"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.callNumber]");
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).callNumber(string);
                }
            }
        });
    }

    @Override
    public void endCall() {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TerminalModeEventBus.endCall"){

            public void run() {
                TerminalModeEventBus.this.lc.log(1000000, "<*> [TerminalModeEventBus.endCall]");
                GIterator gIterator = TerminalModeEventBus.this.listeners.iterator();
                while (gIterator.hasNext()) {
                    ((IEventListener)gIterator.next()).endCall();
                }
            }
        });
    }
}

