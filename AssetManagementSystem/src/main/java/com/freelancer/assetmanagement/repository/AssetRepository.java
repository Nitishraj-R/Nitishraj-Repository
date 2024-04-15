package com.freelancer.assetmanagement.repository;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freelancer.assetmanagement.model.Asset;
import com.freelancer.assetmanagement.model.Employee;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long>{

<<<<<<< HEAD
	public Asset findByAssetIdAndActive(Long assetId, boolean active);

	public List<Asset> findByActive(boolean active);

	public Optional<List<Asset>> findByEmployeeAndActive(Employee employee, boolean active);

	
=======
	public Asset findByAssetIdAndActive(long assetId, boolean active);

	public List<Asset> findByActive(boolean active);

	public Asset findByEmployeeAndActive(Employee employee, boolean active);

>>>>>>> f6f467bffe96089cff76a6636b098297faa97f90
}
