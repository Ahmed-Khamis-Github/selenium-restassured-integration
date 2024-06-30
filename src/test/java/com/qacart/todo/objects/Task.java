package com.qacart.todo.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    @JsonProperty("isCompleted")
    private boolean isCompleted;
    @JsonProperty("item")
    private String item;

    public Task(boolean isCompleted, String item) {
        this.isCompleted = isCompleted;
        this.item = item;
    }

   
}
