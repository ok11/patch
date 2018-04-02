package org.test;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Patch {
    public static abstract class Operation {
        protected final String path;
        protected final Object value;
        protected Operation(String path, Object value) {
            this.path = path;
            this.value = value;
        }
        public String getPath() {
            return path;
        }

        public Object getValue() {
            return value;
        }

        public void perform(Patcheable p) {
            p.apply(this);
        }
    }

    public static class AddOp extends Operation {
        public AddOp(String path, Object value) {
            super(path, value);
        }
    }
    public static class RemoveOp extends Operation {
        public RemoveOp(String path) {
            super(path, null);
        }
    }
    public static class ReplaceOp extends Operation {
        public ReplaceOp(String path, Object value) {
            super(path, value);
        }
    }

    private List<Operation> operations;

    public Patch(Operation ... ops) {
        operations = Arrays.asList(ops);
    }

    public void apply(Patcheable p) {
        p.apply(this);
    }
}
