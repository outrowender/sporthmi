/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import org.apache.xerces.impl.XMLEntityManager$Entity;

public class XMLEntityManager$InternalEntity
extends XMLEntityManager$Entity {
    public String text;

    public XMLEntityManager$InternalEntity() {
        this.clear();
    }

    public XMLEntityManager$InternalEntity(String string, String string2, boolean bl) {
        super(string, bl);
        this.text = string2;
    }

    @Override
    public final boolean isExternal() {
        return false;
    }

    @Override
    public final boolean isUnparsed() {
        return false;
    }

    @Override
    public void clear() {
        super.clear();
        this.text = null;
    }

    @Override
    public void setValues(XMLEntityManager$Entity xMLEntityManager$Entity) {
        super.setValues(xMLEntityManager$Entity);
        this.text = null;
    }

    public void setValues(XMLEntityManager$InternalEntity xMLEntityManager$InternalEntity) {
        super.setValues(xMLEntityManager$InternalEntity);
        this.text = xMLEntityManager$InternalEntity.text;
    }
}

