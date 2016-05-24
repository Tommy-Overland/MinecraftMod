package tealsmc.mods.items.CompoundTools;

import components.AxeHead;
import components.Blade;
import components.ItemShaft;
import components.ShovelHead;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
public class ShovelAxeSwordHybrid extends ShovelAxeHybrid {
	public Blade b;
	public ShovelAxeSwordHybrid(AxeHead h, ShovelHead A, ItemShaft s,Blade b) {
		super(h, A, s,EnumHelper.addToolMaterial("modularMat"+h.toString()+A.toString()+s.toString()+b.toString(),
				h.getLVL(), ((4/3)*(h.getDur()+A.getDur()+b.getDur())+s.getDur())/5, h.getEfficency()*s.getEffMod(),
				b.getDMG()+2, (h.getEnchant()+A.getEnchant()+s.getEnchant()+b.getEnchant())/4)
				);
		this.b=b;
		// TODO Auto-generated constructor stub
	}

	

}
