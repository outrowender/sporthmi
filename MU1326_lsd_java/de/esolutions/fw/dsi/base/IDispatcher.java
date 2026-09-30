/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.dsi.diag.DispatcherInfo;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;

public interface IDispatcher {
    public IReplyService getService();

    public void addUnconfirmedNotificationListener(int var1, DSIListener var2);

    public void addNotificationListener(int var1, DSIListener var2);

    public void removeNotificationListener(int var1, DSIListener var2);

    public void removeNotificationListener(DSIListener var1);

    public boolean hasNotificationListeners(int var1);

    public Iterator getNotificationListenerIterator(int var1);

    public Iterator getUnconfirmedNotificationListenerIterator(int var1);

    public void confirmNotificationListener(int var1, DSIListener var2);

    public DispatcherInfo getDispatcherInfo(int var1);

    public void clearNotificationListeners();
}

