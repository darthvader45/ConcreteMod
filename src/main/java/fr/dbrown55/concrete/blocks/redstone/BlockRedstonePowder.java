package fr.dbrown55.concrete.blocks.redstone;

import fr.dbrown55.concrete.Main;
import fr.dbrown55.concrete.blocks.BlockHandler;
import fr.dbrown55.concrete.blocks.concreteBaseClasses.ConcretePowderBase;
import fr.dbrown55.utilmod.helpers.BlockStateHelper;
import fr.dbrown55.utilmod.helpers.TranslationHelper;
import net.minecraft.block.BlockColored;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockRedstonePowder extends ConcretePowderBase {

	public BlockRedstonePowder() {
		super(new ResourceLocation("concrete", "redcrete_powder"));
	}

	@Override
	public IBlockState getSolidState(IBlockState original) {
		return BlockStateHelper.copyProperties(original, BlockHandler.REDSTONE_SOLID, BlockColored.COLOR);
	}

	@Override
	public String getDisplayName(ItemStack stack) {
		return TranslationHelper.translateAll("tile.redstone_concrete_powder.name", "color." + EnumDyeColor.byMetadata(stack.getMetadata()).getName());
	}

	public boolean canProvidePower(IBlockState state) {
		return true;
	}

	/**
	 * Lower because it costs less redstone to craft this block
	 */
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		if(Main.config.isFullRsPower()) {
			return 15;
		}
		return (int) (15.0*(8.0/9.0));
	}
	
}
