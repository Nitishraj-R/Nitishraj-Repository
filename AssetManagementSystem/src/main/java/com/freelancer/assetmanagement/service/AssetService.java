package com.freelancer.assetmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freelancer.assetmanagement.dto.AssetDto;
<<<<<<< HEAD
import com.freelancer.assetmanagement.dto.AssetWithFixedAssetDto;
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

@Service
public interface AssetService {

	public AssetDto saveAsset(AssetDto assetDto);

	public AssetDto updateAsset(AssetDto assetDto);

	public List<AssetDto> fetchAllAssets();

<<<<<<< HEAD
	public AssetDto findAssetByAssetId(Long assetId);

	public String deleteAssetByAssetId(Long assetId);
=======
	public AssetDto findAssetByAssetId(long assetId);

	public String deleteAssetByAssetId(long assetId);
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

	public String deleteAssetByEmployeeId(String employeeId);

	public List<AssetDto> fetchTotalAssets();
<<<<<<< HEAD

	public List<AssetDto> findAssetByEmployeeId(String employeeId);

	public AssetWithFixedAssetDto saveAssetWithFixedAsset(AssetWithFixedAssetDto assetWithFixedAssetDto);
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
}
