/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelAudioCmdDefaultListener;
import de.audi.app.phone.core.audio.TelHMIAudioServiceCmdListener$1;
import de.audi.app.phone.core.audio.TelHMIAudioServiceCmdListener$2;
import de.audi.app.phone.core.audio.TelHMIAudioServiceCmdListener$3;
import de.audi.app.phone.core.audio.TelHMIAudioServiceCmdListener$4;
import de.audi.app.phone.core.audio.TelHMIAudioServiceCmdListener$5;
import de.audi.app.phone.core.audio.TelHMIAudioServiceCmdListener$6;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIListener;

public class TelHMIAudioServiceCmdListener
extends AbstractPhoneComponent
implements ICommandResponseSupplier,
HMIAudioServiceListener {
    private final ITelAudioCmdListener defaultListener;
    private final CommandListManager cmdListManager;
    private volatile PhoneServiceProvider hmiAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;

    public TelHMIAudioServiceCmdListener(ITelApplication iTelApplication, TelAudioCmdDefaultListener telAudioCmdDefaultListener, CommandListManager commandListManager) {
        super(iTelApplication, "App.Phone.Audio");
        this.defaultListener = telAudioCmdDefaultListener;
        this.cmdListManager = commandListManager;
    }

    @Override
    public void init() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_PHONE);
        this.hmiAudioServiceListener = new PhoneServiceProvider((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = TelHMIAudioServiceCmdListener.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.hmiAudioServiceListener.startService();
    }

    @Override
    public void deinit() {
        if (this.hmiAudioServiceListener != null) {
            this.hmiAudioServiceListener.stopService();
        }
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.log.log(-2137614336, "[TelHMIAudioServiceCmdListener#updateAMAvailable] available=%1", bl);
        CommandResponse.execute(this, new TelHMIAudioServiceCmdListener$1(this, bl));
    }

    @Override
    public void stopConnection(int n, int n2) {
        this.log.log(-2137614336, "[TelHMIAudioServiceCmdListener#stopConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new TelHMIAudioServiceCmdListener$2(this, n, n2));
    }

    @Override
    public void pauseConnection(int n, int n2) {
        this.log.log(-2137614336, "[TelHMIAudioServiceCmdListener#pauseConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new TelHMIAudioServiceCmdListener$3(this, n, n2));
    }

    @Override
    public void startConnection(int n, int n2) {
        this.log.log(-2137614336, "[TelHMIAudioServiceCmdListener#startConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new TelHMIAudioServiceCmdListener$4(this, n, n2));
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        this.log.log(-2137614336, "[TelHMIAudioServiceCmdListener#errorConnection] connection=%1, hmiTerminal=%2, errorCode=%3", (long)n, (long)n2, (long)n3);
        CommandResponse.execute(this, new TelHMIAudioServiceCmdListener$5(this, n, n2, n3));
    }

    @Override
    public void fadedIn(int n, int n2) {
        this.log.log(-2137614336, "[TelHMIAudioServiceCmdListener#fadedIn] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new TelHMIAudioServiceCmdListener$6(this, n, n2));
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
        return "TelHMIAudioServiceCmdListener";
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

    static /* synthetic */ ITelAudioCmdListener access$000(TelHMIAudioServiceCmdListener telHMIAudioServiceCmdListener) {
        return telHMIAudioServiceCmdListener.defaultListener;
    }

    static /* synthetic */ LogChannel access$100(TelHMIAudioServiceCmdListener telHMIAudioServiceCmdListener) {
        return telHMIAudioServiceCmdListener.log;
    }

    static /* synthetic */ LogChannel access$200(TelHMIAudioServiceCmdListener telHMIAudioServiceCmdListener) {
        return telHMIAudioServiceCmdListener.log;
    }

    static /* synthetic */ LogChannel access$300(TelHMIAudioServiceCmdListener telHMIAudioServiceCmdListener) {
        return telHMIAudioServiceCmdListener.log;
    }

    static /* synthetic */ LogChannel access$400(TelHMIAudioServiceCmdListener telHMIAudioServiceCmdListener) {
        return telHMIAudioServiceCmdListener.log;
    }

    static /* synthetic */ LogChannel access$500(TelHMIAudioServiceCmdListener telHMIAudioServiceCmdListener) {
        return telHMIAudioServiceCmdListener.log;
    }

    static /* synthetic */ LogChannel access$600(TelHMIAudioServiceCmdListener telHMIAudioServiceCmdListener) {
        return telHMIAudioServiceCmdListener.log;
    }
}

