package com.swipejobs.match.engine.workermatch.matchengine.convertJsontoPojo;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsonToPojo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Path currentDir = Paths.get(".");
		//System.out.println(currentDir.toAbsolutePath());
		String packageName="com.swipejobs.matchengine.model.workerresponse";
		File inputJson= new File("C:\\SwipeJobsTechAssignment\\worker-match\\src\\main\\java\\com\\swipejobs\\match\\engine\\workermatch\\matchengine\\convertJsontoPojo"+File.separator+"WorkerResponse");
		File outputPojoDirectory=new File("."+File.separator+"convertedPojo");
		outputPojoDirectory.mkdirs();
		try {
			new JsonToPojo().convert2JSON(inputJson.toURI().toURL(), outputPojoDirectory, packageName, inputJson.getName().replace(".json", ""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Encountered issue while converting to pojo: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void convert2JSON(URL inputJson, File outputPojoDirectory, String packageName, String className) throws IOException{
		JCodeModel codeModel = new JCodeModel();

		URL source = inputJson;

		GenerationConfig config = new DefaultGenerationConfig() {
		@Override
		public boolean isGenerateBuilders() { // set config option by overriding method
		return true;
		}
		public SourceType getSourceType(){
            return SourceType.JSON;
        }
		};
		SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
		mapper.generate(codeModel, className, packageName, source);

		codeModel.build(outputPojoDirectory);
	}

}
