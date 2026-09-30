/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdListener;
import de.audi.app.ecall.core.osgi.EcallServiceProvider;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIListener;

class EcalHMIAudioServiceCmdListener
extends AbstractEcallComponent
implements ICommandResponseSupplier,
HMIAudioServiceListener {
    private final IEcallAudioCmdListener defaultListener;
    private final CommandListManager cmdListManager;
    private final EcallServiceProvider hmiAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;

    EcalHMIAudioServiceCmdListener(IEcallApplication iEcallApplication, IEcallAudioCmdListener iEcallAudioCmdListener, CommandListManager commandListManager) {
        super(iEcallApplication, "App.Ecall.Audio");
        this.defaultListener = iEcallAudioCmdListener;
        this.cmdListManager = commandListManager;
        Hashtable hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_ECALL);
        this.hmiAudioServiceListener = new EcallServiceProvider((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = EcalHMIAudioServiceCmdListener.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
    }

    public void init() {
        this.hmiAudioServiceListener.startService();
    }

    public void deinit() {
        this.hmiAudioServiceListener.stopService();
    }

    public void updateAMAvailable(final boolean bl) {
        this.log.log(10000000, "[EcalHMIAudioServiceCmdListener#updateAMAvailable] available=%1", bl);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                IEcallAudioCmdListener iEcallAudioCmdListener = (IEcallAudioCmdListener)dSIListener;
                iEcallAudioCmdListener.updateAMAvailable(bl);
            }
        });
    }

    public void stopConnection(final int n, final int n2) {
        this.log.log(10000000, "[EcalHMIAudioServiceCmdListener#stopConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                IEcallAudioCmdListener iEcallAudioCmdListener = (IEcallAudioCmdListener)dSIListener;
                iEcallAudioCmdListener.stopConnection(n, n2);
            }
        });
    }

    public void pauseConnection(final int n, final int n2) {
        this.log.log(10000000, "[EcalHMIAudioServiceCmdListener#pauseConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                IEcallAudioCmdListener iEcallAudioCmdListener = (IEcallAudioCmdListener)dSIListener;
                iEcallAudioCmdListener.pauseConnection(n, n2);
            }
        });
    }

    public void startConnection(final int n, final int n2) {
        this.log.log(10000000, "[EcalHMIAudioServiceCmdListener#startConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                IEcallAudioCmdListener iEcallAudioCmdListener = (IEcallAudioCmdListener)dSIListener;
                iEcallAudioCmdListener.startConnection(n, n2);
            }
        });
    }

    public void errorConnection(final int n, final int n2, final int n3) {
        this.log.log(10000000, "[EcalHMIAudioServiceCmdListener#errorConnection] connection=%1, hmiTerminal=%2, errorCode=%3", (long)n, (long)n2, (long)n3);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                IEcallAudioCmdListener iEcallAudioCmdListener = (IEcallAudioCmdListener)dSIListener;
                iEcallAudioCmdListener.errorConnection(n, n2, n3);
            }
        });
    }

    public void fadedIn(final int n, final int n2) {
        this.log.log(10000000, "[EcalHMIAudioServiceCmdListener#fadedIn] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                IEcallAudioCmdListener iEcallAudioCmdListener = (IEcallAudioCmdListener)dSIListener;
                iEcallAudioCmdListener.fadedIn(n, n2);
            }
        });
    }

    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    public LogChannel getLogChannel() {
        return this.log;
    }

    public String getHandlerName() {
        return "EcallHMIAudioServiceCmdListener";
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

