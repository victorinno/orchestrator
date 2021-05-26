package com.aubay.orchestrator.api;

import java.io.Serializable;

public class Result implements Serializable {

    private Boolean ok;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }
}
