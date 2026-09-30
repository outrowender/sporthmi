/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.has;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.has.DSIHASReply;
import de.esolutions.fw.comm.dsi.has.impl.DSIHASReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.has.DSIHASListener;
import org.dsi.ifc.has.HASDataContainer;

public class DSIHASDispatcher
extends AbstractDispatcher
implements DSIHASReply {
    private DSIHASReplyService service = new DSIHASReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$has$DSIHASListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIHASDispatcher(int n) {
        super(n, (class$org$dsi$ifc$has$DSIHASListener == null ? (class$org$dsi$ifc$has$DSIHASListener = DSIHASDispatcher.class$("org.dsi.ifc.has.DSIHASListener")) : class$org$dsi$ifc$has$DSIHASListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void actionRequest(int n, int n2, HASDataContainer[] hASDataContainerArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHASListener dSIHASListener = (DSIHASListener)objectArray[i2];
                    dSIHASListener.actionRequest(n, n2, hASDataContainerArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void subscribeRequest(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHASListener dSIHASListener = (DSIHASListener)objectArray[i2];
                    dSIHASListener.subscribeRequest(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void unsubscribeRequest(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHASListener dSIHASListener = (DSIHASListener)objectArray[i2];
                    dSIHASListener.unsubscribeRequest(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void unsubscribeAllRequest() throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHASListener dSIHASListener = (DSIHASListener)objectArray[i2];
                    dSIHASListener.unsubscribeAllRequest();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getPropertyRequest(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHASListener dSIHASListener = (DSIHASListener)objectArray[i2];
                    dSIHASListener.getPropertyRequest(n);
                    continue;
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
                    DSIHASListener dSIHASListener = (DSIHASListener)objectArray[i2];
                    dSIHASListener.asyncException(n, string, n2);
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
                    DSIHASListener dSIHASListener = (DSIHASListener)objectArray[i2];
                    Method method = dSIHASListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIHASDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIHASDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIHASListener, new Object[]{string, string2});
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

