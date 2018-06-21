package com.agh.a2f.fortran.app.util;


import static org.bytedeco.javacpp.LLVM.*;

import java.util.*;

public class MegaStack {

    enum Type {
        STRING, VALUE, BLOCK
    }

    public class MegaStackException extends RuntimeException {
        public MegaStackException(String s) {
            super(s);
        }
    }

    class Section {
        int start;
        boolean useStack;
        Stack<Type> sequence;

        public Section(int start, boolean useStack) {
            this.start = start;
            this.useStack = useStack;
            sequence = new Stack<>();
        }
    }


    public MegaStack() {
        basicBlockRefStack = new Stack<>();
        stringStack = new Stack<>();
        sections = new Stack<>();
        valueRefStack = new Stack<>();
    }

    private Stack<LLVMValueRef> valueRefStack;
    private Stack<LLVMBasicBlockRef> basicBlockRefStack;
    private Stack<String> stringStack;
    private Stack<Section> sections;
    private int index;

    public void startSection() {
        startSection(true);
    }

    public void startSection(boolean useStack) {
        sections.push(new Section(index, useStack));
    }

    public void endSection() {
        Section section = sections.pop();
        for (Type t : section.sequence) {
            switch (t) {
                case STRING:
                    stringStack.pop();
                    break;
                case VALUE:
                    valueRefStack.pop();
                    break;
                case BLOCK:
                    basicBlockRefStack.pop();
                    break;
            }
        }
    }

    public void push(LLVMValueRef valueRef) {
        Section section = sections.peek();
        if (section.useStack) {
            index++;
            section.sequence.push(Type.VALUE);
            valueRefStack.push(valueRef);
        }
    }

    public void push(String val) {
        Section section = sections.peek();
        if (section.useStack) {
            index++;
            section.sequence.push(Type.STRING);
            stringStack.push(val);
        }

    }

    public void push(LLVMBasicBlockRef basicBlockRef) {
        Section section = sections.peek();
        if (section.useStack) {
            index++;
            section.sequence.push(Type.BLOCK);
            basicBlockRefStack.push(basicBlockRef);
        }
    }

    public Object pop() {
        Section actual = sections.peek();
        if (actual.start < index) {
            index--;
            switch (actual.sequence.pop()) {
                case BLOCK:
                    return basicBlockRefStack.pop();
                case VALUE:
                    return valueRefStack.pop();
                case STRING:
                    return stringStack.pop();
            }
        }
        throw new MegaStackException("Stack is empty");
    }

    public LLVMValueRef popValue() {
        Section actual = sections.peek();
        if (isToPop(actual, Type.VALUE)) {
            actual.sequence.pop();
            index--;
            return valueRefStack.pop();
        }
        throw new MegaStackException("ValueRef is not on top of the stack!");
    }

    public LLVMBasicBlockRef popBlock()  {
        Section actual = sections.peek();
        if (isToPop(actual, Type.BLOCK)) {
            actual.sequence.pop();
            index--;
            return basicBlockRefStack.pop();
        }
        throw new MegaStackException("BasicBlockRef is not on top of the stack!");
    }

    public String popString()  {
        Section actual = sections.peek();
        if (isToPop(actual, Type.STRING)) {
            actual.sequence.pop();
            index--;
            return stringStack.pop();
        }
        throw new MegaStackException("String is not on top of the stack!");
    }

    private boolean isToPop(Section section, Type type) {
        assert section.sequence.peek() != null;
        return section.start < index && section.sequence.peek().equals(type);
    }


    public Object peek(){
        Section actual = sections.peek();
        if (actual.start < index) {
            switch (actual.sequence.peek()) {
                case BLOCK:
                    return basicBlockRefStack.peek();
                case VALUE:
                    return valueRefStack.peek();
                case STRING:
                    return stringStack.peek();
            }
        }
        throw new MegaStackException("Stack is empty");
    }


    public Type nextType() {
        return sections.pop().sequence.peek();
    }

    public int getSize(){
        return sections.peek().sequence.size();
    }
    public int size(){
        return getSize();
    }

    public boolean wantData(){
        return !sections.empty() && sections.peek().useStack;
    }

}
