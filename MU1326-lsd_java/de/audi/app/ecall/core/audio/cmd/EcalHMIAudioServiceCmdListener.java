/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.audio.cmd.EcalHMIAudioServiceCmdListener$1;
import de.audi.app.ecall.core.audio.cmd.EcalHMIAudioServiceCmdListener$2;
import de.audi.app.ecall.core.audio.cmd.EcalHMIAudioServiceCmdListener$3;
import de.audi.app.ecall.core.audio.cmd.EcalHMIAudioServiceCmdListener$4;
import de.audi.app.ecall.core.audio.cmd.EcalHMIAudioServiceCmdListener$5;
import de.audi.app.ecall.core.audio.cmd.EcalHMIAudioServiceCmdListener$6;
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

    @Override
    public void init() {
        this.hmiAudioServiceListener.startService();
    }

    @Override
    public void deinit() {
        this.hmiAudioServiceListener.stopService();
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.log.log(-2137614336, "[EcalHMIAudioServiceCmdListener#updateAMAvailable] available=%1", bl);
        CommandResponse.execute(this, new EcalHMIAudioServiceCmdListener$1(this, bl));
    }

    @Override
    public void stopConnection(int n, int n2) {
        this.log.log(-2137614336, "[EcalHMIAudioServiceCmdListener#stopConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new EcalHMIAudioServiceCmdListener$2(this, n, n2));
    }

    @Override
    public void pauseConnection(int n, int n2) {
        this.log.log(-2137614336, "[EcalHMIAudioServiceCmdListener#pauseConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new EcalHMIAudioServiceCmdListener$3(this, n, n2));
    }

    @Override
    public void startConnection(int n, int n2) {
        this.log.log(-2137614336, "[EcalHMIAudioServiceCmdListener#startConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new EcalHMIAudioServiceCmdListener$4(this, n, n2));
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        this.log.log(-2137614336, "[EcalHMIAudioServiceCmdListener#errorConnection] connection=%1, hmiTerminal=%2, errorCode=%3", (long)n, (long)n2, (long)n3);
        CommandResponse.execute(this, new EcalHMIAudioServiceCmdListener$5(this, n, n2, n3));
    }

    @Override
    public void fadedIn(int n, int n2) {
        this.log.log(-2137614336, "[EcalHMIAudioServiceCmdListener#fadedIn] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new EcalHMIAudioServiceCmdListener$6(this, n, n2));
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.log;
    }

    @Override
    public String getHandlerName() {
        return "EcallHMIAudioServiceCmdListener";
    }

    @Override
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

