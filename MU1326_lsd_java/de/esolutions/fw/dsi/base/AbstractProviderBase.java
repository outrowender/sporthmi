/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import de.esolutions.fw.dsi.base.IDispatcher;
import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.util.tracing.TraceChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public abstract class AbstractProviderBase
implements DSIBase {
    protected TraceChannel tracer;
    protected IDispatcher dispatcher;

    public AbstractProviderBase(IDispatcher iDispatcher) {
        this.dispatcher = iDispatcher;
        this.tracer = Channels.DSI_PROVIDER;
    }

    public abstract String getName();

    protected abstract int[] getAttributeIDs();

    protected abstract void setNotification(int var1);

    protected abstract void setNotification(int[] var1);

    protected abstract void setNotification();

    protected abstract void clearNotification(int var1);

    protected abstract void clearNotification(int[] var1);

    protected abstract void clearNotification();

    public final void setNotification(int n, DSIListener dSIListener) {
        if (dSIListener == null) {
            this.tracer.log((short)3, "setNotification without listener ");
            return;
        }
        this.dispatcher.addUnconfirmedNotificationListener(n, dSIListener);
        this.tracer.log((short)1, "DSI notification listener added: attribute=%1, listener=%2", (Object)String.valueOf(n), (Object)dSIListener.getClass().getName());
        this.setNotification(n);
    }

    public final void setNotification(int[] nArray, DSIListener dSIListener) {
        if (dSIListener == null) {
            this.tracer.log((short)3, "setNotification without listener ");
            return;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.dispatcher.addUnconfirmedNotificationListener(nArray[i2], dSIListener);
        }
        this.tracer.log((short)1, "DSI notification listener added: attributes=%1, listener=%2", nArray, (Object)dSIListener.getClass().getName());
        this.setNotification(nArray);
    }

    public final void setNotification(DSIListener dSIListener) {
        if (dSIListener == null) {
            this.tracer.log((short)3, "setNotification without listener ");
            return;
        }
        int[] nArray = this.getAttributeIDs();
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.dispatcher.addUnconfirmedNotificationListener(nArray[i2], dSIListener);
            }
            this.tracer.log((short)1, "DSI notification listener added: attributes=%1, listener=%2", nArray, (Object)dSIListener.getClass().getName());
            this.setNotification();
        }
    }

    public final void clearNotification(int n, DSIListener dSIListener) {
        this.dispatcher.removeNotificationListener(n, dSIListener);
        this.tracer.log((short)1, "DSI notification listener removed: attribute=%1, listener=%2", (Object)String.valueOf(n), (Object)dSIListener.getClass().getName());
        if (!this.dispatcher.hasNotificationListeners(n)) {
            this.clearNotification(n);
        }
    }

    public final void clearNotification(int[] nArray, DSIListener dSIListener) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.clearNotification(nArray[i2], dSIListener);
        }
    }

    public final void clearNotification(DSIListener dSIListener) {
        int[] nArray = this.getAttributeIDs();
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.clearNotification(nArray[i2], dSIListener);
            }
        }
    }

    public void yySet(String string, String string2) {
    }

    protected void traceException(Exception exception) {
        this.tracer.log((short)3, "Provider call not executed: class=%1 reason=%2", (Object)this.getClass().getName(), (Object)exception.getMessage());
        this.tracer.log((short)2, "Provider call not executed: exception=%1", exception);
    }
}

