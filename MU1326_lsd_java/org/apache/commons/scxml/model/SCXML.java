/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.model.Datamodel;
import org.apache.commons.scxml.model.NamespacePrefixesHolder;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.TransitionTarget;

public class SCXML
implements Serializable,
NamespacePrefixesHolder {
    private static final long serialVersionUID = 2L;
    public static final String XMLNS = "http://www.w3.org/2005/07/scxml";
    private String xmlns;
    private String version;
    private TransitionTarget initialTarget;
    private String initial;
    private Datamodel datamodel;
    private Map children = new LinkedHashMap();
    private Map targets = new HashMap();
    private Map namespaces;
    private boolean legacy = false;

    public final State getInitialState() {
        if (this.initialTarget != null && this.initialTarget instanceof State) {
            return (State)this.initialTarget;
        }
        return null;
    }

    public final void setInitialState(State state) {
        this.initialTarget = state;
    }

    public final TransitionTarget getInitialTarget() {
        return this.initialTarget;
    }

    public final void setInitialTarget(TransitionTarget transitionTarget) {
        this.initialTarget = transitionTarget;
    }

    public final Datamodel getDatamodel() {
        return this.datamodel;
    }

    public final void setDatamodel(Datamodel datamodel) {
        this.datamodel = datamodel;
    }

    public final Map getStates() {
        return this.children;
    }

    public final void addState(State state) {
        this.children.put(state.getId(), state);
    }

    public final Map getChildren() {
        return this.children;
    }

    public final void addChild(TransitionTarget transitionTarget) {
        this.children.put(transitionTarget.getId(), transitionTarget);
    }

    public final Map getTargets() {
        return this.targets;
    }

    public final void addTarget(TransitionTarget transitionTarget) {
        String string = transitionTarget.getId();
        if (!SCXMLHelper.isStringEmpty(string)) {
            this.targets.put(string, transitionTarget);
        }
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String string) {
        this.version = string;
    }

    public final String getXmlns() {
        return this.xmlns;
    }

    public final void setXmlns(String string) {
        this.xmlns = string;
    }

    public final Map getNamespaces() {
        return this.namespaces;
    }

    public final void setNamespaces(Map map) {
        this.namespaces = map;
    }

    public final String getInitialstate() {
        return this.initial;
    }

    public final void setInitialstate(String string) {
        this.initial = string;
    }

    public final String getInitial() {
        return this.initial;
    }

    public final void setInitial(String string) {
        this.initial = string;
    }

    public final boolean isLegacy() {
        return this.legacy;
    }

    public final void setLegacy(boolean bl) {
        this.legacy = bl;
    }
}

