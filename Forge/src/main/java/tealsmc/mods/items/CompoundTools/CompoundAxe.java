package tealsmc.mods.items.CompoundTools;

import components.AxeHead;
import components.ItemShaft;
import net.minecraft.item.ItemAxe;
import tealsmc.mods.items.*;
public class CompoundAxe extends ItemAxe {
	public final String name;
	public CompoundAxe(AxeHead h, ItemShaft s) {
		super(ItemsModule.getMat(s, h));
		name = h.toString()+" "+s.toString();
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return name;
	}
}
