/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import org.dsi.ifc.messaging.Template;

public interface ITemplateObserver {
    public void templateSelected(Template var1);

    public static class EmptyImplementation
    implements ITemplateObserver {
        public void templateSelected(Template template) {
        }
    }
}

