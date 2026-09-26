/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import java.util.Iterator;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.ASTReference;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.util.Introspector;
import org.apache.commons.jexl.util.introspection.Info;

public class ASTForeachStatement
extends SimpleNode {
    private static final Info DUMMY = new Info("", 1, 1);
    private static final int VAR_INDEX;
    private static final int ITEMS_INDEX;
    private static final int STATEMENT_INDEX;

    public ASTForeachStatement(int n) {
        super(n);
    }

    public ASTForeachStatement(Parser parser, int n) {
        super(parser, n);
    }

    @Override
    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    @Override
    public Object value(JexlContext jexlContext) {
        Object object = null;
        ASTReference aSTReference = (ASTReference)this.jjtGetChild(0);
        SimpleNode simpleNode = (SimpleNode)this.jjtGetChild(1);
        Object object2 = simpleNode.value(jexlContext);
        if (object2 != null && this.jjtGetNumChildren() >= 3) {
            SimpleNode simpleNode2 = (SimpleNode)this.jjtGetChild(2);
            Iterator iterator = Introspector.getUberspect().getIterator(object2, DUMMY);
            while (iterator.hasNext()) {
                Object object3 = iterator.next();
                jexlContext.getVars().put(aSTReference.getRootString(), object3);
                object = simpleNode2.value(jexlContext);
            }
        }
        return object;
    }
}

