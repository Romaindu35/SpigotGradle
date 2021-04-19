package fr.romaindu35.task;

import fr.romaindu35.SpigotGradle;
import fr.romaindu35.extensions.SpigotGradleExtension;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.JavaExec;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;

public class SetupSpigot extends DefaultTask {

    private SpigotGradleExtension spigotGradleExtension = SpigotGradle.INSTANCE.spigotGradleExtension;

    private String mc_version = spigotGradleExtension.getMinecraftVersion().get();
    private String spigot_version = spigotGradleExtension.getSpigotVersion().get();
    private String build_dir = spigotGradleExtension.getSpigotBuildDir().get();
    private String groupId = SpigotGradle.INSTANCE.groupId;

    @TaskAction
    public void run() throws IOException {
        if (SpigotGradle.INSTANCE.hasLibraries(groupId, "spigot-api", spigot_version) && SpigotGradle.INSTANCE.hasLibraries(groupId, "spigot", spigot_version)) {
            dependsOn();
            setEnabled(false);
        } else {
            dependsOn("downloadBuildTool");
        }

        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "BuildTools.jar", "--rev", spigot_version);
        processBuilder.directory(new File(build_dir));
        Process process = processBuilder.start();
    }

}
