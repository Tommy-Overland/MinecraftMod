package components;
import tealsmc.mods.items.*;
public class ItemShaft extends BaseComponent {
	protected float effMod;
	public ItemShaft(ToolMaterial m) {
		super(m);
		effMod =1;
		// TODO Auto-generated constructor stub
	}
	public float getEffMod(){
		return effMod;
	}
	public String toString(){
		return super.toString()+"Shaft";
	}
	
		
	

}
