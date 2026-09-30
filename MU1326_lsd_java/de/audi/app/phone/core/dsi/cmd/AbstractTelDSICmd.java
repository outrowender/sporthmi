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
    protected static final long DEFAULT_TIMEOUT = 75000L;
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

    public long getTimeout() {
        return 75000L;
    }

    protected int getTerminalID() {
        return this.terminalID;
    }

    public void responseAbortNetworkRegistration(int n) {
    }

    public void responseAbortNetworkSearch(int n) {
    }

    public void responseAcceptCall(int n) {
    }

    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
    }

    public void responseCallWaiting(int n, int n2) {
    }

    public void responseChangeSIMCode(int n, int n2) {
    }

    public void responseCLIR(int n, int n2, int n3) {
    }

    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    public void responseHangupCall(int n) {
    }

    public void responseJoinCalls(int n) {
    }

    public void responseNetworkRegistration(int n) {
    }

    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
    }

    public void responseRestoreFactorySettings(int n) {
    }

    public void responseSendDTMF(int n) {
    }

    public void responseServiceCodeAbort(int n) {
    }

    public void responseSetAutomaticEmergencyCallActive(int n) {
    }

    public void responseSetAutomaticPinEntryActive(int n) {
    }

    public void responseSetAutomaticRedialActive(int n) {
    }

    public void responseSetCDMAThreeWayCallingSetting(int n) {
    }

    public void responseSetESIMActive(int n) {
    }

    public void responseSetHandsFreeMode(int n) {
    }

    public void responseSetMailboxContent(int n) {
    }

    public void responseSetMICMuteState(int n) {
    }

    public void responseSetNADMode(int n, int n2) {
    }

    public void responseSetOptimizationMode(int n, int n2) {
    }

    public void responseSetPhoneReminderSetting(int n) {
    }

    public void responseSetPhoneRingtone(int n) {
    }

    public void responseSetPrivacyMode(int n) {
    }

    public void responseSIMPINRequired(int n) {
    }

    public void responseSplitCall(int n) {
    }

    public void responseSwapCalls(int n) {
    }

    public void responseTelPower(int n) {
    }

    public void responseUnlockOtherSIM(int n) {
    }

    public void responseUnlockSIM(int n) {
    }

    public void responseChangeTopology(int n) {
    }

    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
    }

    public void updateLockState(LockStateStruct lockStateStruct, int n) {
    }

    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }
}

