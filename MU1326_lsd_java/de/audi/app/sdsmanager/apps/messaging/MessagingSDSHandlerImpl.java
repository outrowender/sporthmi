/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.messaging;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSDSApplication;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.messaging.MessagingSDSHandler;
import de.audi.app.sdsmanager.apps.messaging.MsgContentSetInterface;
import de.audi.app.sdsmanager.apps.messaging.MsgReadoutFinishInterface;
import de.audi.app.sdsmanager.apps.messaging.MsgReadoutRecogInterface;
import de.audi.app.sdsmanager.apps.messaging.commands.MsgListHideCommand;
import de.audi.app.sdsmanager.apps.messaging.commands.MsgListLineSetCommand;
import de.audi.app.sdsmanager.apps.messaging.commands.MsgListShowCommand;
import de.audi.app.sdsmanager.apps.messaging.commands.MsgReadoutDetailCommand;
import de.audi.app.sdsmanager.apps.messaging.commands.MsgReadoutFinishCommand;
import de.audi.app.sdsmanager.apps.messaging.commands.MsgReadoutRecogCommand;
import de.audi.app.sdsmanager.apps.messaging.commands.MsgTypeSetCommand;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.IMessagingReadoutService;
import de.audi.atip.interapp.IMessagingReadoutServiceListener;
import de.audi.atip.interapp.def.NullMessagingReadoutService;
import de.audi.atip.interapp.def.NullMultipleMessageReadoutService;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutService;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;

public class MessagingSDSHandlerImpl
extends AbstractSDSApplication
implements MessagingSDSHandler,
IMessagingReadoutServiceListener,
IMultipleMessageReadoutServiceListener {
    private static final int[] commands = new int[]{75007, 75008, 75006, 75004, 75000, 75003, 75009};
    private LogChannel lc = Logger.getAppMessagingLog();
    private IMessagingReadoutService messagingService = new NullMessagingReadoutService(this.lc);
    private IMultipleMessageReadoutService multipleMessageService = new NullMultipleMessageReadoutService(this.lc);
    private final HMIService hmiService;
    private final ISDSPopupHelper sdsPopupHelper;
    private int selectedIndex = 0;

    public MessagingSDSHandlerImpl(HMIService hMIService, SDSHandlerService sDSHandlerService, ISDSPopupHelper iSDSPopupHelper) {
        super(sDSHandlerService, null);
        this.hmiService = hMIService;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.lc.log(10000000, "MessagingSDSHandlerImpl initialized.");
    }

    public int[] getCommands() {
        return commands;
    }

    public void processCommand(int n, ISystemCallParameter[] iSystemCallParameterArray) {
        this.lc.log(10000000, "MessagingSDSHandlerImpl#processCommand: id=%2, params=%1", (Object)SDSUtils.toString((Object[])iSystemCallParameterArray, false), (Object)SDSManagerBaseActivator.getSystemCallNames().getName(n));
        CommandList commandList = new CommandList(SDSManagerBaseActivator.getSysCallCmdListManager());
        switch (n) {
            case 75006: {
                this.lc.log(10000000, "MessagingSDSHandlerImpl#processCommand: MSG_LISTSHOW called!");
                commandList.add(new MsgListShowCommand(this.lc, "MSG_LISTSHOW", this.sdsHandlerService, this.sdsPopupHelper));
                commandList.execute("SYSTEMCALL MSG_LISTSHOW");
                break;
            }
            case 75007: {
                this.lc.log(10000000, "MessagingSDSHandlerImpl#processCommand: MSG_LISTHIDE called!");
                commandList.add(new MsgListHideCommand(this.lc, "MSG_LISTHIDE", this.sdsHandlerService, this.sdsPopupHelper));
                commandList.execute("SYSTEMCALL MSG_LISTHIDE");
                break;
            }
            case 75008: {
                this.lc.log(10000000, "MessagingSDSHandlerImpl#processCommand: MSG_LISTLINESET called!");
                commandList.add(new MsgListLineSetCommand(this.lc, "MSG_LISTLINESET", this.sdsHandlerService, this.hmiService));
                commandList.execute("SYSTEMCALL MSG_LISTLINESET");
                break;
            }
            case 75004: {
                this.lc.log(10000000, "MessagingSDSHandlerImpl#processCommand: MSG_READOUTDETAIL called!");
                commandList.add(new MsgReadoutDetailCommand(this.lc, "MSG_READOUTDETAIL", this.sdsHandlerService, this.messagingService));
                commandList.execute("SYSTEMCALL MSG_READOUTDETAIL");
                break;
            }
            case 75000: {
                this.lc.log(10000000, "MessagingSDSHandlerImpl#processCommand: MSG_READOUTFINISH called!");
                commandList.add(new MsgReadoutFinishCommand(this.lc, "MSG_READOUTFINISH", this.sdsHandlerService, this.messagingService));
                commandList.execute("SYSTEMCALL MSG_READOUTFINISH");
                break;
            }
            case 75003: {
                this.lc.log(10000000, "MessagingSDSHandlerImpl#processCommand: MSG_READOUTRECOG called!");
                commandList.add(new MsgReadoutRecogCommand(this.lc, "MSG_READOUTRECOG", this.sdsHandlerService, this.messagingService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL MSG_READOUTRECOG");
                break;
            }
            case 75009: {
                this.lc.log(10000000, "MessagingSDSHandlerImpl#processCommand: MSG_TYPESET called!");
                commandList.add(new MsgTypeSetCommand(this.lc, "MSG_TYPESET", this.sdsHandlerService, this.messagingService, iSystemCallParameterArray));
                commandList.execute("SYSTEMCALL MSG_TYPESET");
                break;
            }
            default: {
                this.lc.log(10000, "MessagingSDSHandlerImpl#processCommand: Unhandled id %1!", (long)n);
            }
        }
    }

    public boolean freezeLists() {
        this.lc.log(10000000, "MessagingSDSHandlerImpl#freezeLists: called");
        return this.messagingService.freezeDynamicLists() == 0;
    }

    public boolean unfreezeLists() {
        this.lc.log(10000000, "MessagingSDSHandlerImpl#unfreezeLists: called");
        return this.messagingService.unfreezeDynamicLists() == 0;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public String toString() {
        return "MessagingSDSHandlerImpl";
    }

    public void setMessagingReadoutService(IMessagingReadoutService iMessagingReadoutService) {
        if (iMessagingReadoutService == null) {
            return;
        }
        this.messagingService = iMessagingReadoutService;
    }

    public IMessagingReadoutService getMessagingReadoutService() {
        return this.messagingService;
    }

    public void unsetMessagingReadoutService() {
        this.messagingService = new NullMessagingReadoutService(this.lc);
    }

    public void responseReadoutMessage(int n) {
        this.lc.log(10000000, "MessagingSDSHandlerImpl#responseReadoutMessage: result=%1", (long)n);
        try {
            ((MsgReadoutDetailCommand)SDSUtils.getActiveSystemCall()).responseReadoutMessage(n);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MessagingSDSHandlerImpl#responseReadoutMessage: Active command is no MsgReadoutDetailCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(100000, "MessagingSDSHandlerImpl#responseReadoutMessage: NullpointerException. No active command!");
        }
    }

    public void responseBeginDialog(int n) {
        this.lc.log(10000000, "MessagingSDSHandlerImpl#responseBeginDialog: result=%1", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof MsgReadoutRecogInterface) {
            ((MsgReadoutRecogInterface)((Object)abstractSystemCallCommand)).responseBeginDialog(n);
        } else if (abstractSystemCallCommand instanceof MsgTypeSetCommand) {
            ((MsgTypeSetCommand)abstractSystemCallCommand).responseBeginDialog(n);
        } else {
            this.lc.log(100000, "MessagingSDSHandlerImpl#responseBeginDialog: No active command!");
        }
    }

    public void responseEndDialog(int n) {
        this.lc.log(10000000, "MessagingSDSHandlerImpl#responseEndDialog: result=%1", (long)n);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof MsgReadoutFinishInterface) {
            ((MsgReadoutFinishInterface)((Object)abstractSystemCallCommand)).responseEndDialog(n);
        } else if (abstractSystemCallCommand instanceof MsgTypeSetCommand) {
            ((MsgTypeSetCommand)abstractSystemCallCommand).responseEndDialog(n);
        } else {
            this.lc.log(100000, "MessagingSDSHandlerImpl#responseEndDialog: No active command!");
        }
    }

    public void indicateFolderContentListItemSelected(boolean bl) {
        this.lc.log(10000000, "MessagingSDSHandlerImpl#indicateFolderContentListItemSelected: isFolder=%1", bl);
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            this.lc.log(100000, "SMSDictationHandlerImpl#indicateFolderContentListItemSelected: No active command!");
            return;
        }
        if (abstractSystemCallCommand instanceof MsgListLineSetCommand) {
            ((MsgListLineSetCommand)abstractSystemCallCommand).indicateFolderSelection(bl);
            return;
        }
        this.lc.log(100000, "SMSDictationHandlerImpl#indicateFolderContentListItemSelected: active command is not MsgListLineSetCommand!");
    }

    public void setMultipleMessageReadoutService(IMultipleMessageReadoutService iMultipleMessageReadoutService) {
        if (iMultipleMessageReadoutService == null) {
            return;
        }
        this.multipleMessageService = iMultipleMessageReadoutService;
    }

    public IMultipleMessageReadoutService getMultipleMessageReadoutService() {
        return this.multipleMessageService;
    }

    public void unsetMultipleMessageReadoutService() {
        this.multipleMessageService = new NullMultipleMessageReadoutService(this.lc);
    }

    public void responseNextMessage(int n, String string) {
        this.lc.log(10000000, "MessagingSDSHandlerImplPorsche#responseNextMessage: result=%1", (long)n);
        try {
            ((MsgContentSetInterface)((Object)SDSUtils.getActiveSystemCall())).responseNextMessage(n, string);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "MessagingSDSHandlerImplPorsche#responseNextMessage: Active command doesn't implement the MsgContentSetInterface!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(100000, "MessagingSDSHandlerImplPorsche#responseNextMessage: NullpointerException. No active command!");
        }
    }
}

