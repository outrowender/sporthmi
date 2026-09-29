/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.SCXMLHelper;

public class CustomAction {
    private static final String ERR_NO_NAMESPACE;
    private static final String NAMESPACE_SCXML;
    private static final String ERR_RESERVED_NAMESPACE;
    private static final String ERR_NO_LOCAL_NAME;
    private static final String ERR_NOT_AN_ACTION;
    private String namespaceURI;
    private String localName;
    private Class actionClass;
    private Log log = LogFactory.getLog(class$org$apache$commons$scxml$model$CustomAction == null ? (class$org$apache$commons$scxml$model$CustomAction = CustomAction.class$("org.apache.commons.scxml.model.CustomAction")) : class$org$apache$commons$scxml$model$CustomAction);
    static /* synthetic */ Class class$org$apache$commons$scxml$model$CustomAction;
    static /* synthetic */ Class class$org$apache$commons$scxml$model$Action;

    public CustomAction(String string, String string2, Class clazz) {
        if (SCXMLHelper.isStringEmpty(string)) {
            this.log.error("Cannot define a custom SCXML action with a null or empty namespace");
            throw new IllegalArgumentException("Cannot define a custom SCXML action with a null or empty namespace");
        }
        if (string.trim().equalsIgnoreCase("http://www.w3.org/2005/07/scxml")) {
            this.log.error("Cannot define a custom SCXML action within the SCXML namespace 'http://www.w3.org/2005/07/scxml'");
            throw new IllegalArgumentException("Cannot define a custom SCXML action within the SCXML namespace 'http://www.w3.org/2005/07/scxml'");
        }
        if (SCXMLHelper.isStringEmpty(string2)) {
            this.log.error("Cannot define a custom SCXML action with a null or empty local name");
            throw new IllegalArgumentException("Cannot define a custom SCXML action with a null or empty local name");
        }
        if (clazz == null || !(class$org$apache$commons$scxml$model$Action == null ? (class$org$apache$commons$scxml$model$Action = CustomAction.class$("org.apache.commons.scxml.model.Action")) : class$org$apache$commons$scxml$model$Action).isAssignableFrom(clazz)) {
            this.log.error("Custom SCXML action does not extend Action superclass");
            throw new IllegalArgumentException("Custom SCXML action does not extend Action superclass");
        }
        this.namespaceURI = string;
        this.localName = string2;
        this.actionClass = clazz;
    }

    public Class getActionClass() {
        return this.actionClass;
    }

    public String getLocalName() {
        return this.localName;
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

