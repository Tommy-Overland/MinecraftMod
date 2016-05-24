package components;

public class RedBlazeShaft extends ItemShaft {

	public RedBlazeShaft() {
		super(ToolMaterial.IRON);
		this.effMod=2;
		// TODO Auto-generated constructor stub
	}
	public int getDur(){
		
		return (int)1.1*this.m.getMaxUses();
	}
	public int getEnchant(){
		return ToolMaterial.GOLD.getEnchantability();
	}
	public String toString(){
		return "RedBlazeShaft";
	}

}
