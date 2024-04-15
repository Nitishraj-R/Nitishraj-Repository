package com.freelancer.assetmanagement.service;

import java.util.List;
<<<<<<< HEAD
import java.util.Objects;
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

import org.springframework.stereotype.Service;

import com.freelancer.assetmanagement.dto.ITAssetDto;
<<<<<<< HEAD
import com.freelancer.assetmanagement.model.FixedAsset;
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

@Service
public interface ITAssetService {

	public ITAssetDto saveITAsset(ITAssetDto iTAssetDto);

	public ITAssetDto updateITAsset(ITAssetDto iTAssetDto);

	public List<ITAssetDto> fetchAllITAssets();

	public ITAssetDto findITAssetById(long id);

	public String deleteITAssetById(long id);

	public String deleteITAssetByAssetId(long assetId);
<<<<<<< HEAD
	
	public double totalITAssetCost();
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

}
