package org.equinox.api.bellatrix.interbank;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang.StringUtils;
import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

@XmlAccessorType(XmlAccessType.FIELD)
public class LoadScheduleTransferByUsernameResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419062L;

	@XmlElement(name="scheduleTransfers")
	private LinkedList<ScheduleTransfer> schedules = new LinkedList<ScheduleTransfer>();
	
	public LoadScheduleTransferByUsernameResponse() {
		super();
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		LoadScheduleTransferByUsernameResponse result = context.parseString(
				xmlString, "loadScheduleTransferByUsernameResponse", LoadScheduleTransferByUsernameResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
            this.schedules = result.getSchedules();
            
            if(schedules != null && !schedules.isEmpty()) {
            	for(ScheduleTransfer schedule : schedules) {
            		int endIdx = schedule.getScheduleDate().lastIndexOf(".");
            		if(endIdx == -1) continue;
            		schedule.setScheduleDate(schedule.getScheduleDate().substring(0, endIdx));
            	}
            }
            
        } else {
        	this.status = new BellatrixStatus();
        }
		
	}
	
	public int getScheduleTransferId(int transferTypeId, String accountNumber) {
		if(schedules != null && !schedules.isEmpty()) {
			if(!StringUtils.isBlank(accountNumber)) {
				for(ScheduleTransfer schedule : schedules) {
					if(schedule.getTransferTypeId() == transferTypeId) {
						if(schedule.getAccountNumber().equals(accountNumber)) {
							return schedule.getId();
						}
					}
				}
			}
		}
		
		return -1;
	}

	public LinkedList<ScheduleTransfer> getSchedules() {
		return schedules;
	}

	public void setSchedules(LinkedList<ScheduleTransfer> schedules) {
		this.schedules = schedules;
	}
}
