/*
 * Copyright 2014 Matthew Collins
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.thinkofdeath.thinkcraft.shared.block.blocks;

import uk.co.thinkofdeath.thinkcraft.shared.Face;
import uk.co.thinkofdeath.thinkcraft.shared.IMapViewer;
import uk.co.thinkofdeath.thinkcraft.shared.Texture;
import uk.co.thinkofdeath.thinkcraft.shared.block.Block;
import uk.co.thinkofdeath.thinkcraft.shared.block.BlockFactory;
import uk.co.thinkofdeath.thinkcraft.shared.block.enums.MonsterEggVariant;
import uk.co.thinkofdeath.thinkcraft.shared.block.states.EnumState;
import uk.co.thinkofdeath.thinkcraft.shared.block.states.StateKey;
import uk.co.thinkofdeath.thinkcraft.shared.block.states.StateMap;

public class BlockMonsterEgg extends BlockFactory {

    public final StateKey<MonsterEggVariant> VARIANT = stateAllocator.alloc("variant", new EnumState<>(MonsterEggVariant.class));

    private final Texture[] textures = new Texture[MonsterEggVariant.values().length];

    public BlockMonsterEgg(IMapViewer iMapViewer) {
        super(iMapViewer);

        MonsterEggVariant[] values = MonsterEggVariant.values();
        for (int i = 0; i < values.length; i++) {
            textures[i] = mapViewer.getTexture(values[i].toString());
        }
    }

    @Override
    protected Block createBlock(StateMap states) {
        return new BlockImpl(states);
    }

    private class BlockImpl extends Block {

        BlockImpl(StateMap state) {
            super(BlockMonsterEgg.this, state);
        }

        @Override
        public int getLegacyData() {
            return getState(VARIANT).ordinal();
        }

        @Override
        public Texture getTexture(Face face) {
            return textures[getState(VARIANT).ordinal()];
        }
    }
}
