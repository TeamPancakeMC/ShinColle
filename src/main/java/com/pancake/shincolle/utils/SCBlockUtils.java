package com.pancake.shincolle.utils;

import com.pancake.shincolle.init.SCBlocks;
import com.pancake.shincolle.init.SCItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class SCBlockUtils {

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> register = SCBlocks.BLOCKS.register(name, block);
        Item.Properties properties = new Item.Properties().tab(SCItemUtils.MYTH_TAB);
        SCItems.ITEMS.register(name, () -> new BlockItem(register.get(), properties));
        return register;
    }

    public static RegistryObject<Block> normal(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new Block(properties));
    }

    public static RegistryObject<Block> ore(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new OreBlock(properties));
    }

    public static RegistryObject<Block> wood(String name, MaterialColor materialColor) {
        return registerBlock(name, () -> new RotatedPillarBlock(BlockBehaviour.Properties
                .of(Material.WOOD, materialColor).strength(2.0F).sound(SoundType.WOOD)));
    }

    public static RegistryObject<Block> flowerPot(String name, RegistryObject<Block> block) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion();
        return SCBlocks.BLOCKS.register(name, () -> new FlowerPotBlock(block.get(), properties));
    }

    public static RegistryObject<Block> pressurePlate(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, properties));
    }

    public static RegistryObject<Block> fenceGate(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new FenceGateBlock(properties));
    }

    public static RegistryObject<Block> trapdoor(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new TrapDoorBlock(properties));
    }

    public static RegistryObject<Block> button(String name, boolean sensitive, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> sensitive ? new WoodButtonBlock(properties) : new StoneButtonBlock(properties));
    }

    public static <T extends Block> RegistryObject<Block> stair(String name, Supplier<T> block, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new StairBlock(() -> block.get().defaultBlockState(), properties));
    }

    public static RegistryObject<Block> fence(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new FenceBlock(properties));
    }

    public static RegistryObject<Block> door(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new DoorBlock(properties));
    }

    public static RegistryObject<Block> slab(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new SlabBlock(properties));
    }

    public static RegistryObject<Block> wall(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new WallBlock(properties));
    }
    
}