/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.apache.xerces.util.NamespaceSupport;

public final class NamespaceSupport$Prefixes
implements Enumeration {
    private String[] prefixes;
    private int counter = 0;
    private int size = 0;
    private final /* synthetic */ NamespaceSupport this$0;

    public NamespaceSupport$Prefixes(NamespaceSupport namespaceSupport, String[] stringArray, int n) {
        this.this$0 = namespaceSupport;
        this.prefixes = stringArray;
        this.size = n;
    }

    @Override
    public boolean hasMoreElements() {
        return this.counter < this.size;
    }

    @Override
    public Object nextElement() {
        if (this.counter < this.size) {
            return this.this$0.fPrefixes[this.counter++];
        }
        throw new NoSuchElementException("Illegal access to Namespace prefixes enumeration.");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.size; ++i2) {
            stringBuffer.append(this.prefixes[i2]);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
}

