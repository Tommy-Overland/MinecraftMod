package tealsmc.mods.items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class CustomMaterialSet {
public final SwordBlade b;
public final UpgradedStick s;
public final ToolMaterial m;
	public CustomMaterialSet(SwordBlade b, UpgradedStick s) {
		// TODO Auto-generated constructor stub
		this.b=b;
		this.s=s;
		m = EnumHelper.addToolMaterial("test", b.mat.getHarvestLevel(), s.material.getMaxUses(), b.mat.getEfficiencyOnProperMaterial(), b.mat.getDamageVsEntity(), b.mat.getEnchantability());
	}

}
