/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.scxml.PathResolver;
import org.apache.commons.scxml.model.Finalize;
import org.apache.commons.scxml.model.NamespacePrefixesHolder;
import org.apache.commons.scxml.model.Param;
import org.apache.commons.scxml.model.PathResolverHolder;

public class Invoke
implements NamespacePrefixesHolder,
PathResolverHolder,
Serializable {
    private static final long serialVersionUID;
    private String targettype;
    private String src;
    private String srcexpr;
    private Map params = new HashMap();
    private List paramsList = new ArrayList();
    private Finalize finalize;
    private PathResolver pathResolver;
    private Map namespaces;

    public final String getTargettype() {
        return this.targettype;
    }

    public final void setTargettype(String string) {
        this.targettype = string;
    }

    public final String getSrc() {
        return this.src;
    }

    public final void setSrc(String string) {
        this.src = string;
    }

    public final String getSrcexpr() {
        return this.srcexpr;
    }

    public final void setSrcexpr(String string) {
        this.srcexpr = string;
    }

    public final Map getParams() {
        return this.params;
    }

    public final List params() {
        return this.paramsList;
    }

    public final void addParam(Param param) {
        this.params.put(param.getName(), param.getExpr());
        this.paramsList.add(param);
    }

    public final Finalize getFinalize() {
        return this.finalize;
    }

    public final void setFinalize(Finalize finalize) {
        this.finalize = finalize;
    }

    @Override
    public PathResolver getPathResolver() {
        return this.pathResolver;
    }

    @Override
    public void setPathResolver(PathResolver pathResolver) {
        this.pathResolver = pathResolver;
    }

    @Override
    public final Map getNamespaces() {
        return this.namespaces;
    }

    @Override
    public final void setNamespaces(Map map) {
        this.namespaces = map;
    }
}

