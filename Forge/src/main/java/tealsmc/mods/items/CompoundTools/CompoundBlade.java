package tealsmc.mods.items.CompoundTools;

import components.Blade;
import components.ItemShaft;
import net.minecraft.item.ItemSword;
import tealsmc.mods.items.*;
public class CompoundBlade extends ItemSword {
	private final String name;
	public CompoundBlade(Blade b, ItemShaft S) {
		
		super(ItemsModule.getMat(S, b));
		name = b.toString()+" "+S.toString();
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return name;
	}

}
