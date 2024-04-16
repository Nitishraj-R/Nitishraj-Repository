package com.freelancer.assetmanagement.service;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freelancer.assetmanagement.dto.AssetDto;

import com.freelancer.assetmanagement.dto.AssetWithFixedAssetDto;
import com.freelancer.assetmanagement.dto.EmployeeData;
import com.freelancer.assetmanagement.dto.FixedAssetDto;
import com.freelancer.assetmanagement.model.Asset;
import com.freelancer.assetmanagement.model.Employee;
import com.freelancer.assetmanagement.model.FixedAsset;
import com.freelancer.assetmanagement.model.Organization;
import com.freelancer.assetmanagement.repository.AssetRepository;
import com.freelancer.assetmanagement.repository.EmployeeRepository;
import com.freelancer.assetmanagement.repository.FixedAssetRepository;

@Service
@Transactional
public class AssetServiceImp implements AssetService {

	Logger log = LoggerFactory.getLogger(AssetServiceImp.class);

	private static final boolean active = true;

	@Autowired
	private AssetRepository assetRepository;

	@Autowired
	private FixedAssetRepository fixedAssetRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public AssetDto saveAsset(AssetDto assetDto) {
		Asset asset = new Asset();
		assetDto.setActive(active);
		BeanUtils.copyProperties(assetDto, asset);

		if (Objects.nonNull(assetDto.getEmployeeData())) {
			asset.setEmployee(new Employee());
			BeanUtils.copyProperties(assetDto.getEmployeeData(), asset.getEmployee());
		}
		if (Objects.nonNull(assetDto.getOrganizationData())) {
			asset.setOrganization(new Organization());
			BeanUtils.copyProperties(assetDto.getOrganizationData(), asset.getOrganization());
		}
		Asset save = assetRepository.save(asset);
		assetDto.setAssetId(asset.getAssetId());
		assetDto.setCreatedAt(asset.getCreatedAt());
		assetDto.setCreatedBy(asset.getCreatedBy());
		assetDto.setModifiedAt(asset.getModifiedAt());
		assetDto.setModifiedBy(asset.getModifiedBy());
		return assetDto;
	}

	@Override

	public AssetWithFixedAssetDto saveAssetWithFixedAsset(AssetWithFixedAssetDto assetWithFixedAssetDto) {
		Asset asset = new Asset();
		AssetDto assetDto = assetWithFixedAssetDto.getAssetDto();
		assetDto.setActive(active);
		BeanUtils.copyProperties(assetDto, asset);
		Asset save = assetRepository.save(asset);

		FixedAsset fixedAsset = new FixedAsset();

		FixedAssetDto fixedAssetDto = assetWithFixedAssetDto.getFixedAssetDto();
		assetDto.setActive(active);
		BeanUtils.copyProperties(fixedAssetDto, fixedAsset);
		fixedAsset.setAsset(asset);
		FixedAsset save2 = fixedAssetRepository.save(fixedAsset);

		assetDto.setAssetId(asset.getAssetId());
		assetDto.setCreatedAt(asset.getCreatedAt());
		assetDto.setCreatedBy(asset.getCreatedBy());
		assetDto.setModifiedAt(asset.getModifiedAt());
		assetDto.setModifiedBy(asset.getModifiedBy());

		fixedAssetDto.setId(fixedAsset.getId());
		fixedAssetDto.setCreatedAt(fixedAsset.getCreatedAt());
		fixedAssetDto.setCreatedBy(fixedAsset.getCreatedBy());
		fixedAssetDto.setModifiedAt(fixedAsset.getModifiedAt());
		fixedAssetDto.setModifiedBy(fixedAsset.getModifiedBy());
		return assetWithFixedAssetDto;
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

		log.info("Inside fetchAllAssets");
		List<AssetDto> assetDtos = new ArrayList<AssetDto>();

//		List<Employee> employees = assetRepository.findAll();
		List<Asset> assets = assetRepository.findByActive(active);

		log.info("assets->" + assets);
		for (Asset asset : assets) {
			AssetDto assetDto = new AssetDto();

			BeanUtils.copyProperties(asset, assetDto);
			if (assetDto.getEmployeeData() == null) {
				assetDto.setEmployeeData(new EmployeeData());
			}
			if (Objects.nonNull(asset.getEmployee())) {
				BeanUtils.copyProperties(asset.getEmployee(), assetDto.getEmployeeData());
			}
			assetDtos.add(assetDto);
			log.info("assetDtos->" + assetDtos);

		}
		return assetDtos;
	}

	@Override

	public AssetDto findAssetByAssetId(Long assetId) {
		log.info("Inside findAssetByAssetId method AssetServiceImp");
		AssetDto assetDto = new AssetDto();
		Asset asset = assetRepository.findByAssetIdAndActive(assetId, active);
		log.info("Asset from AssetServiceImp->" + asset);
		if(Objects.nonNull(asset)) {
		Employee employee = new Employee();
		if (Objects.isNull(assetDto.getEmployeeData())) {
			assetDto.setEmployeeData(new EmployeeData());
		}

		BeanUtils.copyProperties(asset, assetDto);
		log.info("assetDto->" + assetDto);
		if (Objects.nonNull(asset.getEmployee())) {
			BeanUtils.copyProperties(asset.getEmployee(), assetDto.getEmployeeData());
		}
		log.info("assetDto->" + assetDto);
		return assetDto;
		}
		else {
			return null;
		}
	}

	@Override

	public String deleteAssetByAssetId(Long assetId) {
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

		Optional<List<Asset>> findByEmployeeId = assetRepository.findByEmployeeAndActive(findByEmployeeIdAndActive,
				active);
		if (findByEmployeeId.isPresent()) {
			for (Asset asset : findByEmployeeId.get()) {
//			employeeRepository.delete(findByEmployeeId);
				asset.setActive(!active);
				assetRepository.save(asset);
			}
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

	@Override
	public List<AssetDto> findAssetByEmployeeId(String employeeId) {

		Employee findByEmployeeIdAndActive = employeeRepository.findByEmployeeIdAndActive(employeeId, active);
		log.info("findByEmployeeIdAndActive->" + findByEmployeeIdAndActive);
		if (Objects.nonNull(findByEmployeeIdAndActive)) {
			Optional<List<Asset>> findByEmployeeId = assetRepository.findByEmployeeAndActive(findByEmployeeIdAndActive,
					active);

			if (findByEmployeeId.isPresent()) {
				log.info("Asset based on EmployeeId in AssetService class ->" + findByEmployeeId.get());
				List<AssetDto> assetDtos = new ArrayList<>();
				for (Asset asset : findByEmployeeId.get()) {
					AssetDto assetDto = new AssetDto();
					BeanUtils.copyProperties(asset, assetDto);
					assetDtos.add(assetDto);
				}
				return assetDtos;
			}
			throw new InputMismatchException();
		} else {
			throw new InputMismatchException();
		}
	}

}
