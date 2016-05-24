package components;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import tealsmc.mods.items.*;
public class FlameBlade extends Blade {

	public FlameBlade() {
		super(ToolMaterial.IRON,"Flame");
		// TODO Auto-generated constructor stub
	}
	public int getDur(){
		return this.m.getMaxUses();
	}
	public int getEnchant(){
		return this.m.getEnchantability();
	}
	public void addEffects(ItemStack s){
		s.addEnchantment(Enchantment.fireAspect, 2);
	}

}
