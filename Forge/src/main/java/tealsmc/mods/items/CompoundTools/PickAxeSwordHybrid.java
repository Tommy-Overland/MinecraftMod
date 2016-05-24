package tealsmc.mods.items.CompoundTools;

import components.AxeHead;
import components.Blade;
import components.ItemShaft;
import components.PickaxeHead;
import net.minecraftforge.common.util.EnumHelper;

public class PickAxeSwordHybrid extends HybridPickAxe {
	public Blade b;
	public PickAxeSwordHybrid(PickaxeHead h, AxeHead A, ItemShaft s,Blade b) {
		super(h, A, s,EnumHelper.addToolMaterial("modularMat"+h.toString()+A.toString()+s.toString()+b.toString(),
				h.getLVL(), ((4/3)*(h.getDur()+A.getDur()+b.getDur())+s.getDur())/5, h.getEfficency()*s.getEffMod(),
				b.getDMG()+2, (h.getEnchant()+A.getEnchant()+s.getEnchant()+b.getEnchant())/4));
		this.b=b;
		// TODO Auto-generated constructor stub
	}

	
	

}
