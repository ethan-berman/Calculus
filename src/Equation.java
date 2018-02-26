import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Equation {
    String curve;
    Main m;
    int lim;
    ScriptEngineManager manager;
    ScriptEngine engine;
    public Equation(String curve, Main m){
    	manager = new ScriptEngineManager();
    	engine = manager.getEngineByName("js");
        this.curve = curve;
        this.m = m;
        if(m.quantity_bound >= m.supply_bound){
        	lim = m.quantity_bound;
        }else{
        	lim = m.supply_bound;
        }
    }

    public double[] graph(String curve){
        double[] points = new double[lim];
        for(int i =0;i<points.length;i++){
            String temp_curve = curve.replaceAll("x", Integer.toString(i));;
            
            try {
				Object result = engine.eval(temp_curve);
				//System.out.println(result.toString());
				points[i] = Double.parseDouble(result.toString());
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
		return points;

    }
    public double[] integral(){
    	double[] points = new double[lim];
    	// k over epsilon + 1 times p to the epsilon + 1
    	String k = curve.substring(0, curve.indexOf('*'));
    	String e = curve.substring(curve.indexOf(',')+1,curve.indexOf(')'));
    	Double eps = Double.parseDouble(e);
    	eps += 1;
    	String new_curve = k + '/' + eps + "*Math.pow(x," + eps + ')';
    	//System.out.println(new_curve);
    	points = graph(new_curve);
    	return points;
    }
}