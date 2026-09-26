/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import java.util.Collection;

public interface ICommandList {
    default public CommandListManager getManager() {
    }

    default public Collection getCommands() {
    }

    default public String getName() {
    }

    default public String getInvocationSource() {
    }

    default public ICommandList add(Command command) {
    }

    default public ICommandList add(int n, Command command) {
    }

    default public ICommandList add(CommandList commandList) {
    }

    default public ICommandList add(int n, CommandList commandList) {
    }

    default public ICommandList add(Collection collection) {
    }

    default public ICommandList add(int n, Collection collection) {
    }

    default public void execute(String string) {
    }

    default public void commandFinishedWithPostCommand(Command command) {
    }

    default public void commandFinishedWithPostSequence(CommandList commandList) {
    }

    default public int getPos() {
    }

    default public int size() {
    }

    default public boolean hasActiveCommand() {
    }

    default public Command getActiveCommand() {
    }

    default public Command getErrorCommand() {
    }

    default public void setErrorCommand(Command command) {
    }

    default public void commandFinished() {
    }

    default public void stop(String string) {
    }

    default public void commandAborted(long l) {
    }

    default public void commandAborted(Exception exception) {
    }

    default public void commandAborted(String string, String string2) {
    }

    default public void commandAborted(String string) {
    }

    default public void addMonitor(Monitor monitor) {
    }

    default public void put(Object object, Object object2) {
    }

    default public Object get(Object object) {
    }

    default public Object remove(Object object) {
    }

    default public String toString() {
    }
}

