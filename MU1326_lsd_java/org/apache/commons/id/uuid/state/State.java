/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.state;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

public interface State
extends Serializable {
    public static final String DEFAULT_STATE_IMPL = "org.apache.commons.id.uuid.state.ReadOnlyResourceStateImpl";

    public void load() throws Exception;

    public Set getNodes();

    public void store(Set var1) throws IOException;

    public void store(Set var1, long var2);

    public long getSynchInterval();
}

