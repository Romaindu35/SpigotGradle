package fr.romaindu35;

import fr.romaindu35.extensions.SpigotGradleExtension;
import fr.romaindu35.task.DownloadBuildTool;
import fr.romaindu35.task.SetupSpigot;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.io.File;
import java.util.ArrayList;

public class SpigotGradle implements Plugin<Project> {

    public SpigotGradleExtension spigotGradleExtension;
    public static SpigotGradle INSTANCE;

    public String groupId = "org.spigotmc";

    @Override
    public void apply(Project project) {
        INSTANCE = this;

        /* Set extension*/
        spigotGradleExtension = project.getExtensions().create("spigot", SpigotGradleExtension.class);

        DownloadBuildTool downloadBuildTool = project.getTasks().create("downloadBuildTool", DownloadBuildTool.class);
        downloadBuildTool.setGroup("spigot");

        SetupSpigot setupSpigot = project.getTasks().create("setupSpigot", SetupSpigot.class);
        setupSpigot.setGroup("spigot");
    }

    public boolean hasLibraries(String groupId, String artifactId, String spigot_version) {
        File localMavenRepo = new File(new File(System.getProperty("user.home")), ".m2/repository/");
        File file = new File(localMavenRepo, groupId.replace('.', '/') + "/" + artifactId + "/" + spigot_version + "/");
        return file.exists();
    }
}
