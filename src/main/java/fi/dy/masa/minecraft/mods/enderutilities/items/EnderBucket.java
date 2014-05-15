package fi.dy.masa.minecraft.mods.enderutilities.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import fi.dy.masa.minecraft.mods.enderutilities.creativetab.CreativeTab;
import fi.dy.masa.minecraft.mods.enderutilities.reference.Reference;

public class EnderBucket extends Item
{
	public EnderBucket()
	{
		super();
		this.setMaxStackSize(1);
		this.setUnlocalizedName(Reference.NAME_ITEM_ENDER_BUCKET);
		this.setTextureName(Reference.MOD_ID + ":" + this.getUnlocalizedName()); // FIXME?
		this.setCreativeTab(CreativeTab.ENDER_UTILITIES_TAB);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		NBTTagCompound nbt = stack.getTagCompound();

		if (nbt != null)
		{
		}

		return stack;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		// Do nothing on the client side
		if (world.isRemote == true)
		{
			return false;
		}

		return false;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if (stack.getTagCompound() != null)
		{
			NBTTagCompound nbt = stack.getTagCompound();
			String fluid	= nbt.getString("fluid");
			short amount	= nbt.getShort("amount");

			String pre = "" + EnumChatFormatting.BLUE;
			String rst = "" + EnumChatFormatting.RESET + EnumChatFormatting.GRAY;

			if (nbt.hasKey("fluid") == false || amount == 0)
			{
				list.add("Fluid: <empty>");
			}
			else
			{
				list.add(String.format("Fluid: %s%s%s", pre, fluid, rst));
			}
			list.add(String.format("Amount: %s%d%smB", pre, amount, rst));
		}
	}

	@Override
	public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player)
	{
		return true;
	}
}