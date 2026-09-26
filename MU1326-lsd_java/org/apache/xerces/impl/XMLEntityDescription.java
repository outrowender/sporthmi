/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import org.apache.xerces.xni.XMLResourceIdentifier;

public interface XMLEntityDescription
extends XMLResourceIdentifier {
    default public void setEntityName(String string) {
    }

    default public String getEntityName() {
    }
}

