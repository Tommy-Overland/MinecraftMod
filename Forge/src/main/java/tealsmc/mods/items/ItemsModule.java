package tealsmc.mods.items;

import org.tealsk12.tealsmodloader.module.Module;

import components.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import tealsmc.mods.items.CompoundTools.*;
public class ItemsModule extends Module {

    public static final RockSifter rockSifter = new RockSifter();
    public static final Blade head = new Blade(ToolMaterial.EMERALD);
    public static final ItemShaft shaft = new ItemShaft(ToolMaterial.WOOD);
    public static final CustomMaterialSet mat = new CustomMaterialSet(head,shaft);
    public static final CompoundBlade sword = new CompoundBlade(head,shaft);
    public ToolMaterial paper;
    public ToolMaterial obsidian;
    
    public void onLoad() {
        parentMod.itemRegistry.newInstance("rock_sifter", rockSifter, "Rock Sifter");
        paper = EnumHelper.addToolMaterial("PA", ToolMaterial.WOOD.getHarvestLevel(), 
        (int)ToolMaterial.WOOD.getMaxUses()*2/3, ToolMaterial.WOOD.getEfficiencyOnProperMaterial(),
        ToolMaterial.WOOD.getDamageVsEntity(),ToolMaterial.GOLD.getEnchantability()+5);
        obsidian = EnumHelper.addToolMaterial("OB", ToolMaterial.IRON.getHarvestLevel(),
        (int) (ToolMaterial.EMERALD.getMaxUses()*1.5), ToolMaterial.STONE.getEfficiencyOnProperMaterial(),
        ToolMaterial.STONE.getDamageVsEntity()+1, ToolMaterial.WOOD.getEnchantability());
        ItemShaft[] shafts = getShafts(); //gets all the item shafts
        Blade[] blades = getBlades(); // gets all the sword blades
        ShovelHead[] shove=getShoves(); // gets all the shovel heads
        AxeHead[] Axes = getAxeHeads(); // gets all the axe heads
        PickaxeHead[] Picks = getPicks(); //gets all the pick heads
        addCompoundBlades(shafts,blades); // creates all the combinations of blade and shaft
        addCompoundShovels(shafts,shove); //creates all the combinations of shovels
        addCompoundAxes(shafts,Axes); // creates all the possible axes
        addCompoundPicks(shafts,Picks); //creates all the possible picks
        addHybridPickAxe(shafts,Axes,Picks);
        addHybridPickShovel(shafts,shove,Picks);
        addHybridShovelAxe(shafts,Axes,shove);
        addHybridPickAxeSword(shafts,Axes,Picks,blades);
        addHybridShovelPickaxeSword(shafts,shove,Picks,blades);
        addHybridShovelAxeSword(shafts,Axes,shove,blades);
        addPABS(shafts,Axes,Picks,blades,shove);
    }
    public void addPABS(ItemShaft[] s, AxeHead[] b,PickaxeHead[] p,Blade[] B,ShovelHead[] h ){
    	//iterates over both arrays adding the combo item
    	for(int i=0; i<s.length;i++){
    		for(int j=0;j<b.length;j++){
    			for(int z=0;z<h.length;z++){
    				for(int k =0; k<B.length;k++){
    					for(int w=0;w<p.length;w++){
    			PABS a = new PABS(p[w],B[k],s[i],h[z],b[j]);
    			parentMod.itemRegistry.newInstance(h[z].toString()+b[j].toString()+s[i].toString()+B[k].toString(), a, a.toString());
    			ItemStack S = new ItemStack(a);
    			s[i].addEffects(S);
    			b[j].addEffects(S);
    			h[z].addEffects(S);
    			B[k].addEffects(S);
    			p[w].addEffects(S);
    			GameRegistry.addRecipe(S," B ","PSA"," # ",'B',B[k],'P',p[w],'S',h[z],'A',b[j],'#',s[i]);
    			}
    				}
    			}
    		}
    	}
    }
    public void addHybridPickAxeSword(ItemShaft[] s, AxeHead[] b,PickaxeHead[] h,Blade[] B){
    	//iterates over both arrays adding the combo item
    	for(int i=0; i<s.length;i++){
    		for(int j=0;j<b.length;j++){
    			for(int z=0;z<h.length;z++){
    				for(int k =0; k<B.length;k++){
    			PickAxeSwordHybrid a = new PickAxeSwordHybrid(h[z],b[j],s[i],B[k]);
    			parentMod.itemRegistry.newInstance(h[z].toString()+b[j].toString()+s[i].toString()+B[k].toString(), a, a.toString());
    			ItemStack S = new ItemStack(a);
    			s[i].addEffects(S);
    			b[j].addEffects(S);
    			h[z].addEffects(S);
    			B[k].addEffects(S);
    			GameRegistry.addRecipe(S,"#BP"," I ",'#',b[j],'I',s[i],'P',h[z],'B',B[k]);
    			}
    			}
    		}
    	}
    }
    public void addHybridShovelPickaxeSword(ItemShaft[] s, ShovelHead[] b,PickaxeHead[] h,Blade[] B){
    	//iterates over both arrays adding the combo item
    	for(int i=0; i<s.length;i++){
    		for(int j=0;j<b.length;j++){
    			for(int z=0;z<h.length;z++){
    				for(int k =0; k<B.length;k++){
    			ShovelPickSwordHybrid a = new ShovelPickSwordHybrid(h[z],b[j],s[i],B[k]);
    			parentMod.itemRegistry.newInstance(h[z].toString()+b[j].toString()+s[i].toString()+B[k].toString(), a, a.toString());
    			ItemStack S = new ItemStack(a);
    			s[i].addEffects(S);
    			b[j].addEffects(S);
    			h[z].addEffects(S);
    			B[k].addEffects(S);
    			GameRegistry.addRecipe(S,"#BP"," I ",'#',b[j],'I',s[i],'P',h[z],'B',B[k]);
    			}
    			}
    		}
    	}
    }
    public void addHybridShovelAxeSword(ItemShaft[] s, AxeHead[] b,ShovelHead[] h,Blade[] B){
    	//iterates over both arrays adding the combo item
    	for(int i=0; i<s.length;i++){
    		for(int j=0;j<b.length;j++){
    			for(int z=0;z<h.length;z++){
    				for(int k =0; k<B.length;k++){
    			ShovelAxeSwordHybrid a = new ShovelAxeSwordHybrid(b[j],h[z],s[i],B[k]);
    			parentMod.itemRegistry.newInstance(h[z].toString()+b[j].toString()+s[i].toString()+B[k].toString(), a, a.toString());
    			ItemStack S = new ItemStack(a);
    			s[i].addEffects(S);
    			b[j].addEffects(S);
    			h[z].addEffects(S);
    			B[k].addEffects(S);
    			GameRegistry.addRecipe(S,"#BP"," I ",'#',b[j],'I',s[i],'P',h[z],'B',B[k]);
    			}
    			}
    		}
    	}
    }
    public void addHybridPickAxe(ItemShaft[] s, AxeHead[] b,PickaxeHead[] h){
    	//iterates over both arrays adding the combo item
    	for(int i=0; i<s.length;i++){
    		for(int j=0;j<b.length;j++){
    			for(int z=0;z<h.length;z++){
    			HybridPickAxe a = new HybridPickAxe(h[z],b[j],s[i]);
    			parentMod.itemRegistry.newInstance(h[z].toString()+b[j].toString()+s[i].toString(), a, a.toString());
    			ItemStack S = new ItemStack(a);
    			s[i].addEffects(S);
    			b[j].addEffects(S);
    			h[z].addEffects(S);
    			GameRegistry.addRecipe(S,"# P"," I ",'#',b[j],'I',s[i],'P',h[z]);
    			}
    		}
    	}
    }
    public void addHybridPickShovel(ItemShaft[] s, ShovelHead[] b,PickaxeHead[] h){
    	//iterates over both arrays adding the combo item
    	for(int i=0; i<s.length;i++){
    		for(int j=0;j<b.length;j++){
    			for(int z=0;z<h.length;z++){
    			ShovelPickHybrid a = new ShovelPickHybrid(h[z],b[j],s[i]);
    			parentMod.itemRegistry.newInstance(h[z].toString()+b[j].toString()+s[i].toString(), a, a.toString());
    			ItemStack S = new ItemStack(a);
    			s[i].addEffects(S);
    			b[j].addEffects(S);
    			h[z].addEffects(S);
    			GameRegistry.addRecipe(S,"# P"," I ",'#',b[j],'I',s[i],'P',h[z]);
    			}
    		}
    	}
    }
    public void addHybridShovelAxe(ItemShaft[] s, AxeHead[] b,ShovelHead[] h){
    	//iterates over both arrays adding the combo item
    	for(int i=0; i<s.length;i++){
    		for(int j=0;j<b.length;j++){
    			for(int z=0;z<h.length;z++){
    			ShovelAxeHybrid a = new ShovelAxeHybrid(b[j],h[z],s[i]);
    			parentMod.itemRegistry.newInstance(h[z].toString()+b[j].toString()+s[i].toString(), a, a.toString());
    			ItemStack S = new ItemStack(a);
    			s[i].addEffects(S);
    			b[j].addEffects(S);
    			h[z].addEffects(S);
    			GameRegistry.addRecipe(S,"# P"," I ",'#',b[j],'I',s[i],'P',h[z]);
    			}
    		}
    	}
    }
    public void addCompoundBlades(ItemShaft[] s, Blade[] b){
    	//iterates over both arrays adding the combo item
    	for(int i=0; i<s.length;i++){
    		for(int j=0;j<b.length;j++){
    			CompoundBlade B = new CompoundBlade(b[j],s[i]);
    			parentMod.itemRegistry.newInstance(b[j].toString()+s[i].toString(), B, B.toString());
    			ItemStack S = new ItemStack(B);
    			s[i].addEffects(S);
    			b[j].addEffects(S);
    			GameRegistry.addRecipe(S,"#","I",'#',b[j],'I',s[i]);
    		}
    	}
    } 
    public void addCompoundShovels(ItemShaft[] s, ShovelHead[] b){
    	//iterates over both arrays adding the combo item
    	for(int i=0; i<s.length;i++){
    		for(int j=0;j<b.length;j++){
    			CompoundShovel B = new CompoundShovel(b[j],s[i]);
    			parentMod.itemRegistry.newInstance(b[j].toString()+s[i].toString(), B, B.toString());
    			ItemStack S = new ItemStack(B);
    			b[j].addEffects(S);
    			s[i].addEffects(S);
    			GameRegistry.addRecipe(S,"#","I",'#',b[j],'I',s[i]);
    		}
    	}
    }
    public void addCompoundAxes(ItemShaft[] s, AxeHead[] b){
    	//iterates over both arrays
    	for(int i=0; i<s.length;i++){
    		for(int j=0;j<b.length;j++){
    			CompoundAxe B = new CompoundAxe(b[j],s[i]);
    			parentMod.itemRegistry.newInstance(b[j].toString()+s[i].toString(), B, B.toString());
    			ItemStack S = new ItemStack(B);
    			s[i].addEffects(S);
    			b[j].addEffects(S);
    			GameRegistry.addRecipe(S,"#","I",'#',b[j],'I',s[i]);
    		}
    	}
    }
    public void addCompoundPicks(ItemShaft[] s, PickaxeHead[] b){
    	//iterates over both arrays
    	for(int i=0; i<s.length;i++){
    		for(int j=0;j<b.length;j++){
    			CompoundPick B = new CompoundPick(b[j],s[i]);
    			parentMod.itemRegistry.newInstance(b[j].toString()+s[i].toString(), B, B.toString());
    			ItemStack S = new ItemStack(B); 
    			s[i].addEffects(S);
    			b[j].addEffects(S);
    			GameRegistry.addRecipe(S,"#","I",'#',b[j],'I',s[i]);
    		}
    	}
    }
    public ShovelHead[] getShoves(){
    	//adds each basic shovel head 
    	// add in special shovel heads here 
    	//then returnes a refrence to each
    	ShovelHead[] heads = new ShovelHead[6];
        heads[0]=addShovelH(ToolMaterial.WOOD,Blocks.log,"wooden Shovel Head");
        heads[1]=addShovelH(ToolMaterial.STONE,Blocks.cobblestone,"Stone Shovel Head");
        heads[2]=addShovelH(ToolMaterial.IRON,Items.iron_ingot,"iron Shovel Head");
        heads[3]=addShovelH(ToolMaterial.GOLD,Items.gold_ingot,"gold Shovel Head");
        heads[4]=addShovelH(ToolMaterial.EMERALD,Items.diamond,"dimond Shovel Head");
        heads[5]=addShovelH(this.obsidian,Blocks.obsidian,"Obsidian Shovel Head");
        return heads;
    }
    public Blade[] getBlades(){
    	
    	 Blade[] blades = new Blade[9];
         blades[0]=addBlade(ToolMaterial.WOOD,Blocks.log,"wooden blade");
         blades[1]=addBlade(ToolMaterial.STONE,Blocks.cobblestone,"Stone blade");
         blades[2]=addBlade(ToolMaterial.IRON,Items.iron_ingot,"Iron blade");
         blades[3]=addBlade(ToolMaterial.GOLD,Items.gold_ingot,"Gold blade");
         blades[4]=addBlade(ToolMaterial.EMERALD,Items.diamond,"Dimond blade");
         blades[5]=addBlade(paper,Items.paper,"Paper Blade");
         Blade s = new FlameBlade();
     	parentMod.itemRegistry.newInstance("FlameBlade", s, "Flame Blade");
     	GameRegistry.addRecipe(new ItemStack(s),"# ","##","##",'#',Items.blaze_powder);
     	blades[6]=s;
     	blades[7]=addBlade(obsidian,Blocks.obsidian,"Obsidian blade");
     	s = new PricklyBlade();
     	parentMod.itemRegistry.newInstance("PricklyBlade", s, "Prickly Blade");
     	GameRegistry.addRecipe(new ItemStack(s),"#","#","#",'#',Blocks.cactus);
     	blades[8]=s;
         return blades;
    }
    public AxeHead[] getAxeHeads(){
    	AxeHead[] AH = new AxeHead[7];
    	AH[0] = addAxeH(ToolMaterial.WOOD,Blocks.log,"wooden axe head");
    	AH[1] = addAxeH(ToolMaterial.STONE,Blocks.cobblestone,"Stone axe head");
    	AH[2] = addAxeH(ToolMaterial.IRON,Items.iron_ingot,"Iron axe head");
    	AH[3] = addAxeH(ToolMaterial.GOLD,Items.gold_ingot,"Gold axe head");
    	AH[4] = addAxeH(ToolMaterial.EMERALD,Items.diamond,"Diamond axe head");
    	AH[5] = addAxeH(paper,Items.paper,"Paper axe head");
    	AH[6] = addAxeH(obsidian,Blocks.obsidian,"Obsidian axe head");
    	return AH;
    }
    public PickaxeHead[] getPicks(){
    	PickaxeHead[] PH = new PickaxeHead[7];
    	PH[0]=addPickH(ToolMaterial.WOOD,Blocks.log,"Wooden Pick head");
    	PH[1]=addPickH(ToolMaterial.STONE,Blocks.cobblestone,"Stone Pick head");
    	PH[2]=addPickH(ToolMaterial.IRON,Items.iron_ingot,"Iron Pick head");
    	PH[3]=addPickH(ToolMaterial.GOLD,Items.gold_ingot,"Gold Pick head");
    	PH[4]=addPickH(ToolMaterial.EMERALD,Items.diamond,"Diamond Pick head");
    	PH[5]=addPickH(paper,Items.paper,"Paper Pick head");
    	PH[6]=addPickH(obsidian,Blocks.obsidian,"Obsidian Pick head");
    	return PH;
    }
    public ItemShaft[] getShafts(){
    	ItemShaft[] shafts = new ItemShaft[8];
        shafts[0]=addShaft(ToolMaterial.WOOD,Items.stick,"wooden shaft");
        shafts[1]=addShaft(ToolMaterial.STONE,Blocks.cobblestone,"Stone shaft");
        shafts[2]=addShaft(ToolMaterial.IRON,Items.iron_ingot,"Iron shaft");
        shafts[3]=addShaft(ToolMaterial.GOLD,Items.gold_ingot,"Gold shaft");
        shafts[4]=addShaft(ToolMaterial.EMERALD,Items.diamond,"Dimond shaft");
        shafts[5]=addShaft(paper,Items.paper,"Paper shaft");
        shafts[6]=new RedBlazeShaft();
        parentMod.itemRegistry.newInstance("BlazeShaft", shafts[6], "Red Blaze Shaft");
    	GameRegistry.addRecipe(new ItemStack(shafts[6]),"#I#","#I#","#I#",'#',Items.redstone,'I',Items.blaze_rod);
        shafts[7]=addShaft(obsidian,Blocks.obsidian,"Obsidian shaft");
    	return shafts;
    }
    public static ToolMaterial getMat(ItemShaft s, ItemHead h){
    	return new CustomMaterialSet(h,s).m;
    }
    public Blade addBlade (ToolMaterial m,Item I,String name){
    	System.out.println("adding blade"+name);
    	Blade s = new Blade(m);
    	parentMod.itemRegistry.newInstance(m.toString()+"Blade", s, name);
    	GameRegistry.addRecipe(new ItemStack(s),"# ","##","##",'#',I);
    	return s;
    	
    }
    public Blade addBlade (ToolMaterial m,Block I,String name){
    	System.out.println("adding blade"+name);
    	Blade s = new Blade(m);
    	parentMod.itemRegistry.newInstance(m.toString()+"Blade", s, name);
    	GameRegistry.addRecipe(new ItemStack(s),"# ","##","##",'#',I);
    	return s;
    	
    }
    public ItemShaft addShaft (ToolMaterial m,Item I,String name){
    	ItemShaft s = new ItemShaft(m);
    	parentMod.itemRegistry.newInstance(m.toString()+"Shaft", s, name);
    	GameRegistry.addRecipe(new ItemStack(s),"#","#","#",'#',I);
    	return s;
    	
    }
    public ItemShaft addShaft (ToolMaterial m,Block I,String name){
    	ItemShaft s = new ItemShaft(m);
    	parentMod.itemRegistry.newInstance(m.toString()+"Shaft", s, name);
    	GameRegistry.addRecipe(new ItemStack(s),"#","#","#",'#',I);
    	return s;
    	
    }
    public ShovelHead addShovelH (ToolMaterial m,Item I,String name){
    	ShovelHead s = new ShovelHead(m);
    	parentMod.itemRegistry.newInstance(m.toString()+"Scoop", s, name);
    	GameRegistry.addRecipe(new ItemStack(s)," # ","# #",'#',I);
    	return s;
    	
    }
    public ShovelHead addShovelH (ToolMaterial m,Block I,String name){
    	ShovelHead s = new ShovelHead(m);
    	parentMod.itemRegistry.newInstance(m.toString()+"Scoop", s, name);
    	GameRegistry.addRecipe(new ItemStack(s)," # ","# #",'#',I);
    	return s;
    	
    }
    public AxeHead addAxeH (ToolMaterial m,Item I,String name){
    	AxeHead s = new AxeHead(m);
    	parentMod.itemRegistry.newInstance(m.toString()+"AxeHead", s, name);
    	GameRegistry.addRecipe(new ItemStack(s),"##"," #",'#',I);
    	return s;
    	
    }
    public AxeHead addAxeH (ToolMaterial m,Block I,String name){
    	AxeHead s = new AxeHead(m);
    	parentMod.itemRegistry.newInstance(m.toString()+"AxeHead", s, name);
    	GameRegistry.addRecipe(new ItemStack(s),"##"," #",'#',I);
    	return s;
    	
    }
    public PickaxeHead addPickH (ToolMaterial m,Item I,String name){
    	PickaxeHead s = new PickaxeHead(m);
    	parentMod.itemRegistry.newInstance(m.toString()+"Pick", s, name);
    	GameRegistry.addRecipe(new ItemStack(s),"###",'#',I);
    	return s;
    	
    }
    public PickaxeHead addPickH (ToolMaterial m,Block I,String name){
    	PickaxeHead s = new PickaxeHead(m);
    	parentMod.itemRegistry.newInstance(m.toString()+"Pick", s, name);
    	GameRegistry.addRecipe(new ItemStack(s),"###",'#',I);
    	return s;
    	
    }
    public void addToReg(String key,Item m, String name){
    	parentMod.itemRegistry.newInstance(key, m, name);
    }
    public ToolMaterial getBladedMat(Blade b, ItemShaft s, ItemHead h){
    	return EnumHelper.addToolMaterial("modularMat"+h.toString()+s.toString()+b.toString(),
				h.getLVL(), 2*b.getDur()+2*h.getDur()+s.getDur()/5, h.getEfficency()*s.getEffMod(),
				b.getDMG()+2, (h.getEnchant()+s.getEnchant()+b.getEnchant())/3);
    }
}
