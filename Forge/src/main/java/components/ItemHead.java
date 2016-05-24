package components;

public abstract class ItemHead extends BaseComponent {

	public ItemHead(ToolMaterial m) {
		super(m);
		// TODO Auto-generated constructor stub
	}
	public ItemHead(ToolMaterial m, String s){
		super(m,s);
	}
	public int getLVL(){
		return this.m.getHarvestLevel();
	}
	public float getDMG(){
		return this.m.getDamageVsEntity();
	}
	public float getEfficency(){
		return this.m.getEfficiencyOnProperMaterial();
	}
	public String toString(){
		return super.toString();
	}
	
		
	

}
