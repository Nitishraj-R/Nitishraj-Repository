package com.freelancer.assetmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freelancer.assetmanagement.dto.FixedAssetDto;
import com.freelancer.assetmanagement.dto.ITAssetDto;
import com.freelancer.assetmanagement.model.Asset;
import com.freelancer.assetmanagement.model.FixedAsset;
import com.freelancer.assetmanagement.model.ITAsset;
import com.freelancer.assetmanagement.repository.AssetRepository;
import com.freelancer.assetmanagement.repository.ITAssetRepository;

@Service
@Transactional
public class ITAssetServiceImp implements ITAssetService{

	private static final boolean active=true;

	Logger log=LoggerFactory.getLogger(ITAssetServiceImp.class);
	@Autowired
	private ITAssetRepository iTAssetRepository;
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Override
	public ITAssetDto saveITAsset(ITAssetDto iTAssetDto) {
		ITAsset iTAsset = new ITAsset();
		iTAssetDto.setActive(active);
		BeanUtils.copyProperties(iTAssetDto, iTAsset);
		ITAsset save = iTAssetRepository.save(iTAsset);
		
		iTAssetDto.setId(save.getId());
		iTAssetDto.setCreatedAt(save.getCreatedAt());
		iTAssetDto.setCreatedBy(save.getCreatedBy());
		iTAssetDto.setModifiedAt(save.getModifiedAt());
		iTAssetDto.setModifiedBy(save.getModifiedBy());
		return iTAssetDto;
	}

	@Override
	public ITAssetDto updateITAsset(ITAssetDto iTAssetDto) {
		ITAsset findByAssetId = iTAssetRepository.findByIdAndActive(iTAssetDto.getId(), active);
		if (findByAssetId != null) {
			iTAssetDto.setId(findByAssetId.getId());
			iTAssetDto.setCreatedAt(findByAssetId.getCreatedAt());
			iTAssetDto.setCreatedBy(findByAssetId.getCreatedBy());
			BeanUtils.copyProperties(iTAssetDto, findByAssetId);

			ITAsset updatedAsset = iTAssetRepository.save(findByAssetId);

			iTAssetDto.setModifiedAt(updatedAsset.getModifiedAt());
			iTAssetDto.setModifiedBy(updatedAsset.getModifiedBy());
			return iTAssetDto;
		} else {
			log.info("IT Asset not found so update is not possible");
			return null;
		}
	}

	@Override
	public List<ITAssetDto> fetchAllITAssets() {
		List<ITAssetDto> assetDtos = new ArrayList<ITAssetDto>();

//		List<Employee> employees = assetRepository.findAll();
		List<ITAsset> assets = iTAssetRepository.findByActive(active);
		for (ITAsset asset : assets) {
			ITAssetDto assetDto = new ITAssetDto();
			BeanUtils.copyProperties(asset, assetDto);
			assetDtos.add(assetDto);

		}
		return assetDtos;
	}

	@Override
	public ITAssetDto findITAssetById(long id) {
		ITAssetDto assetDto = new ITAssetDto();
		ITAsset iTAsset = iTAssetRepository.findByIdAndActive(id, active);
		BeanUtils.copyProperties(iTAsset, assetDto);
		return assetDto;
	}

	@Override
	public String deleteITAssetById(long id) {
		ITAsset findByAssetId = iTAssetRepository.findByIdAndActive(id, active);
		if (findByAssetId != null) {
//			employeeRepository.delete(findByEmployeeId);
			findByAssetId.setActive(!active);
			iTAssetRepository.save(findByAssetId);
			return "deleted Successfully";
		} else {
			log.info("IT Asset not found so delete is not possible");
			return "IT Asset not found to delete";
		}
	}

	@Override
	public String deleteITAssetByAssetId(long assetId) {
		Asset findByAssetIdAndActive = assetRepository.findByAssetIdAndActive(assetId, active);
		ITAsset findByAssetId = iTAssetRepository.findByAssetAndActive(findByAssetIdAndActive, active);
		log.info("logging->"+findByAssetId);
		if (findByAssetId != null) {
//			employeeRepository.delete(findByEmployeeId);
			findByAssetId.setActive(!active);
			iTAssetRepository.save(findByAssetId);
			return "deleted Successfully";
		} else {
			log.info("IT Asset not found so delete is not possible");
			return "IT Asset not found to delete";
		}
	}

}
