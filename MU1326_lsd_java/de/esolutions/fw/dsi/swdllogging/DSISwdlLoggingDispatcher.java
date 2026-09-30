/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.swdllogging;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swdllogging.DSISwdlLoggingReply;
import de.esolutions.fw.comm.dsi.swdllogging.impl.DSISwdlLoggingReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.swdllogging.DSISwdlLoggingListener;

public class DSISwdlLoggingDispatcher
extends AbstractDispatcher
implements DSISwdlLoggingReply {
    private DSISwdlLoggingReplyService service = new DSISwdlLoggingReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISwdlLoggingDispatcher(int n) {
        super(n, (class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener == null ? (class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener = DSISwdlLoggingDispatcher.class$("org.dsi.ifc.swdllogging.DSISwdlLoggingListener")) : class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void getHistory(String[] stringArray, int[] nArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlLoggingListener dSISwdlLoggingListener = (DSISwdlLoggingListener)objectArray[i2];
                    dSISwdlLoggingListener.getHistory(stringArray, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setUpdate(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlLoggingListener dSISwdlLoggingListener = (DSISwdlLoggingListener)objectArray[i2];
                    dSISwdlLoggingListener.setUpdate(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getGeneralInformation(boolean bl, String string, String string2, boolean bl2, String string3, String string4, int[] nArray, boolean bl3, int n, int[] nArray2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlLoggingListener dSISwdlLoggingListener = (DSISwdlLoggingListener)objectArray[i2];
                    dSISwdlLoggingListener.getGeneralInformation(bl, string, string2, bl2, string3, string4, nArray, bl3, n, nArray2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getUnusualEvents(int[] nArray, String[] stringArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlLoggingListener dSISwdlLoggingListener = (DSISwdlLoggingListener)objectArray[i2];
                    dSISwdlLoggingListener.getUnusualEvents(nArray, stringArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getUnusualEvent(int n, String string, String string2, String string3, byte by, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlLoggingListener dSISwdlLoggingListener = (DSISwdlLoggingListener)objectArray[i2];
                    dSISwdlLoggingListener.getUnusualEvent(n, string, string2, string3, by, n2);
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
                    DSISwdlLoggingListener dSISwdlLoggingListener = (DSISwdlLoggingListener)objectArray[i2];
                    dSISwdlLoggingListener.asyncException(n, string, n2);
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
                    DSISwdlLoggingListener dSISwdlLoggingListener = (DSISwdlLoggingListener)objectArray[i2];
                    Method method = dSISwdlLoggingListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISwdlLoggingDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISwdlLoggingDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISwdlLoggingListener, new Object[]{string, string2});
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

