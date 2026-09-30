/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core;

import de.audi.app.ecall.core.IOPROpenClosePopupHandler;
import de.audi.app.ecall.core.ISOSOpenClosePopupHandler;
import de.audi.app.ecall.core.ap.IActionProxyDispatcher;
import de.audi.app.ecall.core.audio.IAudioConnectionHandler;
import de.audi.app.ecall.core.bap.IEcallBapServiceAdapter;
import de.audi.app.ecall.core.bap.IGlobalEcallState;
import de.audi.app.ecall.core.msg.IMessageDispatcher;
import de.audi.app.ecall.core.power.IPowerEventDispatcher;
import de.audi.app.ecall.core.screen.IPopupScreenStateDispatcher;
import de.audi.app.ecall.core.sds.SDSHandler;
import de.audi.app.ecall.core.tel.ITelServiceEcallHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;
import org.osgi.framework.BundleContext;

public interface IEcallApplication {
    public static final String LOGCHANNEL_MAIN = "App.Ecall.Main";
    public static final String LOGCHANNEL_SOS = "App.Ecall.SOS";
    public static final String LOGCHANNEL_OPR = "App.Ecall.OPR";
    public static final String LOGCHANNEL_AUDIO = "App.Ecall.Audio";
    public static final String LOGCHANNEL_AUDIO_CL = "App.Ecall.Audio.CL";
    public static final String LOGCHANNEL_STATE_DISPATCHER = "App.Ecall.State.Dispatcher";
    public static final int ECALL_MODULE_ID = 33;
    public static final String MODULE_NAME = "AppEcall";

    public void init();

    public void deinit();

    public IFrameworkAccess getFrameworkAccess();

    public void logStartupEvent(String var1);

    public BundleContext getBundleContext();

    public void addDiagnosisComponent(IEcallDiagnosisComponent var1);

    public IActionProxyDispatcher getActionProxyDispatcher();

    public IPowerEventDispatcher getPowerEventDispatcher();

    public IPopupScreenStateDispatcher getPopupScreenStateDispatcher();

    public LogChannel getEcallAppLogChannel();

    public ISOSOpenClosePopupHandler getSOSPopupHandler();

    public IOPROpenClosePopupHandler getOPRPopupHandler();

    public SDSHandler getSDSHandler();

    public IMessageDispatcher getMessageDispatcher();

    public ITelServiceEcallHandler getTelServiceEcallHandler();

    public IAudioConnectionHandler getAudioConnectionHandler();

    public IGlobalEcallState getEcallStateManager();

    public IEcallBapServiceAdapter getEcallBapServiceAdapter();
}

