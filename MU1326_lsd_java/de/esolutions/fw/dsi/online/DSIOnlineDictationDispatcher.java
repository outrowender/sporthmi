/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineDictationReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineDictationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.online.DSIOnlineDictationListener;
import org.dsi.ifc.online.DictationValueSentence;

public class DSIOnlineDictationDispatcher
extends AbstractDispatcher
implements DSIOnlineDictationReply {
    private DSIOnlineDictationReplyService service = new DSIOnlineDictationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineDictationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIOnlineDictationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$online$DSIOnlineDictationListener == null ? (class$org$dsi$ifc$online$DSIOnlineDictationListener = DSIOnlineDictationDispatcher.class$("org.dsi.ifc.online.DSIOnlineDictationListener")) : class$org$dsi$ifc$online$DSIOnlineDictationListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void dictationResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineDictationListener dSIOnlineDictationListener = (DSIOnlineDictationListener)objectArray[i2];
                    dSIOnlineDictationListener.dictationResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void finishDictationResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineDictationListener dSIOnlineDictationListener = (DSIOnlineDictationListener)objectArray[i2];
                    dSIOnlineDictationListener.finishDictationResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void dictationValueList(DictationValueSentence dictationValueSentence) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineDictationListener dSIOnlineDictationListener = (DSIOnlineDictationListener)objectArray[i2];
                    dSIOnlineDictationListener.dictationValueList(dictationValueSentence);
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
                    DSIOnlineDictationListener dSIOnlineDictationListener = (DSIOnlineDictationListener)objectArray[i2];
                    dSIOnlineDictationListener.asyncException(n, string, n2);
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
                    DSIOnlineDictationListener dSIOnlineDictationListener = (DSIOnlineDictationListener)objectArray[i2];
                    Method method = dSIOnlineDictationListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIOnlineDictationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIOnlineDictationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIOnlineDictationListener, new Object[]{string, string2});
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

