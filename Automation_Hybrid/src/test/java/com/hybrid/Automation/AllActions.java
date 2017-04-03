package com.hybrid.Automation;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import com.hybrid.Constants.Keywords;
import com.hybrid.Helpers.SetupHelper;

public class AllActions {

	@SuppressWarnings("unused")
	private static String getExecutionEnv() {
		try {
			return SetupHelper.getRunEnvironemnt();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static boolean keywordResult(ArrayList<String> argList, Class<?> className, String methodName) {
		int argListSize=0;
		if(argList !=null)
			argListSize = argList.size();
		boolean keywordResult = false;
		Class<?>[] paramType;
		Object[] methodArguments;
		int methodParameters=0;
		Class<?>[] argTypes = null;
		Constructor<?> constructor = null;
		try {
			constructor = className.getDeclaredConstructor(argTypes);
		} catch (NoSuchMethodException e1) {			
			e1.printStackTrace();		
		}
		
		Method[] methods = className.getDeclaredMethods();
		for (Method meth : methods) {
			if (meth.getName().equalsIgnoreCase(methodName)) {
				methodParameters = meth.getParameters().length;
				methodArguments = new Object[methodParameters + 1];
				paramType = new Class<?>[methodParameters];
				if (argListSize != methodParameters) {					
					System.out.println("Fail");
				}		
				try {
					for (int i = 0; i < meth.getParameterTypes().length; i++) {
						paramType[i] = meth.getParameterTypes()[i];
					}
					methodArguments[0] = constructor.newInstance();
					if (methodParameters != 0) {
						for (int i = 1; i <= argListSize; i++) {
							methodArguments[i] = argList.get(i - 1);
						}
					}
					MethodHandles.Lookup lookup = MethodHandles.publicLookup();
					MethodType methodType = MethodType.methodType(boolean.class, paramType);
					MethodHandle handle = lookup.findVirtual(className, meth.getName(), methodType);
					keywordResult = (boolean) handle.invokeWithArguments(methodArguments);							
					break;
				} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
				}
			}
					
		if(keywordResult)

	{
		return true;
	}else
	{
		return false;
	}
	}

	public boolean executeKeywords(NodeList keyWords) {

		String strKeyword = "";
		boolean keywordResults = false;
		ArrayList<String> argList = null;
		Keywords kw;
		int keywordCount=1;
		try{
			for (int i = 0; i < keyWords.getLength(); i++) {
				Node singleKeyword = keyWords.item(i);
				if (singleKeyword.getNodeType() == Node.ELEMENT_NODE) {
					argList = getInitialInformationFromXml(keywordCount,singleKeyword);
					strKeyword =singleKeyword.getAttributes().getNamedItem("label").getNodeValue().toUpperCase();
					kw = Keywords.getKeyword(strKeyword);					
						keywordResults = keywordResult(argList,kw.getClassName(),kw.name());
						System.out.println(argList);
						System.out.println(kw.getClassName());
						System.out.println(kw.name());
						//break;
						
						
					}
				keywordCount++;
				}
			
		}catch(Exception e){
			e.getMessage();
		}
		return keywordResults;
	}

	public static ArrayList<String> getInitialInformationFromXml(int keywordCount,Node singleKeyword){
		ArrayList<String> argumentList = new ArrayList<>();
		ArrayList<String> returnList = null;
		NodeList nodeArgs;
		@SuppressWarnings("unused")
		String currKeyWord = singleKeyword.getAttributes().getNamedItem("label").getNodeValue();
		//AssertionAndTestStep.setValue(HashMapConstants.AssertionAndTestStepConstant.KEYWORD,
	//singleKeyword.getAttributes().getNamedItem("label").getNodeValue();
		System.out.println(singleKeyword);
		nodeArgs = singleKeyword.getChildNodes();
		if(nodeArgs.getLength() !=0){
			NodeList arguments = nodeArgs.item(1).getChildNodes();
			for(int i=0;i<arguments.getLength();i++){
				Node node = arguments.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE){
					argumentList.add(node.getAttributes().getNamedItem("value").getNodeValue());
					//System.out.println(argumentList);
				}
			}			
		}
		if(!argumentList.isEmpty())
			System.out.println(returnList);
		//System.out.println(argumentList);
		
		
		return argumentList;
		
		
		
	}

}
