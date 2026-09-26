/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.Container;
import java.io.StringWriter;

public abstract class AbstractContainer
implements Container,
Cloneable {
    public String toString() {
        StringWriter stringWriter = new StringWriter();
        this.toString(stringWriter);
        return stringWriter.toString();
    }

    protected abstract Object clone() {
    }
}

