package com.griglie.evaluatePerformanceApp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.griglie.evaluatePerformanceApp.api.models.Device;
import com.griglie.evaluatePerformanceApp.api.models.TopTenDeviceResponse;
import com.griglie.evaluatePerformanceApp.persistence.projections.DeviceProjection;

@Component
public class DeviceMapper {
	
	public TopTenDeviceResponse toTopTenDeviceResponse (List<DeviceProjection> deviceProjectionList) {
		TopTenDeviceResponse res = null;
		
		if(deviceProjectionList !=null) {
			List<Device> deviceModelList= new ArrayList<Device>();
			
			for (DeviceProjection deviceProjection : deviceProjectionList) {
				deviceModelList.add(toDeviceModel(deviceProjection));
			}	
			res= new TopTenDeviceResponse(deviceModelList);
		}
		return res;
	}
	
	public Device toDeviceModel (DeviceProjection deviceProjection) {
		Device res=null;
		if(deviceProjection != null) {
			res=new Device();
			res.setDeviceDescription(deviceProjection.getDeviceDescription());
			res.setDeviceOperatingSystem(deviceProjection.getDeviceOperatingSystem());
			res.setDevicePosition(deviceProjection.getDevicePosition());
			res.setIdPerformanceType(deviceProjection.getIdPerformanceType());
			res.setIdPriceRange(deviceProjection.getIdPriceRange());
			res.setResultValue(deviceProjection.getResultValue());
		}
		return res;
	}

}
