/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import de.eso.remotehmi.xpath.PoorMansXPath;
import de.eso.remotehmi.xpath.PoorMansXPathException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.model.TransitionTarget;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Builtin
implements Serializable {
    static /* synthetic */ Class class$org$apache$commons$scxml$Builtin;

    public static boolean isMember(Set set, String string) {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            TransitionTarget transitionTarget = (TransitionTarget)iterator.next();
            if (!string.equals(transitionTarget.getId())) continue;
            return true;
        }
        return false;
    }

    public static Node dataNode(Map map, Object object, String string) {
        NodeList nodeList;
        if (object == null || !(object instanceof Node)) {
            object = LogFactory.getLog(class$org$apache$commons$scxml$Builtin == null ? (class$org$apache$commons$scxml$Builtin = Builtin.class$("org.apache.commons.scxml.Builtin")) : class$org$apache$commons$scxml$Builtin);
            object.error("Data(): Cannot evaluate an XPath expression. DataNode == NULL!, null returned");
            return null;
        }
        Node node = (Node)object;
        try {
            nodeList = (NodeList)PoorMansXPath.resolve(map, node, string);
        }
        catch (PoorMansXPathException poorMansXPathException) {
            object = LogFactory.getLog(class$org$apache$commons$scxml$Builtin == null ? (class$org$apache$commons$scxml$Builtin = Builtin.class$("org.apache.commons.scxml.Builtin")) : class$org$apache$commons$scxml$Builtin);
            object.error(new StringBuffer().append("Data(): Cannot evaluate an XPath expression: ").append(poorMansXPathException.getMessage()).toString());
            nodeList = null;
        }
        if (nodeList == null || nodeList.getLength() == 0) {
            return null;
        }
        if (nodeList.getLength() > 1) {
            // empty if block
        }
        return nodeList.item(0);
    }

    public static NodeList dataNodeList(Map map, Object object, String string) {
        NodeList nodeList;
        System.out.println(new StringBuffer().append("Object = ").append(object).toString());
        if (object == null || !(object instanceof Node)) {
            object = LogFactory.getLog(class$org$apache$commons$scxml$Builtin == null ? (class$org$apache$commons$scxml$Builtin = Builtin.class$("org.apache.commons.scxml.Builtin")) : class$org$apache$commons$scxml$Builtin);
            object.error("Data(): Cannot evaluate an XPath expression in the absence of a context Node, null returned");
            return null;
        }
        Node node = (Node)object;
        try {
            nodeList = (NodeList)PoorMansXPath.resolve(map, node, string);
        }
        catch (PoorMansXPathException poorMansXPathException) {
            object = LogFactory.getLog(class$org$apache$commons$scxml$Builtin == null ? (class$org$apache$commons$scxml$Builtin = Builtin.class$("org.apache.commons.scxml.Builtin")) : class$org$apache$commons$scxml$Builtin);
            object.error(new StringBuffer().append("Data(): Cannot evaluate an XPath expression: ").append(poorMansXPathException.getMessage()).toString());
            nodeList = null;
        }
        if (nodeList == null || nodeList.getLength() == 0) {
            return null;
        }
        return nodeList;
    }

    public static Object data(Map map, Object object, String string) {
        Object object2;
        block4: {
            object2 = Builtin.dataAsString(map, object, string);
            try {
                double d2 = Double.parseDouble((String)object2);
                object2 = new Double(d2);
            }
            catch (NumberFormatException numberFormatException) {
                try {
                    long l = Long.parseLong((String)object2);
                    object2 = new Long(l);
                }
                catch (NumberFormatException numberFormatException2) {
                    if (!(object instanceof Map)) break block4;
                    object2 = (Map)object;
                }
            }
        }
        return object2;
    }

    public static Object dataAsString(Map map, Object object, String string) {
        String string2 = SCXMLHelper.getNodeValue(Builtin.dataNode(map, object, string));
        return string2;
    }

    public static Node dataNode(Object object, String string) {
        return null;
    }

    public static Object data(Object object, String string) {
        Object object2 = SCXMLHelper.getNodeValue(Builtin.dataNode(object, string));
        try {
            double d2 = Double.parseDouble((String)object2);
            object2 = new Double(d2);
        }
        catch (NumberFormatException numberFormatException) {
            try {
                long l = Long.parseLong((String)object2);
                object2 = new Long(l);
            }
            catch (NumberFormatException numberFormatException2) {
                object2 = string;
            }
        }
        return object2;
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

