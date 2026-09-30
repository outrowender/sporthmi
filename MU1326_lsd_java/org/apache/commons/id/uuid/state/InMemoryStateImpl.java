/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.state;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.id.uuid.state.Node;
import org.apache.commons.id.uuid.state.State;
import org.apache.commons.id.uuid.state.StateHelper;

public class InMemoryStateImpl
implements State {
    private static HashSet nodes = new HashSet(1);

    public void load() {
        Node node = new Node(StateHelper.randomNodeIdentifier());
        nodes.add(node);
    }

    public Set getNodes() {
        return nodes;
    }

    public void store(Set set) {
    }

    public void store(Set set, long l) {
    }

    public long getSynchInterval() {
        return Long.MAX_VALUE;
    }
}

