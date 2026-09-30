/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.telephoneng;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephoneng.DSIMobileEquipmentTopologyReply;
import de.esolutions.fw.comm.dsi.telephoneng.impl.DSIMobileEquipmentTopologyReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener;

public class DSIMobileEquipmentTopologyDispatcher
extends AbstractDispatcher
implements DSIMobileEquipmentTopologyReply {
    private DSIMobileEquipmentTopologyReplyService service = new DSIMobileEquipmentTopologyReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMobileEquipmentTopologyDispatcher(int n) {
        super(n, (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener = DSIMobileEquipmentTopologyDispatcher.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void responseChangeTopology(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMobileEquipmentTopologyListener dSIMobileEquipmentTopologyListener = (DSIMobileEquipmentTopologyListener)objectArray[i2];
                    dSIMobileEquipmentTopologyListener.responseChangeTopology(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateTopology(int[] nArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentTopologyListener dSIMobileEquipmentTopologyListener = (DSIMobileEquipmentTopologyListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMobileEquipmentTopologyListener);
                    dSIMobileEquipmentTopologyListener.updateTopology(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentTopologyListener dSIMobileEquipmentTopologyListener = (DSIMobileEquipmentTopologyListener)iterator.next();
                    dSIMobileEquipmentTopologyListener.updateTopology(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateUsage(int[] nArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentTopologyListener dSIMobileEquipmentTopologyListener = (DSIMobileEquipmentTopologyListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMobileEquipmentTopologyListener);
                    dSIMobileEquipmentTopologyListener.updateUsage(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentTopologyListener dSIMobileEquipmentTopologyListener = (DSIMobileEquipmentTopologyListener)iterator.next();
                    dSIMobileEquipmentTopologyListener.updateUsage(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void asyncException(int n, String string, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMobileEquipmentTopologyListener dSIMobileEquipmentTopologyListener = (DSIMobileEquipmentTopologyListener)objectArray[i2];
                    dSIMobileEquipmentTopologyListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void yyIndication(String string, String string2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMobileEquipmentTopologyListener dSIMobileEquipmentTopologyListener = (DSIMobileEquipmentTopologyListener)objectArray[i2];
                    Method method = dSIMobileEquipmentTopologyListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMobileEquipmentTopologyDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMobileEquipmentTopologyDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMobileEquipmentTopologyListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

