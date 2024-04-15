package com.freelancer.assetmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freelancer.assetmanagement.dto.AssetDto;
import com.freelancer.assetmanagement.dto.FixedAssetDto;
import com.freelancer.assetmanagement.model.Asset;
import com.freelancer.assetmanagement.model.FixedAsset;
import com.freelancer.assetmanagement.repository.AssetRepository;
import com.freelancer.assetmanagement.repository.FixedAssetRepository;

@Service
@Transactional
public class FixedAssetServiceImp implements FixedAssetService{
	private static final boolean active=true;

	Logger log=LoggerFactory.getLogger(FixedAssetServiceImp.class);
	@Autowired
	private FixedAssetRepository fixedAssetRepository;
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Override
	public FixedAssetDto saveFixedAsset(FixedAssetDto fixedAssetDto) {
		FixedAsset fixedAsset = new FixedAsset();
		fixedAsset.setActive(active);
		BeanUtils.copyProperties(fixedAssetDto, fixedAsset);
		FixedAsset save = fixedAssetRepository.save(fixedAsset);
		
		fixedAssetDto.setId(save.getId());
		fixedAssetDto.setCreatedAt(save.getCreatedAt());
		fixedAssetDto.setCreatedBy(save.getCreatedBy());
		fixedAssetDto.setModifiedAt(save.getModifiedAt());
		fixedAssetDto.setModifiedBy(save.getModifiedBy());
		return fixedAssetDto;
	}
	
	@Override
	public FixedAssetDto updateFixedAsset(FixedAssetDto fixedAssetDto) {
		FixedAsset findByAssetId = fixedAssetRepository.findByIdAndActive(fixedAssetDto.getId(), active);
		if (findByAssetId != null) {
			fixedAssetDto.setId(findByAssetId.getId());
			fixedAssetDto.setCreatedAt(findByAssetId.getCreatedAt());
			fixedAssetDto.setCreatedBy(findByAssetId.getCreatedBy());
			BeanUtils.copyProperties(fixedAssetDto, findByAssetId);

			FixedAsset updatedAsset = fixedAssetRepository.save(findByAssetId);

			fixedAssetDto.setModifiedAt(updatedAsset.getModifiedAt());
			fixedAssetDto.setModifiedBy(updatedAsset.getModifiedBy());
			return fixedAssetDto;
		} else {
			log.info("Fixed Asset not found so update is not possible");
			return null;
		}
	}
	@Override
	public List<FixedAssetDto> fetchAllFixedAssets() {
		List<FixedAssetDto> assetDtos = new ArrayList<FixedAssetDto>();

//		List<Employee> employees = assetRepository.findAll();
		List<FixedAsset> assets = fixedAssetRepository.findByActive(active);
		for (FixedAsset asset : assets) {
			FixedAssetDto assetDto = new FixedAssetDto();
			BeanUtils.copyProperties(asset, assetDto);
			assetDtos.add(assetDto);

		}
		return assetDtos;
	}
	@Override
	public FixedAssetDto findFixedAssetById(long id) {
		FixedAssetDto assetDto = new FixedAssetDto();
		FixedAsset fixedAsset = fixedAssetRepository.findByIdAndActive(id, active);
		BeanUtils.copyProperties(fixedAsset, assetDto);
		return assetDto;
	}
	@Override
	public String deleteFixedAssetById(long id) {
		FixedAsset findByAssetId = fixedAssetRepository.findByIdAndActive(id, active);
		if (findByAssetId != null) {
//			employeeRepository.delete(findByEmployeeId);
			findByAssetId.setActive(!active);
			fixedAssetRepository.save(findByAssetId);
			return "deleted Successfully";
		} else {
			log.info("Fixed Asset not found so delete is not possible");
			return "Fixed Asset not found to delete";
		}
	}
	@Override
	public String deleteFixedAssetByAssetId(long assetId) {
		Asset findByAssetIdAndActive = assetRepository.findByAssetIdAndActive(assetId, active);
		FixedAsset findByAssetId = fixedAssetRepository.findByAssetAndActive(findByAssetIdAndActive, active);
		if (findByAssetId != null) {
//			employeeRepository.delete(findByEmployeeId);
			findByAssetId.setActive(!active);
			fixedAssetRepository.save(findByAssetId);
			return "deleted Successfully";
		} else {
			log.info("Fixed Asset not found so delete is not possible");
			return "Fixed Asset not found to delete";
		}
	}

	@Override
	public double totalFixedAssetCost() {
		double cost=0;
		log.info("Inside Totalfixedcost method in FixedAssetImp class");
		List<FixedAsset> findByActive = fixedAssetRepository.findByActive(active);
		if(Objects.nonNull(findByActive)) {
			for(FixedAsset fixedAsset:findByActive) {
				cost+=fixedAsset.getAsset().getCost();
			}
			return cost;
		}
		return 0;
	}
	
	
	
}
