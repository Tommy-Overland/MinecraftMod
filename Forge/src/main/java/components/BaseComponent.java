package components;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class BaseComponent extends Item {
	
	protected final ToolMaterial m;
	protected int Dur;
	protected int Enchant;
	protected String name;
	public BaseComponent(ToolMaterial m) {
		// TODO Auto-generated constructor stub
		this.m=m;
		this.Dur=m.getMaxUses();
		this.Enchant=m.getEnchantability();
		if(m.equals(ToolMaterial.WOOD)){
			name="W";
		}else if(m.equals(ToolMaterial.STONE)){
			name = "St";
		}else if(m.equals(ToolMaterial.IRON)){
			name="Ir";
		}else if(m.equals(ToolMaterial.GOLD)){
			name="G";
		}else if(m.equals(ToolMaterial.EMERALD)){
			name ="D";
		}else{
		name = m.toString();
		}
	}
	public BaseComponent(ToolMaterial m,String s) {
		// TODO Auto-generated constructor stub
		this.m=m;
		this.Dur=m.getMaxUses();
		this.Enchant=m.getEnchantability();		
		name = s;
	}
	public int getDur(){
		return this.Dur;
	}
	public int getEnchant(){
		return this.Enchant;
	}
	public void addEffects(ItemStack s){
		
	}
	public String toString(){
		return name;
	}
	public String superToString(){
		return name;
	}
	
//enchantability
	//durability
	//efficency
	//mining lvl
	//damamge
	//
}
