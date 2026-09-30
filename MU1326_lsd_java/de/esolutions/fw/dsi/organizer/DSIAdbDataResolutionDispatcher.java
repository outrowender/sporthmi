/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbDataResolutionReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbDataResolutionReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.organizer.DSIAdbDataResolutionListener;
import org.dsi.ifc.organizer.DataSet;

public class DSIAdbDataResolutionDispatcher
extends AbstractDispatcher
implements DSIAdbDataResolutionReply {
    private DSIAdbDataResolutionReplyService service = new DSIAdbDataResolutionReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbDataResolutionListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAdbDataResolutionDispatcher(int n) {
        super(n, (class$org$dsi$ifc$organizer$DSIAdbDataResolutionListener == null ? (class$org$dsi$ifc$organizer$DSIAdbDataResolutionListener = DSIAdbDataResolutionDispatcher.class$("org.dsi.ifc.organizer.DSIAdbDataResolutionListener")) : class$org$dsi$ifc$organizer$DSIAdbDataResolutionListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void resolveMailAddressResult(int n, DataSet[] dataSetArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbDataResolutionListener dSIAdbDataResolutionListener = (DSIAdbDataResolutionListener)objectArray[i2];
                    dSIAdbDataResolutionListener.resolveMailAddressResult(n, dataSetArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void resolvePhoneNumbersResult(int n, DataSet[] dataSetArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbDataResolutionListener dSIAdbDataResolutionListener = (DSIAdbDataResolutionListener)objectArray[i2];
                    dSIAdbDataResolutionListener.resolvePhoneNumbersResult(n, dataSetArray);
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
                    DSIAdbDataResolutionListener dSIAdbDataResolutionListener = (DSIAdbDataResolutionListener)objectArray[i2];
                    dSIAdbDataResolutionListener.asyncException(n, string, n2);
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
                    DSIAdbDataResolutionListener dSIAdbDataResolutionListener = (DSIAdbDataResolutionListener)objectArray[i2];
                    Method method = dSIAdbDataResolutionListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAdbDataResolutionDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAdbDataResolutionDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAdbDataResolutionListener, new Object[]{string, string2});
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

