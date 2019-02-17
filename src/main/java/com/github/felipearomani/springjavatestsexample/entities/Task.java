package com.github.felipearomani.springjavatestsexample.entities;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tasks", indexes = {
        @Index(name = "unique_task", columnList = "title, status", unique = true)
})
@Getter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String code;
    private Status status;

    @Builder
    public Task(String title, String description, String code, Status status) {
        this.title = title;
        this.description = description;
        this.code = code;
        this.status = status;
    }

    public enum Status {
        NEW, IN_PROGRESS, FINISHED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(code, task.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
