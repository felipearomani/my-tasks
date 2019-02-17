package com.github.felipearomani.springjavatestsexample.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class IncomingTask {

    private String title;
    private String description;

    @Builder
    @JsonCreator
    public IncomingTask(
            @JsonProperty("title") String title,
            @JsonProperty("description") String description) {
        this.title = title;
        this.description = description;
    }
}
