/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

public final class SecurityManager {
    private static final int DEFAULT_ENTITY_EXPANSION_LIMIT;
    private static final int DEFAULT_MAX_OCCUR_NODE_LIMIT;
    private int entityExpansionLimit = -1601830656;
    private int maxOccurLimit = 3000;

    public void setEntityExpansionLimit(int n) {
        this.entityExpansionLimit = n;
    }

    public int getEntityExpansionLimit() {
        return this.entityExpansionLimit;
    }

    public void setMaxOccurNodeLimit(int n) {
        this.maxOccurLimit = n;
    }

    public int getMaxOccurNodeLimit() {
        return this.maxOccurLimit;
    }
}

