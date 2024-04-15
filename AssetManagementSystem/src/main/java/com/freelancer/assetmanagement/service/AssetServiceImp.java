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
import com.freelancer.assetmanagement.model.Asset;
import com.freelancer.assetmanagement.model.Employee;
import com.freelancer.assetmanagement.repository.AssetRepository;
import com.freelancer.assetmanagement.repository.EmployeeRepository;

@Service
@Transactional
public class AssetServiceImp implements AssetService {

	Logger log = LoggerFactory.getLogger(AssetServiceImp.class);

	private static final boolean active = true;

	@Autowired
	private AssetRepository assetRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public AssetDto saveAsset(AssetDto assetDto) {
		Asset asset = new Asset();
		assetDto.setActive(active);
		BeanUtils.copyProperties(assetDto, asset);
		Asset save = assetRepository.save(asset);
		assetDto.setAssetId(asset.getAssetId());
		assetDto.setCreatedAt(asset.getCreatedAt());
		assetDto.setCreatedBy(asset.getCreatedBy());
		assetDto.setModifiedAt(asset.getModifiedAt());
		assetDto.setModifiedBy(asset.getModifiedBy());
		return assetDto;
	}

	@Override
	public AssetDto updateAsset(AssetDto assetDto) {
		Asset findByAssetId = assetRepository.findByAssetIdAndActive(assetDto.getAssetId(), active);
		if (findByAssetId != null) {
			assetDto.setAssetId(findByAssetId.getAssetId());
			assetDto.setCreatedAt(findByAssetId.getCreatedAt());
			assetDto.setCreatedBy(findByAssetId.getCreatedBy());
			BeanUtils.copyProperties(assetDto, findByAssetId);

			Asset updatedAsset = assetRepository.save(findByAssetId);

			assetDto.setModifiedAt(updatedAsset.getModifiedAt());
			assetDto.setModifiedBy(updatedAsset.getModifiedBy());
			return assetDto;
		} else {
			log.info("Asset not found so update is not possible");
			return null;
		}
	}

	@Override
	public List<AssetDto> fetchAllAssets() {
		List<AssetDto> assetDtos = new ArrayList<AssetDto>();

//		List<Employee> employees = assetRepository.findAll();
		List<Asset> assets = assetRepository.findByActive(active);
		for (Asset asset : assets) {
			AssetDto assetDto = new AssetDto();
			BeanUtils.copyProperties(asset, assetDto);
			assetDtos.add(assetDto);

		}
		return assetDtos;
	}

	@Override
	public AssetDto findAssetByAssetId(long assetId) {
		AssetDto assetDto = new AssetDto();
		Asset asset = assetRepository.findByAssetIdAndActive(assetId, active);
		BeanUtils.copyProperties(asset, assetDto);
		return assetDto;
	}

	@Override
	public String deleteAssetByAssetId(long assetId) {
		Asset findByAssetId = assetRepository.findByAssetIdAndActive(assetId, active);
		if (findByAssetId != null) {
//			employeeRepository.delete(findByEmployeeId);
			findByAssetId.setActive(!active);
			assetRepository.save(findByAssetId);
			return "deleted Successfully";
		} else {
			log.info("Asset not found so delete is not possible");
			return "Asset not found to delete";
		}
	}

	@Override
	public String deleteAssetByEmployeeId(String employeeId) {
		Employee findByEmployeeIdAndActive = employeeRepository.findByEmployeeIdAndActive(employeeId, active);
		Asset findByEmployeeId = assetRepository.findByEmployeeAndActive(findByEmployeeIdAndActive, active);
		if (findByEmployeeId != null) {
//			employeeRepository.delete(findByEmployeeId);
			findByEmployeeId.setActive(!active);
			assetRepository.save(findByEmployeeId);
			return "deleted Successfully";
		} else {
			log.info("Asset not found so delete is not possible");
			return "Asset not found to delete";
		}
	}

	@Override
	public List<AssetDto> fetchTotalAssets() {
		List<Asset> findAll = assetRepository.findAll();
		List<AssetDto> assets = new ArrayList<>();
		if (Objects.nonNull(findAll)) {
			for (Asset asset : findAll) {
				AssetDto assetDto = new AssetDto();
				BeanUtils.copyProperties(asset, assetDto);
				assets.add(assetDto);
			}
			log.info("Total Asset fetched");
			return assets;
		}
		
		else {
			log.info("Total Asset not present");
			return null;
		}
	}

}
