package com.cognizant.outreach.vfs.admin.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.outreach.vfs.admin.service.AdminTablesDataService;
import com.cognizant.outreach.vfs.admin.service.EmailBatchService;
import com.cognizant.outreach.vfs.admin.service.EventAndFeedBackDataService;
import com.cognizant.outreach.vfs.admin.service.InsightsDataService;
import com.cognizant.outreach.vfs.api.response.APIStatus;
import com.cognizant.outreach.vfs.api.response.StatusResponse;
import com.cognizant.outreach.vfs.domain.AdminUpdateData;
import com.cognizant.outreach.vfs.domain.ChartData;
import com.cognizant.outreach.vfs.domain.DataSets;
import com.cognizant.outreach.vfs.domain.InsightData;
import com.cognizant.outreach.vfs.service.AdminDataUpdateService;
import com.cognizant.outreach.vfs.util.APIUtil;
import com.cognizant.outreach.vfs.util.ReqMapConstants;

@RestController
@RequestMapping(ReqMapConstants.ADMIN)
@CrossOrigin(origins = "http://localhost:4200")
public class AdminAPI extends APIUtil {
	
	private static final Logger logger = LogManager.getLogger(AdminAPI.class.getName());
	
	@Autowired
	private AdminTablesDataService adminService;
	
	@Autowired
	private EventAndFeedBackDataService eventAndFeedBackDataService;
	
	@Autowired
	private AdminDataUpdateService adminDataUpdateService;
	
	@Autowired
	private InsightsDataService insightsDataService;
	
    @Autowired
	private EmailBatchService emailBatchService;
	

    @RequestMapping(value = ReqMapConstants.GET_ADMIN_DATA, 
    		method = RequestMethod.GET, produces = ReqMapConstants.CHARSET)
    public String getAdminData() {
    	//TODO add try catch
    	StatusResponse response = new StatusResponse();
    	response.setResult(adminService.getAllAdminTableData());
    	response.setStatus(APIStatus.OK);
    	return writeObjectToJson(response);
    }
    
    @RequestMapping(value = ReqMapConstants.GET_EVENTDETAILS_DATA, 
    		method = RequestMethod.GET, produces = ReqMapConstants.CHARSET)
    public String getEventDetailsAndFeedbackData() {
    	//TODO add try catch
    	StatusResponse response = new StatusResponse();
    	response.setResult(eventAndFeedBackDataService.getEventDetailsAndFeedbackDetails());
    	response.setStatus(APIStatus.OK);
    	return writeObjectToJson(response);
    }
    
    @RequestMapping(value = ReqMapConstants.UPDATE_ADMIN_DATA, 
    		method = RequestMethod.POST, produces = ReqMapConstants.CHARSET)
    public String updateAdminData(@RequestBody AdminUpdateData payload) {
    	//TODO add try catch
    	System.out.println(payload);
    	StatusResponse response = new StatusResponse();
    	List<Map<String, String>> data = new ArrayList<>();
    	try {
    		for (Object object: payload.getData()) {
    			System.out.println(object);
    			data.add((Map<String, String>) object);
    		}
    		adminDataUpdateService.updateAdminData(payload.getTable_name(), data, payload.getAction());
			response.setStatus(APIStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(APIStatus.BAD);
		}
    	return writeObjectToJson(response);
    }
    
    @RequestMapping(value = ReqMapConstants.GET_INSIGHT_DATA, 
    		method = RequestMethod.POST, produces = ReqMapConstants.CHARSET)
    public String getInsightData(@RequestBody InsightData payload) {
    	//TODO add try catch
    	System.out.println(payload);
    	StatusResponse response = new StatusResponse();
    	try {
//    		for (Object object: payload.getData()) {
//    			System.out.println(object);
//    			data.add((Map<String, String>) object);
//    		}
//    		adminDataUpdateService.updateAdminData(payload.getTable_name(), data, payload.getAction());
    		InsightData insightData = new InsightData();
//    		ChartData chartData = new ChartData();
//    		DataSets dataSets = new DataSets();
//    		chartData.setDatasets(new ArrayList<DataSets>());
    		response.setResult(insightsDataService.getInsightsData(payload.getFrom_date(), payload.getTo_date(), payload.getInsight_level()));
			response.setStatus(APIStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(APIStatus.BAD);
		}
    	return writeObjectToJson(response);
    }

    @RequestMapping(value = ReqMapConstants.GET_EVENT_SUMMARY_DATA, 
    		method = RequestMethod.GET, produces = ReqMapConstants.CHARSET)
    public String getEventIdList() {
    	//TODO add try catch
    	StatusResponse response = new StatusResponse();
    	response.setResult(adminService.getEventLookUpData());
    	response.setStatus(APIStatus.OK);
    	return writeObjectToJson(response);
    }
	
    @RequestMapping(value = ReqMapConstants.TRIGGER_EMAIL_BATCH, 
    		method = RequestMethod.GET, produces = ReqMapConstants.CHARSET)
    public String triggerEmailBatch(@PathVariable("eventId") String eventId, @PathVariable("isReminder") String isReminder) {
    	//TODO add try catch
    	StatusResponse response = new StatusResponse();
    	emailBatchService.triggerEmailBatch(eventId, isReminder);
    	response.setResult("Email Batch Triggered Successfully");
    	response.setStatus(APIStatus.OK);
    	return writeObjectToJson(response);
    }
}
