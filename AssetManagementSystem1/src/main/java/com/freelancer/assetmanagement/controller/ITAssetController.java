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

import com.freelancer.assetmanagement.dto.FixedAssetDto;
import com.freelancer.assetmanagement.dto.ITAssetDto;
import com.freelancer.assetmanagement.service.ITAssetService;
import com.freelancer.assetmanagement.util.ResponseStructure;

@RestController
@RequestMapping("/ITAsset")
@CrossOrigin(origins ="http://localhost:4200/",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = {"Content-type","Authorization"},allowCredentials = "true")

//@Tag(
//        name = "",
//        description = ""
//)
public class ITAssetController {

	Logger log=LoggerFactory.getLogger(ITAssetController.class);
	@Autowired
	private ITAssetService iTAssetService;
	
	@PostMapping("/saveITAsset")
	public ResponseEntity<ResponseStructure<ITAssetDto>> saveITAsset(@RequestBody ITAssetDto iTAssetDto) {
		log.info("iTAssetDto->"+iTAssetDto);
		ResponseStructure<ITAssetDto> response = new ResponseStructure<>();

		
		ITAssetDto savedITAsset =iTAssetService.saveITAsset(iTAssetDto);

		log.info("Logging-> "+savedITAsset);
		if (Objects.nonNull(savedITAsset)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("IT Asset saved successfully");
			response.setData(savedITAsset);
			ResponseEntity<ResponseStructure<ITAssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage("IT Asset not saved");
			response.setData(null);
			ResponseEntity<ResponseStructure<ITAssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
	}
	
	@PutMapping("/updateITAsset")
	public ResponseEntity<ResponseStructure<ITAssetDto>> updateITAsset(@RequestBody ITAssetDto iTAssetDto) {
		log.info("FixedAssetDto->"+iTAssetDto);
		ResponseStructure<ITAssetDto> response = new ResponseStructure<>();

		
		ITAssetDto updateITAsset = iTAssetService.updateITAsset(iTAssetDto);

		log.info("Logging-> "+updateITAsset);
		if (Objects.nonNull(updateITAsset)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("IT Asset update successfully");
			response.setData(updateITAsset);
			ResponseEntity<ResponseStructure<ITAssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage("IT Asset not updated");
			response.setData(null);
			ResponseEntity<ResponseStructure<ITAssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
		
	}
	
	@GetMapping("/getAllITAssets")
	public ResponseEntity<ResponseStructure<List<ITAssetDto>>> getAllITAssets(){
		ResponseStructure<List<ITAssetDto>> response = new ResponseStructure<>();
		List<ITAssetDto> fetchedAssets = iTAssetService.fetchAllITAssets();

		log.info("Logging fetchedAssets-> "+fetchedAssets);
		if (Objects.nonNull(fetchedAssets)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("All IT Assets fetched successfully");
			response.setData(fetchedAssets);
			ResponseEntity<ResponseStructure<List<ITAssetDto>>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("IT Assets not fetched");
			response.setData(null);
			ResponseEntity<ResponseStructure<List<ITAssetDto>>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	
	@GetMapping("/getITAssetById")
	public ResponseEntity<ResponseStructure<ITAssetDto>> getFixedAssetById(@RequestParam long id) {
		ResponseStructure<ITAssetDto> response = new ResponseStructure<>();
		ITAssetDto fetchedAsset = iTAssetService.findITAssetById(id);

		log.info("Logging fetchedAsset-> "+fetchedAsset);
		if (Objects.nonNull(fetchedAsset)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("IT Asset fetched successfully");
			response.setData(fetchedAsset);
			ResponseEntity<ResponseStructure<ITAssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("IT Asset not fetched");
			response.setData(null);
			ResponseEntity<ResponseStructure<ITAssetDto>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	
	@DeleteMapping("/deleteITAsset")
	public ResponseEntity<ResponseStructure<String>> deleteAssetById(@RequestParam long id) {
		ResponseStructure<String> response = new ResponseStructure<>();
		String deleteMessage = iTAssetService.deleteITAssetById(id);

		log.info("Logging delete Message-> "+deleteMessage);
		if (Objects.nonNull(deleteMessage)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("IT Asset deleted successfully");
			response.setData(deleteMessage);
			ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("IT Asset not deleted");
			response.setData(deleteMessage);
			ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	
	@DeleteMapping("/deleteITAssetByAssetId")
	public ResponseEntity<ResponseStructure<String>> deleteITAssetByAssetId(@RequestParam long assetId) {
		ResponseStructure<String> response = new ResponseStructure<>();
		String deleteMessage = iTAssetService.deleteITAssetByAssetId(assetId);

		log.info("Logging delete Message-> "+deleteMessage);
		if (Objects.nonNull(deleteMessage)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("IT Asset deleted successfully");
			response.setData(deleteMessage);
			ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<>(response,HttpStatus.OK);
			return responseEntity;
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("IT Asset not deleted");
			response.setData(deleteMessage);
			ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
}
