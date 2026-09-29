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
    public static final int PHONE_MODULE_ID;
    public static final String MODULE_NAME;
    public static final String LOGCHANNEL_MAIN;
    public static final String LOGCHANNEL_AUDIO;
    public static final String LOGCHANNEL_AUDIO_CL;
    public static final String LOGCHANNEL_BAP;
    public static final String LOGCHANNEL_BAP_CL;
    public static final String LOGCHANNEL_LOCKSTATE;
    public static final String LOGCHANNEL_SEARCH;
    public static final String LOGCHANNEL_DSI;
    public static final String LOGCHANNEL_DSI_CL;
    public static final String LOGCHANNEL_STATE;
    public static final String LOGCHANNEL_DISPATCHER;
    public static final String LOGCHANNEL_STATE_DISPATCHER;
    public static final String LOGCHANNEL_STARTUP;
    public static final String LOGCHANNEL_FAVORITES;

    default public void init() {
    }

    default public void deinit() {
    }

    default public BundleContext getBundleContext() {
    }

    default public IFrameworkAccess getFrameworkAccess() {
    }

    default public IActionProxyDispatcher getActionProxyDispatcher() {
    }

    default public IGlobalTelephoneState getGlobalTelephoneStateManager() {
    }

    default public IPowerEventDispatcher getPowerEventDispatcher() {
    }

    default public IMessageDispatcher getMessageDispatcher() {
    }

    default public IPopupScreenStateDispatcher getPopupScreenStateDispatcher() {
    }

    default public ILanguageUpdateDispatcher getLanguageUpdateDispatcher() {
    }

    default public ITelephoneDSIAccess getTelephoneDSIAccess() {
    }

    default public void addDiagnosisComponent(IPhoneDiagComponent iPhoneDiagComponent) {
    }

    default public ITelDSIResponseListener getDefaultListener() {
    }

    default public ITelADBHandler getADBHandler() {
    }

    default public ITelCallControl getCallControl() {
    }

    default public ITelTextFactory getTextFactory() {
    }

    default public IEmergencyTextFactory geEmergencyTextFactory() {
    }

    default public ITelDialSuppServiceHandler getDialSuppServiceHandler() {
    }

    default public ITelAudio getAudio() {
    }

    default public ITelEPMHandler getEPMHandler() {
    }

    default public ITelBluetoothHandler getBluetoothHandler() {
    }

    default public void logStartupEvent(String string) {
    }

    default public ITelDSIResponseErrorHandler getDSIDefaultResponseErrorHandler() {
    }

    default public LogChannel getLogChannel(String string) {
    }

    default public TelEventQueue getTelEventQueue() {
    }

    default public void enqueueEvent(AbstractTelEvent abstractTelEvent) {
    }

    default public LogChannel getStartupLogChannel() {
    }
}

