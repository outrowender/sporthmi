/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.ASTArrayAccess;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;

public class ASTIdentifier
extends SimpleNode {
    protected String val;

    public ASTIdentifier(int n) {
        super(n);
    }

    public ASTIdentifier(Parser parser, int n) {
        super(parser, n);
    }

    @Override
    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    @Override
    public Object value(JexlContext jexlContext) {
        return jexlContext.getVars().get(this.val);
    }

    @Override
    public Object execute(Object object, JexlContext jexlContext) {
        return ASTArrayAccess.evaluateExpr(object, this.val);
    }

    public String getIdentifierString() {
        return this.val;
    }
}

