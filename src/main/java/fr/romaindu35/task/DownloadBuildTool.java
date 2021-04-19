package fr.romaindu35.task;

import fr.romaindu35.SpigotGradle;
import fr.romaindu35.extensions.SpigotGradleExtension;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class DownloadBuildTool extends DefaultTask {

    private SpigotGradleExtension spigotGradleExtension = SpigotGradle.INSTANCE.spigotGradleExtension;

    @TaskAction
    public void run() throws IOException {
        File spigotBuildDir = new File(spigotGradleExtension.getSpigotBuildDir().get());
        if (Files.exists(spigotBuildDir.toPath())) {
            spigotBuildDir.delete();
        }
        spigotBuildDir.mkdirs();
        URL buildToolUrl = new URL("https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar");

        Files.copy(buildToolUrl.openStream(), spigotBuildDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

}
