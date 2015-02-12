/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blue.lapis.pore.impl.entity;

import blue.lapis.pore.converter.type.MaterialConverter;
import blue.lapis.pore.converter.wrapper.PoreConverter;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.material.MaterialData;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.living.monster.Enderman;

public class PoreEnderman extends PoreMonster implements org.bukkit.entity.Enderman {

    public static PoreEnderman of(Enderman handle) {
        return PoreConverter.of(PoreEnderman.class, handle);
    }

    protected PoreEnderman(Enderman handle) {
        super(handle);
    }

    @Override
    public Enderman getHandle() {
        return (Enderman)super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.ENDERMAN;
    }

    @Override
    public MaterialData getCarriedMaterial() {
        throw new NotImplementedException();
        /*return getHandle().getCarriedBlock().isPresent() ?
                PoreBlockState.of(getHandle().getCarriedBlock().get()).getData() :
                null;*/
    }

    @Override
    public void setCarriedMaterial(MaterialData material) {
        BlockType type = MaterialConverter.asBlock(material.getItemType());
        if (type != null) {
            //getHandle().setCarriedBlock(type); //TODO: not sure of how to create the block state
            throw new NotImplementedException();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}