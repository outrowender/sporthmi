/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.ASTArrayAccess;
import org.apache.commons.jexl.parser.ASTIdentifier;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;

public class ASTReference
extends SimpleNode {
    protected SimpleNode root;

    public ASTReference(int n) {
        super(n);
    }

    public ASTReference(Parser parser, int n) {
        super(parser, n);
    }

    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object value(JexlContext jexlContext) throws Exception {
        return this.execute(null, jexlContext);
    }

    public void jjtClose() {
        this.root = (SimpleNode)this.jjtGetChild(0);
    }

    public Object execute(Object object, JexlContext jexlContext) throws Exception {
        Object object2 = this.root.value(jexlContext);
        for (int i2 = 1; i2 < this.jjtGetNumChildren(); ++i2) {
            object2 = ((SimpleNode)this.jjtGetChild(i2)).execute(object2, jexlContext);
            if (object2 != null) continue;
            String string = this.getIdentifierToDepth(i2);
            object2 = jexlContext.getVars().get(string);
        }
        return object2;
    }

    private String getIdentifierToDepth(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 <= n; ++i2) {
            SimpleNode simpleNode = (SimpleNode)this.jjtGetChild(i2);
            if (!(simpleNode instanceof ASTIdentifier)) continue;
            stringBuffer.append(((ASTIdentifier)simpleNode).getIdentifierString());
            if (i2 == n) continue;
            stringBuffer.append('.');
        }
        return stringBuffer.toString();
    }

    public String getRootString() throws Exception {
        if (this.root instanceof ASTIdentifier) {
            return ((ASTIdentifier)this.root).getIdentifierString();
        }
        if (this.root instanceof ASTArrayAccess) {
            return ((ASTArrayAccess)this.root).getIdentifierString();
        }
        throw new Exception("programmer error : ASTReference : root not known" + this.root);
    }
}

