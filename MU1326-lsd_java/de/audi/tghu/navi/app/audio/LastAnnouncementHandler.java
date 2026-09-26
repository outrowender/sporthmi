/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.TMCGateway;
import de.audi.tghu.navi.app.audio.AudioStateMachine;
import de.audi.tghu.navi.app.command.AfaRepeatCommand;
import de.audi.tghu.navi.app.command.RequestAudioTriggerAbortCommand;
import de.audi.tghu.navi.app.map.MapInterface;

public final class LastAnnouncementHandler
implements ButtonListener {
    private LogChannel logChannel;
    AudioStateMachine audioStateMachine;
    private boolean announcementRepeatActive;
    private Monitor announcementRepeatMonitor;
    private final ICommandListFactory commandListFactory;
    private final TMCGateway tmcGateway;
    private final MapInterface mapInterface;

    public LastAnnouncementHandler(NavigationEnv navigationEnv, AudioStateMachine audioStateMachine, ICommandListFactory iCommandListFactory, MapInterface mapInterface, TMCGateway tMCGateway) {
        this.commandListFactory = iCommandListFactory;
        this.mapInterface = mapInterface;
        this.tmcGateway = tMCGateway;
        this.logChannel = navigationEnv.getAudioLogChannel();
        this.audioStateMachine = audioStateMachine;
        this.announcementRepeatActive = false;
        this.announcementRepeatMonitor = new Monitor(navigationEnv.getLogChannel());
        audioStateMachine.setLastAnnouncementHandler(this);
        navigationEnv.getButtonModel(1461650944).setButtonListener(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void repeatLastAnnouncement(int n) {
        this.logChannel.log(-2137614336, "LastAnnouncementHandler#repeatLastAnnouncement( %1 )", (long)n);
        long l = this.audioStateMachine.getLastAnnouncementTimestamp();
        int n2 = this.tmcGateway.repeatOrAbortTmcMessageReadOutSince(l);
        if (n2 == -1 || n2 == 1 || n2 == 2) {
            Monitor monitor = this.announcementRepeatMonitor;
            synchronized (monitor) {
                if (!this.announcementRepeatMonitor.isActive()) {
                    this.announcementRepeatActive = true;
                    CommandList commandList = this.commandListFactory.createCommandList(1);
                    commandList.addMonitor(this.announcementRepeatMonitor);
                    commandList.add(new RequestAudioTriggerAbortCommand(this.audioStateMachine, false));
                    commandList.add(new AfaRepeatCommand(n));
                    commandList.execute("LastAnnouncementHandler#repeatLastAnnouncement");
                } else {
                    this.logChannel.log(1078071040, "LastAnnouncementHandler#repeatLastAnnouncement() - repeating dismissed!");
                }
            }
        } else {
            this.logChannel.log(1078071040, "LastAnnouncementHandler#repeatLastAnnouncement() - not repeating last nav announcement. tmcRepeatResult: %1", (long)n2);
        }
    }

    public void repeatLastAnnouncementSimple(int n) {
        this.logChannel.log(-2137614336, "LastAnnouncementHandler#repeatLastAnnouncementSimple( %1 )", (long)n);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new AfaRepeatCommand(n));
        commandList.execute("LastAnnouncementHandler#repeatLastAnnouncementSimple");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateAudioRequest(int n) {
        this.logChannel.log(-2137614336, "LastAnnouncementHandler#updateAudioRequest( %1 )", (long)n);
        Monitor monitor = this.announcementRepeatMonitor;
        synchronized (monitor) {
            if (this.announcementRepeatActive && !this.announcementRepeatMonitor.isActive() && (n == 2 || n == 4)) {
                this.announcementRepeatActive = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isAnnouncementRepeatActive() {
        Monitor monitor = this.announcementRepeatMonitor;
        synchronized (monitor) {
            return this.announcementRepeatActive;
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "LastAnnouncementHandler#keyTyped( %1 )", (long)n);
        if (n == 1461650944) {
            this.repeatLastAnnoucment();
        }
    }

    public void repeatLastAnnoucment() {
        int n = this.mapInterface.isInAltRoutesSelection() ? 3 : 1;
        this.repeatLastAnnouncement(n);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }
}

