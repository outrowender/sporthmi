/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.scxml.SCXMLListener;
import org.apache.commons.scxml.model.SCXML;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

public final class NotificationRegistry
implements Serializable {
    private static final long serialVersionUID;
    private Map regs = new HashMap();

    synchronized void addListener(Object object, SCXMLListener sCXMLListener) {
        Set set = (Set)this.regs.get(object);
        if (set == null) {
            set = new LinkedHashSet();
            this.regs.put(object, set);
        }
        set.add(sCXMLListener);
    }

    synchronized void removeListener(Object object, SCXMLListener sCXMLListener) {
        Set set = (Set)this.regs.get(object);
        if (set != null) {
            set.remove(sCXMLListener);
            if (set.size() == 0) {
                this.regs.remove(object);
            }
        }
    }

    public void fireOnEntry(TransitionTarget transitionTarget, TransitionTarget transitionTarget2) {
        TransitionTarget transitionTarget3 = transitionTarget;
        this.fireOnEntry((Object)transitionTarget3, transitionTarget2);
    }

    public void fireOnEntry(SCXML sCXML, TransitionTarget transitionTarget) {
        SCXML sCXML2 = sCXML;
        this.fireOnEntry((Object)sCXML2, transitionTarget);
    }

    private synchronized void fireOnEntry(Object object, TransitionTarget transitionTarget) {
        Set set = (Set)this.regs.get(object);
        if (set != null) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                SCXMLListener sCXMLListener = (SCXMLListener)iterator.next();
                sCXMLListener.onEntry(transitionTarget);
            }
        }
    }

    public void fireOnExit(TransitionTarget transitionTarget, TransitionTarget transitionTarget2) {
        TransitionTarget transitionTarget3 = transitionTarget;
        this.fireOnExit((Object)transitionTarget3, transitionTarget2);
    }

    public void fireOnExit(SCXML sCXML, TransitionTarget transitionTarget) {
        SCXML sCXML2 = sCXML;
        this.fireOnExit((Object)sCXML2, transitionTarget);
    }

    private synchronized void fireOnExit(Object object, TransitionTarget transitionTarget) {
        Set set = (Set)this.regs.get(object);
        if (set != null) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                SCXMLListener sCXMLListener = (SCXMLListener)iterator.next();
                sCXMLListener.onExit(transitionTarget);
            }
        }
    }

    public void fireOnTransition(Transition transition, TransitionTarget transitionTarget, TransitionTarget transitionTarget2, Transition transition2) {
        Transition transition3 = transition;
        this.fireOnTransition((Object)transition3, transitionTarget, transitionTarget2, transition2);
    }

    public void fireOnTransition(SCXML sCXML, TransitionTarget transitionTarget, TransitionTarget transitionTarget2, Transition transition) {
        SCXML sCXML2 = sCXML;
        this.fireOnTransition((Object)sCXML2, transitionTarget, transitionTarget2, transition);
    }

    private synchronized void fireOnTransition(Object object, TransitionTarget transitionTarget, TransitionTarget transitionTarget2, Transition transition) {
        Set set = (Set)this.regs.get(object);
        if (set != null) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                SCXMLListener sCXMLListener = (SCXMLListener)iterator.next();
                sCXMLListener.onTransition(transitionTarget, transitionTarget2, transition);
            }
        }
    }
}

