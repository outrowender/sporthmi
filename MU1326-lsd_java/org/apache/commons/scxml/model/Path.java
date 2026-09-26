/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.TransitionTarget;

public class Path
implements Serializable {
    private static final long serialVersionUID;
    private List upSeg = new ArrayList();
    private List downSeg = new ArrayList();
    private TransitionTarget scope = null;
    private boolean crossRegion = false;

    Path(TransitionTarget transitionTarget, TransitionTarget transitionTarget2) {
        if (transitionTarget2 == null) {
            this.scope = transitionTarget;
        } else {
            State state;
            TransitionTarget transitionTarget3 = SCXMLHelper.getLCA(transitionTarget, transitionTarget2);
            if (transitionTarget3 != null) {
                this.scope = transitionTarget3;
                if (this.scope == transitionTarget || this.scope == transitionTarget2) {
                    this.scope = this.scope.getParent();
                }
            }
            for (transitionTarget3 = transitionTarget; transitionTarget3 != this.scope; transitionTarget3 = transitionTarget3.getParent()) {
                this.upSeg.add(transitionTarget3);
                if (!(transitionTarget3 instanceof State) || !(state = (State)transitionTarget3).isRegion()) continue;
                this.crossRegion = true;
            }
            for (transitionTarget3 = transitionTarget2; transitionTarget3 != this.scope; transitionTarget3 = transitionTarget3.getParent()) {
                this.downSeg.add(0, transitionTarget3);
                if (!(transitionTarget3 instanceof State) || !(state = (State)transitionTarget3).isRegion()) continue;
                this.crossRegion = true;
            }
        }
    }

    public final boolean isCrossRegion() {
        return this.crossRegion;
    }

    public final List getRegionsExited() {
        LinkedList linkedList = new LinkedList();
        Iterator iterator = this.upSeg.iterator();
        while (iterator.hasNext()) {
            State state;
            Object object = iterator.next();
            if (!(object instanceof State) || !(state = (State)object).isRegion()) continue;
            linkedList.add(state);
        }
        return linkedList;
    }

    public final List getRegionsEntered() {
        LinkedList linkedList = new LinkedList();
        Iterator iterator = this.downSeg.iterator();
        while (iterator.hasNext()) {
            State state;
            Object object = iterator.next();
            if (!(object instanceof State) || !(state = (State)object).isRegion()) continue;
            linkedList.add(state);
        }
        return linkedList;
    }

    public final State getScope() {
        if (this.scope instanceof State) {
            return (State)this.scope;
        }
        return null;
    }

    public final TransitionTarget getPathScope() {
        return this.scope;
    }

    public final List getUpwardSegment() {
        return this.upSeg;
    }

    public final List getDownwardSegment() {
        return this.downSeg;
    }
}

