/*
 * Decompiled with CFR 0.152.
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
    public int getTerminalId();

    public ITerminalLogger getLogger();

    public IServiceManager getServiceManager();

    public IFrameworkAccess getFramework();

    public DispatcherBase getDispatcher();

    public IAudioManager getAudioManager();

    public ITerminalModeConfiguration getConfiguration();

    public void addActionProxyListener(int var1, IActionProxyListener var2);

    public void removeActionProxyListener(IActionProxyListener var1);

    public VirtualButtonModelApp getVirtualButtonModel(int var1);

    public ChoiceModelApp getChoiceModel(int var1);

    public ButtonModelApp getButtonModel(int var1);

    public LabelModelApp getLabelModel(int var1);

    public RangeModelApp getRangeModel(int var1);

    public void fireEventOnModel(int var1);

    public CommandListManager getCommandListManager();

    public CommandListHelper getCommandListHelper();

    public IDSISmartphoneManager getSmartphoneDSIManager();

    public IDiagnosisManager getDiagnosisManager();

    public PhoneAppHandler getPhoneAppHandler();

    public NaviAppHandler getNaviAppHandler();

    public IDeviceManager getDeviceManager();

    public INightDayModeHandler getNightDayModeHandler();

    public IEventBus getEventBus();

    public IActionProxyDispatcher getActionProxyDispatcher();

    public TMKeyEventsHandler getKeyEventsHandler();

    public TMVirtualButtonListener getTMKeyEventController();

    public ISmartphoneIntegrationDSIController getSMIDSIController();

    public HardKeyDSIListener getHardKeyDSIListener();

    public Object get(Class var1);

    public Object get(Object var1, Class var2);
}

