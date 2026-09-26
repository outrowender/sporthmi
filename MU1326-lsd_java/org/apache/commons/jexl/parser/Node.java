/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.parser.ParserVisitor;

public interface Node {
    default public void jjtOpen() {
    }

    default public void jjtClose() {
    }

    default public void jjtSetParent(Node node) {
    }

    default public Node jjtGetParent() {
    }

    default public void jjtAddChild(Node node, int n) {
    }

    default public Node jjtGetChild(int n) {
    }

    default public int jjtGetNumChildren() {
    }

    default public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
    }
}

