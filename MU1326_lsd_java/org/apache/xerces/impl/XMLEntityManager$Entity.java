/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

public abstract class XMLEntityManager$Entity {
    public String name;
    public boolean inExternalSubset;

    public XMLEntityManager$Entity() {
        this.clear();
    }

    public XMLEntityManager$Entity(String string, boolean bl) {
        this.name = string;
        this.inExternalSubset = bl;
    }

    public boolean isEntityDeclInExternalSubset() {
        return this.inExternalSubset;
    }

    public abstract boolean isExternal() {
    }

    public abstract boolean isUnparsed() {
    }

    public void clear() {
        this.name = null;
        this.inExternalSubset = false;
    }

    public void setValues(XMLEntityManager$Entity xMLEntityManager$Entity) {
        this.name = xMLEntityManager$Entity.name;
        this.inExternalSubset = xMLEntityManager$Entity.inExternalSubset;
    }
}

