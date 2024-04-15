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
<<<<<<< HEAD
import com.freelancer.assetmanagement.dto.AssetWithFixedAssetDto;
import com.freelancer.assetmanagement.service.AssetService;
import com.freelancer.assetmanagement.service.FixedAssetService;
import com.freelancer.assetmanagement.service.ITAssetService;
=======
import com.freelancer.assetmanagement.service.AssetService;
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
import com.freelancer.assetmanagement.util.ResponseStructure;


@RestController
@RequestMapping("/asset")
<<<<<<< HEAD
@CrossOrigin(origins ="http://localhost:4200/",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = {"Content-type","Authorization"},allowCredentials = "true")
=======
@CrossOrigin(origins ="http://localhost:4200/",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = {"Content-type","Authentication"},allowCredentials = "true")
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

//@Tag(
//        name = "",
//        description = ""
//)
<<<<<<< HEAD
=======

>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
public class AssetController {
	
	Logger log=LoggerFactory.getLogger(AssetController.class);
	@Autowired
	private AssetService assetService;
	
<<<<<<< HEAD
	@Autowired
	private FixedAssetService fixedAssetService;
	
	@Autowired
	private ITAssetService iTAssetService;
	
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
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
	
<<<<<<< HEAD
	@PostMapping("/saveAssetWithFixed")
	public ResponseEntity<ResponseStructure<AssetWithFixedAssetDto>> saveAssetAndFixedAsset(@RequestBody AssetWithFixedAssetDto assetWithFixedAssetDto) {
		log.info("AssetWithFixedAssetDto->"+assetWithFixedAssetDto);
		ResponseStructure<AssetWithFixedAssetDto> response = new ResponseStructure<>();

		
		AssetWithFixedAssetDto savedAsset = assetService.saveAssetWithFixedAsset(assetWithFixedAssetDto);

		log.info("Logging-> "+savedAsset);
		if (Objects.nonNull(savedAsset)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Asset with FixedAsset saved successfully");
			response.setData(savedAsset);
			ResponseEntity<ResponseStructure<AssetWithFixedAssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Asset with FixedAsset not saved");
			response.setData(null);
			ResponseEntity<ResponseStructure<AssetWithFixedAssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
	}
	
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
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
<<<<<<< HEAD
	public ResponseEntity<ResponseStructure<AssetDto>> getAssetById(@RequestParam Long assetId) {
=======
	public ResponseEntity<ResponseStructure<AssetDto>> getAssetById(@RequestParam long assetId) {
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
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
<<<<<<< HEAD
		log.info("Inside getCount method in AssetController Class");
		List<AssetDto> fetchedAssets = assetService.fetchAllAssets();
		log.info("fetchedAssets->"+fetchedAssets);
		List<AssetDto> fetchTotalAssets=assetService.fetchTotalAssets();
		log.info("fetchTotalAssets->"+fetchTotalAssets);
		AssetCount count=new AssetCount();
		count.setActiveCount(fetchedAssets.size());
		log.info("count.getActiveCount->"+count.getActiveCount());
		count.setTotalCount(fetchTotalAssets.size());
		log.info("count.getTotalCount()->"+count.getTotalCount());
		count.setInactiveCount(fetchTotalAssets.size()-fetchedAssets.size());
		log.info("count.getInactiveCount()->"+count.getInactiveCount());
		count.setFixedAssetCost(fixedAssetService.totalFixedAssetCost());
		log.info("count.getFixedAssetCost()->"+count.getFixedAssetCost());
		count.setITAssetCost(iTAssetService.totalITAssetCost());
		log.info("count.getITAssetCost()->"+count.getITAssetCost());
		return count;
	}
	
	@GetMapping("/getAssetByEmployeeId")
	public ResponseEntity<ResponseStructure<List<AssetDto>>> getAssetByEmployeeId(@RequestParam String employeeId) {
		ResponseStructure<List<AssetDto>> response = new ResponseStructure<>();
		List<AssetDto> fetchedAsset = assetService.findAssetByEmployeeId(employeeId);

		log.info("Logging fetchedAsset-> "+fetchedAsset);
		if (Objects.nonNull(fetchedAsset)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Asset fetched successfully");
			response.setData(fetchedAsset);
			ResponseEntity<ResponseStructure<List<AssetDto>>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("Asset not fetched");
			response.setData(null);
			ResponseEntity<ResponseStructure<List<AssetDto>>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
=======
		List<AssetDto> fetchedAssets = assetService.fetchAllAssets();
		List<AssetDto> fetchTotalAssets=assetService.fetchTotalAssets();
		AssetCount count=new AssetCount();
		count.setActiveCount(fetchedAssets.size());
		count.setTotalCount(fetchTotalAssets.size());
		count.setInactiveCount(fetchTotalAssets.size()-fetchedAssets.size());
		return count;
	}
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

}
