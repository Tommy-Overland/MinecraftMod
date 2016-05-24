package tealsmc.mods.items.CompoundTools;

import components.ItemShaft;
import components.PickaxeHead;
import net.minecraft.item.ItemPickaxe;
import tealsmc.mods.items.*;
public class CompoundPick extends ItemPickaxe {
public final String name;
	public CompoundPick(PickaxeHead h, ItemShaft s) {
		super(ItemsModule.getMat(s, h));
		name = h.toString()+" "+s.toString();
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return name;
	}
}
