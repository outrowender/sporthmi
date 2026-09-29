/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.env.LogUtils;
import org.apache.commons.scxml.model.SCXML;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.TransitionTarget;

public class SimpleErrorReporter
implements ErrorReporter,
Serializable {
    private static final long serialVersionUID;
    private Log log = LogFactory.getLog(super.getClass());

    @Override
    public void onError(String string, String string2, Object object) {
        String string3 = string.intern();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string3).append(" (");
        stringBuffer.append(string2).append("): ");
        if (string3 == "NO_INITIAL") {
            if (object instanceof SCXML) {
                stringBuffer.append("<SCXML>");
            } else if (object instanceof State) {
                stringBuffer.append(new StringBuffer().append("State ").append(LogUtils.getTTPath((State)object)).toString());
            }
        } else if (string3 == "UNKNOWN_ACTION") {
            stringBuffer.append(new StringBuffer().append("Action: ").append(object.getClass().getName()).toString());
        } else if (string3 == "ILLEGAL_CONFIG") {
            if (object instanceof Map$Entry) {
                TransitionTarget transitionTarget = (TransitionTarget)((Map$Entry)object).getKey();
                Set set = (Set)((Map$Entry)object).getValue();
                stringBuffer.append(new StringBuffer().append(LogUtils.getTTPath(transitionTarget)).append(" : [").toString());
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    TransitionTarget transitionTarget2 = (TransitionTarget)iterator.next();
                    stringBuffer.append(LogUtils.getTTPath(transitionTarget2));
                    if (!iterator.hasNext()) continue;
                    stringBuffer.append(", ");
                }
                stringBuffer.append(']');
            } else if (object instanceof Set) {
                Set set = (Set)object;
                stringBuffer.append("<SCXML> : [");
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    TransitionTarget transitionTarget = (TransitionTarget)iterator.next();
                    stringBuffer.append(LogUtils.getTTPath(transitionTarget));
                    if (!iterator.hasNext()) continue;
                    stringBuffer.append(", ");
                }
                stringBuffer.append(']');
            }
        }
        if (this.log.isWarnEnabled()) {
            this.log.warn(stringBuffer.toString());
        }
    }
}

