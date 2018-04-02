package org.test;

public class PatchException extends RuntimeException {
    public PatchException(String path) {
        super("Invalid patch on " + path);
    }
}
