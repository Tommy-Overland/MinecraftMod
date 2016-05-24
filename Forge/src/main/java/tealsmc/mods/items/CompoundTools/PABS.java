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

public class PABS extends ItemPickaxe {
public PickaxeHead P;
public Blade B;
public ItemShaft S;
public ShovelHead H;
public AxeHead A;
public String name;
private static Set Axe = Sets.newHashSet(new Block[] {
	    Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, 
	    Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});
private static Set Shove = Sets.newHashSet(new Block[] {
	    Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, 
	    Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, 
	    Blocks.soul_sand, Blocks.mycelium});

	public PABS(PickaxeHead p,Blade b, ItemShaft s,ShovelHead h,AxeHead a) {
		super(EnumHelper.addToolMaterial("PADS"+p.toString()+b.toString()+s.toString()+h.toString()+a.toString(), 
				p.getLVL(), //sets harvest level to pickaxes the main component
				(p.getDur()+b.getDur()+s.getDur()+h.getDur()+a.getDur())/5, //sets durability to average of all components
				p.getEfficency()*s.getEffMod(),//sets the efficency for the pick
				b.dmg+2, //sets weapon damage value
				(p.getEnchant()+b.getEnchant()+s.getEnchant()+h.getEnchant()+a.getEnchant())/5));//averages the enchantabilities
		// TODO Auto-generated constructor stub
		P=p;
		B=b;
		S=s;
		H=h;
		A=a;
		name = p.superToString()+"P "+a.superToString()+"A "+b.superToString()+"B "+h.superToString()+"S "+s.superToString();
	}
	public String toString(){
		return name;
	}
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
	    return ImmutableSet.of("pickaxe", "spade","axe");
	}
	@Override
	public boolean func_150897_b(Block block) {
	    return Shove.contains(block) ? true : super.func_150897_b(block);
	}
	public float func_150893_a(ItemStack stack, Block block) {
		if (block.getMaterial() == Material.wood || block.getMaterial() == Material.vine || block.getMaterial() == Material.plants)
	        return this.A.getEfficency()*S.getEffMod();
		if(Shove.contains(block))
			return H.getEfficency()*S.getEffMod();
	    return Axe.contains(block) ? this.efficiencyOnProperMaterial : super.func_150893_a(stack, block);
	}
}
