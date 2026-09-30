/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.io;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.model.History;
import org.apache.commons.scxml.model.Initial;
import org.apache.commons.scxml.model.Invoke;
import org.apache.commons.scxml.model.ModelException;
import org.apache.commons.scxml.model.Parallel;
import org.apache.commons.scxml.model.SCXML;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

final class ModelUpdater {
    private static final String ERR_SCXML_NO_INIT = "No SCXML child state with ID \"{0}\" found; illegal initialstate for SCXML document";
    private static final String ERR_STATE_NO_INIT = "No initial element available for {0}";
    private static final String ERR_STATE_BAD_INIT = "Initial state null or not a descendant of {0}";
    private static final String ERR_STATE_BAD_CONTENTS = "{0} should contain either one <parallel>, one <invoke> or any number of <state> children.";
    private static final String ERR_STATE_NO_HIST = "Referenced history state null for {0}";
    private static final String ERR_STATE_BAD_SHALLOW_HIST = "History state for shallow history is not child for {0}";
    private static final String ERR_STATE_BAD_DEEP_HIST = "History state for deep history is not descendant for {0}";
    private static final String ERR_TARGET_NOT_FOUND = "Transition target with ID \"{0}\" not found";
    private static final String ERR_ILLEGAL_TARGETS = "Transition targets \"{0}\" do not satisfy the requirements for target regions belonging to a <parallel>";
    private static final String ERR_HISTORY_SIMPLE_STATE = "Simple {0} contains history elements";
    private static final String ERR_HISTORY_NO_DEFAULT = "No default target specified for history with ID \"{0}\" belonging to {1}";
    private static final String ERR_HISTORY_BAD_DEFAULT = "Default target specified for history with ID \"{0}\" belonging to \"{1}\" is also a history";
    private static final String ERR_INVOKE_NO_TARGETTYPE = "{0} contains <invoke> with no \"targettype\" attribute specified.";
    private static final String ERR_INVOKE_NO_SRC = "{0} contains <invoke> without a \"src\" or \"srcexpr\" attribute specified.";
    private static final String ERR_INVOKE_AMBIGUOUS_SRC = "{0} contains <invoke> with both \"src\" and \"srcexpr\" attributes specified, must specify either one, but not both.";
    static /* synthetic */ Class class$org$apache$commons$scxml$io$ModelUpdater;

    static void updateSCXML(SCXML sCXML) throws ModelException {
        String string = sCXML.getInitial();
        TransitionTarget transitionTarget = (TransitionTarget)sCXML.getTargets().get(string);
        if (transitionTarget == null) {
            ModelUpdater.logAndThrowModelError(ERR_SCXML_NO_INIT, new Object[]{string});
        }
        sCXML.setInitialTarget(transitionTarget);
        Map map = sCXML.getTargets();
        Map map2 = sCXML.getChildren();
        Iterator iterator = map2.keySet().iterator();
        while (iterator.hasNext()) {
            TransitionTarget transitionTarget2 = (TransitionTarget)map2.get(iterator.next());
            if (transitionTarget2 instanceof State) {
                ModelUpdater.updateState((State)transitionTarget2, map);
                continue;
            }
            ModelUpdater.updateParallel((Parallel)transitionTarget2, map);
        }
    }

    private static void updateState(State state, Map map) throws ModelException {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Initial initial = state.getInitial();
        Map map2 = state.getChildren();
        List list = null;
        if (!map2.isEmpty()) {
            if (initial == null) {
                ModelUpdater.logAndThrowModelError(ERR_STATE_NO_INIT, new Object[]{ModelUpdater.getStateName(state)});
            }
            object4 = initial.getTransition();
            ModelUpdater.updateTransition((Transition)object4, map);
            list = ((Transition)object4).getTargets();
            if (list.size() == 0) {
                ModelUpdater.logAndThrowModelError(ERR_STATE_BAD_INIT, new Object[]{ModelUpdater.getStateName(state)});
            } else {
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    object3 = (TransitionTarget)list.get(i2);
                    if (SCXMLHelper.isDescendant((TransitionTarget)object3, state)) continue;
                    ModelUpdater.logAndThrowModelError(ERR_STATE_BAD_INIT, new Object[]{ModelUpdater.getStateName(state)});
                }
            }
        }
        object4 = state.getHistory();
        Iterator iterator = object4.iterator();
        while (iterator.hasNext()) {
            Transition transition;
            if (state.isSimple()) {
                ModelUpdater.logAndThrowModelError(ERR_HISTORY_SIMPLE_STATE, new Object[]{ModelUpdater.getStateName(state)});
            }
            if ((transition = ((History)(object3 = (History)iterator.next())).getTransition()) == null) {
                if (list != null && list.size() > 0) {
                    for (int i3 = 0; i3 < list.size(); ++i3) {
                        if (!(list.get(i3) instanceof History)) continue;
                        ModelUpdater.logAndThrowModelError(ERR_HISTORY_BAD_DEFAULT, new Object[]{((TransitionTarget)object3).getId(), ModelUpdater.getStateName(state)});
                    }
                    transition = new Transition();
                    transition.getTargets().addAll(list);
                    ((History)object3).setTransition(transition);
                } else {
                    ModelUpdater.logAndThrowModelError(ERR_HISTORY_NO_DEFAULT, new Object[]{((TransitionTarget)object3).getId(), ModelUpdater.getStateName(state)});
                }
            }
            ModelUpdater.updateTransition(transition, map);
            object2 = transition.getTargets();
            if (object2.size() == 0) {
                ModelUpdater.logAndThrowModelError(ERR_STATE_NO_HIST, new Object[]{ModelUpdater.getStateName(state)});
            }
            for (int i4 = 0; i4 < object2.size(); ++i4) {
                object = (TransitionTarget)object2.get(i4);
                if (!((History)object3).isDeep()) {
                    if (map2.containsValue(object)) continue;
                    ModelUpdater.logAndThrowModelError(ERR_STATE_BAD_SHALLOW_HIST, new Object[]{ModelUpdater.getStateName(state)});
                    continue;
                }
                if (SCXMLHelper.isDescendant((TransitionTarget)object, state)) continue;
                ModelUpdater.logAndThrowModelError(ERR_STATE_BAD_DEEP_HIST, new Object[]{ModelUpdater.getStateName(state)});
            }
        }
        object3 = state.getTransitionsList();
        for (int i5 = 0; i5 < object3.size(); ++i5) {
            object2 = (Transition)object3.get(i5);
            ModelUpdater.updateTransition((Transition)object2, map);
        }
        Parallel parallel = state.getParallel();
        object2 = state.getInvoke();
        if (object2 != null && parallel != null || object2 != null && !map2.isEmpty() || parallel != null && !map2.isEmpty()) {
            ModelUpdater.logAndThrowModelError(ERR_STATE_BAD_CONTENTS, new Object[]{ModelUpdater.getStateName(state)});
        }
        if (parallel != null) {
            ModelUpdater.updateParallel(parallel, map);
        } else if (object2 != null) {
            boolean bl;
            String string = ((Invoke)object2).getTargettype();
            if (string == null || string.trim().length() == 0) {
                ModelUpdater.logAndThrowModelError(ERR_INVOKE_NO_TARGETTYPE, new Object[]{ModelUpdater.getStateName(state)});
            }
            boolean bl2 = (object = ((Invoke)object2).getSrc()) == null || ((String)object).trim().length() == 0;
            String string2 = ((Invoke)object2).getSrcexpr();
            boolean bl3 = bl = string2 == null || string2.trim().length() == 0;
            if (bl2 && bl) {
                ModelUpdater.logAndThrowModelError(ERR_INVOKE_NO_SRC, new Object[]{ModelUpdater.getStateName(state)});
            }
            if (!bl2 && !bl) {
                ModelUpdater.logAndThrowModelError(ERR_INVOKE_AMBIGUOUS_SRC, new Object[]{ModelUpdater.getStateName(state)});
            }
        } else {
            Iterator iterator2 = map2.keySet().iterator();
            while (iterator2.hasNext()) {
                object = (TransitionTarget)map2.get(iterator2.next());
                if (object instanceof State) {
                    ModelUpdater.updateState((State)object, map);
                    continue;
                }
                if (!(object instanceof Parallel)) continue;
                ModelUpdater.updateParallel((Parallel)object, map);
            }
        }
    }

    private static void updateParallel(Parallel parallel, Map map) throws ModelException {
        Iterator iterator = parallel.getChildren().iterator();
        while (iterator.hasNext()) {
            ModelUpdater.updateState((State)iterator.next(), map);
        }
        Iterator iterator2 = parallel.getTransitionsList().iterator();
        while (iterator2.hasNext()) {
            ModelUpdater.updateTransition((Transition)iterator2.next(), map);
        }
    }

    private static void updateTransition(Transition transition, Map map) throws ModelException {
        String string = transition.getNext();
        if (string == null) {
            return;
        }
        List list = transition.getTargets();
        if (list.size() == 0) {
            boolean bl;
            StringTokenizer stringTokenizer = new StringTokenizer(string);
            while (stringTokenizer.hasMoreTokens()) {
                String string2 = stringTokenizer.nextToken();
                TransitionTarget transitionTarget = (TransitionTarget)map.get(string2);
                if (transitionTarget == null) {
                    ModelUpdater.logAndThrowModelError(ERR_TARGET_NOT_FOUND, new Object[]{string2});
                }
                list.add(transitionTarget);
            }
            if (list.size() > 1 && !(bl = ModelUpdater.verifyTransitionTargets(list))) {
                ModelUpdater.logAndThrowModelError(ERR_ILLEGAL_TARGETS, new Object[]{string});
            }
        }
        transition.getPaths();
    }

    private static void logAndThrowModelError(String string, Object[] objectArray) throws ModelException {
        MessageFormat messageFormat = new MessageFormat(string);
        String string2 = messageFormat.format(objectArray);
        Log log = LogFactory.getLog(class$org$apache$commons$scxml$io$ModelUpdater == null ? (class$org$apache$commons$scxml$io$ModelUpdater = ModelUpdater.class$("org.apache.commons.scxml.io.ModelUpdater")) : class$org$apache$commons$scxml$io$ModelUpdater);
        log.error(string2);
        throw new ModelException(string2);
    }

    private static String getStateName(State state) {
        String string = "anonymous state";
        if (!SCXMLHelper.isStringEmpty(state.getId())) {
            string = new StringBuffer().append("state with ID \"").append(state.getId()).append("\"").toString();
        }
        return string;
    }

    private static boolean verifyTransitionTargets(List list) {
        if (list.size() <= 1) {
            return true;
        }
        TransitionTarget transitionTarget = SCXMLHelper.getLCA((TransitionTarget)list.get(0), (TransitionTarget)list.get(1));
        if (transitionTarget == null || !(transitionTarget instanceof Parallel)) {
            return false;
        }
        Parallel parallel = (Parallel)transitionTarget;
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            TransitionTarget transitionTarget2 = (TransitionTarget)list.get(i2);
            while (transitionTarget2.getParent() != parallel) {
                transitionTarget2 = transitionTarget2.getParent();
            }
            if (hashSet.add(transitionTarget2)) continue;
            return false;
        }
        return hashSet.size() == parallel.getChildren().size();
    }

    private ModelUpdater() {
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

