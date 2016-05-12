package tealsmc.mods.items;

import org.tealsk12.tealsmodloader.module.Module;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;

public class ItemsModule extends Module {

	public static final RockSifter rockSifter = new RockSifter();
    public static final SwordBlade blade = new SwordBlade(ToolMaterial.EMERALD);
    public static final UpgradedStick stick = new UpgradedStick(ToolMaterial.WOOD);
    public static final CustomMaterialSet mat = new CustomMaterialSet(blade,stick);
    public static final SwordTest sword = new SwordTest(stick,blade);
    
    public void onLoad() {
        parentMod.itemRegistry.newInstance("rock_sifter", rockSifter, "Rock Sifter");
        parentMod.itemRegistry.newInstance("test", sword, "blade of testing");
    }
}
