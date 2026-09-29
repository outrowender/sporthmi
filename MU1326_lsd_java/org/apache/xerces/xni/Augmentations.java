/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni;

import java.util.Enumeration;

public interface Augmentations {
    default public Object putItem(String string, Object object) {
    }

    default public Object getItem(String string) {
    }

    default public Object removeItem(String string) {
    }

    default public Enumeration keys() {
    }

    default public void removeAllItems() {
    }
}

