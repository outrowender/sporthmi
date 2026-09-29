/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.messaging.Template;

public interface ITemplatePropertyFactory {
    default public PropertyListCell create(Template template) {
    }
}

