package fr.romaindu35.extensions;

import org.gradle.api.provider.Property;

public abstract class SpigotGradleExtension {

    public abstract Property<String> getMinecraftVersion();
    public abstract Property<String> getSpigotVersion();
    public abstract Property<String> getSpigotBuildDir();

    public SpigotGradleExtension() {
        getMinecraftVersion().convention("$buildDir/spigot/");
    }


}

