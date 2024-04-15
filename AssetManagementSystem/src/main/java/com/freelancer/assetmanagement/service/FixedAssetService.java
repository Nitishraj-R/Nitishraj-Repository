package com.freelancer.assetmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freelancer.assetmanagement.dto.FixedAssetDto;

@Service
public interface FixedAssetService {

	public FixedAssetDto saveFixedAsset(FixedAssetDto fixedAssetDto);

	public FixedAssetDto updateFixedAsset(FixedAssetDto fixedAssetDto);

	public List<FixedAssetDto> fetchAllFixedAssets();

	public FixedAssetDto findFixedAssetById(long id);

	public String deleteFixedAssetById(long id);

	public String deleteFixedAssetByAssetId(long assetId);
<<<<<<< HEAD
	
	public double totalFixedAssetCost();
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

	
}
