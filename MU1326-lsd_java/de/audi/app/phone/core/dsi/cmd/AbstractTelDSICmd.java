/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipementResponseListener;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public abstract class AbstractTelDSICmd
extends Command
implements ITelDSIMobileEquipementResponseListener {
    protected static final long DEFAULT_TIMEOUT;
    protected final int terminalID;
    protected final ITelDSIResponseListener listener;

    protected static void schedule(CommandListManager commandListManager, Command command, String string, Command command2) {
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(command);
        commandList.setErrorCommand(command2);
        commandList.execute(string);
    }

    protected static void schedule(CommandListManager commandListManager, Command command, String string, Command command2, Monitor monitor) {
        CommandList commandList = new CommandList(commandListManager);
        commandList.addMonitor(monitor);
        commandList.add(command);
        commandList.setErrorCommand(command2);
        commandList.execute(string);
    }

    public AbstractTelDSICmd(LogChannel logChannel, String string, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(logChannel, string);
        this.terminalID = n;
        this.listener = iTelDSIResponseListener;
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    protected int getTerminalID() {
        return this.terminalID;
    }

    @Override
    public void responseAbortNetworkRegistration(int n) {
    }

    @Override
    public void responseAbortNetworkSearch(int n) {
    }

    @Override
    public void responseAcceptCall(int n) {
    }

    @Override
    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
    }

    @Override
    public void responseCallWaiting(int n, int n2) {
    }

    @Override
    public void responseChangeSIMCode(int n, int n2) {
    }

    @Override
    public void responseCLIR(int n, int n2, int n3) {
    }

    @Override
    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    @Override
    public void responseHangupCall(int n) {
    }

    @Override
    public void responseJoinCalls(int n) {
    }

    @Override
    public void responseNetworkRegistration(int n) {
    }

    @Override
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
    }

    @Override
    public void responseSendDTMF(int n) {
    }

    @Override
    public void responseServiceCodeAbort(int n) {
    }

    @Override
    public void responseSetAutomaticEmergencyCallActive(int n) {
    }

    @Override
    public void responseSetAutomaticPinEntryActive(int n) {
    }

    @Override
    public void responseSetAutomaticRedialActive(int n) {
    }

    @Override
    public void responseSetCDMAThreeWayCallingSetting(int n) {
    }

    @Override
    public void responseSetESIMActive(int n) {
    }

    @Override
    public void responseSetHandsFreeMode(int n) {
    }

    @Override
    public void responseSetMailboxContent(int n) {
    }

    @Override
    public void responseSetMICMuteState(int n) {
    }

    @Override
    public void responseSetNADMode(int n, int n2) {
    }

    @Override
    public void responseSetOptimizationMode(int n, int n2) {
    }

    @Override
    public void responseSetPhoneReminderSetting(int n) {
    }

    @Override
    public void responseSetPhoneRingtone(int n) {
    }

    @Override
    public void responseSetPrivacyMode(int n) {
    }

    @Override
    public void responseSIMPINRequired(int n) {
    }

    @Override
    public void responseSplitCall(int n) {
    }

    @Override
    public void responseSwapCalls(int n) {
    }

    @Override
    public void responseTelPower(int n) {
    }

    @Override
    public void responseUnlockOtherSIM(int n) {
    }

    @Override
    public void responseUnlockSIM(int n) {
    }

    @Override
    public void responseChangeTopology(int n) {
    }

    @Override
    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
    }

    @Override
    public void updateLockState(LockStateStruct lockStateStruct, int n) {
    }

    @Override
    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }
}

