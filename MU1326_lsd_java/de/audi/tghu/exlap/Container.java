/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap;

import java.io.StringWriter;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public interface Container {
    public HASDataContainer[] createContainer();

    public List createContainer(int var1, int var2, int var3);

    public void toString(StringWriter var1);
}

