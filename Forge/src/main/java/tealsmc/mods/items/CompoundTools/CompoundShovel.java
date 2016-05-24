package tealsmc.mods.items.CompoundTools;

import components.ItemShaft;
import components.ShovelHead;
import net.minecraft.item.ItemSpade;
import tealsmc.mods.items.*;
public class CompoundShovel extends ItemSpade {
	public final String name;
	public CompoundShovel(ShovelHead h, ItemShaft s) {
		
		super(ItemsModule.getMat(s, h));
		name = h.toString()+" "+s.toString();
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return name;
	}
}
