/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.semantics;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.NotificationRegistry;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.SCXMLSemantics;
import org.apache.commons.scxml.Step;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.invoke.Invoker;
import org.apache.commons.scxml.invoke.InvokerException;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.Executable;
import org.apache.commons.scxml.model.History;
import org.apache.commons.scxml.model.Initial;
import org.apache.commons.scxml.model.Invoke;
import org.apache.commons.scxml.model.ModelException;
import org.apache.commons.scxml.model.Parallel;
import org.apache.commons.scxml.model.Param;
import org.apache.commons.scxml.model.Path;
import org.apache.commons.scxml.model.SCXML;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;
import org.apache.commons.scxml.semantics.TransitionTargetComparator;

public class SCXMLSemanticsImpl
implements SCXMLSemantics,
Serializable {
    private static final long serialVersionUID = 1L;
    private Log appLog = LogFactory.getLog(class$org$apache$commons$scxml$SCXMLSemantics == null ? (class$org$apache$commons$scxml$SCXMLSemantics = SCXMLSemanticsImpl.class$("org.apache.commons.scxml.SCXMLSemantics")) : class$org$apache$commons$scxml$SCXMLSemantics);
    private TransitionTargetComparator targetComparator = new TransitionTargetComparator();
    private static final String NAMESPACES_KEY = "_ALL_NAMESPACES";
    private static final String ERR_ILLEGAL_ALLOC = ".error.illegalalloc";
    static /* synthetic */ Class class$org$apache$commons$scxml$SCXMLSemantics;

    public SCXML normalizeStateMachine(SCXML sCXML, ErrorReporter errorReporter) {
        return sCXML;
    }

    public void determineInitialStates(SCXML sCXML, Set set, List list, ErrorReporter errorReporter, SCInstance sCInstance) throws ModelException {
        TransitionTarget transitionTarget = sCXML.getInitialTarget();
        if (transitionTarget == null) {
            errorReporter.onError("NO_INITIAL", "SCXML initialstate is missing!", sCXML);
        } else {
            set.add(transitionTarget);
            this.determineTargetStates(set, errorReporter, sCInstance);
            Set set2 = SCXMLHelper.getAncestorClosure(set, null);
            Object[] objectArray = set2.toArray();
            set2.clear();
            Arrays.sort(objectArray, this.getTTComparator());
            List list2 = Arrays.asList(objectArray);
            Collections.reverse(list2);
            list.addAll(list2);
        }
    }

    public void executeActions(Step step, SCXML sCXML, EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance) throws ModelException {
        TransitionTarget transitionTarget;
        Serializable serializable;
        Object object;
        Serializable serializable2;
        NotificationRegistry notificationRegistry = sCInstance.getNotificationRegistry();
        Collection collection = step.getAfterStatus().getEvents();
        Map map = sCInstance.getInvokers();
        Iterator iterator = step.getExitList().iterator();
        while (iterator.hasNext()) {
            Object object2;
            serializable2 = (TransitionTarget)iterator.next();
            object = ((TransitionTarget)serializable2).getOnExit();
            try {
                object2 = ((Executable)object).getActions().iterator();
                while (object2.hasNext()) {
                    ((Action)object2.next()).execute(eventDispatcher, errorReporter, sCInstance, this.appLog, collection);
                }
            }
            catch (SCXMLExpressionException sCXMLExpressionException) {
                errorReporter.onError("EXPRESSION_ERROR", sCXMLExpressionException.getMessage(), object);
            }
            if (map.containsKey(serializable2)) {
                object2 = (Invoker)map.get(serializable2);
                try {
                    object2.cancel();
                }
                catch (InvokerException invokerException) {
                    serializable = new TriggerEvent(new StringBuffer().append(((TransitionTarget)serializable2).getId()).append(".invoke.cancel.failed").toString(), 5);
                    collection.add(serializable);
                }
                map.remove(serializable2);
            }
            notificationRegistry.fireOnExit((TransitionTarget)serializable2, (TransitionTarget)serializable2);
            notificationRegistry.fireOnExit(sCXML, (TransitionTarget)serializable2);
            object2 = new TriggerEvent(new StringBuffer().append(((TransitionTarget)serializable2).getId()).append(".exit").toString(), 2);
            collection.add(object2);
        }
        iterator = step.getTransitList().iterator();
        while (iterator.hasNext()) {
            serializable2 = (Transition)iterator.next();
            try {
                object = ((Executable)serializable2).getActions().iterator();
                while (object.hasNext()) {
                    ((Action)object.next()).execute(eventDispatcher, errorReporter, sCInstance, this.appLog, collection);
                }
            }
            catch (SCXMLExpressionException sCXMLExpressionException) {
                errorReporter.onError("EXPRESSION_ERROR", sCXMLExpressionException.getMessage(), serializable2);
            }
            object = ((Transition)serializable2).getRuntimeTargets();
            for (int i2 = 0; i2 < object.size(); ++i2) {
                transitionTarget = (TransitionTarget)object.get(i2);
                notificationRegistry.fireOnTransition((Transition)serializable2, ((Executable)serializable2).getParent(), transitionTarget, (Transition)serializable2);
                notificationRegistry.fireOnTransition(sCXML, ((Executable)serializable2).getParent(), transitionTarget, (Transition)serializable2);
            }
        }
        iterator = step.getEntryList().iterator();
        while (iterator.hasNext()) {
            Object object3;
            Object object4;
            serializable2 = (TransitionTarget)iterator.next();
            object = ((TransitionTarget)serializable2).getOnEntry();
            try {
                object4 = ((Executable)object).getActions().iterator();
                while (object4.hasNext()) {
                    ((Action)object4.next()).execute(eventDispatcher, errorReporter, sCInstance, this.appLog, collection);
                }
            }
            catch (SCXMLExpressionException sCXMLExpressionException) {
                errorReporter.onError("EXPRESSION_ERROR", sCXMLExpressionException.getMessage(), object);
            }
            notificationRegistry.fireOnEntry((TransitionTarget)serializable2, (TransitionTarget)serializable2);
            notificationRegistry.fireOnEntry(sCXML, (TransitionTarget)serializable2);
            object4 = new TriggerEvent(new StringBuffer().append(((TransitionTarget)serializable2).getId()).append(".entry").toString(), 2);
            collection.add(object4);
            if (!(serializable2 instanceof State)) continue;
            transitionTarget = (State)serializable2;
            serializable = ((State)transitionTarget).getInitial();
            if (((State)transitionTarget).isComposite() && serializable != null) {
                try {
                    object3 = ((Initial)serializable).getTransition().getActions().iterator();
                    while (object3.hasNext()) {
                        ((Action)object3.next()).execute(eventDispatcher, errorReporter, sCInstance, this.appLog, collection);
                    }
                }
                catch (SCXMLExpressionException sCXMLExpressionException) {
                    errorReporter.onError("EXPRESSION_ERROR", sCXMLExpressionException.getMessage(), serializable);
                }
            }
            if (!((State)transitionTarget).isFinal()) continue;
            object3 = (State)transitionTarget.getParent();
            String string = "";
            if (object3 != null) {
                string = ((TransitionTarget)object3).getId();
            }
            object4 = new TriggerEvent(new StringBuffer().append(string).append(".done").toString(), 2);
            collection.add(object4);
            if (object3 != null) {
                sCInstance.setDone((TransitionTarget)object3, true);
            }
            if (object3 == null || !((State)object3).isRegion()) continue;
            Parallel parallel = (Parallel)((TransitionTarget)object3).getParent();
            int n = 0;
            int n2 = parallel.getChildren().size();
            Iterator iterator2 = parallel.getChildren().iterator();
            while (iterator2.hasNext()) {
                State state = (State)iterator2.next();
                if (!sCInstance.isDone(state)) continue;
                ++n;
            }
            if (n != n2) continue;
            object4 = new TriggerEvent(new StringBuffer().append(parallel.getId()).append(".done").toString(), 2);
            collection.add(object4);
            sCInstance.setDone(parallel, true);
            if (!sCXML.isLegacy()) continue;
            object4 = new TriggerEvent(new StringBuffer().append(parallel.getParent().getId()).append(".done").toString(), 2);
            collection.add(object4);
            sCInstance.setDone(parallel.getParentState(), true);
        }
    }

    public void enumerateReachableTransitions(SCXML sCXML, Step step, ErrorReporter errorReporter) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet(step.getBeforeStatus().getStates());
        LinkedList linkedList = new LinkedList(hashSet2);
        while (!linkedList.isEmpty()) {
            TransitionTarget transitionTarget = (TransitionTarget)linkedList.removeFirst();
            Object object = transitionTarget.getTransitionsList().iterator();
            while (object.hasNext()) {
                Transition transition = (Transition)object.next();
                if (hashSet.contains(transition)) continue;
                hashSet.add(transition);
                step.getTransitList().add(transition);
            }
            object = transitionTarget.getParent();
            if (object == null || hashSet2.contains(object)) continue;
            hashSet2.add(object);
            linkedList.addLast(object);
        }
        hashSet.clear();
        hashSet2.clear();
        linkedList.clear();
    }

    public void filterTransitionsSet(Step step, EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance) throws ModelException {
        Object object;
        Object object2;
        Object object3;
        Serializable serializable;
        Object object4;
        HashSet hashSet = new HashSet(step.getBeforeStatus().getEvents().size() + step.getExternalEvents().size());
        hashSet.addAll(step.getBeforeStatus().getEvents());
        hashSet.addAll(step.getExternalEvents());
        Object object5 = sCInstance.getInvokers().keySet().iterator();
        while (object5.hasNext()) {
            object4 = (State)object5.next();
            if (!this.finalizeMatch(object4.getId(), hashSet) || (serializable = object4.getInvoke().getFinalize()) == null) continue;
            try {
                object3 = ((Executable)serializable).getActions().iterator();
                while (object3.hasNext()) {
                    ((Action)object3.next()).execute(eventDispatcher, errorReporter, sCInstance, this.appLog, step.getAfterStatus().getEvents());
                }
            }
            catch (SCXMLExpressionException sCXMLExpressionException) {
                errorReporter.onError("EXPRESSION_ERROR", sCXMLExpressionException.getMessage(), serializable);
            }
        }
        object5 = new LinkedList();
        object4 = step.getTransitList().iterator();
        while (object4.hasNext()) {
            serializable = (Transition)object4.next();
            object3 = ((Transition)serializable).getEvent();
            if (!this.eventMatch((String)object3, hashSet)) {
                object5.add(serializable);
                continue;
            }
            object2 = ((Transition)serializable).getCond();
            if (SCXMLHelper.isStringEmpty((String)object2)) {
                object = Boolean.TRUE;
            } else {
                try {
                    Context context = sCInstance.getContext(((Executable)serializable).getParent());
                    context.setLocal(NAMESPACES_KEY, ((Transition)serializable).getNamespaces());
                    object = sCInstance.getEvaluator().evalCond(context, ((Transition)serializable).getCond());
                    context.setLocal(NAMESPACES_KEY, null);
                }
                catch (SCXMLExpressionException sCXMLExpressionException) {
                    object = Boolean.FALSE;
                    errorReporter.onError("EXPRESSION_ERROR", sCXMLExpressionException.getMessage(), serializable);
                }
            }
            if (((Boolean)object).booleanValue()) continue;
            object5.add(serializable);
        }
        step.getTransitList().removeAll((Collection)object5);
        hashSet.clear();
        object5.clear();
        if (step.getTransitList().size() > 1) {
            object4 = step.getTransitList().toArray();
            serializable = new LinkedHashSet();
            block7: for (int i2 = 0; i2 < ((Object[])object4).length; ++i2) {
                object = (Transition)object4[i2];
                object2 = ((Executable)object).getParent();
                for (int i3 = i2 + 1; i3 < ((Object[])object4).length; ++i3) {
                    Transition transition = (Transition)object4[i3];
                    TransitionTarget transitionTarget = transition.getParent();
                    if (SCXMLHelper.isDescendant(transitionTarget, (TransitionTarget)object2)) {
                        object5.add(object);
                        continue block7;
                    }
                    if (SCXMLHelper.isDescendant((TransitionTarget)object2, transitionTarget)) {
                        object5.add(transition);
                        continue;
                    }
                    serializable.add(object);
                    serializable.add(transition);
                }
            }
            serializable.removeAll((Collection)object5);
            if (serializable.size() > 0) {
                HashSet hashSet2 = new HashSet();
                object = serializable.iterator();
                while (object.hasNext()) {
                    object2 = (Transition)object.next();
                    TransitionTarget transitionTarget = ((Executable)object2).getParent();
                    if (hashSet2.contains(transitionTarget)) {
                        object5.add(object2);
                        continue;
                    }
                    hashSet2.add(transitionTarget);
                }
            }
            step.getTransitList().removeAll((Collection)object5);
        }
    }

    public Set seedTargetSet(Set set, List list, ErrorReporter errorReporter) {
        Object object;
        Object object2;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Object object3 = list.iterator();
        while (object3.hasNext()) {
            object2 = (Transition)object3.next();
            if (((Transition)object2).getTargets().size() > 0) {
                hashSet.addAll(((Transition)object2).getTargets());
            }
            object = ((Transition)object2).getPaths();
            for (int i2 = 0; i2 < object.size(); ++i2) {
                Path path = (Path)object.get(i2);
                if (!path.isCrossRegion()) continue;
                List list2 = path.getRegionsEntered();
                Iterator iterator = list2.iterator();
                while (iterator.hasNext()) {
                    State state = (State)iterator.next();
                    hashSet2.addAll(((Parallel)state.getParent()).getChildren());
                }
            }
        }
        object3 = new HashSet(set);
        object3.addAll(hashSet);
        object3 = SCXMLHelper.getAncestorClosure((Set)object3, null);
        hashSet2.removeAll((Collection)object3);
        object2 = hashSet2.iterator();
        while (object2.hasNext()) {
            object = (State)object2.next();
            hashSet.add(object);
        }
        return hashSet;
    }

    public void determineTargetStates(Set set, ErrorReporter errorReporter, SCInstance sCInstance) throws ModelException {
        long l = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList(set);
        set.clear();
        while (!linkedList.isEmpty()) {
            Object object;
            TransitionTarget transitionTarget;
            if (System.currentTimeMillis() - l > 5000L) {
                throw new ModelException("InfiniteLoop");
            }
            TransitionTarget transitionTarget2 = (TransitionTarget)linkedList.removeFirst();
            if (transitionTarget2 instanceof State) {
                transitionTarget = (State)transitionTarget2;
                if (((State)transitionTarget).isSimple()) {
                    set.add(transitionTarget);
                    continue;
                }
                if (((State)transitionTarget).isOrthogonal()) {
                    linkedList.addLast(((State)transitionTarget).getParallel());
                    continue;
                }
                object = ((State)transitionTarget).getInitial().getTransition().getTargets();
                linkedList.addAll((Collection)object);
                continue;
            }
            if (transitionTarget2 instanceof Parallel) {
                transitionTarget = (Parallel)transitionTarget2;
                object = ((Parallel)transitionTarget).getChildren().iterator();
                while (object.hasNext()) {
                    linkedList.addLast(object.next());
                }
                continue;
            }
            if (transitionTarget2 instanceof History) {
                transitionTarget = (History)transitionTarget2;
                if (sCInstance.isEmpty((History)transitionTarget)) {
                    linkedList.addAll(((History)transitionTarget).getTransition().getRuntimeTargets());
                    continue;
                }
                linkedList.addAll(sCInstance.getLastConfiguration((History)transitionTarget));
                continue;
            }
            throw new ModelException(new StringBuffer().append("Unknown TransitionTarget subclass:").append(transitionTarget2.getClass().getName()).toString());
        }
    }

    public void updateHistoryStates(Step step, ErrorReporter errorReporter, SCInstance sCInstance) {
        Set set = step.getBeforeStatus().getStates();
        Iterator iterator = step.getExitList().iterator();
        while (iterator.hasNext()) {
            State state;
            Object object = iterator.next();
            if (!(object instanceof State) || !(state = (State)object).hasHistory()) continue;
            HashSet hashSet = null;
            HashSet hashSet2 = null;
            Iterator iterator2 = state.getHistory().iterator();
            while (iterator2.hasNext()) {
                History history = (History)iterator2.next();
                if (history.isDeep()) {
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet();
                        Iterator iterator3 = set.iterator();
                        while (iterator3.hasNext()) {
                            State state2 = (State)iterator3.next();
                            if (!SCXMLHelper.isDescendant(state2, state)) continue;
                            hashSet2.add(state2);
                        }
                    }
                    sCInstance.setLastConfiguration(history, hashSet2);
                    continue;
                }
                if (hashSet == null) {
                    hashSet = new HashSet();
                    hashSet.addAll(state.getChildren().values());
                    hashSet.retainAll(SCXMLHelper.getAncestorClosure(set, null));
                }
                sCInstance.setLastConfiguration(history, hashSet);
            }
            hashSet = null;
            hashSet2 = null;
        }
    }

    public void followTransitions(Step step, ErrorReporter errorReporter, SCInstance sCInstance) throws ModelException {
        Object object;
        Object[] objectArray;
        Object[] objectArray2;
        Serializable serializable;
        Set set;
        Object object2;
        Set set2 = step.getBeforeStatus().getStates();
        List list = step.getTransitList();
        HashSet hashSet = new HashSet();
        Object object3 = list.iterator();
        while (object3.hasNext()) {
            object2 = (Transition)object3.next();
            set = SCXMLHelper.getStatesExited((Transition)object2, set2);
            hashSet.addAll(set);
        }
        object3 = new HashSet(set2);
        object3.removeAll(hashSet);
        object2 = this.seedTargetSet((Set)object3, list, errorReporter);
        set = step.getAfterStatus().getStates();
        set.addAll((Collection)object2);
        this.determineTargetStates(set, errorReporter, sCInstance);
        Set set3 = SCXMLHelper.getAncestorClosure(set, (Set)object2);
        object2.clear();
        Object object4 = list.iterator();
        while (object4.hasNext()) {
            serializable = (Transition)object4.next();
            objectArray2 = ((Transition)serializable).getPaths();
            for (int i2 = 0; i2 < objectArray2.size(); ++i2) {
                Path path = (Path)objectArray2.get(i2);
                set3.addAll(path.getDownwardSegment());
            }
            objectArray = ((Transition)serializable).getRuntimeTargets();
            for (int i3 = 0; i3 < objectArray.size(); ++i3) {
                object = (TransitionTarget)objectArray.get(i3);
                if (!(object instanceof History)) continue;
                set3.remove(object);
            }
        }
        set.addAll((Collection)object3);
        object3.clear();
        if (!SCXMLHelper.isLegalConfig(set, errorReporter)) {
            throw new ModelException("Illegal state machine configuration!");
        }
        object4 = SCXMLHelper.getAncestorClosure(hashSet, null);
        object4.removeAll(hashSet);
        serializable = new HashSet(set3);
        serializable.retainAll((Collection)object4);
        if (!serializable.isEmpty()) {
            set3.removeAll((Collection)((Object)serializable));
            if (this.appLog.isInfoEnabled()) {
                this.appLog.info(new StringBuffer().append("Removed exited ancestor(s) ").append(serializable).append(" from entered states ").append(set3).append(" when exited ").append(hashSet).append(" for target(s) ").append(set).toString());
            }
        }
        objectArray2 = hashSet.toArray();
        hashSet.clear();
        objectArray = set3.toArray();
        set3.clear();
        Arrays.sort(objectArray2, this.getTTComparator());
        Arrays.sort(objectArray, this.getTTComparator());
        step.getExitList().addAll(Arrays.asList(objectArray2));
        List list2 = Arrays.asList(objectArray);
        Collections.reverse(list2);
        step.getEntryList().addAll(list2);
        object = list2.iterator();
        while (object.hasNext()) {
            Object object5 = object.next();
            if (!(object5 instanceof State)) continue;
            sCInstance.setDone((State)object5, false);
        }
    }

    public void processInvokes(TriggerEvent[] triggerEventArray, ErrorReporter errorReporter, SCInstance sCInstance) throws ModelException {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(triggerEventArray));
        Iterator iterator = sCInstance.getInvokers().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            String string = ((TransitionTarget)entry.getKey()).getId();
            if (this.finalizeMatch(string, hashSet)) continue;
            Invoker invoker = (Invoker)entry.getValue();
            try {
                invoker.parentEvents(triggerEventArray);
            }
            catch (InvokerException invokerException) {
                this.appLog.error(invokerException.getMessage(), invokerException);
                throw new ModelException(invokerException.getMessage(), invokerException.getCause());
            }
        }
    }

    public void initiateInvokes(Step step, ErrorReporter errorReporter, SCInstance sCInstance) {
        Evaluator evaluator = sCInstance.getEvaluator();
        Collection collection = step.getAfterStatus().getEvents();
        Iterator iterator = step.getAfterStatus().getStates().iterator();
        while (iterator.hasNext()) {
            Serializable serializable;
            Serializable serializable2;
            Object object;
            String string;
            State state = (State)iterator.next();
            Context context = sCInstance.getContext(state);
            Invoke invoke = state.getInvoke();
            if (invoke == null || sCInstance.getInvoker(state) != null) continue;
            String string2 = invoke.getSrc();
            if (string2 == null) {
                string = invoke.getSrcexpr();
                object = null;
                try {
                    context.setLocal(NAMESPACES_KEY, invoke.getNamespaces());
                    object = evaluator.eval(context, string);
                    context.setLocal(NAMESPACES_KEY, null);
                    string2 = String.valueOf(object);
                }
                catch (SCXMLExpressionException sCXMLExpressionException) {
                    errorReporter.onError("EXPRESSION_ERROR", sCXMLExpressionException.getMessage(), invoke);
                }
            }
            string = string2;
            object = invoke.getPathResolver();
            if (object != null && string2 != null) {
                string = invoke.getPathResolver().resolvePath(string2);
            }
            String string3 = invoke.getTargettype();
            Invoker invoker = null;
            try {
                invoker = sCInstance.newInvoker(string3);
            }
            catch (InvokerException invokerException) {
                serializable2 = new TriggerEvent(new StringBuffer().append(state.getId()).append(".invoke.failed").toString(), 5);
                collection.add(serializable2);
                continue;
            }
            invoker.setParentStateId(state.getId());
            invoker.setSCInstance(sCInstance);
            List list = invoke.params();
            serializable2 = new HashMap();
            Iterator iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                serializable = (Param)iterator2.next();
                String string4 = ((Param)serializable).getExpr();
                Object object2 = null;
                context.setLocal(NAMESPACES_KEY, ((Param)serializable).getNamespaces());
                if (string4 != null && string4.trim().length() > 0) {
                    try {
                        object2 = evaluator.eval(context, string4);
                    }
                    catch (SCXMLExpressionException sCXMLExpressionException) {
                        errorReporter.onError("EXPRESSION_ERROR", sCXMLExpressionException.getMessage(), invoke);
                    }
                } else {
                    try {
                        object2 = evaluator.evalLocation(context, ((Param)serializable).getName());
                        if (object2 == null) {
                            TriggerEvent triggerEvent = new TriggerEvent(new StringBuffer().append(state.getId()).append(ERR_ILLEGAL_ALLOC).toString(), 5);
                            collection.add(triggerEvent);
                        }
                    }
                    catch (SCXMLExpressionException sCXMLExpressionException) {
                        errorReporter.onError("EXPRESSION_ERROR", sCXMLExpressionException.getMessage(), invoke);
                    }
                }
                context.setLocal(NAMESPACES_KEY, null);
                serializable2.put(((Param)serializable).getName(), object2);
            }
            try {
                invoker.invoke(string, (Map)((Object)serializable2));
            }
            catch (InvokerException invokerException) {
                serializable = new TriggerEvent(new StringBuffer().append(state.getId()).append(".invoke.failed").toString(), 5);
                collection.add(serializable);
                continue;
            }
            sCInstance.setInvoker(state, invoker);
        }
    }

    protected boolean eventMatch(String string, Set set) {
        if (SCXMLHelper.isStringEmpty(string)) {
            return true;
        }
        String string2 = string.trim();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            TriggerEvent triggerEvent = (TriggerEvent)iterator.next();
            String string3 = triggerEvent.getName();
            if (string3 == null) continue;
            String string4 = string3.trim();
            if (string4.equals(string2)) {
                return true;
            }
            if (triggerEvent.getType() != 2 && string2.equals("*")) {
                return true;
            }
            if (!string2.endsWith(".*") || !string4.startsWith(string2.substring(0, string2.length() - 1))) continue;
            return true;
        }
        return false;
    }

    protected boolean finalizeMatch(String string, Set set) {
        String string2 = new StringBuffer().append(string).append(".invoke.").toString();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String string3 = ((TriggerEvent)iterator.next()).getName();
            if (string3 == null || !string3.trim().startsWith(string2)) continue;
            return true;
        }
        return false;
    }

    protected Comparator getTTComparator() {
        return this.targetComparator;
    }

    protected void setLog(Log log) {
        this.appLog = log;
    }

    protected Log getLog() {
        return this.appLog;
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

