/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.io.StringWriter;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.model.Data;
import org.apache.commons.scxml.model.Datamodel;
import org.apache.commons.scxml.model.Parallel;
import org.apache.commons.scxml.model.Path;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Node;

public final class SCXMLHelper {
    private static final String NAMESPACES_KEY;
    static /* synthetic */ Class class$java$lang$Object;
    static /* synthetic */ Class class$org$apache$commons$scxml$SCXMLHelper;

    public static boolean isStringEmpty(String string) {
        return string == null || string.trim().length() == 0;
    }

    public static boolean isDescendant(TransitionTarget transitionTarget, TransitionTarget transitionTarget2) {
        for (TransitionTarget transitionTarget3 = transitionTarget.getParent(); transitionTarget3 != null; transitionTarget3 = transitionTarget3.getParent()) {
            if (transitionTarget3 != transitionTarget2) continue;
            return true;
        }
        return false;
    }

    public static Set getAncestorClosure(Set set, Set set2) {
        HashSet hashSet = new HashSet(set.size() * 2);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            for (TransitionTarget transitionTarget = (TransitionTarget)iterator.next(); transitionTarget != null && hashSet.add(transitionTarget) && (set2 == null || !set2.contains(transitionTarget)); transitionTarget = transitionTarget.getParent()) {
            }
        }
        return hashSet;
    }

    public static boolean isLegalConfig(Set set, ErrorReporter errorReporter) {
        Set set2;
        TransitionTarget transitionTarget;
        Object object;
        boolean bl = true;
        IdentityHashMap identityHashMap = new IdentityHashMap();
        HashSet hashSet = new HashSet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            object = (TransitionTarget)iterator.next();
            transitionTarget = null;
            while ((transitionTarget = ((TransitionTarget)object).getParent()) != null) {
                set2 = (HashSet)identityHashMap.get(transitionTarget);
                if (set2 == null) {
                    set2 = new HashSet();
                    identityHashMap.put(transitionTarget, set2);
                }
                ((HashSet)set2).add(object);
                object = transitionTarget;
            }
            hashSet.add(object);
        }
        iterator = identityHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            object = (Map$Entry)iterator.next();
            transitionTarget = (TransitionTarget)object.getKey();
            set2 = (Set)object.getValue();
            if (transitionTarget instanceof Parallel) {
                Parallel parallel = (Parallel)transitionTarget;
                if (set2.size() < parallel.getChildren().size()) {
                    errorReporter.onError("ILLEGAL_CONFIG", new StringBuffer().append("Not all AND states active for parallel ").append(parallel.getId()).toString(), object);
                    bl = false;
                }
            } else if (set2.size() > 1) {
                errorReporter.onError("ILLEGAL_CONFIG", new StringBuffer().append("Multiple OR states active for state ").append(transitionTarget.getId()).toString(), object);
                bl = false;
            }
            set2.clear();
        }
        if (hashSet.size() > 1) {
            errorReporter.onError("ILLEGAL_CONFIG", "Multiple top-level OR states active!", hashSet);
        }
        hashSet.clear();
        identityHashMap.clear();
        return bl;
    }

    public static TransitionTarget getLCA(TransitionTarget transitionTarget, TransitionTarget transitionTarget2) {
        if (transitionTarget == transitionTarget2) {
            return transitionTarget;
        }
        if (SCXMLHelper.isDescendant(transitionTarget, transitionTarget2)) {
            return transitionTarget2;
        }
        if (SCXMLHelper.isDescendant(transitionTarget2, transitionTarget)) {
            return transitionTarget;
        }
        HashSet hashSet = new HashSet();
        TransitionTarget transitionTarget3 = transitionTarget;
        while ((transitionTarget3 = transitionTarget3.getParent()) != null) {
            hashSet.add(transitionTarget3);
        }
        transitionTarget3 = transitionTarget2;
        while ((transitionTarget3 = transitionTarget3.getParent()) != null) {
            if (hashSet.add(transitionTarget3)) continue;
            hashSet.clear();
            return transitionTarget3;
        }
        return null;
    }

    public static Set getStatesExited(Transition transition, Set set) {
        TransitionTarget transitionTarget;
        HashSet hashSet = new HashSet();
        if (transition.getTargets().size() == 0) {
            return hashSet;
        }
        Path path = (Path)transition.getPaths().get(0);
        hashSet.addAll(path.getUpwardSegment());
        TransitionTarget transitionTarget2 = transition.getParent();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            transitionTarget = (TransitionTarget)iterator.next();
            if (!SCXMLHelper.isDescendant(transitionTarget, transitionTarget2)) continue;
            boolean bl = false;
            bl = hashSet.add(transitionTarget);
            while (bl && transitionTarget != transitionTarget2) {
                transitionTarget = transitionTarget.getParent();
                bl = hashSet.add(transitionTarget);
            }
        }
        if (path.isCrossRegion()) {
            iterator = path.getRegionsExited().iterator();
            while (iterator.hasNext()) {
                transitionTarget = (Parallel)((State)iterator.next()).getParent();
                Iterator iterator2 = ((Parallel)transitionTarget).getChildren().iterator();
                while (iterator2.hasNext()) {
                    State state = (State)iterator2.next();
                    Iterator iterator3 = set.iterator();
                    while (iterator3.hasNext()) {
                        TransitionTarget transitionTarget3 = (TransitionTarget)iterator3.next();
                        if (!SCXMLHelper.isDescendant(transitionTarget3, state)) continue;
                        boolean bl = false;
                        bl = hashSet.add(transitionTarget3);
                        while (bl && transitionTarget3 != state) {
                            transitionTarget3 = transitionTarget3.getParent();
                            bl = hashSet.add(transitionTarget3);
                        }
                    }
                }
            }
        }
        return hashSet;
    }

    public static boolean inConflict(Transition transition, Transition transition2, Set set) {
        Set set2 = SCXMLHelper.getStatesExited(transition, set);
        Set set3 = SCXMLHelper.getStatesExited(transition2, set);
        set2.retainAll(set3);
        return !set2.isEmpty();
    }

    public static boolean subtypeOf(Class clazz, Class clazz2) {
        if (clazz == null || clazz2 == null) {
            return false;
        }
        for (Class clazz3 = clazz; clazz3 != (class$java$lang$Object == null ? SCXMLHelper.class$("java.lang.Object") : class$java$lang$Object); clazz3 = clazz3.getSuperclass()) {
            if (clazz3 != clazz2) continue;
            return true;
        }
        return false;
    }

    public static boolean implementationOf(Class clazz, Class clazz2) {
        if (clazz == null || clazz2 == null || !clazz2.isInterface()) {
            return false;
        }
        for (Class clazz3 = clazz; clazz3 != (class$java$lang$Object == null ? SCXMLHelper.class$("java.lang.Object") : class$java$lang$Object); clazz3 = clazz3.getSuperclass()) {
            Class[] classArray = clazz3.getInterfaces();
            for (int i2 = 0; i2 < classArray.length; ++i2) {
                if (classArray[i2] != clazz2) continue;
                return true;
            }
        }
        return false;
    }

    public static void setNodeValue(Node node, String string) {
        switch (node.getNodeType()) {
            case 2: {
                node.setNodeValue(string);
                break;
            }
            case 1: {
                Node node2;
                if (node.hasChildNodes()) {
                    for (node2 = node.getFirstChild(); node2 != null; node2 = node2.getNextSibling()) {
                        if (node2.getNodeType() != 3) continue;
                        node.removeChild(node2);
                    }
                }
                node2 = node.getOwnerDocument().createTextNode(string);
                node.appendChild(node2);
                break;
            }
            case 3: 
            case 4: {
                ((CharacterData)node).setData(string);
                break;
            }
            default: {
                String string2 = new StringBuffer().append("Trying to set value of a strange Node type: ").append(node.getNodeType()).toString();
                throw new IllegalArgumentException(string2);
            }
        }
    }

    public static String getNodeValue(Node node) {
        String string = "";
        if (node == null) {
            return string;
        }
        switch (node.getNodeType()) {
            case 2: {
                string = node.getNodeValue();
                break;
            }
            case 1: {
                if (!node.hasChildNodes()) break;
                StringBuffer stringBuffer = new StringBuffer();
                for (Node node2 = node.getFirstChild(); node2 != null; node2 = node2.getNextSibling()) {
                    if (node2.getNodeType() != 3) continue;
                    stringBuffer.append(((CharacterData)node2).getData());
                }
                string = stringBuffer.toString();
                break;
            }
            case 3: 
            case 4: {
                string = ((CharacterData)node).getData();
                break;
            }
            default: {
                String string2 = new StringBuffer().append("Trying to get value of a strange Node type: ").append(node.getNodeType()).toString();
                throw new IllegalArgumentException(string2);
            }
        }
        return string.trim();
    }

    public static void cloneDatamodel(Datamodel datamodel, Context context, Evaluator evaluator, Log log) {
        if (datamodel == null) {
            return;
        }
        List list = datamodel.getData();
        if (list == null) {
            return;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Data data = (Data)iterator.next();
            Node node = data.getNode();
            Node node2 = null;
            if (node != null) {
                node2 = node.cloneNode(true);
            }
            if (!SCXMLHelper.isStringEmpty(data.getSrc())) {
                context.setLocal(data.getId(), node2);
                continue;
            }
            if (!SCXMLHelper.isStringEmpty(data.getExpr())) {
                Object object = null;
                try {
                    context.setLocal("_ALL_NAMESPACES", data.getNamespaces());
                    object = evaluator.eval(context, data.getExpr());
                    context.setLocal("_ALL_NAMESPACES", null);
                }
                catch (SCXMLExpressionException sCXMLExpressionException) {
                    if (log != null) {
                        log.error(sCXMLExpressionException.getMessage(), sCXMLExpressionException);
                    }
                    Log log2 = LogFactory.getLog(class$org$apache$commons$scxml$SCXMLHelper == null ? SCXMLHelper.class$("org.apache.commons.scxml.SCXMLHelper") : class$org$apache$commons$scxml$SCXMLHelper);
                    log2.error(sCXMLExpressionException.getMessage(), sCXMLExpressionException);
                }
                context.setLocal(data.getId(), object);
                continue;
            }
            context.setLocal(data.getId(), node2);
        }
    }

    public static String escapeXML(String string) {
        if (string == null) {
            return null;
        }
        int n = string.length();
        StringWriter stringWriter = new StringWriter(n + 8);
        for (int i2 = 0; i2 < n; ++i2) {
            char c2 = string.charAt(i2);
            String string2 = null;
            switch (c2) {
                case '\"': {
                    string2 = "quot";
                    break;
                }
                case '&': {
                    string2 = "amp";
                    break;
                }
                case '\'': {
                    string2 = "apos";
                    break;
                }
                case '<': {
                    string2 = "lt";
                    break;
                }
                case '>': {
                    string2 = "gt";
                    break;
                }
            }
            if (string2 == null) {
                if (c2 > '\u007f') {
                    stringWriter.write("&#");
                    stringWriter.write(Integer.toString(c2));
                    stringWriter.write(59);
                    continue;
                }
                stringWriter.write(c2);
                continue;
            }
            stringWriter.write(38);
            stringWriter.write(string2);
            stringWriter.write(59);
        }
        return stringWriter.toString();
    }

    private SCXMLHelper() {
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

