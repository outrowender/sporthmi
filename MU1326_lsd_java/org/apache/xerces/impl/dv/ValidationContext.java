/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.dv;

public interface ValidationContext {
    default public boolean needFacetChecking() {
    }

    default public boolean needExtraChecking() {
    }

    default public boolean needToNormalize() {
    }

    default public boolean useNamespaces() {
    }

    default public boolean isEntityDeclared(String string) {
    }

    default public boolean isEntityUnparsed(String string) {
    }

    default public boolean isIdDeclared(String string) {
    }

    default public void addId(String string) {
    }

    default public void addIdRef(String string) {
    }

    default public String getSymbol(String string) {
    }

    default public String getURI(String string) {
    }
}

