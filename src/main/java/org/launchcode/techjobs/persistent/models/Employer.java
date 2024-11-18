package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotNull
    @NotBlank(message = "A location is required.")
    @Size(max = 50, message = "Location should be no longer than 50 characters.")
    private String location;

    @OneToMany
    @JoinColumn(name = "employer_id")
    private final List<Job> jobs = new ArrayList<>();

    public Employer() {}


    public @NotNull(message = "A name is required.") @Size(max = 50, message = "Name should be in between 3 and 50 characters.") String getLocation() {
        return location;
    }

    public void setLocation(@NotNull(message = "A name is required.") @Size(max = 50, message = "Name should be in between 3 and 50 characters.") String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
