/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni.parser;

import org.apache.xerces.xni.parser.XMLComponentManager;

public interface XMLComponent {
    default public void reset(XMLComponentManager xMLComponentManager) {
    }

    default public String[] getRecognizedFeatures() {
    }

    default public void setFeature(String string, boolean bl) {
    }

    default public String[] getRecognizedProperties() {
    }

    default public void setProperty(String string, Object object) {
    }

    default public Boolean getFeatureDefault(String string) {
    }

    default public Object getPropertyDefault(String string) {
    }
}

