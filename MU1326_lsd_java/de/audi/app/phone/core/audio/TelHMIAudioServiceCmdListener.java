/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelAudioCmdDefaultListener;
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

    public void init() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_PHONE);
        this.hmiAudioServiceListener = new PhoneServiceProvider((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = TelHMIAudioServiceCmdListener.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.hmiAudioServiceListener.startService();
    }

    public void deinit() {
        if (this.hmiAudioServiceListener != null) {
            this.hmiAudioServiceListener.stopService();
        }
    }

    public void updateAMAvailable(final boolean bl) {
        this.log.log(10000000, "[TelHMIAudioServiceCmdListener#updateAMAvailable] available=%1", bl);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ITelAudioCmdListener iTelAudioCmdListener = TelHMIAudioServiceCmdListener.this.defaultListener;
                try {
                    iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    TelHMIAudioServiceCmdListener.this.log.log(10000, "[TelHMIAudioServiceCmdListener#updateAMAvailable] %1", (Throwable)classCastException);
                }
                iTelAudioCmdListener.updateAMAvailable(bl);
            }
        });
    }

    public void stopConnection(final int n, final int n2) {
        this.log.log(10000000, "[TelHMIAudioServiceCmdListener#stopConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ITelAudioCmdListener iTelAudioCmdListener = TelHMIAudioServiceCmdListener.this.defaultListener;
                try {
                    iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    TelHMIAudioServiceCmdListener.this.log.log(10000, "[TelHMIAudioServiceCmdListener#stopConnection] %1", (Throwable)classCastException);
                }
                iTelAudioCmdListener.stopConnection(n, n2);
            }
        });
    }

    public void pauseConnection(final int n, final int n2) {
        this.log.log(10000000, "[TelHMIAudioServiceCmdListener#pauseConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ITelAudioCmdListener iTelAudioCmdListener = TelHMIAudioServiceCmdListener.this.defaultListener;
                try {
                    iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    TelHMIAudioServiceCmdListener.this.log.log(10000, "[TelHMIAudioServiceCmdListener#pauseConnection] %1", (Throwable)classCastException);
                }
                iTelAudioCmdListener.pauseConnection(n, n2);
            }
        });
    }

    public void startConnection(final int n, final int n2) {
        this.log.log(10000000, "[TelHMIAudioServiceCmdListener#startConnection] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ITelAudioCmdListener iTelAudioCmdListener = TelHMIAudioServiceCmdListener.this.defaultListener;
                try {
                    iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    TelHMIAudioServiceCmdListener.this.log.log(10000, "[TelHMIAudioServiceCmdListener#startConnection] %1", (Throwable)classCastException);
                }
                iTelAudioCmdListener.startConnection(n, n2);
            }
        });
    }

    public void errorConnection(final int n, final int n2, final int n3) {
        this.log.log(10000000, "[TelHMIAudioServiceCmdListener#errorConnection] connection=%1, hmiTerminal=%2, errorCode=%3", (long)n, (long)n2, (long)n3);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ITelAudioCmdListener iTelAudioCmdListener = TelHMIAudioServiceCmdListener.this.defaultListener;
                try {
                    iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    TelHMIAudioServiceCmdListener.this.log.log(10000, "[TelHMIAudioServiceCmdListener#errorConnection] %1", (Throwable)classCastException);
                }
                iTelAudioCmdListener.errorConnection(n, n2, n3);
            }
        });
    }

    public void fadedIn(final int n, final int n2) {
        this.log.log(10000000, "[TelHMIAudioServiceCmdListener#fadedIn] connection=%1, hmiTerminal=%2", (long)n, (long)n2);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ITelAudioCmdListener iTelAudioCmdListener = TelHMIAudioServiceCmdListener.this.defaultListener;
                try {
                    iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    TelHMIAudioServiceCmdListener.this.log.log(10000, "[TelHMIAudioServiceCmdListener#fadedIn] %1", (Throwable)classCastException);
                }
                iTelAudioCmdListener.fadedIn(n, n2);
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
        return "TelHMIAudioServiceCmdListener";
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

