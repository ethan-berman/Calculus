import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.jfree.data.xy.XYSeries;

public class Equation {
    String curve;
    Main m;
    int lim;
    int d;
    ScriptEngineManager manager;
    ScriptEngine engine;

    public Equation(String curve, Main m, int d){
    	manager = new ScriptEngineManager();
    	engine = manager.getEngineByName("js");
        this.curve = curve;
        this.m = m;
        this.d = d;
        if(m.quantity_bound >= m.supply_bound){
        	lim = m.quantity_bound;
        }else{
        	lim = m.supply_bound;
        }
    }

    public XYSeries graph(String curve){
    	XYSeries points;
    	if(d == 0){
    		points = new XYSeries("Demand");
    	}else if(d == 1){
    		points = new XYSeries("Supply");
    	}
    	else{
    		points = new XYSeries("Other");
    	}
        for(double i =0.0;i<15;i += 0.01){
            String temp_curve = curve.replaceAll("x", Double.toString(i));;
            
            try {
				Object result = engine.eval(temp_curve);
				//System.out.println(result.toString());
				if(result.toString().equals("Infinity")){
					
				}else{
					points.add(i, Double.parseDouble(result.toString()));
					//System.out.println(i + "  " + Double.parseDouble(result.toString()));
				}
				
			} catch (ScriptException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

		return points;
		
    }
    public XYSeries integral(){
    XYSeries points = new XYSeries(100 + m.counter + 2 * m.counter);
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