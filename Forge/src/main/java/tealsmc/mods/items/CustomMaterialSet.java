package tealsmc.mods.items;
import components.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class CustomMaterialSet {
public final ItemHead b;
public final ItemShaft s;
public final ToolMaterial m;
	public CustomMaterialSet(ItemHead h, ItemShaft s) {
		// TODO Auto-generated constructor stub
		this.b=h;
		this.s=s;
		m = EnumHelper.addToolMaterial(h.toString()+" "+s.toString(), h.getLVL(), s.getDur()+h.getDur(), 
				h.getEfficency()*s.getEffMod(), h.getDMG(), (h.getEnchant()+s.getEnchant())/2);
	}

}
