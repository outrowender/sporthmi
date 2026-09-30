/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.PathResolver;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.ModelException;
import org.apache.commons.scxml.model.PathResolverHolder;
import org.apache.commons.scxml.model.TransitionTarget;
import org.w3c.dom.Node;

public class Assign
extends Action
implements PathResolverHolder {
    private static final long serialVersionUID = 1L;
    private String name;
    private String location;
    private String src;
    private String expr;
    private PathResolver pathResolver;

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getExpr() {
        return this.expr;
    }

    public void setExpr(String string) {
        this.expr = string;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String string) {
        this.location = string;
    }

    public String getSrc() {
        return this.src;
    }

    public void setSrc(String string) {
        this.src = string;
    }

    public PathResolver getPathResolver() {
        return this.pathResolver;
    }

    public void setPathResolver(PathResolver pathResolver) {
        this.pathResolver = pathResolver;
    }

    public void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, Log log, Collection collection) throws ModelException, SCXMLExpressionException {
        TransitionTarget transitionTarget = this.getParentTransitionTarget();
        Context context = sCInstance.getContext(transitionTarget);
        Evaluator evaluator = sCInstance.getEvaluator();
        context.setLocal(Assign.getNamespacesKey(), this.getNamespaces());
        if (!SCXMLHelper.isStringEmpty(this.location)) {
            Node node = evaluator.evalLocation(context, this.location);
            if (node != null) {
                Object object;
                Node node2 = null;
                try {
                    Node node3;
                    node2 = this.src != null && this.src.trim().length() > 0 ? this.getSrcNode() : evaluator.evalLocation(context, this.expr);
                    object = node.getFirstChild();
                    while (object != null) {
                        node3 = object.getNextSibling();
                        node.removeChild((Node)object);
                        object = node3;
                    }
                    if (node2 != null) {
                        for (node3 = node2.getFirstChild(); node3 != null; node3 = node3.getNextSibling()) {
                            Node node4 = node.getOwnerDocument().importNode(node3, true);
                            node.appendChild(node4);
                        }
                    }
                }
                catch (SCXMLExpressionException sCXMLExpressionException) {
                    Object object2 = evaluator.eval(context, this.expr);
                    SCXMLHelper.setNodeValue(node, object2.toString());
                }
                if (log.isDebugEnabled()) {
                    log.debug("<assign>: data node '" + node.getNodeName() + "' updated");
                }
                object = new TriggerEvent(this.name + ".change", 2);
                collection.add(object);
            } else {
                log.error("<assign>: location does not point to a <data> node");
            }
        } else if (!context.has(this.name)) {
            errorReporter.onError("UNDEFINED_VARIABLE", this.name + " = null", transitionTarget);
        } else {
            Object object = null;
            object = this.src != null && this.src.trim().length() > 0 ? this.getSrcNode() : evaluator.eval(context, this.expr);
            context.set(this.name, object);
            if (log.isDebugEnabled()) {
                log.debug("<assign>: Set variable '" + this.name + "' to '" + String.valueOf(object) + "'");
            }
            TriggerEvent triggerEvent = new TriggerEvent(this.name + ".change", 2);
            collection.add(triggerEvent);
        }
        context.setLocal(Assign.getNamespacesKey(), null);
    }

    private Node getSrcNode() {
        return null;
    }
}

