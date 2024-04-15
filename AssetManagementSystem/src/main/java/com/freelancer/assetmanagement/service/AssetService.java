package com.freelancer.assetmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freelancer.assetmanagement.dto.AssetDto;

@Service
public interface AssetService {

	public AssetDto saveAsset(AssetDto assetDto);

	public AssetDto updateAsset(AssetDto assetDto);

	public List<AssetDto> fetchAllAssets();

	public AssetDto findAssetByAssetId(long assetId);

	public String deleteAssetByAssetId(long assetId);

	public String deleteAssetByEmployeeId(String employeeId);

	public List<AssetDto> fetchTotalAssets();
}
