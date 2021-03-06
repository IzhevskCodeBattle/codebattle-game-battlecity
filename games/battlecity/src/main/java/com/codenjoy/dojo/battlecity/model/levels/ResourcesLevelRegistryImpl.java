package com.codenjoy.dojo.battlecity.model.levels;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 - 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResourcesLevelRegistryImpl implements LevelRegistry {

    private static final String MAPS_LIST_FILE = "maps.list";
    private String classPathPrefix;
    private String mapExt;
    private String settingsExt;
    private LevelSettingsLoader levelSettingsLoader;

    public ResourcesLevelRegistryImpl(String classPathPrefix, String mapExt, String settingsExt,
                                      LevelSettingsLoader levelSettingsLoader) {
        this.classPathPrefix = classPathPrefix;
        this.mapExt = mapExt;
        this.settingsExt = settingsExt;
        this.levelSettingsLoader = levelSettingsLoader;
    }

    @Override
    public LevelInfo getLevelByName(String levelName) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(getBasePath() + levelName + mapExt);

        String mapBody = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));

        LevelSettings levelSettings = getLevelSettings(levelName);

        return new LevelInfo(mapBody, levelSettings);
    }

    @Override
    public List<String> getAvailableMapsNames() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(getBasePath() + MAPS_LIST_FILE)) {
            return new BufferedReader(new InputStreamReader(is,
                            StandardCharsets.UTF_8)).lines()
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private LevelSettings getLevelSettings(String levelName) {
        InputStream settingsInputStream =
                getClass().getClassLoader().getResourceAsStream(getBasePath() + levelName + settingsExt);

        LevelSettings levelSettings = null;

        if (settingsInputStream != null) {
            levelSettings = levelSettingsLoader.loadLevelSettings(settingsInputStream);
        }
        return levelSettings;
    }

    private String getBasePath() {
        return classPathPrefix;
    }
}
