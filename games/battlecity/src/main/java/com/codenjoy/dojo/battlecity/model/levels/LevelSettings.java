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

import java.util.Optional;

public interface LevelSettings {
    Optional<String> getGameMode();
    Optional<Integer> getInitialPlayerAmmoCount();
    Optional<Integer> getInitialAIAmmoCount();
    Optional<Integer> getMinAmmoBonusOnMap();
    Optional<Integer> getMaxAmmoBonusOnMap();
    Optional<Integer> getMaxAmmoBonusLifeCycle();
    Optional<Integer> getMinAmmoBonusLifeCycle();
    Optional<Integer> getAmmoBonusGenerationCycle();
    Optional<Integer> getAmmoQuantityInAmmoBonus();
    Optional<Integer> getMinHedgeHogsOnMap();
    Optional<Integer> getMaxHedgeHogsOnMap();
    Optional<Integer> getTicksToUpdateHedgehogs();
    Optional<Integer> getMaxHedgehogLifetime();
    Optional<Integer> getMinHedgehogLifetime();
    Optional<Integer> getGameSpeed();
    Optional<Integer> getPlayerTicksPerBullet();
    Optional<Integer> getAiTicksPerBullet();
    Optional<Integer> getInitialPlayerLivesCount();
    Optional<Integer> getInitialAILivesCount();
    Optional<Integer> getMedKitBonusLifeCycle();
    Optional<Integer> getMinMedKitBonusOnMap();
    Optional<Integer> getMaxMedKitBonusOnMap();
    Optional<Integer> getMinMedKitBonusLifeTime();
    Optional<Integer> getMaxMedKitBonusLifeTime();
    Optional<Integer> getMinBogsOnMap();
    Optional<Integer> getMaxBogsOnMap();
    Optional<Integer> getMinBogLifetime();
    Optional<Integer> getMaxBogLifetime();
    Optional<Integer> getTicksToUpdateBogs();
    Optional<Integer> getMinSandsOnMap();
    Optional<Integer> getMaxSandsOnMap();
    Optional<Integer> getMinSandLifetime();
    Optional<Integer> getMaxSandLifetime();
    Optional<Integer> getTicksToUpdateSands();
    Optional<Integer> getMinMoatsOnMap();
    Optional<Integer> getMaxMoatsOnMap();
    Optional<Integer> getMinMoatLifetime();
    Optional<Integer> getMaxMoatLifetime();
    Optional<Integer> getTicksToUpdateMoats();
}
