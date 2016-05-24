package components;

public class Blade extends ItemHead {
public final float dmg;
	public Blade(ToolMaterial m) {
		super(m);
		dmg = m.getDamageVsEntity();
		// TODO Auto-generated constructor stub
		
	}
	public Blade(ToolMaterial m,String s){
		super(m,s);
		dmg = m.getDamageVsEntity();
	}
	public Blade(ToolMaterial m, float dmg){
		super(m);
		this.dmg=dmg;
	}
	public Blade(ToolMaterial m, String s, float dmg){
		super(m,s);
		this.dmg=dmg;
	}
	public String toString(){
		return super.toString()+"Blade";
	}
	public float getDMG(){
		return dmg;
	}
}
