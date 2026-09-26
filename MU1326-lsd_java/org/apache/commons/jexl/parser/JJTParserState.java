/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import java.util.Stack;
import org.apache.commons.jexl.parser.Node;

class JJTParserState {
    private final Stack nodes = new Stack();
    private final Stack marks = new Stack();
    private int sp = 0;
    private int mk = 0;
    private boolean node_created;

    JJTParserState() {
    }

    boolean nodeCreated() {
        return this.node_created;
    }

    void reset() {
        this.nodes.removeAllElements();
        this.marks.removeAllElements();
        this.sp = 0;
        this.mk = 0;
    }

    Node rootNode() {
        return (Node)this.nodes.elementAt(0);
    }

    void pushNode(Node node) {
        this.nodes.push(node);
        ++this.sp;
    }

    Node popNode() {
        if (--this.sp < this.mk) {
            this.mk = (Integer)this.marks.pop();
        }
        return (Node)this.nodes.pop();
    }

    Node peekNode() {
        return (Node)this.nodes.peek();
    }

    int nodeArity() {
        return this.sp - this.mk;
    }

    void clearNodeScope(Node node) {
        while (this.sp > this.mk) {
            this.popNode();
        }
        this.mk = (Integer)this.marks.pop();
    }

    void openNodeScope(Node node) {
        this.marks.push(new Integer(this.mk));
        this.mk = this.sp;
        node.jjtOpen();
    }

    void closeNodeScope(Node node, int n) {
        this.mk = (Integer)this.marks.pop();
        while (n-- > 0) {
            Node node2 = this.popNode();
            node2.jjtSetParent(node);
            node.jjtAddChild(node2, n);
        }
        node.jjtClose();
        this.pushNode(node);
        this.node_created = true;
    }

    void closeNodeScope(Node node, boolean bl) {
        if (bl) {
            int n = this.nodeArity();
            this.mk = (Integer)this.marks.pop();
            while (n-- > 0) {
                Node node2 = this.popNode();
                node2.jjtSetParent(node);
                node.jjtAddChild(node2, n);
            }
            node.jjtClose();
            this.pushNode(node);
            this.node_created = true;
        } else {
            this.mk = (Integer)this.marks.pop();
            this.node_created = false;
        }
    }
}

