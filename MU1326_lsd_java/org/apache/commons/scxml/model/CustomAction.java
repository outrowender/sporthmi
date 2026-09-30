/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.SCXMLHelper;

public class CustomAction {
    private static final String ERR_NO_NAMESPACE = "Cannot define a custom SCXML action with a null or empty namespace";
    private static final String NAMESPACE_SCXML = "http://www.w3.org/2005/07/scxml";
    private static final String ERR_RESERVED_NAMESPACE = "Cannot define a custom SCXML action within the SCXML namespace 'http://www.w3.org/2005/07/scxml'";
    private static final String ERR_NO_LOCAL_NAME = "Cannot define a custom SCXML action with a null or empty local name";
    private static final String ERR_NOT_AN_ACTION = "Custom SCXML action does not extend Action superclass";
    private String namespaceURI;
    private String localName;
    private Class actionClass;
    private Log log = LogFactory.getLog(class$org$apache$commons$scxml$model$CustomAction == null ? (class$org$apache$commons$scxml$model$CustomAction = CustomAction.class$("org.apache.commons.scxml.model.CustomAction")) : class$org$apache$commons$scxml$model$CustomAction);
    static /* synthetic */ Class class$org$apache$commons$scxml$model$CustomAction;
    static /* synthetic */ Class class$org$apache$commons$scxml$model$Action;

    public CustomAction(String string, String string2, Class clazz) {
        if (SCXMLHelper.isStringEmpty(string)) {
            this.log.error(ERR_NO_NAMESPACE);
            throw new IllegalArgumentException(ERR_NO_NAMESPACE);
        }
        if (string.trim().equalsIgnoreCase(NAMESPACE_SCXML)) {
            this.log.error(ERR_RESERVED_NAMESPACE);
            throw new IllegalArgumentException(ERR_RESERVED_NAMESPACE);
        }
        if (SCXMLHelper.isStringEmpty(string2)) {
            this.log.error(ERR_NO_LOCAL_NAME);
            throw new IllegalArgumentException(ERR_NO_LOCAL_NAME);
        }
        if (clazz == null || !(class$org$apache$commons$scxml$model$Action == null ? (class$org$apache$commons$scxml$model$Action = CustomAction.class$("org.apache.commons.scxml.model.Action")) : class$org$apache$commons$scxml$model$Action).isAssignableFrom(clazz)) {
            this.log.error(ERR_NOT_AN_ACTION);
            throw new IllegalArgumentException(ERR_NOT_AN_ACTION);
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

