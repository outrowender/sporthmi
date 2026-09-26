/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.Node;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserTreeConstants;
import org.apache.commons.jexl.parser.ParserVisitor;

public class SimpleNode
implements Node {
    protected Node parent;
    protected Node[] children;
    protected int id;
    protected Parser parser;

    public SimpleNode(int n) {
        this.id = n;
    }

    public SimpleNode(Parser parser, int n) {
        this(n);
        this.parser = parser;
    }

    @Override
    public void jjtOpen() {
    }

    @Override
    public void jjtClose() {
    }

    @Override
    public void jjtSetParent(Node node) {
        this.parent = node;
    }

    @Override
    public Node jjtGetParent() {
        return this.parent;
    }

    @Override
    public void jjtAddChild(Node node, int n) {
        if (this.children == null) {
            this.children = new Node[n + 1];
        } else if (n >= this.children.length) {
            Node[] nodeArray = new Node[n + 1];
            System.arraycopy((Object)this.children, 0, (Object)nodeArray, 0, this.children.length);
            this.children = nodeArray;
        }
        this.children[n] = node;
    }

    @Override
    public Node jjtGetChild(int n) {
        return this.children[n];
    }

    @Override
    public int jjtGetNumChildren() {
        return this.children == null ? 0 : this.children.length;
    }

    @Override
    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object childrenAccept(ParserVisitor parserVisitor, Object object) {
        if (this.children != null) {
            for (int i2 = 0; i2 < this.children.length; ++i2) {
                this.children[i2].jjtAccept(parserVisitor, object);
            }
        }
        return object;
    }

    public String toString() {
        return ParserTreeConstants.jjtNodeName[this.id];
    }

    public String toString(String string) {
        return new StringBuffer().append(string).append(this.toString()).toString();
    }

    public void dump(String string) {
        System.out.println(this.toString(string));
        if (this.children != null) {
            for (int i2 = 0; i2 < this.children.length; ++i2) {
                SimpleNode simpleNode = (SimpleNode)this.children[i2];
                if (simpleNode == null) continue;
                simpleNode.dump(new StringBuffer().append(string).append(" ").toString());
            }
        }
    }

    public boolean interpret(JexlContext jexlContext) {
        for (int i2 = 0; i2 < this.jjtGetNumChildren(); ++i2) {
            SimpleNode simpleNode = (SimpleNode)this.jjtGetChild(i2);
            if (simpleNode.interpret(jexlContext)) continue;
            return false;
        }
        return true;
    }

    public Object value(JexlContext jexlContext) {
        return null;
    }

    public Object setValue(JexlContext jexlContext, Object object) {
        return null;
    }

    public Object execute(Object object, JexlContext jexlContext) {
        return null;
    }
}

