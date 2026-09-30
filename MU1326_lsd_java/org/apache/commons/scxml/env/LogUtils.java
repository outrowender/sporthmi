/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

public final class LogUtils {
    public static String transToString(TransitionTarget transitionTarget, TransitionTarget transitionTarget2, Transition transition) {
        StringBuffer stringBuffer = new StringBuffer("transition (");
        stringBuffer.append("event = ").append(transition.getEvent());
        stringBuffer.append(", cond = ").append(transition.getCond());
        stringBuffer.append(", from = ").append(LogUtils.getTTPath(transitionTarget));
        stringBuffer.append(", to = ").append(LogUtils.getTTPath(transitionTarget2));
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public static String getTTPath(TransitionTarget transitionTarget) {
        TransitionTarget transitionTarget2 = transitionTarget.getParent();
        if (transitionTarget2 == null) {
            return "/" + transitionTarget.getId();
        }
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(transitionTarget);
        while (transitionTarget2 != null) {
            linkedList.addFirst(transitionTarget2);
            transitionTarget2 = transitionTarget2.getParent();
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            TransitionTarget transitionTarget3 = (TransitionTarget)iterator.next();
            stringBuffer.append('/').append(transitionTarget3.getId());
        }
        return stringBuffer.toString();
    }

    private LogUtils() {
    }
}

