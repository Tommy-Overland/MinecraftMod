package tealsmc.mods.items;

import org.tealsk12.tealsmodloader.module.Module;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;


import java.awt.Graphics2D;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ItemsModule extends Module {

	public static final RockSifter rockSifter = new RockSifter();
    public static final SwordBlade blade = new SwordBlade(ToolMaterial.EMERALD);
    public static final UpgradedStick stick = new UpgradedStick(ToolMaterial.WOOD);
    public static final CustomMaterialSet mat = new CustomMaterialSet(blade,stick);
    public static final SwordTest sword = new SwordTest(stick,blade);
    
    public void onLoad() {
        parentMod.itemRegistry.newInstance("rock_sifter", rockSifter, "Rock Sifter");
        parentMod.itemRegistry.newInstance("test", sword, "blade of testing");
        overlay();
    }
    
    public void overlay(){//File add){
    	int height = 16, width = 16;
    	File base = new File("../bin/assets/tealsmodloader/textures/items/" + "shovel.png");
    	
    	if (base.exists()){
    		System.out.println(base.getAbsolutePath() + " is the file path.");
    	}
    	else System.out.println("File does not exist...");
    	//BufferedImage base = ImageIO.read(arg0);//input a File (parameter is File) equivalent to item component
    	//BufferedImage bi = ImageIO.read(add);
    	
    	for (int i = 0; i < width; i++){
    		for (int j = 0; j < width; j++){
    			//base.getRGB(i, j);
    			//base
    			
    			//bi.setRGB(i, j, rgb);
        	}
    	}	
    }
    
    public void makeTexture(){ //parameter as item?
    	// make file
    	// add components stick -> anything else with overlay code
    	// return file name? Do I need to? return anything?
    }
}
