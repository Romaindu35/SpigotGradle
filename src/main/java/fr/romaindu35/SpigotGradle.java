package fr.romaindu35;

import groovy.lang.Closure;
import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

public class SpigotGradle implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.task("hello").doLast(task -> System.out.println("cc"));
    }
}
