/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.ASTSizeFunction;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;

public class ASTSizeMethod
extends SimpleNode {
    public ASTSizeMethod(int n) {
        super(n);
    }

    public ASTSizeMethod(Parser parser, int n) {
        super(parser, n);
    }

    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object execute(Object object, JexlContext jexlContext) throws Exception {
        return new Integer(ASTSizeFunction.sizeOf(object));
    }
}

