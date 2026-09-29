/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni;

import java.util.Enumeration;

public interface NamespaceContext {
    public static final String XML_URI = "http://www.w3.org/XML/1998/namespace".intern();
    public static final String XMLNS_URI = "http://www.w3.org/2000/xmlns/".intern();

    default public void pushContext() {
    }

    default public void popContext() {
    }

    default public boolean declarePrefix(String string, String string2) {
    }

    default public String getURI(String string) {
    }

    default public String getPrefix(String string) {
    }

    default public int getDeclaredPrefixCount() {
    }

    default public String getDeclaredPrefixAt(int n) {
    }

    default public Enumeration getAllPrefixes() {
    }

    default public void reset() {
    }
}

