package com.security.guard.securitygaurdadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.security.guard.securitygaurdadmin.models.Branch;
import com.security.guard.securitygaurdadmin.models.Rank;
import com.security.guard.securitygaurdadmin.models.Region;
import com.security.guard.securitygaurdadmin.models.Shift;
import com.security.guard.securitygaurdadmin.repository.BranchRepository;
import com.security.guard.securitygaurdadmin.repository.RankRepository;
import com.security.guard.securitygaurdadmin.repository.RegionRepository;
import com.security.guard.securitygaurdadmin.repository.ShiftRepository;

@Service
public class SettingService {
	@Autowired
	BranchRepository branchRepository;
	@Autowired
	RankRepository rankRepository;
	
	@Autowired
	ShiftRepository shiftRepository;

	@Autowired
	RegionRepository regionRepository;

	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}
	
	public Shift saveShift(Shift shift) {
		return shiftRepository.save(shift);
	}
	
	
	public List<Shift> getShifts() {
		return shiftRepository.findAll();
	}
	
	

	public Branch updateBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public List<Branch> getBranches() {
		return branchRepository.findAll();
	}

	public Rank saveRank(Rank rank) {
		return rankRepository.save(rank);
	}

	public List<Rank> getRanks() {
		return rankRepository.findAll();
	}

	public Rank updateRank(Rank rank) {
		return rankRepository.save(rank);
	}

	public Region saveRegion(Region region) {
		return regionRepository.save(region);
	}

	public List<Region> getRegions() {
		return regionRepository.findAll();
	}

	public Region updateRegion(Region region) {
		return regionRepository.save(region);
	}

	public Optional<Branch> findBranch(String branch) {
		return branchRepository.findByBranch(branch);
	}
}
