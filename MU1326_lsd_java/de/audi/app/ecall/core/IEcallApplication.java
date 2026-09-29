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
    public static final String LOGCHANNEL_MAIN;
    public static final String LOGCHANNEL_SOS;
    public static final String LOGCHANNEL_OPR;
    public static final String LOGCHANNEL_AUDIO;
    public static final String LOGCHANNEL_AUDIO_CL;
    public static final String LOGCHANNEL_STATE_DISPATCHER;
    public static final int ECALL_MODULE_ID;
    public static final String MODULE_NAME;

    default public void init() {
    }

    default public void deinit() {
    }

    default public IFrameworkAccess getFrameworkAccess() {
    }

    default public void logStartupEvent(String string) {
    }

    default public BundleContext getBundleContext() {
    }

    default public void addDiagnosisComponent(IEcallDiagnosisComponent iEcallDiagnosisComponent) {
    }

    default public IActionProxyDispatcher getActionProxyDispatcher() {
    }

    default public IPowerEventDispatcher getPowerEventDispatcher() {
    }

    default public IPopupScreenStateDispatcher getPopupScreenStateDispatcher() {
    }

    default public LogChannel getEcallAppLogChannel() {
    }

    default public ISOSOpenClosePopupHandler getSOSPopupHandler() {
    }

    default public IOPROpenClosePopupHandler getOPRPopupHandler() {
    }

    default public SDSHandler getSDSHandler() {
    }

    default public IMessageDispatcher getMessageDispatcher() {
    }

    default public ITelServiceEcallHandler getTelServiceEcallHandler() {
    }

    default public IAudioConnectionHandler getAudioConnectionHandler() {
    }

    default public IGlobalEcallState getEcallStateManager() {
    }

    default public IEcallBapServiceAdapter getEcallBapServiceAdapter() {
    }
}

