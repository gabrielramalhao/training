package com.studies.training.model;

import com.studies.training.dto.TaskDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String content;
    private boolean isChecked;
    @NotNull
    private String conclusionExpectacion;

    public Task() {

    }

    public Task(Long id, @NotNull String name, @NotNull String content, @NotNull String conclusionExpectacion) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.isChecked = false;
        this.conclusionExpectacion = conclusionExpectacion + " 00:00:00";
    }

    public Task(TaskDTO data) {
        this.id = data.id();
        this.name = data.name();
        this.content = data.content();
        this.isChecked = false;
        this.conclusionExpectacion = data.conclusionExpectacion() + " 00:00:00";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public String getConclusionExpectacion() {
        return conclusionExpectacion;
    }

    public void setConclusionExpectacion(String conclusionExpectacion) {
        this.conclusionExpectacion = conclusionExpectacion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
