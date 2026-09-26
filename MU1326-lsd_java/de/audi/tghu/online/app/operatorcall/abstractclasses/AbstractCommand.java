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
    public static final int CURRENT_STATE_CONNECTING;
    public static final int CURRENT_STATE_CONNECTED;
    public static final int CURRENT_STATE_HANGING_UP;
    public static final int CURRENT_STATE_IDLE;
    public static final int CURRENT_STATE_ERROR;
    protected AbstractOperatorCall listener;
    private OperatorCallCommandList cmdList;

    public AbstractCommand(AbstractOperatorCall abstractOperatorCall, String string) {
        super(Online.getInstance().getOperatorCallLogChannel(), string);
        this.listener = abstractOperatorCall;
        this.logger.log(1078071040, "AbstractCommand: Command = %1, listener is of type %2", (Object)this.getName(), (long)abstractOperatorCall.getServiceType());
    }

    @Override
    public void setCommandList(ICommandList iCommandList) {
        if (iCommandList == null) {
            throw new NullPointerException("AbstractCommand#setCommandList: The CommandList is null!");
        }
        try {
            this.cmdList = (OperatorCallCommandList)iCommandList;
        }
        catch (ClassCastException classCastException) {
            this.logger.log(-1601830656, "AbstractCommand#setCommandList: ClassCastException! The CommandList is not a CallcenterCallCommandList!", (Throwable)classCastException);
            this.listener.getModelHandler().showDefaultError(true, 1);
            throw classCastException;
        }
        super.setCommandList(this.cmdList);
    }

    @Override
    public ICommandList getCommandList() {
        return super.getCommandList();
    }

    public OperatorCallCommandList getCmdList() {
        return this.cmdList;
    }

    @Override
    public void responseOperatorCallResult(int n, OperatorCallResult[] operatorCallResultArray) {
        this.logger.log(-1601830656, "AbstractCommand#responseOperatorCallResult: This command does not implement this method!");
    }

    @Override
    public void responseOperatorPhoneNumber(int n, String string, String[] stringArray, int n2) {
        this.logger.log(-1601830656, "AbstractCommand#responseOperatorPhoneNumber: This command does not implement this method!");
    }
}

