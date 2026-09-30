/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.semantics;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.model.Parallel;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.TransitionTarget;

final class TransitionTargetComparator
implements Comparator,
Serializable {
    private static final long serialVersionUID = 1L;

    TransitionTargetComparator() {
    }

    public int compare(Object object, Object object2) {
        TransitionTarget transitionTarget = (TransitionTarget)object;
        TransitionTarget transitionTarget2 = (TransitionTarget)object2;
        if (transitionTarget == transitionTarget2) {
            return 0;
        }
        if (SCXMLHelper.isDescendant(transitionTarget, transitionTarget2)) {
            return -1;
        }
        if (SCXMLHelper.isDescendant(transitionTarget2, transitionTarget)) {
            return 1;
        }
        int n = this.countChainLength(transitionTarget);
        int n2 = this.countChainLength(transitionTarget2);
        if (n2 == n) {
            Parallel parallel = (Parallel)SCXMLHelper.getLCA(transitionTarget, transitionTarget2);
            TransitionTarget transitionTarget3 = transitionTarget;
            while (transitionTarget3.getParent() != parallel) {
                transitionTarget3 = transitionTarget3.getParent();
            }
            TransitionTarget transitionTarget4 = transitionTarget2;
            while (transitionTarget4.getParent() != parallel) {
                transitionTarget4 = transitionTarget4.getParent();
            }
            if (parallel != null) {
                Iterator iterator = parallel.getChildren().iterator();
                while (iterator.hasNext()) {
                    State state = (State)iterator.next();
                    if (state == transitionTarget3) {
                        return 1;
                    }
                    if (state != transitionTarget4) continue;
                    return -1;
                }
            }
        }
        return n2 - n;
    }

    private int countChainLength(TransitionTarget transitionTarget) {
        int n = 0;
        for (TransitionTarget transitionTarget2 = transitionTarget.getParent(); transitionTarget2 != null; transitionTarget2 = transitionTarget2.getParent()) {
            ++n;
        }
        return n;
    }
}

