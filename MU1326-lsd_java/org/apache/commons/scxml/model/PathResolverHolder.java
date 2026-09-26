/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import org.apache.commons.scxml.PathResolver;

public interface PathResolverHolder {
    default public void setPathResolver(PathResolver pathResolver) {
    }

    default public PathResolver getPathResolver() {
    }
}

