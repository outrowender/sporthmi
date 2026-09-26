/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap;

import java.io.StringWriter;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public interface Container {
    default public HASDataContainer[] createContainer() {
    }

    default public List createContainer(int n, int n2, int n3) {
    }

    default public void toString(StringWriter stringWriter) {
    }
}

