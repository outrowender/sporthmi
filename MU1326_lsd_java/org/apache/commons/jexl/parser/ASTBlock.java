/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;

public class ASTBlock
extends SimpleNode {
    public ASTBlock(int n) {
        super(n);
    }

    public ASTBlock(Parser parser, int n) {
        super(parser, n);
    }

    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object value(JexlContext jexlContext) throws Exception {
        int n = this.jjtGetNumChildren();
        Object object = null;
        for (int i2 = 0; i2 < n; ++i2) {
            object = ((SimpleNode)this.jjtGetChild(i2)).value(jexlContext);
        }
        return object;
    }
}

