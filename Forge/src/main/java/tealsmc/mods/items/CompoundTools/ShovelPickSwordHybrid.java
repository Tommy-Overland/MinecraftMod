package tealsmc.mods.items.CompoundTools;

import components.Blade;
import components.ItemShaft;
import components.PickaxeHead;
import components.ShovelHead;
import net.minecraftforge.common.util.EnumHelper;

public class ShovelPickSwordHybrid extends ShovelPickHybrid {
public Blade b;
	public ShovelPickSwordHybrid(PickaxeHead h, ShovelHead A, ItemShaft s,Blade b) {
		super(h, A, s,EnumHelper.addToolMaterial("modularMat"+h.toString()+A.toString()+s.toString()+b.toString(),
				h.getLVL(), ((4/3)*(h.getDur()+A.getDur()+b.getDur())+s.getDur())/5, h.getEfficency()*s.getEffMod(),
				b.getDMG()+2, (h.getEnchant()+A.getEnchant()+s.getEnchant()+b.getEnchant())/4));
		this.b=b;
		// TODO Auto-generated constructor stub
	}
	public ShovelPickSwordHybrid(PickaxeHead h, ShovelHead A, ItemShaft s, Blade b, ToolMaterial m){
		super(h,A,s,m);
		this.b=b;
	}


}
