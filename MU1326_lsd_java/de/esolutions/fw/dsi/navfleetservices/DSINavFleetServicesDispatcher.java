/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.navfleetservices;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.navfleetservices.DSINavFleetServicesReply;
import de.esolutions.fw.comm.dsi.navfleetservices.impl.DSINavFleetServicesReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.navfleetservices.DSINavFleetServicesListener;

public class DSINavFleetServicesDispatcher
extends AbstractDispatcher
implements DSINavFleetServicesReply {
    private DSINavFleetServicesReplyService service = new DSINavFleetServicesReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$navfleetservices$DSINavFleetServicesListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSINavFleetServicesDispatcher(int n) {
        super(n, (class$org$dsi$ifc$navfleetservices$DSINavFleetServicesListener == null ? (class$org$dsi$ifc$navfleetservices$DSINavFleetServicesListener = DSINavFleetServicesDispatcher.class$("org.dsi.ifc.navfleetservices.DSINavFleetServicesListener")) : class$org$dsi$ifc$navfleetservices$DSINavFleetServicesListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void setVZOTrackerStateResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavFleetServicesListener dSINavFleetServicesListener = (DSINavFleetServicesListener)objectArray[i2];
                    dSINavFleetServicesListener.setVZOTrackerStateResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setVZODownloadStateResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavFleetServicesListener dSINavFleetServicesListener = (DSINavFleetServicesListener)objectArray[i2];
                    dSINavFleetServicesListener.setVZODownloadStateResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setLGITrackerStateResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavFleetServicesListener dSINavFleetServicesListener = (DSINavFleetServicesListener)objectArray[i2];
                    dSINavFleetServicesListener.setLGITrackerStateResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setLGIDownloadStateResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavFleetServicesListener dSINavFleetServicesListener = (DSINavFleetServicesListener)objectArray[i2];
                    dSINavFleetServicesListener.setLGIDownloadStateResult(n);
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
                    DSINavFleetServicesListener dSINavFleetServicesListener = (DSINavFleetServicesListener)objectArray[i2];
                    dSINavFleetServicesListener.asyncException(n, string, n2);
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
                    DSINavFleetServicesListener dSINavFleetServicesListener = (DSINavFleetServicesListener)objectArray[i2];
                    Method method = dSINavFleetServicesListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSINavFleetServicesDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSINavFleetServicesDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSINavFleetServicesListener, new Object[]{string, string2});
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

