/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.audio.IAudioManager
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.CommandListHelper;
import de.audi.app.terminalmode.INightDayModeHandler;
import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.NaviAppHandler;
import de.audi.app.terminalmode.PhoneAppHandler;
import de.audi.app.terminalmode.actionproxy.IActionProxyDispatcher;
import de.audi.app.terminalmode.actionproxy.IActionProxyListener;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.diagnosis.IDiagnosisManager;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.keyevents.TMKeyEventsHandler;
import de.audi.app.terminalmode.keyevents.TMVirtualButtonListener;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.smartphone.HardKeyDSIListener;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public interface IContext {
    default public int getTerminalId() {
    }

    default public ITerminalLogger getLogger() {
    }

    default public IServiceManager getServiceManager() {
    }

    default public IFrameworkAccess getFramework() {
    }

    default public DispatcherBase getDispatcher() {
    }

    default public IAudioManager getAudioManager() {
    }

    default public ITerminalModeConfiguration getConfiguration() {
    }

    default public void addActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
    }

    default public void removeActionProxyListener(IActionProxyListener iActionProxyListener) {
    }

    default public VirtualButtonModelApp getVirtualButtonModel(int n) {
    }

    default public ChoiceModelApp getChoiceModel(int n) {
    }

    default public ButtonModelApp getButtonModel(int n) {
    }

    default public LabelModelApp getLabelModel(int n) {
    }

    default public RangeModelApp getRangeModel(int n) {
    }

    default public void fireEventOnModel(int n) {
    }

    default public CommandListManager getCommandListManager() {
    }

    default public CommandListHelper getCommandListHelper() {
    }

    default public IDSISmartphoneManager getSmartphoneDSIManager() {
    }

    default public IDiagnosisManager getDiagnosisManager() {
    }

    default public PhoneAppHandler getPhoneAppHandler() {
    }

    default public NaviAppHandler getNaviAppHandler() {
    }

    default public IDeviceManager getDeviceManager() {
    }

    default public INightDayModeHandler getNightDayModeHandler() {
    }

    default public IEventBus getEventBus() {
    }

    default public IActionProxyDispatcher getActionProxyDispatcher() {
    }

    default public TMKeyEventsHandler getKeyEventsHandler() {
    }

    default public TMVirtualButtonListener getTMKeyEventController() {
    }

    default public ISmartphoneIntegrationDSIController getSMIDSIController() {
    }

    default public HardKeyDSIListener getHardKeyDSIListener() {
    }

    default public Object get(Class clazz) {
    }

    default public Object get(Object object, Class clazz) {
    }
}

