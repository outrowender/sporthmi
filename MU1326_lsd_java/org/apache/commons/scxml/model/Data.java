/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.scxml.model.NamespacePrefixesHolder;
import org.w3c.dom.Node;

public class Data
implements NamespacePrefixesHolder,
Serializable {
    private static final long serialVersionUID = 1L;
    private String id = null;
    private String src = null;
    private String expr = null;
    private Node node = null;
    private Map namespaces;

    public final String getName() {
        return this.id;
    }

    public final void setName(String string) {
        this.id = string;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String string) {
        this.id = string;
    }

    public final String getSrc() {
        return this.src;
    }

    public final void setSrc(String string) {
        this.src = string;
    }

    public final String getExpr() {
        return this.expr;
    }

    public final void setExpr(String string) {
        this.expr = string;
    }

    public final Node getNode() {
        return this.node;
    }

    public final void setNode(Node node) {
        this.node = node;
    }

    public final Map getNamespaces() {
        return this.namespaces;
    }

    public final void setNamespaces(Map map) {
        this.namespaces = map;
    }
}

