package com.security.guard.securitygaurdadmin.controller;

import java.time.LocalDate;
import java.util.List;

import javax.jms.IllegalStateRuntimeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.guard.securitygaurdadmin.models.Branch;
import com.security.guard.securitygaurdadmin.models.Rank;
import com.security.guard.securitygaurdadmin.models.Region;
import com.security.guard.securitygaurdadmin.models.Shift;
import com.security.guard.securitygaurdadmin.service.SettingService;

@RestController
@RequestMapping("/v1/api")
public class SettingController {

	@Autowired
	SettingService settingService;

	@PostMapping("/rank")
	public ResponseEntity<Rank> saveRank(@RequestBody Rank rank) {
		try {
			return new ResponseEntity<Rank>(settingService.saveRank(rank), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Rank>(HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/ranks")
	public ResponseEntity<List<Rank>> getRankData() {
		try {
			return new ResponseEntity<List<Rank>>(settingService.getRanks(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Rank>>(HttpStatus.BAD_REQUEST);

		}
	}

	@PostMapping("/branch")
	public ResponseEntity<Branch> saveRank(@RequestBody Branch branch) {
		branch.setDateAdded(LocalDate.now());
		try {
			if (settingService.findBranch(branch.getBranch()).isEmpty()) {
				return new ResponseEntity<Branch>(settingService.saveBranch(branch), HttpStatus.OK);
			} else {
				throw new IllegalStateRuntimeException("Branch already Exist");

			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Branch>(HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/branches")
	public ResponseEntity<List<Branch>> getBranches() {
		try {
			return new ResponseEntity<List<Branch>>(settingService.getBranches(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Branch>>(HttpStatus.BAD_REQUEST);

		}
	}

	@PostMapping("/region")
	public ResponseEntity<Region> saveRank(@RequestBody Region region) {
		try {
			return new ResponseEntity<Region>(settingService.saveRegion(region), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Region>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@PostMapping("/shift")
	public ResponseEntity<Shift> saveShift(@RequestBody Shift region) {
		try {
			return new ResponseEntity<Shift>(settingService.saveShift(region), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Shift>(HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/regions")
	public ResponseEntity<List<Region>> getRegion() {
		try {
			return new ResponseEntity<List<Region>>(settingService.getRegions(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Region>>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/shifts")
	public ResponseEntity<List<Shift>> getShifts() {
		try {
			return new ResponseEntity<List<Shift>>(settingService.getShifts(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<Shift>>(HttpStatus.BAD_REQUEST);

		}
	}
}