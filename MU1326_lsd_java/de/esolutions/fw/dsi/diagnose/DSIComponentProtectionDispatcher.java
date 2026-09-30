/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diagnose;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.diagnose.DSIComponentProtectionReply;
import de.esolutions.fw.comm.dsi.diagnose.impl.DSIComponentProtectionReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.diagnose.DSIComponentProtectionListener;

public class DSIComponentProtectionDispatcher
extends AbstractDispatcher
implements DSIComponentProtectionReply {
    private DSIComponentProtectionReplyService service = new DSIComponentProtectionReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$diagnose$DSIComponentProtectionListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIComponentProtectionDispatcher(int n) {
        super(n, (class$org$dsi$ifc$diagnose$DSIComponentProtectionListener == null ? (class$org$dsi$ifc$diagnose$DSIComponentProtectionListener = DSIComponentProtectionDispatcher.class$("org.dsi.ifc.diagnose.DSIComponentProtectionListener")) : class$org$dsi$ifc$diagnose$DSIComponentProtectionListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void authStringResponse(String string, String string2, byte by) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIComponentProtectionListener dSIComponentProtectionListener = (DSIComponentProtectionListener)objectArray[i2];
                    dSIComponentProtectionListener.authStringResponse(string, string2, by);
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
                    DSIComponentProtectionListener dSIComponentProtectionListener = (DSIComponentProtectionListener)objectArray[i2];
                    dSIComponentProtectionListener.asyncException(n, string, n2);
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
                    DSIComponentProtectionListener dSIComponentProtectionListener = (DSIComponentProtectionListener)objectArray[i2];
                    Method method = dSIComponentProtectionListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIComponentProtectionDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIComponentProtectionDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIComponentProtectionListener, new Object[]{string, string2});
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

