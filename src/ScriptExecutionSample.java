import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptExecutionSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ScriptEngineManager factory = new ScriptEngineManager();
			ScriptEngine engine = factory.getEngineByName("nashorn");
			engine.put("param1", "Bangalore - 560037");
			
			engine.eval(
					"function extractCity(param) { return param1.split('-')[0].trim();}; var result = extractCity(param1);");
			
			Object result = engine.get("result");
			System.out.println("City :" + result);
			
			engine.eval(
					"function extractZip(param) { return param1.split('-')[1].trim();}; var result = extractZip(param1);");
			result = engine.get("result");
			System.out.println("Zip :" + result);
			
		} catch (ScriptException ex) {
			throw new RuntimeException(ex);
		}
	}

}
