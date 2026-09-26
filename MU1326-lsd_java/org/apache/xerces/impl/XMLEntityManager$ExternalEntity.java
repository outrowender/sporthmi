/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import org.apache.xerces.impl.XMLEntityManager$Entity;
import org.apache.xerces.xni.XMLResourceIdentifier;

public class XMLEntityManager$ExternalEntity
extends XMLEntityManager$Entity {
    public XMLResourceIdentifier entityLocation;
    public String notation;

    public XMLEntityManager$ExternalEntity() {
        this.clear();
    }

    public XMLEntityManager$ExternalEntity(String string, XMLResourceIdentifier xMLResourceIdentifier, String string2, boolean bl) {
        super(string, bl);
        this.entityLocation = xMLResourceIdentifier;
        this.notation = string2;
    }

    @Override
    public final boolean isExternal() {
        return true;
    }

    @Override
    public final boolean isUnparsed() {
        return this.notation != null;
    }

    @Override
    public void clear() {
        super.clear();
        this.entityLocation = null;
        this.notation = null;
    }

    @Override
    public void setValues(XMLEntityManager$Entity xMLEntityManager$Entity) {
        super.setValues(xMLEntityManager$Entity);
        this.entityLocation = null;
        this.notation = null;
    }

    public void setValues(XMLEntityManager$ExternalEntity xMLEntityManager$ExternalEntity) {
        super.setValues(xMLEntityManager$ExternalEntity);
        this.entityLocation = xMLEntityManager$ExternalEntity.entityLocation;
        this.notation = xMLEntityManager$ExternalEntity.notation;
    }
}

