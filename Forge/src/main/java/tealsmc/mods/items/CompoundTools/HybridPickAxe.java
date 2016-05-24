package tealsmc.mods.items.CompoundTools;

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
public class HybridPickAxe extends ItemPickaxe {
private PickaxeHead h;
private AxeHead A;
private ItemShaft s;
public String name;
private static Set effectiveAgainst = Sets.newHashSet(new Block[] {
	    Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, 
	    Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});

	public HybridPickAxe(PickaxeHead h, AxeHead A,ItemShaft s) {
		super(EnumHelper.addToolMaterial("modularMat"+h.toString()+A.toString()+s.toString(),
		h.getLVL(), (2*h.getDur()+2*A.getDur()+s.getDur())/5, h.getEfficency()*s.getEffMod(),
		(h.getDMG()+A.getDMG())/2, (h.getEnchant()+A.getEnchant()+s.getEnchant())/3)
		);
		this.h=h;
		this.A=A;
		this.s=s;
		name=h.toString()+" "+A.toString()+" "+s.toString()+" hybrid PickAxe";
		// TODO Auto-generated constructor stub
	}
	public HybridPickAxe(PickaxeHead h, AxeHead A,ItemShaft s,ToolMaterial m) {
		super(m);
		this.h=h;
		this.A=A;
		this.s=s;
		name=h.toString()+" "+A.toString()+" "+s.toString()+" hybrid PickAxe";
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return name;
	}
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
	    return ImmutableSet.of("pickaxe", "axe");
	}
	@Override
	public float func_150893_a(ItemStack stack, Block block) {
	    if (block.getMaterial() == Material.wood || block.getMaterial() == Material.vine || block.getMaterial() == Material.plants)
	        return this.A.getEfficency()*s.getEffMod();
	    if(effectiveAgainst.contains(block))
	    	return this.A.getEfficency();
	    return effectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : super.func_150893_a(stack, block);
	}

}
