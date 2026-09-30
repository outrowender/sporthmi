/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.listener;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import org.dsi.ifc.online.DSIOperatorCallListener;
import org.dsi.ifc.online.OperatorCallResult;

public class OperatorCallDefaultListener
implements DSIOperatorCallListener {
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();

    public void asyncException(int n, String string, int n2) {
    }

    public void responseOperatorCallResult(int n, OperatorCallResult[] operatorCallResultArray) {
        this.logChannel.log(100000, "OperatorCallDefaultListener#responseOperatorCallResult: no listener exists.");
    }

    public void responseOperatorPhoneNumber(int n, String string, String[] stringArray, int n2) {
        this.logChannel.log(100000, "OperatorCallDefaultListener#responseOperatorPhoneNumber: no listener exists.");
    }
}

