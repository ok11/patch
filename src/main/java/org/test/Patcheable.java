package org.test;

public interface Patcheable {
    boolean validate(Patch.Operation operation);
    boolean validate(Patch patch);
    void apply(Patch.Operation operation);
    void apply(Patch patch);
}
