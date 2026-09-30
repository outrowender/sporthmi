/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.ASTIdentifier;
import org.apache.commons.jexl.parser.ASTReference;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;

public class ASTAssignment
extends SimpleNode {
    public ASTAssignment(int n) {
        super(n);
    }

    public ASTAssignment(Parser parser, int n) {
        super(parser, n);
    }

    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object value(JexlContext jexlContext) throws Exception {
        ASTReference aSTReference;
        SimpleNode simpleNode = (SimpleNode)this.jjtGetChild(0);
        Object object = ((SimpleNode)this.jjtGetChild(1)).value(jexlContext);
        if (simpleNode instanceof ASTReference && (simpleNode = (SimpleNode)(aSTReference = (ASTReference)simpleNode).jjtGetChild(0)) instanceof ASTIdentifier) {
            String string = ((ASTIdentifier)simpleNode).getIdentifierString();
            jexlContext.getVars().put(string, object);
        }
        return object;
    }
}

