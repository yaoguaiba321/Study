package com.study.server.excepiton;

import java.util.ArrayList;
import java.util.List;

public class StudyException extends RuntimeException {
    private List<String> errors = new ArrayList<>();

    public StudyException() {
        super();
    }

    public StudyException(String error) {
        this.errors.add(error);
    }

    public StudyException(List<String> errors) {
        this.errors = errors;
    }

    public void addError(String error) {
        this.errors.add(error);
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
