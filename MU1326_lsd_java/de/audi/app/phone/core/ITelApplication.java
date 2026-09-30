/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.ITelTextFactory;
import de.audi.app.phone.core.adb.ITelADBHandler;
import de.audi.app.phone.core.ap.IActionProxyDispatcher;
import de.audi.app.phone.core.audio.ITelAudio;
import de.audi.app.phone.core.bluetooth.ITelBluetoothHandler;
import de.audi.app.phone.core.callcontrol.ITelCallControl;
import de.audi.app.phone.core.dsi.ITelDSIResponseErrorHandler;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.ITelephoneDSIAccess;
import de.audi.app.phone.core.emergency.IEmergencyTextFactory;
import de.audi.app.phone.core.epm.ITelEPMHandler;
import de.audi.app.phone.core.event.AbstractTelEvent;
import de.audi.app.phone.core.event.TelEventQueue;
import de.audi.app.phone.core.lang.ILanguageUpdateDispatcher;
import de.audi.app.phone.core.msg.IMessageDispatcher;
import de.audi.app.phone.core.power.IPowerEventDispatcher;
import de.audi.app.phone.core.screen.IPopupScreenStateDispatcher;
import de.audi.app.phone.core.state.IGlobalTelephoneState;
import de.audi.app.phone.core.suppservices.ITelDialSuppServiceHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import org.osgi.framework.BundleContext;

public interface ITelApplication {
    public static final int PHONE_MODULE_ID = 3;
    public static final String MODULE_NAME = "AppPhone";
    public static final String LOGCHANNEL_MAIN = "App.Phone.Main";
    public static final String LOGCHANNEL_AUDIO = "App.Phone.Audio";
    public static final String LOGCHANNEL_AUDIO_CL = "App.Phone.Audio.CL";
    public static final String LOGCHANNEL_BAP = "App.Phone.BAP";
    public static final String LOGCHANNEL_BAP_CL = "App.Phone.BAP.CL";
    public static final String LOGCHANNEL_LOCKSTATE = "App.Phone.LockState";
    public static final String LOGCHANNEL_SEARCH = "App.Phone.Search";
    public static final String LOGCHANNEL_DSI = "App.Phone.DSI";
    public static final String LOGCHANNEL_DSI_CL = "App.Phone.DSI.CL";
    public static final String LOGCHANNEL_STATE = "App.Phone.State";
    public static final String LOGCHANNEL_DISPATCHER = "App.Phone.Dispatcher";
    public static final String LOGCHANNEL_STATE_DISPATCHER = "App.Phone.State.Dispatcher";
    public static final String LOGCHANNEL_STARTUP = "App.Phone.Startup";
    public static final String LOGCHANNEL_FAVORITES = "App.Phone.Favorites";

    public void init();

    public void deinit();

    public BundleContext getBundleContext();

    public IFrameworkAccess getFrameworkAccess();

    public IActionProxyDispatcher getActionProxyDispatcher();

    public IGlobalTelephoneState getGlobalTelephoneStateManager();

    public IPowerEventDispatcher getPowerEventDispatcher();

    public IMessageDispatcher getMessageDispatcher();

    public IPopupScreenStateDispatcher getPopupScreenStateDispatcher();

    public ILanguageUpdateDispatcher getLanguageUpdateDispatcher();

    public ITelephoneDSIAccess getTelephoneDSIAccess();

    public void addDiagnosisComponent(IPhoneDiagComponent var1);

    public ITelDSIResponseListener getDefaultListener();

    public ITelADBHandler getADBHandler();

    public ITelCallControl getCallControl();

    public ITelTextFactory getTextFactory();

    public IEmergencyTextFactory geEmergencyTextFactory();

    public ITelDialSuppServiceHandler getDialSuppServiceHandler();

    public ITelAudio getAudio();

    public ITelEPMHandler getEPMHandler();

    public ITelBluetoothHandler getBluetoothHandler();

    public void logStartupEvent(String var1);

    public ITelDSIResponseErrorHandler getDSIDefaultResponseErrorHandler();

    public LogChannel getLogChannel(String var1);

    public TelEventQueue getTelEventQueue();

    public void enqueueEvent(AbstractTelEvent var1);

    public LogChannel getStartupLogChannel();
}

