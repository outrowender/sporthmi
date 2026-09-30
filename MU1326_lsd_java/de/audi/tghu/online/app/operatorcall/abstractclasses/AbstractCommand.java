/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.abstractclasses;

import de.audi.tghu.command.Command;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.commands.OperatorCallCommandList;
import org.dsi.ifc.online.DSIOperatorCallListener;
import org.dsi.ifc.online.OperatorCallResult;

public abstract class AbstractCommand
extends Command
implements DSIOperatorCallListener {
    public static final int CURRENT_STATE_CONNECTING = 0;
    public static final int CURRENT_STATE_CONNECTED = 1;
    public static final int CURRENT_STATE_HANGING_UP = 2;
    public static final int CURRENT_STATE_IDLE = 3;
    public static final int CURRENT_STATE_ERROR = 4;
    protected AbstractOperatorCall listener;
    private OperatorCallCommandList cmdList;

    public AbstractCommand(AbstractOperatorCall abstractOperatorCall, String string) {
        super(Online.getInstance().getOperatorCallLogChannel(), string);
        this.listener = abstractOperatorCall;
        this.logger.log(1000000, "AbstractCommand: Command = %1, listener is of type %2", (Object)this.getName(), (long)abstractOperatorCall.getServiceType());
    }

    public void setCommandList(ICommandList iCommandList) {
        if (iCommandList == null) {
            throw new NullPointerException("AbstractCommand#setCommandList: The CommandList is null!");
        }
        try {
            this.cmdList = (OperatorCallCommandList)iCommandList;
        }
        catch (ClassCastException classCastException) {
            this.logger.log(100000, "AbstractCommand#setCommandList: ClassCastException! The CommandList is not a CallcenterCallCommandList!", (Throwable)classCastException);
            this.listener.getModelHandler().showDefaultError(true, 1);
            throw classCastException;
        }
        super.setCommandList(this.cmdList);
    }

    public ICommandList getCommandList() {
        return super.getCommandList();
    }

    public OperatorCallCommandList getCmdList() {
        return this.cmdList;
    }

    public void responseOperatorCallResult(int n, OperatorCallResult[] operatorCallResultArray) {
        this.logger.log(100000, "AbstractCommand#responseOperatorCallResult: This command does not implement this method!");
    }

    public void responseOperatorPhoneNumber(int n, String string, String[] stringArray, int n2) {
        this.logger.log(100000, "AbstractCommand#responseOperatorPhoneNumber: This command does not implement this method!");
    }
}

