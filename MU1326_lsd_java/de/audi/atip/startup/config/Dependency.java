/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup.config;

import de.audi.atip.startup.config.Component;
import de.esolutions.fw.util.commons.Buffer;

public class Dependency {
    static final int ATTRIBUTE_UNDEFINED = -1;
    private final String dependentComponentName;
    private final int domain;
    private final int state;
    private final boolean async;
    private final boolean isComponentDependency;
    private final boolean isStopOnFailDependency;
    private final boolean isStartAnywayDependency;
    private Component dependentComponent;

    public Dependency(int n, int n2, boolean bl, String string, boolean bl2, boolean bl3) {
        this.dependentComponentName = string;
        this.domain = n;
        this.state = n2;
        this.async = bl;
        this.dependentComponent = null;
        this.isComponentDependency = string != null;
        this.isStopOnFailDependency = bl2;
        this.isStartAnywayDependency = bl3;
    }

    public String getDependentComponentName() {
        return this.dependentComponentName;
    }

    public int getDomain() {
        return this.domain;
    }

    public int getState() {
        return this.state;
    }

    public boolean isAsync() {
        return this.async;
    }

    public Component getDependentComponent() {
        return this.dependentComponent;
    }

    public void setDependentComponent(Component component) {
        this.dependentComponent = component;
    }

    public boolean isComponentDependency() {
        return this.isComponentDependency;
    }

    public boolean isStopOnFailDependency() {
        return this.isStopOnFailDependency;
    }

    public boolean isStartAnywayDependency() {
        return this.isStartAnywayDependency;
    }

    public final String toString() {
        Buffer buffer = new Buffer("    Dependency(");
        if (this.domain != -1) {
            buffer.append(this.domain).append(',').append(Integer.toHexString(this.state)).append(' ').append(this.async ? "async" : "sync");
        }
        if (this.dependentComponentName != null) {
            if (this.domain != -1) {
                buffer.append(',');
            }
            buffer.append(this.dependentComponentName);
            if (this.isStopOnFailDependency) {
                buffer.append(",").append("stopOnFailDependency");
            }
            if (this.isStartAnywayDependency) {
                buffer.append(",").append("startAnywayDependency");
            }
        }
        buffer.append(')');
        return buffer.toString();
    }
}

