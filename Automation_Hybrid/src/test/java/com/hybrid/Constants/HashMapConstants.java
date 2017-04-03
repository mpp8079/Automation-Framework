package com.hybrid.Constants;

public class HashMapConstants {
	public class RunEnvironment{
		public static final String RUN_ENVIRONMENT_PROP_SHEET = "runEnvironmentPropSheet";
  		public static final String TEST_CASES_TO_RUN_EXCEL_SHEET = "testCasesToRunExcelSheet";
  		public static final String USER_NAME_AND_PASSWORD_EXCEL_SHEET = "userNameAndPasswordExcelSheet";
	}
	
	public class MasterConstant {
		//Framework Keys
		public static final String TESTNAME = "testCaseName";
		public static final String BROWSER = "testbrowser";
		public static final String BROWSER_VERSION = "browserversion";
		public static final String OPERATING_SYSTEM = "os";
		public static final String USER_ID = "UserId";
  		public static final String TEST_EXECUTION_START_TIME = "testExecutionStartTime";
  		public static final String TEST_CRASHED = "testCrashed";
  		public static final String START_ROW = "startRow";
  		public static final String END_ROW = "endRow";
  		public static final String SESSION_ID = "sessionId";
  		public static final String SAUCE_TUNNEL = "SauceTunnel";
  		public static final String APP_SERVER_URL = "appServerUrl";
  		
  		//Global Keys
  		public static final String GBL_LAST_PAGE = "gblLastPage";
  		public static final String GBL_CURRENT_PAGE = "gblCurrentPage";
  		public static final String GBL_STR_ENDECA_ATTRIBUTE_VALUE = "gblstrEndecaAttributeValue";
  		public static final String GBL_WEB_ORDER_NUMBER = "gblWEBOrderNumber";
  		public static final String GBL_RANDOM_USER_FOR_REGISTRATION = "gblRandomUserForRegistration";
  		public static final String GBL_SERVICE_STATUS  = "gblServiceStatus";
  		public static final String GBL_SERVICE_RESPONSE_TEXT  = "gblServiceResponseText";
		public static final String GBL_STR_APP_NAME = "gblStrAppName";
  		public static final String GBL_STR_PARAMETER_1 = "gblStrParameter1";
  		public static final String GBL_STR_PARAMETER_2 = "gblStrParameter2";
  		public static final String GBL_STR_PARAMETER_3 = "gblStrParameter3";
  		public static final String GBL_STR_PARAMETER_4 = "gblStrParameter4";
  		public static final String GBL_STR_REMEMBER_ME = "gblStrRememberMe";
  		public static final String GBL_NEGATIVE_TEST = "gblNegativeTest";
  		
  		//Cart
  		public static final String SHIP_METHOD_PRICE = "ShippingMethodPrice";
  		public static final String DESIGNATED_CARRIER = "DesignatedCarrier";
  		public static final String ESTIMATED_STANDARD_SHIPPING = "EstimatedStandardShipping";
  		public static final String ESTIMATED_TAX = "EstimatedTax";
  		public static final String ESTIMATED_SHIPPING = "EstimatedShipping";
  		public static final String JSESSION_ID = "JSESSIONID";
		public static final String FINAL_DESTINATION_COUNTRY = "finalDestinationCountry";
		public static final String SALESFORCE_CASE_INDEX = "SalesForceCaseIndex";
		
		//Quotes
		public static final String QUOTE_PRICE = "QuotePrice";
		public static final String QUOTE_NUMBER = "QuoteNumber";
		
		//Sales Force
		public static final String SALESFORCE_PARENT_CASE_NUMBER = "ParentCaseNumber";
		public static final String SALESFORCE_CASE_NUMBER = "CaseNumber";
		public static final String SALESFORCE_OPPORTUNITY_ACCOUNT_NUMBER = "AccountNumber";
		public static final String DRIVER_CODE = "driverCode";
		public static final String UNIQUE_VALUE = "uniqueValue";
		public static final String OPEN_MODAL = "openModal";
		public static final String ITEM_NUMBER = "itemNumber";
		public static final String SALESFORCE_USER_TYPE = "salesForceUserType";
		public static final String PO_RELEASE_NUMBER = "po-release";
		
		//BulkOrderPad
		public static final String BULK_ORDER_PAD_ROW = "bulkOrderPadRow";
		
		//Silo
		public static final String BUILD_NUMBER_SILO_1 = "BUILD_NUMBER_1";
		public static final String BUILD_NUMBER_SILO_2 = "BUILD_NUMBER_2";
		public static final String SILO_NAME_1 = "SILO_NAME_1";
		public static final String SILO_NAME_2 = "SILO_NAME_2";
	}

	public class AssertionAndTestStepConstant {
		public static final String TEST_STEP_NAME = "testStepName";
		public static final String ACTION_NAME = "actionName";
		public static final String KEYWORD = "keyWord";
		public static final String PARAMETER_VALUES = "parameterValues";
		public static final String RESULT = "Result";
		public static final String TEST_STEP_COUNTER = "testStepCounter";
		public static final String GBL_TEST_RESULT = "gblTestResult";
		public static final String GBL_PASS_STEP_COUNT = "gblPassStepsCount";
		public static final String GBL_FAIL_STEP_COUNT = "gblFailStepsCount";
		public static final String REPORT_OUT_COUNT = "reportOutCount";
		public static final String GBL_PASS_MESSAGE = "gblPassMessage";
		public static final String GBL_ERROR_MESSAGE = "gblErrorMessage";
		public static final String FINAL_REPORT = "FinalReport";
		public static final String BROWSER = "browser";
		public static final String TESTNAME = "testName";
	}

//	public enum AssertionAndTestStepConstant {
//		TEST_STEP_NAME,
//		ACTION_NAME,
//		KEYWORD,
//		PARAMETER_VALUES,
//		RESULT,
//		TEST_STEP_COUNTER,
//		GBL_TEST_RESULT,
//		BL_PASS_STEP_COUNT,
//		GBL_FAIL_STEP_COUNT,
//		REPORT_OUT_COUNT,
//		GBL_PASS_MESSAGE,
//		GBL_ERROR_MESSAGE,
//		FINAL_REPORT;
//	}
	
	public class SearchInformationConstant {

	}

	public class FinalOutputConstant {
		//Framework Keys
		public static final String TESTNAME = "tcName";
		public static final String URL = "url";
		public static final String START_DATE_AND_TIME = "startDateAndTime";
		public static final String BROWSER = "browser";
		public static final String BROWSER_VERSION = "browserversion";
		public static final String OPERATING_SYSTEM ="osVersion";
		public static final String SAUCE_VIDEO_LINK = "SauceVideoLink";
		public static final String SAUCE_VIDEO_LINK_RERUN = "SauceVideoLink-Rerun";
		public static final String RERUN_TEST = "rerunTest";
		public static final String TEST_RESULT = "TestResult";
		public static final String STEPS_PASSED = "stepsPassed";
		public static final String STEPS_FAILED = "stepsFailed";
		public static final String TOTAL_EXECUTION_TIME = "totalExecutionTime";
		public static final String ZDT_SILO = "ZdtSilo";
		public static final String ZDT_BUILD = "ZdtBuild";
		public static final String ZDT_CATALOG_VERSION = "ZdtCatalogVersion";
		public static final String ZDT_COOKIE = "ZdtCookie";
		public static final String ZDT_IS_STAGED = "ZdtIsStaged";
		public static final String TLTSID = "TLTSID";
		public static final String TLTSID_RERUN = "TLTSID-Rerun";
		public static final String NAVIGATE_TO_SILO ="navigatoToSilo";
		public static final String VERIFY_CURRENT_PAGE = "verifyCurrentPage";
		public static final String VALIDATE_COOKIE ="validateCookie";
		public static final String VALIDATE_POPUP = "validatePopup";
		public static final String VALIDATE_DOM_OBJECT = "validateDomObject";
		public static final String PS_COOKIE = "PS-Cookie";
		public static final String O_COOKIE = "O-Cookie";
		public static final String SAUCE_REST_FAILURE = "SauceRestFailure";
		public static final String JS_ERRORS = "jsErrors";
		public static final String JS_ERROR_INCREMENT_VALUE = "jsErrorIncrementValue";
		public static final String STEP_LEVEL_REPORT = "StepLevelReport";
		public static final String RETRY_COUNT = "retryCount";
		public static final String SILO_1_BUILD_NUMBER = "Silo1BuildNum";
		public static final String SILO_2_BUILD_NUMBER = "Silo2BuildNum";
	}
}