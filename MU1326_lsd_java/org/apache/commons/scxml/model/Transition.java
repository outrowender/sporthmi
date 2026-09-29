/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.scxml.model.Executable;
import org.apache.commons.scxml.model.NamespacePrefixesHolder;
import org.apache.commons.scxml.model.Path;
import org.apache.commons.scxml.model.TransitionTarget;

public class Transition
extends Executable
implements NamespacePrefixesHolder {
    private static final long serialVersionUID;
    private String event;
    private String cond;
    private List targets = new ArrayList();
    private String next;
    private List paths = new ArrayList();
    private Map namespaces;

    public final String getCond() {
        return this.cond;
    }

    public final void setCond(String string) {
        this.cond = string;
    }

    public final String getEvent() {
        return this.event;
    }

    public final void setEvent(String string) {
        this.event = string;
    }

    @Override
    public final Map getNamespaces() {
        return this.namespaces;
    }

    @Override
    public final void setNamespaces(Map map) {
        this.namespaces = map;
    }

    public final TransitionTarget getTarget() {
        if (this.targets.size() > 0) {
            return (TransitionTarget)this.targets.get(0);
        }
        return null;
    }

    public final List getTargets() {
        return this.targets;
    }

    public final TransitionTarget getRuntimeTarget() {
        return (TransitionTarget)this.getRuntimeTargets().get(0);
    }

    public final List getRuntimeTargets() {
        if (this.targets.size() == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.getParent());
            return arrayList;
        }
        return this.targets;
    }

    public final void setTarget(TransitionTarget transitionTarget) {
        this.targets.add(0, transitionTarget);
    }

    public final String getNext() {
        return this.next;
    }

    public final void setNext(String string) {
        this.next = string;
    }

    public final Path getPath() {
        return (Path)this.getPaths().get(0);
    }

    public final List getPaths() {
        if (this.paths.size() == 0) {
            if (this.targets.size() > 0) {
                for (int i2 = 0; i2 < this.targets.size(); ++i2) {
                    this.paths.add(i2, new Path(this.getParent(), (TransitionTarget)this.targets.get(i2)));
                }
            } else {
                this.paths.add(new Path(this.getParent(), null));
            }
        }
        return this.paths;
    }
}

