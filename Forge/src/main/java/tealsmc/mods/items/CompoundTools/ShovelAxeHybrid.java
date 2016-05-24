package tealsmc.mods.items.CompoundTools;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import tealsmc.mods.items.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import java.util.Set;
import com.google.common.collect.*;

import components.*;


public class ShovelAxeHybrid extends ItemAxe {
	private AxeHead h;
	private ShovelHead A;
	private ItemShaft s;
	public String name;
	private static Set effectiveAgainst = Sets.newHashSet(new Block[] {
		    Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, 
		    Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, 
		    Blocks.soul_sand, Blocks.mycelium});
	public ShovelAxeHybrid(AxeHead h, ShovelHead A, ItemShaft s) {
		super(EnumHelper.addToolMaterial("modularMat"+h.toString()+A.toString()+s.toString(),
				h.getLVL(), (2*h.getDur()+2*A.getDur()+s.getDur())/5, h.getEfficency()*s.getEffMod(),
				(h.getDMG()+A.getDMG())/2, (h.getEnchant()+A.getEnchant()+s.getEnchant())/3)
				);
				this.h=h;
				this.A=A;
				this.s=s;
				name=h.toString()+" "+A.toString()+" "+s.toString()+"ShovelAxe";
		// TODO Auto-generated constructor stub
	}
	public ShovelAxeHybrid(AxeHead h, ShovelHead A, ItemShaft s,ToolMaterial m) {
		super(m);
				this.h=h;
				this.A=A;
				this.s=s;
				name=h.toString()+" "+A.toString()+" "+s.toString()+"ShovelAxe";
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return name;
	}
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
	    return ImmutableSet.of("axe", "spade");
	}
	@Override
	public boolean func_150897_b(Block block) {
	    return effectiveAgainst.contains(block) ? true : super.func_150897_b(block);
	}
	public float func_150893_a(ItemStack stack, Block block) {
		if(effectiveAgainst.contains(block))
			return this.A.getEfficency()*this.s.getEffMod();
	    return effectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : super.func_150893_a(stack, block);
	}

}
