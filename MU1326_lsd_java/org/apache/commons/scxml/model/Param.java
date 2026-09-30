/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.scxml.model.NamespacePrefixesHolder;

public class Param
implements NamespacePrefixesHolder,
Serializable {
    private static final long serialVersionUID = 1L;
    private String name = null;
    private String expr = null;
    private Map namespaces;

    public final String getName() {
        return this.name;
    }

    public final void setName(String string) {
        this.name = string;
    }

    public final String getExpr() {
        return this.expr;
    }

    public final void setExpr(String string) {
        this.expr = string;
    }

    public final Map getNamespaces() {
        return this.namespaces;
    }

    public final void setNamespaces(Map map) {
        this.namespaces = map;
    }
}

