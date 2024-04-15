package com.freelancer.assetmanagement.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freelancer.assetmanagement.dto.AssetCount;
import com.freelancer.assetmanagement.dto.AssetDto;
import com.freelancer.assetmanagement.service.AssetService;
import com.freelancer.assetmanagement.util.ResponseStructure;


@RestController
@RequestMapping("/asset")
@CrossOrigin(origins ="http://localhost:4200/",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = {"Content-type","Authentication"},allowCredentials = "true")

//@Tag(
//        name = "",
//        description = ""
//)

public class AssetController {
	
	Logger log=LoggerFactory.getLogger(AssetController.class);
	@Autowired
	private AssetService assetService;
	
	@PostMapping("/saveAsset")
	public ResponseEntity<ResponseStructure<AssetDto>> saveAsset(@RequestBody AssetDto assetDto) {
		log.info("AssetDto->"+assetDto);
		ResponseStructure<AssetDto> response = new ResponseStructure<>();

		
		AssetDto savedAsset = assetService.saveAsset(assetDto);

		log.info("Logging-> "+savedAsset);
		if (Objects.nonNull(savedAsset)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Asset saved successfully");
			response.setData(savedAsset);
			ResponseEntity<ResponseStructure<AssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Asset not saved");
			response.setData(null);
			ResponseEntity<ResponseStructure<AssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
	}
	
	@PutMapping("/updateAsset")
	public ResponseEntity<ResponseStructure<AssetDto>> updateAsset(@RequestBody AssetDto assetDto) {
		log.info("AssetDto->"+assetDto);
		ResponseStructure<AssetDto> response = new ResponseStructure<>();

		
		AssetDto updateAsset = assetService.updateAsset(assetDto);

		log.info("Logging-> "+updateAsset);
		if (Objects.nonNull(updateAsset)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Asset update successfully");
			response.setData(updateAsset);
			ResponseEntity<ResponseStructure<AssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Asset not updated");
			response.setData(null);
			ResponseEntity<ResponseStructure<AssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
		
		
	}
	
	@GetMapping("/getAllAssets")
	public ResponseEntity<ResponseStructure<List<AssetDto>>> getAllAssets(){
		ResponseStructure<List<AssetDto>> response = new ResponseStructure<>();
		List<AssetDto> fetchedAssets = assetService.fetchAllAssets();

		log.info("Logging fetchedAssets-> "+fetchedAssets);
		if (Objects.nonNull(fetchedAssets)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("All Assets fetched successfully");
			response.setData(fetchedAssets);
			ResponseEntity<ResponseStructure<List<AssetDto>>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("Assets not fetched");
			response.setData(null);
			ResponseEntity<ResponseStructure<List<AssetDto>>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	
	@GetMapping("/getAssetById")
	public ResponseEntity<ResponseStructure<AssetDto>> getAssetById(@RequestParam long assetId) {
		ResponseStructure<AssetDto> response = new ResponseStructure<>();
		AssetDto fetchedAsset = assetService.findAssetByAssetId(assetId);

		log.info("Logging fetchedAsset-> "+fetchedAsset);
		if (Objects.nonNull(fetchedAsset)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Asset fetched successfully");
			response.setData(fetchedAsset);
			ResponseEntity<ResponseStructure<AssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("Asset not fetched");
			response.setData(null);
			ResponseEntity<ResponseStructure<AssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	
	@DeleteMapping("/deleteAsset")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeByAssetId(@RequestParam long assetId) {
		ResponseStructure<String> response = new ResponseStructure<>();
		String deleteMessage = assetService.deleteAssetByAssetId(assetId);

		log.info("Logging delete Message-> "+deleteMessage);
		if (Objects.nonNull(deleteMessage)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("AssetDto deleted successfully");
			response.setData(deleteMessage);
			ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("AssetDto not deleted");
			response.setData(deleteMessage);
			ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	
	@DeleteMapping("/deleteAssetByEmployeeId")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeByEmployeeId(@RequestParam String employeeId) {
		ResponseStructure<String> response = new ResponseStructure<>();
		String deleteMessage = assetService.deleteAssetByEmployeeId(employeeId);

		log.info("Logging delete Message-> "+deleteMessage);
		if (Objects.nonNull(deleteMessage)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("AssetDto deleted successfully");
			response.setData(deleteMessage);
			ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("AssetDto not deleted");
			response.setData(deleteMessage);
			ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	
	@GetMapping("/getCount")
	public AssetCount getCount() {
		List<AssetDto> fetchedAssets = assetService.fetchAllAssets();
		List<AssetDto> fetchTotalAssets=assetService.fetchTotalAssets();
		AssetCount count=new AssetCount();
		count.setActiveCount(fetchedAssets.size());
		count.setTotalCount(fetchTotalAssets.size());
		count.setInactiveCount(fetchTotalAssets.size()-fetchedAssets.size());
		return count;
	}

}
