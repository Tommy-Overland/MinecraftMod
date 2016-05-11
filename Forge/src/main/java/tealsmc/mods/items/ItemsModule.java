package tealsmc.mods.items;

import org.tealsk12.tealsmodloader.module.Module;

import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;

public class ItemsModule extends Module {

    public static final RockSifter rockSifter = new RockSifter();
    public static final SwordTest sword = new SwordTest(ToolMaterial.IRON);
    public void onLoad() {
        parentMod.itemRegistry.newInstance("rock_sifter", rockSifter, "Rock Sifter");
        parentMod.itemRegistry.newInstance("test", sword, "blade of testing");
    }
}
